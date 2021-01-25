package com.aliseon.ott.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Atrend {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("list")
    @Expose
    private List atrend_list;

    public class List {

        public ArrayList<today> today = new ArrayList<>();
        public ArrayList<today> getToday() {return today;}
        public ArrayList<last> last = new ArrayList<>();
        public ArrayList<last> getLast() {return last;}

        public class today {
            @SerializedName("id") String id;
            @SerializedName("user_id") String user_id;
            @SerializedName("type") String type;
            @SerializedName("product_id") String productId;
            @SerializedName("contents_id") String contentsId;
            @SerializedName("title") String title;
            @SerializedName("sub_title") String subTitle;
            @SerializedName("description") String description;
            @SerializedName("summary") String summary;
            @SerializedName("view") Integer view;
            @SerializedName("like") Integer like;
            @SerializedName("color") String color;
            @SerializedName("start_at") String startAt;
            @SerializedName("create_at") String createAt;
            @SerializedName("update_at") String updateAt;
            @SerializedName("opacity") String opacity;
            @SerializedName("status") Integer status;
            @SerializedName("background") String background;
            @SerializedName("thumbnail") String thumbnail;
            @SerializedName("items") ArrayList<Item> items = new ArrayList<>();
            public ArrayList<Item> getItems() {return items;}

            public String getId() {return id;}
            public String getUser_id() {return user_id;}
            public String getType() {return type;}
            public String getProductId() {return productId;}
            public String getContentsId() {return contentsId;}
            public String getTitle() {return title;}
            public String getSubTitle() {return subTitle;}
            public String getDescription() {return description;}
            public String getSummary() {return summary;}
            public int getView() {return view;}
            public int getLike() {return like;}
            public String getColor() {return color;}
            public String getStartAt() {return startAt;}
            public String getCreateAt() {return createAt;}
            public String getUpdateAt() {return updateAt;}
            public String getOpacity() {return opacity;}
            public int getStatus() {return status;}
            public String getBackground() {return background;}
            public String getThumbnail() {return thumbnail;}

            public class Item {
                @SerializedName("id") private Integer id;
                @SerializedName("name") private String name;
                @SerializedName("brand") private String brand;
                @SerializedName("thumbnail") private String thumbnail;
                @SerializedName("price") private Integer price;
                @SerializedName("previous_price") private Integer previousPrice;

                public Integer getId() {
                    return id;
                }
                public String getName() {
                    return name;
                }
                public String getBrand() {
                    return brand;
                }
                public String getThumbnail() {
                    return thumbnail;
                }
                public Integer getPrice() {
                    return price;
                }
                public Integer getPreviousPrice() {
                    return previousPrice;
                }
            }

        }

        public class last {
            @SerializedName("id") String id;
            @SerializedName("user_id") String user_id;
            @SerializedName("type") String type;
            @SerializedName("product_id") String productId;
            @SerializedName("contents_id") String contentsId;
            @SerializedName("title") String title;
            @SerializedName("sub_title") String subTitle;
            @SerializedName("description") String description;
            @SerializedName("summary") String summary;
            @SerializedName("view") Integer view;
            @SerializedName("like") Integer like;
            @SerializedName("color") String color;
            @SerializedName("start_at") String startAt;
            @SerializedName("create_at") String createAt;
            @SerializedName("update_at") String updateAt;
            @SerializedName("opacity") String opacity;
            @SerializedName("status") Integer status;
            @SerializedName("background") String background;
            @SerializedName("thumbnail") String thumbnail;
            @SerializedName("items") ArrayList<List.last.Item> items = new ArrayList<>();
            public ArrayList<List.last.Item> getItems() {return items;}

            public String getId() {return id;}
            public String getUser_id() {return user_id;}
            public String getType() {return type;}
            public String getProductId() {return productId;}
            public String getContentsId() {return contentsId;}
            public String getTitle() {return title;}
            public String getSubTitle() {return subTitle;}
            public String getDescription() {return description;}
            public String getSummary() {return summary;}
            public int getView() {return view;}
            public int getLike() {return like;}
            public String getColor() {return color;}
            public String getStartAt() {return startAt;}
            public String getCreateAt() {return createAt;}
            public String getUpdateAt() {return updateAt;}
            public String getOpacity() {return opacity;}
            public int getStatus() {return status;}
            public String getBackground() {return background;}
            public String getThumbnail() {return thumbnail;}

            public class Item {
                @SerializedName("id") private Integer id;
                @SerializedName("name") private String name;
                @SerializedName("brand") private String brand;
                @SerializedName("thumbnail") private String thumbnail;
                @SerializedName("price") private Integer price;
                @SerializedName("previous_price") private Integer previousPrice;

                public Integer getId() {
                    return id;
                }
                public String getName() {
                    return name;
                }
                public String getBrand() {
                    return brand;
                }
                public String getThumbnail() {
                    return thumbnail;
                }
                public Integer getPrice() {
                    return price;
                }
                public Integer getPreviousPrice() {
                    return previousPrice;
                }
            }

        }

    }
    public List getList() {
        return atrend_list;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}

