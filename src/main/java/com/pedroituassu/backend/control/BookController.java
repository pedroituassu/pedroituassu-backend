package com.pedroituassu.backend.control;

import com.pedroituassu.backend.model.Book;
import com.pedroituassu.backend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{name}")
    public Book getBook(@PathVariable String name) {
        return bookRepository.findByName(name);
    }

    @DeleteMapping("/book/{name}")
    public void deleteBook(@PathVariable String name) {
        bookRepository.deleteByName(name);
    }

    @PutMapping("/book/{name}/tags")
    public void updateBookTags(@PathVariable String name, @RequestBody List<String> tags) {
        bookRepository.updateTags(name, tags);
    }

    @PutMapping("/book/{name}/page")
    public void updateCurrentPage(@PathVariable String name, @RequestBody int page) {
        bookRepository.updateCurrentPage(name, page);
    }

    @PutMapping("/book/{name}/notes")
    public void updateNotes(@PathVariable String name, @RequestBody String notes) {
        bookRepository.updateNotes(name, notes);
    }
}
