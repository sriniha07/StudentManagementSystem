package com.example.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.project.entity.Student;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
    Page<Student> searchStudents(String keyword, String department, String year, int page);
    long countStudents();
    List<Student> getRecentStudents();
}
