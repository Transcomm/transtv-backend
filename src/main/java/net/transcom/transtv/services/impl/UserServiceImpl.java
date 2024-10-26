package net.transcom.transtv.services.impl;


import lombok.RequiredArgsConstructor;
import net.transcom.transtv.dto.UserResponse;
import net.transcom.transtv.entities.User;
import net.transcom.transtv.repository.UserRepository;
import net.transcom.transtv.services.JWTService;
import net.transcom.transtv.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JWTService jwtService;

    public UserResponse getInfo(String authtoken){

        String userEmail = jwtService.extractUsername(authtoken);
        //get the user from the database
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new IllegalArgumentException("User not found"));

        UserResponse userResponse = new UserResponse();
        userResponse.setFirstname(user.getFirstname());
        userResponse.setLastname(user.getLastname());
        userResponse.setEmail(user.getEmail());
        userResponse.setClient(user.getClient());

        return userResponse;
    }

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username){
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
