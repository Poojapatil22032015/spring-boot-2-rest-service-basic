package com.pooja_sample_project.springboot2restservicebasic.exception;
public class Lib_userNotfoundException extends Exception {
    private String phone_number;
    public Lib_userNotfoundException(String phone_number) {
        super(String.format("User is not found with phone number : '%s'", phone_number));
    }
}