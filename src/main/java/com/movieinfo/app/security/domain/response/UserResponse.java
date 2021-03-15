package com.movieinfo.app.security.domain.response;

public class UserResponse {

    private String username;
    private String password;
    private String email;

    public UserResponse() {}

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
