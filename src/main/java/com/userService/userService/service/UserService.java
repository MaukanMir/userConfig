package com.userService.userService.service;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void saveUser(UserDomain newUser){
        userRepository.save(newUser);
    }
}
