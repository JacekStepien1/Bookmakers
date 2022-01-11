package buk;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Service
public class TestWebReaderFortuna {

	@Autowired
	MatchesRepository matchesRep;
	@Autowired
	TeamsRepository tlRep;
	@Autowired
	OddsRepository oddsRep;


	String time;
	String dateTry = "";
	String teams;
	Date oddsDate;
	double oddsTable[] = new double[3];
	int numberOfMatches;
	int value;
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyHH:mm");
	Document doc;
	Elements col3;
	
	
//		String url = "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/turcja/1-liga/184/6527/74206/";
//		File fileUrl = new File("F:\\Java\\Eclipse2020\\buk2-building\\src\\main\\resources\\sts-turcja.htm");

	
	
	
	
	//File turkey1leagueUrl = new File("src\\main\\resources\\sts-turcja.htm");
	File belarus1leagueUrl = new File("src\\main\\resources\\fortuna-bialorus.html");

	public void matchesReader() throws Exception {
		
		matchesReaderStart(belarus1leagueUrl, belarus1LeagueSTS());
	}
	
	public void matchesReaderStart(File fileUrl, Map league) throws Exception {
		
		try {
			doc = Jsoup.parse(fileUrl, "UTF-8");
			numberOfMatches=0;
//			Connection connection = Jsoup.connect(url);
//			connection.userAgent("Mozilla");
//			connection.timeout(5000);
//			Document doc = connection.get();
			col3 = doc.select(".market-name");
			
			// col3 = number of matches in a given league
			numberOfMatches = col3.size();
		} catch (Exception e) {
			System.err.println("read error: "+ fileUrl);
		}

		for (int i = 0; i < numberOfMatches; i++) {

			// get date
//			Elements dat = col3.get(i).select(".date");
//			dateTry = dat.isEmpty() ? dateTry : dat.text().replaceAll("[^.0123456789]", "");
			// get time
//			time = col3.get(i).select(".date_time").text();
			// get teams
			teams = col3.get(i).text();
			System.out.println(teams);
//			teams.trim();
			// remove odds from String
//			teams = teams.replaceAll(" +[0-9]+{1}.[0-9]+{1}", "");
			// split teams
//			String teamsTab [] = teams.split(" X ");
//
//			Matches match = new Matches();
//
//			// save match, compare teams
//			List<Teams> matchesList = new ArrayList<Teams>();
//		
//			Iterator<Integer> iterator = league.keySet().iterator();
//			value = iterator.next();
//
//			if(teamsTab.length==2) {
//				for (int y = value; y <= league.size()+value; y++) {
//					if (teamsTab[0].equals(league.get(y))) {
//						Teams tl = tlRep.findOne((long) y);
//						match.setHome(tl.getTeam());
//						matchesList.add(tl);
//					}
//					if (teamsTab[1].equals(league.get(y))) {
//						Teams tl = tlRep.findOne((long) y);
//						match.setAway(tl.getTeam());
//						matchesList.add(tl);
//					}
//				}
//			}
//			
//			match.setTeams(matchesList);
//			try {
//				Date date = sdf.parse(dateTry + time);
//				match.setDateTime(date);
//			} catch (Exception e) {
//				System.err.println("date error");
//			}
//
//			Matches m = matchesRep.findFirstByDateTimeAndHome(match.getDateTime(), match.getHome());
//			Odds od = new Odds();
//			String odds;
//			oddsDate = new Date();
//			
//			if (m == null) {
//				matchesRep.save(match);
//				
//				// get odds
//				double oddsTable[] = new double[3];
//				for (int x = 0; x < 3; x++) {
//					odds = col3.get(i).select(".subTable").select("span").get(x).text();
//					try {
//						oddsTable[x] = Double.parseDouble(odds);
//						od.setHome(oddsTable[0]);
//						od.setDraw(oddsTable[1]);
//						od.setAway(oddsTable[2]);
//						od.setDateTime(oddsDate);
//						od.setBuk("STS");
//						od.setMatch(match);
//						oddsRep.save(od);
//						
//					} catch (Exception e) {
//						System.err.println("odds error");
//					}
//				}
//			}
//			
//			else {
//				Long l = m.getId();
//				
//				for (int x = 0; x < 3; x++) {
//					odds = col3.get(i).select(".subTable").select("span").get(x).text();
//					try {
//					oddsTable[x] = Double.parseDouble(odds);
//					od.setHome(oddsTable[0]);
//					od.setDraw(oddsTable[1]);
//					od.setAway(oddsTable[2]);
//					od.setMatch(matchesRep.findOne(l));
//					od.setDateTime(oddsDate);
//					od.setBuk("STS");
//					oddsRep.save(od);
//					} catch (Exception e) {
//						System.err.println("odds error");
//					}
//				}			
//			}
		}
	}
	
	public Map<Integer, String> belarus1LeagueSTS() {
		Map <Integer, String> belarus1League = new TreeMap<>();
		belarus1League.put(50, "Slutsk");
		belarus1League.put(51, "Zhodino");//--------------------------------------------------
		belarus1League.put(52, "BATE Borisov");
		belarus1League.put(53, "Energetik BGU");
		belarus1League.put(54, "Isloch Minsk");
		belarus1League.put(55, "S.Soligorsk");
		belarus1League.put(56, "Sl. Mozyr");//--------------------------------------------------
		belarus1League.put(57, "Vitebsk");
		belarus1League.put(58, "Gorodeya");//--------------------------------------------------
		belarus1League.put(59, "Dyn.Brest");
		belarus1League.put(60, "Rukh Brest");
		belarus1League.put(61, "FC Mińsk");//--------------------------------------------------
		belarus1League.put(62, "Dyn.Minsk");
		belarus1League.put(63, "N. Grodno");//--------------------------------------------------
		belarus1League.put(64, "Smolevichy");
		belarus1League.put(65, "Bobrujsk");//--------------------------------------------------
		return belarus1League;
	}

}
