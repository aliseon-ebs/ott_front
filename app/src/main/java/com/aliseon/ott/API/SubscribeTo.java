package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SubscribeTo {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("list")
    @Expose
    public ArrayList<List> subscribe_to_list = new ArrayList<>();

    public class List {

        @SerializedName("id") Integer id;
        @SerializedName("nickname") String nickname;
        @SerializedName("photo") String photo;
        @SerializedName("subscribeto_cnt") int subscribetoCnt;
        @SerializedName("contents_cnt") int contentsCnt;

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

        public Integer getSubscribetoCnt() {
            return subscribetoCnt;
        }

        public void setSubscribetoCnt(Integer subscribetoCnt) {
            this.subscribetoCnt = subscribetoCnt;
        }

        public Integer getContentsCnt() {
            return contentsCnt;
        }

        public void setContentsCnt(Integer contentsCnt) {
            this.contentsCnt = contentsCnt;
        }

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<List> getsubscribe_to_list() { return subscribe_to_list; }

    public void setsubscribe_to_list(ArrayList<List> subscribe_to_list) { this.subscribe_to_list = subscribe_to_list; }

}
