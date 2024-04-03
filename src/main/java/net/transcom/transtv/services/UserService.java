package net.transcom.transtv.services;

import net.transcom.transtv.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    UserResponse getInfo(String authtoken);
}
