package com.example.nastisch.cakeroom.Model;

public class OrderDetails {

    private int ordDetID;
    private int ordID;
    private int cID;
    private int pID;
    private String ordDetPickupDate;
    private double ordTotalAmount;
    private int ordQuantity;
    private String cFName;
    private String cLName;
    private String ordDate;
    private String pName;
    private double pPricePerEach;
    private int lpID;

    public OrderDetails(int ordID, int cID, int pID, String ordDetPickupDate, double ordTotalAmount,
                        int ordQuantity, String cFName, String cLName, String ordDate, String pName, double pPricePerEach, int lpID) {
        this.ordID = ordID;
        this.cID = cID;
        this.pID = pID;
        this.ordDetPickupDate = ordDetPickupDate;
        this.ordTotalAmount = ordTotalAmount;
        this.ordQuantity = ordQuantity;
        this.cFName = cFName;
        this.cLName = cLName;
        this.ordDate = ordDate;
        this.pName = pName;
        this.pPricePerEach = pPricePerEach;
        this.lpID = lpID;
    }

    public String getOrdDetPickupDate() {
        return ordDetPickupDate;
    }

    public void setOrdDetPickupDate(String ordDetPickupDate) {
        this.ordDetPickupDate = ordDetPickupDate;
    }

    public double getOrdTotalAmount() {
        return ordTotalAmount;
    }

    public void setOrdTotalAmount(double ordTotalAmount) {
        this.ordTotalAmount = ordTotalAmount;
    }

    public int getOrdQuantity() {
        return ordQuantity;
    }

    public void setOrdQuantity(int ordQuantity) {
        this.ordQuantity = ordQuantity;
    }

    public String getcFName() {
        return cFName;
    }


    public String getcLName() {
        return cLName;
    }

    public String getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(String ordDate) {
        this.ordDate = ordDate;
    }

    public String getpName() {
        return pName;
    }


    public double getpPricePerEach() {
        return pPricePerEach;
    }

    public int getOrdDetID() {
        return ordDetID;
    }

    public int getOrdID() {
        return ordID;
    }

    public int getcID() {
        return cID;
    }

    public int getpID() {
        return pID;
    }

    public int getLpID() {
        return lpID;
    }
}
