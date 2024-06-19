package org.nicholas.mybatiswithquarkus.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String emailId;
    private String password;
    private String firstName;
    private String lastname;
    private Blog blog;
}
