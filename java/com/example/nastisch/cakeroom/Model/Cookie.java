package com.example.nastisch.cakeroom.Model;

import android.graphics.drawable.Drawable;

public class Cookie extends Product {

    private String cookieType;
    private double pricePerDozen;
    private String typeOfDough;

    public Cookie(Drawable pImage, String pName, String pDescription, String pLoyalty, String pCategory, String pIngredients, double pPricePerEach, int pAvailQuantity,
                  String pReviews, String cookieType, double pricePerDozen, String typeOfDough) {
        super(pImage, pName, pDescription, pLoyalty, pCategory, pIngredients, pPricePerEach, pAvailQuantity, pReviews);
        this.cookieType = cookieType;
        this.pricePerDozen = pricePerDozen;
        this.typeOfDough = typeOfDough;
    }

    public String getCookieType() { return cookieType; }

    public void setCookieType(String cookieType) { this.cookieType = cookieType; }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

    public void setPricePerDozen(double pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    public String getTypeOfDough() {
        return typeOfDough;
    }

    public void setTypeOfDough(String typeOfDough) {
        this.typeOfDough = typeOfDough;
    }
}
