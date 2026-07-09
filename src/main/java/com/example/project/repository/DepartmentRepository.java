package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
