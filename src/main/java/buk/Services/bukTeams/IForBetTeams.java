package buk.Services.bukTeams;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IForBetTeams {
	
	@Autowired
	TeamGenerator teamGenerator;

	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"Union Saint-Gilloise", "Club Brugge", "Anderlecht", "Antwerpia", "Gent", "Mechelen", "Charleroi",
				"Kortrijk", "Genk", "OH Leuven", "Cercle Brugge", "Eupen", "St. Truiden", "Oostende", "St. Liege", "Waregem",
				"RFC Seraing", "Kfco Wilrijk"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"Zenit St. Petersburg", "CSKA Moskwa", "Spartak Moskwa", "Sochi", "FK Rostów", "Dynamo Moskwa", "Krasnodar",
				"Lokomotiv Moskwa", "Rubin Kazań", "Akhmat Grozny", "FK Chimki", "Ural", "Samara", "Arsienał Tuła", "Ufa", "Niżny Nowogród"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gaziantep", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Fatih Karagumruk", "Yeni Malatyaspor", "Antalyaspor", "Goztepespor", "Rizespor", "Sivasspor", "Basaksehir", "Konyaspor", "Kasimpasa", 
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting L.", "FC Porto", "Benfica", "Braga", "Ferreira", "V. Guimaraes", "Moreirense",
				"Maritimo", "Santa Clara", "Estoril", "Tondela", "Portimonense", "Famalicao", "FC Arouca", "Gil Vicente", "FC Vizela",
				"Belenenses", "Boavista"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax", "Vitesse", "PSV", "Feyenoord", "AZ Alkmaar", "Groningen", "Twente",
				"Heerenveen", "Sparta Rotterdam", "Utrecht", "Heracles", "Zwolle", "Sittard", "Cambuur Leeuwarden", "Waalwijk", "Go Ahead Eagles",
				"Willem II", "NEC Nijmegen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"PSG", "Lille", "Lyon", "Monaco", "Rennes", "Marsylia", "Lens",
				"Angers", "Bordeaux", "Metz", "Montpellier", "Brest", "Nice", "Strasbourg", "Reims", "St. Etienne", 
				"Nantes", "Troyes", "Clermont", "FC Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madryt", "Real Madryt", "Sevilla", "FC Barcelona", "Villarreal", "Real Sociedad", "Granada",
				"Real Betis", "Cadiz CF", "Levante", "Getafe", "Celta Vigo", "Athletic Bilbao", "Valencia", "Espanyol", "Mallorca"
				, "Alaves", "Elche CF", "Osasuna", "Rayo Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester United", "Manchester City", "Leicester", "Liverpool", "Tottenham", "Everton", "West Ham",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds United", "Crystal Palace", "Wolverhampton", "Newcastle", "Burnley"
				, "Brighton", "Norwich", "Watford", "Brentford"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	

	//exc AC Parma
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter", "AS Roma", "Atalanta", "Napoli", "Juventus", "Lazio",
				"Sassuolo", "Hellas Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna", "Udinese", "Spezia", "Genoa"
				, "Cagliari", "Torino", "SSC Venezia", "US Salernitana 1919"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia Warszawa", "Piast Gliwice", "Lech Poznań", "Śląsk Wrocław",
				"Cracovia", "Pogoń Szczecin", "Jagiellonia Białystok", "Lechia Gdańsk", "Górnik Zabrze",
				"Raków Częstochowa", "Zagłębie Lubin", "Wisła Płock", "Wisła Kraków", "Warta Poznań", "Stal Mielec",
				"Radomiak Radom", "Termalica Nieciecza", "Górnik Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern", "RB Lipsk", "Leverkusen", "Dortmund", 
				"Union Berlin", "Wolfsburg", "Frankfurt","Moenchengladbach", "Freiburg", 
				"Stuttgart", "Augsburg", "VfL Bochum", "Hertha", "Hoffenheim", "Arminia Bielefeld",
				"FC Koln", "Mainz", "Greuther Furth"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	//Exceptions
	public TreeMap<Integer, String> iForBetTeamsExceptions() {
		TreeMap<Integer, String> teamsExceptions = new TreeMap<>();
//		teamsExceptions.put(3018, "FC Parma");
		return teamsExceptions;
	}
	
	public TreeMap <Integer, String> insertTeams (String[] teamList, TreeMap <Integer, String> teams, int setId){
		for (int i = 0; i < teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		return teams;
	}

}




















