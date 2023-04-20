package com.userService.userService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document("user_config")
public class UserDomain {
    @Id
    private String id;
    private String email;
    private String username;
    private String password;
    private LocalDate dob;
    private LocalDateTime createdAt;
}
