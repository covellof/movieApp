package com.movieinfo.app;

import com.movieinfo.app.security.PasswordConfig;
import com.movieinfo.app.security.UserService;
import com.movieinfo.app.security.auth.AppUserDetails;
import com.movieinfo.app.security.auth.AppUserDetailsService;
import com.movieinfo.app.security.domain.AppUserPermission;
import com.movieinfo.app.security.domain.User;
import com.movieinfo.app.security.domain.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sun.security.util.Password;

import java.util.HashSet;

import static com.movieinfo.app.security.domain.AppUserRole.ADMIN;

@SpringBootApplication
public class MovieInfoApp {

    private static BCryptPasswordEncoder passwordConfig = new BCryptPasswordEncoder(10);

    public static void main(String[] args) {
        SpringApplication.run(MovieInfoApp.class, args);
    }

}
