package com.userService.userService.service;

import com.userService.userService.controller.exception.UnauthorizedUserException;
import com.userService.userService.domain.UserDomain;
import com.userService.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;


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

    public UserDomain authenticateUser(UserDomain verifyUser) {

            UserDomain foundUser = userRepository.findByUserName(verifyUser.getUsername());

            if( foundUser == null || !foundUser.getPassword().equals(verifyUser.getUsername()) || !foundUser.getPassword().equals(verifyUser.getPassword())){
                throw new UnauthorizedUserException("User is not authenticated");
            }

            return foundUser;
    }

    public Optional<UserDomain> findUserProfile(String Id){

        Optional<UserDomain> foundProfile = userRepository.findById(Id);

        return foundProfile;
    }

}
