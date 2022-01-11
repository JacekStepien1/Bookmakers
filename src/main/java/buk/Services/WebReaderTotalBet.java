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
import buk.Services.bukTeams.TotalBetTeams;
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Service
public class WebReaderTotalBet {
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
	TotalBetTeams totalBetTeams;
	
	String dayAndMonth, year, time, home, away;
	String bukName="Totalbet";
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
	int numberOfMaches;
	String projectPath = System.getProperty("user.dir");
	
	String polandEkstraklasaUrl = "https://totalbet.pl/sports/events/Pilka-nozna/7485";
	
	public void matchesReader(WebDriver driver) throws Exception {

		this.driver=driver;
		for (Map.Entry<String, TreeMap> link : dataService.totalBet().entrySet()) {
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
		numberOfMaches = allMatches.size();
		//max 18 matches to read
		if (numberOfMaches>18)
			numberOfMaches = 18;
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='event']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='game']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='date-time']//span[@class='time']")));
		}
		catch  (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getOdds() {
		odds = new Odds [match.length];
		for (int i=0; i<match.length; i++) {
			List <WebElement> odds1x2 = driver.findElements(By.xpath("((//div[@class='after-event'])["+(i+1)+"]//div[@class='game'])[1]//button"));
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
		List <WebElement> matchesSep = driver.findElements(By.xpath("//span[@class='event-name']"));
		match = new Matches[numberOfMaches];
		for (int i=0; i<numberOfMaches; i++) {
			String matchTab [];
			matchTab=matchesSep.get(i).getText().split(" - ");
			match[i] = new Matches();
			try {
				home=matchTab[0].trim();
				away=matchTab[1].trim();
			} catch (Exception e) {
				System.err.println("home, away error");
				mainService.errorReport(bukName, dateTemp, "getMatches err");
			}
			if(away.length()>33){
				String temp = away.substring((away.length()-30), away.length());
				if (temp.equalsIgnoreCase("(TOTALhit: zagraj wyższy kurs)")){
					String temp2= away.substring(0, (away.length()-30));
					away=temp2.trim();
				}
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
		if (match.getHome()==null || match.getAway()==null) {
			for (Map.Entry<String, Integer> excep : totalBetTeams.teamsExceptions().entrySet()) {
				if (home.equalsIgnoreCase(excep.getKey())) {
					Teams tl = tlRep.findOne((long) excep.getValue());
					match.setHome(tl.getTeam());
					matchesList.add(tl);
				}
				if (away.equalsIgnoreCase(excep.getKey())) {
					Teams tl = tlRep.findOne((long) excep.getValue());
					match.setAway(tl.getTeam());
					matchesList.add(tl);
				}
			}
		}
		match.setTeams(matchesList);
	}
	
	public void getDates () {
		
		List <WebElement> mTime = driver.findElements(By.xpath("(//div[@class='date-time'])//span[@class='time']"));
		List <WebElement> mDate = driver.findElements(By.xpath("(//div[@class='date-time'])//span[@class='date']"));

		for (int i = 0; i < numberOfMaches; i++) {
			time = mTime.get(i).getText();
			dayAndMonth = mDate.get(i).getText();
			dateTemp = new Date();
			year = String.valueOf(dateTemp.getYear()+1900);
			matchDate=null;
			Calendar cal = Calendar.getInstance();
			if (dayAndMonth.equalsIgnoreCase("Dzisiaj"))
				dayAndMonth=String.valueOf(cal.get(Calendar.DAY_OF_MONTH))+"."+String.valueOf(cal.get(Calendar.MONTH)+1);
			if (dayAndMonth.equalsIgnoreCase("Jutro")) {
				dayAndMonth=String.valueOf(cal.get(Calendar.DAY_OF_MONTH)+1)+"."+String.valueOf(cal.get(Calendar.MONTH)+1);
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

