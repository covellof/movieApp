package com.movieinfo.app.repository;

import com.movieinfo.app.domain.Season;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends MongoRepository<Season, String> {
}
