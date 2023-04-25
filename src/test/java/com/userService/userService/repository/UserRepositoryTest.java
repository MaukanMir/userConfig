package com.userService.userService.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    private static final LocalDate TODAY = LocalDate.now();

}
