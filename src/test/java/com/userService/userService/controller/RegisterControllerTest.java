package com.userService.userService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userService.userService.domain.UserDomain;
import com.userService.userService.repository.UserRepository;
import com.userService.userService.service.UserService;
import com.userService.userService.utils.TestingUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTest {
    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDateTime NOW = LocalDateTime.now();
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RegisterController registerController;
    @Autowired
    TestingUtils testingUtils;
    @AfterEach
    void cleanUp(){
        this.userRepository.deleteAll();
    }

    @Test
    void userRegisterGoldenPaths(){
        UserDomain newUser = testingUtils.createUserDomain("user1","1234","mm@gmail.com",TODAY,NOW);
        userRepository.save(newUser);
    }


}
