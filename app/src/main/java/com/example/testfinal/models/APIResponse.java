package com.example.testfinal.models;
import com.google.gson.annotations.SerializedName;
public class APIResponse {
   @SerializedName("is_system")
    boolean is_system;
    @SerializedName("uid")
    int uid;
    @SerializedName("is_admin")
    boolean is_admin;

    public boolean isIs_system() {
        return is_system;
    }

    public int getUid() {
        return uid;
    }

    public boolean isIs_admin() {
        return is_admin;
    }
}
