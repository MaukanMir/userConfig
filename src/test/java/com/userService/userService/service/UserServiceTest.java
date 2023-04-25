package com.userService.userService.service;

import com.userService.userService.repository.UserRepository;
import com.userService.userService.utils.TestingUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
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

    }
}
