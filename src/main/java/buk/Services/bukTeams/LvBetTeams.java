package buk.Services.bukTeams;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LvBetTeams {
	
	@Autowired
	TeamGenerator teamGenerator;

	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"Royale Union Saint-Gilloise", "Club Brugge KV", "RSC Anderlecht", "Royal Antwerp FC", "KAA Gent", "KV Mechelen", "Royal Charleroi SC",
				"KV Kortrijk", "KRC Genk", "Oud-Heverlee Leuven", "Cercle Brugge KSV", "KAS Eupen", "Sint Truidense VV", "KV Oostende", "Standard Liege", "SV Zulte Waregem",
				"Seraing United", "FCO Beerschot Wilrijk"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray SK", "Gaziantep BB", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Fatih Karagumruk SK", "Yeni Malatyaspor 1986", "Antalyaspor", "Goztepe SK", "Caykur Rizespor", "Sivasspor", "Istanbul Basaksehir", "Torku Konyaspor", "Kasimpasa",
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting CP", "FC Porto", "SL Benfica", "SC Braga", "Pacos Ferreira", "Vitoria Guimaraes", "Moreirense FC",
				"CS Maritimo", "CD Santa Clara", "Estoril Praia", "CD Tondela", "Portimonense SC", "FC Famalicao", "FC Arouca", "Gil Vicente", "FC Vizela",
				"Os Belenenses SAD", "Boavista FC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax Amsterdam", "Vitesse Arnhem", "PSV Eindhoven", "Feyenoord Rotterdam", "AZ Alkmaar", "FC Groningen", "FC Twente",
				"SC Heerenveen", "Sparta Rotterdam", "FC Utrecht", "Heracles Almelo", "PEC Zwolle", "Fortuna Sittard", "SC Cambuur Leeuwarden", "RKC Waalwijk", "Go Ahead Eagles Deventer",
				"Willem II Tilburg", "NEC Nijmegen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"PSG", "Lille OSC", "Olympique Lyon", "AS Monaco", "Stade Rennais", "Olympique Marsylia", "RC Lens",
				"Angers SCO", "Girondins de Bordeaux", "FC Metz", "Montpellier HSC", "Stade Brestois", "OGC Nice", "RC Strasbourg Alsace", "Stade Reims", "AS Saint-Etienne", 
				"FC Nantes", "ES Troyes AC", "Clermont Foot", "FC Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madryt", "Real Madryt CF", "FC Sevilla", "FC Barcelona", "Villarreal CF", "Real Sociedad", "Granada CF",
				"Real Betis", "Cadiz CF", "Levante UD", "Getafe CF", "Celta Vigo", "Athletic Bilbao", "Valencia CF", "RCD Espanyol", "RCD Mallorca"
				, "Deportivo Alaves", "Elche CF", "CA Osasuna", "Rayo Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester United", "Manchester City", "Leicester City FC", "Liverpool FC", "Tottenham Hotspur FC", "Everton FC", "West Ham United",
				"Chelsea FC", "Southampton FC", "Arsenal FC", "Aston Villa", "Leeds United", "Crystal Palace FC", "Wolverhampton Wanderers", "Newcastle United", "Burnley FC"
				, "Brighton and Hove Albion", "Norwich City", "Watford FC", "Brentford"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter Mediolan", "AS Roma", "Atalanta", "SSC Napoli", "Juventus FC", "SS Lazio",
				"US Sassuolo", "Hellas Verona", "UC Sampdoria", "Empoli FC", "Fiorentina", "Bologna FC", "Udinese", "AC Spezia", "Genoa CFC"
				, "Cagliari", "Torino FC", "Venezia", "Salernitana"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia Warszawa", "Piast Gliwice", "KKS Lech Poznań", "Śląsk Wrocław",
				"Cracovia Kraków", "Pogoń Szczecin", "Jagiellonia Białystok", "Lechia Gdańsk", "Górnik Zabrze",
				"KS Raków Częstochowa", "Zagłębie Lubin", "Wisła Płock", "Wisła Kraków", "Warta Poznań", "Stal Mielec",
				"RKS Radomiak Radom", "Termalica Bruk-Bet Nieciecza", "Górnik Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"FC Bayern Monachium", "RB Lipsk", "Bayer Leverkusen", "Borussia Dortmund", "1. FC Union Berlin", "VfL Wolfsburg", "Eintracht Frankfurt",
				"Borussia Monchengladbach", "SC Freiburg", "VfB Stuttgart", "FC Augsburg", "VfL Bochum", "Hertha BSC", "TSG 1899 Hoffenheim", "DSC Arminia Bielefeld", "1.FC Koln"
				, "1. FSV Mainz 05", "SpVgg Greuther Furth"};
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