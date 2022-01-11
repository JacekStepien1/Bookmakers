package buk.Services.bukTeams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class ScoresTeams {

    @Autowired
    TeamGenerator teamGenerator;

    public TreeMap<Integer, String> insertTeams (String[] teamList, TreeMap <Integer, String> teams, int setId){
        for (int i = 0; i < teamList.length; i++) {
            teams.put(setId, teamList[i]);
            setId++;
        }
        return teams;
    }
    public TreeMap<Integer, String> belgiumJupiter() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.belgiumJupiter;
        String teamList[] = new String [] {"Royale Union Saint-Gilloise", "Brugge", "Anderlecht", "Royal Antwerp", "Gent", "Mechelen", "R. Charleroi",
                "Kortrijk", "Genk", "Oud-Heverlee Leuven", "Cercle Brugge", "K.A.S. Eupen", "Sint-Truidense", "Oostende", "Standard Liege", "Zulte Waregem",
                "Seraing United", "FCO Beerschot"};
        insertTeams(teamList, teams, setId);
        return teams;
    }


    public TreeMap<Integer, String> belarus1() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.belarus1league;
        String teamList[] = new String [] {"Shakhtyor Soligorsk", "BATE Borisov", "Torpedo-BelAZ", "FC Dinamo Brest", "Neman Grodno", "Dinamo Minsk", "Isloch",
                "Rukh Brest", "Slavia-Mozyr", "Energetik-BGU", "Minsk", "Vitebsk", "Sputnik Rechica", "Slutsk", "Gomel", "Smorgon"};
        insertTeams(teamList, teams, setId);
        return teams;
    }

    public TreeMap<Integer, String> russiaPremier() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.russiaPremier;
        String teamList[] = new String [] {"Zenit St. Petersburg", "CSKA Moscow", "Spartak Moscow", "Sochi", "Rostov", "Dynamo Moscow", "Krasnodar",
                "Lokomotiv Moscow", "Rubin Kazan", "Akhmat", "Khimki", "Ural", "Krylia Sovetov", "Arsenal Tula", "Ufa", "Nizhniy Novgorod"};
        insertTeams(teamList, teams, setId);
        return teams;
    }

    public TreeMap<Integer, String> turkeySuperLig() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.turkeySuperLig;
        String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gaziantep FK", "Trabzonspor", "Alanyaspor", "Hatayspor",
                "Fatih Karagumruk SK", "Yeni Malatyaspor", "Antalyaspor", "Goztepe", "Caykur Rizespor", "Sivasspor", "Istanbul BFK", "Konyaspor 1922", "Kasimpasa",
                "Kayserispor", "Adana Demirspor", "Giresunspor", "Altay"};
        insertTeams(teamList, teams, setId);
        return teams;
    }

    public TreeMap<Integer, String> portugalPrimeiraLiga() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.portugalPrimeiraLiga;
        String teamList[] = new String [] {"Sporting Clube de Portugal", "Porto", "SL Benfica", "Sporting Braga", "Pacos de Ferreira", "Vitoria Guimaraes", "Moreirense",
                "Marítimo", "Santa Clara", "Estoril", "Tondela", "Portimonense", "Famalicao", "Arouca", "Gil Vicente", "Vizela",
                "Os Belenenses", "Boavista Porto"};
        insertTeams(teamList, teams, setId);
        return teams;
    }

    public TreeMap<Integer, String> netherlandsEredivisie() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.netherlandsEredivisie;
        String teamList[] = new String [] {"Ajax", "Vitesse", "PSV Eindhoven", "Feyenoord", "AZ Alkmaar", "Groningen", "Twente",
                "Heerenveen", "Sparta Rotterdam", "Utrecht", "Heracles Almelo", "PEC Zwolle", "Fortuna Sittard", "Cambuur", "Waalwijk", "Go Ahead Eagles",
                "Willem II", "N.E.C."};
        insertTeams(teamList, teams, setId);
        return teams;
    }

    public TreeMap<Integer, String> franceLigue1() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.franceLigue1;
        String teamList[] = new String [] {"Paris Saint-Germain", "Lille OSC", "Lyon", "AS Monaco", "Stade Rennais", "Olympique de Marseille", "RC Lens",
                "Angers SCO", "Girondins de Bordeaux", "Metz", "Montpellier HSC", "Stade Brestois 29", "Nice", "Strasbourg", "Stade de Reims", "AS Saint-Etienne",
                "Nantes", "Troyes AC", "Clermont Foot", "Lorient"};
        insertTeams(teamList, teams, setId);
        return teams;
    }


    public TreeMap<Integer, String> bundesLiga() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.germanyBundesliga;
        String teamList[] = new String [] {"Bayern Munich", "RasenBallsport Leipzig", "Bayer 04", "Borussia Dortmund", "Union Berlin", "VfL Wolfsburg", "Eintracht Frankfurt",
                "Borussia Monchengladbach", "Freiburg", "VfB Stuttgart", "Augsburg", "VfL Bochum", "Hertha BSC", "TSG 1899 Hoffenheim", "Arminia Bielefeld", "1. Koln"
                , "1. FSV Mainz 05", "Greuther Furth"};
        insertTeams(teamList, teams, setId);
        return teams;
    }

    public TreeMap<Integer, String> spainLaLiga() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.spainLaLiga;
        String teamList[] = new String [] {"Atletico Madrid", "Real Madrid", "Sevilla", "Barcelona", "Villarreal", "Real Sociedad", "Granada",
                "Real Betis", "Cadiz", "Levante UD", "Getafe", "Celta", "Athletic Bilbao", "Valencia", "Espanyol", "Mallorca"
                , "Deportivo Alaves", "Elche", "Osasuna", "Rayo Vallecano"};
        insertTeams(teamList, teams, setId);
        return teams;
    }

    public TreeMap<Integer, String> italySerieA() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.italySerieA;
        String teamList[] = new String [] {"Milan", "Inter", "Roma", "Atalanta", "Napoli", "Juventus", "Lazio",
                "Sassuolo Calcio", "Hellas Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna 1909", "Udinese", "Spezia Calcio", "Genoa"
                , "Cagliari Calcio", "Torino", "Unione Venezia", "Salernitana 1919"};
        insertTeams(teamList, teams, setId);
        return teams;
    }

    public TreeMap<Integer, String> polandEkstraklasa() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.polandEkstraklasa;
        String teamList[] = new String [] {"Legia Warsaw", "Piast Gliwice", "Lech Poznan", "Slask Wroclaw", "KS Cracovia", "Pogon Szczecin", "Jagiellonia Bialystok",
                "Lechia Gdansk", "Gornik Zabrze", "Rakow Czestochowa", "Zaglebie Lubin", "Wisla PLock", "Wisla Krakow", "Warta Poznan", "Stal Mielec", "RKS Radomiak Radom",
                "Bruk-Bet Termalica", "Gornik Leczna"};
        insertTeams(teamList, teams, setId);
        return teams;
    }

    public TreeMap<Integer, String> englandPremier() {
        TreeMap<Integer, String> teams = new TreeMap<>();
        int setId = teamGenerator.englandPremier;
        String teamList[] = new String [] {"Manchester United", "Manchester City", "Leicester City", "Liverpool", "Tottenham", "Everton", "West Ham United",
                "Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds United", "Crystal Palace", "Wolverhampton Wanderers", "Newcastle United", "Burnley"
                , "Brighton & Hove Albion", "Norwich", "Watford", "Brentford"};
        insertTeams(teamList, teams, setId);
        return teams;
    }





}
