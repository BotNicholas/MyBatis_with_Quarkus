package org.nicholas.mybatiswithquarkus.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Integer blogId;
    private String blogName;
    private LocalDate createdOn;
    private List<Post> posts = new ArrayList<Post>();
}
