//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionMySubscribeTo;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static com.aliseon.ott.Aliseon.mydetail_list_contents_cnt;
//import static com.aliseon.ott.Aliseon.mydetail_list_id;
//import static com.aliseon.ott.Aliseon.mydetail_list_nickname;
//import static com.aliseon.ott.Aliseon.mydetail_list_photo;
//import static com.aliseon.ott.Aliseon.mydetail_list_subscribeto_cnt;
//import static com.aliseon.ott.Aliseon.mydetailapiload;
//import static com.aliseon.ott.activity.MyDetailActivity.myactivitydetailhandler;
//
//public class NetworkTaskMySubscribeTo extends AsyncTask<Void, Void, String> {
//
//    private static String TAG = "팔로우";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskMySubscribeTo(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionMySubscribeTo requesthttpurlconnectionmysubscribeto = new RequestHttpURLConnectionMySubscribeTo();
//        result = requesthttpurlconnectionmysubscribeto.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//    }
//
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        String my_subscribefrom_list = s;
//
//        if (s != null) {
//            try {
//                JSONObject jo_my_subscribefrom = new JSONObject(my_subscribefrom_list);
//                String list = jo_my_subscribefrom.getString("list");
//
//                Log.d("myTo" , "myTo 오리지날 리스트>>" + list);
//
//                JSONArray ja_my_subscribefrom = new JSONArray(list);
//                Log.d("myTo" , "myTo  리스트>>" + ja_my_subscribefrom);
//
//                for (int i = 0; i < ja_my_subscribefrom.length(); i++) {
//                    JSONObject jo_my_subscribefrom_value = ja_my_subscribefrom.getJSONObject(i);
//
//                    int id = jo_my_subscribefrom_value.getInt("id");
//                    String nickname = jo_my_subscribefrom_value.getString("nickname");
//                    String photo = jo_my_subscribefrom_value.getString("photo");
//                    int subscribeto_cnt = jo_my_subscribefrom_value.getInt("subscribeto_cnt");
//                    int contents_cnt = jo_my_subscribefrom_value.getInt("contents_cnt");
//
//                    mydetail_list_id.add(id);
//                    mydetail_list_nickname.add(nickname);
//                    mydetail_list_photo.add(photo);
//                    mydetail_list_subscribeto_cnt.add(subscribeto_cnt);
//                    mydetail_list_contents_cnt.add(contents_cnt);
//
//                    Log.d("myTo" ,"구독list 정보 >>" + id + " / " + nickname + " / " + photo + " / " + subscribeto_cnt + " / " + contents_cnt);
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        if(mydetailapiload == 0){
//
//            mydetailapiload = 1;
//            myactivitydetailhandler.sendEmptyMessage(1000);
//
//        } else if(mydetailapiload == 1){
//            myactivitydetailhandler.sendEmptyMessage(800);
//        }
//
//    }
//}