package com.example.nastisch.cakeroom.Model;

public class Company {

    private int companyID;
    private String companyName;
    private int storeID;

    public Company(int companyID, String companyName, int storeID) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.storeID = storeID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getStoreID() {
        return storeID;
    }

}
