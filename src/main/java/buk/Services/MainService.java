package buk.Services;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buk.Entities.ErrorReports;
import buk.Entities.Matches;
import buk.Entities.Odds;
import buk.Entities.Teams;
import buk.repositories.ErrorReportsRepository;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Service
public class MainService {
	
	@Autowired
	MatchesRepository matchesRep;
	@Autowired
	TeamsRepository tlRep;
	@Autowired
	OddsRepository oddsRep;
	@Autowired
	ErrorReportsRepository errorReportsRep;
	
	Date oddsDate;
	Odds odds;
	String projectPath = System.getProperty("user.dir");
	Calendar calb=Calendar.getInstance();
	Calendar cal=Calendar.getInstance();
	Calendar calCompare;
	Random r = new Random();
	int n=0;
	
	public WebDriver driver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("force-device-scale-factor=0.7");
		chromeOptions.addArguments("window-size=2500,1400");
		chromeOptions.addArguments("high-dpi-support=0.7");

//		// Linux
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver", "/root/drivers/chromedriverLinux/chromedriver");

//		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	// until how many days ahead should read (amount=?)
	public boolean compareDates (Matches match) {
		boolean b;
		calCompare = Calendar.getInstance();
		calCompare.add(Calendar.DAY_OF_MONTH, 60);
		calb.setTime(match.getDateTime());
		b=calb.before(calCompare);
		return b;
	}

	//match date Between date 1 and date 2
	public Date date1 (Matches match) {
		calb.setTime(match.getDateTime());
		calb.add(Calendar.HOUR_OF_DAY, -12);
		Date date1 = calb.getTime();
		return date1;
	}

	//match date Between date 1 and date 2
	public Date date2 (Matches match) {
		calb.setTime(match.getDateTime());
		calb.add(Calendar.HOUR_OF_DAY, 12);
		Date date2 = calb.getTime();
		return date2;
	}

	//match(scores) date Between date 1 and date 2
	public Date dateBetween1 (Date date) {
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		date = cal.getTime();
		return date;
	}
	//match(scores) date Between date 1 and date 2
	public Date dateBetween2 (Date date) {
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		date = cal.getTime();
		return date;
	}

	public void errorReport(String bukName, Date date, String error) {
		ErrorReports errorReports = new ErrorReports();
		errorReports.setBuk(bukName);
		errorReports.setDateTime(date);
		errorReports.setError(error);
		errorReportsRep.save(errorReports);
	}

	public int randomNumber(){
		n = ((r.nextInt(80-20)+20))*100;
		return n;
	}

	public int randomNumber2(){
		n = ((r.nextInt(111-30)+30))*100;
		return n;
	}
	
	public Matches saveMatch (Matches match, Map league, Date matchDate, String home, String away) {
		List<Teams> matchesList = new ArrayList<Teams>();
		Iterator <Integer> x = league.keySet().iterator();
		while (x.hasNext()) {
			int key = x.next();
			if (home.equals(league.get(key))) {
				Teams tl = tlRep.findOne((long) key);
				match.setHome(tl.getTeam());
				matchesList.add(tl);
			}
			if (away.equals(league.get(key))) {
				Teams tl = tlRep.findOne((long) key);
				match.setAway(tl.getTeam());
				matchesList.add(tl);
			}
		}
		match.setTeams(matchesList);
		match.setDateTime(matchDate);
		return match;
	}
	
	public void saveOdds (double oddsTable[], Matches match, Matches m, String buk) {
		odds = new Odds();
		oddsDate = new Date();
		
		if (m != null) {
			try {
				odds.setHome(oddsTable[0]);
				odds.setDraw(oddsTable[1]);
				odds.setAway(oddsTable[2]);
				odds.setDateTime(oddsDate);
				odds.setBuk(buk);
				if (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) {
				odds.setMatch(matchesRep.findOne(m.getId()));
				oddsRep.save(odds);
				}
			} catch (Exception e) {
				System.err.println("odds error");
			}
			
		}
		if (m == null ) {
				try {
					odds.setHome(oddsTable[0]);
					odds.setDraw(oddsTable[1]);
					odds.setAway(oddsTable[2]);
					odds.setDateTime(oddsDate);
					odds.setBuk(buk);
					odds.setMatch(match);
					match.setFirstAppeared(buk);
					if (match.getDateTime()!=null && match.getHome()!=null && match.getAway()!=null && (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) && compareDates(match)) {
					matchesRep.save(match);
					oddsRep.save(odds);
					}
					
				} catch (Exception e) {
					System.err.println("odds error");
				}
		}
	}
	
	

	
	
	

}
