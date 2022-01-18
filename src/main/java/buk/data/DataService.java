package buk.data;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import buk.Services.bukTeams.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    BetClicTeams betClicTeams;
    @Autowired
    BetfanTeams betfanTeams;
    @Autowired
    BetXTeams betXTeams;
    @Autowired
    EtotoTeams etotoTeams;
    @Autowired
    EwinnerTeams ewinnerTeams;
    @Autowired
    FortunaTeams fortunaTeams;
    @Autowired
    IForBetTeams iForBetTeams;
    @Autowired
    LvBetTeams lvBetTeams;
    @Autowired
    NobleBetTeams nobleBetTeams;
    @Autowired
    PzBukTeams pzBukTeams;
    @Autowired
    StsTeams stsTeams;
    @Autowired
    SuperbetTeams superbetTeams;
    @Autowired
    TotalBetTeams totalBetTeams;
    @Autowired
    TotolotekTeams totolotekTeams;
    @Autowired
    ScoresTeams scoresTeams;

    public Map<String, String> betClicLinks = new HashMap<>();
    public Map<String, String> betFanLinks = new HashMap<>();
    public Map<String, String> betXLinks = new HashMap<>();
    public Map<String, String> eTotoLinks = new HashMap<>();
    public Map<String, String> eWinnerLinks = new HashMap<>();
    public Map<String, String> fortunaLinks = new HashMap<>();
    public Map<String, String> iForBetLinks = new HashMap<>();
    public Map<String, String> lvBetLinks = new HashMap<>();
    public Map<String, String> noblebetLinks = new HashMap<>();
    public Map<String, String> pzBukLinks = new HashMap<>();
    public Map<String, String> stsLinks = new HashMap<>();
    public Map<String, String> superbetLinks = new HashMap<>();
    public Map<String, String> totalbetLinks = new HashMap<>();
    //public Map <String, String> totolotekLinks = new HashMap<>();

    public Map<String, TreeMap> betClic() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://www.betclic.pl/pilka-nozna-s1/ekstraklasa-c221", betClicTeams.polandEkstraklasa());
        links.put("https://www.betclic.pl/pilka-nozna-s1/niemcy-bundesliga-c5", betClicTeams.bundesLiga());
        links.put("https://www.betclic.pl/pilka-nozna-s1/serie-a-c6", betClicTeams.italySerieA());
        links.put("https://www.betclic.pl/pilka-nozna-s1/anglia-premier-league-c3", betClicTeams.englandPremier());
        links.put("https://www.betclic.pl/pilka-nozna-s1/hiszpania-la-liga-c7", betClicTeams.spainLaLiga());
        links.put("https://www.betclic.pl/pilka-nozna-s1/francja-ligue-1-c4", betClicTeams.franceLigue1());
        links.put("https://www.betclic.pl/pilka-nozna-s1/holandia-eredivisie-c21", betClicTeams.netherlandsEredivisie());
        links.put("https://www.betclic.pl/pilka-nozna-s1/portugalia-primeira-liga-c32", betClicTeams.portugalPrimeiraLiga());
        links.put("https://www.betclic.pl/pilka-nozna-s1/turcja-super-lig-c37", betClicTeams.turkeySuperLig());
        links.put("https://www.betclic.pl/pilka-nozna-s1/rosja-premier-league-c147", betClicTeams.russiaPremier());
        links.put("https://www.betclic.pl/pilka-nozna-s1/belgia-1-liga-c26", betClicTeams.belgiumJupiter());
        return links;
    }

    public Map<String, TreeMap> betFan() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/polska/ekstraklasa/294", betfanTeams.polandEkstraklasa());
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/niemcy/bundesliga/264", betfanTeams.germanyBundesLiga());
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/wlochy/serie-a/218", betfanTeams.italySerieA());
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/anglia/premier-league/244", betfanTeams.englandPremier());
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/hiszpania/laliga/230", betfanTeams.spainLaLiga());
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/francja/ligue-1/214", betfanTeams.franceLigue1());
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/holandia/1-holandia/252", betfanTeams.netherlandsEredivisie());
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/portugalia/1-portugalia/302", betfanTeams.portugalPrimeiraLiga());
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/turcja/1-turcja/260", betfanTeams.turkeySuperLig());
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/rosja/1-rosja/285", betfanTeams.russiaPremier());
        links.put("https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/belgia/1-belgia/228", betfanTeams.belgiumJupiter());
        return links;
    }

    public Map<String, TreeMap> betX() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/polska/ekstraklasa?hours=7200", betXTeams.polandEkstraklasa());
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/niemcy/bundesliga?hours=7200", betXTeams.bundesLiga());
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/wlochy/serie-a?hours=7200", betXTeams.italySerieA());
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/anglia/premier-league?hours=7200", betXTeams.englandPremier());
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/hiszpania/laliga?hours=7200", betXTeams.spainLaLiga());
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/francja/ligue-1?hours=7200", betXTeams.franceLigue1());
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/holandia/eredivisie?hours=7200", betXTeams.netherlandsEredivisie());
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/portugalia/liga-portugal?hours=7200", betXTeams.portugalPrimeiraLiga());
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/turcja/1-liga?hours=7200", betXTeams.turkeySuperLig());
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/rosja/1-liga?hours=7200", betXTeams.russiaPremier());
        links.put("https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/belgia/belgia-1-liga?hours=7200", betXTeams.belgiumJupiter());


        return links;
    }

    public Map<String, TreeMap> eToto() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/polska/ekstraklasa/666", etotoTeams.polandEkstraklasa());
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/niemcy/bundesliga/847", etotoTeams.bundesLiga());
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/wlochy/serie-a/210", etotoTeams.italySerieA());
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/anglia/premier-league/206", etotoTeams.englandPremier());
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/hiszpania/la-liga/1165", etotoTeams.spainLaLiga());
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/francja/ligue-1/350", etotoTeams.franceLigue1());
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/holandia/eredivisie/1200", etotoTeams.netherlandsEredivisie());
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/portugalia/primeira-liga/229", etotoTeams.portugalPrimeiraLiga());
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/turcja/super-lig/280", etotoTeams.turkeySuperLig());
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/rosja/premier-league/272", etotoTeams.russiaPremier());
        links.put("https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/belgia/-jupiler-pro-league/352", etotoTeams.belgiumJupiter());

        return links;
    }

    public Map<String, TreeMap> eWinner() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://ewinner.pl/zaklady-bukmacherskie/events/pilka-nozna/602", ewinnerTeams.polandEkstraklasa());
        links.put("https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/niemcy/bundesliga/268", ewinnerTeams.bundesLiga());
        links.put("https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/wlochy/serie-a/305", ewinnerTeams.italySerieA());
        links.put("https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/anglia/premier-league/313", ewinnerTeams.englandPremier());
        links.put("https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/hiszpania/laliga/256", ewinnerTeams.spainLaLiga());
        links.put("https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/francja/ligue-1/594", ewinnerTeams.franceLigue1());
        links.put("https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/holandia/eredivisie/505", ewinnerTeams.netherlandsEredivisie());
        links.put("https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/belgia/jupiler-league/1086", ewinnerTeams.belgiumJupiter());
        links.put("https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/portugalia/1-liga/599", ewinnerTeams.portugalPrimeiraLiga());
        links.put("https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/turcja/1-liga/1350", ewinnerTeams.turkeySuperLig());


        return links;
    }

    public Map<String, TreeMap> fortuna() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/ekstraklasa-polska", fortunaTeams.polandEkstraklasa());
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-niemcy", fortunaTeams.bundesLiga());
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-wlochy", fortunaTeams.italySerieA());
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-anglia", fortunaTeams.englandPremier());
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-hiszpania", fortunaTeams.spainLaLiga());
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-francja", fortunaTeams.franceLigue1());
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-holandia", fortunaTeams.netherlandsEredivisie());
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-portugalia", fortunaTeams.portugalPrimeiraLiga());
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-turcja", fortunaTeams.turkeySuperLig());
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-rosja", fortunaTeams.russiaPremier());
        links.put("https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-belgia", fortunaTeams.belgiumJupiter());

        return links;
    }

    public Map<String, TreeMap> iForBet() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/320/29994", iForBetTeams.polandEkstraklasa());
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/141/29975", iForBetTeams.bundesLiga());
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/118/122", iForBetTeams.italySerieA());
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/155/199", iForBetTeams.englandPremier());
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/156/159", iForBetTeams.spainLaLiga());
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/165/29958", iForBetTeams.franceLigue1());
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/157/29968", iForBetTeams.netherlandsEredivisie());
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/554/555", iForBetTeams.portugalPrimeiraLiga());
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/119/29972", iForBetTeams.turkeySuperLig());
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/116/29897", iForBetTeams.russiaPremier());
        links.put("https://www.iforbet.pl/zaklady-bukmacherskie/365/29861", iForBetTeams.belgiumJupiter());

        return links;
    }

    public Map<String, TreeMap> lvBet() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=392", lvBetTeams.polandEkstraklasa());
        links.put("https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=671", lvBetTeams.bundesLiga());
        links.put("https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=775", lvBetTeams.italySerieA());
        links.put("https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=754", lvBetTeams.englandPremier());
        links.put("https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=669", lvBetTeams.spainLaLiga());
        links.put("https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=665", lvBetTeams.franceLigue1());
        links.put("https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=791", lvBetTeams.netherlandsEredivisie());
        links.put("https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=658", lvBetTeams.portugalPrimeiraLiga());
        links.put("https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=596", lvBetTeams.turkeySuperLig());
        links.put("https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=666", lvBetTeams.belgiumJupiter());

        return links;
    }

    public Map<String, TreeMap> nobleBet() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=37425", nobleBetTeams.polandEkstraklasa());
        links.put("https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=37682", nobleBetTeams.bundesLiga());
        links.put("https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=37680", nobleBetTeams.italySerieA());
        links.put("https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=37685", nobleBetTeams.englandPremier());
        links.put("https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=41533", nobleBetTeams.spainLaLiga());
        links.put("https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=37677", nobleBetTeams.franceLigue1());
        links.put("https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=37446", nobleBetTeams.netherlandsEredivisie());
        links.put("https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=37666", nobleBetTeams.portugalPrimeiraLiga());
        links.put("https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=37353", nobleBetTeams.turkeySuperLig());

        links.put("https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=66791", nobleBetTeams.belgiumJupiter());

        return links;
    }

    public Map<String, TreeMap> pzBuk() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/polska-ekstraklasa/", pzBukTeams.polandEkstraklasa());
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/niemcy-bundesliga/", pzBukTeams.bundesLiga());
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/włochy-serie-a/", pzBukTeams.italySerieA());
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/anglia-premier-league/", pzBukTeams.englandPremier());
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/hiszpania-la-liga/", pzBukTeams.spainLaLiga());
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/francja-ligue-1/", pzBukTeams.franceLigue1());
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/holandia-eredivisie/", pzBukTeams.netherlandsEredivisie());
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/portugalia-primeira-liga/", pzBukTeams.portugalPrimeiraLiga());
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/turcja-super-lig/", pzBukTeams.turkeySuperLig());
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/rosja-pierwsza-liga/", pzBukTeams.russiaPremier());
        links.put("https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/belgia-first-division-a/", pzBukTeams.belgiumJupiter());


        return links;
    }

    public Map<String, TreeMap> sts() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/polska/ekstraklasa/184/30860/86441/", stsTeams.polandEkstraklasa());
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/niemcy/1-liga/184/30872/86476/", stsTeams.bundesLiga());
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/wlochy/1-liga/184/30874/86484/", stsTeams.italySerieA());
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/anglia/1-liga/184/30862/86451/", stsTeams.englandPremier());
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/hiszpania/1-liga/184/30867/86464/", stsTeams.spainLaLiga());
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/francja/1-liga/184/30868/86465/", stsTeams.franceLigue1());
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/holandia/1-liga/184/30870/86471/", stsTeams.netherlandsEredivisie());
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/portugalia/1-liga/184/30901/86644/", stsTeams.portugalPrimeiraLiga());
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/turcja/1-liga/184/30907/86638/", stsTeams.turkeySuperLig());
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/rosja/1-liga/184/30871/86473/", stsTeams.russiaPremier());
        links.put("https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/belgia/1-liga/184/30864/86457/", stsTeams.belgiumJupiter());

        return links;
    }

    public Map<String, TreeMap> superBet() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/polska/polska-ekstraklasa", superbetTeams.polandEkstraklasa());
        links.put("https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/niemcy/niemcy-1liga", superbetTeams.bundesLiga());
        links.put("https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/wlochy/wlochy-1liga", superbetTeams.italySerieA());
        links.put("https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/anglia/anglia-1liga", superbetTeams.englandPremier());
        links.put("https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/hiszpania/hiszpania-1liga", superbetTeams.spainLaLiga());
        links.put("https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/francja/francja-1liga", superbetTeams.franceLigue1());
        links.put("https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/holandia/holandia-1liga", superbetTeams.netherlandsEredivisie());
        links.put("https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/portugalia/portugalia-1liga", superbetTeams.portugalPrimeiraLiga());
        links.put("https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/turcja/turcja-1liga", superbetTeams.turkeySuperLig());
        links.put("https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/belgia/belgia-1liga", superbetTeams.belgiumJupiter());


        return links;
    }

    public Map<String, TreeMap> totalBet() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7485", totalBetTeams.polandEkstraklasa());
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7226/", totalBetTeams.bundesLiga());
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7151/", totalBetTeams.italySerieA());
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7124", totalBetTeams.englandPremier());
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7110", totalBetTeams.spainLaLiga());
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7219", totalBetTeams.franceLigue1());
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7241", totalBetTeams.netherlandsEredivisie());
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7519", totalBetTeams.portugalPrimeiraLiga());
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7312", totalBetTeams.turkeySuperLig());
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7320", totalBetTeams.russiaPremier());
        links.put("https://totalbet.pl/sports/events/Pilka-nozna/7119", totalBetTeams.belgiumJupiter());


        return links;
    }

    public Map<String, TreeMap> totolotek() {
        Map<String, TreeMap> links = new TreeMap<>();
//			links.put("https://www.totolotek.pl/pl/pilka-nozna/polska/ekstraklasa", totolotekTeams.polandEkstraklasa());
//			links.put("https://www.totolotek.pl/pl/pilka-nozna/niemcy/bundesliga", totolotekTeams.bundesLiga());
//			links.put("https://www.totolotek.pl/pl/pilka-nozna-wlochy-serie-a", totolotekTeams.italySerieA());
//			links.put("https://www.totolotek.pl/pl/pilka-nozna/anglia/premier-league", totolotekTeams.englandPremier());
//			links.put("https://www.totolotek.pl/pl/pilka-nozna/hiszpania/laliga", totolotekTeams.spainLaLiga());
//			links.put("https://www.totolotek.pl/pl/pilka-nozna/francja/ligue-1", totolotekTeams.franceLigue1());
//			links.put("https://www.totolotek.pl/pl/pilka-nozna/holandia/eredivisie", totolotekTeams.netherlandsEredivisie());
//			links.put("https://www.totolotek.pl/pl/pilka-nozna/portugalia/primeira-liga", totolotekTeams.portugalPrimeiraLiga());
//			links.put("https://www.totolotek.pl/pl/pilka-nozna/turcja/super-lig", totolotekTeams.turkeySuperLig());
//			links.put("https://www.totolotek.pl/pl/pilka-nozna/rosja/premier-league", totolotekTeams.russiaPremier());
        return links;
    }

    public Map<String, TreeMap> scores() {
        Map<String, TreeMap> links = new TreeMap<>();
        links.put("https://livescores.biz/leagues/poland/ekstraklasa/finished", scoresTeams.polandEkstraklasa());
        links.put("https://livescores.biz/leagues/germany/bundesliga-1/finished", scoresTeams.bundesLiga());
        links.put("https://livescores.biz/leagues/italy/serie-a/finished", scoresTeams.italySerieA());
        links.put("https://livescores.biz/leagues/england/premier-league/finished", scoresTeams.englandPremier());
        links.put("https://livescores.biz/leagues/spain/laliga/finished", scoresTeams.spainLaLiga());
        links.put("https://livescores.biz/leagues/france/ligue-1/finished", scoresTeams.franceLigue1());
        links.put("https://livescores.biz/leagues/netherlands/eredivisie/finished", scoresTeams.netherlandsEredivisie());
        links.put("https://livescores.biz/leagues/portugal/primeira-liga/finished", scoresTeams.portugalPrimeiraLiga());
        links.put("https://livescores.biz/leagues/turkey/super-lig/finished", scoresTeams.turkeySuperLig());
        links.put("https://livescores.biz/leagues/russia/premier-league-5/finished", scoresTeams.russiaPremier());
        links.put("https://livescores.biz/leagues/belarus/vysshaya-liga/finished", scoresTeams.belarus1());
        links.put("https://livescores.biz/leagues/belgium/first-division-a/finished", scoresTeams.belgiumJupiter());
        return links;
    }

    public void createLinks() {

        betClicLinks.put("Poland", "https://www.betclic.pl/pilka-nozna-s1/ekstraklasa-c221");
        betClicLinks.put("germany", "https://www.betclic.pl/pilka-nozna-s1/niemcy-bundesliga-c5");
        betClicLinks.put("italy", "https://www.betclic.pl/pilka-nozna-s1/serie-a-c6");
        betClicLinks.put("england", "https://www.betclic.pl/pilka-nozna-s1/anglia-premier-league-c3");
        betClicLinks.put("spain", "https://www.betclic.pl/pilka-nozna-s1/hiszpania-la-liga-c7");
        betClicLinks.put("france", "https://www.betclic.pl/pilka-nozna-s1/francja-ligue-1-c4");
        betClicLinks.put("netherlands", "https://www.betclic.pl/pilka-nozna-s1/holandia-eredivisie-c21");
        betClicLinks.put("portugal", "https://www.betclic.pl/pilka-nozna-s1/portugalia-primeira-liga-c32");
        betClicLinks.put("turkey", "https://www.betclic.pl/pilka-nozna-s1/turcja-super-lig-c37");
        betClicLinks.put("russia", "https://www.betclic.pl/pilka-nozna-s1/rosja-premier-league-c147");
        betClicLinks.put("belgium", "https://www.betclic.pl/pilka-nozna-s1/belgia-1-liga-c26");


        betFanLinks.put("Poland", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/polska/ekstraklasa/294");
        betFanLinks.put("germany", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/niemcy/bundesliga/264");
        betFanLinks.put("italy", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/wlochy/serie-a/218");
        betFanLinks.put("england", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/anglia/premier-league/244");
        betFanLinks.put("spain", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/hiszpania/laliga/230");
        betFanLinks.put("france", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/francja/ligue-1/214");
        betFanLinks.put("netherlands", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/holandia/1-holandia/252");
        betFanLinks.put("portugal", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/portugalia/1-portugalia/302");
        betFanLinks.put("turkey", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/turcja/1-turcja/260");
        betFanLinks.put("russia", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/rosja/1-rosja/285");
        betFanLinks.put("belgium", "https://betfan.pl/zaklady-bukmacherskie/pilka-nozna/belgia/1-belgia/228");


        betXLinks.put("Poland", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/polska/ekstraklasa?hours=7200");
        betXLinks.put("germany", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/niemcy/bundesliga?hours=7200");
        betXLinks.put("italy", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/wlochy/serie-a?hours=7200");
        betXLinks.put("england", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/anglia/premier-league?hours=7200");
        betXLinks.put("spain", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/hiszpania/laliga?hours=7200");
        betXLinks.put("france", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/francja/ligue-1?hours=7200");
        betXLinks.put("netherlands", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/holandia/eredivisie?hours=7200");
        betXLinks.put("portugal", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/portugalia/liga-portugal?hours=7200");
        betXLinks.put("turkey", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/turcja/1-liga?hours=7200");
        betXLinks.put("russia", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/rosja/1-liga?hours=7200");
        betXLinks.put("belgium", "https://ebetx.pl/pl/sports-betting/offer/pilka-nozna/belgia/belgia-1-liga?hours=7200");


        eTotoLinks.put("Poland", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/polska/ekstraklasa/666");
        eTotoLinks.put("germany", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/niemcy/bundesliga/847");
        eTotoLinks.put("italy", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/wlochy/serie-a/210");
        eTotoLinks.put("england", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/anglia/premier-league/206");
        eTotoLinks.put("spain", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/hiszpania/la-liga/1165");
        eTotoLinks.put("france", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/francja/ligue-1/350");
        eTotoLinks.put("netherlands", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/holandia/eredivisie/1200");
        eTotoLinks.put("portugal", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/portugalia/primeira-liga/229");
        eTotoLinks.put("turkey", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/turcja/super-lig/280");
        eTotoLinks.put("russia", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/rosja/premier-league/272");
        eTotoLinks.put("belgium", "https://www.etoto.pl/zaklady-bukmacherskie/pilka-nozna/belgia/-jupiler-pro-league/352");


        eWinnerLinks.put("Poland", "https://ewinner.pl/zaklady-bukmacherskie/events/pilka-nozna/602");
        eWinnerLinks.put("germany", "https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/niemcy/bundesliga/268");
        eWinnerLinks.put("italy", "https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/wlochy/serie-a/305");
        eWinnerLinks.put("england", "https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/anglia/premier-league/313");
        eWinnerLinks.put("spain", "https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/hiszpania/laliga/256");
        eWinnerLinks.put("france", "https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/francja/ligue-1/594");
        eWinnerLinks.put("netherlands", "https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/holandia/eredivisie/505");
        eWinnerLinks.put("portugal", "https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/portugalia/1-liga/599");
        eWinnerLinks.put("turkey", "https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/turcja/1-liga/1350");
        eWinnerLinks.put("belgium", "https://ewinner.pl/zaklady-bukmacherskie/pilka-nozna/belgia/jupiler-league/1086");


        fortunaLinks.put("Poland", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/ekstraklasa-polska");
        fortunaLinks.put("germany", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-niemcy");
        fortunaLinks.put("italy", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-wlochy");
        fortunaLinks.put("england", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-anglia");
        fortunaLinks.put("spain", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-hiszpania");
        fortunaLinks.put("france", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-francja");
        fortunaLinks.put("netherlands", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-holandia");
        fortunaLinks.put("portugal", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-portugalia");
        fortunaLinks.put("turkey", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-turcja");
        fortunaLinks.put("russia", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-rosja");
        fortunaLinks.put("belgium", "https://www.efortuna.pl/zaklady-bukmacherskie/pilka-nozna/1-belgia");


        iForBetLinks.put("Poland", "https://www.iforbet.pl/zaklady-bukmacherskie/320/29994");
        iForBetLinks.put("germany", "https://www.iforbet.pl/zaklady-bukmacherskie/141/29975");
        iForBetLinks.put("italy", "https://www.iforbet.pl/zaklady-bukmacherskie/118/122");
        iForBetLinks.put("england", "https://www.iforbet.pl/zaklady-bukmacherskie/155/199");
        iForBetLinks.put("spain", "https://www.iforbet.pl/zaklady-bukmacherskie/156/159");
        iForBetLinks.put("france", "https://www.iforbet.pl/zaklady-bukmacherskie/165/29958");
        iForBetLinks.put("netherlands", "https://www.iforbet.pl/zaklady-bukmacherskie/157/29968");
        iForBetLinks.put("portugal", "https://www.iforbet.pl/zaklady-bukmacherskie/554/555");
        iForBetLinks.put("turkey", "https://www.iforbet.pl/zaklady-bukmacherskie/119/29972");
        iForBetLinks.put("russia", "https://www.iforbet.pl/zaklady-bukmacherskie/116/29897");
        iForBetLinks.put("belgium", "https://www.iforbet.pl/zaklady-bukmacherskie/365/29861");


        lvBetLinks.put("Poland", "https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=392");
        lvBetLinks.put("germany", "https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=671");
        lvBetLinks.put("italy", "https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=775");
        lvBetLinks.put("england", "https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=754");
        lvBetLinks.put("spain", "https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=669");
        lvBetLinks.put("france", "https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=665");
        lvBetLinks.put("netherlands", "https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=791");
        lvBetLinks.put("portugal", "https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=658");
        lvBetLinks.put("turkey", "https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=596");
        lvBetLinks.put("belgium", "https://lvbet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=666");


        noblebetLinks.put("Poland", "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=37425");
        noblebetLinks.put("germany", "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=37682");
        noblebetLinks.put("italy", "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=37680");
        noblebetLinks.put("england", "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=37685");
        noblebetLinks.put("spain", "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=41533");
        noblebetLinks.put("france", "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=37677");
        noblebetLinks.put("netherlands", "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=37446");
        noblebetLinks.put("portugal", "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=37666");
        noblebetLinks.put("turkey", "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--/?leagues=37353");
        noblebetLinks.put("belgium", "https://noblebet.pl/pl/zaklady-bukmacherskie/multiple--?leagues=66791");


        pzBukLinks.put("Poland", "https://sports.pzbuk.pl/sports/piłka-nożna/polska-ekstraklasa/");
        pzBukLinks.put("germany", "https://sports.pzbuk.pl/sports/piłka-nożna/niemcy-bundesliga/");
        pzBukLinks.put("italy", "https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/włochy-serie-a/");
        pzBukLinks.put("england", "https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/anglia-premier-league/");
        pzBukLinks.put("spain", "https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/hiszpania-la-liga/");
        pzBukLinks.put("france", "https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/francja-ligue-1/");
        pzBukLinks.put("netherlands", "https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/holandia-eredivisie/");
        pzBukLinks.put("portugal", "https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/portugalia-primeira-liga/");
        pzBukLinks.put("turkey", "https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/turcja-super-lig/");
        pzBukLinks.put("russia", "https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/rosja-pierwsza-liga/");
        pzBukLinks.put("belgium", "https://sports.pzbuk.pl/sports/pi%C5%82ka-no%C5%BCna/belgia-first-division-a/");


        stsLinks.put("Poland", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/polska/ekstraklasa/184/30860/86441/");
        stsLinks.put("germany", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/niemcy/1-liga/184/30872/86476/");
        stsLinks.put("italy", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/wlochy/1-liga/184/30874/86484/");
        stsLinks.put("england", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/anglia/1-liga/184/30862/86451/");
        stsLinks.put("spain", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/hiszpania/1-liga/184/30867/86464/");
        stsLinks.put("france", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/francja/1-liga/184/30868/86465/");
        stsLinks.put("netherlands", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/holandia/1-liga/184/30870/86471/");
        stsLinks.put("portugal", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/portugalia/1-liga/184/30901/86644/");
        stsLinks.put("turkey", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/turcja/1-liga/184/30907/86638/");
        stsLinks.put("russia", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/rosja/1-liga/184/30871/86473/");
        stsLinks.put("belgium", "https://www.sts.pl/pl/zaklady-bukmacherskie/pilka-nozna/belgia/1-liga/184/30864/86457/");


        superbetLinks.put("Poland", "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/polska/polska-ekstraklasa");
        superbetLinks.put("germany", "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/niemcy/niemcy-1liga");
        superbetLinks.put("italy", "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/wlochy/wlochy-1liga");
        superbetLinks.put("england", "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/anglia/anglia-1liga");
        superbetLinks.put("spain", "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/hiszpania/hiszpania-1liga");
        superbetLinks.put("france", "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/francja/francja-1liga");
        superbetLinks.put("netherlands", "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/holandia/holandia-1liga");
        superbetLinks.put("portugal", "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/portugalia/portugalia-1liga");
        superbetLinks.put("turkey", "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/turcja/turcja-1liga");
        superbetLinks.put("belgium", "https://www.superbet.pl/zaklady-bukmacherskie/pilka-nozna/belgia/belgia-1liga");


        totalbetLinks.put("Poland", "https://totalbet.pl/sports/events/Pilka-nozna/7485");
        totalbetLinks.put("germany", "https://totalbet.pl/sports/events/Pilka-nozna/7226/");
        totalbetLinks.put("italy", "https://totalbet.pl/sports/events/Pilka-nozna/7151/");
        totalbetLinks.put("england", "https://totalbet.pl/sports/events/Pilka-nozna/7124");
        totalbetLinks.put("spain", "https://totalbet.pl/sports/events/Pilka-nozna/7110");
        totalbetLinks.put("france", "https://totalbet.pl/sports/events/Pilka-nozna/7219");
        totalbetLinks.put("netherlands", "https://totalbet.pl/sports/events/Pilka-nozna/7241");
        totalbetLinks.put("portugal", "https://totalbet.pl/sports/events/Pilka-nozna/7519");
        totalbetLinks.put("turkey", "https://totalbet.pl/sports/events/Pilka-nozna/7312");
        totalbetLinks.put("russia", "https://totalbet.pl/sports/events/Pilka-nozna/7320");


//			totolotekLinks.put("Poland", "https://www.totolotek.pl/pl/pilka-nozna/polska/ekstraklasa");
//			totolotekLinks.put("germany", "https://www.totolotek.pl/pl/pilka-nozna/niemcy/bundesliga");
//			totolotekLinks.put("italy", "https://www.totolotek.pl/pl/pilka-nozna-wlochy-serie-a");
//			totolotekLinks.put("england", "https://www.totolotek.pl/pl/pilka-nozna/anglia/premier-league");
//			totolotekLinks.put("spain", "https://www.totolotek.pl/pl/pilka-nozna/hiszpania/laliga");


    }

}
