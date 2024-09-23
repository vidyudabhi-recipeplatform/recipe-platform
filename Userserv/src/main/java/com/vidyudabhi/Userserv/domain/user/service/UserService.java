package com.vidyudabhi.Userserv.domain.user.service;

import com.vidyudabhi.Userserv.domain.user.model.User;
import com.vidyudabhi.Userserv.domain.user.model.UserRequestDTO;

public interface UserService {
    User addUser(UserRequestDTO userRequestDTO);
}
