package com.movieinfo.app.service;

import com.movieinfo.app.domain.Movie;
import com.movieinfo.app.domain.response.MovieList;
import com.movieinfo.app.domain.response.MovieResponse;
import com.movieinfo.app.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieResponse findById(Integer movieDbId) {
        Optional<Movie> document = repository.findByMovieDBId(movieDbId);
        if(document.isPresent()) {
            LOGGER.info("Retrieving movie with id {}", movieDbId);
            return Movie.toResponse(document.get());
        } else {
            LOGGER.error("Movie with id {} not found", movieDbId);
            throw new NotFoundException("Movie not found with id: " + movieDbId);
        }
    }

    public MovieList findAll() {
        List<MovieResponse> responses =
                repository.findAll().stream().map(Movie::toResponse).collect(Collectors.toList());
        MovieList movieList = new MovieList();
        movieList.setResults(responses);
        LOGGER.info("Returning all movies");
        return movieList;
    }

    public MovieResponse insertMovie(MovieResponse toSave) {
        if (toSave == null) {
            LOGGER.error("Unable to insert, empty object");
            throw new BadRequestException("Document to be saved was empty");
        } else {
            LOGGER.info("Saving a new movie with id: {}", toSave.getId());
            Movie document = Movie.mapToDocument(toSave);
            repository.insert(document);
            return toSave;
        }
    }

    public MovieResponse updateMovie(Integer movieDBId, MovieResponse toUpdate) {
        if (toUpdate != null) {
            if(repository.findByMovieDBId(movieDBId).isPresent()) {
                LOGGER.info("Updating movie with id {}", movieDBId);
                repository.save(Movie.mapToDocument(toUpdate));
            } else {
                LOGGER.info("Movie with id {} not found, inserting in DB instead", movieDBId);
                repository.insert(Movie.mapToDocument(toUpdate));
            }
            return toUpdate;
        } else {
            LOGGER.error("Object to update is null");
            throw new BadRequestException("Document to be saved was empty");
        }
    }

    public void deleteMovieByDBId(Integer movieDBId) {
        LOGGER.info("Deleting movie with id: {}", movieDBId);
        Movie toDelete = repository.findByMovieDBId(movieDBId).get();
        repository.deleteById(toDelete.getId());
    }
}
