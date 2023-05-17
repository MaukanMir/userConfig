package com.userService.userService.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("recommendation_feed")
@Builder
@Data
public class RecommendationFeedDomain {
}
