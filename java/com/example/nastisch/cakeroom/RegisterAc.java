package com.example.nastisch.cakeroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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

public class RegisterAc extends AppCompatActivity {

    EditText username, email, password;
    Button button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_dialog);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        username = (EditText) findViewById(R.id.editUserName);
        email = (EditText) findViewById(R.id.editEmail);
        password = (EditText) findViewById(R.id.editPassword);
        button_register = (Button) findViewById(R.id.btnRegisterDialog);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = username.getText().toString().trim();
                String mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String hashpass = null;
                try {
                    hashpass = hashPassword(pass);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                userRegister(uName, mail, hashpass);
            }
        });
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update(password.getBytes(), 0, password.length());
        return new BigInteger(1, messageDigest.digest()).toString(16);

    }




    private void userRegister(final String username, final String email, final String password) {
        StringRequest stringRequest = new StringRequest
                (Request.Method.POST, Configure.REGISTER_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean error = jsonObject.getBoolean("error");
                            if (!error) {
                                JSONObject user = jsonObject.getJSONObject("users");
                                //getting items
                                String uName = user.getString("name");
                                String password = user.getString("password");
                                toast("You are successfully registered");
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
                params.put("name", username);
                params.put("email", email);
                params.put("password", password);

                return params;
            }
        };

        String mytag = "req_register";
        //adding request to the request queue - AndroidLoginController
        AndroidLoginController.getmInstance().addToRequestQueue(stringRequest, mytag);
    }

    private void toast (String x) {
        Toast.makeText(this, x, Toast.LENGTH_LONG).show();
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
                shareIntent.putExtra(Intent.EXTRA_TEXT, "This is Cake Room application");
                startActivity(Intent.createChooser(shareIntent, "Share via:"));
        }
        return super.onOptionsItemSelected(item);
    }
}
