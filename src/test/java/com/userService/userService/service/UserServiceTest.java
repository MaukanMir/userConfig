package com.userService.userService.service;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.dto.UserDTO;
import com.userService.userService.repository.UserRepository;
import com.userService.userService.utils.TestingUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {
    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDateTime NOW = LocalDateTime.now();
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
        UserDomain newUser = testingUtils.createUserDomain("user1","1234","mm@gmail.com",TODAY,NOW);

        userService.saveUser(newUser);

        List<UserDomain> savedUser = this.repository.findByUsername(newUser.getUsername());

        assertEquals(newUser.getPassword(),savedUser.get(0).getPassword());

    }

    @Test
    public void findUserProfileGoldenPaths() throws Exception{
        UserDomain newUser = testingUtils.createUserDomain("user1","1234","mm@gmail.com",TODAY,NOW);

        userService.saveUser(newUser);

        UserDTO foundProfile = userService.findUserProfile(newUser.getId());

        assertEquals(foundProfile.getUsername(), newUser.getUsername());
    }

    @Test
    public void authenticateUserGoldenPaths() throws Exception{
        UserDomain verifyUser = testingUtils.createUserDomain("user1","1234","mm@gmail.com",TODAY,NOW);
        repository.save(verifyUser);

       List<UserDomain> authenticatedUser = userService.authenticateUser(verifyUser);

       assertEquals(verifyUser.getUsername(), authenticatedUser.get(0).getUsername());
       assertEquals(verifyUser.getPassword(), authenticatedUser.get(0).getPassword());
       assertEquals(verifyUser.getDob(), authenticatedUser.get(0).getDob());
    }
}
