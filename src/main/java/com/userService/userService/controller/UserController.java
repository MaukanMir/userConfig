package com.userService.userService.controller;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.dto.UserDTO;
import com.userService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




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
