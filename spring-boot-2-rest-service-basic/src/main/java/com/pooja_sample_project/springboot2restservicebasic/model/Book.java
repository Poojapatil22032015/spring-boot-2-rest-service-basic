package com.pooja_sample_project.springboot2restservicebasic.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String phone_number;
    @NotBlank
    private String book_name;
    @NotBlank
    private String author_name;
    @NotBlank
    private String sub_name;
    public Book(){

        super();
    }
    public Book(Long id, String phone_number, String book_name, String author_name, String sub_name) {
        super();
        this.id = id;
        this.phone_number = phone_number;
        this.book_name = book_name;
        this.author_name = author_name;
        this.sub_name= sub_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
        return sub_name;
    }
    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }
}
