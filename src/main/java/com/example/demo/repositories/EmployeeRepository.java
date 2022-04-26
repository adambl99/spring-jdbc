package com.example.demo.repositories;

import com.example.demo.models.Employees;
import com.example.demo.utility.DatabaseConnectionManager;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employees> {


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
                        rs.getDate(5),
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
                    rs.getDate(5),
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
        return false;
    }
}
