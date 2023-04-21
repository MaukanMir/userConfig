package com.userService.userService.repository;

import com.userService.userService.domain.UserDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "UserRepository", path = "UserRepository")
public interface UserRepository extends MongoRepository<UserDomain, String> {
    UserDomain findByUserName(String username);
}
