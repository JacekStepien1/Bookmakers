	package buk.Services.bukTeams;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotolotekTeams {
	
	@Autowired
	TeamGenerator teamGenerator;
	
	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"Zenit St. Petersburg", "CSKA Moskwa", "Spartak Moskwa", "PFK Soczi", "FK Rostov", "Dynamo Moskwa", "FK Krasnodar",
				"Lokomotiv Moskwa", "FK Rubin Kazań", "Achmat Grozny", "FK Chimki", "Ural", "Rotor Wołgogr.", "Arsenal Tula", "FK Ufa", "FK Tambov"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas JK", "Fenerbahce", "Galatasaray Ista.", "Gaziantep Bld Sp.", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Fatih Karagumruk", "Yeni Malatyaspor", "Antalyaspor", "Goztepespor", "Caykur Rizespor", "Sivasspor", "Basaksehir", "Konyaspor", "Kasimpasa", 
				"Kayserispor", "Genclerbirligi", "MKE Ankaragucu", "Erzurum Buyukseh.", "Denizlispor Kulübü"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting CP", "FC Porto", "Benfica Lizbona", "SC Braga", "FC Pacos Ferreira", "Vitoria Guimaraes", "Moreirense FC",
				"CS Maritimo Made.", "CD Santa Clara", "Rio Ave FC", "CD Tondela", "Portimonense SC", "FC Famalicao", "Nacional Madeira", "Gil Vicente FC", "Sporting Farens", 
				"Belenenses Lizbo.", "Boavista FC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax Amsterdam", "Vitesse Arnhem", "PSV Eindhoven", "Feyenoord Rotter.", "AZ Alkmaar", "FC Groningen", "Twente Enschede",
				"SC Heerenveen", "Sparta Rotterdam", "FC Utrecht", "Heracles Almelo", "FC Zwolle", "Fortuna Sittard", "VVV Venlo", "RKC Waalwijk", "ADO Den Haag", 
				"Willem II Tilburg", "FC Emmen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"Paris SG", "OSC Lille", "Lyon", "AS Monaco FC", "Stade Rennes", "Olympique Marsyl.", "RC Lens",
				"SCO Angers", "Girondins Bordeaux", "FC Metz", "HSC Montpellier", "Stade Brest", "OGC Nice", "Racing Strasbourg", "Stade de Reims", "AC Saint Etienne", 
				"FC Nantes", "Olympique Nimes", "Dijon Fco", "FC Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madryt", "Real Madryt", "Sevilla FC", "FC Barcelona", "FC Villarreal", "Real Sociedad", "Granada CF",
				"Betis Sevilla", "Cadiz CF", "UD Levante", "FC Getafe", "Celta de Vigo", "Athletic Bilbao", "FC Valencia", "Espanyol Barcelo.", "RCD Mallorca"
				, "CD Alaves", "Elche CF", "CA Osasuna", "Rayo Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester United", "Manchester City", "Leicester City", "FC Liverpool", "Tottenham Hotspur", "FC Everton", "West Ham United",
				"Chelsea Londyn", "Southampton FC", "Arsenal Londyn", "Aston Villa", "Leeds United", "Crystal Palace", "Wolverhampton Wanderers FC", "Newcastle United", "FC Burnley"
				, "FC Brighton & Ho.", "Norwich City", "Watford FC", "Brentford FC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	// exc "Lazio Rzym"
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter Mediolan", "AS Roma", "Atalanta BC", "SSC Napoli", "Juventus Turyn", "S.S. Lazio",
				"US Sassuolo", "Hellas Verona", "Sampdoria Genua", "FC Empoli", "Fiorentina", "FC Bologna", "Udinese Calcio", "Spezia Calcio", "Genoa Cfc"
				, "Cagliari", "Torino FC", "Venezia", "US Salernitana 1."};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia Warszawa", "Piast Gliwice", "Lech Poznań", "Śląsk Wrocław",
				"Cracovia Kraków", "Pogoń Szczecin", "Jagiellonia Białystok", "Lechia Gdańsk", "Górnik Zabrze",
				"Raków Częstochowa", "Zagłębie Lubin", "Wisła Płock", "Wisła Kraków", "Warta Poznań", "Stal Mielec",
				"Radomiak Radom","Termalica Bruk-B.", "Górnik Łęczna"}; 
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern Monachium", "RB Leipzig", "Bayer Leverkusen", "Borussia Dortmund", 
				"FC Union Berlin", "VfL Wolfsburg", "Eintracht Frankfurt","Borussia M´gladbach", "SC Freiburg", 
				"VfB Stuttgart", "FC Augsburg", "Werder Brema", "Hertha BSC", "1899 Hoffenheim", "Arminia Bielefeld", 
				"1. FC Koln", "1. Fsv Mainz 05", "Greuther Furth"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	//Exceptions
	public TreeMap<Integer, String> totolotekTeamsExceptions() {
		TreeMap<Integer, String> teamsExceptions = new TreeMap<>();
		teamsExceptions.put(3006, "Lazio Rzym");
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