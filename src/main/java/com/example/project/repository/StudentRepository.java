package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFullNameContainingIgnoreCase(String fullName);
    List<Student> findByDepartmentContainingIgnoreCase(String department);
    List<Student> findByYearContainingIgnoreCase(String year);
}
