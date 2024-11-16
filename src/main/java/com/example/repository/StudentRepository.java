package com.example.repository;

import com.example.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {


    List<StudentEntity> findByYearOfEnrollment(Integer year);

    void deleteByYearOfEnrollment(Integer year);
}
