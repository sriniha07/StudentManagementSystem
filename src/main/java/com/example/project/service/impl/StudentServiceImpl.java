package com.example.project.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.project.entity.Student;
import com.example.project.repository.StudentRepository;
import com.example.project.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> searchStudents(String keyword, String department, String year, int page) {
        List<Student> allStudents = studentRepository.findAll();
        List<Student> filtered = allStudents.stream()
                .filter(student -> keyword == null || keyword.isBlank() || student.getFullName().toLowerCase().contains(keyword.toLowerCase()) || student.getRegisterNumber().toLowerCase().contains(keyword.toLowerCase()))
                .filter(student -> department == null || department.isBlank() || student.getDepartment().equalsIgnoreCase(department))
                .filter(student -> year == null || year.isBlank() || student.getYear().equalsIgnoreCase(year))
                .toList();

        int size = 6;
        int from = Math.min(page * size, filtered.size());
        int to = Math.min(from + size, filtered.size());
        return new PageImpl<>(filtered.subList(from, to), PageRequest.of(page, size), filtered.size());
    }

    @Override
    public long countStudents() {
        return studentRepository.count();
    }

    @Override
    public List<Student> getRecentStudents() {
        return studentRepository.findAll().stream().limit(5).toList();
    }
}
