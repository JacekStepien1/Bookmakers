package buk.Services;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buk.Entities.Matches;
import buk.Entities.Odds;
import buk.Entities.Teams;
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;


@Service
public class WebReaderSTS {

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


    String time;
    String dateTry = "";
    String teams;
    Date oddsDate;
    double oddsTable[];
    int numberOfMatches;
    int value;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyHH:mm");
    Document doc;
    Elements col3;
    String buk = "STS";

    public void matchesReader() throws Exception {
        for (Map.Entry<String, TreeMap> link : dataService.sts().entrySet()) {
            matchesReaderStart(link.getKey(), link.getValue());
        }
    }

    public void matchesReaderStart(String url, Map league) throws Exception {
        numberOfMatches = 0;
        try {
            Thread.sleep(mainService.randomNumber2());
            doc = Jsoup.parse(url, "UTF-8");
            numberOfMatches = 0;
            Connection connection = Jsoup.connect(url);
            connection.userAgent("Mozilla");
            connection.timeout(10000);
            Document doc = connection.get();
            col3 = doc.select(".col3");
            numberOfMatches = col3.size();
        } catch (Exception e) {
            System.err.println("read error: " + url);
        }

        try {

            for (int i = 0; i < numberOfMatches; i++) {

                // get date
                Elements dat = col3.get(i).select(".date");
                dateTry = dat.isEmpty() ? dateTry : dat.text().replaceAll("[^.0123456789]", "");
                // get time
                time = col3.get(i).select(".date_time").text();
                // get teams
                teams = col3.get(i).select(".subTable").select("td").text();
                teams.trim();
                // remove odds from String
                teams = teams.replaceAll(" +[0-9]+{1}.[0-9]+{1}", "");
                // split teams
                String teamsTab[] = teams.split(" [xX] ");

                Matches match = new Matches();

                // teams comparison, save match
                List<Teams> matchesList = new ArrayList<Teams>();
                Iterator<Integer> iterator = league.keySet().iterator();
                value = iterator.next();

                if (teamsTab.length == 2) {
                    for (int y = value; y <= league.size() + value; y++) {
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
                    match.setTeams(matchesList);
                }

                Date date = null;
                try {
                    date = sdf.parse(dateTry + time);
                    match.setDateTime(date);
                } catch (Exception e) {
                    System.err.println("date error");
                    break;
                }

                Matches m = matchesRep.findFirstByDateTimeAndHome(match.getDateTime(), match.getHome());
                Odds od = null;
                String odds;
                oddsDate = new Date();
                oddsTable = new double[3];

                if (m == null) {

                    // get odds
                    for (int x = 0; x < 3; x++) {
                        odds = col3.get(i).select(".subTable").select("span").get(x).text();
                        try {
                            oddsTable[x] = Double.parseDouble(odds);
                        } catch (Exception e) {
                            System.err.println("odds error");
                        }
                    }
                    od = null;
                    if (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) {
                        od = new Odds();
                        od.setHome(oddsTable[0]);
                        od.setDraw(oddsTable[1]);
                        od.setAway(oddsTable[2]);
                        od.setDateTime(oddsDate);
                        od.setBuk(buk);
                        od.setMatch(match);
                        match.setFirstAppeared(buk);
                        if (match.getDateTime() != null && match.getHome() != null && match.getAway() != null && mainService.compareDates(match)) {
                            matchesRep.save(match);
                            oddsRep.save(od);
                        }
                    }
                } else {
                    Long l = m.getId();

                    for (int x = 0; x < 3; x++) {
                        odds = col3.get(i).select(".subTable").select("span").get(x).text();
                        try {
                            oddsTable[x] = Double.parseDouble(odds);
                        } catch (Exception e) {
                            System.err.println("odds error");
                        }
                    }
                    od = null;
                    if (oddsTable[0] + oddsTable[1] + oddsTable[2] > 7.5) {
                        od = new Odds();
                        od.setHome(oddsTable[0]);
                        od.setDraw(oddsTable[1]);
                        od.setAway(oddsTable[2]);
                        od.setMatch(matchesRep.findOne(l));
                        od.setDateTime(oddsDate);
                        od.setBuk(buk);
                        oddsRep.save(od);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("sts err");
        }
    }
}
