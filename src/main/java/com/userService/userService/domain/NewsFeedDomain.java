package com.userService.userService.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("news_feed")
@Data
@Builder
public class NewsFeedDomain {
    @Id
    String Id;
    String email;
    String username;
    Map<String,String> metaData;

}
