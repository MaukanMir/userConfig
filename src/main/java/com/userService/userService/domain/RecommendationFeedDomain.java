package com.userService.userService.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("recommendation_feed")
@Builder
@Data
public class RecommendationFeedDomain {
    @Id
    private String Id;
    private String username;
    private String email;
    private Map<String,Object> metaData;
}
