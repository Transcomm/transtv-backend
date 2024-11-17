package net.transcom.transtv.services;

import net.transcom.transtv.entities.WifiUserInfo;

import java.util.List;

public interface WifiUserInfoService {

    WifiUserInfo saveUserInfo(WifiUserInfo wifiUserInfo);
    List<WifiUserInfo> getAllWifiUserInfo();

}
