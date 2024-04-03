package net.transcom.transtv.controller;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.dto.UserResponse;
import net.transcom.transtv.entities.Ads;
import net.transcom.transtv.services.AdsService;
import net.transcom.transtv.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final AdsService adsService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello, I am a User");
    }

    @GetMapping("/info")
    public ResponseEntity<UserResponse> getUserInfo(@RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok(userService.getInfo(authorizationHeader.substring(7)));
    }

    @GetMapping("/ads")
    public ResponseEntity<Page<Ads>> getAdsByStatus(@RequestParam String status,
                                                 @RequestParam String client,
                                                 @RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        Page<Ads> ads = adsService.getLatestAdsByStatus(status, client, page - 1, size);
        return ResponseEntity.ok(ads);
    }

    @GetMapping("/matatus")
    public ResponseEntity<List<String>> getListOfMatatus(@RequestParam String status, @RequestParam String client){
        return ResponseEntity.ok(adsService.getListOfMatatus(status, client));
    }

    @GetMapping("/advsmatatu")
    public ResponseEntity<List<Object[]>> getAdsvsMatatu(@RequestParam String status, @RequestParam String client){
        return ResponseEntity.ok(adsService.getAdsByMatatu(status, client));
    }

    @GetMapping("/advsroute")
    public ResponseEntity<List<Object[]>> getAdsvsRoute(@RequestParam String status, @RequestParam String client){
        return ResponseEntity.ok(adsService.getAdsByRoute(status, client));
    }

    @GetMapping("/advsvideo")
    public ResponseEntity<List<Object[]>> getAdsvsVideo(@RequestParam String status, @RequestParam String client){
        return ResponseEntity.ok(adsService.getAdsByVideoName(status, client));
    }

//    @GetMapping("/advs7days")
//    public ResponseEntity<List<Object[]>> getAdsvs7days(@RequestParam String status){
//        return ResponseEntity.ok(adsService.getAdsByLast7Days(status));
//    }

    @GetMapping("/adsvsdays")
    public ResponseEntity<List<Object[]>> getAdsvsDays(@RequestParam String status, @RequestParam String client){
        return ResponseEntity.ok(adsService.getAdsByDays(status, client));
    }

}
