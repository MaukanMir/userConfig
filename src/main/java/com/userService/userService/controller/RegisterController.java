package com.userService.userService.controller;

import com.userService.userService.controller.exception.DuplicateEmailException;
import com.userService.userService.controller.exception.DuplicateUsernameException;
import com.userService.userService.domain.UserDomain;
import com.userService.userService.dto.UserDTO;
import com.userService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/userRegister")
@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?>createUser(@RequestBody UserDomain user){
        try{
            return ResponseEntity.ok(userService.saveUser(user));
        }catch( DuplicateUsernameException exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }catch(DuplicateEmailException exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }
    }
}
