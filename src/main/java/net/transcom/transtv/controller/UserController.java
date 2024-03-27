package net.transcom.transtv.controller;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.entities.Ads;
import net.transcom.transtv.services.AdsService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final AdsService adsService;

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello, I am a User");
    }

    @GetMapping("/ads")
    public ResponseEntity<Page<Ads>> getAdsByStatus(@RequestParam String status,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        Page<Ads> ads = adsService.getLatestAdsByStatus(status, page, size);
        return ResponseEntity.ok(ads);
    }

    @GetMapping("/matatus")
    public ResponseEntity<List<String>> getListOfMatatus(){
        return ResponseEntity.ok(adsService.getListOfMatatus());
    }

}
