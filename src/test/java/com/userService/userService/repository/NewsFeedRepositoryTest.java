package com.userService.userService.repository;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewsFeedRepositoryTest {
    @Autowired
    NewsFeedRepository newsFeedRepository;

    @AfterEach
    void  cleanUp(){
        newsFeedRepository.deleteAll();
    }
}
