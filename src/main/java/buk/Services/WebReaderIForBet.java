package buk.Services;

import java.text.SimpleDateFormat;
import java.util.*;

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
import buk.Services.bukTeams.IForBetTeams;
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Service
public class WebReaderIForBet {

    @Autowired
    MatchesRepository matchesRep;
    @Autowired
    TeamsRepository tlRep;
    @Autowired
    OddsRepository oddsRep;
    @Autowired
    DataService dataService;
    @Autowired
    IForBetTeams iForBetTeams;
    @Autowired
    MainService mainService;


    String dateStr;
    String bukName = "IForBet";
    List<Date> dateList = new ArrayList<>();
    TreeMap<Integer, String> league;
    Matches match[];
    double oddsTable[] = new double[3];
    Odds odds[];
    Date matchDate;
    Date oddsDate;
    int numberOfMatches;
    SimpleDateFormat sdf = new SimpleDateFormat("EEEMMMddyyyyHH:mm:ss", Locale.ENGLISH);
    Date dateTemp;
    WebDriver driver;

    public void matchesReader(WebDriver driver) throws Exception {
        this.driver = driver;
        for (Map.Entry<String, TreeMap> link : dataService.iForBet().entrySet()) {
            matchesReaderStart(link.getKey(), link.getValue());
        }
    }

    public void matchesReaderStart(String url, TreeMap<Integer, String> league) {
        this.league = league;
        try {
            Thread.sleep(mainService.randomNumber());
            dateTemp = new Date();
            driver.get(url);
            waitUntill();
            List<WebElement> allMatches = driver.findElements(By.xpath("//section[@class='mb-6']//section/div[contains(@class, 'items-center')]"));
            numberOfMatches = allMatches.size();
            // max 16 matches to read
            if (numberOfMatches>16)
                numberOfMatches=16;
            getDates();
            getMatches();
            getOdds();
            saveMatchAndOdds();
        } catch (Exception e) {
            System.err.println("xpath or url not found.......");
            mainService.errorReport(bukName, dateTemp, "xpath or url err");
        }
        league.clear();
        dateList.clear();

    }

    public void waitUntill() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='mb-6']//section/div[contains(@class, 'items-center')]")));
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
                oddsTable[0] = Double.parseDouble(driver.findElement(By.xpath("(//section[@class='mb-6']//section//div[contains(@class, 'mr-14')])[" + (i + 1) + "]//div[1]/button[1]")).getText());
                oddsTable[1] = Double.parseDouble(driver.findElement(By.xpath("(//section[@class='mb-6']//section//div[contains(@class, 'mr-14')])[" + (i + 1) + "]//div[1]/button[2]")).getText());
                oddsTable[2] = Double.parseDouble(driver.findElement(By.xpath("(//section[@class='mb-6']//section//div[contains(@class, 'mr-14')])[" + (i + 1) + "]//div[1]/button[3]")).getText());

            } catch (Exception e) {
                System.err.println("get odds error");
                mainService.errorReport(bukName, dateTemp, "getOdds");
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
            if (match[i].getDateTime() != null && match[i].getHome() != null && match[i].getAway() != null && odds[i] != null && mainService.compareDates(match[i])) {
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
    }

    public void getMatches() {
        match = new Matches[numberOfMatches];
        for (int i = 0; i < numberOfMatches; i++) {
            match[i] = new Matches();
            String gethomeAway="";
            String[] homeAway = new String[2];
            try {
                gethomeAway = driver.findElement(By.xpath("(//section[1]//header[contains(@class, 'text-13')])[" + (i + 1) + "]")).getText();
                homeAway = gethomeAway.split(" - ");
            } catch (Exception e) {
                System.err.println("home, away error");
                mainService.errorReport(bukName, dateTemp, "home, away error");
            }
            getTeamFromDataBase(homeAway[0], homeAway[1], match[i]);
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
        for (int i = 0; i < numberOfMatches; i++) {
            matchDate = null;
            String dateSplit [];
            try {
                dateStr = driver.findElement(By.xpath("(//section/div[contains(@class, 'items-center')]//time)[" + (i + 1) + "]")).getAttribute("datetime");
                dateSplit=dateStr.split(" ");
                matchDate=(sdf.parse(dateSplit[0]+dateSplit[1]+dateSplit[2]+dateSplit[3]+dateSplit[4]));
            } catch (Exception e) {
                System.err.println("date error");
                mainService.errorReport(bukName, dateTemp, "getDates err");
            }
            dateList.add(matchDate);
        }
    }

}
