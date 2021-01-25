//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionMySubscribeFrom;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static com.aliseon.ott.Aliseon.CreatorDetailClear;
//import static com.aliseon.ott.Aliseon.MyDetailClear;
//import static com.aliseon.ott.Aliseon.api_subscribe_to;
//import static com.aliseon.ott.Aliseon.api_voyage;
//import static com.aliseon.ott.Aliseon.param_subscribe_activity;
//import static com.aliseon.ott.Aliseon.subscribe_creator_list_id;
//import static com.aliseon.ott.Aliseon.subscribe_creator_list_nickname;
//import static com.aliseon.ott.Aliseon.subscribe_creator_list_photo;
//import static com.aliseon.ott.Aliseon.subscribeapiload;
//import static com.aliseon.ott.activity.SubscribeActivity.subscribeactivityhandler;
//
//public class NetworkTaskMySubscribeFrom extends AsyncTask<Void, Void, String> {
//
//    private static String TAG2 = "자바로 가공한 토큰 정보 가져오기";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskMySubscribeFrom(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionMySubscribeFrom requesthttpurlconnectionmysubscribefrom = new RequestHttpURLConnectionMySubscribeFrom();
//        result = requesthttpurlconnectionmysubscribefrom.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//    }
//
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        String subscribefromlist = s;
//
//        if (s != null) {
//            try {
//                JSONObject jo_subscribe_from = new JSONObject(subscribefromlist);
//                String list = jo_subscribe_from.getString("list");
//
//                Log.d(TAG2, "SubscribeFrom 오리지날 리스트>>" + list);
//
//                JSONArray ja_subscribe_from = new JSONArray(list);
//                Log.d(TAG2, "subscribe_from 리스트>>" + ja_subscribe_from);
//
//                for (int i = 0; i < ja_subscribe_from.length(); i++) {
//                    JSONObject jo_subscribe_from_creator = ja_subscribe_from.getJSONObject(i);
//
//                    int id = jo_subscribe_from_creator.getInt("id");
//                    String nickname = jo_subscribe_from_creator.getString("nickname");
//                    String photo = jo_subscribe_from_creator.getString("photo");
//
//                    subscribe_creator_list_id.add(id);
//                    subscribe_creator_list_nickname.add(nickname);
//                    subscribe_creator_list_photo.add(photo);
//
//                    Log.d(TAG2,"구독list 정보 >>" + id + " / " + nickname + " / " + photo);
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        if(subscribeapiload == 0 && param_subscribe_activity == 0){
//
//            NetworkTaskTvottSubscribeVoyage networktasktvottvoyage = new NetworkTaskTvottSubscribeVoyage(api_voyage, null);
//            networktasktvottvoyage.execute();
//
//        } else if(subscribeapiload == 1 && param_subscribe_activity == 0){
//
//            subscribeactivityhandler.sendEmptyMessage(800);
//
//        } else if (param_subscribe_activity == 1) {
//
//            CreatorDetailClear();
//            MyDetailClear();
//
//            NetworkTaskCreatorSubscribeTo networktaskcreatorsubscribeto = new NetworkTaskCreatorSubscribeTo(api_subscribe_to, null);
//            networktaskcreatorsubscribeto.execute();
//
//        } else if (param_subscribe_activity == 2) {
//
//            NetworkTaskMySubscribeTo networktaskmysubscribeto = new NetworkTaskMySubscribeTo(api_subscribe_to, null);
//            networktaskmysubscribeto.execute();
//
//        }
//
//    }
//}