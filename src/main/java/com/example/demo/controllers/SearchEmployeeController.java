package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.models.Employees;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchEmployeeController {

    private final IRepository<Employees> employeeRepository = new EmployeeRepository();

    @GetMapping("/search")
    public String searchEmployee(@RequestParam("id") int id, Model model){
        Employees e = employeeRepository.getSingleById(id);
        model.addAttribute("employees", e);
        return "employees";

    }


}
