package com.example.nastisch.cakeroom.Model;

public class Payment {

    private int payID;
    private int shCartID;
    private double payAmount;
    private String payMethod;
    private int cCardNumber;

    public Payment(int payID, int shCartID, double payAmount, String payMethod, int cCardNumber) {
        this.payID = payID;
        this.shCartID = shCartID;
        this.payAmount = payAmount;
        this.payMethod = payMethod;
        this.cCardNumber = cCardNumber;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public int getcCardNumber() {
        return cCardNumber;
    }

    public int getPayID() {
        return payID;
    }

    public int getShCartID() {
        return shCartID;
    }
}
