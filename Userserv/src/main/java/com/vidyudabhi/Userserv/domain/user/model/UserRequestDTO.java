package com.vidyudabhi.Userserv.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String firstname;

    private String lastname;

    private String password;

    private String email;

}
