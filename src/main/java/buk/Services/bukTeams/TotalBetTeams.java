package buk.Services.bukTeams;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalBetTeams {
	
	@Autowired
	TeamGenerator teamGenerator;

	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"Union Saint-Gilloise", "Club Brugge", "Rsc Anderlecht", "Royal Antwerpia", "KAA Gent", "Yellow-red Kv Mechelen", "Royal Charleroi SC",
				"KV Kortrijk", "KRC Genk", "Oud-heverlee", "Cercle Brugge", "AS Eupen", "St. Truiden Vv", "KV Oostende", "Standard Liege", "SV Zulte Waregem",
				"Rfc Seraing", "Kfco Beerschot Wilrijk"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"Zenit St. Petersburg", "CSKA Moskwa", "Fc Spartak Moskwa", "PFC Sochi", "FC Rostow", "Dynamo Moskwa", "Fc Krasnodar",
				"Fc Lokomotiw Moskwa", "Fk Rubin Kazań", "Fc Akhmat Grozny", "Fc Khimki", "Fc Ural Jekaterinburg", "Fc Kryliya Sovetov Samara", "Arsenal Tula", "Fc Ufa", "Fc Nizhny Novgorod"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray Istambuł", "Gazisehir Gaziantep FK", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Fatih Karagumruk", "Malatya", "Antalyaspor", "Goztepespor", "Caykur Rizespor", "Sivasspor", "Basaksehir Fk", "Konyaspor", "Kasimpasa", 
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting CP", "FC Porto", "Benfica Lizbona", "Sporting Braga", "Fc Pacos Ferreira", "Vitoria Guimaraes", "Moreirense Fc",
				"Cs Maritimo Madeira", "Santa Clara", "Gd Estoril Praia", "Cd Tondela", "Portimonense Sc", "Fc Famalicao", "Fc Arouca", "Gil Vicente Fc", "Fc Vizela",
				"Belenenses Lizbona", "Boavista FC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax Amsterdam", "Vitesse Arnhem", "PSV Eindhoven", "Feyenoord Rotterdam", "AZ Alkmaar", "FC Groningen", "Twente Enschede",
				"SC Heerenveen", "Sparta Rotterdam", "FC Utrecht", "Heracles Almelo", "FC Zwolle", "Fortuna Sittard", "SC Cambuur", "Rkc Waalwijk", "Go Ahead Eagles",
				"Willem II Tilburg", "Nec Nijmegen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	// exc AS Saint-Étienne, Étienne
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"PSG", "LOSC Lille", "Olympique Lyon", "AS Monaco FC", "Stade Rennais", "Olympique Marsylia", "Lens",
				"Angers SCO", "Girondins Bordeaux", "Metz", "Montpellier HSC", "Brest", "OGC Nice", "RC Strasbourg", "Stade de Reims", "AS Saint-Étienne", 
				"FC Nantes", "Troyes", "Clermont", "Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madryt", "Real Madryt", "Fc Sevilla", "FC Barcelona", "Fc Villarreal", "Real Sociedad", "Granada",
				"Real Betis", "Cadiz Cf", "Ud Levante", "Getafe CF", "Celta De Vigo", "Athletic Bilbao", "Fc Valencia", "Espanyol Barcelona", "RCD Mallorca"
				, "Deportivo Alaves Sad", "Elche Cf", "Osasuna", "Rayo Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester United", "Manchester City", "Leicester", "Liverpool", "Tottenham", "Everton", "West Ham",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds", "Crystal Palace", "Wolves", "Newcastle", "Burnley"
				, "Brighton", "Norwich City", "Watford", "Brentford FC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"Ac Milan", "Inter Mediolan", "AS Roma", "Atalanta Bergamo", "Ssc Napoli", "Juventus Turyn", "Lazio Rzym",
				"Sassuolo", "Hellas Verona", "Sampdoria Genua", "FC Empoli", "Acf Fiorentina", "Fc Bologna", "Udinese Calcio", "Spezia Calcio", "Fc Genua"
				, "Cagliari", "Fc Torino", "Venezia", "Sportiva Salernitana"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia Warszawa", "Piast Gliwice", "Lech Poznań", "Śląsk Wrocław",
				"Cracovia", "Pogoń Szczecin", "Jagiellonia Białystok", "Lechia Gdańsk", "Górnik Zabrze",
				"Raków Częstochowa", "Zagłębie Lubin", "Wisła Płock", "Wisła Kraków", "Warta Poznań", "Stal Mielec",
				"Radomiak Radom", "Termalica Bruk-bet Nieciecza", "Górnik Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern Monachium", "RB Lipsk", "Bayer Leverkusen", "Borussia Dortmund", 
				"FC Union Berlin", "VfL Wolfsburg", "Eintracht Frankfurt","Borussia M'gladbach", "SC Freiburg", 
				"VfB Stuttgart", "FC Augsburg", "VfL Bochum", "Hertha BSC", "1899 Hoffenheim", "Arminia Bielefeld",
				"1. FC Köln", "1. FSV Mainz 05", "Greuther Furth"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	//Exceptions
	public TreeMap <String, Integer> teamsExceptions() {
		TreeMap<String, Integer> teamsExceptions = new TreeMap<>();
		teamsExceptions.put("AS Saint", 6015);
		teamsExceptions.put("Étienne", 6015);
		teamsExceptions.put("Cracovia Kraków", 1004);
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