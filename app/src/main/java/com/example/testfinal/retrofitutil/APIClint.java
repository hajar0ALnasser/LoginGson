package com.example.testfinal.retrofitutil;

import androidx.annotation.NonNull;

import com.example.testfinal.R;
import com.example.testfinal.activity.MainActivity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIClint {

    private static final String Base_url ="https://pos-api.odoo.com/pos-api/";
    private static Retrofit retrofit = null;
MainActivity mainActivity= new MainActivity();
String a = mainActivity.getSessionid();

    public static Retrofit GETAPIClint(){

        if(retrofit==null)

        {
            OkHttpClient.Builder Okhttpbuilder= new OkHttpClient.Builder();
            Okhttpbuilder.addInterceptor(new Interceptor() {

                @Override
                public Response intercept( Chain chain) throws IOException {
                    Request request = chain.request();
                   Request.Builder newRequest = request.newBuilder()
                           .addHeader("content-type","application/json");


                    return chain.proceed(newRequest.build());

                }
            });
            retrofit=new Retrofit.Builder().baseUrl(Base_url+"sign-in/").client(Okhttpbuilder.build()).addConverterFactory(GsonConverterFactory.create()).build();
        }
return retrofit;
    }
   public static Retrofit secGETAPIClin(){

        if(retrofit==null)

        {

            OkHttpClient.Builder Okhttpbuilder= new OkHttpClient.Builder();
            Okhttpbuilder.addInterceptor(new Interceptor() {

                @Override
                public Response intercept( Chain chain) throws IOException {
                    MainActivity mainActivity= new MainActivity();
                    String a = mainActivity.getSessionid();
                    Request request = chain.request();
                    Request.Builder newRequest = request.newBuilder()
                            .addHeader("content-type","application/json").addHeader("X-Openerp-Session-Id",a);

                    return chain.proceed(newRequest.build());


                }
            });
            retrofit=new Retrofit.Builder().baseUrl(Base_url+"get-session-info/").client(Okhttpbuilder.build()).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
