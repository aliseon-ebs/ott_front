package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Cart {

    @SerializedName("status") Boolean status;
    @SerializedName("list")
    @Expose
    public ArrayList<List> cart_list = new ArrayList<>();

    public class List {

        @SerializedName("shop") Shop shop;
        @SerializedName("items") ArrayList<Item> items = null;

        public Shop getShop() {
            return shop;
        }

        public void setShop(Shop shop) {
            this.shop = shop;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void setItems(ArrayList<Item> items) {
            this.items = items;
        }

    }

    public class Item {

        @SerializedName("id") String id;
        @SerializedName("user_id") Integer userId;
        @SerializedName("option_price") String optionPrice;
        @SerializedName("option_stock") String optionStock;
        @SerializedName("product_id") String productId;
        @SerializedName("option_value") String optionValue;
        @SerializedName("option_price_ori") String optionPriceOri;
        @SerializedName("status") String item_status;
        @SerializedName("seller_id") String sellerId;
        @SerializedName("name") String name;
        @SerializedName("thumbnail") String thumbnail;
        @SerializedName("previous_price") String previousPrice;
        @SerializedName("price") String price;

        public String getId() { return id; }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getOptionPrice() {
            return optionPrice;
        }

        public void setOptionPrice(String optionPrice) {
            this.optionPrice = optionPrice;
        }

        public String getOptionStock() {
            return optionStock;
        }

        public void setOptionStock(String optionStock) {
            this.optionStock = optionStock;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getOptionValue() {
            return optionValue;
        }

        public void setOptionValue(String optionValue) {
            this.optionValue = optionValue;
        }

        public String getOptionPriceOri() {
            return optionPriceOri;
        }

        public void setOptionPriceOri(String optionPriceOri) {
            this.optionPriceOri = optionPriceOri;
        }

        public String getItem_Status() {
            return item_status;
        }

        public void setItem_Status(String item_status) {
            this.item_status = item_status;
        }

        public String getSellerId() {
            return sellerId;
        }

        public void setSellerId(String sellerId) {
            this.sellerId = sellerId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getPreviousPrice() {
            return previousPrice;
        }

        public void setPreviousPrice(String previousPrice) {
            this.previousPrice = previousPrice;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

    }

    public class Shop {

        @SerializedName("id") String id;
        @SerializedName("photo") String photo;
        @SerializedName("nickname") String nickname;
        @SerializedName("seller_id") Integer sellerId;
        @SerializedName("shop_name") String shopName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Integer getSellerId() {
            return sellerId;
        }

        public void setSellerId(Integer sellerId) {
            this.sellerId = sellerId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
