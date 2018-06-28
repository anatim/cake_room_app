package com.example.nastisch.cakeroom;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class DrawerAc extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), StartScreenAc.class);
        startActivityForResult(myIntent, 0);
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
                return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navVw);
        navigationView.setNavigationItemSelectedListener(this);}

//                (
//                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        // set item as selected to persist highlight
//                        item.setChecked(true);

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        int id=item.getItemId();
                        switch (id){
                            case R.id.drawer_account:
                                Intent userAccIntent= new Intent(DrawerAc.this, UserAccountAc.class);
                                startActivity(userAccIntent);
                                break;
                            case R.id.drawer_home:
                                Intent homeIntent= new Intent(DrawerAc.this,StartScreenAc.class);
                                startActivity(homeIntent);
                                break;
                            case R.id.drawer_gallery:
                                Intent galleryIntent= new Intent(DrawerAc.this,GalleryAc.class);
                                startActivity(galleryIntent);
                                break;
                            case R.id.drawer_stores:
                                Intent storesIntent= new Intent(DrawerAc.this,OurStoresAc.class);
                                startActivity(storesIntent);
                                break;
                            case R.id.drawer_loyalty:
                                Intent loyaltyIntent= new Intent(DrawerAc.this,LoyaltyAc.class);
                                startActivity(loyaltyIntent);
                            case R.id.drawer_contact:
                                Intent contactIntent = new Intent(DrawerAc.this,ContactUsAc.class);
                                startActivity(contactIntent);
                                break;
                            case R.id.drawer_about:
                                Intent aboutIntent= new Intent(DrawerAc.this,AboutUsAc.class);
                                startActivity(aboutIntent);
                                break;
//                            case R.id.drawer_settings:
//                                Intent settingsIntent= new Intent(DrawerAc.this,SettingsAc.class);
//                                startActivity(settingsIntent);
//                                break;
//                            case R.id.drawer_logout:
//                                Intent logoutIntent= new Intent(DrawerAc.this,Logout.class);
//                                startActivity(logoutIntent);
//                                break;
                        }
                        // close drawer when item is tapped
                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
                        drawer.closeDrawer(GravityCompat.START);

                        return true;
                    }

    }








