package com.movieinfo.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {

    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("moviedb")
    public String getMovieDb() {
        return "moviedb";
    }
}
