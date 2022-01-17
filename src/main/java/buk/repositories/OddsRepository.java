package buk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import buk.Entities.Matches;
import buk.Entities.Odds;

@Repository
public interface OddsRepository extends JpaRepository<Odds, Long>{
	
	List <Odds> findByMatchIdAndBukOrderByDateTimeDesc(Long MatchId, String buk);

	Odds findFirstByBukAndMatchIdOrderByDateTimeDesc(String buk, Long id);

	
	@Query("SELECT MAX (o.home) FROM Odds o INNER JOIN o.match m WHERE m.id=?1")
	double maxOddsHome (Long id);
	
	@Query("SELECT MAX (o.draw) FROM Odds o INNER JOIN o.match m WHERE m.id=?1")
	double maxOddsDraw (Long id);
	
	@Query("SELECT MAX (o.away) FROM Odds o INNER JOIN o.match m WHERE m.id=?1")
	double maxOddsAway (Long id);
	

}
