package buk.Services.bukTeams;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetfanTeams {
	
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
		String teamList[] = new String [] {"St. Gilloise", "Club Brugge", "Anderlecht", "Royal Antwerpia", "Gent", "KV Mechelen", "Charleroi",
				"Kortrijk", "Genk", "Oud-Heverlee", "Cercle Brugge", "Eupen", "St. Truiden", "Oostende", "Standard Liege", "Zulte Waregem",
				"RFC Seraing", "Beerschot-Wilrijk"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"Zenit St Petersburg", "CSKA Moskwa", "Spartak Moskwa", "PFK Soczi", "Rostów", "Dynamo Moskwa", "Krasnodar",
				"Lokomotiv Moskwa", "Rubin Kazań", "Akhmat Grozny", "Chimki", "Ural Jekaterinburg", "Kryliya Sovetov", "Arsenał Tula", "Ufa", "Nizhny Novgorod"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gaziantep Bld Spor", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Fatih Karagumruk", "Malatya Bld Spor", "Antalyaspor", "Goztepe", "Caykur Rizespor", "Sivasspor", "Basaksehir", "Atiker Konyaspor", "Kasimpasa",
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting Lizbona", "FC Porto", "Benfica", "Sporting Braga", "Pacos Ferreira", "Vitoria Guimaraes", "Moreirense",
				"Maritimo", "Santa Clara", "Estoril", "Tondela", "Portimonense", "Famalicao", "Arouca", "Gil Vicente", "Vizela",
				"Belenenses", "Boavista"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax", "Vitesse Arnhem", "PSV Eindhoven", "Feyenoord Rotterdam", "AZ Alkmaar", "Groningen", "Twente Enschede",
				"Heerenveen", "Sparta Rotterdam", "Utrecht", "Heracles", "Zwolle", "Fortuna Sittard", "Cambuur", "RKC Waalwijk", "Go Ahead Eagles",
				"Willem II", "NEC Nijmegen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"PSG", "Lille", "Olympique Lyon", "Monaco", "Rennes", "Olympique Marsylia", "Lens",
				"Angers", "Bordeaux", "Metz", "Montpellier", "Brest", "Nice", "Strasbourg", "Reims", "Saint Etienne", 
				"Nantes", "Troyes", "Clermont", "Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madryt", "Real Madryt", "Sevilla", "FC Barcelona", "Villarreal", "Real Sociedad", "Granada",
				"Betis", "Cadiz", "Levante", "Getafe", "Celta Vigo", "Athletic Bilbao", "Valencia", "Espanyol Barcelona", "Mallorca"
				, "Alaves", "Elche", "Osasuna", "Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester United", "Manchester City", "Leicester", "Liverpool", "Tottenham", "Everton", "WHU",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds United", "Crystal Palace", "Wolverhampton", "Newcastle", "Burnley"
				, "Brighton", "Norwich", "Watford", "Brentford"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter Mediolan", "AS Roma", "Atalanta Bergamo", "Napoli", "Juventus", "Lazio Rzym",
				"Sassuolo", "Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna", "Udinese", "Spezia", "Genoa"
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
				"Radomiak Radom", "Nieciecza", "Górnik Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> germanyBundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern Monachium", "RB Lipsk", "Bayer Leverkusen", "Borussia Dortmund",
				"Union Berlin", "Wolfsburg", "Eintracht Frankfurt","Borussia M´Gladbach", "Freiburg",
				"Stuttgart", "Augsburg", "Bochum", "Hertha", "Hoffenheim", "Arminia Bielefeld",
				"FC Koln", "Mainz", "Greuther Furth"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	
}