package com.userService.userService.controller;


import com.userService.userService.dto.UserDTO;
import com.userService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/userProfile")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findUser/{Id}")
    public UserDTO grabUserInfo(@PathVariable String Id){
        return userService.findUserProfile(Id);
    }
}
