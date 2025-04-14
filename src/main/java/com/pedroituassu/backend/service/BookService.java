package com.pedroituassu.backend.service;

import com.pedroituassu.backend.dtos.BookUpdateDTO;
import com.pedroituassu.backend.model.Book;
import java.util.List;
import com.pedroituassu.backend.repositories.BookRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final MongoTemplate mongoTemplate;

    public BookService(BookRepository bookRepository, MongoTemplate mongoTemplate) {
        this.bookRepository = bookRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public void deleteBook(String title) {
        bookRepository.deleteByTitle(title);
    }

    public void partialUpdateBook(String title, BookUpdateDTO updates) {
        Query query = Query.query(Criteria.where("title").is(title));
        Update update = new Update();

        if (updates.getTitle() != null) update.set("title", updates.getTitle());
        if (updates.getAuthor() != null) update.set("author", updates.getAuthor());
        if (updates.getTags() != null) update.set("tags", updates.getTags());
        if (updates.getPages() != 0) update.set("pages", updates.getPages());
        if (updates.getCurrentPage() != 0) update.set("currentPage", updates.getCurrentPage());
        if (updates.getNotes() != null) update.set("notes", updates.getNotes());

        mongoTemplate.updateFirst(query, update, Book.class);
    }
}
