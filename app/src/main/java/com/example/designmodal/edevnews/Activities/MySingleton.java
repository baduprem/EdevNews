package com.example.designmodal.edevnews.Activities;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.lang.ref.ReferenceQueue;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MySingleton {
    private static  MySingleton mInstance;
    private static Context mctx;
    private RequestQueue requestQueue;

    private  MySingleton (Context context){
        mctx = context;
        requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue = Volley.newRequestQueue(mctx.getApplicationContext());

        }
        return requestQueue;
    }
    public static  synchronized MySingleton getmInstance(Context context){
        if(mInstance==null) {
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }
    public <T>  void  addToRequestQueue(com.android.volley.Request<T>request){
     getRequestQueue().add(request);
    }


}
