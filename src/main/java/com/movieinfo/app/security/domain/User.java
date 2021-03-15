package com.movieinfo.app.security.domain;

import com.movieinfo.app.security.domain.response.UserResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class User {

    @Id
    @Field("_id")
    private String username;

    private String password;
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {}

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public static User mapToDocument(UserResponse response) {
        User document = new User();
        document.setUsername(response.getUsername());
        document.setPassword(response.getPassword());
        document.setEmail(response.getEmail());
        return document;
    }

    public static UserResponse mapToResponse(User document) {
        UserResponse response = new UserResponse();
        response.setUsername(document.getUsername());
        response.setPassword(document.getPassword());
        response.setEmail(document.getEmail());
        return response;
    }
}
