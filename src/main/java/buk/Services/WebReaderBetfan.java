package buk.Services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buk.Entities.Matches;
import buk.Entities.Odds;
import buk.Entities.Teams;
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Service
public class WebReaderBetfan {

    @Autowired
    MainService mainService;
    @Autowired
    MatchesRepository matchesRep;
    @Autowired
    TeamsRepository tlRep;
    @Autowired
    OddsRepository oddsRep;
    @Autowired
    DataService dataService;

    String dayAndMonth, year, time;
    String bukName = "Betfan";
    List<Date> dateList = new ArrayList<>();
    TreeMap<Integer, String> league;
    Matches match[];
    double oddsTable[] = new double[3];
    Odds odds[];
    List<WebElement> allMatches;
    Date matchDate;
    Date oddsDate;
    int numberOfMatches;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
    Date dateTemp;
    WebDriver driver;

    public void matchesReader(WebDriver driver) throws Exception {

        this.driver = driver;

        for (Map.Entry<String, TreeMap> link : dataService.betFan().entrySet()) {
            matchesReaderStart(link.getKey(), link.getValue());
        }
    }

    public void matchesReaderStart(String url, TreeMap league) {
        this.league = league;
        try {
            Thread.sleep(mainService.randomNumber());
            dateTemp = new Date();
            driver.get(url);
            waitUntill();
            List<WebElement> allMatches = driver.findElements(By.xpath("//div[@class='game']"));
            numberOfMatches = allMatches.size();
            getDates();
            getMatches();
            getOdds();
            saveMatchAndOdds();
        } catch (Exception e) {
            System.err.println("xpath or url not found.......");
            mainService.errorReport(bukName, dateTemp, "xpath or url err");
        }
        league.clear();
        numberOfMatches = 0;
        dateList.clear();
    }

    public void waitUntill() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='game']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='time']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getOdds() {
        odds = new Odds[numberOfMatches];
        for (int i = 0; i < numberOfMatches; i++) {
            odds[i] = new Odds();
            oddsDate = new Date();
            oddsTable[0] = 0;
            oddsTable[1] = 0;
            oddsTable[2] = 0;
            try {
                oddsTable[0] = Double.parseDouble(driver.findElement(By.xpath("(((//li[contains(@class, 'single-event')])[" + (i + 1) + "]//div[@class='game'])//span[@class='outcome-odd'])[1]")).getText());
                oddsTable[1] = Double.parseDouble(driver.findElement(By.xpath("(((//li[contains(@class, 'single-event')])[" + (i + 1) + "]//div[@class='game'])//span[@class='outcome-odd'])[2]")).getText());
                oddsTable[2] = Double.parseDouble(driver.findElement(By.xpath("(((//li[contains(@class, 'single-event')])[" + (i + 1) + "]//div[@class='game'])//span[@class='outcome-odd'])[3]")).getText());
            } catch (Exception e) {
                System.err.println("get odds error");
                mainService.errorReport(bukName, dateTemp, "get odds error");
            }
            if (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) {
                odds[i].setHome(oddsTable[0]);
                odds[i].setDraw(oddsTable[1]);
                odds[i].setAway(oddsTable[2]);
                odds[i].setDateTime(oddsDate);
                odds[i].setBuk(bukName);
            } else
                odds[i] = null;
        }
    }

    public void saveMatchAndOdds() {
        for (int i = 0; i < numberOfMatches; i++) {
            Matches m = matchesRep.findFirstByHomeAndAwayAndDateTimeBetween(match[i].getHome(), match[i].getAway(), mainService.date1(match[i]), mainService.date2(match[i]));
            if (m != null && odds[i] != null) {
                odds[i].setMatch(m);
                oddsRep.save(odds[i]);
            } else {
                if (match[i].getDateTime() != null && match[i].getHome() != null && match[i].getAway() != null && odds[i] != null && mainService.compareDates(match[i])) {
                    match[i].setFirstAppeared(bukName);
                    matchesRep.save(match[i]);
                    odds[i].setMatch(match[i]);
                    oddsRep.save(odds[i]);
                }
            }
        }
    }

    public void getMatches() {
        match = new Matches[numberOfMatches];
        for (int i = 0; i < numberOfMatches; i++) {
            match[i] = new Matches();
            String[] homeAway = new String[2];
            try {
                homeAway[0] = driver.findElement(By.xpath("((//li[contains(@class, 'single-event')])[" + (i + 1) + "]//span[@class='outcome-name'])[1]")).getText();
                homeAway[1] = driver.findElement(By.xpath("((//li[contains(@class, 'single-event')])[" + (i + 1) + "]//span[@class='outcome-name'])[3]")).getText();
            } catch (Exception e) {
                System.err.println("home, away error");
                mainService.errorReport(bukName, dateTemp, "home, away error");
            }
            if (homeAway[0] != null && homeAway[0] != null)
                getTeamFromDataBase(homeAway[0], homeAway[1], match[i]);
            match[i].setDateTime(dateList.get(i));
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
        match.setTeams(matchesList);
    }

    public void getDates() {
        for (int i = 0; i < numberOfMatches; i++) {
            dateTemp = new Date();
            matchDate = null;
            try {
                time = driver.findElement(By.xpath("(//li[contains(@class, 'single-event')])[" + (i + 1) + "]//span[@class='time']")).getText();
                dayAndMonth = driver.findElement(By.xpath("(//li[contains(@class, 'single-event')])[" + (i + 1) + "]")).getAttribute("event-date");
                matchDate = sdf.parse(dayAndMonth + "-" + time);
            } catch (Exception e) {
                System.err.println("date error");
                mainService.errorReport(bukName, dateTemp, "date error");
            }
            dateList.add(matchDate);
        }
    }


}

