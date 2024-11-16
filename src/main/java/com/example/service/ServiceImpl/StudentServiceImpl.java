package com.example.service.ServiceImpl;

import com.example.entity.StudentEntity;
import com.example.model.StudentModel;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


       final StudentRepository studentRepository;
       final ModelMapper mapper;

    public void addStudent(StudentModel StudentModel) {

       studentRepository.save(mapper.map(StudentModel,StudentEntity.class));

   }

    @Override
    public List<StudentModel> getAllStudents() {
        List<StudentModel> studentModels = new ArrayList<>();
        studentRepository.findAll().forEach(student -> studentModels.add(mapper.map(student,StudentModel.class)));
        return studentModels;
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentModel> getStudentsByYear(Integer year) {
        List<StudentModel> studentModels = new ArrayList<>();
        studentRepository.findByYearOfEnrollment(year).forEach(student -> studentModels.add(mapper.map(student,StudentModel.class)));
        return studentModels;
    }

    @Override
    public String getDepartmentByStudentId(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        if(studentEntity == null){
            return "Invalid Student Id! Please enter a valid student id";
        }
        return studentEntity.getDepartment();
    }

    @Override
    @Transactional
    public void deleteStudentsByYear(int year) {
        studentRepository.deleteByYearOfEnrollment(year);
    }


}

