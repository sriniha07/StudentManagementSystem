package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project.service.DepartmentService;
import com.example.project.service.StudentService;

@Controller
public class DashboardController {

    private final StudentService studentService;
    private final DepartmentService departmentService;

    public DashboardController(StudentService studentService, DepartmentService departmentService) {
        this.studentService = studentService;
        this.departmentService = departmentService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("studentCount", studentService.countStudents());
        model.addAttribute("departmentCount", departmentService.getAllDepartments().size());
        model.addAttribute("recentStudents", studentService.getRecentStudents());
        model.addAttribute("activePage", "dashboard");
        return "dashboard";
    }
}
