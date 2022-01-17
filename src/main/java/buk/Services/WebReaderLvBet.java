package buk.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class WebReaderLvBet {

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

    String day, month, year, time, home, away;
    String bukName = "LvBet";
    List<Date> dateList = new ArrayList<>();
    TreeMap<Integer, String> league;
    Matches match[];
    double oddsTable[] = new double[3];
    Odds odds[];
    Date dateTemp;
    WebDriver driver;

    Date matchDate;
    Date oddsDate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.HH:mm");
    Pattern yearPattern = Pattern.compile("20[0-9]{2}");
    Pattern hourPattern = Pattern.compile("[0-9]{2}:[0-9]{2}");
    Pattern monthPattern = Pattern.compile("[A-Za-zążźćóęśńłĘÓŁŚĄŻŹĆŃ]+,");
    Matcher matcher;
    String monthNames[] = new String[]{
            "stycznia",
            "lutego",
            "marca",
            "kwietnia",
            "maja",
            "czerwca",
            "lipca",
            "sierpnia",
            "września",
            "października",
            "listopada",
            "grudnia"};

    public void matchesReader(WebDriver driver) throws Exception {
        this.driver = driver;
        for (Map.Entry<String, TreeMap> link : dataService.lvBet().entrySet()) {
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

            List<WebElement> allMatches = driver.findElements(By.xpath("//match-item [contains (@class, 'matches-group-entry')]"));
            List<WebElement> oddsElem = driver.findElements(By.xpath("//div[@class='odds-wrapp']"));
            getDates();
            getMatches(allMatches);
            getOdds(oddsElem);
            saveMatchAndOdds();
        } catch (Exception e) {
            System.err.println("xpath or url not found.......");
            mainService.errorReport(bukName, dateTemp, "err");
        }
        league.clear();
        dateList.clear();


    }

    public void waitUntill() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//matches-league [contains(@class, 'sb-odds-table')]")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wrapp']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//match-item [contains (@class, 'matches-group-entry')]//a[@class='game']//li")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getOdds(List<WebElement> oddsElem) {
        odds = new Odds[match.length];
        for (int i = 0; i < match.length; i++) {
            odds[i] = new Odds();
            oddsDate = new Date();
            try {
                for (int z = 0; z < 3; z++) {
                    oddsTable[z] = Double.parseDouble(driver.findElement(By.xpath("((//div[@class='wrapp'])[" + (i + 1) + "]//button)[" + (z + 1) + "]")).getText());
                }
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
        for (int i = 0; i < match.length; i++) {
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

    public void getMatches(List<WebElement> allMatches) {
        int elem = 1;
        match = new Matches[allMatches.size()];
        for (int i = 0; i < allMatches.size(); i++) {
            match[i] = new Matches();
            try {
                home = allMatches.get(1).findElement(By.xpath("(//match-item [contains (@class, 'matches-group-entry')]//a[@class='game']//li )[" + elem + "]")).getText();
                away = allMatches.get(1).findElement(By.xpath("(//match-item [contains (@class, 'matches-group-entry')]//a[@class='game']//li )[" + (elem + 1) + "]")).getText();
                elem += 2;
            } catch (Exception e) {
                System.err.println("home, away error");
                mainService.errorReport(bukName, dateTemp, "home, away error");
            }
            getTeamFromDataBase(home, away, match[i]);
            match[i].setDateTime(dateList.get(i));
        }
    }

    public void getTeamFromDataBase(String home, String away, Matches match) {
        List<Teams> matchesList = new ArrayList<Teams>();
        for (int z = league.firstKey(); z < league.firstKey() + league.size(); z++) {
            if (home.equalsIgnoreCase(league.get(z))) {
                Teams tl = tlRep.findOne((long) z);
                match.setHome(tl.getTeam());
                matchesList.add(tl);
            }
            if (away.equalsIgnoreCase(league.get(z))) {
                Teams tl = tlRep.findOne((long) z);
                match.setAway(tl.getTeam());
                matchesList.add(tl);
            }
        }
        match.setTeams(matchesList);
    }

    public void getDates() {
        WebElement getDate = driver.findElement(By.xpath("//matches-league [contains(@class, 'sb-odds-table')]"));
        String[] stringWebElements = getDate.getText().split("\n");
        for (int i = 0; i < stringWebElements.length; i++) {
            if (stringWebElements[i].length() > 15) {
                matcher = yearPattern.matcher(stringWebElements[i].substring(stringWebElements[i].length() - 4, stringWebElements[i].length()));
                if (matcher.matches()) {
                    year = stringWebElements[i].replaceAll("[^0123456789]", "");
                    day = year.substring(0, year.length() - 4);
                    year = year.substring(year.length() - 4, year.length());
                    matcher = monthPattern.matcher(stringWebElements[i]);
                    if (matcher.find()) {
                        month = matcher.replaceAll("");
                        month = month.replaceAll("[1234567890]", "");
                        month = month.trim();
                        for (int y = 0; y < 12; y++) {
                            if (monthNames[y].equals(month))
                                month = String.valueOf(y + 1);
                        }
                    }
                }
            }
            matcher = hourPattern.matcher(stringWebElements[i]);
            if (matcher.matches()) {
                String hour = stringWebElements[i];
                matchDate = null;
                try {
                    matchDate = sdf.parse(day + "." + month + "." + year + "." + hour);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dateList.add(matchDate);
            }
        }
    }


}


