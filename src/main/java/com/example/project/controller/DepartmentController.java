package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.project.entity.Department;
import com.example.project.service.DepartmentService;

import jakarta.validation.Valid;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public String departments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("department", new Department());
        model.addAttribute("activePage", "departments");
        return "departments";
    }

    @PostMapping("/departments/save")
    public String saveDepartment(@Valid @ModelAttribute("department") Department department,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentService.getAllDepartments());
            model.addAttribute("activePage", "departments");
            return "departments";
        }
        departmentService.saveDepartment(department);
        redirectAttributes.addFlashAttribute("successMessage", "Department saved successfully.");
        return "redirect:/departments";
    }

    @GetMapping("/departments/delete/{id}")
    public String deleteDepartment(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        departmentService.deleteDepartment(id);
        redirectAttributes.addFlashAttribute("successMessage", "Department deleted successfully.");
        return "redirect:/departments";
    }
}
