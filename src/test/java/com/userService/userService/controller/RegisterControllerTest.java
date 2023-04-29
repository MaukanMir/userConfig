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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    TestingUtils testingUtils;
    @AfterEach
    void cleanUp(){
        this.userRepository.deleteAll();
    }

    @Test
    void userRegisterGoldenPaths() throws Exception{
        UserDomain newUser = testingUtils.createUserDomain("user1","1234","mm@gmail.com",TODAY,NOW);

        this.mockMvc.perform(post("/userRegister")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser))

                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

        List<UserDomain> savedUser = this.userRepository.findByUsername(newUser.getUsername());

        assertEquals(savedUser.get(0).getUsername(),newUser.getUsername());





    }


}
