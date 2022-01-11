package buk.Services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import buk.Services.bukTeams.EtotoTeams;
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Service
public class WebReaderEtoto {

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
	@Autowired
	EtotoTeams etotoTeams;

	String dayAndMonth, year, time;
	String bukName = "Etoto";
	List<Date> dateList = new ArrayList<>();
	TreeMap<Integer, String> league;
	Matches match[];
	double oddsTable[] = new double[3];
	Odds odds[];
	List<WebElement> allMatches;
	Date matchDate;
	Date oddsDate;
	int numberOfMatches;
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.HH:mm");
	Date dateTemp;
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	String polandEkstraklasaUrl = "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/polska/ekstraklasa/666";

	public void matchesReader(WebDriver driver) throws Exception {

		this.driver=driver;
		for (Map.Entry<String, TreeMap> link : dataService.eToto().entrySet()) {
			matchesReaderStart(link.getKey(), link.getValue());
	}
	}

	public void matchesReaderStart(String url, TreeMap<Integer, String> league) {
		this.league = league;
		try {
			Thread.sleep(mainService.randomNumber());
			dateTemp=new Date();
			driver.get(url);
			waitUntill();
			
			//List<WebElement> allMatches = driver.findElements(By.xpath("//div[@class='event']"));
			List<WebElement> allMatches = driver.findElements(By.xpath("//li[normalize-space(@class)= 'col-all-12 single-event']"));
			numberOfMatches=allMatches.size();
			getDates();
			getMatches();
			getOdds();
			saveMatchAndOdds();
		} catch (Exception e) {
			System.err.println("xpath or url not found.......");
			mainService.errorReport(bukName, dateTemp, "xpath or url err");
		}
		league.clear();
		numberOfMatches=0;
		dateList.clear();
		
	}

	public void waitUntill() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'participant1')]")));
		}
		catch  (Exception e) {
			e.printStackTrace();
		}
	}

	public void getOdds() {
		odds = new Odds[numberOfMatches];
		for (int i=0; i < numberOfMatches; i++) {
			odds[i] = new Odds();
			oddsDate = new Date();
			oddsTable[0]=0;oddsTable[1]=0;oddsTable[2]=0;
			try {
				
				oddsTable[0]=Double.parseDouble(driver.findElement(By.xpath("(((//div[@class='after-event '])["+(i+1)+"]//div[@class='game'])[1])//button[1]")).getText());
				oddsTable[1]=Double.parseDouble(driver.findElement(By.xpath("(((//div[@class='after-event '])["+(i+1)+"]//div[@class='game'])[1])//button[2]")).getText());
				oddsTable[2]=Double.parseDouble(driver.findElement(By.xpath("(((//div[@class='after-event '])["+(i+1)+"]//div[@class='game'])[1])//button[3]")).getText());
			} catch (Exception e) {
				System.err.println("get odds error");
				mainService.errorReport(bukName, dateTemp, "błąd");
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

	public void getMatches() {
		match = new Matches[numberOfMatches];
		for (int i = 0; i < numberOfMatches; i++) {
			match[i] = new Matches();
			String[] homeAway = new String[2];
			try {
				homeAway[0]=driver.findElement(By.xpath("(//li[normalize-space(@class)= 'col-all-12 single-event'])["+(i+1)+"]//div[contains(@class, 'participant1')]//span")).getText();
				homeAway[1]=driver.findElement(By.xpath("(//li[normalize-space(@class)= 'col-all-12 single-event'])["+(i+1)+"]//div[contains(@class, 'participant2')]//span")).getText();
			} catch (Exception e) {
				System.err.println("home, away error");
				mainService.errorReport(bukName, dateTemp, "err");
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
		if (match.getHome()==null || match.getAway()==null) {
			for (Map.Entry<Integer, String> excep : etotoTeams.eTotoTeamsExceptions().entrySet()) {
				if (home.equalsIgnoreCase(excep.getValue())) {
					Teams tl = tlRep.findOne((long) excep.getKey());
					match.setHome(tl.getTeam());
					matchesList.add(tl);
				}
				if (away.equalsIgnoreCase(excep.getValue())) {
					Teams tl = tlRep.findOne((long) excep.getKey());
					match.setAway(tl.getTeam());
					matchesList.add(tl);
				}
			}
		}
		match.setTeams(matchesList);
	}

	public void getDates() {
		for (int i = 0; i < numberOfMatches; i++) {
			dateTemp = new Date();
			matchDate = null;
			try {
				
				
				dayAndMonth=driver.findElement(By.xpath("(//div[@class='date-time']//span[@class='date'])["+(i+1)+"]")).getText();
				time=driver.findElement(By.xpath("(//div[@class='date-time']//span[@class='time'])["+(i+1)+"]")).getText();
				Calendar cal = Calendar.getInstance();
				year = String.valueOf(cal.get(Calendar.YEAR));
				if(dayAndMonth.equalsIgnoreCase("dziś") || dayAndMonth.equalsIgnoreCase("dzisiaj")) {
					dayAndMonth=String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "." + String.valueOf(cal.get(Calendar.MONTH)+1);		
				}
				if(dayAndMonth.equalsIgnoreCase("jutro")) {
					dayAndMonth=String.valueOf(cal.get(Calendar.DAY_OF_MONTH)+1) + "." + String.valueOf(cal.get(Calendar.MONTH)+1);
				}
				//dayAndMonth=dayAndMonth.replace(" /", ".");
				matchDate = sdf.parse(dayAndMonth + "." + year + "." + time);
				if (matchDate.before(dateTemp)) {
				matchDate.setYear(matchDate.getYear() + 1);
			}
			} catch (Exception e) {
				System.err.println("date error");
				mainService.errorReport(bukName, dateTemp, "błąd");
			}
			dateList.add(matchDate);
		}
	}
	
	
	
}

