package com.userService.userService.controller;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.repository.UserRepository;
import com.userService.userService.utils.TestingUtils;
import jdk.incubator.vector.VectorOperators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDateTime NOW = LocalDateTime.now();

    @Autowired
    LoginController loginController;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TestingUtils testingUtils;

    @AfterEach
    void cleanUp(){
        this.userRepository.deleteAll();
    }

    @Test
    void loginAuthenticatorGoldenPaths() throws Exception{
        UserDomain loginForm = testingUtils.createUserDomain("user1","1234","mm@gmail.com",TODAY,NOW);
    }

    @Test
    void loginFailedExceptionErrorPaths() throws Exception{

    }

}
