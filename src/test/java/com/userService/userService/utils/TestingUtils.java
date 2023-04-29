package com.userService.userService.utils;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class TestingUtils {

    public UserDomain createUserDomain(String username, String password, String email, LocalDate dob, LocalDateTime createdAt){

        return UserDomain.builder()
                .username(username)
                .password(password)
                .email(email)
                .dob(dob)
                .createdAt(createdAt)
                .build();
    }

    public UserDTO createUserDTO(String username, String email, LocalDate dob, LocalDateTime createdAt){

        return UserDTO.builder()
                .username(username)
                .email(email)
                .dob(dob)
                .createdAt(createdAt)
                .build();
    }


}
