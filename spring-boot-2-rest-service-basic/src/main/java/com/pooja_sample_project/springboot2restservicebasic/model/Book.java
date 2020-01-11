package com.pooja_sample_project.springboot2restservicebasic.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @NotBlank
    private String book_name;
    @NotBlank
    private String author_name;
    @NotBlank
    private String Sub_name;
    public Book(){
        super();
    }
    public Book(String book_name, String author_name, String Sub_name) {
        super();
        this.book_name = book_name;
        this.author_name = author_name;
        this.Sub_name= Sub_name;
    }
    public String getBook_name() {
        return book_name;
    }
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    public String getAuthor_name() {
        return author_name;
    }
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
    public String getSub_name() {
        return Sub_name;
    }
    public void setSub_name(String Sub_name) {
        this.Sub_name = Sub_name;
    }
}
