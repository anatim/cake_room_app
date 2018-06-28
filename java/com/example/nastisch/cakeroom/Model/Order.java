package com.example.nastisch.cakeroom.Model;

public class Order {

    private int ordID;
    private int ordDetID;
    private int cID;
    private String ordDate;
    private double ordTotalAmount;
    private int ordQuantity;

    public Order(int cID, String ordDate, double ordTotalAmount, int ordQuantity) {
        this.cID = cID;
        this.ordDate = ordDate;
        this.ordTotalAmount = ordTotalAmount;
        this.ordQuantity = ordQuantity;
    }

    public String getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(String ordDate) {
        this.ordDate = ordDate;
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

    public int getOrdID() {
        return ordID;
    }

    public int getOrdDetID() {
        return ordDetID;
    }

    public int getcID() {
        return cID;
    }
}
