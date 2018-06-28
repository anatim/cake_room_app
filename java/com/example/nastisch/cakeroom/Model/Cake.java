package com.example.nastisch.cakeroom.Model;

import android.graphics.drawable.Drawable;

public class Cake extends Product {

    private String cakeType;
    private int noOfLayers;
    private double pricePerSlice;
    private String typeOfFrosting;

    public Cake(Drawable pImage, String pName, String pDescription, String pLoyalty, String pCategory, String pIngredients, double pPricePerEach, int pAvailQuantity,
                String pReviews, String cakeType, int noOfLayers, double pricePerSlice, String typeOfFrosting) {
        super(pImage, pName, pDescription, pLoyalty, pCategory, pIngredients, pPricePerEach, pAvailQuantity, pReviews);
        this.cakeType = cakeType;
        this.noOfLayers = noOfLayers;
        this.pricePerSlice = pricePerSlice;
        this.typeOfFrosting = typeOfFrosting;
    }

    public String getCakeType() { return cakeType; }

    public void setCakeType(String cakeType) { this.cakeType = cakeType; }

    public int getNoOfLayers() {
        return noOfLayers;
    }

    public void setNoOfLayers(int noOfLayers) {
        this.noOfLayers = noOfLayers;
    }

    public double getPricePerSlice() {
        return pricePerSlice;
    }

    public void setPricePerSlice(double pricePerSlice) {
        this.pricePerSlice = pricePerSlice;
    }

    public String getTypeOfFrosting() {
        return typeOfFrosting;
    }

    public void setTypeOfFrosting(String typeOfFrosting) {
        this.typeOfFrosting = typeOfFrosting;
    }
}
