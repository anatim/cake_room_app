package com.example.nastisch.cakeroom;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.Address;
import android.location.Geocoder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class OurStoresAc extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this, "Map is ready", Toast.LENGTH_SHORT).show();
        mMap = googleMap;

        if (mLocationPermissionGranted) {
            getDeviceLocation();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                    (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return; }
           // mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
           // mMap.getUiSettings().setMapToolbarEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);
//            mMap.getUiSettings().setScrollGesturesEnabled(true);
//            mMap.getUiSettings().setRotateGesturesEnabled(true);
        }

        // Add a marker in different regions of Auckland and move the camera
        LatLng aklHenderson = new LatLng(-36.873928, 174.627731);
        mMap.addMarker(new MarkerOptions().position(aklHenderson).title("Cake Room Henderson"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aklHenderson));

        LatLng aklParnell = new LatLng(-36.854065, 174.779877);
        mMap.addMarker(new MarkerOptions().position(aklParnell).title("Cake Room Parnell"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aklParnell));

        LatLng aklRosedale = new LatLng(-36.746212, 174.737122);
        mMap.addMarker(new MarkerOptions().position(aklRosedale).title("Cake Room Rosedale"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aklRosedale));

        LatLng aklCBD = new LatLng(-36.8471567, 174.7649395);
        mMap.addMarker(new MarkerOptions().position(aklCBD).title("Cake Room CBD"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aklCBD));

        LatLng aklPonsonby = new LatLng(-36.852356, 174.738689);
        mMap.addMarker(new MarkerOptions().position(aklPonsonby).title("Cake Room Ponsonby"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aklPonsonby));
    }


    private static final String TAG = "OurStoresAc";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final float DEFAULT_ZOOM = 15f;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;

    //variables
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_stores);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getLocationPermission();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), StartScreenAc.class);
        startActivityForResult(myIntent, 0);

        switch (item.getItemId()) {
            case R.id.m_share:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "This is my application");
                startActivity(Intent.createChooser(shareIntent, "Share via:"));

            case R.id.shCart:
                Intent cartIntent = new Intent(getApplicationContext(), ShoppingCartActivity.class);
                startActivity(cartIntent);
                setContentView(R.layout.activity_shopping_cart);
        }
        return super.onOptionsItemSelected(item);
    }



    private void initMap(){
        Log.d(TAG, "initMap: initializing map");
       SupportMapFragment mapFragment = (SupportMapFragment)
               getSupportFragmentManager().findFragmentById(R.id.map);
       mapFragment.getMapAsync(OurStoresAc.this);
    }


    private void getLocationPermission() {
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {FINE_LOCATION, COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionGranted = true;
            initMap();}
                else { ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE); }
        }
        else { ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE); }
    }

    private void getDeviceLocation() {
        Log.d(TAG, "getDeviceLocation: getting the device's current location");
mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

try{
if(mLocationPermissionGranted){
    final Task location = mFusedLocationProviderClient.getLastLocation();
    location.addOnCompleteListener(new OnCompleteListener() {
        @Override
        public void onComplete(@NonNull Task task) {
if(task.isSuccessful() && task.getResult() != null){
Log.d(TAG, "onComplete: found location!");
Location currentLocation = (Location) task.getResult();
moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), DEFAULT_ZOOM);
} else{
    Log.d(TAG, "onComplete: current location is null");
    Toast.makeText(OurStoresAc.this, "Unable to get current location", Toast.LENGTH_SHORT).show();
}
        }
    });
}
    }
    catch (SecurityException e){
Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage());
        }
    }

    private void moveCamera(LatLng latLng, float zoom) {
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        mLocationPermissionGranted = false;

        switch (requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                // If request is cancelled, the result arrays are empty.
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
mLocationPermissionGranted = false;
Log.d(TAG, "onRequestPermissionsResult: permission failed");
return;
                        }
                    }
Log.d(TAG, "onRequestPermissionsResult: permission granted");
mLocationPermissionGranted = true;
//initialise the map
                    initMap();

                }
            }
        }
    }


}
