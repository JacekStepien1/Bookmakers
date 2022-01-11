package buk.Services;

import buk.Entities.Country;
import buk.Entities.Matches;
import buk.Entities.Odds;
import buk.Entities.Teams;
import buk.Services.bukTeams.TeamGenerator;
import buk.data.DataService;
import buk.repositories.CountryRepository;
import buk.repositories.MatchesRepository;
import buk.repositories.OddsRepository;
import buk.repositories.TeamsRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Test {
    @Autowired
    MainService mainService;
    @Autowired
    MatchesRepository matchesRep;
    @Autowired
    TeamsRepository tlRep;
    @Autowired
    DataService dataService;
    @Autowired
    OddsRepository oddsRepository;
    @Autowired
    CountryRepository countryRep;
    @Autowired
    TeamsRepository teamsRep;
    @Autowired
    TeamGenerator teamGenerator;



    String dayAndMonth, year, time;
    String bukName = "Betfan";


    double oddsTable[] = new double[3];

    List<WebElement> allMatches;

    int numberOfMatches;

    WebDriver driver;
    Pattern pattern = Pattern.compile(" [0-9]{1,2}-[0-9]{1,2} ");
    Matcher matcher;
    String home, away, match, score, matchTab1[], matchTab2[], scoreTab[];
    int homeScore, awayScore;

//    public void matchesReader(WebDriver driver, String url) throws Exception {
//        this.driver=driver;
//            matchesReaderStart(url);
//        }

    public void matchesReader(WebDriver driver) throws Exception {
        this.driver = driver;
//        for (Map.Entry<String, TreeMap> link : dataService.scores().entrySet()) {
//            matchesReaderStart(link.getKey(), link.getValue());
//      matchesReaderStart();
//        }

    matchesReaderStart();
    }


//        public void matchesReaderStart (String url, TreeMap league) {
        public void matchesReaderStart () {
        try {
//            createMatches();
//            createMatches2();
//            createMatches3();
//            createMatches4();
//            updateCountryId();
//            driver.get(url);
//          waitUntill();
//            List<WebElement> allMatches = driver.findElements(By.xpath("//div[@class='title-container']"));
//            numberOfMatches = allMatches.size();
//            this.allMatches=allMatches;

        } catch (Exception e) {
        }

//        System.out.println(allMatches.size());
//        readMatches();
    }


    public void createMatches4 () {
        String teamList[] = new String [] {"Manchester Utd", "Manchester City", "Leicester", "Liverpool", "Tottenham", "Everton", "West Ham",
                "Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds", "Crystal Palace", "Wolverhampton", "Newcastle", "Burnley"
                , "Brighton", "Norwich", "Watford", "Brentford"};

        		String teamListold[] = new String [] {"Manchester United", "Manchester City", "Leicester City", "Liverpool", "Tottenham Hotspur", "Everton", "West Ham United",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds United", "Crystal Palace", "Wolverhampton", "Newcastle United", "Burnley"
				, "Brighton", "Norwich", "Watford", "Brentford"};



        List<Matches> allMatches = matchesRep.findAll();
        for (int i=0; i<allMatches.size(); i++){
                for (int y=0; y<teamList.length; y++){
                    if (allMatches.get(i).getHome().equals(teamListold[y]))
                        allMatches.get(i).setHome(teamList[y]);
                    matchesRep.save(allMatches.get(i));
                }
                for (int y=0; y<teamList.length; y++){
                    if (allMatches.get(i).getAway().equals(teamListold[y]))
                        allMatches.get(i).setAway(teamList[y]);
                         matchesRep.save(allMatches.get(i));
                }
            }
        }





    public void updateCountryId(){
//        Teams t1 = new Teams();
//        Country countryPl = countryRep.findOne(100L);
//        countryPl.setId(950L);
//        countryRep.save(countryPl);
//        countryRep.delete(100L);




//        for(int i=0; i<18; i++){
//            Teams teams = teamsRep.findOne((i+1001L));
//            Country c1 = countryRep.findOne(950L);
//            teams.setCountry(c1);
//            teamsRep.save(teams);
//        }

//        for (int i=0; i<27; i++){
//            Matches m = matchesRep.findOne((i+1L));
//            m.se
//        }


    }

    public void createMatches3 (){

        Matches [] mtab = new Matches[1];
        Calendar cal = Calendar.getInstance();
        cal.set(2022,01,01,13,30);
        Teams t3 = tlRep.findOne(2011L);
        for (int i=0; i<mtab.length; i++){
            mtab[i] = new Matches();
            Teams t1 = tlRep.findOne(2009L);
            Teams t2 = tlRep.findOne(2001L);
            List<Teams> matchesList = new ArrayList<Teams>();
            mtab[i].setHome(t1.getTeam());
            mtab[i].setAway(t2.getTeam());
            matchesList.add(t1);
            mtab[i].setTeams(matchesList);
            Date date = cal.getTime();
            mtab[i].setDateTime(date);
            matchesRep.save(mtab[i]);

        }
        double d=2.00;
        for (int z=0; z<500; z++) {
//           d+=0.01;
            cal.add(Calendar.MINUTE,+4);
            Date date1 = cal.getTime();
            Odds odds = new Odds();
            d+=0.01;
            odds.setHome(d);
            odds.setDraw(3.00);
            odds.setAway(4.00);
            odds.setBuk("Fortuna");
            odds.setMatch(mtab[0]);
            odds.setDateTime(date1);
            oddsRepository.save(odds);
        }

    }

    public void createMatches2 (){

        Matches [] mtab = new Matches[1];
        Calendar cal = Calendar.getInstance();
        cal.set(2022,00,01,13,30);
        Teams t3 = tlRep.findOne(2011L);
        for (int i=0; i<mtab.length; i++){
            mtab[i] = new Matches();
            Teams t1 = tlRep.findOne(2009L);
            Teams t2 = tlRep.findOne(2001L);
            List<Teams> matchesList = new ArrayList<Teams>();
            mtab[i].setHome(t1.getTeam());
            mtab[i].setAway(t2.getTeam());
            matchesList.add(t1);
            mtab[i].setTeams(matchesList);
            Date date = cal.getTime();
            mtab[i].setDateTime(date);
            matchesRep.save(mtab[i]);

            mtab[i] = new Matches();
            t1 = tlRep.findOne(2000L);
            t2 = tlRep.findOne(2013L);
            matchesList.clear();
            mtab[i].setHome(t1.getTeam());
            mtab[i].setAway(t2.getTeam());
            matchesList.add(t1);
            mtab[i].setTeams(matchesList);
            cal.set(2022,00,03,18,30);
            date = cal.getTime();
            mtab[i].setDateTime(date);
            matchesRep.save(mtab[i]);

            mtab[i] = new Matches();
            t1 = tlRep.findOne(2000L);
            t2 = tlRep.findOne(2013L);
            matchesList.clear();
            mtab[i].setHome(t1.getTeam());
            mtab[i].setAway(t2.getTeam());
            matchesList.add(t1);
            mtab[i].setTeams(matchesList);
            cal.set(2022,01,03,18,30);
            date = cal.getTime();
            mtab[i].setDateTime(date);
            matchesRep.save(mtab[i]);

            mtab[i] = new Matches();
            t1 = tlRep.findOne(5001L);
            t2 = tlRep.findOne(5014L);
            matchesList.clear();
            mtab[i].setHome(t1.getTeam());
            mtab[i].setAway(t2.getTeam());
            matchesList.add(t1);
            mtab[i].setTeams(matchesList);
            cal.set(2021,11,18,15,30);
            date = cal.getTime();
            mtab[i].setDateTime(date);
            matchesRep.save(mtab[i]);

            mtab[i] = new Matches();
            t1 = tlRep.findOne(5001L);
            t2 = tlRep.findOne(5014L);
            matchesList.clear();
            mtab[i].setHome(t1.getTeam());
            mtab[i].setAway(t2.getTeam());
            matchesList.add(t1);
            mtab[i].setTeams(matchesList);
            cal.set(2023,00,1,15,30);
            date = cal.getTime();
            mtab[i].setDateTime(date);
            matchesRep.save(mtab[i]);

        }
//        double d=2;
//        for (int z=0; z<50; z++) {
//            d+=0.1;
//            cal.add(Calendar.DAY_OF_YEAR,+1);
//            cal.add(Calendar.MINUTE,+9);
//            Date date1 = cal.getTime();
//            Odds odds = new Odds();
//            odds.setHome(d);
//            odds.setDraw(3.00);
//            odds.setAway(4.00);
//            odds.setBuk("Fortuna");
//            odds.setMatch(mtab[0]);
//            odds.setDateTime(date1);
//            oddsRepository.save(odds);
//        }

    }

    public void createMatches (){

        Matches [] mtab = new Matches[8];
        Calendar cal = Calendar.getInstance();
        Teams t3 = tlRep.findOne(2011L);
        for (int i=0; i<7; i++){

        mtab[i] = new Matches();
        Teams t12 = tlRep.findOne(2005L);
        Teams t2 = tlRep.findOne(2003L);
        List<Teams> matchesList = new ArrayList<Teams>();
        mtab[i].setHome(t12.getTeam());
        mtab[i].setAway(t2.getTeam());
            if (i==2){
                mtab[i].setAway(t3.getTeam());;
            }
        matchesList.add(t12);
        matchesList.add(t2);
            if (i==2){
                matchesList.remove(t2);
                matchesList.add(t3);
            }

        mtab[i].setTeams(matchesList);

        cal.add(Calendar.DAY_OF_YEAR,-1);
        Date date = cal.getTime();
        mtab[i].setDateTime(date);
        mtab[i].setScoreHome(i);
        mtab[i].setScoreAway(i+1);
        if(i==0){
            Calendar cal2 = Calendar.getInstance();
            cal2.set(2022,1,4,18,40);
            Date date2 = new Date();
            date2=cal2.getTime();
            mtab[i].setDateTime(date2);
        }
        if (i==3){
            mtab[i].setScoreHome(3);
            mtab[i].setScoreAway(1);
        }
            if (i==1){
                mtab[i].setScoreHome(2);
                mtab[i].setScoreAway(2);
            }
        matchesRep.save(mtab[i]);


        }
            double d=2;
        for (int z=0; z<50; z++) {
            d+=0.1;
            cal.add(Calendar.DAY_OF_YEAR,+1);
            cal.add(Calendar.MINUTE,+9);
            Date date1 = cal.getTime();
            Odds odds = new Odds();
            odds.setHome(d);
            odds.setDraw(3.00);
            odds.setAway(4.00);
            odds.setBuk("Fortuna");
            odds.setMatch(mtab[0]);
            odds.setDateTime(date1);
            oddsRepository.save(odds);
        }



//        Calendar calbet1 = Calendar.getInstance();
//        Calendar calebet2 = Calendar.getInstance();
//        calbet1.add(Calendar.DAY_OF_YEAR, -1);
//        calbet1.add(Calendar.HOUR_OF_DAY,-24);
//        calebet2.add(Calendar.DAY_OF_YEAR,-1);
//        calebet2.add(Calendar.HOUR_OF_DAY,24);
//        Date dat1 = calbet1.getTime();
//        Date dat2 = calebet2.getTime();
//
//        Matches match2 = matchesRep.findFirstByHomeAndAwayAndDateTimeBetween("Everton", "Liverpool", dat1, dat2);
//        System.out.println(match2.getHome());
    }

    public void readMatches () {
        for (int i=0; i<allMatches.size(); i++){
//        for (int i=0; i<3; i++){
            try {

        matchTab1 = allMatches.get(i).getText().split("\\n");
        matchTab2 = pattern.split(matchTab1[0]);
        home = matchTab2[0];
        away = matchTab2[1];
        matcher = pattern.matcher(matchTab1[0]);
        matcher.find();
        score = matcher.group(0);
        score.trim();
        scoreTab = score.split("-");
        homeScore = Integer.valueOf(scoreTab[0].trim());
        awayScore = Integer.valueOf(scoreTab[1].trim());

        System.out.println(home + " - " + away + " score: " + homeScore+":"+awayScore);

        Calendar calbet1 = Calendar.getInstance();
        Calendar calebet2 = Calendar.getInstance();
        calbet1.add(Calendar.DAY_OF_YEAR, -1);
        calbet1.add(Calendar.HOUR_OF_DAY,-24);
        calebet2.add(Calendar.DAY_OF_YEAR,-1);
        calebet2.add(Calendar.HOUR_OF_DAY,24);
        Date dat1 = calbet1.getTime();
        Date dat2 = calebet2.getTime();

        Integer temp = null;

//        Matches m = matchesRep.findFirstByHomeAndAwayAndDateTimeBetween(home, away, dat1, dat2 );
        Matches m = matchesRep.findFirstByHomeAndAwayAndDateTimeBetweenAndScoreHome(home, away, dat1, dat2, temp);

        if (m!=null){
            m.setScoreHome(homeScore);
            m.setScoreAway(awayScore);
            matchesRep.save(m);
        }



            } catch (Exception e) {

            }

        }








    }



//        public void waitUntill() {
//            try {
//                WebDriverWait wait = new WebDriverWait(driver, 15);
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='game']")));
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='time']")));
//            }
//            catch  (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }