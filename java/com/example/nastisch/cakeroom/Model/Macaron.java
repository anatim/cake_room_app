package com.example.nastisch.cakeroom.Model;

import android.graphics.drawable.Drawable;

public class Macaron extends Product {

    private String macaronType;
    private double pricePerDozen;
    private String typeOfFilling;

    public Macaron(Drawable pImage, String pName, String pDescription, String pLoyalty, String pCategory, String pIngredients, double pPricePerEach,
                   int pAvailQuantity, String pReviews, String macaronType, double pricePerDozen, String typeOfFilling) {
        super(pImage, pName, pDescription, pLoyalty, pCategory, pIngredients, pPricePerEach, pAvailQuantity, pReviews);
        this.macaronType = macaronType;
        this.pricePerDozen = pricePerDozen;
        this.typeOfFilling = typeOfFilling;
    }

    public String getMacaronType() { return macaronType; }

    public void setMacaronType(String macaronType) { this.macaronType = macaronType; }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

    public void setPricePerDozen(double pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    public String getTypeOfFilling() {
        return typeOfFilling;
    }

    public void setTypeOfFilling(String typeOfFilling) {
        this.typeOfFilling = typeOfFilling;
    }
}
