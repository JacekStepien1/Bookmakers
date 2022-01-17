package buk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import buk.Entities.Teams;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long> {
	
}
