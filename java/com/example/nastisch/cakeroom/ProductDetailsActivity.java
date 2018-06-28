package com.example.nastisch.cakeroom;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nastisch.cakeroom.Model.Product;

import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_product_details);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        List<Product> catalog = ShoppingCartHelper.getCatalog(getResources());
        // final List<Product> cart = ShoppingCartHelper.getCart();

        //extract the extra information out of the Intent
        int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX);
        final Product selectedProduct = catalog.get(productIndex);

        // Set the proper image and text
        ImageView productImageView = (ImageView) findViewById(R.id.imgVwProductImage);
        productImageView.setImageDrawable(selectedProduct.pImage);

        TextView productTitleTextView = (TextView) findViewById(R.id.txtVwProductName);
        productTitleTextView.setText(selectedProduct.pName);

        TextView productPriceTextView = (TextView) findViewById(R.id.txtVwProductPrice);
        productPriceTextView.setText("Price: " + String.valueOf(selectedProduct.pPricePerEach) + " NZD");

        TextView productRatingTextView = (TextView) findViewById(R.id.txtVwProductReviews);
        productRatingTextView.setText("Reviews: " + selectedProduct.pReviews);

        TextView productLoyaltyTextView = (TextView) findViewById(R.id.txtVwProductLoyaltyPoints);
        productLoyaltyTextView.setText("Loyalty points: " + selectedProduct.pLoyalty);

        TextView productDescriptionTextView = (TextView) findViewById(R.id.txtVwProductDescription);
        productDescriptionTextView.setText(selectedProduct.pDescription);

        TextView productIngredientsTextView = (TextView) findViewById(R.id.txtVwProductIngredients);
        productIngredientsTextView.setText(selectedProduct.pIngredients);


        // Update the current quantity in the cart
        TextView textViewCurrentQuantity = (TextView) findViewById(R.id.txtVwChooseQuantity);
        textViewCurrentQuantity.setText("Choose quantity: "
                //+ ShoppingCartHelper.getProductQuantity(selectedProduct)
        );


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // Save a reference to the quantity edit text
        final EditText editTextChooseQuantity = (EditText) findViewById(R.id.editTxtChooseQuantity);

        Button btnAddToCart = (Button) findViewById(R.id.btnAddToCart);
        btnAddToCart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // Check to see that a valid quantity was entered
                int quantity = 0;
                try {
                    quantity = Integer.parseInt(editTextChooseQuantity.getText().toString());

                    if (quantity < 0) {
                        Toast.makeText(getBaseContext(), "Please enter a quantity of 0 or higher", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Please enter a numeric quantity", Toast.LENGTH_SHORT).show();
                    return;
                }

                // If we make it here, a valid quantity was entered
                ShoppingCartHelper.setQuantity(selectedProduct, quantity);

                // Close the activity
                finish();
            }
        });


//    Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
//        addToCartButton.setOnClickListener(new
//
//    OnClickListener() {
//
//        @Override
//        public void onClick (View v){
//
//            cart.add(selectedProduct);
//            finish();
//        }
//});


        // // Disable the add to cart button if the item is already in the cart
//        if(cart.contains(selectedProduct)) {
//            addToCartButton.setEnabled(false);
//            addToCartButton.setText("Item is in the Cart");
//        }
    }

    public void onChange (View view) {
        final TextView textView1 = (TextView) findViewById(R.id.txtVwSelectedShop);
        if (view.getId() == R.id.rdShop1) {
            textView1.setTextColor(Color.parseColor("#400f8e")); }
        if (view.getId() == R.id.rdShop2) {
            textView1.setTextColor(Color.parseColor("#178c61")); }
        if (view.getId() == R.id.rdShop3) {
            textView1.setTextColor(Color.parseColor("#8c1717")); }
        if (view.getId() == R.id.rdShop4) {
            textView1.setTextColor(Color.parseColor("#066d6b")); }
        if (view.getId() == R.id.rdShop5) {
            textView1.setTextColor(Color.parseColor("#4d0084")); }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }


        switch (item.getItemId()) {


            case R.id.m_share:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "This is Cake Room application");
                startActivity(Intent.createChooser(shareIntent, "Share via:"));

            case R.id.shCart:
                Intent cartIntent = new Intent(getApplicationContext(), ShoppingCartActivity.class);
                startActivity(cartIntent);
                setContentView(R.layout.activity_shopping_cart);
        }
        return super.onOptionsItemSelected(item);
    }

}