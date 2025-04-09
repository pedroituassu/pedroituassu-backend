package com.pedroituassu.backend.repositories;

import com.pedroituassu.backend.model.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.Date;
import java.util.List;

public interface ExperienceRepository extends MongoRepository<Experience, String> {

    @Query("{'enterprise': ?0}")
    Experience findByEnterprise(String enterprise);

    @Query("{'enterprise': ?0}")
    void deleteByEnterprise(String enterprise);

    @Query("{'enterprise': ?0}")
    @Update("{'$set':  {'role': ?1}}")
    void updateRole(String enterprise, String role);

    @Query("{'enterprise': ?0}")
    @Update("{'$set':  {'endDate': ?1}}")
    void updateEndDate(String enterprise, Date endDate);

    @Query("{'enterprise': ?0}")
    @Update("{'$set':  {'description': ?1}}")
    void updateDescription(String enterprise, List<String> description);
}
