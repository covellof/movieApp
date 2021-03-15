package com.movieinfo.app.repository;

import com.movieinfo.app.domain.MovieCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCollectionRepository extends MongoRepository<MovieCollection, String> {
}
