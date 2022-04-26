package com.example.demo.models;

import java.sql.Date;

public class Employees {
    int id;
    String employee_name;
    String job;
    int manager;
    String hiredate;
    int salary;
    int commission;
    int department_number;

    public Employees(int id, String employee_name, String job, int manager, String hiredate, int salary, int commission, int department_number){
        this.id = id;
        this.employee_name = employee_name;
        this.job = job;
        this.manager = manager;
        this.hiredate = hiredate;
        this.salary = salary;
        this.commission = commission;
        this.department_number = department_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getDepartment_number() {
        return department_number;
    }

    public void setDepartment_number(int department_number) {
        this.department_number = department_number;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", employee_name='" + employee_name + '\'' +
                '}';
    }
}
