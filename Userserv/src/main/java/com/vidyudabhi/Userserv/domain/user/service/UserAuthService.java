package com.vidyudabhi.Userserv.domain.user.service;

import com.vidyudabhi.Userserv.domain.user.model.AuthRequest;
import com.vidyudabhi.Userserv.domain.user.model.User;
import com.vidyudabhi.Userserv.domain.user.utils.JwtUtils;
import com.vidyudabhi.Userserv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return user;
    }

    public String loginUser(AuthRequest authRequest){
       User user = (User) loadUserByUsername(authRequest.getUsername());
       if(user!=null && passwordEncoder.matches(authRequest.getPassword(),user.getPassword())){
           return jwtUtils.generateJwtToken(authRequest.getUsername(),user.getUserid(),user.getRole());
       }
       throw new RuntimeException("INVALID_CREDENTIALS");
    }
}
