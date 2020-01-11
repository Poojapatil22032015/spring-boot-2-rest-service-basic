package com.pooja_sample_project.springboot2restservicebasic.exception;
public class SubjectNotFoundException extends Exception {
    private String Subject;
    public SubjectNotFoundException(String Subject) {
        super(String.format("Subject is not found with name : '%s'", Subject));
    }
}