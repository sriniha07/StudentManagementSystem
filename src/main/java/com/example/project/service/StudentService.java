package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.StudentEntity;

import com.example.project.repository.StudentRepository;
@Service
public class StudentService{
    @Autowired
    private StudentRepository repo;
    public StudentEntity addStudent(StudentEntity s){
        return repo.save(s);
    }
    public List<StudentEntity> getStudents(){
        return repo.findAll();
    }
    public StudentEntity updateStudent(int id,StudentEntity s){
        StudentEntity s1=repo.findById(id).orElse(null);
        if (s!=null){
            s1.setName(s.getName());
            return repo.save(s);
        }
        return null;
    }
    public StudentEntity upStudent(int id,StudentEntity s){
        StudentEntity s1=repo.findById(id).orElse(null);
        if(s1!=null){
            if(s.getName()!=null && !s.getName().isBlank()){
                s1.setName(s.getName());
            }
            return repo.save(s1);
        }
        return null;
    }
    public String deleteStudent(int id){
        repo.deleteById(id);
        return "deleted successfully";
    }
    

}