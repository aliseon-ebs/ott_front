package com.aliseon.ott.API;

import android.app.Application;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Auth {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("list")
    @Expose
    private java.util.List<List> list;

    public class List {
        @SerializedName("access_token")
        @Expose
        private String accessToken;

        public String getAccessToken() {
            return accessToken;
        }
    }
    public java.util.List<List> getList() {
        return list;
    }
    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public Boolean getStatus() {
        return status;
    }

}
