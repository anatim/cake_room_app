package com.example.nastisch.cakeroom.Model;

public class Store {

    private int storeID;
    private int staffID;
    private int storeZIP;
    private int cID;
    private int pID;
    private String cRegDate;
    private String storeStreet;
    private String storeBuilding;
    private String storePhone;
    private String storeOpeningHours;
    private String storeSuburb;
    private boolean pStatus;

    public Store(int storeID, int storeZIP, String cRegDate, String storeStreet, String storeBuilding,
                 String storePhone, String storeOpeningHours, String storeSuburb, boolean pStatus) {
        this.storeID = storeID;
        this.storeZIP = storeZIP;
        this.cRegDate = cRegDate;
        this.storeStreet = storeStreet;
        this.storeBuilding = storeBuilding;
        this.storePhone = storePhone;
        this.storeOpeningHours = storeOpeningHours;
        this.storeSuburb = storeSuburb;
        this.pStatus = pStatus;
    }

    public int getStoreZIP() {
        return storeZIP;
    }

    public void setStoreZIP(int storeZIP) {
        this.storeZIP = storeZIP;
    }

    public String getcRegDate() {
        return cRegDate;
    }

    public String getStoreStreet() {
        return storeStreet;
    }

    public void setStoreStreet(String storeStreet) {
        this.storeStreet = storeStreet;
    }

    public String getStoreBuilding() {
        return storeBuilding;
    }

    public void setStoreBuilding(String storeBuilding) {
        this.storeBuilding = storeBuilding;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreOpeningHours() {
        return storeOpeningHours;
    }

    public void setStoreOpeningHours(String storeOpeningHours) {
        this.storeOpeningHours = storeOpeningHours;
    }

    public String getStoreSuburb() {
        return storeSuburb;
    }

    public void setStoreSuburb(String storeSuburb) {
        this.storeSuburb = storeSuburb;
    }

    public boolean ispStatus() {
        return pStatus;
    }

    public void setpStatus(boolean pStatus) {
        this.pStatus = pStatus;
    }

    public int getStoreID() {
        return storeID;
    }

    public int getStaffID() {
        return staffID;
    }

    public int getcID() {
        return cID;
    }

    public int getpID() {
        return pID;
    }
}
