package com.vidyudabhi.Userserv.domain.user.service;

import com.vidyudabhi.Userserv.domain.user.model.Role;
import com.vidyudabhi.Userserv.domain.user.model.User;
import com.vidyudabhi.Userserv.domain.user.model.UserRequestDTO;
import com.vidyudabhi.Userserv.domain.user.model.UserStatus;
import com.vidyudabhi.Userserv.domain.user.utils.UserMapper;
import com.vidyudabhi.Userserv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User addUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.convertToUser(userRequestDTO);
        user.setRole(Role.USER);
        user.setUserStatus(UserStatus.ACTIVE);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        return userRepository.save(user);
    }
}
