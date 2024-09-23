package com.vidyudabhi.Userserv.domain.user.model;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;

    private String password;
}
