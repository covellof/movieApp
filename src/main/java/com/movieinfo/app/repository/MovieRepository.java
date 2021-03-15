package com.movieinfo.app.repository;

import com.movieinfo.app.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    Optional<Movie> findByMovieDBId(Integer tvDBId);
}
