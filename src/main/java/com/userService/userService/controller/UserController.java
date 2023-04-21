package com.userService.userService.controller;

import com.userService.userService.domain.UserDomain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/userBio")
@RestController
public class UserController {

    @GetMapping("/findUser{Id}")
    public UserDomain grabUserInfo(@PathVariable UserDomain Id){

    }
}
