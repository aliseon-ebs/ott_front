package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductDetail {

    @SerializedName("status") Boolean status;
    @SerializedName("list")
    @Expose
    private ArrayList<List> list = null;

    public class List {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("vendor_id")
        @Expose
        private Integer vendorId;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("sub_name")
        @Expose
        private String subName;
        @SerializedName("previous_price")
        @Expose
        private Integer previousPrice;
        @SerializedName("complete_price")
        @Expose
        private Integer completePrice;
        @SerializedName("basic_shipping")
        @Expose
        private Integer basicShipping;
        @SerializedName("free_shipping")
        @Expose
        private Integer freeShipping;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getVendorId() {
            return vendorId;
        }

        public void setVendorId(Integer vendorId) {
            this.vendorId = vendorId;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }

        public Integer getPreviousPrice() {
            return previousPrice;
        }

        public void setPreviousPrice(Integer previousPrice) {
            this.previousPrice = previousPrice;
        }

        public Integer getCompletePrice() {
            return completePrice;
        }

        public void setCompletePrice(Integer completePrice) {
            this.completePrice = completePrice;
        }

        public Integer getBasicShipping() {
            return basicShipping;
        }

        public void setBasicShipping(Integer basicShipping) {
            this.basicShipping = basicShipping;
        }

        public Integer getFreeShipping() {
            return freeShipping;
        }

        public void setFreeShipping(Integer freeShipping) {
            this.freeShipping = freeShipping;
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
