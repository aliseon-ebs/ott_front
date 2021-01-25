//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottDelcart;
//
//import static com.aliseon.ott.Aliseon.api_cart;
//
//public class NetworkTaskTvottDelcart extends AsyncTask<Void, Void, String> {
//
//    private static String TAG = "토큰 정보 가져오기";
//    private static String TAG2 = "자바로 가공한 토큰 정보 가져오기";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskTvottDelcart(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionTvottDelcart requestHttpURLConnectiondelcart = new RequestHttpURLConnectionTvottDelcart();
//        result = requestHttpURLConnectiondelcart.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//    }
//
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//        Log.d(TAG, "장바구니 삭제 >>" + s);
//
//        NetworkTaskTvottCart networktasktvottcart = new NetworkTaskTvottCart(api_cart, null);
//        networktasktvottcart.execute();
//
//    }
//}