package com.userService.userService.service;

import com.userService.userService.domain.NewsFeedDomain;
import com.userService.userService.repository.NewsFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFeedService {
    @Autowired
    NewsFeedRepository newsFeedRepository;

    public List<NewsFeedDomain> saveUserNewsFeed(NewsFeedDomain userFeed){

    }
}
