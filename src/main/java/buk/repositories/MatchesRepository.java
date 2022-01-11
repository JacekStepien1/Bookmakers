package buk.repositories;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import buk.Entities.Matches;

@Repository
public interface MatchesRepository extends JpaRepository<Matches, Long> {
	
	public Matches findFirstByDateTimeAndHome (Date date, String home);	
	
	public Matches findFirstByHomeAndAwayAndDateTimeBetween (String home, String away, Date date1, Date date2);

	public Matches findFirstByHomeAndAwayAndDateTimeBetweenAndScoreHome (String home, String away, Date date1, Date date2, Integer scores);

	public List<Matches> findTop5ByDateTimeBeforeAndHomeOrDateTimeBeforeAndAwayOrderByDateTimeDesc(Date date, String home, Date date1, String away);

	public List<Matches> findTop5ByDateTimeBeforeAndHomeAndScoreHomeNotNullOrDateTimeBeforeAndAwayAndScoreHomeNotNullOrderByDateTimeDesc(Date date, String home, Date date1, String away);




	@Query("SELECT DISTINCT m FROM Matches m INNER JOIN m.teams x WHERE x.country=?1")
	Collection<Matches> findTrabzon(int liczba);
	
	public List<Matches> findByDateTimeBetween (Date data1, Date date2);

	@Query("SELECT DISTINCT m FROM Matches m INNER JOIN m.teams t WHERE t.country=(SELECT z.id FROM Country z WHERE z.country=?1)")
	List<Matches> selectMatches (String country);
		
//	@Query("SELECT m FROM Matches m INNER JOIN m.teams t WHERE t.country=(SELECT z.id FROM Country z WHERE z.country=?1)  ORDER BY m.dateTime ASC")
//	List <Matches> match (String league);
	
//	@Query(value = "SELECT * FROM Matches m WHERE m.home='Warta'", nativeQuery = true)
//	List <Matches> match (String league);
	
//	@Query("SELECT m FROM Matches m INNER JOIN m.teams t WHERE t.country=3")
//	List <Matches> match ();
	
	@Query("SELECT DISTINCT m FROM Matches m INNER JOIN m.teams z INNER JOIN z.country x WHERE x.country = ?1 AND m.dateTime >=?2 ORDER BY m.dateTime ASC")
	List <Matches> distinctMatches (String leauge, Date dateTime);


	
	
	
	

}
