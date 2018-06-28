package com.example.nastisch.cakeroom.Model;

import android.graphics.drawable.Drawable;

public class Cupcake extends Product {

    private String cupcakeType;
    private double pricePerDozen;
    private String typeOfFrosting;

    public Cupcake(Drawable pImage, String pName, String pDescription, String pLoyalty, String pCategory, String pIngredients, double pPricePerEach, int pAvailQuantity,
                   String pReviews, String cupcakeType, double pricePerDozen, String typeOfFrosting) {
        super(pImage, pName, pDescription, pLoyalty, pCategory, pIngredients, pPricePerEach, pAvailQuantity, pReviews);
        this.cupcakeType = cupcakeType;
        this.pricePerDozen = pricePerDozen;
        this.typeOfFrosting = typeOfFrosting;
    }

    public String getCupcakeType() { return cupcakeType; }

    public void setCupcakeType(String cupcakeType) { this.cupcakeType = cupcakeType; }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

    public void setPricePerDozen(double pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    public String getTypeOfFrosting() {
        return typeOfFrosting;
    }

    public void setTypeOfFrosting(String typeOfFrosting) {
        this.typeOfFrosting = typeOfFrosting;
    }
}
