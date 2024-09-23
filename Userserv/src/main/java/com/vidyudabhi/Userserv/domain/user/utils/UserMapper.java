package com.vidyudabhi.Userserv.domain.user.utils;

import com.vidyudabhi.Userserv.domain.user.model.User;
import com.vidyudabhi.Userserv.domain.user.model.UserRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertToUser(UserRequestDTO userRequestDTO) {

        User user =  modelMapper.map(userRequestDTO,User.class);
        user.setUsername(user.getFirstname()+" "+user.getLastname());
        return user;
    }
}
