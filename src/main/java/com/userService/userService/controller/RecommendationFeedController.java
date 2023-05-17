package com.userService.userService.controller;

import com.userService.userService.domain.RecommendationFeedDomain;
import com.userService.userService.service.RecommendationFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendationService")
public class RecommendationFeedController {
    @Autowired
    RecommendationFeedService recommendationFeedService;

    @GetMapping("/getRecomendationFeed")
    public List<RecommendationFeedDomain> findUserRecommendation(@RequestParam String username){
        return recommendationFeedService.sendUserFeed(username);
    }
}
