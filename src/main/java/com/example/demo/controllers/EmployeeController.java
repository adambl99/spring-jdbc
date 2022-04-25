package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    private final IRepository<Employee> employeeRepository = new EmployeeRepository();

    @GetMapping("/employee")
    public String allDepartments(Model model){
       employeeRepository.getAllEntities();
        return "employees";
    }
}

