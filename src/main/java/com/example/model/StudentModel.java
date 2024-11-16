package com.example.model;

import lombok.Data;

@Data
public class StudentModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private int yearOfEnrollment;
}


