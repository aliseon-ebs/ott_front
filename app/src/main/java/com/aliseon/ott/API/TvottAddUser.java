package com.aliseon.ott.API;

import android.app.Application;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TvottAddUser extends Application {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("list")
    @Expose
    public ArrayList<List> tvottadduser_list = new ArrayList<>();

    public class List {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("nickname")
        @Expose
        private String nickname;
        @SerializedName("photo")
        @Expose
        private String photo;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("currency")
        @Expose
        private String currency;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<List> getList() {
        return tvottadduser_list;
    }

    public void setList(ArrayList<List> list) {
        this.tvottadduser_list = list;
    }

}
