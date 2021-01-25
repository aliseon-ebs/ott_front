package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Categories {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("list")
    @Expose
    public ArrayList<List> categories_list = new ArrayList<>();

    public class List {

        @SerializedName("id") int id;
        @SerializedName("dept1") String dept1;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDept1() {
            return dept1;
        }

        public void setDept1(String dept1) {
            this.dept1 = dept1;
        }

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
