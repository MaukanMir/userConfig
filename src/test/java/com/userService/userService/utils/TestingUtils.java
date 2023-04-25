package com.userService.userService.utils;

import com.userService.userService.domain.UserDomain;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
