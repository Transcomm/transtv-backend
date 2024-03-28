package net.transcom.transtv.repository;

import net.transcom.transtv.entities.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginInfoRepository extends JpaRepository<LoginInfo, Integer> {
}
