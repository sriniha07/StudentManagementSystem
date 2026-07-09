package com.example.project.service;

import java.util.List;

import com.example.project.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department updateDepartment(Department department);
    void deleteDepartment(Long id);
}
