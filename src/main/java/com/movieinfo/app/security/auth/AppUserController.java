package com.movieinfo.app.security.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AppUserController {

    private AppUserDetailsService service;

    public AppUserController(AppUserDetailsService service) {
        this.service = service;
    }

    @GetMapping
    public UserDetails findUserByUsername(String username) throws UsernameNotFoundException {
        return service.loadUserByUsername(username);
    }
}
