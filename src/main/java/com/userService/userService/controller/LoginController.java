package com.userService.userService.controller;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/login")
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody UserDomain loginForm){

        try{
            return ResponseEntity.ok(userService.authenticateUser(loginForm));
        }catch(Exception errorMessage){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage.getMessage());
        }

    }
}
