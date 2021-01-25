package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Popular {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("list")
    @Expose
    public ArrayList<List> popular_list = new ArrayList<>();

    public class List {

        @SerializedName("id") String id;
        @SerializedName("user_id") String userId;
        @SerializedName("product_id") String productId;
        @SerializedName("contents_id") String contentsId;
        @SerializedName("contents_type") String contentsType;
        @SerializedName("category_id") String categoryId;
        @SerializedName("status") Integer status;
        @SerializedName("description") String description;
        @SerializedName("create_at") String createAt;
        @SerializedName("update_at") String updateAt;
        @SerializedName("like_count") Integer likeCount;
        @SerializedName("view_count") Integer viewCount;
        @SerializedName("comment_count") Integer commentCount;
        @SerializedName("category_en") String categoryEn;
        @SerializedName("category_ko") String categoryKo;
        @SerializedName("nickname") String nickname;
        @SerializedName("photo") String photo;
        @SerializedName("thumbnail") ArrayList<String> thumbnail;
        @SerializedName("items") ArrayList<Item> items = new ArrayList<>();
        public ArrayList<Item> getItems() {return items;}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getContentsId() {
            return contentsId;
        }

        public void setContentsId(String contentsId) {
            this.contentsId = contentsId;
        }

        public String getContentsType() {
            return contentsType;
        }

        public void setContentsType(String contentsType) {
            this.contentsType = contentsType;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        public String getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(String updateAt) {
            this.updateAt = updateAt;
        }

        public Integer getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(Integer likeCount) {
            this.likeCount = likeCount;
        }

        public Integer getViewCount() {
            return viewCount;
        }

        public void setViewCount(Integer viewCount) {
            this.viewCount = viewCount;
        }

        public Integer getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(Integer commentCount) {
            this.commentCount = commentCount;
        }

        public String getCategoryEn() {
            return categoryEn;
        }

        public void setCategoryEn(String categoryEn) {
            this.categoryEn = categoryEn;
        }

        public String getCategoryKo() {
            return categoryKo;
        }

        public void setCategoryKo(String categoryKo) {
            this.categoryKo = categoryKo;
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

        public ArrayList<String> getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(ArrayList<String> thumbnail) {
            this.thumbnail = thumbnail;
        }

    }

    public class Item {

        @SerializedName("id") Integer id;
        @SerializedName("name")String name;
        @SerializedName("brand")String brand;
        @SerializedName("thumbnail")String thumbnail;
        @SerializedName("price") Integer price;
        @SerializedName("previous_price") Integer previousPrice;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getPreviousPrice() {
            return previousPrice;
        }

        public void setPreviousPrice(Integer previousPrice) {
            this.previousPrice = previousPrice;
        }

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
