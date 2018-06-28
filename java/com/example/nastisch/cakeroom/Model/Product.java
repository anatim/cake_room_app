package com.example.nastisch.cakeroom.Model;

import android.graphics.drawable.Drawable;

public class Product {

    public int pID;
    public Drawable pImage;
    public String pName;
    public String pDescription;
    public String pLoyalty;
    public String pCategory;
    public String pIngredients;
    public double pPricePerEach;
    public int pAvailQuantity;
    public String pReviews;
    public String shareViaSocNetworkName;
    public String shareViaEmailName;
    public int storeID;
    public boolean pStatus;
    public boolean pSelected;

    public Product(Drawable pImage, String pName, String pDescription, String pLoyalty, String pCategory, String pIngredients, double pPricePerEach,
                   int pAvailQuantity, String pReviews) {
        this.pImage = pImage;
        this.pName = pName;
        this.pDescription = pDescription;
        this.pLoyalty = pLoyalty;
        this.pCategory = pCategory;
        this.pIngredients = pIngredients;
        this.pPricePerEach = pPricePerEach;
        this.pAvailQuantity = pAvailQuantity;
        this.pReviews = pReviews;
    }

    public Drawable getpImage() { return pImage; }

    public void setpImage(Drawable pImage) { this.pImage = pImage; }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    public String getpIngredients() {
        return pIngredients;
    }

    public void setpIngredients(String pIngredients) {
        this.pIngredients = pIngredients;
    }

    public double getpPricePerEach() { return pPricePerEach; }

    public void setpPricePerEach(double pPricePerEach) { this.pPricePerEach = pPricePerEach; }

    public int getpAvailQuantity() {
        return pAvailQuantity;
    }

    public void setpAvailQuantity(int pAvailQuantity) {
        this.pAvailQuantity = pAvailQuantity;
    }

    public String getpReviews() {
        return pReviews;
    }

    public void setpReviews(String pReviews) {
        this.pReviews = pReviews;
    }

    public String getShareViaSocNetworkName() {
        return shareViaSocNetworkName;
    }

    public void setShareViaSocNetworkName(String shareViaSocNetworkName) {
        this.shareViaSocNetworkName = shareViaSocNetworkName;
    }

    public String getShareViaEmailName() {
        return shareViaEmailName;
    }

    public void setShareViaEmailName(String shareViaEmailName) {
        this.shareViaEmailName = shareViaEmailName;
    }

    public boolean ispStatus() {
        return pStatus;
    }


    public int getpID() {
        return pID;
    }

    public String getpLoyalty() { return pLoyalty; }

    public int getStoreID() {
        return storeID;
    }

}
