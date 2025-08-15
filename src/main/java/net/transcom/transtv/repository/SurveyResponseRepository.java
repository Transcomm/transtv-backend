package net.transcom.transtv.repository;

import net.transcom.transtv.entities.SurveyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {
    Page<SurveyResponse> findAll(Pageable pageable);
}
