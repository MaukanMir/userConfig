package com.userService.userService.service;

import com.userService.userService.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationFeedService {
    @Autowired
    RecommendationRepository recommendationRepository;
}
