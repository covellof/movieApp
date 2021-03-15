package com.movieinfo.app.security.auth;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AppUserDetailsRepository extends MongoRepository<AppUserDetails, String> {

    Optional<AppUserDetails> findAppUserDetailsByUsername(String username);
}
