package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PopularDetail {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("list")
    @Expose
    private List list;

    public class List {

        @SerializedName("detail")
        @Expose
        private ArrayList<Detail> detail = null;
        @SerializedName("related")
        @Expose
        private ArrayList<Related> related = null;

        public ArrayList<Detail> getDetail() { return detail; }

        public void setDetail(ArrayList<Detail> detail) { this.detail = detail; }

        public ArrayList<Related> getRelated() {
            return related; }

        public void setRelated(ArrayList<Related> related) { this.related = related; }

        public class Detail {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("product_id")
            @Expose
            private String productId;
            @SerializedName("contents_id")
            @Expose
            private String contentsId;
            @SerializedName("contents_type")
            @Expose
            private String contentsType;
            @SerializedName("category_id")
            @Expose
            private Integer categoryId;
            @SerializedName("status")
            @Expose
            private Integer status;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("create_at")
            @Expose
            private String createAt;
            @SerializedName("update_at")
            @Expose
            private String updateAt;
            @SerializedName("like_count")
            @Expose
            private Integer likeCount;
            @SerializedName("view_count")
            @Expose
            private Integer viewCount;
            @SerializedName("comment_count")
            @Expose
            private Integer commentCount;
            @SerializedName("category_ko")
            @Expose
            private String categoryKo;
            @SerializedName("category_en")
            @Expose
            private String categoryEn;
            @SerializedName("nickname")
            @Expose
            private String nickname;
            @SerializedName("photo")
            @Expose
            private String photo;
            @SerializedName("contents")
            @Expose
            private ArrayList<String> contents = null;
            @SerializedName("items")
            @Expose
            private ArrayList<Item> items = null;

            public Integer getId() { return id; }

            public void setId(Integer id) { this.id = id; }

            public Integer getUserId() { return userId; }

            public void setUserId(Integer userId) { this.userId = userId; }

            public String getProductId() { return productId; }

            public void setProductId(String productId) { this.productId = productId; }

            public String getContentsId() { return contentsId; }

            public void setContentsId(String contentsId) { this.contentsId = contentsId; }

            public String getContentsType() { return contentsType; }

            public void setContentsType(String contentsType) { this.contentsType = contentsType; }

            public Integer getCategoryId() { return categoryId; }

            public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

            public Integer getStatus() { return status; }

            public void setStatus(Integer status) { this.status = status; }

            public String getDescription() { return description; }

            public void setDescription(String description) { this.description = description; }

            public String getCreateAt() { return createAt; }

            public void setCreateAt(String createAt) { this.createAt = createAt; }

            public String getUpdateAt() { return updateAt; }

            public void setUpdateAt(String updateAt) { this.updateAt = updateAt; }

            public Integer getLikeCount() { return likeCount; }

            public void setLikeCount(Integer likeCount) { this.likeCount = likeCount; }

            public Integer getViewCount() { return viewCount; }

            public void setViewCount(Integer viewCount) { this.viewCount = viewCount; }

            public Integer getCommentCount() { return commentCount; }

            public void setCommentCount(Integer commentCount) { this.commentCount = commentCount; }

            public String getCategoryKo() { return categoryKo; }

            public void setCategoryKo(String categoryKo) { this.categoryKo = categoryKo; }

            public String getCategoryEn() { return categoryEn; }

            public void setCategoryEn(String categoryEn) { this.categoryEn = categoryEn; }

            public String getNickname() { return nickname; }

            public void setNickname(String nickname) { this.nickname = nickname; }

            public String getPhoto() { return photo; }

            public void setPhoto(String photo) { this.photo = photo; }

            public ArrayList<String> getContents() { return contents; }

            public void setContents(ArrayList<String> contents) { this.contents = contents; }

            public ArrayList<Item> getItems() { return items; }

            public void setItems(ArrayList<Item> items) { this.items = items; }

            public class Item {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("brand")
                @Expose
                private String brand;
                @SerializedName("thumbnail")
                @Expose
                private String thumbnail;
                @SerializedName("price")
                @Expose
                private Integer price;
                @SerializedName("previous_price")
                @Expose
                private Integer previousPrice;

                public Integer getId() { return id; }

                public void setId(Integer id) { this.id = id; }

                public String getName() { return name; }

                public void setName(String name) { this.name = name; }

                public String getBrand() { return brand; }

                public void setBrand(String brand) { this.brand = brand; }

                public String getThumbnail() { return thumbnail; }

                public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

                public Integer getPrice() { return price; }

                public void setPrice(Integer price) { this.price = price; }

                public Integer getPreviousPrice() { return previousPrice; }

                public void setPreviousPrice(Integer previousPrice) { this.previousPrice = previousPrice; }

            }

        }

        public class Related {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("contents_id")
            @Expose
            private String contentsId;
            @SerializedName("status")
            @Expose
            private Integer status;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("create_at")
            @Expose
            private String createAt;
            @SerializedName("update_at")
            @Expose
            private String updateAt;
            @SerializedName("like_count")
            @Expose
            private Integer likeCount;
            @SerializedName("view_count")
            @Expose
            private Integer viewCount;
            @SerializedName("comment_count")
            @Expose
            private Integer commentCount;
            @SerializedName("thumbnail")
            @Expose
            private String thumbnail;

            public Integer getId() { return id; }

            public void setId(Integer id) { this.id = id; }

            public Integer getUserId() { return userId; }

            public void setUserId(Integer userId) { this.userId = userId; }

            public String getContentsId() { return contentsId; }

            public void setContentsId(String contentsId) { this.contentsId = contentsId; }

            public Integer getStatus() { return status; }

            public void setStatus(Integer status) { this.status = status; }

            public String getDescription() { return description; }

            public void setDescription(String description) { this.description = description; }

            public String getCreateAt() { return createAt; }

            public void setCreateAt(String createAt) { this.createAt = createAt; }

            public String getUpdateAt() { return updateAt; }

            public void setUpdateAt(String updateAt) { this.updateAt = updateAt; }

            public Integer getLikeCount() { return likeCount; }

            public void setLikeCount(Integer likeCount) { this.likeCount = likeCount; }

            public Integer getViewCount() { return viewCount; }

            public void setViewCount(Integer viewCount) { this.viewCount = viewCount; }

            public Integer getCommentCount() { return commentCount; }

            public void setCommentCount(Integer commentCount) { this.commentCount = commentCount; }

            public String getThumbnail() { return thumbnail; }

            public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

        }

    }

    public List getList() { return list; }

    public void setList() { this.list = list; }

    public Boolean getStatus() { return status; }

    public void setStatus(Boolean status) { this.status = status; }

}
