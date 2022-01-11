package buk.Services;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buk.Entities.Matches;
import buk.Entities.Odds;
import buk.Entities.Teams;
import buk.Services.bukTeams.IForBetTeams;
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Service
public class WebReaderIForBet {

	@Autowired
	MatchesRepository matchesRep;
	@Autowired
	TeamsRepository tlRep;
	@Autowired
    OddsRepository oddsRep;
	@Autowired
	DataService dataService;
	@Autowired
	IForBetTeams iForBetTeams;
	@Autowired
	MainService mainService;


	String strOdds;
	String yearStr;
	String buk="IForBet";
	Date matchDate;
	Date oddsDate;
	double oddsTable[] = new double[3];
	int value;
	int numberOfCol;
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyHH:mm");
	Document doc;
	Elements col3;
	Pattern pattern = Pattern.compile("[0-9]{2,3}\\.[0-9]{2}");
	

	

	
	
		String polandEkstraklasaUrl = "https://www.iforbet.pl/oferta/8/29994";
//		File fileUrl = new File("F:\\Java\\Eclipse2020\\buk2-building\\src\\main\\resources\\sts-turcja.htm");

	
	//File turkey1leagueUrl = new File("src\\main\\resources\\sts-turcja.htm");
	//File belarus1leagueUrl = new File("src\\main\\resources\\fortuna-bialorus.html");
	
	
//	File polandEkstraklasaUrl = new File("src\\main\\resources\\iforbet-ekstraklasa.xml");
	
	public void matchesReader() throws Exception {
		

		//matchesReaderStart(belarus1leagueUrl, fortunaTeams.belarus1LeagueFortuna());
		
//		matchesReaderStart(polandEkstraklasaUrl, iForBetTeams.polandEkstraklasaIForBetTeams());
		
		for (Map.Entry<String, TreeMap> link : dataService.iForBet().entrySet()) {
			matchesReaderStart(link.getKey(), link.getValue());
	}
       
		
	}
	

//	public void matchesReaderStart(File fileUrl, Map league) throws Exception {
	public void matchesReaderStart(String url, Map league) throws Exception {
		
		numberOfCol=0;
		
		try {
//			doc = Jsoup.parse(fileUrl, "UTF-8");
			Thread.sleep(mainService.randomNumber2());
			doc = Jsoup.parse(url, "UTF-8");
			numberOfCol=0;
			Connection connection = Jsoup.connect(url);
			connection.userAgent("Mozilla");
			connection.timeout(10000);
			Document doc = connection.get();
			col3 = doc.select(".events-group");
			numberOfCol = col3.size();
			
		} catch (Exception e) {
			System.err.println("read error: "+ url);
		}

			String monthNames [] = new String [] {
					"stycznia", 
					"lutego", 
					"marca", 
					"kwietnia", 
					"maja", 
					"czerwca", 
					"lipca",
					"sierpnia", 
					"września", 
					"października", 
					"listopada", 
					"grudnia"};
			
			String dateDayAndMonth;
			String dateDay;
			String dateMonthNumber=null;
			String dateMonth;
			String dateTime;
			
			try {
			
			for (int i=0; i<col3.size(); i++) {

				//get data
				dateDayAndMonth = col3.get(i).select(".event-start").text();
				dateDayAndMonth = dateDayAndMonth.substring(6);
				dateDay = dateDayAndMonth.replaceAll("[^0123456789]", "");
				String dateSplit [] = dateDayAndMonth.split(" ");
				dateMonth=dateSplit[2];
				for (int y=0; y<12; y++) {
					if (monthNames[y].equals(dateMonth))
						dateMonthNumber = String.valueOf(y+1);
				}
				
				//get year
				Date getYear = new Date();
				int year = getYear.getYear()+1900;
				yearStr = String.valueOf(year);
				
				
				Elements elem = col3.get(i).select(".event-rate");
				Elements elem5 = col3.get(i).select(".event-time");
				int n1=0;
				int n2=0;
				String home;
				String away;
				
				for (int y=0; y<elem.size(); y+=3) {
					
					try {
					//get event time
					dateTime=elem5.get(n2).text();
					n2++;
					
					//set date and time
					matchDate=null;
					matchDate=sdf.parse(dateDay+"."+dateMonthNumber+"." + yearStr+dateTime);
					
					//get odds and teams
					double oddsTable[] = new double[3];

					home=elem.get(n1).selectFirst("span").text();
					strOdds=elem.get(n1).select(".rate-value").text();
					oddsTable[0]=Double.parseDouble(strOdds);
					n1++;
					strOdds=elem.get(n1).select(".rate-value").text();
					oddsTable[1]=Double.parseDouble(strOdds);
					n1++;
					away=elem.get(n1).selectFirst("span").text();
					strOdds=elem.get(n1).select(".rate-value").text();
					oddsTable[2]=Double.parseDouble(strOdds);
					n1++;
					

					
					Matches match = new Matches();
					
					// teams comparison, save match
					List<Teams> matchesList = new ArrayList<Teams>();
				
					Iterator<Integer> iterator = league.keySet().iterator();
					value = iterator.next();

						for (int z = value; z <= league.size()+value; z++) {
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
							for (Map.Entry<Integer, String> excep : iForBetTeams.iForBetTeamsExceptions().entrySet()) {
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
						
						try {
							match.setDateTime(matchDate);
						} catch (Exception e) {
							System.err.println("date error");
						}
						
						Matches m = matchesRep.findFirstByDateTimeAndHome(match.getDateTime(), match.getHome());
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
							Long l = m.getId();
							if (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) {
								try {
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
					}catch (Exception e) {
						e.printStackTrace();
					}	
				}
			}
			} catch (Exception e) {
				System.err.println("iforbet err");
			}
	}
}