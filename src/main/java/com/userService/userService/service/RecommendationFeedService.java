package com.userService.userService.service;

import com.userService.userService.domain.RecommendationFeedDomain;
import com.userService.userService.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationFeedService {
    @Autowired
    RecommendationRepository recommendationRepository;

    public List<RecommendationFeedDomain> sendUserFeed(String username){
        return recommendationRepository.findByUsername(username);
    }
}
