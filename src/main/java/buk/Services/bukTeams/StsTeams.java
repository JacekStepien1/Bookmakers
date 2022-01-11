package buk.Services.bukTeams;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StsTeams {
	
	@Autowired
	TeamGenerator teamGenerator;

	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"St. Gilloise", "Club Brugge", "Anderlecht", "Antwerp", "Gent", "Mechelen", "Charleroi",
				"Kortrijk", "Genk", "Leuven", "Cercle Brugge", "Eupen", "St. Truiden", "Oostende", "St. Liege", "Waregem",
				"Seraing", "Beerschot"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"St. Petersburg", "CSKA Moskwa", "Sp. Moskwa", "Sochi", "Rostov", "Dyn. Moskwa", "Krasnodar",
				"Lok. Moskwa", "Rubin Kazań", "Grozny", "Khimki", "Ural", "Samara", "Tula", "Ufa", "N. Novogrod"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gaziantep", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Karagumruk", "Yeni Malatya", "Antalyaspor", "Goztepe", "Rizespor", "Sivasspor", "Basaksehir", "Konyaspor", "Kasimpasa", 
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sp. Lizbona", "FC Porto", "Benfica", "Braga", "P. Ferreira", "V. Guimaraes", "Moreirense",
				"Maritimo", "Santa Clara", "Estoril", "Tondela", "Portimonense", "Famalicao", "Arouca", "Gil Vicente", "Vizela",
				"Belenenses", "Boavista"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax", "Vitesse", "PSV", "Feyenoord", "Alkmaar", "Groningen", "Twente",
				"Heerenveen", "Sp. Rotterdam", "Utrecht", "Heracles", "Zwolle", "F. Sittard", "Cambuur", "Waalwijk", "Go Ahead",
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
		String teamList[] = new String [] {"Atl. Madryt", "Real Madryt", "Sevilla", "Barcelona", "Villarreal", "Real Sociedad", "Granada",
				"Betis", "Cadiz", "Levante", "Getafe", "Celta", "Bilbao", "Valencia", "Espanyol", "Mallorca"
				, "Alaves", "Elche", "Osasuna", "R. Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Man. Utd", "Man. City", "Leicester", "Liverpool", "Tottenham", "Everton", "West Ham",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds", "Crystal Palace", "Wolverhampton", "Newcastle", "Burnley"
				, "Brighton", "Norwich", "Watford", "Brentford"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"Milan", "Inter", "Roma", "Atalanta", "Napoli", "Juventus", "Lazio",
				"Sassuolo", "Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna", "Udinese", "Spezia", "Genoa"
				, "Cagliari", "Torino", "Venezia", "Salernitana"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia", "Piast", "Lech", "Śląsk",
				"Cracovia", "Pogoń", "Jagiellonia", "Lechia", "G. Zabrze",
				"Raków", "Zagłębie L.", "W. Płock", "W. Kraków", "Warta", "Mielec", "Radomiak", "Nieciecza", "G. Łęczna" };
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern", "RB Lipsk", "Leverkusen", "Dortmund", 
				"Union Berlin", "Wolfsburg", "Ein. Frankfurt","Moenchengladbach", "Freiburg",
				"Stuttgart", "Augsburg", "Bochum", "Hertha", "Hoffenheim", "Bielefeld",
				"FC Koeln", "Mainz", "Gr. Furth"};
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