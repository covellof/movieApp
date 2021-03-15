package com.movieinfo.app.repository;

import com.movieinfo.app.domain.Network;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkRepository extends MongoRepository<Network, String> {
}
