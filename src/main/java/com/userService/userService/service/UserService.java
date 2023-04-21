package com.userService.userService.service;

import com.userService.userService.controller.exception.UnauthorizedUserException;
import com.userService.userService.domain.UserDomain;
import com.userService.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public UserDomain saveUser(UserDomain newUser){
        String hashedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(hashedPassword);
        userRepository.save(newUser);
        return userRepository.findByUserName(newUser.getUsername());
    }

    public List<UserDomain> authenticateUser(UserDomain verifyUser) {

            List<UserDomain> foundUser = userRepository.findByUserName(verifyUser.getUsername());

            if(foundUser.get(0).getPassword() != verifyUser.getPassword()){
                throw new UnauthorizedUserException("User is not authenticated");
            }
            return foundUser;
    }

}
