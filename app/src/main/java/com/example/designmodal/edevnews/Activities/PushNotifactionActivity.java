package com.example.designmodal.edevnews.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.designmodal.edevnews.R;

import java.util.HashMap;
import java.util.Map;

public class PushNotifactionActivity extends AppCompatActivity {

    Button button;
    String app_server_url= "http://192.168.1.83/fcmtest/fcm_insert.php";
    //String app_server_url= "http://192.168.10.61/fcmtest/fcm_insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notifaction);
        button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
                final String token= sharedPreferences.getString(getString(R.string.FCM_TOKEN),"");
               // Toast.makeText(PushNotifactionActivity.this, "token:"+token, Toast.LENGTH_SHORT).show();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, app_server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params= new HashMap<String, String>();
                        params.put("fcm_token", token);

                        return params;
                    }
                };
                MySingleton.getmInstance(PushNotifactionActivity.this).addToRequestQueue(stringRequest);
            }
        });

    }
}
