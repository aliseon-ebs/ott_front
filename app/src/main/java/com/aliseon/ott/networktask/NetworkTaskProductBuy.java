package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionProductBuy;
import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionUsersManagement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.aliseon.ott.Variable.cartdetail_productbuy_c_option_original_price;
import static com.aliseon.ott.Variable.cartdetail_productbuy_c_option_original_value;
import static com.aliseon.ott.Variable.cartdetail_productbuy_c_option_price;
import static com.aliseon.ott.Variable.cartdetail_productbuy_c_option_stock;
import static com.aliseon.ott.Variable.cartdetail_productbuy_c_option_value;
import static com.aliseon.ott.Variable.cartdetail_productbuy_c_option_name;
import static com.aliseon.ott.Variable.cartdetail_productbuy_p_option_name;
import static com.aliseon.ott.Variable.cartdetail_productbuy_p_option_original_price;
import static com.aliseon.ott.Variable.cartdetail_productbuy_p_option_original_value;
import static com.aliseon.ott.Variable.cartdetail_productbuy_p_option_price;
import static com.aliseon.ott.Variable.cartdetail_productbuy_p_option_stock;
import static com.aliseon.ott.Variable.cartdetail_productbuy_p_option_value;
import static com.aliseon.ott.Variable.cartdetailapiload;
import static com.aliseon.ott.activity.CartDetailActivity.cartdetailactivityhandler;
import static com.aliseon.ott.activity.InfoCheckActivity.InfocheckmHandler;
import static com.aliseon.ott.activity.LoadingActivity.setDataUserinfo;
import static com.aliseon.ott.Variable.userinfo;
import static com.aliseon.ott.Variable.userinfouid;

public class NetworkTaskProductBuy extends AsyncTask<Void, Void, String> {

    private static String TAG = "배열 정보 가져오기";
    private static String TAG2 = "자바로 가공한 사용자 배열 정보 가져오기";
    private static String TAG3 = "가져온 데이터 ArrayList에 넣기";

    private String url;
    private ContentValues values;

    public NetworkTaskProductBuy(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionProductBuy requestHttpURLConnectionproductbuy= new RequestHttpURLConnectionProductBuy();
        result = requestHttpURLConnectionproductbuy.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.d(TAG, "Product Buy >>" + s);

        if (s != null) {
            try {

                JSONObject jo_productbuy_total = new JSONObject(s);
                String productbuy_list = jo_productbuy_total.getString("list");

                JSONArray ja_productbuy = new JSONArray(productbuy_list);

                for (int i = 0; i < ja_productbuy.length(); i++) {

                    cartdetail_productbuy_c_option_original_value = new ArrayList<>();
                    cartdetail_productbuy_c_option_original_price = new ArrayList<>();
                    cartdetail_productbuy_c_option_name = new ArrayList<>();
                    cartdetail_productbuy_c_option_value = new ArrayList<>();
                    cartdetail_productbuy_c_option_price = new ArrayList<>();
                    cartdetail_productbuy_c_option_stock = new ArrayList<>();

                    JSONObject jo_productbuy_option = ja_productbuy.getJSONObject(i);

                    String name = jo_productbuy_option.getString("name");
                    String original_value = jo_productbuy_option.getString("original_value");
                    String original_price = jo_productbuy_option.getString("original_price");
                    String value = jo_productbuy_option.getString("value");
                    String price = jo_productbuy_option.getString("price");
                    String stock = jo_productbuy_option.getString("stock");

                    try{
                        name = name.replace("\\","");
                        name = name.replace("\"","");
                        name = name.replace("[","");
                        name = name.replace("]","");
                        String[] name_result = name.split(",");
                        for(int ii = 0; ii < name_result.length; ii++) {
                            cartdetail_productbuy_c_option_name.add(name_result[ii]);
                        }
                        cartdetail_productbuy_p_option_name.add(cartdetail_productbuy_c_option_name);
//                      throw new Exception(); //강제 에러 출력
                    }catch (Exception e){
                        cartdetail_productbuy_p_option_name.add(cartdetail_productbuy_c_option_name);
                    }

                    Log.d("원래 값", ""+ original_value);

                    try{
                        original_value = original_value.replace("\\","");
                        original_value = original_value.replace("\"","");
                        original_value = original_value.replace("[","");
                        original_value = original_value.replace("]","");
                        original_value = original_value.replace("|","");
                        String[] original_value_result = original_value.split(",");
                        for(int ii = 0; ii < original_value_result.length; ii++) {
                            cartdetail_productbuy_c_option_original_value.add(original_value_result[ii]);
                        }
                        cartdetail_productbuy_p_option_original_value.add(cartdetail_productbuy_c_option_original_value);
//                      throw new Exception(); //강제 에러 출력
                    }catch (Exception e){
                        cartdetail_productbuy_p_option_original_value.add(cartdetail_productbuy_c_option_original_value);
                    }

                    try{
                        original_price = original_price.replace("\\","");
                        original_price = original_price.replace("\"","");
                        original_price = original_price.replace("[","");
                        original_price = original_price.replace("]","");
                        String[] original_price_result = original_price.split(",");
                        for(int ii = 0; ii < original_price_result.length; ii++) {
                            cartdetail_productbuy_c_option_original_price.add(Integer.parseInt(original_price_result[ii]));
                        }
                        cartdetail_productbuy_p_option_original_price.add(cartdetail_productbuy_c_option_original_price);
//                      throw new Exception(); //강제 에러 출력
                    }catch (Exception e){
                        cartdetail_productbuy_p_option_original_price.add(cartdetail_productbuy_c_option_original_price);
                    }

                    try{
                        String[] value_result = value.split(",");
                        for(int ii = 0; ii < value_result.length; ii++) {
                            cartdetail_productbuy_c_option_value.add(value_result[ii]);
                        }
                        cartdetail_productbuy_p_option_value.add(cartdetail_productbuy_c_option_value);
//                      throw new Exception(); //강제 에러 출력
                    }catch (Exception e){
                        cartdetail_productbuy_p_option_value.add(cartdetail_productbuy_c_option_value);
                    }

                    try{
                        String[] price_result = price.split(",");
                        for(int ii = 0; ii < price_result.length; ii++) {
                            cartdetail_productbuy_c_option_price.add(Integer.parseInt(price_result[ii]));
                        }
                        cartdetail_productbuy_p_option_price.add(cartdetail_productbuy_c_option_price);
//                      throw new Exception(); //강제 에러 출력
                    }catch (Exception e){
                        cartdetail_productbuy_p_option_price.add(cartdetail_productbuy_c_option_price);
                    }

                    try{
                        String[] stock_result = stock.split(",");
                        for(int ii = 0; ii < stock_result.length; ii++) {
                            cartdetail_productbuy_c_option_stock.add(Integer.parseInt(stock_result[ii]));
                        }
                        cartdetail_productbuy_p_option_stock.add(cartdetail_productbuy_c_option_stock);
//                      throw new Exception(); //강제 에러 출력
                    }catch (Exception e){
                        cartdetail_productbuy_p_option_stock.add(cartdetail_productbuy_c_option_stock);
                    }

                    Log.d(TAG2, "Product Buy result >>" + name + " / " + original_value + " / " + original_price + " / " + value + " / " + price + " / " + stock );

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        if (cartdetailapiload == 0) {

            cartdetailapiload = 1;
            cartdetailactivityhandler.sendEmptyMessage(1000);

        } else if (cartdetailapiload == 1) {

            cartdetailactivityhandler.sendEmptyMessage(800);

        }

    }
}
