package com.movieinfo.app.repository;

import com.movieinfo.app.domain.Creator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepository extends MongoRepository<Creator, Integer> {
}
