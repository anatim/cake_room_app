package com.example.nastisch.cakeroom.Model;

public class LoyaltyPoints {

    private int lpID;
    private String lpName;
    private String lpDescription;
    private int lpPoints;
    private String lpTCs;
    private int pID;

    public LoyaltyPoints(int lpID, String lpName, String lpDescription, int lpPoints, String lpTCs) {
        this.lpID = lpID;
        this.lpName = lpName;
        this.lpDescription = lpDescription;
        this.lpPoints = lpPoints;
        this.lpTCs = lpTCs;
    }

    public String getLpName() {
        return lpName;
    }

    public void setLpName(String lpName) {
        this.lpName = lpName;
    }

    public String getLpDescription() {
        return lpDescription;
    }

    public void setLpDescription(String lpDescription) {
        this.lpDescription = lpDescription;
    }

    public int getLpPoints() {
        return lpPoints;
    }

    public void setLpPoints(int lpPoints) {
        this.lpPoints = lpPoints;
    }

    public String getLpTCs() {
        return lpTCs;
    }

    public void setLpTCs(String lpTCs) {
        this.lpTCs = lpTCs;
    }

    public int getLpID() {
        return lpID;
    }

    public int getpID() {
        return pID;
    }
}
