package com.movieinfo.app.repository;

import com.movieinfo.app.domain.TV;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TVRepository extends MongoRepository<TV, String> {

    Optional<TV> findByTvDBId(Integer tvDBId);
}
