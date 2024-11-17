package net.transcom.transtv.services.impl;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.entities.WifiUserInfo;
import net.transcom.transtv.repository.WifiUserInfoRepository;
import net.transcom.transtv.services.WifiUserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WifiUserInfoServiceImpl implements WifiUserInfoService {

    private final WifiUserInfoRepository wifiUserInfoRepository;

    public WifiUserInfo saveUserInfo(WifiUserInfo wifiUserInfo) {
        return wifiUserInfoRepository.save(wifiUserInfo);
    }

    public List<WifiUserInfo> getAllWifiUserInfo() {
        return wifiUserInfoRepository.findAll();
    }

}
