package com.pedroituassu.backend.repositories;

import com.pedroituassu.backend.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.Date;
import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {

    @Query("{'name': ?0}")
    Project findByName(String name);

    @Query("{'name': ?0}")
    void deleteByName(String name);

    @Query("{'name': ?0}")
    @Update("{'$set':  {'name':  ?1}}")
    void updateName(String name, String updatedName);

    @Query("{'url': ?0}")
    @Update("{'$set': {'name': ?1}}")
    void updateUrl(String name, String updatedUrl);

    @Query("{'name': ?0}")
    @Update("{'$set':  {'technologies':  ?1}}")
    void updateTechnologies(String name, List<String> technologies);

    @Query("{'name': ?0}")
    @Update("{'$set': {'date':  ?1}}")
    void updateDate(String name, Date date);

    @Query("{'name': ?0}")
    @Update("{'$set':  {'description': ?1}}")
    void updateDescription(String name, List<String> description);
}
