package com.userService.userService.controller;

import com.userService.userService.domain.NewsFeedDomain;
import com.userService.userService.service.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/newsFeed")
@RestController
public class NewsFeedController {
    @Autowired
    NewsFeedService newsFeedService;
    @GetMapping("search/findByUsername/")
    public List<NewsFeedDomain> getUserNewsFeed(@RequestParam String username){
        return newsFeedService.findUserNewsFeed(username);
    }

    @PostMapping
    public NewsFeedDomain saveUserNewsFeed(@RequestBody NewsFeedDomain userInfo){
        return newsFeedService.saveUserNewsFeed(userInfo);
    }

}
