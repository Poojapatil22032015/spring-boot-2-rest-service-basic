package com.pooja_sample_project.springboot2restservicebasic.controller;
import com.pooja_sample_project.springboot2restservicebasic.model.*;
import com.pooja_sample_project.springboot2restservicebasic.repository.BookRepository;
import com.pooja_sample_project.springboot2restservicebasic.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.ArrayList;
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
    @GetMapping("/books/1/{userid}/{book_name}")
    public Book getNoteById(@PathVariable(value = "userid") String userId,
                            @PathVariable(value = "book_name") String book_name) throws BookNotFoundException {
        List<Book> ls = bookRepository.findAll();
        Book book = null;
        for(int i=0; i<ls.size(); i++){
            if(ls.get(i).getBook_name().contentEquals(book_name) && ls.get(i).getPhone_number().contentEquals(userId)){
                book = ls.get(i);
            }
        }
        return book;
    }

    // Get all Books for a user
    @CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/books/{phone_number}")
    public List<Book> getBookById(@PathVariable(value = "phone_number") String phone_number) throws BookNotFoundException {
        List<Book> ls = bookRepository.findAll();
        List<Book> res = new ArrayList<>();
        for(int i=0; i<ls.size(); i++){
            if(ls.get(i).getPhone_number().contentEquals(phone_number)){
                res.add(ls.get(i));
            }
        }
        return res;
    }

    // Get all Books for a user and author
    @CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/books/{phone_number}/{author}")
    public List<Book> getbookbyauthoranduser(@PathVariable(value = "phone_number") String phone_number,
                                  @PathVariable(value = "author")String author) throws BookNotFoundException {
        List<Book> ls = bookRepository.findAll();
        List<Book> res = new ArrayList<>();
        for(int i=0; i<ls.size(); i++){
            if(ls.get(i).getPhone_number().contentEquals(phone_number) && ls.get(i).getAuthor_name().contentEquals(author)){
                res.add(ls.get(i));
            }
        }
        return res;
    }

//    // Update a Book
//    @CrossOrigin(origins = "http://localhost:8088")
//    @PutMapping("/books/{id}")
//    public Book updateNote(@PathVariable(value = "id") String bookId,
//                           @Valid @RequestBody Book bookDetails) throws BookNotFoundException {
//
//        Book book = bookRepository.findById(bookId)
//                .orElseThrow(() -> new BookNotFoundException(bookId));
//
//        book.setBook_name(bookDetails.getBook_name());
//        book.setAuthor_name(bookDetails.getAuthor_name());
//        book.setSub_name(bookDetails.getSub_name());
//
//        Book updatedBook = bookRepository.save(book);
//
//        return updatedBook;
//    }

// Delete a Book
    @CrossOrigin(origins = "http://localhost:8088")
    @DeleteMapping("/books/{id}/{book_name}")
    public String deleteBookById(@PathVariable(value = "id") String bookId, @PathVariable(value="book_name") String book_name) throws BookNotFoundException {
        List <Book> ls=bookRepository.findAll();
        for(int i=0;i<ls.size();i++){
            if(ls.get(i).getBook_name().contentEquals(book_name)&& ls.get(i).getPhone_number().contentEquals(bookId)){
                bookRepository.delete(ls.get(i));
                break;
            }
        }
        return "Deleted Successfully";
    }
}
