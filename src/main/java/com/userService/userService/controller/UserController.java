package com.userService.userService.controller;

import com.userService.userService.domain.UserDomain;
import com.userService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RequestMapping("/userBio")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findUser/{Id}")
    public EntityModel<UserDomain> grabUserInfo(@PathVariable String Id){
        return EntityModel.of(userService.findUserProfile(Id).get());
    }
}
