package com.example.nastisch.cakeroom.Model;

public abstract class Staff {

    private int staffID;
    private String staffFName;
    private String staffLName;
    private String staffPosition;
    private String staffPosDescription;
    private double staffSalary;
    private int storeID;
    private boolean isManager;

    public Staff(String staffFName, String staffLName, String staffPosition, String staffPosDescription,
                 double staffSalary, int storeID, boolean isManager) {
        this.staffFName = staffFName;
        this.staffLName = staffLName;
        this.staffPosition = staffPosition;
        this.staffPosDescription = staffPosDescription;
        this.staffSalary = staffSalary;
        this.storeID = storeID;
        this.isManager = isManager;
    }

    public String getStaffFName() {
        return staffFName;
    }

    public void setStaffFName(String staffFName) {
        this.staffFName = staffFName;
    }

    public String getStaffLName() {
        return staffLName;
    }

    public void setStaffLName(String staffLName) {
        this.staffLName = staffLName;
    }

    public String getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition;
    }

    public String getStaffPosDescription() {
        return staffPosDescription;
    }

    public void setStaffPosDescription(String staffPosDescription) {
        this.staffPosDescription = staffPosDescription;
    }

    public double getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(double staffSalary) {
        this.staffSalary = staffSalary;
    }

    public int getStoreID() {
        return storeID;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public int getStaffID() {
        return staffID;
    }
}
