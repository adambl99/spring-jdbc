package com.example.demo.models;

public class Employee {
    private int employeeNo;
    private String employeeName;

    public Employee(int employeeNo, String employeeName){
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNo=" + employeeNo +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
