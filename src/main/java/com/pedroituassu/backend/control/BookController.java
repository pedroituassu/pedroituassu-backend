package com.pedroituassu.backend.control;

import com.pedroituassu.backend.dtos.BookUpdateDTO;
import com.pedroituassu.backend.model.Book;
import com.pedroituassu.backend.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @DeleteMapping("/{title}")
    public void deleteBook(@PathVariable String title) {
        bookService.deleteBook(title);
    }

    @PatchMapping("/{title}")
    public ResponseEntity<Void> partialUpdateBook(
            @PathVariable String title,
            @RequestBody BookUpdateDTO updates
    ) {
        bookService.partialUpdateBook(title, updates);
        return ResponseEntity.ok().build();
    }
}
