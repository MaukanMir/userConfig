package com.userService.userService.service;

import com.userService.userService.controller.exception.UnauthorizedUserException;
import com.userService.userService.domain.UserDomain;
import com.userService.userService.dto.UserDTO;
import com.userService.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public UserDTO saveUser(UserDomain newUser){
        String hashedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(hashedPassword);
        userRepository.save(newUser);
        List<UserDomain> savedUser = userRepository.findByUsername(newUser.getUsername());
        return UserDTOWrapper(savedUser);
    }
    public List<UserDomain> authenticateUser(UserDomain verifyUser) {

            List<UserDomain> foundUser = userRepository.findByUsername(verifyUser.getUsername());

            if( foundUser.isEmpty() || !foundUser.get(0).getUsername().equals(verifyUser.getUsername()) || !foundUser.get(0).getPassword().equals(verifyUser.getPassword())){
                throw new UnauthorizedUserException("User is not authenticated");
            }

            return foundUser;
    }
    public UserDTO findUserProfile(String Id){

        Optional <UserDomain>  foundProfile = userRepository.findById(Id);
        return UserDTOWrapper(foundProfile.stream().toList());
    }

    public UserDTO UserDTOWrapper(List <UserDomain> userDomainObject){

        return UserDTO.builder()
                .id(userDomainObject.get(0).getId())
                .username(userDomainObject.get(0).getUsername())
                .email(userDomainObject.get(0).getEmail())
                .dob(userDomainObject.get(0).getDob())
                .createdAt(userDomainObject.get(0).getCreatedAt()).build();
    }

}
