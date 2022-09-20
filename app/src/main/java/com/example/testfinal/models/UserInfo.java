package com.example.testfinal.models;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;

public class UserInfo {
    @SerializedName("login")
    String login;
    @SerializedName("password")
    String password;
    public UserInfo(@Field("login") String username,@Field("password") String Password){
        login=username;
        password =Password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
