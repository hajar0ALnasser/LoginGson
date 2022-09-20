package com.example.testfinal.retrofitutil;

import androidx.core.view.accessibility.AccessibilityEventCompat;

import com.example.testfinal.models.APIResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import com.example.testfinal.models.UserInfo;
public interface APIInterface{
   // @Headers({"content-type: application/json"})
    @POST("https://pos-api.odoo.com/pos-api/sign-in/")
    abstract Call<APIResponse> performUserSignIn (@Body UserInfo userInfo) ;





}

