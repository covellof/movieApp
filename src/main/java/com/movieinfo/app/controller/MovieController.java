package com.movieinfo.app.controller;

import com.movieinfo.app.domain.response.MovieList;
import com.movieinfo.app.domain.response.MovieResponse;
import com.movieinfo.app.service.MovieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public MovieList findAll() {
        return service.findAll();
    }

    @GetMapping("{movieDBId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MovieResponse findById(@PathVariable Integer movieDBId) {
        return service.findById(movieDBId);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MovieResponse save(@RequestBody MovieResponse toSave) {
        return service.insertMovie(toSave);
    }

    @PutMapping("/{movieId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MovieResponse update(@PathVariable Integer movieDBId, @RequestBody MovieResponse toUpdate) {
        return service.updateMovie(movieDBId, toUpdate);
    }

    @DeleteMapping("{movieId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Integer movieDBId) {
        service.deleteMovieByDBId(movieDBId);
    }
}
