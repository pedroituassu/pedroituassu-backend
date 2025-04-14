package com.pedroituassu.backend.repositories;

import com.pedroituassu.backend.model.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ExperienceRepository extends MongoRepository<Experience, String> {
    @Query("{'enterprise': ?0}")
    Experience findByEnterprise(String enterprise);

    void deleteByEnterprise(String enterprise);
}
