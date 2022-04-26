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
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/addEmployee")
    public String addEmployee() {
        return "addEmployee";
    }

    @PostMapping("/employeeAdd")
    public String employeeAdd(@RequestParam("id") int ID, @RequestParam("name") String Name,
                              @RequestParam("job") String job, @RequestParam("manager") int Manager,
                              @RequestParam("hire_date") String hire_date, @RequestParam("salary") int salary,
                              @RequestParam("commission") int commission, @RequestParam("departmentno") int department) {
        Employees emp = new Employees(ID, Name, job, Manager, hire_date, salary, commission, department);
        employeeRepository.create(emp);
        return "redirect:/employee";
    }

}

