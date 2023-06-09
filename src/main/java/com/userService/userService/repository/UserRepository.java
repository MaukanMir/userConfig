package com.userService.userService.repository;

import com.userService.userService.domain.UserDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "userConfig", path = "userConfig")
public interface UserRepository extends MongoRepository<UserDomain, String> {
  List<UserDomain> findByUsername(String username);
  List<UserDomain> existsByEmail(String email);
  List<UserDomain> existsByUsername(String username);
}
