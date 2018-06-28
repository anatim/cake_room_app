package com.example.nastisch.cakeroom;

import android.content.res.Resources;

import com.example.nastisch.cakeroom.Model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Vector;

public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    //private static List<Product> cart;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();
            catalog.add(new Product(res.getDrawable(R.drawable.rasp_choc_cake_small, null),"RASPBERRY CHOCOLATE CAKE",
                    "description", "9","Cake", "ingredients", 18, 60, "5 out of 5"));

            catalog.add(new Product(res.getDrawable(R.drawable.lemon_cake_small, null),"LEMON CAKE",
                    "description", "7", "Cake", "ingredients", 15, 50, "4 out of 5"));

            catalog.add(new Product(res.getDrawable(R.drawable.choc_chip_cookie_small, null),"CHOCOLATE CHIP COOKIE",
                    "description", "1","Cookie", "ingredients", 2, 100, "5 out of 5"));

            catalog.add(new Product(res.getDrawable(R.drawable.peanut_butter_cookie_small, null),"PEANUT BUTTER COOKIE",
                    "description", "1","Cookie", "ingredients", 2.5, 90, "3 out of 5"));

            catalog.add(new Product(res.getDrawable(R.drawable.straw_cupcake_small, null),"STRAWBERRY CUPCAKE",
                    "description", "2","Cupcake", "ingredients", 3.5, 120, "3.5 out of 5"));

            catalog.add(new Product(res.getDrawable(R.drawable.choc_cupcake_small, null),"CHOCOLATE CUPCAKE",
                    "description", "2", "Cupcake", "ingredients", 4, 150, "4.5 out of 5"));

            catalog.add(new Product(res.getDrawable(R.drawable.mint_macaron_small, null),"MINT MACARON",
                    "description", "1", "Macaron", "ingredients", 2, 100, "5 out of 5"));

            catalog.add(new Product(res.getDrawable(R.drawable.salt_caramel_macaron_small, null),"SALT CARAMEL MACARON",
                    "description", "1", "Macaron", "ingredients", 2.5, 110, "4.5 out of 5"));

        }

        return catalog;
    }

    public static void setQuantity(Product product, int quantity) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        // If the quantity is zero or less, remove the products
        if(quantity <= 0) {
            if(curEntry != null) removeProduct(product);
            return; }

        // If a current cart entry doesn't exist, create one
        if(curEntry == null) {
            curEntry = new ShoppingCartEntry(product, quantity);
            cartMap.put(product, curEntry);
            return; }

        // Update the quantity
        curEntry.setQuantity(quantity); }

    public static int getProductQuantity(Product product) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);
        if(curEntry != null) return curEntry.getQuantity();
        return 0; }


    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }


    public static List<Product> getCartList() {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p : cartMap.keySet()) {
            cartList.add(p);
        } return cartList; }

}

