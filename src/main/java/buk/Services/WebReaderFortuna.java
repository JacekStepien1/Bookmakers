package buk.Services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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
public class WebReaderFortuna {

	@Autowired
	MatchesRepository matchesRep;
	@Autowired
	TeamsRepository tlRep;
	@Autowired
	OddsRepository oddsRep;
	@Autowired
	DataService dataService;
	@Autowired
	MainService mainService;

	String dateTry = "";
	String teams;
	String strOdds;
	String buk="Fortuna";

	String yearStr;

	int numberOfOdds;
	int value;
	Odds odds[];
	Document doc;
	Elements col3;
	Elements date;

	String dayAndMonth, time;
	int year;
	String bukName = "Fortuna";
	List<Date> dateList = new ArrayList<>();
	TreeMap<Integer, String> league;
	Matches match[];
	double oddsTable[] = new double[3];
	List<WebElement> allMatches;
	Date matchDate;
	Date oddsDate;
	int numberOfMatches;
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyHH:mm");
	Date dateTemp;
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");



//		String url = "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/turcja/1-liga/184/6527/74206/";
//		File fileUrl = new File("F:\\Java\\Eclipse2020\\buk2-building\\src\\main\\resources\\sts-turcja.htm");


	String polandEkstraklasaUrl = "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/ekstraklasa-polska";


	//File turkey1leagueUrl = new File("src\\main\\resources\\sts-turcja.htm");
//	File belarus1leagueUrl = new File("src\\main\\resources\\fortuna-bialorus.html");
//	File polandEkstraklasaUrl = new File("src\\main\\resources\\fortuna-ekstraklasa.html");

	public void matchesReader(WebDriver driver) throws Exception {

		this.driver = driver;
		for (Map.Entry<String, TreeMap> link : dataService.fortuna().entrySet()) {
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

			List<WebElement> allMatches = driver.findElements(By.xpath("//tr[@class='tablesorter-hasChildRow']"));
			numberOfMatches=allMatches.size();

			if (numberOfMatches>0){
				getDates();
				getMatches();
				getOdds();
				saveMatchAndOdds();
			}
			if (numberOfMatches==0){
				List<WebElement> allMatches1 = driver.findElements(By.xpath("//div[@class='markets-list']"));
				numberOfMatches=allMatches1.size();
				if (numberOfMatches==1){
				getDates1();
				getMatches1();
				getOdds1();
				saveMatchAndOdds();
				}
			}
		} catch (Exception e) {
			System.err.println("xpath or url not found.......");
			mainService.errorReport(bukName, dateTemp, "main err " +driver.getCurrentUrl());
		}
		league.clear();
		numberOfMatches=0;
		dateList.clear();

	}

	public void waitUntill() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='markets-list']")));
		}
		catch  (Exception e) {
			e.printStackTrace();
		}
	}

	public void getDates() {
		for (int i = 0; i < numberOfMatches; i++) {
			dateTemp = new Date();
			matchDate = null;
			Date getYear = new Date();
			year = getYear.getYear()+1900;
			yearStr = String.valueOf(year);
			String dayMonthTime [];
			try {
				dateTry=driver.findElement(By.xpath("//tr[@class='tablesorter-hasChildRow']["+(i+1)+"]//span[@class='event-datetime']")).getText();
				dateTry=dateTry.replaceFirst(" ", yearStr);
				matchDate = sdf.parse(dateTry);
				if (matchDate.before(dateTemp)) {
					matchDate.setYear(matchDate.getYear() + 1);
				}
			} catch (Exception e) {
				System.err.println("date error");
				mainService.errorReport(bukName, dateTemp, "date error " + driver.getCurrentUrl());
			}
			dateList.add(matchDate);
		}
	}

	public void getMatches() {
		match = new Matches[numberOfMatches];
		for (int i = 0; i < numberOfMatches; i++) {
			match[i] = new Matches();
			String[] homeAway = new String[2];
			try {
				teams=driver.findElement(By.xpath("//tr[@class='tablesorter-hasChildRow']["+(i+1)+"]//span[@class='market-name']")).getText();
				teams.trim();
				homeAway = teams.split(" - ");
			} catch (Exception e) {
				System.err.println("home, away error");
				mainService.errorReport(bukName, dateTemp, "getMatches error " +driver.getCurrentUrl());
			}
			if (homeAway[0]!=null && homeAway[0]!=null)
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

	public void getOdds() {
		odds = new Odds[numberOfMatches];
		for (int i=0; i < numberOfMatches; i++) {
			odds[i] = new Odds();
			oddsDate = new Date();
			oddsTable[0]=0;oddsTable[1]=0;oddsTable[2]=0;
			String odd;

			try {


				for (int z=0; z<3; z++) {
					odd=driver.findElement(By.xpath("//tr[@class='tablesorter-hasChildRow']["+(i+1)+"]//td[@class='col-odds']["+(z+1)+"]")).getText();
					oddsTable[z]=Double.valueOf(odd);
				}
			} catch (Exception e) {
				System.err.println("get odds error");
				mainService.errorReport(bukName, dateTemp, "getOdds error " +driver.getCurrentUrl());
			}
			if (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) {
				odds[i].setHome(oddsTable[0]);
				odds[i].setDraw(oddsTable[1]);
				odds[i].setAway(oddsTable[2]);
				odds[i].setDateTime(oddsDate);
				odds[i].setBuk(bukName);
			}
			else
				odds[i] = null;
		}
	}

	public void saveMatchAndOdds() {
		for (int i=0; i<numberOfMatches; i++) {
			Matches m = matchesRep.findFirstByHomeAndAwayAndDateTimeBetween(match[i].getHome(), match[i].getAway(), mainService.date1 (match[i]), mainService.date2 (match[i]));
			if (m != null && odds[i]!=null) {
				odds[i].setMatch(m);
				oddsRep.save(odds[i]);
			}
			else {
				if (match[i].getDateTime()!=null && match[i].getHome()!=null && match[i].getAway()!=null && odds[i]!=null && mainService.compareDates(match[i])) {
					match[i].setFirstAppeared(bukName);
					matchesRep.save(match[i]);
					odds[i].setMatch(match[i]);
					oddsRep.save(odds[i]);
				}
			}
		}
	}

	public void getDates1() {
		for (int i = 0; i < numberOfMatches; i++) {
			dateTemp = new Date();
			matchDate = null;
			Date getYear = new Date();
			year = getYear.getYear()+1900;
			yearStr = String.valueOf(year);
			String dayMonthTime [];
			try {
				dateTry=driver.findElement(By.xpath("//div[@class='markets-list']//span[@class='event-datetime']")).getText();
				dateTry=dateTry.replaceFirst(" ", yearStr);
				matchDate = sdf.parse(dateTry);
				if (matchDate.before(dateTemp)) {
					matchDate.setYear(matchDate.getYear() + 1);
				}
			} catch (Exception e) {
				System.err.println("date error");
				mainService.errorReport(bukName, dateTemp, "date error " + driver.getCurrentUrl());
			}
			dateList.add(matchDate);
		}
	}

	public void getMatches1() {
		match = new Matches[numberOfMatches];
		for (int i = 0; i < numberOfMatches; i++) {
			match[i] = new Matches();
			String[] homeAway = new String[2];
			try {
				teams=driver.findElement(By.xpath("//div[@class='markets-list']//span[@class='market-name']")).getText();
				teams.trim();
				homeAway = teams.split(" - ");
			} catch (Exception e) {
				System.err.println("home, away error");
				mainService.errorReport(bukName, dateTemp, "getMatches error " +driver.getCurrentUrl());
			}
			if (homeAway[0]!=null && homeAway[0]!=null)
				getTeamFromDataBase(homeAway[0], homeAway[1], match[i]);
			match[i].setDateTime(dateList.get(i));
		}
	}

	public void getOdds1() {
		odds = new Odds[numberOfMatches];
		for (int i=0; i < numberOfMatches; i++) {
			odds[i] = new Odds();
			oddsDate = new Date();
			oddsTable[0]=0;oddsTable[1]=0;oddsTable[2]=0;
			String odd;

			try {


				for (int z=0; z<3; z++) {
					odd=driver.findElement(By.xpath("//div[@class='markets-list']//td[@class='col-odds']["+(z+1)+"]")).getText();
					oddsTable[z]=Double.valueOf(odd);
				}
			} catch (Exception e) {
				System.err.println("get odds error");
				mainService.errorReport(bukName, dateTemp, "getOdds error " +driver.getCurrentUrl());
			}
			if (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) {
				odds[i].setHome(oddsTable[0]);
				odds[i].setDraw(oddsTable[1]);
				odds[i].setAway(oddsTable[2]);
				odds[i].setDateTime(oddsDate);
				odds[i].setBuk(bukName);
			}
			else
				odds[i] = null;
		}
	}


}
