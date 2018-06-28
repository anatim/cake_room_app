package com.example.nastisch.cakeroom.Model;

public class Customer {

    private int cID;
    private String cFName;
    private String cLName;
    private int cZIP;
    private int ordID;
    private int ordDetID;
    private int lpID;
    private int cCardNumber;
    private String cCardFullName;
    private String cCardType;
    private String cCardExpiryDate;
    private int cCardCVV;
    private String cStreet;
    private String cCity;
    private String cSuburb;
    private String cRegDate;
    private int storeID;

    public Customer(String cFName, String cLName, int cZIP, int cCardNumber,
                    String cCardFullName, String cCardType, String cCardExpiryDate,
                    int cCardCVV, String cStreet, String cCity, String cSuburb, String cRegDate) {
        this.cFName = cFName;
        this.cLName = cLName;
        this.cZIP = cZIP;
        this.cCardNumber = cCardNumber;
        this.cCardFullName = cCardFullName;
        this.cCardType = cCardType;
        this.cCardExpiryDate = cCardExpiryDate;
        this.cCardCVV = cCardCVV;
        this.cStreet = cStreet;
        this.cCity = cCity;
        this.cSuburb = cSuburb;
        this.cRegDate = cRegDate;
    }

    public String getcFName() {
        return cFName;
    }

    public void setcFName(String cFName) {
        this.cFName = cFName;
    }

    public String getcLName() {
        return cLName;
    }

    public void setcLName(String cLName) {
        this.cLName = cLName;
    }

    public int getcZIP() {
        return cZIP;
    }

    public void setcZIP(int cZIP) {
        this.cZIP = cZIP;
    }

    public int getcCardNumber() {
        return cCardNumber;
    }

    public void setcCardNumber(int cCardNumber) {
        this.cCardNumber = cCardNumber;
    }

    public String getcCardFullName() {
        return cCardFullName;
    }

    public void setcCardFullName(String cCardFullName) {
        this.cCardFullName = cCardFullName;
    }

    public String getcCardType() {
        return cCardType;
    }

    public void setcCardType(String cCardType) {
        this.cCardType = cCardType;
    }

    public String getcCardExpiryDate() {
        return cCardExpiryDate;
    }

    public void setcCardExpiryDate(String cCardExpiryDate) {
        this.cCardExpiryDate = cCardExpiryDate;
    }

    public int getcCardCVV() {
        return cCardCVV;
    }

    public void setcCardCVV(int cCardCVV) {
        this.cCardCVV = cCardCVV;
    }

    public String getcStreet() {
        return cStreet;
    }

    public void setcStreet(String cStreet) {
        this.cStreet = cStreet;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public String getcSuburb() {
        return cSuburb;
    }

    public void setcSuburb(String cSuburb) {
        this.cSuburb = cSuburb;
    }

    public String getcRegDate() {
        return cRegDate;
    }

    public void setcRegDate(String cRegDate) {
        this.cRegDate = cRegDate;
    }

    public int getcID() {
        return cID;
    }

    public int getOrdID() {
        return ordID;
    }

    public int getOrdDetID() {
        return ordDetID;
    }

    public int getLpID() {
        return lpID;
    }

    public int getStoreID() {
        return storeID;
    }

}
