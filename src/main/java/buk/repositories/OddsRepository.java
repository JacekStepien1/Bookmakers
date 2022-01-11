package buk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import buk.Entities.Matches;
import buk.Entities.Odds;

@Repository
public interface OddsRepository extends JpaRepository<Odds, Long>{
	
	@Query("SELECT DISTINCT m FROM Matches m INNER JOIN m.teams t WHERE t.country=(SELECT z.id FROM Country z WHERE z.country=?1)")
	List<Odds> selectOdds (String league);
	
	@Query("SELECT o FROM Odds o WHERE o.buk='LvBet' ")
	List<Odds> selectOdds2 ();
	
//	@Query("SELECT DISTINCT o FROM Odds o INNER JOIN o.match z WHERE o.buk='Ewinner' AND z.id=3")
//	List<Odds> bukList ();
	
	// List of buks for a specific match
//	@Query("SELECT DISTINCT o.buk FROM Odds o INNER JOIN o.match z WHERE z.id=?1")
//	List<String> bukListString (Long id);
	
	List <Odds> findDistinctFirstByBukAndMatchIdOrderByDateTimeDesc(String buk, Long id);
	
	List <Odds> findByMatchIdAndBukOrderByDateTimeDesc(Long MatchId, String buk);
	
//	List <Odds> findByMatchIdAndBukOrderByIdDesc(Long MatchId, String buk);
	
	List <Odds> findByMatchIdOrderByDateTimeDesc(Long MatchId);
	
	Odds findFirstByBukAndMatchIdOrderByDateTimeDesc(String buk, Long id);
	
	//double findFirstMaxHomeByMatchId(Long id);
	
	@Query("SELECT MAX (o.home) FROM Odds o INNER JOIN o.match m WHERE m.id=?1")
	double maxOddsHome (Long id);
	
	@Query("SELECT MAX (o.draw) FROM Odds o INNER JOIN o.match m WHERE m.id=?1")
	double maxOddsDraw (Long id);
	
	@Query("SELECT MAX (o.away) FROM Odds o INNER JOIN o.match m WHERE m.id=?1")
	double maxOddsAway (Long id);
	

}
