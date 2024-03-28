package net.transcom.transtv.services.impl;


import lombok.RequiredArgsConstructor;
import net.transcom.transtv.dto.JwtAuthenticationResponse;
import net.transcom.transtv.dto.RefreshTokenRequest;
import net.transcom.transtv.dto.SignInRequest;
import net.transcom.transtv.dto.SignUpRequest;
import net.transcom.transtv.entities.LoginInfo;
import net.transcom.transtv.entities.Role;
import net.transcom.transtv.entities.User;
import net.transcom.transtv.repository.LoginInfoRepository;
import net.transcom.transtv.repository.UserRepository;
import net.transcom.transtv.services.AuthenticationService;
import net.transcom.transtv.services.JWTService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final LoginInfoRepository loginInfoRepository;

    public User signup(SignUpRequest signUpRequest){
        User user = new User();

        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        user.setEmail(signUpRequest.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signin(SignInRequest signInRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),
                signInRequest.getPassword()));

        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        var jwt = jwtService.generateToken(user);
        var refreshtoken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setAccess(jwt);
        jwtAuthenticationResponse.setRefresh(refreshtoken);

        //saving the user login records
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setEmail(user.getEmail());
        loginInfoRepository.save(loginInfo);

        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse refresh(RefreshTokenRequest refreshTokenRequest){
        String userEmail = jwtService.extractUsername(refreshTokenRequest.getToken());
        //get the user from the database
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new IllegalArgumentException("User email not found"));

        //check if the token is valid
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(),user)) {
            var jwt = jwtService.generateToken(user);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

            jwtAuthenticationResponse.setAccess(jwt);
            jwtAuthenticationResponse.setRefresh(refreshTokenRequest.getToken());

            return jwtAuthenticationResponse;
        }
        return null;
    }

}
