package buk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import buk.Entities.Country;
import buk.Entities.Matches;

public interface CountryRepository extends JpaRepository<Country, Long> {
	@Query("SELECT c.leagueName from Country c WHERE c.country =?1")
	String league (String league);
}
