package com.userService.userService.controller;

import com.userService.userService.domain.NewsFeedDomain;
import com.userService.userService.service.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/newsFeed")
@RestController
public class NewsFeedController {
    @Autowired
    NewsFeedService newsFeedService;
    @GetMapping("search/findByUsername/")
    public List<NewsFeedDomain> getUserNewsFeed(@RequestBody NewsFeedDomain username){

    }

}
