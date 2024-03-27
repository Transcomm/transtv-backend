package net.transcom.transtv.repository;

import net.transcom.transtv.entities.Ads;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {
    Page<Ads> findByStatusOrderByCreatedAtDesc(String status, Pageable pageable);
    @Query("SELECT DISTINCT a.entityName FROM Ads a")
    List<String> findDistinctByEntityName();
}
