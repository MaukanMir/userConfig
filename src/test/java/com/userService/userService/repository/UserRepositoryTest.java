package com.userService.userService.repository;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDateTime NOW = LocalDateTime.now();

    @AfterEach
    public void cleanUp(){
        this.repository.deleteAll();
    }

}
