package com.example.nastisch.cakeroom;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nastisch.cakeroom.Model.Product;

import java.util.List;

public class CheckoutAc extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_ac);



        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button mShowOrderDialog = (Button) findViewById(R.id.btnPlaceOrder);
        mShowOrderDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CheckoutAc.this);
                View mViewOrderIsBeingProcessed = getLayoutInflater().inflate(R.layout.order_processing_dialog, null);

                mBuilder.setView(mViewOrderIsBeingProcessed);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                dialog.getWindow().setLayout(1000, 1500);


            }
                    });
    }

    public void onChange (View view) {
        final TextView textView2 = (TextView) findViewById(R.id.txtVwSelectedShopCheckout);
        if (view.getId() == R.id.rdShop1) {
            textView2.setTextColor(Color.parseColor("#400f8e")); }
        if (view.getId() == R.id.rdShop2) {
            textView2.setTextColor(Color.parseColor("#178c61")); }
        if (view.getId() == R.id.rdShop3) {
            textView2.setTextColor(Color.parseColor("#8c1717")); }
        if (view.getId() == R.id.rdShop4) {
            textView2.setTextColor(Color.parseColor("#066d6b")); }
        if (view.getId() == R.id.rdShop5) {
            textView2.setTextColor(Color.parseColor("#4d0084")); }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), ShoppingCartActivity.class);
        startActivityForResult(myIntent, 0);

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
