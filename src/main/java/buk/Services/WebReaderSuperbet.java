package buk.Services;

import java.text.ParseException;
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
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Service
public class WebReaderSuperbet {
	
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
	
	String dayAndMonth, year, time, home, away;
	String bukName="SuperBet";
	List<Date> dateList = new ArrayList<>();
	TreeMap <Integer, String> league;
	Matches match [];
	double oddsTable[] = new double[3];
	Odds odds [];
	List <WebElement> allMatches;
	Date matchDate;
	Date oddsDate;
	Date dateTemp;
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.HH:mm");						   
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String days [] = {"niedz.","pon.","wt.","śr.","czw.","pt.","sob."};
	
	String polandEkstraklasaUrl = "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/polska/polska-ekstraklasa";
	
	public void matchesReader(WebDriver driver) throws Exception {
		this.driver=driver;
		for (Map.Entry<String, TreeMap> link : dataService.superBet().entrySet()) {
			matchesReaderStart(link.getKey(), link.getValue());
	}
	}
	
	public void matchesReaderStart(String url, TreeMap <Integer, String> league)  {	
		this.league=league;
		try{
			Thread.sleep(mainService.randomNumber());
		dateTemp=new Date();
		driver.get(url);
		waitUntill();
		allMatches = driver.findElements(By.xpath("//div[@class='event-row']"));
		getDates();	
		getMatches();
		getOdds();
		saveMatchAndOdds();
		}
		catch (Exception e) {
			System.err.println("xpath or url not found.......");
			mainService.errorReport(bukName, dateTemp, "xpath or url err");
		}
		league.clear();
		dateList.clear();

	}
	
	public void waitUntill() {
		try {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='event-row']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='primary-market']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='event-summary__competitors-team1']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='event-summary__match-indicator-time']")));
	}
	catch  (Exception e) {
		e.printStackTrace();
	}
}
	
	public void getOdds() {
		odds = new Odds [match.length];
		for (int i=0; i<match.length; i++) {
			List <WebElement> odds1x2 = allMatches.get(1).findElements(By.xpath("(//div [@class='primary-market'])["+(i+1)+"]//span[@class=normalize-space('value old actionable')]"));
			odds[i]=new Odds();
			oddsDate = new Date();
			try { 
				for (int z=0; z<3; z++) {
				oddsTable[z]= Double.parseDouble(odds1x2.get(z).getText());
				}
			}
				catch (Exception e) {
					System.err.println("get odds error");
					mainService.errorReport(bukName, dateTemp, "getOdds error");
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
		for (int i=0; i<match.length; i++) {

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
	
	public void getMatches()  {
		match = new Matches[allMatches.size()];
		for (int i=0; i<allMatches.size(); i++) {
			match[i] = new Matches();
			try {
				home=allMatches.get(1).findElement(By.xpath("(//span[@class='event-summary__competitors-team1'])["+(i+1)+"]")).getText();
				away=allMatches.get(1).findElement(By.xpath("(//span[@class='event-summary__competitors-team2'])["+(i+1)+"]")).getText();
			} catch (Exception e) {
				System.err.println("home, away error");
				mainService.errorReport(bukName, dateTemp, "getMatches error");
			}
			getTeamFromDataBase(home, away, match[i]);
			match[i].setDateTime(dateList.get(i));
		}
	}
	
	public void getTeamFromDataBase(String home, String away, Matches match) {
		List<Teams> matchesList = new ArrayList<Teams>();
		for (int z=league.firstKey(); z< league.firstKey() + league.size(); z++) {
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
	
	public void getDates () {
		for (int i = 0; i < allMatches.size(); i++) {
			try {
			time = allMatches.get(i).findElement(By.xpath("(//span[@class='event-summary__match-indicator-time'])["+(i+1)+"]")).getText();
			dayAndMonth = allMatches.get(i).findElement(By.xpath("(//span[@class='event-summary__match-indicator-day'])["+(i+1)+"]")).getText();
			dayAndMonth=dayAndMonth.trim();
			Calendar cal = Calendar.getInstance();
			int dayOfWeek;
			matchDate=null;
			for (int z=0; z<7; z++) {
				if (dayAndMonth.equalsIgnoreCase(days[z])) {
					dayOfWeek=(z+1)-cal.get(Calendar.DAY_OF_WEEK);
					if (dayOfWeek<0) {
						dayOfWeek+=7;
					}
					try {
						cal.add(Calendar.DATE, dayOfWeek);
						matchDate = sdf.parse(cal.get(Calendar.DAY_OF_MONTH)+ "." + (cal.get(Calendar.MONTH)+1)+ "." + cal.get(Calendar.YEAR) + "." + time);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					break;
				}
			}
				if (matchDate==null) {
					try {
						matchDate = sdf.parse(dayAndMonth+ "." + cal.get(Calendar.YEAR) + "." + time);
					} catch (ParseException e) {
						e.printStackTrace();
					}
			}
				Date dateTemp = new Date();
			if (matchDate.before(dateTemp)) {
				matchDate.setYear(matchDate.getYear()+1);
			}
			dateList.add(matchDate);
		}
		catch (Exception e) {
			System.err.println("getDates");
			mainService.errorReport(bukName, dateTemp, "getDates");
		}
	}
	}
	
	
}


