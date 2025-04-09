package com.pedroituassu.backend.repositories;

import com.pedroituassu.backend.model.AcademicEducation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.Date;

public interface AcademicEducationRepository extends MongoRepository<AcademicEducation, String> {

    @Query("{'title': ?0}")
    AcademicEducation findByTitle(String title);

    @Query("{'title': ?0}")
    void deleteByTitle(String title);

    @Query("{'title': ?0}")
    @Update("{'$set': {'endDate': ?1}}")
    void updateEndDate(String title, Date endDate);
}
