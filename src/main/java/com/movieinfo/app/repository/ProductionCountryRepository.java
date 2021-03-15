package com.movieinfo.app.repository;

import com.movieinfo.app.domain.ProductionCountry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionCountryRepository extends MongoRepository<ProductionCountry, String> {
}
