package com.userService.userService.repository;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.utils.TestingUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
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
    @Autowired
    TestingUtils testingUtils;

    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDateTime NOW = LocalDateTime.now();

    @AfterEach
    public void cleanUp(){
        this.repository.deleteAll();
    }

    @Test
    void save_StandardScenario_MatchesExpected(){

        UserDomain ud1 = testingUtils.createUserDomain("user1","1234","mm@gmail.com",TODAY,NOW);
        UserDomain ud2 = testingUtils.createUserDomain("user2","1236","mm@gmail.com",TODAY.minusDays(1),NOW.minusDays(1));
        UserDomain ud3 = testingUtils.createUserDomain("user3","1236","mm@gmail.com",TODAY.minusDays(2),NOW.minusDays(2));
    }

}
