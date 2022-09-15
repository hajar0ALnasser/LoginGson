package com.example.testfinal.retrofitutil;

import com.example.testfinal.models.APIResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface{
    @Headers("content-type: application/json")
    @FormUrlEncoded
    @POST("authenticate.py")

    abstract Call<APIResponse> performUserSignIn(  @Field("login") @Body String UserNam,  @Field("password") @Body String Password) ;
}
