package net.transcom.transtv.controller;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.dto.UserResponse;
import net.transcom.transtv.entities.WifiUserInfo;
import net.transcom.transtv.services.UserService;
import net.transcom.transtv.services.WifiUserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/general")
@RequiredArgsConstructor
public class GeneralController {

    private final UserService userService;
    private final WifiUserInfoService wifiUserInfoService;

    @GetMapping("/info")
    public ResponseEntity<UserResponse> getUserInfo(@RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok(userService.getInfo(authorizationHeader.substring(7)));
    }
    @GetMapping("/wifi/user")
    public ResponseEntity<List<WifiUserInfo>> getAllWifiUsers(){
        return ResponseEntity.ok().body(wifiUserInfoService.getAllWifiUserInfo());
    }

}
