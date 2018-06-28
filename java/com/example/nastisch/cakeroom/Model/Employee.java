package com.example.nastisch.cakeroom.Model;

public class Employee extends Staff {

    public String employeeType;
    public String employeeDuties;

    public Employee(String staffFName, String staffLName, String staffPosition, String staffPosDescription,
                    double staffSalary, int storeID, boolean isManager, String employeeType, String employeeDuties) {
        super(staffFName, staffLName, staffPosition, staffPosDescription, staffSalary, storeID, isManager);
        this.employeeType = employeeType;
        this.employeeDuties = employeeDuties;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeDuties() {
        return employeeDuties;
    }

    public void setEmployeeDuties(String employeeDuties) {
        this.employeeDuties = employeeDuties;
    }
}
