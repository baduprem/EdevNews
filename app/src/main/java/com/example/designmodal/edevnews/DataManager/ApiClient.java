package com.example.designmodal.edevnews.DataManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by compware on 6/15/2018.
 */

public class ApiClient {
//192.168.1.106 room
    public static final String BASE_URL = "http://192.168.1.85/EdevNewsApp/";
    private static Retrofit retrofit = null;
//192.168.1.85 office
    public static Retrofit getRetrofit()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit;
    }

}