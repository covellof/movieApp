package com.movieinfo.app.security;

import com.movieinfo.app.security.domain.response.UserResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<UserResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/admin/{username}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public UserResponse findAdmin(@PathVariable String username) {
        return service.findById(username);
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public UserResponse findUser(@PathVariable String username) {
        return service.findById(username);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public UserResponse insertNewUser(@RequestBody UserResponse toSave) {
        return service.insertNewUser(toSave);
    }

    @DeleteMapping(path = "/{username}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable String username) {
        service.deleteUser(username);
    }

    @PutMapping(path = "/{username}")
    @PreAuthorize("hasAuthority('user:write')")
    public UserResponse updateStudent(@PathVariable String username, @RequestBody UserResponse toUpdate) {
        return service.updateUser(username, toUpdate);
    }


}
