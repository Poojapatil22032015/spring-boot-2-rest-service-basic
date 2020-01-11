package com.pooja_sample_project.springboot2restservicebasic.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "Shelf")
public class Shelf {
    @Id
    @NotBlank
    private String Subject;

    public Shelf() {
        super();
    }
    public Shelf(String subject) {
        super();
        this.Subject = subject;
    }
    public String getSubject() {
        return Subject;
    }
    public void setSubject(String subject) {
        this.Subject = Subject;
    }
}