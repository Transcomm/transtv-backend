package net.transcom.transtv.repository;

import net.transcom.transtv.entities.SurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {
    @Query("SELECT s.question1, COUNT(s) FROM SurveyResponse s GROUP BY s.question1")
    List<Object[]> getQuestion1Stats();

    @Query("SELECT s.question2, COUNT(s) FROM SurveyResponse s GROUP BY s.question2")
    List<Object[]> getQuestion2Stats();

    @Query("SELECT q3, COUNT(q3) FROM SurveyResponse s JOIN s.question3 q3 GROUP BY q3")
    List<Object[]> getQuestion3Stats();

    @Query("SELECT s.question4, COUNT(s) FROM SurveyResponse s GROUP BY s.question4")
    List<Object[]> getQuestion4Stats();

    @Query("SELECT s.question5, COUNT(s) FROM SurveyResponse s GROUP BY s.question5")
    List<Object[]> getQuestion5Stats();
}
