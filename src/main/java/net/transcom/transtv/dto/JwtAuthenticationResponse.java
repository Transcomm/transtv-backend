package net.transcom.transtv.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String access;
    private String refresh;

}
