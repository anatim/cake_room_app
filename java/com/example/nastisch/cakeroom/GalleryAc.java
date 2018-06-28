package com.example.nastisch.cakeroom;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.nastisch.cakeroom.Model.Product;

import java.util.List;

public class GalleryAc extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private List<Product> mProductList;
    private ListView listViewCatalog;

    private SearchView svProducts;
    private ProductAdapter productAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        svProducts=(SearchView) findViewById(R.id.searchProductsView);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_gallery);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        // Obtain a reference to the product catalog
        mProductList = ShoppingCartHelper.getCatalog(getResources());

        // Create the list

        productAdapter = new ProductAdapter(mProductList, getLayoutInflater(), false, false);
        listViewCatalog.setAdapter(productAdapter);

        listViewCatalog.setTextFilterEnabled(true);
        setupSearchView();

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(),ProductDetailsActivity.class);
                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });

        Button viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);
        viewShoppingCart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

    }

    private void setupSearchView()
    {
        svProducts.setIconifiedByDefault(false);
        svProducts.setOnQueryTextListener(this);
        svProducts.setSubmitButtonEnabled(true);
    }

    @Override
    public boolean onQueryTextChange(String newText)
    {

        if (TextUtils.isEmpty(newText)) {
            listViewCatalog.clearTextFilter();
        } else {
            listViewCatalog.setFilterText(newText);
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query)
    {
        return false;
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