package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionProductDetail;
import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionUsersManagement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.Variable.api_product_buy;
import static com.aliseon.ott.Variable.cartdetail_productdetail_basic_shipping;
import static com.aliseon.ott.Variable.cartdetail_productdetail_free_shipping;
import static com.aliseon.ott.Variable.cartdetail_productdetail_previous_price;
import static com.aliseon.ott.Variable.cartdetail_productdetail_sub_title;
import static com.aliseon.ott.Variable.cartdetail_productdetail_thumbnail;
import static com.aliseon.ott.Variable.cartdetail_productdetail_title;
import static com.aliseon.ott.Variable.cartdetail_productdetail_vendor_id;
import static com.aliseon.ott.Variable.cartdetailapiload;
import static com.aliseon.ott.activity.CartDetailActivity.cartdetailactivityhandler;
import static com.aliseon.ott.Variable.cartdetail_productdetail_id;
import static com.aliseon.ott.Variable.cartdetail_productdetail_complete_price;

public class NetworkTaskProductDetail extends AsyncTask<Void, Void, String> {

    private String url;
    private ContentValues values;

    public NetworkTaskProductDetail(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionProductDetail requestHttpURLConnectionproductdetail= new RequestHttpURLConnectionProductDetail();
        result = requestHttpURLConnectionproductdetail.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String TAG = "장바구니 자세히 출력";

        if (s != null) {
            try {

                JSONObject jo_productdetail_total = new JSONObject(s);
                String productdetail_list = jo_productdetail_total.getString("list");
                JSONArray ja_productdetail_list = new JSONArray(productdetail_list);

                    JSONObject jo_productdetail = ja_productdetail_list.getJSONObject(0);

                    int id = jo_productdetail.getInt("id");
                    int vendor_id = jo_productdetail.getInt("vendor_id");
                    String thumbnail = jo_productdetail.getString("thumbnail");
                    String title = jo_productdetail.getString("name");
                    String sub_title = jo_productdetail.getString("sub_name");
                    int previous_price = jo_productdetail.getInt("previous_price");
                    int complete_price = jo_productdetail.getInt("complete_price");
                    int basic_shipping = jo_productdetail.getInt("basic_shipping");
                    int free_shipping = jo_productdetail.getInt("free_shipping");

                    cartdetail_productdetail_id = id;
                    cartdetail_productdetail_vendor_id = vendor_id;
                    cartdetail_productdetail_thumbnail = thumbnail;
                    cartdetail_productdetail_title = title;
                    cartdetail_productdetail_sub_title = sub_title;
                    cartdetail_productdetail_previous_price = previous_price;
                    cartdetail_productdetail_complete_price = complete_price;
                    cartdetail_productdetail_basic_shipping = basic_shipping;
                    cartdetail_productdetail_free_shipping = free_shipping;

                    Log.d(TAG, ">>" + id + "/" + vendor_id + "/" + thumbnail + "/" + title + "/" + sub_title + "/" + previous_price + "/" + complete_price + "/" + basic_shipping + "/" + free_shipping + "/");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        if (cartdetailapiload == 0) {

            NetworkTaskProductBuy networktaskproductbuy = new NetworkTaskProductBuy(api_product_buy, null);
            networktaskproductbuy.execute();

        } else if (cartdetailapiload == 1) {
            cartdetailactivityhandler.sendEmptyMessage(800);
        }

    }
}
