package buk.Services.bukTeams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buk.Entities.Country;
import buk.Entities.Teams;
import buk.repositories.CountryRepository;
import buk.repositories.TeamsRepository;

@Service
public class TeamGenerator {
	
	@Autowired
	public TeamsRepository teamsRepository;
	
	@Autowired
	public CountryRepository countryRep;
	
	int polandEkstraklasa=1000;
	int englandPremier=2000;
	int italySerieA=3000;
	int spainLaLiga=4000;
	int germanyBundesliga=5000;
	int franceLigue1=6000;
	int netherlandsEredivisie=7000;
	int portugalPrimeiraLiga=8000;
	int turkeySuperLig=9000;
	int russiaPremier=10000;
	int belarus1league=11000;
	int belgiumJupiter=12000;
	
	
	Map<Integer,String> teams = new HashMap<Integer, String>();

	public void teamsGenerator() {
		polandEkstraklasa();
		englandPremier();
		germanyBundesliga();
		italySerieA();
		spainLaLiga();
		franceLigue1();
		netherlandsEredivisie();
		portugalPrimeiraLiga();
		turkeySuperLig();
		russiaPremier();
		belarus1();
		belgiumJupiter();
	}

	public void setCountry (){

	}

	public void russiaPremier() {
		int setId=russiaPremier;
		String teamList[] = new String [] {"Zenit", "CSKA Moscow", "Spartak Moscow", "Sochi", "Rostov", "Dinamo Moscow", "Krasnodar",
				"Lokomotiv Moscow", "Rubin Kazan", "Akhmat", "Khimki", "Ural", "Krylya", "Arsenal Tula", "Ufa", "Nizhny Novgorod"
		, "Torpedo Moskva", "Fakel", "Orenburg"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("russia");
		country.setLeagueName("Russia Premier League");
		country.setId(1200L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}

	public void turkeySuperLig() {
		int setId=turkeySuperLig;
		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gaziantep", "Trabzonspor", "Alanyaspor", "Hatayspor",
				"Karagumruk", "Yeni Malatyaspor", "Antalyaspor", "Goztepe", "Rizespor", "Sivasspor", "Istanbul BFK", "Konyaspor", "Kasimpasa",
				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir", "Ankaragucu", "Umraniyespor", "Istanbulspor AS"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("turkey");
		country.setLeagueName("Turkey Super Lig");
		country.setId(1000L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}


	public void portugalPrimeiraLiga() {
		int setId=portugalPrimeiraLiga;
		String teamList[] = new String [] {"Sporting CP", "FC Porto", "Benfica", "Sporting Braga", "Pacos de Ferreira", "Vitoria Guimaraes", "Moreirense",
				"Maritimo", "Santa Clara", "Estoril Prai", "Tondela", "Portimonense", "Famalicao", "Arouca", "Gil Vicente", "Vizela",
				"Belenenses", "Boavista", "Rio Ave", "Casa Pia", "GD Chaves"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("portugal");
		country.setLeagueName("Portugal Primeira Liga");
		country.setId(900L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}


	public void netherlandsEredivisie() {
		int setId=netherlandsEredivisie;
		String teamList[] = new String [] {"Ajax", "Vitesse", "PSV Eindhoven", "Feyenoord", "AZ Alkmaar", "Groningen", "Twente",
				"Heerenveen", "Sparta Rotterdam", "Utrecht", "Heracles", "PEC Zwolle", "Fortuna Sittard", "SC Cambuur", "RKC Waalwijk", "Go Ahead Eagles",
				"Willem II", "Nec Nijmegen", "Emmen", "Volendam", "Excelsior"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("netherlands");
		country.setLeagueName("Netherlands Eredivisie");
		country.setId(700L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}

	public void franceLigue1() {
		int setId=franceLigue1;
		String teamList[] = new String [] {"PSG", "Lille", "Olympique Lyon", "Monaco", "Rennes", "Olympique Marseille", "Lens",
				"Angers", "Bordeaux", "Metz", "Montpellier", "Brestois", "Nice", "Strasbourg", "Reims", "Saint-Etienne",
				"Nantes", "Troyes", "Clermont Foot", "Lorient", "Toulouse", "Ajaccio", "Auxerre"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("france");
		country.setLeagueName("France Ligue 1");
		country.setId(600L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}

	public void germanyBundesliga() {
		int setId=germanyBundesliga;
		String teamList[] = new String [] {"Bayern", "RB Lipsk", "Leverkusen", "Dortmund", "Union Berlin", "Wolfsburg", "Frankfurt",
				"Moenchengladbach", "Freiburg", "Stuttgart", "Augsburg", "Bochum", "Hertha", "Hoffenheim", "Bielefeld", "FC Koeln"
				, "Mainz", "Greuther Fürth", "Schalke 04", "Werder Brema"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("germany");
		country.setLeagueName("Germany Bundesliga");
		country.setId(500L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}



	public void spainLaLiga() {
		int setId=spainLaLiga;
		String teamList[] = new String [] {"Atletico", "Real Madrid", "Sevilla", "Barcelona", "Villarreal", "Real Sociedad", "Granada",
				"Real Betis", "Cadiz", "Levante", "Getafe", "Celta Vigo", "Athletic Club", "Valencia", "Espanyol Barcelona", "Mallorka"
				, "Deportivo Alavas", "Elche", "Osasuna", "Rayo Vallecano", "Girona FC", "Real Valladolid", "Almeria"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("spain");
		country.setLeagueName("Spain La Liga");
		country.setId(400L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}

	public void italySerieA() {
		int setId=italySerieA;
		String teamList[] = new String [] {"Milan", "Inter", "Roma", "Atalanta", "Napoli", "Juventus", "Lazio",
				"Sassuolo", "Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna", "Udinese", "Spezia", "Genoa"
				, "Cagliari", "Torino", "Venezia", "Salernitana", "Lecce", "Cremonese", "Monza Brianza"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("italy");
		country.setLeagueName("Italy Serie A");
		country.setId(300L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}


	public void englandPremier() {
		int setId=englandPremier;
		String teamList[] = new String [] {"Manchester Utd", "Manchester City", "Leicester", "Liverpool", "Tottenham", "Everton", "West Ham",
				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds", "Crystal Palace", "Wolverhampton", "Newcastle", "Burnley"
				, "Brighton", "Norwich", "Watford", "Brentford", "Fulham", "AFC Bournemouth", "Nottingham Forest"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("england");
		country.setLeagueName("England Premier League");
		country.setId(200L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}


	public void polandEkstraklasa() {
		int setId=polandEkstraklasa;
		String teamList[] = new String [] {"Legia Warszawa", "Piast Gliwice", "Lech Poznań", "Śląsk Wrocław", "Cracovia", "Pogoń Szczecin", "Jagiellonia Białystok",
				"Lechia Gdańsk", "Górnik Zabrze", "Raków Częstochowa", "Zagłębie Lubin", "Wisła Płock", "Wisła Kraków", "Warta", "Mielec", "Radomiak Radom",
				"Termalica", "Górnik Łęczna", "Miedź Legnica", "Widzew Łódź", "Korona Kielce"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("Poland");
		country.setLeagueName("Poland Ekstraklasa");
		country.setId(950L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}

	public void belarus1() {
		int setId=belarus1league;
		String teamList[] = new String [] {"Shakhtyor", "BATE", "Torpedo BelAZ", "Dinamo Brest", "Neman Grodno", "Dinamo Minsk", "Isloch",
				"Ruh Brest", "Slavia", "Energetyk-BGU", "Minsk", "Vitebsk", "Gorodeya", "Slutsk", "Belshina", "Smolevichy-STI"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("belarus");
		country.setLeagueName("Belarus Vysshaya Liga");
		country.setId(1100L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}

	public void belgiumJupiter() {
		int setId=belgiumJupiter;
		String teamList[] = new String [] {"Union Saint-Gilloise", "Club Brugge", "Anderlecht", "Antwerp", "Gent", "Mechelen", "Charleroi",
				"Kortrijk", "Genk", "Leuven", "Cercle Brugge", "Eupen", "Sint Truidense", "Oostende", "Standard Liege", "Zulte Waregem",
				"Seresien", "Beerschot", "KVC Westerlo"};
		for (int i=0; i<teamList.length; i++) {
			teams.put(setId, teamList[i]);
			setId++;
		}
		Country country = new Country();
		country.setCountry("belgium");
		country.setLeagueName("Belgium Jupiler League");
		country.setId(800L);
		countryRep.save(country);
		saveTeams(teamList, teams, country);
		teams.clear();
	}


	// BACK UP OF TEAMS!
	
//	public void russiaPremier() {
//		int setId=russiaPremier;
//		String teamList[] = new String [] {"Zenit", "CSKA Moscow", "Spartak Moscow", "Sochi", "Rostov", "Dinamo Moscow", "Krasnodar",
//				"Lokomotiv Moscow", "Rubin Kazan", "Akhmat Grozny", "Khimki", "Ural", "Krylya Sovetov", "Arsenal Tula", "Ufa", "Nizhny Novgorod"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("russia");
//		country.setLeagueName("Russia Premier League");
//		country.setId(1200L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//	public void turkeySuperLig() {
//		int setId=turkeySuperLig;
//		String teamList[] = new String [] {"Besiktas", "Fenerbahce", "Galatasaray", "Gaziantep", "Trabzonspor", "Alanyaspor", "Hatayspor",
//				"Karagumruk", "Yeni Malatyaspor", "Antalyaspor", "Goztepe", "Rizespor", "Sivasspor", "Istanbul BFK", "Konyaspor", "Kasimpasa",
//				"Kayserispor", "Adana Demirspor", "Giresunspor", "Altay Izmir"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("turkey");
//		country.setLeagueName("Turkey Super Lig");
//		country.setId(1000L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//
//	public void portugalPrimeiraLiga() {
//		int setId=portugalPrimeiraLiga;
//		String teamList[] = new String [] {"Sporting CP", "FC Porto", "Benfica", "Sporting Braga", "Pacos de Ferreira", "Vitoria Guimaraes", "Moreirense",
//				"Maritimo", "Santa Clara", "Estoril Prai", "Tondela", "Portimonense", "Famalicao", "Arouca", "Gil Vicente", "Vizela",
//				"Belenenses", "Boavista"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("portugal");
//		country.setLeagueName("Portugal Primeira Liga");
//		country.setId(900L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//
//	public void netherlandsEredivisie() {
//		int setId=netherlandsEredivisie;
//		String teamList[] = new String [] {"Ajax", "Vitesse", "PSV Eindhoven", "Feyenoord", "AZ Alkmaar", "Groningen", "Twente",
//				"Heerenveen", "Sparta Rotterdam", "Utrecht", "Heracles", "PEC Zwolle", "Fortuna Sittard", "SC Cambuur", "RKC Waalwijk", "Go Ahead Eagles",
//				"Willem II", "Nec Nijmegen"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("netherlands");
//		country.setLeagueName("Netherlands Eredivisie");
//		country.setId(700L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//	public void franceLigue1() {
//		int setId=franceLigue1;
//		String teamList[] = new String [] {"PSG", "Lille", "Olympique Lyon", "Monaco", "Rennes", "Olympique Marseille", "Lens",
//				"Angers", "Bordeaux", "Metz", "Montpellier", "Brestois", "Nice", "Strasbourg", "Reims", "Saint-Etienne",
//				"Nantes", "Troyes", "Clermont Foot", "Lorient"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("france");
//		country.setLeagueName("France Ligue 1");
//		country.setId(600L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//	public void germanyBundesliga() {
//		int setId=germanyBundesliga;
//		String teamList[] = new String [] {"Bayern", "RB Lipsk", "Leverkusen", "Dortmund", "Union Berlin", "Wolfsburg", "Frankfurt",
//				"Moenchengladbach", "Freiburg", "Stuttgart", "Augsburg", "Bochum", "Hertha", "Hoffenheim", "Bielefeld", "FC Koeln"
//				, "Mainz", "Greuther Fürth"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("germany");
//		country.setLeagueName("Germany Bundesliga");
//		country.setId(500L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//
//
//	public void spainLaLiga() {
//		int setId=spainLaLiga;
//		String teamList[] = new String [] {"Atletico Madrid", "Real Madrid", "Sevilla", "Barcelona", "Villarreal", "Real Sociedad", "Granada",
//				"Real Betis", "Cadiz", "Levante", "Getafe", "Celta Vigo", "Athletic Club", "Valencia", "Espanyol Barcelona", "Mallorka"
//				, "Deportivo Alavas", "Elche", "Osasuna", "Rayo Vallecano"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("spain");
//		country.setLeagueName("Spain La Liga");
//		country.setId(400L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//	public void italySerieA() {
//		int setId=italySerieA;
//		String teamList[] = new String [] {"Milan", "Inter", "Roma", "Atalanta", "Napoli", "Juventus", "Lazio",
//				"Sassuolo", "Verona", "Sampdoria", "Empoli", "Fiorentina", "Bologna", "Udinese", "Spezia", "Genoa"
//				, "Cagliari", "Torino", "Venezia", "Salernitana"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("italy");
//		country.setLeagueName("Italy Serie A");
//		country.setId(300L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//
//	public void englandPremier() {
//		int setId=englandPremier;
//		String teamList[] = new String [] {"Manchester United", "Manchester City", "Leicester City", "Liverpool", "Tottenham Hotspur", "Everton", "West Ham United",
//				"Chelsea", "Southampton", "Arsenal", "Aston Villa", "Leeds United", "Crystal Palace", "Wolverhampton", "Newcastle United", "Burnley"
//				, "Brighton", "Norwich", "Watford", "Brentford"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("england");
//		country.setLeagueName("England Premier League");
//		country.setId(200L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//
//	public void polandEkstraklasa() {
//		int setId=polandEkstraklasa;
//		String teamList[] = new String [] {"Legia Warszawa", "Piast Gliwice", "Lech Poznań", "Śląsk Wrocław", "Cracovia", "Pogoń Szczecin", "Jagiellonia Białystok",
//				"Lechia Gdańsk", "Górnik Zabrze", "Raków Częstochowa", "Zagłębie Lubin", "Wisła Płock", "Wisła Kraków", "Warta", "Mielec", "Radomiak Radom",
//				"Termalica", "Górnik Łęczna"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("Poland");
//		country.setLeagueName("Poland Ekstraklasa");
//		country.setId(950L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//	public void belarus1() {
//		int setId=belarus1league;
//		String teamList[] = new String [] {"Shakhtyor", "BATE", "Torpedo BelAZ", "Dinamo Brest", "Neman Grodno", "Dinamo Minsk", "Isloch",
//				"Ruh Brest", "Slavia", "Energetyk-BGU", "Minsk", "Vitebsk", "Gorodeya", "Slutsk", "Belshina", "Smolevichy-STI"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("belarus");
//		country.setLeagueName("Belarus Vysshaya Liga");
//		country.setId(1100L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
//
//	public void belgiumJupiter() {
//		int setId=belgiumJupiter;
//		String teamList[] = new String [] {"Union Saint-Gilloise", "Club Brugge", "Anderlecht", "Antwerp", "Gent", "Mechelen", "Charleroi",
//				"Kortrijk", "Genk", "Leuven", "Cercle Brugge", "Eupen", "Sint Truidense", "Oostende", "Standard Liege", "Zulte Waregem",
//				"Seresien", "Beerschot"};
//		for (int i=0; i<teamList.length; i++) {
//			teams.put(setId, teamList[i]);
//			setId++;
//		}
//		Country country = new Country();
//		country.setCountry("belgium");
//		country.setLeagueName("Belgium Jupiler League");
//		country.setId(800L);
//		countryRep.save(country);
//		saveTeams(teamList, teams, country);
//		teams.clear();
//	}
	
	
	
	public void saveTeams (String [] teamList, Map <Integer,String> teams, Country country) {
		for (Map.Entry<Integer, String> x : teams.entrySet()) {
			Teams tt = new Teams();
			tt.setId(x.getKey());
			tt.setTeam(x.getValue());
			tt.setCountry(country);
			teamsRepository.save(tt);
		}
	}
	
	
	
	

}
