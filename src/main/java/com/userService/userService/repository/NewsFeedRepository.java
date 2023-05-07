package com.userService.userService.repository;

import com.userService.userService.domain.NewsFeedDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "newsFeed", path = "newsFeed")
public interface NewsFeedRepository extends MongoRepository<NewsFeedDomain, String> {

    List<NewsFeedDomain> findByUsername(String username);
}
