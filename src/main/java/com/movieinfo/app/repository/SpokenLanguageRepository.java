package com.movieinfo.app.repository;

import com.movieinfo.app.domain.SpokenLanguage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpokenLanguageRepository extends MongoRepository<SpokenLanguage, String> {
}
