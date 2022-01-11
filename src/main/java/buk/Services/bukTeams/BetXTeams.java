package buk.Services.bukTeams;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetXTeams {
	
	@Autowired
	TeamGenerator teamGenerator;


	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"Union Saint-Gilloise", "Club Brugge", "RSC Anderlecht", "Royal Antwerpia", "KAA Gent", "Yellow-Red KV Mechelen", "Royal Charleroi SC",
				"KV Kortrijk", "KRC Genk", "Oud-Heverlee Leuven", "Cercle Brugge", "AS Eupen", "St. Truidense VV", "KV Oostende", "Standard Liege", "SV Zulte Waregem",
				"RFC Seraing", "K Beerschot VA"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"Zenit St Petersburg", "CSKA Moskwa", "Spartak Moskwa", "FK Sochi", "FK Rostov", "FK Dinamo Moscow", "FK Krasnodar",
				"Lokomotiw Moskwa", "FK Rubin Kazan", "RFK Akhmat Grozny", "FK Khimki", "FK Ural Yekaterinburg", "PFK Krylia Sovetov Samara", "PFK Arsenal Tula", "FK Ufa", "FK Nizhny Novgorod"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas Stambuł", "Fenerbahce", "Galatasaray", "Gazisehir Gaziantep FK", "Trabzonspor", "Alanyaspor", "Hatayspor Antakya",
				"Fatih Karagumruk Istanbul", "Malatya Bld Spor", "Antalyaspor", "Goztepe Izmir", "Caykur Rizespor", "Sivasspor", "Istanbul Basaksehir", "Konyaspor", "Kasimpasa Istanbul",
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting Lizbona", "FC Porto", "Benfica Lizbona", "SC Braga", "Pacos de Ferreira", "Vitoria Guimarares", "Moreirense FC",
				"Maritimo Madeira", "Santa Clara", "GD Estoril Praia", "CD Tondela", "Portimonense SC", "FC Famalicao", "FC Arouca", "Gil Vicente Barcelos", "FC Vizela",
				"Belenenses Lisbon", "Boavista Porto"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax Amsterdam", "Vitesse Arnhem", "PSV Eindhoven", "Feyenoord Rotterdam", "AZ Alkmaar", "FC Groningen", "Twente Enschede",
				"SC Heerenveen", "Sparta Rotterdam", "FC Utrecht", "Heracles Almelo", "FC Zwolle", "Fortuna Sittard", "SC Cambuur", "RKC Waalwijk", "Go Ahead Eagles",
				"Willem II Tilburg", "NEC Nijmegen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"PSG", "LOSC Lille", "Olympique Lyon", "AS Monaco", "Stade Rennes", "Olympique Marsylia", "RC Lens",
				"SCO Angers", "Girondins Bordeaux", "FC Metz", "Montpellier HSC", "Stade Brest", "OGC Nice", "RC Strasbourg", "Stade Reims", "AS Saint-Etienne",
				"FC Nantes", "ESTAC Troyes", "Clermont Foot 63", "FC Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madryt", "Real Madryt", "Sevilla", "FC Barcelona", "Villarreal", "Real Sociedad", "Granada",
				"Betis Sevilla", "Cadiz", "Levante", "Getafe", "Celta Vigo", "Athletic Bilbao", "Valencia", "Espanyol", "Mallorca"
				, "Alaves", "Elche", "Osasuna", "Rayo Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester United", "Manchester City", "Leicester City", "Liverpool FC", "Tottenham Hotspur", "Everton FC", "West Ham United",
				"Chelsea FC", "Southampton FC", "Arsenal FC", "Aston Villa", "Leeds United", "Crystal Palace", "Wolverhampton Wanderers", "Newcastle United", "Burnley FC"
				, "Brighton & Hove Albion", "Norwich City", "Watford FC", "Brentford FC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter Mediolan", "AS Roma", "Atalanta Bergamo", "SSC Napoli", "Juventus Turyn", "Lazio Rzym",
				"US Sassuolo", "Hellas Verona", "UC Sampdoria", "Empoli FC", "ACF Fiorentina", "Bologna FC", "Udinese Calcio", "Spezia Calcio", "Genoa CFC"
				, "Cagliari Calcio", "Torino FC", "Venezia FC", "US Salernitana 1919"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia Warszawa", "Piast Gliwice", "Lech Poznań", "Śląsk Wrocław",
				"Cracovia Kraków", "Pogoń Szczecin", "Jagiellonia Białystok", "Lechia Gdańsk", "Górnik Zabrze",
				"Raków Częstochowa", "Zagłębie Lubin", "Wisła Płock", "Wisła Kraków", "Warta Poznań", "Stal Mielec",
				"Radomiak Radom", "Bruk-Bet Termalica Nieciecza", "Górnik Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern Monachium", "RB Lipsk", "Bayer Leverkusen", "Borussia Dortmund", 
				"Union Berlin", "VfL Wolfsburg", "Eintracht Frankfurt","B. Moenchengladbach", "Freiburg",
				"VfB Stuttgart", "Augsburg", "VfL Bochum", "Hertha Berlin", "TSG Hoffenheim", "Arminia Bielefeld",
				"FC Koln", "FSV Mainz", "Greuther Furth"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	//Exceptions
	public TreeMap <String, Integer> teamsExceptions() {
		TreeMap<String, Integer> teamsExceptions = new TreeMap<>();
		teamsExceptions.put("Brentford", 2019);
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