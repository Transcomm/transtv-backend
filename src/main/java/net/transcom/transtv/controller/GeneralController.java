package net.transcom.transtv.controller;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.dto.UserResponse;
import net.transcom.transtv.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/info")
@RequiredArgsConstructor
public class GeneralController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getUserInfo(@RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok(userService.getInfo(authorizationHeader.substring(7)));
    }

}
