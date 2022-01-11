package buk.Services;

import buk.Entities.Matches;
import buk.Entities.Teams;
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.OddsRepository;
import buk.repositories.TeamsRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ScoresReader {
    @Autowired
    MainService mainService;
    @Autowired
    MatchesRepository matchesRep;
    @Autowired
    TeamsRepository tlRep;
    @Autowired
    DataService dataService;
    @Autowired
    OddsRepository oddsRepository;


    List<WebElement> matches;
    List<WebElement> dates;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyydd/MM HH:mm");
    WebDriver driver;
    Pattern pattern = Pattern.compile(" [0-9]{1,2}-[0-9]{1,2} ");
    Pattern pattern2 = Pattern.compile(" [0-9]{1}");
    Matcher matcher;
    String home, away, year, score, matchTab1[], matchTab2[], scoreTab[];
    int homeScore, awayScore, numberOfMatches, scoresTab[];
    Integer temp=null;
    Calendar cal=Calendar.getInstance();
    TreeMap<Integer, String> league;


    public void matchesReader(WebDriver driver) throws Exception {
        this.driver = driver;
        for (Map.Entry<String, TreeMap> link : dataService.scores().entrySet()) {
            matchesReaderStart(link.getKey(), link.getValue());
        }
    }

    public void matchesReaderStart(String url, TreeMap<Integer, String> league) {
        this.league = league;
        try {
            Thread.sleep(mainService.randomNumber2());
            driver.get(url);
            waitUntill();
            matches = driver.findElements(By.xpath("//div[@class=' content-1']//div[@class='title-container']"));
            dates= driver.findElements(By.xpath("//div[@class=' content-1']//div[@class='color-gray']"));
            numberOfMatches = matches.size();
            if (numberOfMatches > 15)
                numberOfMatches = 15;
            year=String.valueOf(cal.get(Calendar.YEAR));
            readMatches();

        } catch (Exception e) {
        }
    }

    public void readMatches() {
        for (int i = 0; i < numberOfMatches; i++) {
            try {
                matchTab1 = matches.get(i).getText().split("\\n");
                matchTab2 = pattern.split(matchTab1[0]);
                home = matchTab2[0].trim();
                away = matchTab2[1].trim();
                matcher=pattern2.matcher(home.substring(home.length()-2));
                if (matcher.matches())
                    home=home.substring(0,home.length()-2);
                matcher=pattern2.matcher(away.substring(away.length()-2));
                if (matcher.matches())
                    away=away.substring(0,away.length()-2);
                matcher = pattern.matcher(matchTab1[0]);
                matcher.find();
                score = matcher.group(0);
                score.trim();
                scoreTab = score.split("-");
                homeScore = Integer.valueOf(scoreTab[0].trim());
                awayScore = Integer.valueOf(scoreTab[1].trim());
                String dateStr = dates.get(i).getText();
                Date date = sdf.parse(year + dateStr);
                Matches m = new Matches();
                getTeamFromDataBase(home, away, m);
                Matches match = matchesRep.findFirstByHomeAndAwayAndDateTimeBetweenAndScoreHome(m.getHome(), m.getAway(), mainService.dateBetween1(date), mainService.dateBetween2(date), temp);
                if (match != null) {
                    match.setScoreHome(homeScore);
                    match.setScoreAway(awayScore);
                    matchesRep.save(match);
                }
            } catch (Exception e) {
            }
        }
    }

    public void getTeamFromDataBase(String home, String away, Matches match) {
        List<Teams> matchesList = new ArrayList<Teams>();
        for (int z = league.firstKey(); z < league.firstKey() + league.size(); z++) {
            if (home.equals(league.get(z))) {
                Teams tl = tlRep.findOne((long) z);
                match.setHome(tl.getTeam());
                matchesList.add(tl);
            }
            if (away.equals(league.get(z))) {
                Teams tl = tlRep.findOne((long) z);
                match.setAway(tl.getTeam());
                matchesList.add(tl);
            }
        }
    }


        public void waitUntill() {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 15);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title-container']")));
            }
            catch  (Exception e) {
                e.printStackTrace();
            }
        }

    }