package com.example.nastisch.cakeroom.Model;

public class Manager extends Staff {

public String managerType;
public String managerDuties;

    public Manager(String staffFName, String staffLName, String staffPosition, String staffPosDescription,
                   double staffSalary, int storeID, boolean isManager, String managerType, String managerDuties) {
        super(staffFName, staffLName, staffPosition, staffPosDescription, staffSalary, storeID, isManager);
        this.managerType = managerType;
        this.managerDuties = managerDuties;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    public String getManagerDuties() {
        return managerDuties;
    }

    public void setManagerDuties(String managerDuties) {
        this.managerDuties = managerDuties;
    }



}
