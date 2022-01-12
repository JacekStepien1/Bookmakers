package buk.Services.bukTeams;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FortunaTeams {
	
	@Autowired
	TeamGenerator teamGenerator;

	public TreeMap<Integer, String> belgiumJupiter() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belgiumJupiter;
		String teamList[] = new String [] {"St.Gilloise", "Club Brugge", "Anderlecht", "FC Antwerp", "Gent", "KV Mechelen", "Charleroi",
				"Kortrijk", "Genk", "OH Leuven", "Cercle Brugge", "Eupen", "Sint Truiden", "Oostende", "St.Liege", "Waregem",
				"RFC Seraing", "Beerschot VA"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> turkeySuperLig() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gaziantep FK", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Karagumruk", "Yeni Malatyaspor", "Antalyaspor", "Goztepe", "Caykur Rizespor", "Sivasspor", "Istanbul Basaksehir", "Konyaspor", "Kasimpasa", 
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	public TreeMap<Integer, String> russiaPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.russiaPremier;
		String teamList[] = new String [] {"Zenit St.Petersb.", "CSKA M.", "Sp.Moskwa", "Soczi", "FK Rostow", "Dynamo M.", "FK Krasnodar",
				"Lok.Moskwa", "Kazan", "Akhmat Grozny", "Chimki", "Jekaterinburg", "KS Samara", "Arsenal Tula", "Ufa", "N.Novgorod"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	
	public TreeMap<Integer, String> portugalPrimeiraLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting L.", "FC Porto", "SL Benfica", "SC Braga", "Pacos Ferreira", "Vitoria Guimarares", "Moreirense FC",
				"Maritimo Madeira", "Santa Clara", "Estoril Praia", "CD Tondela", "Portimonense", "FC Famalicao", "FC Arouca", "Gil Vicente FC", "FC Vizela",
				"Belenenses SAD", "Boavista FC"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> netherlandsEredivisie() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax", "Vitesse Arnhem", "PSV Eindhoven", "Feyenoord", "AZ Alkmaar", "Groningen", "Tw.Enschede",
				"Heerenveen", "Sparta Rotterdam", "Utrecht", "Heracles", "Zwolle", "Sittard", "Cambuur", "Waalwijk", "G.A.Eagles",
				"Tilburg", "Nijmegen"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> franceLigue1() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.franceLigue1;
		String teamList[] = new String [] {"Paris SG", "Lille", "Lyon", "Monaco", "Rennes", "Marseille", "Lens",
				"Angers", "Bordeaux", "Metz", "Montpellier", "Brest", "Nice", "Strasbourg", "Reims", "St.Etienne", 
				"Nantes", "Troyes", "Clermont", "Lorient"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> spainLaLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.spainLaLiga;
		String teamList[] = new String [] {"Atl. Madryt", "Real M.", "FC Sevilla", "Barcelona", "Villarreal", "Real Sociedad", "Granada",
				"Betis", "Cadiz", "Levante", "Getafe", "Celta Vigo", "Bilbao", "Valencia", "Espanyol", "Mallorca"
				, "Alaves", "Elche", "Osasuna", "Vallecano"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> englandPremier() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.englandPremier;
		String teamList[] = new String [] {"Manch.Utd.", "Manch.City", "Leicester", "Liverpool", "Tottenham", "Everton", "West Ham",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds", "Cr.Palace", "Wolverhampton", "Newcastle", "Burnley"
				, "Brighton", "Norwich", "Watford", "Brentford"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	public TreeMap<Integer, String> italySerieA() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.italySerieA;
		String teamList[] = new String [] {"AC Milan", "Inter M.", "AS Roma", "A.Bergamo", "Napoli", "Juventus", "Lazio",
				"Sassuolo", "Hellas Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna", "Udinese", "Spezia", "Genoa"
				, "Cagliari", "Torino", "Venezia", "Salernitana"};
		insertTeams(teamList, teams, setId);
		return teams;
	}

	public TreeMap<Integer, String> polandEkstraklasa() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.polandEkstraklasa;
		String teamList[] = new String[] { "Legia W.", "Piast G.", "Lech P.", "Śląsk W.",
				"Cracovia", "Pogoń Sz.", "Jagiellonia", "Lechia G.", "Górnik Z.",
				"Raków Cz.", "Zag.Lubin", "W.Płock", "Wisła K.", "Warta Poz.", "S.Mielec",
				"R.Radom", "Nieciecza", "G.Łęczna"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public TreeMap<Integer, String> bundesLiga() {
		TreeMap<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.germanyBundesliga;
		String teamList[] = new String[] {"Bayern M.", "Leipzig", "Leverkusen", "Dortmund", 
				"Un. Berlin", "Wolfsburg", "Eint.Frankfurt","M gladbach", "Freiburg", 
				"VFB Stuttgart", "Augsburg", "Bochum", "Hertha", "Hoffenheim", "Bielefeld",
				"1.FC Koln", "Mainz", "Furth"};
		insertTeams(teamList, teams, setId);
		return teams;
	}
	
	public Map<Integer, String> belarus1LeagueFortuna() {
		Map<Integer, String> teams = new TreeMap<>();
		int setId = teamGenerator.belarus1league;
		String teamList[] = new String[] { "Slutsk", "T.Zhodino", "BATE Borisov", "Energetik BGU",
				"Isloch Minsk", "S.Soligorsk", "Slavia Mozyr", "Vitebsk", "Gorodeya",
				"Dyn.Brest", "Rukh Brest", "FC Minsk", "Dyn.Minsk", "Nem.Grodno", "Smolevichy",
				"Belshina" };
		for (int i = 0; i < 16; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
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




















