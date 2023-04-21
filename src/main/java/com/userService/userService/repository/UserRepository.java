package com.userService.userService.repository;

import com.userService.userService.domain.UserDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@RepositoryRestResource(collectionResourceRel = "UserServiceRepository", path = "UserServiceRepository")
public interface UserRepository extends MongoRepository<UserDomain, String> {
}
