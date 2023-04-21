package com.userService.userService.controller;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/userBio")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findUser{Id}")
    public Optional<UserDomain> grabUserInfo(@PathVariable String Id){
        return userService.findUserProfile(Id);
    }
}
