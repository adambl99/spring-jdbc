package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.models.Employees;
import com.example.demo.models.Employees;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class EmployeeController {
    private final IRepository<Employees> employeeRepository = new EmployeeRepository();

    @GetMapping("/employee")
    public String allEmployees(Model model){
       model.addAttribute("employees", employeeRepository.getAllEntities());
        return "employees";
    }
    @GetMapping("/create")
    public String createEmployee(@RequestParam ("id") int id, @RequestParam("employee_name") String employee_name, @RequestParam("job") String job, @RequestParam("manager") int manager, @RequestParam("hiredate") String hiredate, @RequestParam("salary") int salary, @RequestParam("commission") int commission, @RequestParam("department_number") int department_number, Model model){
        Employees employees = new Employees(id, employee_name, job, manager, hiredate, salary, commission, department_number);
        employeeRepository.create(employees);
        model.addAttribute("employees", employeeRepository.getAllEntities());
        return "employees";
    }
}
//http://localhost:8080/create?id=420?employee_name=Adam?job=Designer?manager=10?hiredate=1010?salary=4200?commission=420?department_number=200

