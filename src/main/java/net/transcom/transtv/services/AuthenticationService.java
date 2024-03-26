package net.transcom.transtv.services;


import net.transcom.transtv.dto.JwtAuthenticationResponse;
import net.transcom.transtv.dto.RefreshTokenRequest;
import net.transcom.transtv.dto.SignInRequest;
import net.transcom.transtv.dto.SignUpRequest;
import net.transcom.transtv.entities.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);
    JwtAuthenticationResponse refresh(RefreshTokenRequest refreshTokenRequest);

}
