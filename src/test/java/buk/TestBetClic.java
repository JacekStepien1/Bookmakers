package buk;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import buk.Entities.Matches;

public class TestBetClic {
	
	
	
	public static void main (String args[]) {
		
		File fileUrl = new File("src\\main\\resources\\betclic-ekstraklasa.html");
		Document doc;
		Elements elem1;
		Elements elem2;
		String home;
		String away;
		String date;
		String time;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyHH:mm");
		Date matchDate;
		Date oddsDate;
		double oddsTable[] = new double[3];
		
		try {
			doc = Jsoup.parse(fileUrl, "UTF-8");
//			Connection connection = Jsoup.connect(url);
//			connection.userAgent("Mozilla");
//			connection.timeout(5000);
//			Document doc = connection.get();
			
			elem1 = doc.select(".betBox_match");
			elem2 = doc.select(".betBox_wrapperOdds");

			for (int i=0; i<elem1.size(); i++) {
				
				//get data and time
				date = elem1.get(i).select(".betBox_matchDate").select(".ng-star-inserted").text();
				time = elem1.get(i).select(".betBox_matchDate").select(".betBox_matchDateInfo").text();
				matchDate = sdf.parse(date+time);
				System.out.println(matchDate);
				
				//get teams
				home = elem1.get(i).select(".betBox_contestant").get(0).text();
				away = elem1.get(i).select(".betBox_contestant").get(1).text();
				System.out.println(home);
				System.out.println(away);
				
				//get odds
				for (int y=0; y<3; y++) {
					oddsTable[y] = Double.parseDouble(elem2.get(i).select(".oddValue").get(y).text().replace(",", "."));
					System.out.println(oddsTable[y]);
				}
				
				oddsDate = new Date();
				System.out.println(oddsDate);
				System.out.println();
				
				Matches match = new Matches();
				
				

				
//				String str1 = elem2.get(i).select(".oddValue").get(0).text();
//				System.out.println(str1);
//				elem2 = doc.select(".oddValue");
//				System.out.println(elem2.get(0).size());
//				System.out.println(elem2.get(i).text());
				//String odds = elem1.get(i).select(".oddValue").get(0).text();
				
				
			}
				
			
			
			//elem1 = doc.select(".betBox_wrapperOdds");
			//System.out.println(elem1.get(0).text());
//			elem2 = elem1.select(".oddValue");
//			System.out.println(elem2.get(0).text());
			
			
			
			
			
			
			
			
			
			
	} catch (Exception e) {
		System.err.println("read error: "+ fileUrl);
	}
	}

}
