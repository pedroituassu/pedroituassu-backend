package com.pedroituassu.backend.repositories;

import com.pedroituassu.backend.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{'name': ?0}")
    Book findByName(String name);

    @Query("{'name': ?0}")
    void deleteByName(String name);

    @Query("{'name': ?0}")
    @Update("{'$set': {'tags': ?1}}")
    void updateTags(String name, List<String> tags);

    @Query("{'name': ?0}")
    @Update("{'$set': {'currentPage': ?1}}")
    void updateCurrentPage(String name, int currentPage);

    @Query("{'name': ?0}")
    @Update("{'$set': {'notes': ?1}}")
    void updateNotes(String name, String notes);
}
