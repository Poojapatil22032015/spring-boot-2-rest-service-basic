package com.pooja_sample_project.springboot2restservicebasic.controller;
import com.pooja_sample_project.springboot2restservicebasic.model.*;
import com.pooja_sample_project.springboot2restservicebasic.repository.BookRepository;
import com.pooja_sample_project.springboot2restservicebasic.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    // Get All Books
    @CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Create a new Note
    @CrossOrigin(origins = "http://localhost:8088")
    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Get a Single Book
    @CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/books/{id}")
    public Book getNoteById(@PathVariable(value = "id") String bookId) throws BookNotFoundException {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }

    // Update a Book
    @CrossOrigin(origins = "http://localhost:8088")
    @PutMapping("/books/{id}")
    public Book updateNote(@PathVariable(value = "id") String bookId,
                           @Valid @RequestBody Book bookDetails) throws BookNotFoundException {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        book.setBook_name(bookDetails.getBook_name());
        book.setAuthor_name(bookDetails.getAuthor_name());
        book.setSub_name(bookDetails.getSub_name());

        Book updatedBook = bookRepository.save(book);

        return updatedBook;
    }

    // Delete a Book
    @CrossOrigin(origins = "http://localhost:8088")
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") String bookId) throws BookNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        bookRepository.delete(book);

        return ResponseEntity.ok().build();
    }
}
