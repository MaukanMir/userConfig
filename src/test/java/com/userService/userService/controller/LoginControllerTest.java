package com.userService.userService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userService.userService.domain.UserDomain;
import com.userService.userService.repository.UserRepository;
import com.userService.userService.utils.TestingUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    void cleanUp(){
        this.userRepository.deleteAll();
    }

    @Test
    void loginAuthenticatorGoldenPaths() throws Exception{
        UserDomain loginForm = testingUtils.createUserDomain("user1","1234","mm@gmail.com",TODAY,NOW);
        userRepository.save(loginForm);

        this.mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginForm))

        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    void loginFailedExceptionErrorPaths() throws Exception{

        UserDomain loginForm = testingUtils.createUserDomain("user1","1234","mm@gmail.com",TODAY,NOW);

        this.mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginForm))

                ).andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(result -> assertEquals("User is not authenticated", result.getResponse().getErrorMessage()));

    }

}
