package com.movieinfo.app.security;

import com.movieinfo.app.security.domain.User;
import com.movieinfo.app.security.domain.response.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserResponse> findAll() {
        List<UserResponse> responses =
                repository.findAll().stream().map(User::mapToResponse).collect(Collectors.toList());
        LOGGER.info("Returning all movies");
        return responses;
    }

    public UserResponse findById(String username) {
        Optional<User> document = repository.findByUsername(username);
        if(document.isPresent()) {
            LOGGER.info("Retrieving user with username {}", username);
            return User.mapToResponse(document.get());
        } else {
            LOGGER.error("User with username {} not found", username);
            throw new NotFoundException("User not found with username: " + username);
        }    }

    public UserResponse insertNewUser(UserResponse toSave) {
        if (toSave == null) {
            LOGGER.error("Unable to insert, empty object");
            throw new BadRequestException("Document to be saved was empty");
        } else {
            LOGGER.info("Saving a new user with username: {}", toSave.getUsername());
            User document = User.mapToDocument(toSave);
            repository.insert(document);
            return toSave;
        }
    }

    public void deleteUser(String username) {
        LOGGER.info("Deleting user with username: {}", username);
        User toDelete = repository.findByUsername(username).get();
        repository.deleteById(toDelete.getUsername());
    }

    public UserResponse updateUser(String username, UserResponse toUpdate) {
        if (toUpdate != null) {
            if(repository.findById(username).isPresent()) {
                LOGGER.info("Updating user with username {}", username);
                repository.save(User.mapToDocument(toUpdate));
            } else {
                LOGGER.info("User with username {} not found, inserting in DB instead", username);
                repository.insert(User.mapToDocument(toUpdate));
            }
            return toUpdate;
        } else {
            LOGGER.error("Object to update is null");
            throw new BadRequestException("Document to be saved was empty");
        }
    }
}
