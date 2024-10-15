package com.pluralsight.payroll;

public class Employee {
    private int employeeid;
    private String name;
    private double hoursWorked;
    private double payRate;

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public Employee( int employeeid,String name, double hoursWorked, double payRate) {
        this.name = name;
        this.employeeid = employeeid;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;


    }

    public double getGrosspay() {
        return hoursWorked * payRate;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeid=" + employeeid +
                ", name='" + name + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", payRate=" + payRate +
                '}';
    }
}



