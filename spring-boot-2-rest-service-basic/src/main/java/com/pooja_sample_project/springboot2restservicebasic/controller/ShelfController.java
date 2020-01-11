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
    @GetMapping("/Shelf")
    public List<Shelf> getAllSubjects() {
        return shelfRepository.findAll();
    }

    // Create a new Subject
    @PostMapping("/Shelf")
    public Shelf createSubject(@Valid @RequestBody Shelf Subject) {
        return shelfRepository.save(Subject);
    }
    // Get a Single Subject
    @GetMapping("/Shelf/{id}")
    public Shelf getSubjectById(@PathVariable(value = "id") String Subject) throws SubjectNotFoundException {
        return shelfRepository.findById(Subject)
                .orElseThrow(() -> new SubjectNotFoundException(Subject));
    }
    // Delete a Subject
    @DeleteMapping("/Shelf/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable(value = "id") String Subject) throws SubjectNotFoundException {
        Shelf shelf = shelfRepository.findById(Subject)
                .orElseThrow(() -> new SubjectNotFoundException(Subject));

        shelfRepository.delete(shelf);

        return ResponseEntity.ok().build();
    }
}

