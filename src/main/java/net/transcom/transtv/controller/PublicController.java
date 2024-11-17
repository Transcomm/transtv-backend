package net.transcom.transtv.controller;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.entities.Ads;
import net.transcom.transtv.entities.WifiUserInfo;
import net.transcom.transtv.services.AdsService;
import net.transcom.transtv.services.WifiUserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public")
@RequiredArgsConstructor
public class PublicController {

    private final AdsService adsService;
    private final WifiUserInfoService wifiUserInfoService;

    @PostMapping("/ads")
    public ResponseEntity<Ads> saveAd(@RequestBody Ads ad){
        return ResponseEntity.ok().body(adsService.saveAd(ad));
    }

    @PostMapping("/wifi/user")
    public ResponseEntity<WifiUserInfo> saveWifiUserInfo(@RequestBody WifiUserInfo wifiUserInfo){
        return ResponseEntity.ok().body(wifiUserInfoService.saveUserInfo(wifiUserInfo));
    }

}
