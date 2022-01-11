package buk;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestIforBet {

	
	public static void main(String[] args) {
		String dateTry = "";
		String teams;
		String strOdds;
		String strTabOdds [];
		String yearStr;
		Date matchDate;
		Date oddsDate;
		double oddsTable[] = new double[3];
		int numberOfCol;
		int numberOfOdds=0;
		int value;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyHH:mm");
		Document doc;
		Elements col3;
		Elements date;
		Elements odds;
		
		File fileUrl = new File("src\\main\\resources\\iforbet-ekstraklasa.xml");
		numberOfCol=0;
		
		
		try {
			doc = Jsoup.parse(fileUrl, "UTF-8");
			numberOfCol=0;
//			Connection connection = Jsoup.connect(url);
//			connection.userAgent("Mozilla");
//			connection.timeout(5000);
//			Document doc = connection.get();
			
			col3 = doc.select(".events-group");
			
//			date = doc.select(".event-datetime");
//			odds = doc.select(".odds-value");
			// col3 = number of matches in a given league
			numberOfCol = col3.size();
			//System.out.println(col3.get(0));
			
			System.out.println("");
			System.out.println("col size---------------");
			System.out.println(col3.size());
			System.out.println("");
			
			Element elem1 = col3.get(0);
//			System.out.println("");
//			System.out.println("element 1 z 2 ---------------");
//			System.out.println(elem1);
			
			System.out.println("");
			System.out.println("");
			System.out.println("element 1 z 2 jako tekst---------------");
			System.out.println("");
			System.out.println(elem1.text());
			
			
			Elements elem2 = col3.get(0).select(".event-rate");
			System.out.println("");
			System.out.println("rozmiar col0 rozbity o event-rate ---------------");
			System.out.println("");

			System.out.println(elem2.size());
			
			
			System.out.println("");
			System.out.println("");
			System.out.println("element 1,2,3 z rozbitych 12 czesci ---------------");
			System.out.println("");
			System.out.println(elem2.get(0).text());
			System.out.println(elem2.get(1).text());
			System.out.println(elem2.get(2).text());
			

			System.out.println("");
			System.out.println("");
			System.out.println("event-start ---------------");
			System.out.println("");
			System.out.println(col3.get(0).select(".event-start").text());
			
			
			System.out.println("start ---------------");
			System.out.println("");
			System.out.println("");
			
			
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
			
//			Map<String, Integer> months = new HashMap<>();
//			for (int i=1; i<=12; i++) {
//				months.put(monthNames[i-1], i);
//			}
//			
//			for (Map.Entry<String, Integer> x : months.entrySet()) {
//				System.out.println(x.getKey() + " " + x.getValue());
//			}
			
			System.out.println("");
			System.out.println("");
			
			String dateDayAndMonth;
			String dateDay;
			String dateMonthNumber=null;
			String dateMonth;
			String dateTime;
			
			for (int i=0; i<col3.size(); i++) {

				dateDayAndMonth = col3.get(i).select(".event-start").text();
				System.out.println(dateDayAndMonth);
				dateDayAndMonth = dateDayAndMonth.substring(6);
				System.out.println(dateDayAndMonth);
				dateDay = dateDayAndMonth.replaceAll("[^0123456789]", "");
				System.out.println("dzień :" + dateDay);
				String dateSplit [] = dateDayAndMonth.split(" ");
				dateMonth=dateSplit[2];
				System.out.println(dateMonth);
				for (int y=0; y<12; y++) {
					if (monthNames[y].equals(dateMonth))
						dateMonthNumber = String.valueOf(y+1);
				}
				
				System.out.println(dateMonthNumber);
				
				Date getYear = new Date();
				int year = getYear.getYear()+1900;
				yearStr = String.valueOf(year);
				
				System.out.println(dateDay+"."+dateMonthNumber+"." + yearStr);
				System.out.println("");
				
				Elements elem = col3.get(i).select(".event-rate");
				Elements elem5 = col3.get(i).select(".event-time");
				int n1=0;
				int n2=0;
				String home;
				String away;
				
				for (int y=0; y<elem.size(); y+=3) {
					
					oddsDate = new Date();
					dateTime=elem5.get(n2).text();
					n2++;
					matchDate=sdf.parse(dateDay+"."+dateMonthNumber+"." + yearStr+dateTime);
					System.out.println(matchDate);
					
					
					home=elem.get(n1).text();
					strOdds=home.substring(home.length()-4, home.length());
					oddsTable[0]=Double.parseDouble(strOdds);
					home=home.substring(0, home.length()-4);
					System.out.println(home);
					System.out.println(oddsTable[0]);
					n1++;
					
					strOdds=elem.get(n1).text();
					strOdds=strOdds.replace("X", "");
					oddsTable[1]=Double.parseDouble(strOdds);
					System.out.println(oddsTable[1]);
					n1++;
					
					away=elem.get(n1).text();
					strOdds=away.substring(away.length()-4, away.length());
					oddsTable[2]=Double.parseDouble(strOdds);
					away=away.substring(0, away.length()-4);
					System.out.println(oddsTable[2]);
					System.out.println(away);
					System.out.println(oddsDate);
					n1++;
				}
				
			}
			
			
			System.out.println("");
			System.out.println("");
			
			
//			String name = "Jacek toast 23 KRaków";
//			name = name.substring(9);
//			String name2 = name.substring(9);
//			System.out.println(name);
			
			
			
			
			
		} catch (Exception e) {
			System.err.println("read error: "+ fileUrl);
		}
		


	}

}
