package buk.Services.bukTeams;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtotoTeams {
	
	@Autowired
	TeamGenerator teamGenerator;

	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"St. Gilloise", "Club Brugge", "Anderlecht", "Antwerp", "Gent", "Mechelen", "Charleroi",
				"Kortrijk", "Genk", "Leuven", "Cercle Brugge", "Eupen", "St. Truidense", "Oostende", "Standard Liege", "Zulte Waregem",
				"Seraing", "Beerschot"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"Zenit St Petersburg", "CSKA Moskwa", "Spartak Moskwa", "FK Sochi", "Rostow", "Dinamo Moskwa", "Krasnodar",
				"Lokomotiv Moskwa", "Rubin Kazań", "Akhmat Grozny", "Khimki", "Ural", "Krylia Sovetov", "Arsenal Tula", "Ufa", "Nizhny Novgorod"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gaziantep", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Karagumruk", "Malatyaspor", "Antalyaspor", "Goztepe", "Rizespor", "Sivasspor", "Basaksehir", "Konyaspor", "Kasimpasa",
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting Lizbona", "FC Porto", "Benfica", "Braga", "Pacos Ferreira", "Vitoria Guimaraes", "Moreirense",
				"Maritimo", "Santa Clara", "Estoril Praia", "Tondela", "Portimonense", "Famalicao", "Arouca", "Gil Vicente", "Vizela",
				"Belenenses", "Boavista"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax", "Vitesse", "PSV", "Feyenoord", "AZ Alkmaar", "Groningen", "Twente",
				"Heerenveen", "Sparta Rotterdam", "Utrecht", "Heracles", "Zwolle", "Fortuna Sittard", "Cambuur", "Waalwijk", "G.A. Eagles",
				"Willem II", "Nijmegen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"PSG", "Lille", "Lyon", "Monaco", "Rennes", "Marsylia", "Lens",
				"Angers", "Bordeaux", "Metz", "Montpellier", "Brest", "Nice", "Strasbourg", "Reims", "St. Etienne",
				"Nantes", "Troyes", "Clermont", "Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madryt", "Real Madryt", "Sevilla", "FC Barcelona", "Villarreal", "Real Sociedad", "Granada",
				"Betis", "Cadiz", "Levante", "Getafe", "Celta Vigo", "Athletic Bilbao", "Valencia", "Espanyol", "Mallorca"
				, "Alaves", "Elche", "Osasuna", "Rayo Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester Utd", "Manchester City", "Leicester", "Liverpool", "Tottenham", "Everton", "West Ham",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds", "Crystal Palace", "Wolverhampton", "Newcastle", "Burnley"
				, "Brighton", "Norwich", "Watford", "Brentford"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter Mediolan", "AS Roma", "Atalanta", "Napoli", "Juventus", "Lazio",
				"Sassuolo", "Hellas Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna", "Udinese", "Spezia", "Genoa"
				, "Cagliari", "Torino", "Venezia", "Salernitana"};
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
				"Union Berlin", "VfL Wolfsburg", "Eintracht Frankfurt","Monchengladbach", "Freiburg",
				"Stuttgart", "Augsburg", "Bochum", "Hertha BSC", "Hoffenheim", "Arminia Bielefeld",
				"FC Koln", "Mainz", "Furth"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	//Exceptions
	public TreeMap<Integer, String> eTotoTeamsExceptions() {
		TreeMap<Integer, String> teamsExceptions = new TreeMap<>();
		teamsExceptions.put(5005, "Wolfsburg");
		teamsExceptions.put(5016, "Mainz");
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