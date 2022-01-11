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
public class WebReaderNobleBet {

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
	String bukName = "NobleBet";
	List<Date> dateList = new ArrayList<>();
	TreeMap<Integer, String> league;
	Matches match[];
	double oddsTable[] = new double[3];
	Odds odds[];
	List<WebElement> allMatches;
	Date matchDate;
	Date oddsDate;
	int numberOfMatches;
	int numberOfLiveMatches;
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.HH:mm");
	Date dateTemp;
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	String polandEkstraklasaUrl = "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=37425";

	public void matchesReader(WebDriver driver) throws Exception {

		this.driver=driver;
		for (Map.Entry<String, TreeMap> link : dataService.nobleBet().entrySet()) {
			matchesReaderStart(link.getKey(), link.getValue());
	}
	}

	public void matchesReaderStart(String url, TreeMap<Integer, String> league) {
		this.league = league;
		try {
			Thread.sleep(mainService.randomNumber());
			numberOfMatches=0;
			dateTemp=new Date();
			driver.get(url);
			waitUntill();
			allMatches = driver.findElements(By.xpath("//div[@class=normalize-space('row match-row')]"));
			numberOfMatches=allMatches.size();
			allMatches = driver.findElements(By.xpath("//div[contains(@class, 'is-live')]"));

			numberOfLiveMatches=allMatches.size();
//			numberOfMatches-=numberOfLiveMatches;

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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=normalize-space('row match-row')]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='date']")));
	}
	catch  (Exception e) {
		e.printStackTrace();
	}
}

	public void getOdds() {
		odds = new Odds[numberOfMatches-numberOfLiveMatches];
		for (int i = 0+numberOfLiveMatches; i < numberOfMatches; i++) {
			odds[i-numberOfLiveMatches] = new Odds();
			oddsDate = new Date();
			oddsTable[0]=0;oddsTable[1]=0;oddsTable[2]=0;
			try {


				// (((//div[@class=normalize-space('row match-row')])["+(i+1)+"]//div[@class='col-d-4'])[1]//span)[1]


				if (driver.findElement(By.xpath("(((//div[@class=normalize-space('row match-row')])["+(i+1)+"]//div[@class='col-d-4'])[1]//span)[1]")).getText().equals("1"))
				oddsTable[0]=Double.parseDouble(driver.findElement(By.xpath("(((//div[@class=normalize-space('row match-row')])["+(i+1)+"]//div[@class='col-d-4'])[1]//button)[1]")).getText().trim());
				if (driver.findElement(By.xpath("(((//div[@class=normalize-space('row match-row')])["+(i+1)+"]//div[@class='col-d-4'])[2]//span)[1]")).getText().trim().equalsIgnoreCase("x"))
				oddsTable[1]=Double.parseDouble(driver.findElement(By.xpath("(((//div[@class=normalize-space('row match-row')])["+(i+1)+"]//div[@class='col-d-4'])[2]//button)[1]")).getText().trim());
				if (driver.findElement(By.xpath("(((//div[@class=normalize-space('row match-row')])["+(i+1)+"]//div[@class='col-d-4'])[3]//span)[1]")).getText().equals("2"))
				oddsTable[2]=Double.parseDouble(driver.findElement(By.xpath("(((//div[@class=normalize-space('row match-row')])["+(i+1)+"]//div[@class='col-d-4'])[3]//button)[1]")).getText().trim());
			} catch (Exception e) {
				System.err.println("get odds error");
				mainService.errorReport(bukName, dateTemp, "get odds error");
			}
			if (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) {
				odds[i-numberOfLiveMatches].setHome(oddsTable[0]);
				odds[i-numberOfLiveMatches].setDraw(oddsTable[1]);
				odds[i-numberOfLiveMatches].setAway(oddsTable[2]);
				odds[i-numberOfLiveMatches].setDateTime(oddsDate);
				odds[i-numberOfLiveMatches].setBuk(bukName);
			}
			else 
				odds[i-numberOfLiveMatches] = null;
		}
	}

	public void saveMatchAndOdds() {
		for (int i=0+numberOfLiveMatches; i<numberOfMatches; i++) {
			Matches m = matchesRep.findFirstByHomeAndAwayAndDateTimeBetween(match[i-numberOfLiveMatches].getHome(), match[i-numberOfLiveMatches].getAway(), mainService.date1 (match[i-numberOfLiveMatches]), mainService.date2 (match[i-numberOfLiveMatches]));
			if (m != null && odds[i-numberOfLiveMatches]!=null) {
				odds[i-numberOfLiveMatches].setMatch(m);
				oddsRep.save(odds[i-numberOfLiveMatches]);
			}
			else {
				if (match[i-numberOfLiveMatches].getDateTime()!=null && match[i-numberOfLiveMatches].getHome()!=null && match[i-numberOfLiveMatches].getAway()!=null && odds[i-numberOfLiveMatches]!=null  && mainService.compareDates(match[i-numberOfLiveMatches]))  {
				match[i-numberOfLiveMatches].setFirstAppeared(bukName);
				matchesRep.save(match[i-numberOfLiveMatches]);
				odds[i-numberOfLiveMatches].setMatch(match[i-numberOfLiveMatches]);
				oddsRep.save(odds[i-numberOfLiveMatches]);	
				}
			}
		}
	}

	public void getMatches() {
		match = new Matches[numberOfMatches-numberOfLiveMatches];
		for (int i = 0+numberOfLiveMatches; i < numberOfMatches; i++) {
			match[i-numberOfLiveMatches] = new Matches();
			String[] homeAway = new String[2];
			try {
				homeAway=driver.findElement(By.xpath("((//div[@class=normalize-space('row match-row')])["+(i+1)+"]//p[@class='has-tooltip'])[1]")).getText().split(" - ");
			} catch (Exception e) {
				System.err.println("home, away error");
				mainService.errorReport(bukName, dateTemp, "getMatches");
			}
			getTeamFromDataBase(homeAway[0], homeAway[1], match[i-numberOfLiveMatches]);
			match[i-numberOfLiveMatches].setDateTime(dateList.get(i-numberOfLiveMatches));
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
		for (int i=numberOfLiveMatches; i<numberOfMatches; i++) {
			dateTemp = new Date();
			matchDate = null;
			try {
				dayAndMonth=driver.findElement(By.xpath("((//div[@class=normalize-space('row match-row')])["+(i+1)+"]//div[@class='date'])[1]")).getText();
				time=driver.findElement(By.xpath("((//div[@class=normalize-space('row match-row')])["+(i+1)+"]//div[@class='date'])[2]")).getText();
				year = String.valueOf(dateTemp.getYear() + 1900);
				matchDate = sdf.parse(dayAndMonth + "." + year + "." + time);
				if (matchDate.before(dateTemp)) {
				matchDate.setYear(matchDate.getYear() + 1);
			}
			} catch (Exception e) {
				System.err.println("date error");
				mainService.errorReport(bukName, dateTemp, "getDates");
			}
			dateList.add(matchDate);
		}
	}

}