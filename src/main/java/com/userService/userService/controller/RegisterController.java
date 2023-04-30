package com.userService.userService.controller;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.dto.UserDTO;
import com.userService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/userRegister")
@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDomain user){
         return (userService.saveUser(user));
    }
}
