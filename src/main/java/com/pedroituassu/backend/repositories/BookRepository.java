package com.pedroituassu.backend.repositories;

import com.pedroituassu.backend.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BookRepository extends MongoRepository<Book, String> {
    @Query("{'title': ?0}")
    Book findByTitle(String title);

    void deleteByTitle(String title);
}
