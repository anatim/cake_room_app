package com.example.nastisch.cakeroom;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class StartScreenAc extends AppCompatActivity
   {

       private int mYear,mMonth,mDay;
       private static final String TAG = "StartScreenAc";
       private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);




//        Button mShowLoginDialog = (Button) findViewById(R.id.btnLoginDialog); //button in AppSetting
//        mShowLoginDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder mBuilder = new AlertDialog.Builder(StartScreenAc.this);
//                View mViewLogin = getLayoutInflater().inflate(R.layout.login_dialog, null);
//                final EditText mEmail = (EditText) mViewLogin.findViewById(R.id.editUserName);
//                final EditText mPassword = (EditText) mViewLogin.findViewById(R.id.editPassword);
//                Button mLogin = (Button) mViewLogin.findViewById(R.id.btnLoginDialog); //login button inside login_dialog.xml
//
//                mBuilder.setView(mViewLogin);
//                final AlertDialog dialog = mBuilder.create();
//                dialog.show();
//                dialog.getWindow().setLayout(1000, 860);
//                mLogin.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View view) {
//                        if(!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()){
//                            if(mEmail.getText().toString().equals("admin") && mPassword.getText().toString().equals("123")){
//                                Toast.makeText(StartScreenAc.this,"Login Success",
//                                        Toast.LENGTH_SHORT).show();
//                                dialog.dismiss();
//                            }
//                            else{
//                                Toast.makeText(StartScreenAc.this,"Login failed",
//                                        Toast.LENGTH_SHORT).show();
//                            }  }
//                        else{
//                            Toast.makeText(StartScreenAc.this,
//                                    "Empty request",
//                                    Toast.LENGTH_SHORT).show();
//                            if(!mEmail.getText().toString().isEmpty() || !mPassword.getText().toString().isEmpty())
//                                Toast.makeText(StartScreenAc.this,"Email or Password is empty. Please try again",
//                                        Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                });
//                       }
//
//        });



//        Button mShowRegisterDialog = (Button) findViewById(R.id.btnRegister); //button in AppSetting
//        mShowRegisterDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder mBuilder = new AlertDialog.Builder(StartScreenAc.this);
//                View mViewRegister = getLayoutInflater().inflate(R.layout.register_dialog, null);
//
//                final EditText mEmail = (EditText) mViewRegister.findViewById(R.id.editUserName);
//                final EditText mFName = (EditText) mViewRegister.findViewById(R.id.editFName);
//                final EditText mLName = (EditText) mViewRegister.findViewById(R.id.editLName);
//                final EditText mPassword = (EditText) mViewRegister.findViewById(R.id.editPassword);
//                Button mRegister = (Button) mViewRegister.findViewById(R.id.btnRegisterDialog); //login button inside login_dialog.xml
//
//                mBuilder.setView(mViewRegister);
//                final AlertDialog dialog = mBuilder.create();
//                dialog.getWindow().setLayout(350, 1000);
//                dialog.show();
//                mRegister.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View view) {
//                        if(!mEmail.getText().toString().isEmpty() && !mFName.getText().toString().isEmpty() && !mLName.getText().toString().isEmpty()
//                                && !mPassword.getText().toString().isEmpty()){
//                            if(mEmail.getText().toString().equals("admin") && mFName.getText().toString().equals("Ana") && mLName.getText().toString().equals("Timofeeva")
//                                    && mPassword.getText().toString().equals("123")){
//                                Toast.makeText(StartScreenAc.this,"This user is already registered. Please try again",
//                                        Toast.LENGTH_SHORT).show();
//                                dialog.dismiss();
//                            }
//                            else{
//                                Toast.makeText(StartScreenAc.this,"You are successfully registered",
//                                        Toast.LENGTH_SHORT).show();
//                            }  }
//                        else{
//                            Toast.makeText(StartScreenAc.this,
//                                    "Some fields are empty. Please try again",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//                final TextView dateOfBirth = (TextView) mViewRegister.findViewById(R.id.editDOB);
//                final Calendar myCalendar = Calendar.getInstance();
//                final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener()
//                {
//                   @Override
//                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        // TODO Auto-generated method stub
//                        mYear = year;
//                        mMonth = monthOfYear;
//                        mDay = dayOfMonth;
//
//                        // myCalendar.add(Calendar.DATE, 0);
//                        String myFormat = "dd-MM-yyyy"; //In which you need put here
//                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
//                        dateOfBirth.setText(sdf.format(myCalendar.getTime()));
//                    }
//                };
//
//                dateOfBirth.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        Calendar c = Calendar.getInstance(TimeZone.getDefault());
//                       // final DatePicker dp =  (DatePicker) findViewById(R.id.);.
//                        mYear = c.get(Calendar.YEAR);
//                        mMonth = c.get(Calendar.MONTH);
//                        mDay = c.get(Calendar.DAY_OF_MONTH);
//
//
//                        // Launch Date Picker Dialog
//                        DatePickerDialog dpd = new DatePickerDialog(StartScreenAc.this, new DatePickerDialog.OnDateSetListener() {
//
//
//                            @Override
//                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                                // Display Selected date in textbox
//                                if (year < mYear) view.updateDate(mYear, mMonth, mDay);
//
//                                if (monthOfYear < mMonth && year == mYear) view.updateDate(mYear, mMonth, mDay);
//
//                                if (dayOfMonth < mDay && year == mYear && monthOfYear == mMonth) view.updateDate(mYear,mMonth,mDay);
//
//                                dateOfBirth.setText("Date of birth: "+ dayOfMonth + "/" + (monthOfYear + 1) + "/" + year); }}, mYear, mMonth, mDay);
//                        c.add(c.YEAR, -100); // subtract 100 years from now
//                       dpd.getDatePicker().setMinDate(c.getTimeInMillis());
//                        dpd.getDatePicker().setMaxDate(System.currentTimeMillis());
//                        dpd.show();
//
//                    }
//
//                });
//            }
//        });

    }
       public boolean isServicesOK(){
           Log.d(TAG, "isServicesOK: checking google services version");

           int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(StartScreenAc.this);

           if(available == ConnectionResult.SUCCESS){
               //everything is fine and the user can make map requests
               Log.d(TAG, "isServicesOK: Google Play Services is working");
               return true;
           }
           else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
               //an error occurred but we can resolve it
               Log.d(TAG, "isServicesOK: an error occurred but we can fix it");
               Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(StartScreenAc.this, available, ERROR_DIALOG_REQUEST);
               dialog.show();
           }else{
               Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
           }
           return false;
       }

       public void goToRegister(View view) {
           Intent intent7 = new Intent(getApplicationContext(),RegisterAc.class);
           startActivity(intent7);
           setContentView(R.layout.register_dialog);
       }

       public void goToLogin(View view) {
           Intent intent7 = new Intent(getApplicationContext(),LoginAc.class);
           startActivity(intent7);
           setContentView(R.layout.login_dialog);
       }



       @Override
       public boolean onCreateOptionsMenu(Menu menu) {

           getMenuInflater().inflate(R.menu.main_menu, menu);
           return super.onCreateOptionsMenu(menu);
       }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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


       public void goToGallery(View view) {
           Intent intent3 = new Intent(getApplicationContext(), GalleryAc.class);
           startActivity(intent3);
           setContentView(R.layout.activity_gallery);
       }

       public void goToAboutUs(View view) {
           Intent intent4 = new Intent(getApplicationContext(), AboutUsAc.class);
           startActivity(intent4);
           setContentView(R.layout.activity_about_us);
       }

       public void goToContactUs(View view) {
           Intent intent5 = new Intent(getApplicationContext(),ContactUsAc.class);
           startActivity(intent5);
           setContentView(R.layout.activity_contact_us);
       }

       public void goToOurStores(View view) {
           Intent intent6 = new Intent(getApplicationContext(),OurStoresAc.class);
           startActivity(intent6);
           setContentView(R.layout.activity_our_stores);
       }

       public void goToLoyalty(View view) {
           Intent intent8 = new Intent(getApplicationContext(),LoyaltyAc.class);
           startActivity(intent8);
           setContentView(R.layout.activity_loyalty);
       }







    }




