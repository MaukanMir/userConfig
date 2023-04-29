package com.userService.userService.controller;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.dto.UserDTO;
import com.userService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/userRegister")
@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDomain user){
         return ResponseEntity.ok(userService.saveUser(user));
    }
}
