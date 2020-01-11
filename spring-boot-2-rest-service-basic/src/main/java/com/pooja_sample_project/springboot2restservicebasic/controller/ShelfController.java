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
        return ShelfRepository.findAll();
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
    // Update Subject
    @PutMapping("/Shelf/{id}")
    public Shelf updateSubject(@PathVariable(value = "Subject") String Subject,
                           @Valid @RequestBody Shelf subjectDetails) throws SubjectNotFoundException {

        Shelf shelf = shelfRepository.findById(Subject)
                .orElseThrow(() -> new SubjectNotFoundException(Subject));

        shelf.setSubject(subjectDetails.getSubject());

        Shelf updatedSubject = (Shelf) shelfRepository.save(Subject);

        return updatedSubject;
    }
    // Delete a Subject
    @DeleteMapping("/Shelf/{Subject}")
    public ResponseEntity<?> deleteSubject(@PathVariable(value = "id") String Subject) throws SubjectNotFoundException {
        Shelf shelf = shelfRepository.findById(Subject)
                .orElseThrow(() -> new SubjectNotFoundException(Subject));

        shelfRepository.delete(Subject);

        return ResponseEntity.ok().build();
    }
}

