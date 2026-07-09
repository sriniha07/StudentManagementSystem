package com.example.project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entity.StudentEntity;
import com.example.project.service.StudentService;

@RestController
@CrossOrigin(origins="*")
public class StudentController{
    @Autowired
    private StudentService service;
    @PostMapping("/stu")
    public StudentEntity addStudent (@RequestBody StudentEntity s){
        return service.addStudent(s);
    }
    @GetMapping("/students")
    public List <StudentEntity> getStudents(){
        return service.getStudents();
    }
    @PutMapping("/student/{id}")
    public StudentEntity updateStudent(@PathVariable int id,@RequestBody StudentEntity s){
        return service.updateStudent(id,s);
    }
    @PatchMapping("/stud/{id}")
    public StudentEntity upStudent(@PathVariable int id,@RequestBody StudentEntity s){
        return service.upStudent(id,s);
    }
    @DeleteMapping("/studs/{id}")
    public String deleteStudent(@PathVariable int id){
        return service.deleteStudent(id);

    }

}