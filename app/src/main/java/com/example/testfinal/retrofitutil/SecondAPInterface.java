package com.example.testfinal.retrofitutil;

import com.example.testfinal.models.APIResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import com.example.testfinal.models.APIResponse;
import com.example.testfinal.models.APIResponseSec;
import com.example.testfinal.models.EmptyBody;
import com.example.testfinal.models.UserInfo;


public interface SecondAPInterface {
 // @Headers("X-Openerp-Session-Id: 77984a557d574676d8b511f74933ef21d80494cc")
  // @Headers({})
@POST("https://pos-api.odoo.com/pos-api/get-session-info/")
abstract Call<APIResponseSec> getSission (@Body EmptyBody emptyBody) ;}


