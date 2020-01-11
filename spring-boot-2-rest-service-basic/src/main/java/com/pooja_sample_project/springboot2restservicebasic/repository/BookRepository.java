package com.pooja_sample_project.springboot2restservicebasic.repository;
import com.pooja_sample_project.springboot2restservicebasic.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}