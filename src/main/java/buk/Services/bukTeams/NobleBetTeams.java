package buk.Services.bukTeams;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NobleBetTeams {
	
	@Autowired
	TeamGenerator teamGenerator;

	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"Union Saint Gilloise", "Club Brugge", "Anderlecht", "Royal Antwerp", "KAA Gent", "KV Mechelen", "Sporting de Charleroi",
				"Kortrijk", "Racing Genk", "Oud-Heverlee Leuven", "Cercle Brugge", "KAS Eupen", "Sint-Truidense VV", "KV Oostende", "Standard Liege", "Zulte Waregem",
				"RFC Seraing", "Beerschot VA"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas JK", "Fenerbahçe SK", "Galatasaray SK", "Gazişehir Gaziantep F.K.", "Trabzonspor", "Alanyaspor", "Hatayspor Antakya",
				"Fatih Karagümrük Istanbul", "Yeni Malatyaspor", "Antalyaspor", "Göztepe", "Caykur Rizespor", "Sivasspor", "Istanbul Basaksehir FK", "Konyaspor", "Kasimpasa SK", 
				"Kayserispor", "Adana Demirspor","Giresunspor", "Altay SK Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting CP", "FC Porto", "Benfica", "Sporting Braga", "Paços de Ferreira", "Vitoria de Guimaraes", "Moreirense FC",
				"Marítimo", "Santa Clara", "Estoril-Praia", "Tondela", "Portimonense", "Famalicão", "Futebol Clube de Arouca", "Gil Vicente", "Vizela",
				"Belenenses", "Boavista FC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax", "Vitesse", "PSV Eindhoven", "Feyenoord", "AZ Alkmaar", "FC Groningen", "FC Twente",
				"Heerenveen", "Sparta Rotterdam", "FC Utrecht", "Heracles Almelo", "PEC Zwolle", "Fortuna Sittard", "Cambuur Leeuwarden", "RKC Waalwijk", "Go Ahead Eagles",
				"Willem II", "NEC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"Paris Saint-Germain", "Lille OSC", "Olympique Lyon", "AS Monaco", "Stade Rennais", "Olympique Marsylia", "RC Lens",
				"Angers SCO", "Girondins de Bordeaux", "FC Metz", "Montpellier HSC", "Stade Brestois 29", "OGC Nice", "RC Strasbourg", "Stade Reims", "Saint-Étienne", 
				"FC Nantes", "Troyes AC", "Clermont Foot", "FC Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madryt", "Real Madryt", "Sevilla", "FC Barcelona", "Villarreal", "Real Sociedad", "Granada CF",
				"Real Betis", "Cádiz", "Levante UD", "Getafe", "Celta Vigo", "Athletic Bilbao", "Valencia", "Espanyol", "Real Mallorca"
				, "Deportivo Alaves", "Elche CF", "Osasuna", "Rayo Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester United", "Manchester City", "Leicester City", "Liverpool", "Tottenham Hotspur", "Everton", "West Ham",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds United", "Crystal Palace", "Wolverhampton Wanderers", "Newcastle United", "Burnley"
				, "Brighton & Hove Albion", "Norwich City", "Watford", "Brentford"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter Mediolan", "AS Roma", "Atalanta", "Napoli", "Juventus", "Lazio",
				"Sassuolo", "Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna", "Udinese", "Spezia", "Genoa"
				, "Cagliari", "Torino", "Venezia", "Salernitana"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia Warszawa", "Piast Gliwice", "Lech Poznań", "Śląsk Wrocław",
				"KS Cracovia", "Pogoń Szczecin", "Jagiellonia Białystok", "Lechia Gdańsk", "Górnik Zabrze",
				"Raków Częstochowa", "Zagłębie Lubin", "Wisła Płock", "Wisła Kraków", "Warta Poznań", "Stal Mielec",
				"Radomiak Radom", "Termalica Bruk-Bet Nieciecza", "Górnik Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	//Germany Bundesliga
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"FC Bayern Monachium", "RB Lipsk", "Bayer 04 Leverkusen", "Borussia Dortmund",
				"1. FC Union Berlin", "VfL Wolfsburg", "Eintracht Frankfurt","Borussia Mönchengladbach", "SC Freiburg", 
				"VfB Stuttgart", "FC Augsburg", "VfL Bochum", "Hertha BSC", "1899 Hoffenheim", "Arminia Bielefeld",
				"1. FC Köln", "1. FSV Mainz 05", "SpVgg Greuther Fürth"};
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