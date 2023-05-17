package com.userService.userService.repository;


import com.userService.userService.domain.RecommendationFeedDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "recommendationFeed", path = "recommendationFeed")
public interface RecommendationRepository extends MongoRepository<RecommendationFeedDomain,String> {
    List<RecommendationFeedDomain> findByUsername(String username);
}

