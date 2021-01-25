//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionSubscribePost;
//
//import static com.aliseon.ott.Aliseon.CreatorDetailClear;
//import static com.aliseon.ott.Aliseon.MyDetailClear;
//import static com.aliseon.ott.Aliseon.api_subscribe_from;
//import static com.aliseon.ott.Aliseon.param_subscribe_activity;
//
//public class NetworkTaskSubscribePost extends AsyncTask<Void, Void, String> {
//
//    private static String TAG = "구독하기";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskSubscribePost(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionSubscribePost requesthttpurlconnectionsubscribechannels = new RequestHttpURLConnectionSubscribePost();
//        result = requesthttpurlconnectionsubscribechannels.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//    }
//
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        if(s != null) {
//
//            if (param_subscribe_activity == 1) {
//
//                CreatorDetailClear();
//
//            } else if (param_subscribe_activity == 2) {
//
//                MyDetailClear();
//
//            }
//
//            NetworkTaskMySubscribeFrom networktasksubscribefrom = new NetworkTaskMySubscribeFrom(api_subscribe_from, null);
//            networktasksubscribefrom.execute();
//
//        }
//
//    }
//}