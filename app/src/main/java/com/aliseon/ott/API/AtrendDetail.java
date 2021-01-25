package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AtrendDetail {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("list")
    @Expose
    public List atrend_detail_list;

    public class List {

        @SerializedName("detail")
        @Expose
        private ArrayList<Detail> detail = null;

        @SerializedName("related")
        @Expose
        private ArrayList<Related> related = null;

        public ArrayList<Detail> getDetail() { return detail; }

        public void setDetail(ArrayList<Detail> detail) { this.detail = detail; }

        public ArrayList<Related> getRelated() { return related; }

        public void setRelated(ArrayList<Related> related) { this.related = related; }

        public class Detail {
            
            @SerializedName("dept1_html")
            @Expose
            private String dept1Html;
            
            @SerializedName("dept2_html")
            @Expose
            private String dept2Html;
            
            @SerializedName("dept3_html")
            @Expose
            private String dept3Html;
            
            @SerializedName("dept4_html")
            @Expose
            private String dept4Html;
            
            @SerializedName("maincontent")
            @Expose
            private String maincontent;
            
            @SerializedName("items")
            @Expose
            private ArrayList<Item> items = null;

            public String getDept1Html() { return dept1Html; }

            public void setDept1Html(String dept1Html) { this.dept1Html = dept1Html; }

            public String getDept2Html() { return dept2Html; }

            public void setDept2Html(String dept2Html) { this.dept2Html = dept2Html; }

            public String getDept3Html() { return dept3Html; }

            public void setDept3Html(String dept3Html) { this.dept3Html = dept3Html; }

            public String getDept4Html() { return dept4Html; }

            public void setDept4Html(String dept4Html) { this.dept4Html = dept4Html; }

            public String getMaincontent() { return maincontent; }

            public void setMaincontent(String maincontent) { this.maincontent = maincontent; }

            public ArrayList<Item> getItems() { return items; }

            public void setItems(ArrayList<Item> items) { this.items = items; }

            public class Item {

                @SerializedName("dept1_product")
                @Expose
                private ArrayList<Dept1Product> dept1Product = null;
                @SerializedName("dept2_product")
                @Expose
                private ArrayList<Dept1Product> dept2Product = null;
                @SerializedName("dept3_product")
                @Expose
                private ArrayList<Dept1Product> dept3Product = null;
                @SerializedName("dept4_product")
                @Expose
                private ArrayList<Dept1Product> dept4Product = null;

                public ArrayList<Dept1Product> getDept1Product() {
                    return dept1Product;
                }

                public void setDept1Product(ArrayList<Dept1Product> dept1Product) {
                    this.dept1Product = dept1Product;
                }

                public ArrayList<Dept1Product> getDept2Product() {
                    return dept2Product;
                }

                public void setDept2Product(ArrayList<Dept1Product> dept2Product) {
                    this.dept2Product = dept2Product;
                }

                public ArrayList<Dept1Product> getDept3Product() {
                    return dept3Product;
                }

                public void setDept3Product(ArrayList<Dept1Product> dept3Product) {
                    this.dept3Product = dept3Product;
                }

                public ArrayList<Dept1Product> getDept4Product() {
                    return dept4Product;
                }

                public void setDept4Product(ArrayList<Dept1Product> dept4Product) {
                    this.dept4Product = dept4Product;
                }

                public class Dept1Product {

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

            }

        }

        public class Related {
            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("type")
            @Expose
            private String type;
            @SerializedName("product_id")
            @Expose
            private String productId;
            @SerializedName("contents_id")
            @Expose
            private Integer contentsId;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("sub_title")
            @Expose
            private String subTitle;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("summary")
            @Expose
            private String summary;
            @SerializedName("view")
            @Expose
            private Integer view;
            @SerializedName("like")
            @Expose
            private Integer like;
            @SerializedName("color")
            @Expose
            private String color;
            @SerializedName("start_at")
            @Expose
            private String startAt;
            @SerializedName("create_at")
            @Expose
            private String createAt;
            @SerializedName("update_at")
            @Expose
            private String updateAt;
            @SerializedName("opacity")
            @Expose
            private String opacity;
            @SerializedName("status")
            @Expose
            private Integer status;
            @SerializedName("background")
            @Expose
            private String background;
            @SerializedName("thumbnail")
            @Expose
            private String thumbnail;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getProductId() {
                return productId;
            }

            public void setProductId(String productId) {
                this.productId = productId;
            }

            public Integer getContentsId() {
                return contentsId;
            }

            public void setContentsId(Integer contentsId) {
                this.contentsId = contentsId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public Integer getView() {
                return view;
            }

            public void setView(Integer view) {
                this.view = view;
            }

            public Integer getLike() {
                return like;
            }

            public void setLike(Integer like) {
                this.like = like;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getStartAt() {
                return startAt;
            }

            public void setStartAt(String startAt) {
                this.startAt = startAt;
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

            public String getOpacity() {
                return opacity;
            }

            public void setOpacity(String opacity) {
                this.opacity = opacity;
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }

            public String getBackground() {
                return background;
            }

            public void setBackground(String background) {
                this.background = background;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }
        }

    }

    public void setList(List atrend_detail_list) { this.atrend_detail_list = atrend_detail_list; }

    public List getList() { return atrend_detail_list; }

    public Boolean getStatus() { return status; }

    public void setStatus(Boolean status) { this.status = status; }

}

