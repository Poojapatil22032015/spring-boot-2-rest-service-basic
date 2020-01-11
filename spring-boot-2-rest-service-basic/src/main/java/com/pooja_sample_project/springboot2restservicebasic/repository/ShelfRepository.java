package com.pooja_sample_project.springboot2restservicebasic.repository;
import com.pooja_sample_project.springboot2restservicebasic.model.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
@Repository
public interface ShelfRepository extends JpaRepository<Shelf, String> {

}
