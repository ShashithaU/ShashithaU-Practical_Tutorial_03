package com.example.controller;

import com.example.entity.StudentEntity;
import com.example.model.StudentModel;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class StudentController {

    final StudentService studentService;
    final ModelMapper modelMapper;
    final StudentRepository studentRepository;

    @PostMapping("/add-students")
    public void addStudent(@RequestBody StudentModel studentmodel) {
        studentService.addStudent(studentmodel);
        System.out.println("Student added successfully");
    }

    @GetMapping("/get-students")
    public List<StudentModel> getAllStudents() {
       return studentService.getAllStudents();
    }

    @DeleteMapping("/delete-student/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @PutMapping("/update-student")
    public void updateStudent(@RequestBody StudentModel studentModel){
        studentService.addStudent(studentModel);
    }

    @GetMapping("/get-students/{year}")
    public List<StudentModel> getStudentsByYear(@PathVariable Integer year){
       return studentService.getStudentsByYear(year);
    }
    @GetMapping("/get-department-by-student-id/{id}")
    public String getDepartmentByStudentId(@PathVariable Long id){
        return studentService.getDepartmentByStudentId(id);
    }

    @DeleteMapping("/delete-student-by-year/{year}")
    public void deleteStudentsByYear(@PathVariable int year){
        studentService.deleteStudentsByYear(year);
    }
}
