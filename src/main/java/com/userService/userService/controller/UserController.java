package com.userService.userService.controller;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/userService")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("")
    public ResponseEntity<UserDomain> createUser(@RequestBody UserDomain user){

    }

}
