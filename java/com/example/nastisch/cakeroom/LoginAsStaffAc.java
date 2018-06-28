package com.example.nastisch.cakeroom;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LoginAsStaffAc extends AppCompatActivity
{
    EditText staff_id, staff_password;
    Button button_login_staff;

    public static String TAG = LoginAsStaffAc.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_as_staff);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        staff_id = (EditText) findViewById(R.id.editEmployeeIDLoginAsStaff);
        staff_password = (EditText) findViewById(R.id.editPasswordLoginAsStaff);
        button_login_staff = (Button) findViewById(R.id.btnShowLoginAsStaffDialog);

        button_login_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st_id = staff_id.getText().toString().trim();
                String st_pass = staff_password.getText().toString().trim();

                String hashpass = null;
                try {
                    hashpass = hashPassword(st_pass);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }

                staffLogin(st_id, hashpass);
            }
        });
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update(password.getBytes(), 0, password.length());
        return new BigInteger(1, messageDigest.digest()).toString(16);

    }

    private void staffLogin(final String staff_id, final String staff_password) {
        StringRequest stringRequest = new StringRequest
                (Request.Method.POST, Configure.LOGIN_STAFF_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        try {
                            Log.d(TAG,response.toString());
                            JSONObject jsonObject = new JSONObject(response);
                            boolean error = jsonObject.getBoolean("error");
                            if (!error) {
                                JSONObject staff = jsonObject.getJSONObject("staff");
                                //getting items
                                String staff_id = staff.getString("staff_id");
                                String staff_password = staff.getString("staff_password");
                                toast("You are logged in as staff");
                                startActivity(new Intent(LoginAsStaffAc.this, StaffAccountAc.class));
                            }
                            else {
//Error with PHP
                                String errorMsg = jsonObject.getString("error_msg");
                                toast(errorMsg);
                            }
                        }
//Error with Json
                        catch (JSONException e) {

                            e.printStackTrace();
                            toast("Json error" + e.getMessage());
                        }
                    }
                },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                toast("Unknown error occurred");
                            }
                        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("staff_id", staff_id);
                params.put("staff_password", staff_password);

                return params;
            }
        };

        String mytagstaff = "req_login_as_staff";
        //adding request to the request queue - AndroidLoginController
        AndroidLoginController.getmInstanceStaff().addToRequestQueueStaff(stringRequest, mytagstaff);
    }


    private void toast (String y) {
        Toast.makeText(this, y, Toast.LENGTH_LONG).show();
    }



    public void goToStaffAccount(View view) {
        Intent intent6 = new Intent(getApplicationContext(), StaffAccountAc.class);
        startActivity(intent6);
        setContentView(R.layout.staff_account);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), LoginAc.class);
        startActivityForResult(myIntent, 0);

        switch (item.getItemId()) {
            case R.id.m_share:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "This is Cake Room application");
                startActivity(Intent.createChooser(shareIntent, "Share via:"));
        }
        return super.onOptionsItemSelected(item);
    }


}
