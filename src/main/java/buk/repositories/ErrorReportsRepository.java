package buk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import buk.Entities.ErrorReports;

@Repository
public interface ErrorReportsRepository extends JpaRepository<ErrorReports, Long>{

}
