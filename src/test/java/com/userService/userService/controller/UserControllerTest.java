package com.userService.userService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userService.userService.repository.UserRepository;
import com.userService.userService.utils.TestingUtils;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    TestingUtils testingUtils;
    @Autowired
    UserRepository userRepository;

    @AfterEach
    void cleanUp(){
        this.userRepository.deleteAll();
    }
}
