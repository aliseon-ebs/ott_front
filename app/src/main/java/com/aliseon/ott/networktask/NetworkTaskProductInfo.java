//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionProductInfo;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static com.aliseon.ott.Aliseon.api_product_detail;
//import static com.aliseon.ott.Aliseon.cartdetail_productinfo_desc;
//import static com.aliseon.ott.Aliseon.cartdetail_productinfo_id;
//import static com.aliseon.ott.Aliseon.cartdetailapiload;
//import static com.aliseon.ott.activity.CartDetailActivity.cartdetailactivityhandler;
//
//public class NetworkTaskProductInfo extends AsyncTask<Void, Void, String> {
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskProductInfo(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionProductInfo requesthttpurlconnectionproductinfo = new RequestHttpURLConnectionProductInfo();
//        result = requesthttpurlconnectionproductinfo.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        String TAG = "장바구니 정보 출력";
//
//        if (s != null) {
//            try {
//
//                JSONObject jo_productinfo_total = new JSONObject(s);
//                String productinfo_list = jo_productinfo_total.getString("list");
//                JSONArray ja_productinfo_list = new JSONArray(productinfo_list);
//
//                    JSONObject jo_productinfo = ja_productinfo_list.getJSONObject(0);
//
//                    int id = jo_productinfo.getInt("id");
//                    String desc = jo_productinfo.getString("desc");
//
//                    cartdetail_productinfo_id = id;
//                    cartdetail_productinfo_desc = desc;
//
//                    Log.d(TAG, ">>" + id + "/" + desc);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//            if (cartdetailapiload == 0) {
//
//                NetworkTaskProductDetail networktaskproductdetail = new NetworkTaskProductDetail(api_product_detail, null);
//                networktaskproductdetail.execute();
//
//            } else if (cartdetailapiload == 1) {
//                cartdetailactivityhandler.sendEmptyMessage(800);
//            }
//
//
//
//    }
//}
//
