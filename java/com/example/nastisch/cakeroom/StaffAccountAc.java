package com.example.nastisch.cakeroom;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StaffAccountAc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_account);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void onChange (View view) {
        Button button1 = (Button) findViewById(R.id.btnFragProducts);
        Button button2 = (Button) findViewById(R.id.btnFragUsers);
        Button button3 = (Button) findViewById(R.id.btnFragContractors);
        Button button5 = (Button) findViewById(R.id.btnFragLoyalty);

        Fragment fragment;
        if(view==button1)
        {
            fragment = new FragManageProducts();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.Manager_fragment, fragment);
            fragmentTransaction.commit();
        }
        else if (view==button2)
        {
            fragment = new FragManageUsers();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.Manager_fragment, fragment);
            fragmentTransaction.commit();
        }
        else if (view==button3)
        {
            fragment = new FragManageContractors();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.Manager_fragment, fragment);
            fragmentTransaction.commit();
        }
        else if (view==button5)
        {
            fragment = new FragManageLoyalty();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.Manager_fragment, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
