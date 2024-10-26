package net.transcom.transtv.dto;

import lombok.Data;

@Data
public class SignUpRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String client;
    private String password;
    private String orgName;

}
