package com.movieinfo.app.controller;

import com.movieinfo.app.domain.response.MovieResponse;
import com.movieinfo.app.service.ExternalMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class ExternalMovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalMovieController.class);

    private ExternalMovieService service;

    public ExternalMovieController(ExternalMovieService service) {
        this.service = service;
    }

    @GetMapping(value = "/{movieId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findMovie(@PathVariable String movieId) {
        return service.getByMovieId(movieId);
    }

    @GetMapping(value = "/popular")
    public ResponseEntity<?> findPopular() {
        return service.getByPopularity();
    }

    @GetMapping(value = "/{movieId}/save")
    public MovieResponse fetchMovieAndSave(@PathVariable String movieId) {
        MovieResponse movie = (MovieResponse) findMovie(movieId).getBody();
        return service.saveToApi(movie);
    }

    @GetMapping(value = "/saveDBtoLocal")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public boolean getFullDB() {
        for (int id = 1; id < 5474; id++) {
            MovieResponse movie = fetchMovieAndSave(String.valueOf(id));
            LOGGER.info("Saving movie with id {}, {}", id, movie);
        }
        return true;
    }
}
