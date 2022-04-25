package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee> {


    @Override
    public List<Employee> getAllEntities() {
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Employee> allEmployees = new ArrayList<Employee>();

        return null;

        //TODO OPSÆT DB CONNECTION
    }

    @Override
    public Employee getSingleById(int id) {
        return null;
    }

    @Override
    public boolean create(Employee entity) {
        return false;
    }
}
