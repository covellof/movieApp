package com.movieinfo.app.repository;

import com.movieinfo.app.domain.Episode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends MongoRepository<Episode, String> {
}
