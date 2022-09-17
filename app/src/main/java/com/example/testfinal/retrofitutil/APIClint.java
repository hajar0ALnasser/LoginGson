package com.example.testfinal.retrofitutil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClint {
    private static final String Base_url ="https://pos-api.odoo.com/pos-api/sign-in/";
    private static Retrofit retrofit = null;
    public static Retrofit GETAPIClint(){
        if(retrofit==null)
        {retrofit=new Retrofit.Builder().baseUrl(Base_url).addConverterFactory(GsonConverterFactory.create()).build();
        }
return retrofit;
    }
}
