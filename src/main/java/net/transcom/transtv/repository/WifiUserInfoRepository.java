package net.transcom.transtv.repository;

import net.transcom.transtv.entities.WifiUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WifiUserInfoRepository extends JpaRepository<WifiUserInfo, Long> {
}
