package com.example.retrofitex;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    public static final String BASE_URL="https://vyasprakruti.000webhostapp.com/30Nov/";
    public static Retrofit retrofit=null;

    public static Retrofit getapiclient()
    {
        if(retrofit==null)
        {
            retrofit= new Retrofit.Builder().
                    baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }


        return retrofit;
    }
}
