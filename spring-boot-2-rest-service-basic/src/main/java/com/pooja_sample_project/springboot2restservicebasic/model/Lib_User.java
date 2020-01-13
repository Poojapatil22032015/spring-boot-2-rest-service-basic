package com.pooja_sample_project.springboot2restservicebasic.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "Lib_user")
public class Lib_User {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String phone_number;
    @NotBlank
    private String subject;
    public Lib_User(){
        super();

    }
    public Lib_User(Long id, String phone_number, String subject){
        super();
        this.id = id;
        this.phone_number=phone_number;
        this.subject=subject;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
