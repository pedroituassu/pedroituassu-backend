package com.pedroituassu.backend.repositories;

import com.pedroituassu.backend.model.AcademicEducation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AcademicEducationRepository extends MongoRepository<AcademicEducation, String> {
    @Query("{'title': ?0}")
    AcademicEducation findByTitle(String title);

    void deleteByTitle(String title);
}
