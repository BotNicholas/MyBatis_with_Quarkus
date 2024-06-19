package org.nicholas.mybatiswithquarkus.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer postId;
    private String title;
    private String content;
    private String createdOn;
}
