package com.pooja_sample_project.springboot2restservicebasic.model;
import org.springframework.data.annotation.Id;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String phone_number;
    @NotBlank
    private String password;
public User(){
    super();
}
public User(String name, String email, String phone_number,String password){
    super();
    this.name=name;
    this.email=email;
    this.phone_number=phone_number;
    this.password=password;
}

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName(){
    return name;
}
public String getEmail(){
    return email;
}
public String getPhone_number(){
    return phone_number;
}
public String getPassword(){
    return password;
}
}
