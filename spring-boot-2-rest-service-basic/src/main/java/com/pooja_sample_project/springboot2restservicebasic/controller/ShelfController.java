package com.pooja_sample_project.springboot2restservicebasic.controller;
import com.pooja_sample_project.springboot2restservicebasic.exception.SubjectNotFoundException;
import  com.pooja_sample_project.springboot2restservicebasic.model.Shelf;
import com.pooja_sample_project.springboot2restservicebasic.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;
@RestController
public class ShelfController {
    @Autowired
    private
    ShelfRepository shelfRepository;

    // Get All Subjects
    @CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/Shelf")
    public List<Shelf> getAllSubjects() {
        return shelfRepository.findAll();
    }

    // Create a new Subject
    @CrossOrigin(origins = "http://localhost:8088")
    @PostMapping("/Shelf")
    public Shelf createSubject(@Valid @RequestBody Shelf Subject) {
        return shelfRepository.save(Subject);
    }
    // Get a Single Subject
    @CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/Shelf/{id}")
    public Shelf getSubjectById(@PathVariable(value = "id") String Subject) throws SubjectNotFoundException {
        return shelfRepository.findById(Subject)
                .orElseThrow(() -> new SubjectNotFoundException(Subject));
    }
    // Delete a Subject
    @CrossOrigin(origins = "http://localhost:8088")
    @DeleteMapping("/Shelf/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable(value = "id") String Subject) throws SubjectNotFoundException {
        Shelf shelf = shelfRepository.findById(Subject)
                .orElseThrow(() -> new SubjectNotFoundException(Subject));

        shelfRepository.delete(shelf);

        return ResponseEntity.ok().build();
    }
}

