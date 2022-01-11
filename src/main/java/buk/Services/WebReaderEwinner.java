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
public class WebReaderEwinner {
	
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
	String bukName="Ewinner";
	List<Date> dateList = new ArrayList<>();
	TreeMap <Integer, String> league;
	Matches match [];
	double oddsTable[] = new double[3];
	Odds odds [];
	List <WebElement> allMatches;
	Date matchDate;
	Date oddsDate;
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.HH:mm");
	Date dateTemp;
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	
	
	String polandEkstraklasaUrl = "https://ewinner.pl/zaklady-bukmacherskie/events/pilka-nozna/602";
	
	public void matchesReader(WebDriver driver) throws Exception {
		this.driver=driver;
		
//		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
//		driver = new ChromeDriver();
		for (Map.Entry<String, TreeMap> link : dataService.eWinner().entrySet()) {
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
		allMatches = driver.findElements(By.xpath("//div[@class='event']"));
		List <WebElement> oddsElem = driver.findElements(By.xpath("(//div[@class='game'])"));
		getDates();	
		getMatches();
		getOdds(oddsElem);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='event']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='game'])")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='game']//button")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='event']/span[@class='event-name']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='event']//div[@class='date-time']//span[@class='time']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='event']//div[@class='date-time']//span[@class='date']")));
		}
		catch  (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getOdds(List<WebElement> oddsElem) {
		odds = new Odds [match.length];
		for (int i=0; i<match.length; i++) {
			List <WebElement> odds1x2 = oddsElem.get(1).findElements(By.xpath("(//div[@class='game'])["+(i+1)+"]//button"));
			odds[i]=new Odds();
			oddsDate = new Date();
			try { 
				for (int z=0; z<3; z++) {
				oddsTable[z]= Double.parseDouble(odds1x2.get(z).getText());
				}
			}
				catch (Exception e) {
					System.err.println("get odds error");
					mainService.errorReport(bukName, dateTemp, "getOdds err");
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
			String [] homeAway = new String [2];
			try {
				homeAway = allMatches.get(1).findElement(By.xpath("(//div[@class='event'])["+(i+1)+"]/span[@class='event-name']")).getText().split(" - ");
				homeAway[0]=homeAway[0].trim();
				homeAway[1]=homeAway[1].trim();

			} catch (Exception e) {
				System.err.println("home, away error");
				mainService.errorReport(bukName, dateTemp, "getMatches err");
			}
			getTeamFromDataBase(homeAway[0], homeAway[1], match[i]);
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
			time = allMatches.get(1).findElement(By.xpath("(//div[@class='event'])["+(i+1)+"]//div[@class='date-time']//span[@class='time']")).getText();
			dayAndMonth = allMatches.get(1).findElement(By.xpath("(//div[@class='event'])["+(i+1)+"]//div[@class='date-time']//span[@class='date']")).getText();
			dateTemp = new Date();
			year = String.valueOf(dateTemp.getYear()+1900);
			matchDate=null;
			if (dayAndMonth.equalsIgnoreCase("Dzisiaj")) {
				Calendar cal = Calendar.getInstance();
				dayAndMonth=String.valueOf(cal.get(Calendar.DAY_OF_MONTH))+"."+String.valueOf(cal.get(Calendar.MONTH)+1);
			}
				try {
					matchDate = sdf.parse(dayAndMonth+ "." + year + "." + time);
				} catch (ParseException e) {
					e.printStackTrace();
					mainService.errorReport(bukName, dateTemp, "getDates err");
				}
				if (matchDate.before(dateTemp)) {
					matchDate.setYear(matchDate.getYear()+1);
				}
				dateList.add(matchDate);
			}
		}

	
	
}


