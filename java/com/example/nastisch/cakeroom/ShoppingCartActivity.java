package com.example.nastisch.cakeroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nastisch.cakeroom.Model.Product;

import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {

    private List<Product> mCartList;
    private ProductAdapter mProductAdapter;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_shopping_cart);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mCartList = ShoppingCartHelper.getCartList();

        // Make sure to clear the selections
        for(int i = 0; i < mCartList.size(); i++) {
            mCartList.get(i).pSelected = false;
        }

        // Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true,true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Product selectedProduct = mCartList.get(position);
                if(selectedProduct.pSelected == true)
                    selectedProduct.pSelected = false;
                else
                    selectedProduct.pSelected = true;

                mProductAdapter.notifyDataSetInvalidated();

//            }
//        });
//                Intent productDetailsIntent = new Intent(getBaseContext(),ProductDetailsActivity.class);
//                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
//                startActivity(productDetailsIntent);
            }
        });



        Button removeButton = (Button) findViewById(R.id.btnRemoveFromCart);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Loop through and remove all the products that are selected
                // Loop backwards so that the remove works correctly
                for(int i=mCartList.size()-1; i>=0; i--) {

                    if(mCartList.get(i).pSelected) {
                        mCartList.remove(i);
                    }
                }
                mProductAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refresh the data
        if(mProductAdapter != null) { mProductAdapter.notifyDataSetChanged(); }

        double subTotal = 0;
        int loyalty_points_total = 0;
        for(Product p : mCartList) {
            int quantity = ShoppingCartHelper.getProductQuantity(p);
            subTotal += p.pPricePerEach * quantity;
        }

        TextView productPriceTextView = (TextView) findViewById(R.id.txtVwSubtotal);
        productPriceTextView.setText("SUBTOTAL: " + subTotal + " NZD");
    }

    public void goToCheckout(View view) {
        Intent intentGoToCheckout = new Intent(getApplicationContext(),CheckoutAc.class);
        startActivity(intentGoToCheckout);
        setContentView(R.layout.checkout_ac); }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true; }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)) { return true; }

        switch (item.getItemId()) {

            case R.id.m_share:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "This is my application");
                startActivity(Intent.createChooser(shareIntent, "Share via:"));
        }
        return super.onOptionsItemSelected(item);
    }


}
