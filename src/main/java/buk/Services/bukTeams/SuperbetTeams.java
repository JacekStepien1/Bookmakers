package buk.Services.bukTeams;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperbetTeams {
	
	@Autowired
	TeamGenerator teamGenerator;

	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"Un. St.Gilloise", "Club Brugge", "Anderlecht", "Antwerpia", "Gent", "Mechelen", "Charleroi",
				"Kortrijk", "Genk", "OH Leuven", "Cercle Brugge", "Eupen", "St.Truidense", "Oostende", "Standard L.", "Zulte Waregem",
				"Seraing", "Beerschot"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gaziantep", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"F.Karagumruk", "Y.Malatyaspor", "Antalyaspor", "Goztepespor", "C.Rizespor", "Sivasspor", "Basaksehir FK", "Konyaspor", "Kasimpasa",
				"Kayserispor", "Adana D.", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting L.", "Porto", "Benfica", "Braga", "P.Ferreira", "Guimaraes", "Moreirense",
				"Maritimo", "Santa Clara", "Estoril", "Tondela", "Portimonense", "Famalicao", "Arouca", "Gil Vicente", "Vizela",
				"Belenenses", "Boavista"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax", "Vitesse", "PSV", "Feyenoord", "AZ Alkmaar", "Groningen", "Twente",
				"Heerenveen", "Sparta R.", "Utrecht", "Heracles", "Zwolle", "Fortuna S.", "Cambuur", "Waalwijk", "G.A. Eagles",
				"Willem II", "NEC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"PSG", "Lille", "Lyon", "Monaco", "Rennes", "Marsylia", "Lens",
				"Angers", "Bordeaux", "Metz", "Montpellier", "Brest", "Nice", "Strasbourg", "Reims", "St.Etienne", 
				"Nantes", "Troyes", "Clermont Foot", "Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atl.Madryt", "Real Madryt", "Sevilla", "Barcelona", "Villarreal", "Sociedad", "Granada",
				"Betis", "Cadiz", "Levante", "Getafe", "Celta", "Bilbao", "Valencia", "Espanyol", "Mallorca"
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
		String teamList[] = new String [] {"AC Milan", "Inter M.", "Roma", "Atalanta", "Napoli", "Juventus", "Lazio",
				"Sassuolo", "Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna", "Udinese", "Spezia", "Genoa"
				, "Cagliari", "Torino", "Venezia", "Salernitana"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	//Poland ekstraklasa
	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia", "Piast", "Lech", "Śląsk",
				"Cracovia", "Pogoń", "Jagiellonia", "Lechia", "Górnik Z.",
				"Raków", "Zagłębie L.", "W.Płock", "W.Kraków", "Warta", "Mielec",
				"Radomiak", "Nieciecza", "Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	//Germany Bundesliga
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern M.", "RB Lipsk", "Leverkusen", "Dortmund",
				"Union Berlin", "Wolfsburg", "Eintracht F.","M'gladbach", "Freiburg",
				"Stuttgart", "Augsburg", "Bochum", "Hertha", "Hoffenheim", "A.Bielefeld",
				"Koln", "Mainz", "Greuther Furth"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	public TreeMap <Integer, String> insertTeams (String[] teamList, TreeMap <Integer, String> teams, int setId){
		for (int i = 0; i < teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		return teams;
	}
	
}
