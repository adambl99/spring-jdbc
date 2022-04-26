package com.example.demo.repositories;

import com.example.demo.models.Employees;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepository implements IRepository<Employees> {
    static String sqlString;
    static Statement stmt;


    @Override
    public List<Employees> getAllEntities() {
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Employees> allEmployees = new ArrayList<Employees>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Employees temp = new Employees(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                allEmployees.add(temp);
            }
        } catch (SQLException e){
            System.out.println("Something is wrong in the statement");
            e.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public Employees getSingleById(int id) {
        Connection conn = DatabaseConnectionManager.getConnection();
        try{
            PreparedStatement prtsmt = conn.prepareStatement("SELECT * FROM employees WHERE id = ?");
            prtsmt.setInt(1, id);
            prtsmt.execute();
            ResultSet rs = prtsmt.getResultSet();
            rs.next();
            Employees temp = new Employees(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8)
            );
            return temp;
        }
        catch (SQLException e ){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean create(Employees entity) {
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            String insert = "Insert INTO employees (`id`, `employee_name`, `job`, `manager`, `hiredate`, `salary`, `commission`, `department_number`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insert);
            stmt.setInt(1, (entity.getId()));
            stmt.setString(2, (entity.getEmployee_name()));
            stmt.setString(3, (entity.getJob()));
            stmt.setInt(4, (entity.getManager()));
            stmt.setString(5, (entity.getHiredate()));
            stmt.setInt(6, (entity.getSalary()));
            stmt.setInt(7, (entity.getCommission()));
            stmt.setInt(8, (entity.getDepartment_number()));
            stmt.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }


    }

