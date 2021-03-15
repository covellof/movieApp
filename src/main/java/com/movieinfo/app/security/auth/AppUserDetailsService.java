package com.movieinfo.app.security.auth;

import com.movieinfo.app.security.domain.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.movieinfo.app.security.domain.AppUserRole.ADMIN;
import static com.movieinfo.app.security.domain.AppUserRole.USER;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private AppUserDetailsRepository repository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUserDetails testAppUser = new AppUserDetails("testUser",
                passwordEncoder.encode("testPassword"),
                ADMIN.getGrantedAuthorities(),
                true,
                true,
                true,
                true);
        UserResponse testUser = new UserResponse();
        testUser.setUsername("testUser");
        testUser.setPassword(passwordEncoder.encode("testPassword"));
        testUser.setEmail("email@email.com");

        return testAppUser;
//                repository.findAppUserDetailsByUsername(username)
//                .orElseThrow(() ->
//                new UsernameNotFoundException(String.format("Username %s not found", username))
//        );
    }

    public AppUserDetails insertUser(AppUserDetails user) {
        return repository.insert(user);
    }
}
