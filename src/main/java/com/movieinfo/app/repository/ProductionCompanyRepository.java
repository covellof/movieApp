package com.movieinfo.app.repository;

import com.movieinfo.app.domain.ProductionCompany;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionCompanyRepository extends MongoRepository<ProductionCompany, String> {
}
