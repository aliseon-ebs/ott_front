package com.aliseon.ott.API;

import android.app.Application;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserPhone extends Application {

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("list")
    @Expose
    public ArrayList<List> userphone_list = null;

    public class List {

        @SerializedName("id") Integer id;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }

    }

    public ArrayList<List> getUserphone_list() { return userphone_list; }
    public void setUserphone_list(ArrayList<List> userphone_list) { this.userphone_list = userphone_list; }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

}
