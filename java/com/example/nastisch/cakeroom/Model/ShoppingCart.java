package com.example.nastisch.cakeroom.Model;

public class ShoppingCart {

    private int shCartID;
    private int shCItemQuantity;
    private int ordDetID;
    private int payID;
    private boolean shCItemOnHold;

    public ShoppingCart(int shCartID, int shCItemQuantity, int ordDetID, boolean shCItemOnHold) {
        this.shCartID = shCartID;
        this.shCItemQuantity = shCItemQuantity;
        this.ordDetID = ordDetID;
        this.shCItemOnHold = shCItemOnHold;
    }

    public int getShCItemQuantity() {
        return shCItemQuantity;
    }

    public void setShCItemQuantity(int shCItemQuantity) {
        this.shCItemQuantity = shCItemQuantity;
    }

    public boolean isShCItemOnHold() {
        return shCItemOnHold;
    }

    public void setShCItemOnHold(boolean shCItemOnHold) {
        this.shCItemOnHold = shCItemOnHold;
    }

    public int getShCartID() {
        return shCartID;
    }

    public int getOrdDetID() {
        return ordDetID;
    }

    public int getPayID() {
        return payID;
    }
}
