package buk.Services.bukTeams;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PzBukTeams {
	
	@Autowired
	TeamGenerator teamGenerator;

	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"Saint Gilloise", "Club Brugge", "Anderlecht", "Antwerp", "Gent", "KV Mechelen", "Charleroi",
				"Kortrijk", "Genk", "Oud Heverlee", "Cercle Brugge", "Eupen", "Sint Truiden", "Oostende", "Standard Liege", "Zulte Waregem",
				"RFC Seraing", "K Beerschot VA"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"Zenit St. Petersburg", "CSKA Moskwa", "Spartak Moskwa", "FC Sochi", "FC Rostov", "Dynamo Moskwa", "FC Krasnodar",
				"Lokomotiv Moskwa", "Rubin Kazan", "FC Akhmat Grozny", "FC Khimki", "Ural Ekaterinburg", "Rotor Volgograd", "Arsenal Tula", "FC Ufa", "FK Tambov"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gazisehir Gaziantep", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Karagumruk", "Yeni Malatyaspor", "Antalyaspor", "Goztepe Izmir", "Rizespor", "Sivasspor", "Istanbul Basaksehir", "Konyaspor", "Kasimpasa", 
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting Lizbona", "FC Porto", "Benfica", "Braga", "Pacos Ferreira", "Vitoria Guimaraes", "Moreirense",
				"Maritimo", "CD Santa Clara", "Estoril", "CD Tondela", "Portimonense", "FC Famalicao", "Arouca", "Gil Vicente", "Vizela",
				"Belenenses SAD", "Boavista"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax", "Vitesse", "PSV Eindhoven", "Feyenoord", "AZ Alkmaar", "Groningen", "Twente",
				"Heerenveen", "Sparta Rotterdam", "Utrecht", "Heracles", "Zwolle", "Fortuna Sittard", "Cambuur", "Waalwijk", "Go Ahead Eagles",
				"Willem II", "Nijmegen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"Paris St-Germain", "Lille", "Lyon", "Monako", "Stade Rennes", "Marseille", "Lens",
				"Angers", "Bordeaux", "Metz", "Montpellier", "Stade Brest", "Nice", "Strasbourg", "Reims", "Saint Etienne", 
				"Nantes", "Troyes", "Clermont", "Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madrid", "Real Madryt", "Sevilla", "Barcelona", "Villarreal", "Real Sociedad", "Granada CF",
				"Real Betis", "Cadiz", "Levante", "Getafe", "Celta Vigo", "Athletic Bilbao", "Valencia", "Espanyol", "Mallorca"
				, "Alaves", "Elche", "Osasuna", "Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester United", "Man City", "Leicester", "Liverpool", "Tottenham", "Everton", "West Ham",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds", "Crystal Palace", "Wolves", "Newcastle", "Burnley"
				, "Brighton", "Norwich", "Watford", "Brentford"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter Milan", "AS Roma", "Atalanta", "Napoli", "Juventus", "Lazio",
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
				"Radomiak Radom", "BB Termalica Nieciecza", "Górnik Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern Monachium", "RB Leipzig", "Bayer Leverkusen", "Dortmund", 
				"Union Berlin", "Wolfsburg", "Eintracht Frankfurt","Monchengladbach", "Freiburg", 
				"Stuttgart", "Augsburg", "Bochum", "Hertha Berlin", "Hoffenheim", "Bielefeld",
				"Cologne", "Mainz", "Furth"};
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