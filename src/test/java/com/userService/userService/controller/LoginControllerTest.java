package com.userService.userService.controller;

import com.userService.userService.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    LoginController loginController;
    @Autowired
    UserRepository userRepository;

    @AfterEach
    void cleanUp(){
        this.userRepository.deleteAll();
    }

}
