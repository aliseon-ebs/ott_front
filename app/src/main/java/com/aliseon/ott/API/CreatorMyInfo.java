package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CreatorMyInfo {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("list")
    @Expose
    public List creator_my_list;

    public class List {

        @SerializedName("id") String id;
        @SerializedName("email") String email;
        @SerializedName("name") String name;
        @SerializedName("nickname") String nickname;
        @SerializedName("photo") String photo;
        @SerializedName("ban") Integer ban;
        @SerializedName("subscribeto_cnt") Integer subscribetoCnt;
        @SerializedName("subscribefrom_cnt") Integer subscribefromCnt;
        @SerializedName("contents_cnt") Integer contentsCnt;
        @SerializedName("country") String country;
        @SerializedName("zip") String zip;
        @SerializedName("city") String city;
        @SerializedName("state") String state;
        @SerializedName("address") String address;
        @SerializedName("is_allowme") Integer isAllowme;
        @SerializedName("is_hide") Integer isHide;
        @SerializedName("is_noti_subscribe") Integer isNotiSubscribe;
        @SerializedName("is_noti_upload_contents") Integer isNotiUploadContents;
        @SerializedName("desc") String desc;
        @SerializedName("is_noti_shipping_product") Integer isNotiShippingProduct;
        @SerializedName("is_noti_event") Integer isNotiEvent;
        @SerializedName("fav_category") String favCategory;
        @SerializedName("seller_id") Integer sellerId;
        @SerializedName("seller_status") Integer sellerStatus;
        @SerializedName("mega_id") Integer megaId;
        @SerializedName("mega_status") Integer megaStatus;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public Integer getBan() {
            return ban;
        }

        public void setBan(Integer ban) {
            this.ban = ban;
        }

        public Integer getSubscribetoCnt() {
            return subscribetoCnt;
        }

        public void setSubscribetoCnt(Integer subscribetoCnt) {
            this.subscribetoCnt = subscribetoCnt;
        }

        public Integer getSubscribefromCnt() {
            return subscribefromCnt;
        }

        public void setSubscribefromCnt(Integer subscribefromCnt) {
            this.subscribefromCnt = subscribefromCnt;
        }

        public Integer getContentsCnt() {
            return contentsCnt;
        }

        public void setContentsCnt(Integer contentsCnt) {
            this.contentsCnt = contentsCnt;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Integer getIsAllowme() {
            return isAllowme;
        }

        public void setIsAllowme(Integer isAllowme) {
            this.isAllowme = isAllowme;
        }

        public Integer getIsHide() {
            return isHide;
        }

        public void setIsHide(Integer isHide) {
            this.isHide = isHide;
        }

        public Integer getIsNotiSubscribe() {
            return isNotiSubscribe;
        }

        public void setIsNotiSubscribe(Integer isNotiSubscribe) {
            this.isNotiSubscribe = isNotiSubscribe;
        }

        public Integer getIsNotiUploadContents() {
            return isNotiUploadContents;
        }

        public void setIsNotiUploadContents(Integer isNotiUploadContents) {
            this.isNotiUploadContents = isNotiUploadContents;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public Integer getIsNotiShippingProduct() {
            return isNotiShippingProduct;
        }

        public void setIsNotiShippingProduct(Integer isNotiShippingProduct) {
            this.isNotiShippingProduct = isNotiShippingProduct;
        }

        public Integer getIsNotiEvent() {
            return isNotiEvent;
        }

        public void setIsNotiEvent(Integer isNotiEvent) {
            this.isNotiEvent = isNotiEvent;
        }

        public String getFavCategory() {
            return favCategory;
        }

        public void setFavCategory(String favCategory) {
            this.favCategory = favCategory;
        }

        public Integer getSellerId() {
            return sellerId;
        }

        public void setSellerId(Integer sellerId) {
            this.sellerId = sellerId;
        }

        public Integer getSellerStatus() {
            return sellerStatus;
        }

        public void setSellerStatus(Integer sellerStatus) {
            this.sellerStatus = sellerStatus;
        }

        public Integer getMegaId() {
            return megaId;
        }

        public void setMegaId(Integer megaId) {
            this.megaId = megaId;
        }

        public Integer getMegaStatus() {
            return megaStatus;
        }

        public void setMegaStatus(Integer megaStatus) {
            this.megaStatus = megaStatus;
        }
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
