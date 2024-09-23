package com.vidyudabhi.Userserv.controller;

import com.vidyudabhi.Userserv.domain.user.model.AuthRequest;
import com.vidyudabhi.Userserv.domain.user.model.User;
import com.vidyudabhi.Userserv.domain.user.model.UserRequestDTO;
import com.vidyudabhi.Userserv.domain.user.service.UserAuthService;
import com.vidyudabhi.Userserv.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserAuthService userAuthService;

    @GetMapping("/home")
    public String getUsers(){
        return "INSIDE USER SERVICE";
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestBody UserRequestDTO userRequestDTO
    ){
        User user =userService.addUser(userRequestDTO);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestBody AuthRequest authRequest
    ){
        String jwtToken=userAuthService.loginUser(authRequest);
        return ResponseEntity.ok().body(jwtToken);
    }
}
