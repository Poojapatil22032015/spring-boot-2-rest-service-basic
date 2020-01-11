package com.pooja_sample_project.springboot2restservicebasic.exception;
public class UserNotFoundException extends Exception {
    private String phone_number;
    public UserNotFoundException(String phone_number) {
        super(String.format("User is not found with phone number : '%s'", phone_number));
    }
}