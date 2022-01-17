package buk.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buk.Entities.Matches;
import buk.Services.bukTeams.BetClicTeams;
import buk.data.DataService;
import buk.repositories.MatchesRepository;
import buk.repositories.TeamsRepository;
import buk.repositories.OddsRepository;

@Service
public class WebReaderBetClic {

    @Autowired
    MainService mainService;
    @Autowired
    MatchesRepository matchesRep;
    @Autowired
    TeamsRepository tlRep;
    @Autowired
    OddsRepository oddsRep;
    @Autowired
    BetClicTeams betClicTeams;
    @Autowired
    DataService dataService;

    Document doc;
    Elements elem1;
    Elements elem2;
    String home;
    String away;
    String date;
    String time;
    String buk = "BetClic";
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyHH:mm");
    Date matchDate;

    public void matchesReader() throws Exception {

        for (Map.Entry<String, TreeMap> link : dataService.betClic().entrySet()) {
            matchesReaderStart(link.getKey(), link.getValue());
        }

    }

    public void matchesReaderStart(String url, TreeMap league) {

        try {
            Thread.sleep(mainService.randomNumber2());
            doc = Jsoup.parse(url, "UTF-8");
            Connection connection = Jsoup.connect(url);
            connection.userAgent("Mozilla");
            connection.timeout(10000);
            Document doc = connection.get();
            elem1 = doc.select(".event");
            elem2 = doc.select(".markets");

        } catch (Exception e) {
            System.err.println("read error: " + url);
        }

        try {

            for (int i = 0; i < elem1.size(); i++) {

                // get date and time
                try {
                    String date1[] = elem1.get(i).select(".event_infoTime").text().trim().split(" ");
                    date = date1[0];
                    time = date1[1];
                } catch (Exception e) {
                    // TODO: handle exception
                }


                if (date.equals("Dzisiaj")) {
                    Calendar cal = Calendar.getInstance();
                    date = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "." + String.valueOf(cal.get(Calendar.MONTH) + 1) + "." + String.valueOf(cal.get(Calendar.YEAR));
                }
                if (date.equals("Jutro")) {
                    Calendar cal = Calendar.getInstance();
                    date = String.valueOf(cal.get(Calendar.DAY_OF_MONTH) + 1) + "." + String.valueOf(cal.get(Calendar.MONTH) + 1) + "." + String.valueOf(cal.get(Calendar.YEAR));
                }
                if (date.equals("Pojutrze")) {
                    Calendar cal = Calendar.getInstance();
                    date = String.valueOf(cal.get(Calendar.DAY_OF_MONTH) + 2) + "." + String.valueOf(cal.get(Calendar.MONTH) + 1) + "." + String.valueOf(cal.get(Calendar.YEAR));
                }


                matchDate = null;
                try {
                    matchDate = sdf.parse(date + time);
                } catch (ParseException e) {
                    System.err.println("date error");
                }

                // get teams
                home = elem1.get(i).select(".scoreboard_contestantLabel").get(0).text();
                away = elem1.get(i).select(".scoreboard_contestantLabel").get(1).text();

                // get odds

                double oddsTable[] = new double[3];
                try {
                    for (int y = 0; y < 3; y++) {
                        oddsTable[y] = Double.parseDouble(elem2.get(i).select(".oddValue").get(y).text().replace(",", "."));
                    }
                } catch (Exception e) {
                }

                // save match
                Matches match = new Matches();
                mainService.saveMatch(match, league, matchDate, home, away);

                // save odds
                if (matchDate != null && home != null && away != null) {
                    Matches m = matchesRep.findFirstByHomeAndAwayAndDateTimeBetween(match.getHome(), match.getAway(),
                            mainService.date1(match), mainService.date2(match));
                    mainService.saveOdds(oddsTable, match, m, buk);
                }


            }
        } catch (Exception e) {
            System.err.println("betClic err");
        }
    }

}
