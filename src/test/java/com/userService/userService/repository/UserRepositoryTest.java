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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

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
        this.repository.save(ud1);
        UserDomain ud2 = testingUtils.createUserDomain("user2","1236","mm@gmail.com",TODAY.minusDays(1),NOW.minusDays(1));
        this.repository.save(ud2);
        UserDomain ud3 = testingUtils.createUserDomain("user3","1236","mm@gmail.com",TODAY.minusDays(2),NOW.minusDays(2));
        this.repository.save(ud3);
        assertThat(this.repository.count(), is(3L));

        assertMatch(this.repository.findById(ud1.getId()).get(), ud1);
        assertMatch(this.repository.findById(ud2.getId()).get(), ud2);
        assertMatch(this.repository.findById(ud3.getId()).get(), ud3);
    }

    private void assertMatch(UserDomain actual, UserDomain expected){
        assertThat(actual, is(notNullValue()));
        assertThat(actual.getId(), is(expected.getId()));
        assertThat(actual.getUsername(), is(expected.getUsername()));
        assertThat(actual.getPassword(), is(expected.getPassword()));
        assertThat(actual.getDob(), is(expected.getDob()));
        assertThat(actual.getEmail(), is(expected.getEmail()));
        assertThat(actual.getDob(), is(expected.getDob()));
    }

}
