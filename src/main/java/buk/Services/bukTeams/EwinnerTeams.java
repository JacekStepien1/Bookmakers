package buk.Services.bukTeams;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EwinnerTeams {
	
	@Autowired
	TeamGenerator teamGenerator;
// dodane: KAA Gent , KV Kortrijk , Oud-Heverlee Leuven, KV Mechelen, RFC Seraing, Union Saint-Gilloise, SV Zulte Waregem, KV Oostende , Club Brugge,
	// Sint-Truidense VV, Royal Antwerp FC, Royal Charleroi
	// brak: Anderlecht, Genk, Cercle Brugge, Eupen, Standard Liege, Beerschot
	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"Union Saint-Gilloise", "Club Brugge", "RSC Anderlecht", "Royal Antwerp FC", "KAA Gent", "KV Mechelen", "Royal Charleroi",
				"KV Kortrijk", "KRC Genk", "Oud-Heverlee Leuven", "Cercle Brugge", "AS Eupen", "Sint-Truidense VV", "KV Oostende", "Standard Liege", "SV Zulte Waregem",
				"RFC Seraing", "Beerschot VA"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gaziantep FK", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Fatih Karagumruk SK", "Yeni Malatyaspor", "Antalyaspor", "Goztepe", "Caykur Rizespor", "Sivasspor", "Basaksehir FK", "Konyaspor", "Kasimpasa", 
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"FK Zenit Saint Petersburg", "CSKA Moskwa", "FK Spartak Moscow", "PFK Sochi", "FK Rostow", "FK Dinamo Moscow", "FK Krasnodar",
				"FK Lokomotiv Moscow", "FK Rubin Kazan", "RFK Akhmat Grozny", "FK Khimki", "FK Ural Jekaterinburg", "PFK Krylia Sovetov Samara", "PFK Arsenal Tula", "FK Ufa", "Nizhny Novgorod"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting CP", "FC Porto", "SL Benfica", "SC Braga", "FC Pacos de Ferreira", "Vitoria Guimaraes", "Moreirense FC",
				"CS Maritimo Madeira", "CD Santa Clara", "GD Estoril Praia", "CD Tondela", "Portimonense SC", "FC Famalicao", "FC Arouca", "Gil Vicente FC", "FC Vizela",
				"OS Belenenses", "Boavista FC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax Amsterdam", "Vitesse Arnhem", "PSV Eindhoven", "Feyenoord Rotterdam", "AZ Alkmaar", "FC Groningen", "Twente Enschede",
				"SC Heerenveen", "Sparta Rotterdam", "FC Utrecht", "Heracles Almelo", "PEC Zwolle", "Fortuna Sittard", "SC Cambuur", "RKC Waalwijk", "Go Ahead Eagles",
				"Willem II Tilburg", "Nec Nijmegen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"Paris Saint-Germain", "Lille OSC", "Olympique Lyon", "AS Monaco", "Stade Rennes", "Olympique Marsylia", "RC Lens",
				"SCO Angers", "Girondins Bordeaux", "FC Metz", "Montpellier HSC", "Stade Brest", "OGC Nice", "Racing Strasbourg", "Stade Reims", "AS Saint Etienne", 
				"FC Nantes", "Troyes AC", "Clermont Foot", "FC Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atletico Madryt", "Real Madryt", "Sevilla FC", "FC Barcelona", "Villarreal CF", "Real Sociedad", "Granada CF",
				"Real Betis", "Cadiz CF", "Levante UD", "Getafe CF", "RC Celta", "Athletic Club", "Valencia CF", "Espanyol Barcelona", "RCD Mallorca"
				, "Deportivo Alaves", "Elche CF", "CA Osasuna", "Rayo Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manchester United", "Manchester City", "Leicester City", "Liverpool FC", "Tottenham Hotspur", "Everton FC", "West Ham United",
				"Chelsea FC", "Southampton", "Arsenal FC", "Aston Villa", "Leeds United", "Crystal Palace", "Wolverhampton Wanderers", "Newcastle United", "Burnley FC"
				, "Brighton & Hove Albion", "Norwich City", "Watford", "Brentford FC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter Mediolan", "AS Roma", "Atalanta Bergamo", "SSC Napoli", "Juventus FC", "Lazio",
				"US Sassuolo", "Hellas Verona", "Sampdoria", "Empoli FC", "ACF Fiorentina", "Bologna FC", "Udinese", "Spezia Calcio", "Genoa FC"
				, "Cagliari", "FC Torino", "Venezia", "US Salernitana"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia Warszawa", "Piast Gliwice", "Lech Poznań", "Śląsk Wrocław",
				"Cracovia Kraków", "Pogoń Szczecin", "Jagiellonia Białystok", "Lechia Gdańsk", "Górnik Zabrze",
				"Raków Częstochowa", "Zagłębie Lubin", "Wisła Płock", "Wisła Kraków", "Warta Poznań", "Stal Mielec",
				"Radomiak Radom" , "Termalica Bruk-Bet Nieciecza", "Górnik Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern Monachium", "RB Lipsk", "Bayer Leverkusen", "Borussia Dortmund", 
				"1. FC Union Berlin", "VfL Wolfsburg", "Eintracht Frankfurt","Borussia Monchengladbach", "SC Freiburg", 
				"VfB Stuttgart", "FC Augsburg", "VfL Bochum", "Hertha BSC", "TSG 1899 Hoffenheim", "DSC Arminia Bielefeld",
				"1. FC Koln", "1. FSV Mainz 05", "Greuther Furth"};
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
