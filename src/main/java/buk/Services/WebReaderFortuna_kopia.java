package buk.Services;

import buk.Entities.Matches;
import buk.Entities.Odds;
import buk.Entities.Teams;
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WebReaderFortuna_kopia {

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
	Date matchDate;
	Date oddsDate;
	int numberOfMatches;
	int numberOfOdds;
	int value;
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyHH:mm");
	Document doc;
	Elements col3;
	Elements date;
	Elements odds;


//		String url = "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/turcja/1-liga/184/6527/74206/";
//		File fileUrl = new File("F:\\Java\\Eclipse2020\\buk2-building\\src\\main\\resources\\sts-turcja.htm");


	String polandEkstraklasaUrl = "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/ekstraklasa-polska";


	//File turkey1leagueUrl = new File("src\\main\\resources\\sts-turcja.htm");
//	File belarus1leagueUrl = new File("src\\main\\resources\\fortuna-bialorus.html");
//	File polandEkstraklasaUrl = new File("src\\main\\resources\\fortuna-ekstraklasa.html");

	public void matchesReader() throws Exception {

//		matchesReaderStart(belarus1leagueUrl, fortunaTeams.belarus1LeagueFortuna());
		for (Map.Entry<String, TreeMap> link : dataService.fortuna().entrySet()) {
			matchesReaderStart(link.getKey(), link.getValue());
	}

	}


	public void matchesReaderStart(String url, Map league) throws Exception {

		numberOfMatches=0;
		String strTabOdds [];
		numberOfOdds=0;

		try {
			doc = Jsoup.parse(url, "UTF-8");
			numberOfMatches=0;
			Connection connection = Jsoup.connect(url);
			connection.userAgent("Mozilla");
			connection.timeout(5000);
			Document doc = connection.get();
			col3 = doc.select(".market-name");
			date = doc.select(".event-datetime");
//			odds = doc.select(".odds-value");
			// col3 = number of matches in a given league
			numberOfMatches = col3.size();



		} catch (Exception e) {
			System.err.println("read error: "+ url);
		}

		strOdds = odds.text();
		strTabOdds = strOdds.split(" ");
		
		Date getYear = new Date();
		int year = getYear.getYear()+1900;
		
		try {
		
		for (int i = 0; i < numberOfMatches; i++) {
			
			double oddsTable[] = new double[3];
			
			//get date and time
			try {
				yearStr = String.valueOf(year);
				dateTry = date.get(i).text().replaceFirst(" ", yearStr);
			} catch (Exception e) {
				System.err.println("date error");
			}

			// get teams
			teams = col3.get(i).text();
			teams.trim();
			// split teams
			String teamsTab [] = teams.split(" - ");
			
			//get odds
			try {
				for (int x=0; x<3; x++) {
					oddsTable[x]= Double.parseDouble(strTabOdds[numberOfOdds]);
					numberOfOdds++;
				}
			} catch (Exception e) {
				System.err.println("odds error");
			}
			numberOfOdds+=3;
	
			
			Matches match = new Matches();

			// teams comparison, save match
			List<Teams> matchesList = new ArrayList<Teams>();
		
			Iterator<Integer> iterator = league.keySet().iterator();
			value = iterator.next();

			if(teamsTab.length==2) {
				for (int y = value; y <= league.size()+value; y++) {
					if (teamsTab[0].equals(league.get(y))) {
						Teams tl = tlRep.findOne((long) y);
						match.setHome(tl.getTeam());
						matchesList.add(tl);
					}
					if (teamsTab[1].equals(league.get(y))) {
						Teams tl = tlRep.findOne((long) y);
						match.setAway(tl.getTeam());
						matchesList.add(tl);
					}
				}
			}
			
			match.setTeams(matchesList);
			matchDate=null;
			
			try {
				matchDate = sdf.parse(dateTry);
				match.setDateTime(matchDate);
			} catch (Exception e) {
				System.err.println("date error");
			}

			//Matches m = matchesRep.findFirstByDateTimeAndHome(match.getDateTime(), match.getHome());
			Matches m = matchesRep.findFirstByHomeAndAwayAndDateTimeBetween(match.getHome(), match.getAway(), mainService.date1 (match), mainService.date2 (match));
			Odds od = new Odds();
			oddsDate = new Date();
			
			if (m == null) {
				// get odds
				od=null;
				if (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) {
					try {
						od = new Odds();
						od.setHome(oddsTable[0]);
						od.setDraw(oddsTable[1]);
						od.setAway(oddsTable[2]);
						od.setDateTime(oddsDate);
						od.setBuk(buk);
						od.setMatch(match);
						match.setFirstAppeared(buk);
						if (match.getDateTime()!=null && match.getHome()!=null && match.getAway()!=null && mainService.compareDates(match)) {
						matchesRep.save(match);
						oddsRep.save(od);		
						}
					} catch (Exception e) {
						System.err.println("odds error");
					}
				}

			}
			
			else {
				od=null;
				Long l = m.getId();
				if (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) {
					try {
					od = new Odds();
					od.setHome(oddsTable[0]);
					od.setDraw(oddsTable[1]);
					od.setAway(oddsTable[2]);
					od.setMatch(matchesRep.findOne(l));
					od.setDateTime(oddsDate);
					od.setBuk(buk);
					oddsRep.save(od);
					} catch (Exception e) {
						System.err.println("odds error");
					}
				}		
			}
		}
		} catch (Exception e) {
			System.err.println("fortuna err");
		}
		
	}
	
}
