package com.example.service;

import com.example.entity.StudentEntity;
import com.example.model.StudentModel;

import java.util.List;

public interface StudentService {
    public void addStudent(StudentModel StudentModel);
    public List<StudentModel> getAllStudents();

    void deleteById(Long id);


    public List<StudentModel> getStudentsByYear(Integer year);

   public String getDepartmentByStudentId(Long id);

    void deleteStudentsByYear(int year);
}
