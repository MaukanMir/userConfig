package com.userService.userService.service;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.repository.UserRepository;
import com.userService.userService.utils.TestingUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class UserServiceTest {
    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDateTime NOW = LocalDateTime.now();
    @Autowired
    TestingUtils testingUtils;
    @Autowired
    UserRepository repository;
    @Autowired
    UserService userService;

    @AfterEach
    public void cleanUp(){
        this.repository.deleteAll();
    }

    @Test
    public void saveUserGoldenPaths() throws Exception{
        UserDomain newUser = testingUtils.createUserDomain("user1","1234","mm@gmail.com",TODAY,NOW);

    }
}
