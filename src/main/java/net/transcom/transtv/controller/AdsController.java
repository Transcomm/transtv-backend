package net.transcom.transtv.controller;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.entities.Ads;
import net.transcom.transtv.services.AdsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public")
@RequiredArgsConstructor
public class AdsController {

    private final AdsService adsService;

    @PostMapping("/ads")
    public ResponseEntity<Ads> saveAd(@RequestBody Ads ad){
        return ResponseEntity.ok().body(adsService.saveAd(ad));
    }

}
