package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottCart;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.aliseon.ott.activity.CartActivity.cartactivitycarthandler;
import static com.aliseon.ott.Variable.cart_items_p_cart_id;
import static com.aliseon.ott.Variable.cart_items_p_name;
import static com.aliseon.ott.Variable.cart_items_p_option_price;
import static com.aliseon.ott.Variable.cart_items_p_option_stock;
import static com.aliseon.ott.Variable.cart_items_p_option_value;
import static com.aliseon.ott.Variable.cart_items_p_previous_price;
import static com.aliseon.ott.Variable.cart_items_p_price;
import static com.aliseon.ott.Variable.cart_items_p_product_id;
import static com.aliseon.ott.Variable.cart_items_p_status;
import static com.aliseon.ott.Variable.cart_items_p_thumbnail;
import static com.aliseon.ott.Variable.cart_items_p_user_id;
import static com.aliseon.ott.Variable.cart_items_p_vendor_id;
import static com.aliseon.ott.Variable.cart_shop_id;
import static com.aliseon.ott.Variable.cart_shop_nickname;
import static com.aliseon.ott.Variable.cart_shop_photo;
import static com.aliseon.ott.Variable.cart_shop_shop_name;
import static com.aliseon.ott.Variable.cartapiload;
import static com.aliseon.ott.Variable.cart_items_c_cart_id;
import static com.aliseon.ott.Variable.cart_items_c_user_id;
import static com.aliseon.ott.Variable.cart_items_c_option_value;
import static com.aliseon.ott.Variable.cart_items_c_option_price;
import static com.aliseon.ott.Variable.cart_items_c_option_stock;
import static com.aliseon.ott.Variable.cart_items_c_product_id;
import static com.aliseon.ott.Variable.cart_items_c_status;
import static com.aliseon.ott.Variable.cart_items_c_vendor_id;
import static com.aliseon.ott.Variable.cart_items_c_name;
import static com.aliseon.ott.Variable.cart_items_c_thumbnail;
import static com.aliseon.ott.Variable.cart_items_c_ship;
import static com.aliseon.ott.Variable.cart_items_c_previous_price;
import static com.aliseon.ott.Variable.cart_items_c_price;

public class NetworkTaskTvottCart extends AsyncTask<Void, Void, String> {

    private static String TAG = "장바구니 배열 출력";

    private String url;
    private ContentValues values;

    public NetworkTaskTvottCart (String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionTvottCart requestHttpURLConnectiontvottcart = new RequestHttpURLConnectionTvottCart();
        result = requestHttpURLConnectiontvottcart.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s != null) {
            try {

                JSONObject jo_cart_total = new JSONObject(s);
                String cart_list = jo_cart_total.getString("list");
                JSONArray ja_cart_list = new JSONArray(cart_list);

                for (int i = 0; i < ja_cart_list.length(); i++) {
                    JSONObject jo_cart = ja_cart_list.getJSONObject(i);

                    cart_items_c_cart_id = new ArrayList<>();
                    cart_items_c_user_id = new ArrayList<>();
                    cart_items_c_option_value = new ArrayList<>();
                    cart_items_c_option_price = new ArrayList<>();
                    cart_items_c_option_stock = new ArrayList<>();
                    cart_items_c_product_id = new ArrayList<>();
                    cart_items_c_status = new ArrayList<>();
                    cart_items_c_vendor_id = new ArrayList<>();
                    cart_items_c_name = new ArrayList<>();
                    cart_items_c_thumbnail = new ArrayList<>();
                    cart_items_c_ship = new ArrayList<>();
                    cart_items_c_previous_price = new ArrayList<>();
                    cart_items_c_price = new ArrayList<>();

                    String shop = jo_cart.getString("shop");
                    String items = jo_cart.getString("items");

                    JSONObject jo_cart_shop = new JSONObject(shop);

                    String id = jo_cart_shop.getString("id");
                    String photo = jo_cart_shop.getString("photo");
                    String vendor_nickname = jo_cart_shop.getString("nickname");
                    String shop_name = jo_cart_shop.getString("shop_name");

                    cart_shop_id.add(id);
                    cart_shop_photo.add(photo);
                    cart_shop_nickname.add(vendor_nickname);
                    cart_shop_shop_name.add(shop_name);

                    Log.d(TAG, "자바로 가공한 cart shop 리스트>>" + id + " / " + photo + " / " + vendor_nickname + " / " + shop_name);

                    JSONArray ja_items = new JSONArray(items);

                        for (int ii = 0; ii < ja_items.length(); ii++) {
                            JSONObject jo_items = ja_items.getJSONObject(ii);

                            String cart_id = jo_items.getString("cart_id");
                            String user_id = jo_items.getString("user_id");
                            String option_value = jo_items.getString("option_value");
                            String option_price = jo_items.getString("option_price");
                            String option_stock = jo_items.getString("option_stock");
                            String product_id = jo_items.getString("product_id");
                            String status = jo_items.getString("status");
                            String vendor_id = jo_items.getString("vendor_id");
                            String item_name = jo_items.getString("name");
                            String thumbnail = jo_items.getString("thumbnail");
//                            String ship = jo_items.getString("ship");
                            String previous_price = jo_items.getString("previous_price");
                            String price = jo_items.getString("price");

                            option_value = option_value.replace(",", "\n");

                            cart_items_c_cart_id.add(cart_id);
                            cart_items_c_user_id.add(user_id);
                            cart_items_c_option_value.add(option_value);
                            cart_items_c_option_price.add(option_price);
                            cart_items_c_option_stock.add(option_stock);
                            cart_items_c_product_id.add(product_id);
                            cart_items_c_status.add(status);
                            cart_items_c_vendor_id.add(vendor_id);
                            cart_items_c_name.add(item_name);
                            cart_items_c_thumbnail.add(thumbnail);
//                            cart_items_c_ship.add(ship);
                            cart_items_c_previous_price.add(previous_price);
                            cart_items_c_price.add(price);

                            Log.d(TAG, "자바로 가공한 cart items 리스트>>" + cart_id + "/" + user_id + "/" + option_value + "/" + option_price + "/" + option_stock + "/" + product_id + "/" + status + "/" + vendor_id
                                    + "/" + item_name + "/" + thumbnail + "/" + previous_price + "/" + price);

                        }

                    cart_items_p_cart_id.add(cart_items_c_cart_id);
                    cart_items_p_user_id.add(cart_items_c_user_id);
                    cart_items_p_option_value.add(cart_items_c_option_value);
                    cart_items_p_option_price.add(cart_items_c_option_price);
                    cart_items_p_option_stock.add(cart_items_c_option_stock);
                    cart_items_p_product_id.add(cart_items_c_product_id);
                    cart_items_p_status.add(cart_items_c_status);
                    cart_items_p_vendor_id.add(cart_items_c_vendor_id);
                    cart_items_p_name.add(cart_items_c_name);
                    cart_items_p_thumbnail.add(cart_items_c_thumbnail);
//                    cart_items_p_ship.add(cart_items_c_ship);
                    cart_items_p_previous_price.add(cart_items_c_previous_price);
                    cart_items_p_price.add(cart_items_c_price);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


            if (cartapiload == 0) {
                Log.d(TAG, "자바로 가공한 cart items array 리스트>>" + cart_items_p_cart_id);
                cartapiload = 1;
                cartactivitycarthandler.sendEmptyMessage(1000);
            } else if (cartapiload == 1) {
                cartactivitycarthandler.sendEmptyMessage(800);
            }
        }
    }
}

