package buk.Services.bukTeams;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetClicTeams {
	
	@Autowired
	TeamGenerator teamGenerator;
	
	public TreeMap <Integer, String> insertTeams (String[] teamList, TreeMap <Integer, String> teams, int setId){
		for (int i = 0; i < teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		return teams;
	}

	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"Union Saint-Gilloise", "Club Brugge", "Anderlecht", "Antwerp", "Gent", "Mechelen", "Royal Charleroi SC",
				"Kortrijk", "Genk", "Oud-Heverlee Leuven", "Cercle Brugge", "Eupen", "St Truiden", "Oostende", "Standard Liege", "Zulte Waregem",
				"RFC Seraing", "Kfco Beerschot Wilrijk"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"Zenit Petersburg", "CSKA Moskwa", "Spartak Moskwa", "Soczi", "Rostów", "Dinamo Moskwa", "Krasnodar",
				"Lokomotiv Moskwa", "Rubin Kazań", "Akhmat", "Chimki", "Urał", "Krylja Sowietow", "Arsienał Tuła", "Ufa", "Niżny Nowogród"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gazisehir Gaziantep FK", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Karagümrük", "Malatyaspor", "Antalyaspor", "Goztepe", "Caykur Rizespor", "Sivasspor", "Istanbul Basaksehir", "Konyaspor", "Kasimpasa",
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting Lizbona", "Porto", "Benfica", "Braga", "Pacos Ferreira", "Vitoria Guimaraes", "Moreirense",
				"Maritimo", "Santa Clara", "Estoril Praia", "Tondela", "Portimonense", "Famalicao", "Arouca", "Gil Vicente", "Vizela",
				"Belenenses", "Boavista"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax", "Vitesse", "PSV Eindhoven", "Feyenoord", "AZ", "Groningen", "Twente",
				"Heerenveen", "Sparta Rotterdam", "Utrecht", "Heracles", "Zwolle", "Fortuna Sittard", "Cambuur Leeuwarden", "RKC Waalwijk", "Go Ahead Eagles",
				"Willem II", "NEC Nijmegen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	// PSG? 
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"Paris SG", "Lille", "Lyon", "Monaco", "Rennes", "Marsylia", "Lens",
				"Angers", "Bordeaux", "Metz", "Montpellier", "Brest", "Nice", "Strasbourg", "Reims", "Saint-Etienne", 
				"Nantes", "Troyes", "Clermont Foot", "Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madryt", "Real Madryt", "Sevilla", "Barcelona", "Villarreal", "Real Sociedad", "Granada",
				"Betis", "Cádiz", "Levante", "Getafe", "Celta Vigo", "Athletic Bilbao", "Valencia", "Espanyol", "Mallorca"
				, "Alaves", "Elche", "Osasuna", "Rayo Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	//Poland ekstraklasa
	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia Warszawa", "Piast Gliwice", "Lech Poznań", "Śląsk Wrocław",
				"Cracovia", "Pogoń Szczecin", "Jagiellonia Białystok", "Lechia Gdańsk", "Górnik Zabrze",
				"Raków Częstochowa", "Zagłębie Lubin", "Wisła Płock", "Wisła Kraków", "Warta Poznań", "Stal Mielec",
				"RKS Radomiak", "Nieciecza", "Górnik Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	//Germany Bundesliga
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern Monachium", "RB Leipzig", "B. Leverkusen", "Dortmund",
				"Union Berlin", "Wolfsburg", "Eintracht Fr.","B. M'gladbach", "Freiburg",
				"Stuttgart", "Augsburg", "Bochum", "Hertha Berlin", "Hoffenheim", "Arminia",
				"FC Koeln", "Mainz", "Greuther Furth"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester Utd", "Manchester City", "Leicester", "Liverpool", "Tottenham", "Everton", "West Ham",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds", "Crystal Palace", "Wolverhampton", "Newcastle", "Burnley"
				, "Brighton", "Norwich City", "Watford", "Brentford"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter", "Roma", "Atalanta", "Napoli", "Juventus", "Lazio",
				"Sassuolo", "Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna", "Udinese", "Spezia", "Genoa"
				, "Cagliari", "Torino", "Venezia", "Salernitana"};
		insertTeams(teamList, teams, setId);
		return teams;
	}




}
