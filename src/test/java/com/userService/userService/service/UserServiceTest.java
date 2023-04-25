package com.userService.userService.service;

import com.userService.userService.repository.UserRepository;
import com.userService.userService.utils.TestingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    TestingUtils testingUtils;
    @Autowired
    UserRepository userRepository;
}
