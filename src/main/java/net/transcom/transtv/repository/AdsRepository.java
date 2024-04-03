package net.transcom.transtv.repository;

import net.transcom.transtv.entities.Ads;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {
    Page<Ads> findByStatusAndCustomerIdOrderByCreatedAtDesc(String status, String client, Pageable pageable);
    @Query("SELECT DISTINCT a.entityName FROM Ads a WHERE status = :status AND customerId = :client")
    List<String> findDistinctByEntityName(@Param("status") String status, @Param("client") String client);
    @Query("SELECT DATE(a.createdAt) AS day, COUNT(a.id) AS count FROM Ads a WHERE status = :status AND customerId = :client GROUP BY day ORDER BY day DESC")
    List<Object[]> findAdCountByDay(@Param("status") String status, @Param("client") String client);
//    @Query("SELECT DATE(a.createdAt) AS date, COUNT(a.id) AS count FROM Ads a WHERE status = :status AND customerId = :client AND a.createdAt >= CURRENT_DATE - INTERVAL '7 days' GROUP BY date ORDER BY date DESC")
//    List<Object[]> findAdCountByLast7Days(@Param("status") String status, @Param("client") String client);
    @Query("SELECT a.route AS route, COUNT(a.id) AS count FROM Ads a WHERE status = :status AND customerId = :client GROUP BY route")
    List<Object[]> findAdCountByRoute(@Param("status") String status, @Param("client") String client);
    @Query("SELECT a.entityName AS matatu, COUNT(a.id) AS count FROM Ads a WHERE status = :status AND customerId = :client GROUP BY matatu")
    List<Object[]> findAdCountByMatatu(@Param("status") String status, @Param("client") String client);
    @Query("SELECT a.videoName AS video, COUNT(a.id) AS count FROM Ads a WHERE status = :status AND customerId = :client GROUP BY video")
    List<Object[]> findAdCountByVideoName(@Param("status") String status, @Param("client") String client);
}
