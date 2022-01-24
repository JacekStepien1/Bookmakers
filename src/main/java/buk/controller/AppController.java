package buk.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import buk.Entities.Country;
import buk.Entities.Matches;
import buk.Entities.Odds;
import buk.Entities.Teams;
import buk.data.DataService;
import buk.repositories.CountryRepository;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Controller
public class AppController {

	@Autowired
	MatchesRepository matchRep;
	@Autowired
	TeamsRepository TRep;
	@Autowired
	CountryRepository countryRep;
	@Autowired
	OddsRepository oddsRep;
	@Autowired
	DataService dataService;



	//	String [] bukListString = new String [] {"BetClic", "Betfan", "BetX", "Etoto", "Ewinner", "Fortuna", "IForBet", "LvBet", "NobleBet", "PZBuk", "STS", "SuperBet", "Totalbet", "Totolotek"};
	String [] bukListString = new String [] {"BetClic", "Betfan", "BetX", "Etoto", "Ewinner", "Fortuna", "IForBet", "LvBet", "NobleBet", "PZBuk", "STS", "SuperBet", "Totalbet"};
	List <String> bukLinks;

	@RequestMapping("/index/{leauge}")
	public String index (@PathVariable(name="leauge") String leauge, Model model, Device device)  {
		List<Country> countryList = countryRep.findAll();
		String leagueName = countryRep.league(leauge);
		Date date = new Date();
		List <Matches> m = matchRep.distinctMatches(leauge, date);
		List <Odds> oddsList= new ArrayList<>();
		for (int i=0; i<m.size(); i++) {
			m.get(i).setOdds(oddsList);
		}
		for (int i=0; i<m.size(); i++) {
			oddsList = new ArrayList<>();
			for (int y=0; y<bukListString.length; y++) {
				Odds odds = oddsRep.findFirstByBukAndMatchIdOrderByDateTimeDesc(bukListString[y], m.get(i).getId());
				if (odds==null)
					odds = new Odds();
				oddsList.add(odds);
			}
			m.get(i).setOdds(oddsList);
		}
		List <Odds> highestOdds = new ArrayList<>();
		for (int i=0; i<m.size(); i++) {
			double dHome=0;
			double dDraw=0;
			double dAway=0;
			for (int y=0; y<m.get(i).getOdds().size(); y++) {
				if (dHome<m.get(i).getOdds().get(y).getHome())
					dHome = m.get(i).getOdds().get(y).getHome();
				if (dDraw<m.get(i).getOdds().get(y).getDraw())
					dDraw = m.get(i).getOdds().get(y).getDraw();
				if (dAway<m.get(i).getOdds().get(y).getAway())
					dAway = m.get(i).getOdds().get(y).getAway();
			}
			Odds odd=new Odds();
			odd.setHome(dHome);
			odd.setDraw(dDraw);
			odd.setAway(dAway);
			highestOdds.add(odd);
		}
		bukLinks = new ArrayList<>();
		bukLinks.add(dataService.betClicLinks.get(leauge));
		bukLinks.add(dataService.betFanLinks.get(leauge));
		bukLinks.add(dataService.betXLinks.get(leauge));
		bukLinks.add(dataService.eTotoLinks.get(leauge));
		bukLinks.add(dataService.eWinnerLinks.get(leauge));
		bukLinks.add(dataService.fortunaLinks.get(leauge));
		bukLinks.add(dataService.iForBetLinks.get(leauge));
		bukLinks.add(dataService.lvBetLinks.get(leauge));
		bukLinks.add(dataService.noblebetLinks.get(leauge));
		bukLinks.add(dataService.pzBukLinks.get(leauge));
		bukLinks.add(dataService.stsLinks.get(leauge));
		bukLinks.add(dataService.superbetLinks.get(leauge));
		bukLinks.add(dataService.totalbetLinks.get(leauge));
//		bukLinks.add(dataService.totolotekLinks.get(leauge));

		// charts (x10)
		double [][] d = new double [10][3];
		for (int i=0; i<10 && i<m.size(); i++) {
			for (int y=0; y<bukListString.length; y++) {
				if (m.get(i).getOdds().get(y).getHome() != 0.00) {
					double a1 = 100/m.get(i).getOdds().get(y).getHome();
					double a2 = 100/m.get(i).getOdds().get(y).getDraw();
					double a3 = 100/m.get(i).getOdds().get(y).getAway();
					double aSum = 100/(a1+a2+a3);
					d[i][0]=a1*aSum;
					d[i][1]=a2*aSum;
					d[i][2]=a3*aSum;
					String s1 = String.format("%.1f", d[i][0]);
					String s2 = String.format("%.1f", d[i][1]);
					String s3 = String.format("%.1f", d[i][2]);
					s1=s1.replace(",", ".");
					s2=s2.replace(",", ".");
					s3=s3.replace(",", ".");
					d[i][0]=Double.valueOf(s1);
					d[i][1]=Double.valueOf(s2);
					d[i][2]=Double.valueOf(s3);
					break;
				}
			}
		}

		// last 5 matches on each teams
		Matches lastMatches [][] = new Matches[m.size()][10];
		Date date1 = new Date();
		for (int i=0; i<m.size(); i++){
			for (int y=0; y<10; y++){
				lastMatches[i][y] = new Matches();
			}
		}
		for (int i=0; i<m.size(); i++){
			List<Matches> mList1 = matchRep.findTop5ByDateTimeBeforeAndHomeAndScoreHomeNotNullOrDateTimeBeforeAndAwayAndScoreHomeNotNullOrderByDateTimeDesc(date1, m.get(i).getHome(), date1, m.get(i).getHome());
			List<Matches> mList2 = matchRep.findTop5ByDateTimeBeforeAndHomeAndScoreHomeNotNullOrDateTimeBeforeAndAwayAndScoreHomeNotNullOrderByDateTimeDesc(date1, m.get(i).getAway(), date1, m.get(i).getAway());
			for (int y=0; y<5 && y<mList1.size(); y++){
				lastMatches[i][y] = mList1.get(y);
			}
			for (int y=0; y<5 && y<mList2.size(); y++){
				lastMatches[i][y+5] = mList2.get(y);
			}
		}
		model.addAttribute("lm", lastMatches);
		model.addAttribute("d", d);
		model.addAttribute("bukLinks", bukLinks);
		model.addAttribute("matches", m);
		model.addAttribute("bukList", bukListString);
		model.addAttribute("odds", oddsList);
		model.addAttribute("highestOdds", highestOdds);
		model.addAttribute("country", countryList);
		model.addAttribute("leagueName", leagueName);
		if (device.isMobile())
			return "m.index";
		if (device.isTablet())
			return "m.index";
		if (device.isNormal())
			return "index";
		else
			return "index";
	}

	@RequestMapping("matchdetails/{id}/{buk}")
	public String matchdetails(@PathVariable(name="id") Long id, @PathVariable(name="buk") String buk, Model model, Device device) {
		Matches matches = matchRep.findOne(id);
		List <Odds> oddsListDesc = oddsRep.findByMatchIdAndBukOrderByDateTimeDesc(id, buk);
		model.addAttribute("country", matches.getTeams().get(0).getCountry().getCountry());
		matches.setOdds(oddsListDesc);
		model.addAttribute("m", matches);
		Object [][] ob = dataTable(oddsListDesc);
		model.addAttribute("ob", ob);
		if (device.isMobile())
			return "mobilematchdetails";
		if (device.isTablet())
			return "mobilematchdetails";
		if (device.isNormal())
			return "matchdetails";
		else
			return "matchdetails";
	}

	public Object [][] dataTable (List <Odds> oddsListDesc){
		List<Odds> oddsList = oddsListDesc.stream()
				.sorted(Comparator.comparing(Odds::getDateTime))
				.collect(Collectors.toList());
		int div = 15;
		int size3=oddsList.size()-1;
		int size = oddsList.size();
		double divDouble=div;
		double sizeDouble1 = oddsList.size();
		double sizeDouble2 = sizeDouble1/divDouble;
// 		if integer div=10 -->
//		if(oddsList.size()<16 && oddsList.size()>9)
//			sizeDouble2=sizeDouble2-sizeDouble2%1;
		if(oddsList.size()<15)
			sizeDouble2=sizeDouble2+1-sizeDouble2%1;
		double sizeDouble3 = sizeDouble2;
		if(oddsList.size()<16)
			div = oddsList.size()-1;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM(HH:mm)");
		Object [][] ob = new Object [div+2][4];
		ob[0][0] = "Date";
		ob[0][1] = "1";
		ob[0][2] = "X";
		ob[0][3] = "2";
		ob[1][0] = sdf.format(oddsList.get(0).getDateTime());
		ob[1][1] = oddsList.get(0).getHome();
		ob[1][2] = oddsList.get(0).getDraw();
		ob[1][3] = oddsList.get(0).getAway();

		for (int i=2; i<=div; i++) {
			if(sizeDouble2%1>=0.5)
				size = (int)sizeDouble2+1;
			else
				size = (int)sizeDouble2;

			ob[i][0] = sdf.format(oddsList.get(size).getDateTime());
			ob[i][1] = oddsList.get(size).getHome();
			ob[i][2] = oddsList.get(size).getDraw();
			ob[i][3] = oddsList.get(size).getAway();
			sizeDouble2+=sizeDouble3;
		}
		ob[div+1][0] = sdf.format(oddsList.get(size3).getDateTime());
		ob[div+1][1] = oddsList.get(size3).getHome();
		ob[div+1][2] = oddsList.get(size3).getDraw();
		ob[div+1][3] = oddsList.get(size3).getAway();
		return ob;
	}

	@RequestMapping("delete/{id}")
	public String delete(@PathVariable(name="id") Long id, Model model) {
		matchRep.delete(id);
		return "delete";
	}

//	@RequestMapping("matchdetails/{id}")
//	public String mdetails(@PathVariable(name="id") Long id, Model model) {
//		Matches matches = matchRep.findOne(id);
//		List <Odds> oddsList = new ArrayList<>();
//		oddsList=oddsRep.findByMatchIdOrderByDateTimeDesc(id);
//		matches.setOdds(oddsList);
//		model.addAttribute("matches", matches);
//		return "matchdetails";
//	}

//	@RequestMapping("delete/{id}/{id2}")
//	public String delete2(@PathVariable(name="id") long id, @PathVariable(name="id2") long id2, Model model) {
//		for (long i=id; i<=id2; i++) {
//			if (matchRep.findOne(i)!=null) {
//			matchRep.delete((long) i);
//			System.out.println("delete :" + i);
//			}
//		}
//		return "delete";
//	}

//	@RequestMapping("deleteodds/{id}/{id2}")
//	public String deleteOdds(@PathVariable(name="id") long id, @PathVariable(name="id2") long id2, Model model) {
//		for (long i=id; i<=id2; i++) {
//			if (oddsRep.findOne(i)!=null) {
//				oddsRep.delete((long) i);
//			System.out.println("delete :" + i);
//			}
//		}
//		return "delete";
//	}

	@RequestMapping("")
	public String main (Model model, Device device )  {
		String leauge ="poland";
		List<Country> countryList = countryRep.findAll();
		String leagueName = countryRep.league(leauge);
		Date date = new Date();
		List <Matches> m = matchRep.distinctMatches(leauge, date);
		List <Odds> oddsList= new ArrayList<>();
		for (int i=0; i<m.size(); i++) {
			m.get(i).setOdds(oddsList);
		}
		for (int i=0; i<m.size(); i++) {
			oddsList = new ArrayList<>();
			for (int y=0; y<bukListString.length; y++) {
				Odds odds = oddsRep.findFirstByBukAndMatchIdOrderByDateTimeDesc(bukListString[y], m.get(i).getId());
				if (odds==null)
					odds = new Odds();
				oddsList.add(odds);
			}
			m.get(i).setOdds(oddsList);
		}
		List <Odds> highestOdds = new ArrayList<>();
		for (int i=0; i<m.size(); i++) {
			double dHome=0;
			double dDraw=0;
			double dAway=0;
			for (int y=0; y<m.get(i).getOdds().size(); y++) {
				if (dHome<m.get(i).getOdds().get(y).getHome())
					dHome = m.get(i).getOdds().get(y).getHome();
				if (dDraw<m.get(i).getOdds().get(y).getDraw())
					dDraw = m.get(i).getOdds().get(y).getDraw();
				if (dAway<m.get(i).getOdds().get(y).getAway())
					dAway = m.get(i).getOdds().get(y).getAway();
			}
			Odds odd=new Odds();
			odd.setHome(dHome);
			odd.setDraw(dDraw);
			odd.setAway(dAway);
			highestOdds.add(odd);
		}

		bukLinks = new ArrayList<>();
		bukLinks.add(dataService.betClicLinks.get(leauge));
		bukLinks.add(dataService.betFanLinks.get(leauge));
		bukLinks.add(dataService.betXLinks.get(leauge));
		bukLinks.add(dataService.eTotoLinks.get(leauge));
		bukLinks.add(dataService.eWinnerLinks.get(leauge));
		bukLinks.add(dataService.fortunaLinks.get(leauge));
		bukLinks.add(dataService.iForBetLinks.get(leauge));
		bukLinks.add(dataService.lvBetLinks.get(leauge));
		bukLinks.add(dataService.noblebetLinks.get(leauge));
		bukLinks.add(dataService.pzBukLinks.get(leauge));
		bukLinks.add(dataService.stsLinks.get(leauge));
		bukLinks.add(dataService.superbetLinks.get(leauge));
		bukLinks.add(dataService.totalbetLinks.get(leauge));
//		bukLinks.add(dataService.totolotekLinks.get(leauge));

		// charts (x10)
		double [][] d = new double [10][3];
		for (int i=0; i<10 && i<m.size(); i++) {
			for (int y=0; y<bukListString.length; y++) {
				if (m.get(i).getOdds().get(y).getHome() != 0.00) {
					double a1 = 100/m.get(i).getOdds().get(y).getHome();
					double a2 = 100/m.get(i).getOdds().get(y).getDraw();
					double a3 = 100/m.get(i).getOdds().get(y).getAway();
					double aSum = 100/(a1+a2+a3);
					d[i][0]=a1*aSum;
					d[i][1]=a2*aSum;
					d[i][2]=a3*aSum;
					String s1 = String.format("%.1f", d[i][0]);
					String s2 = String.format("%.1f", d[i][1]);
					String s3 = String.format("%.1f", d[i][2]);
					s1=s1.replace(",", ".");
					s2=s2.replace(",", ".");
					s3=s3.replace(",", ".");
					d[i][0]=Double.valueOf(s1);
					d[i][1]=Double.valueOf(s2);
					d[i][2]=Double.valueOf(s3);
					break;
				}
			}
		}

		// last 5 matches on each teams
		Matches lastMatches [][] = new Matches[m.size()][10];
		Date date1 = new Date();
		for (int i=0; i<m.size(); i++){
			for (int y=0; y<10; y++){
				lastMatches[i][y] = new Matches();
			}
		}
		for (int i=0; i<m.size(); i++){
			List<Matches> mList1 = matchRep.findTop5ByDateTimeBeforeAndHomeAndScoreHomeNotNullOrDateTimeBeforeAndAwayAndScoreHomeNotNullOrderByDateTimeDesc(date1, m.get(i).getHome(), date1, m.get(i).getHome());
			List<Matches> mList2 = matchRep.findTop5ByDateTimeBeforeAndHomeAndScoreHomeNotNullOrDateTimeBeforeAndAwayAndScoreHomeNotNullOrderByDateTimeDesc(date1, m.get(i).getAway(), date1, m.get(i).getAway());
			for (int y=0; y<5 && y<mList1.size(); y++){
				lastMatches[i][y] = mList1.get(y);
			}
			for (int y=0; y<5 && y<mList2.size(); y++){
				lastMatches[i][y+5] = mList2.get(y);
			}
		}

		model.addAttribute("lm", lastMatches);
		model.addAttribute("d", d);
		model.addAttribute("bukLinks", bukLinks);
		model.addAttribute("matches", m);
		model.addAttribute("bukList", bukListString);
		model.addAttribute("odds", oddsList);
		model.addAttribute("highestOdds", highestOdds);
		model.addAttribute("country", countryList);
		model.addAttribute("leagueName", leagueName);
		if (device.isMobile())
			return "m.index";
		if (device.isTablet())
			return "m.index";
		if (device.isNormal())
			return "index";
		else
			return "index";
	}


}
