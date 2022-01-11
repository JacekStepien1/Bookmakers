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
import buk.Services.bukTeams.TotolotekTeams;
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Service
public class WebReaderTotolotek {
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
	TotolotekTeams totolotekTeams;
	
	String dayAndMonth, year, time, home, away;
	String bukName="Totolotek";
	List<Date> dateList = new ArrayList<>();
	TreeMap <Integer, String> league;
	Matches match [];
	double oddsTable[] = new double[3];
	Odds odds [];
	List <WebElement> allMatches;
	Date dateTemp;
	Date matchDate;
	Date oddsDate;
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.HH:mm");						   
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	int numberOfMatches;
	
	String polandEkstraklasaUrl = "https://www.totolotek.pl/pl/pilka-nozna/polska/ekstraklasa";
	
	public void matchesReader(WebDriver driver) throws Exception {

		this.driver=driver;
		for (Map.Entry<String, TreeMap> link : dataService.totolotek().entrySet()) {
			matchesReaderStart(link.getKey(), link.getValue());
	}
	}
	
	public void matchesReaderStart(String url, TreeMap <Integer, String> league)  {	
		this.league=league;
		try{
		dateTemp=new Date();
		driver.get(url);
		waitUntill();
		List <WebElement> allMatches = driver.findElements(By.xpath("//div[contains(@class, 'game--upcoming')]"));
		numberOfMatches=allMatches.size();
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
		numberOfMatches=0;
		dateList.clear();

	}
	
	public void waitUntill() {
		WebDriverWait wait = new WebDriverWait(driver,15);;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='game__teams']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='standings__time']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='gamelist__event']//div[@class='odd-button__value']")));
		}
		catch  (Exception e) {
			e.printStackTrace();
		}
		
		
		}
	
	public void getOdds() {	
		odds = new Odds [numberOfMatches];
		List <WebElement> odds1x2;
		for (int i=0; i<numberOfMatches; i++) {
			oddsTable[0]=0;oddsTable[1]=0;oddsTable[2]=0;
			odds1x2 = driver.findElements(By.xpath("((//div[contains(@class, 'game--upcoming')])["+(i+1)+"]//div[@class='market__content'])[1]//div[@class='odd-button__value']"));
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
					odds[i]=new Odds();
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
			if (m != null  && odds[i]!=null) {
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
		match = new Matches[numberOfMatches];
		List <WebElement> homeAway = driver.findElements(By.xpath("//div[contains(@class, 'game--upcoming')]//div[@class='game__teams']"));
		for (int i=0; i<numberOfMatches; i++) {
			match[i] = new Matches();
			String homeAwayTab[];
			try {
				homeAwayTab=homeAway.get(i).getText().split("\n");
				home=homeAwayTab[0];
				away=homeAwayTab[1];
			} catch (Exception e) {
				System.err.println("home, away error");
				mainService.errorReport(bukName, dateTemp, "getMatches err");
			}
			getTeamFromDataBase(home, away, match[i]);
			match[i].setDateTime(dateList.get(i));
		}
	}
	
	public void getTeamFromDataBase(String home, String away, Matches match) {
		List<Teams> matchesList = new ArrayList<Teams>();
		for (int z=league.firstKey(); z< league.firstKey() + league.size(); z++) {
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
		
		if (match.getHome()==null || match.getAway()==null) {
			for (Map.Entry<Integer, String> excep : totolotekTeams.totolotekTeamsExceptions().entrySet()) {
				if (home.equals(excep.getValue())) {
					Teams tl = tlRep.findOne((long) excep.getKey());
					match.setHome(tl.getTeam());
					matchesList.add(tl);
				}
				if (away.equals(excep.getValue())) {
					Teams tl = tlRep.findOne((long) excep.getKey());
					match.setAway(tl.getTeam());
					matchesList.add(tl);
				}
			}
		}
		match.setTeams(matchesList);
	}
	
	public void getDates () {
		List <WebElement> date = driver.findElements(By.xpath("//div[contains(@class, 'game--upcoming')]//div[@class='standings__time']"));
		List <WebElement> matchTime = driver.findElements(By.xpath("//div[contains(@class, 'game--upcoming')]//div[@class='standings__starttime']"));
		String [] splitDate;
		dateTemp = new Date();
		for (int i = 0; i < numberOfMatches; i++) {
			matchDate=null;
				try {			
					splitDate=date.get(i).getText().split(" ");
					dayAndMonth=splitDate[1];
					time=matchTime.get(i).getText();		
					year = String.valueOf(dateTemp.getYear()+1900);
					matchDate = sdf.parse(dayAndMonth+ "." + year + "." + time);
					if (matchDate.before(dateTemp)) {
						matchDate.setYear(matchDate.getYear()+1);
					}
				} catch (Exception e) {
					e.printStackTrace();
					mainService.errorReport(bukName, dateTemp, "getDates err");
				}	
				dateList.add(matchDate);
			}
		}
	
	
}


