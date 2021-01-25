package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductBuy {

    @SerializedName("status") Boolean status;
    @SerializedName("list")
    @Expose
    private ArrayList<List> list = null;

    public class List {

        @SerializedName("name")
        @Expose
        private ArrayList<String> name = null;
        @SerializedName("count")
        @Expose
        private Integer count;
        @SerializedName("original_value")
        @Expose
        private ArrayList<String> originalValue = null;
        @SerializedName("original_price")
        @Expose
        private ArrayList<String> originalPrice = null;
        @SerializedName("value")
        @Expose
        private ArrayList<String> value = null;
        @SerializedName("price")
        @Expose
        private ArrayList<String> price = null;
        @SerializedName("stock")
        @Expose
        private ArrayList<String> stock = null;

        public ArrayList<String> getName() {
            return name;
        }

        public void setName(ArrayList<String> name) {
            this.name = name;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public ArrayList<String> getOriginalValue() {
            return originalValue;
        }

        public void setOriginalValue(ArrayList<String> originalValue) {
            this.originalValue = originalValue;
        }

        public ArrayList<String> getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(ArrayList<String> originalPrice) {
            this.originalPrice = originalPrice;
        }

        public ArrayList<String> getValue() {
            return value;
        }

        public void setValue(ArrayList<String> value) {
            this.value = value;
        }

        public ArrayList<String> getPrice() {
            return price;
        }

        public void setPrice(ArrayList<String> price) {
            this.price = price;
        }

        public ArrayList<String> getStock() {
            return stock;
        }

        public void setStock(ArrayList<String> stock) {
            this.stock = stock;
        }

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<List> getList() {
        return list;
    }

    public void setList(ArrayList<List> list) {
        this.list = list;
    }

}
