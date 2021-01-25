package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RecommendCreator {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("list")
    @Expose
    public ArrayList<List> recommend_creator_list;

    public class List {

        @SerializedName("id") String id;
        @SerializedName("nickname") String nickname;
        @SerializedName("photo") String photo;
        @SerializedName("subscribeto_cnt") Integer subscribetoCnt;
        @SerializedName("contents_cnt") Integer contentsCnt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

    public ArrayList<List> getRecommend_creator_list() { return recommend_creator_list; }

    public void setRecommend_creator_list(ArrayList<List> recommend_creator_list) {
        this.recommend_creator_list = recommend_creator_list;
    }
}
