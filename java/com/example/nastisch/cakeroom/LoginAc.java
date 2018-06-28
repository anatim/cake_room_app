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

public class LoginAc extends AppCompatActivity {

    EditText email, password;
    Button button_login;

    public static String TAG = LoginAc.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_dialog);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        email = (EditText) findViewById(R.id.editEmail);
        password = (EditText) findViewById(R.id.editPassword);
        button_login = (Button) findViewById(R.id.btnLoginDialog);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                String hashpass = null;
                try {
                    hashpass = hashPassword(pass);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }

                userLogin(mail, hashpass);
            }
        });

    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update(password.getBytes(), 0, password.length());
        return new BigInteger(1, messageDigest.digest()).toString(16);

    }

    private void userLogin(final String email, final String password) {
        StringRequest stringRequest = new StringRequest
                (Request.Method.POST, Configure.LOGIN_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        try {
                            Log.d(TAG,response.toString());
                            JSONObject jsonObject = new JSONObject(response);
                            boolean error = jsonObject.getBoolean("error");
                            if (!error) {
                                JSONObject user = jsonObject.getJSONObject("users");
                                //getting items
                                String email = user.getString("email");
                                String password = user.getString("password");
                                toast("You are logged in");
                                startActivity(new Intent(LoginAc.this, UserAccountAc.class));
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
                params.put("email", email);
                params.put("password", password);

                return params;
            }
        };

        String mytag = "req_login";
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

            case R.id.shCart:
                Intent cartIntent = new Intent(getApplicationContext(), ShoppingCartActivity.class);
                startActivity(cartIntent);
                setContentView(R.layout.activity_shopping_cart);
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToLoginAsStaff(View view) {
        Intent intent4 = new Intent(getApplicationContext(), LoginAsStaffAc.class);
        startActivity(intent4);
        setContentView(R.layout.login_as_staff);
    }

}
