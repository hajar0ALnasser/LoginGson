package com.example.testfinal.models;

import com.google.gson.annotations.SerializedName;

public class APIResponseSec {
    @SerializedName("success")
    boolean Success ;
    @SerializedName("is_system")
    boolean is_system;
    @SerializedName("uid")
    int uid;
    @SerializedName("is_admin")
    boolean is_admin;
    @SerializedName("session_id")
    String session_id;

    public boolean isIs_system() {
        return is_system;
    }

    public int getUid() {
        return uid;
    }

    public boolean isIs_admin() {
        return is_admin;
    }


    public String getSession_id(){ return session_id;}

    public boolean isSuccess() {
        return Success;
    }
}



