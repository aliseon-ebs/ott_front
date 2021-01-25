//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionMyInfo;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static com.aliseon.ott.Aliseon.api_my_list;
//import static com.aliseon.ott.Aliseon.my_id;
//import static com.aliseon.ott.Aliseon.my_nickname;
//import static com.aliseon.ott.Aliseon.my_photo;
//import static com.aliseon.ott.Aliseon.my_zip;
//import static com.aliseon.ott.Aliseon.my_city;
//import static com.aliseon.ott.Aliseon.my_state;
//import static com.aliseon.ott.Aliseon.my_address;
//import static com.aliseon.ott.Aliseon.my_subscribeto_cnt;
//import static com.aliseon.ott.Aliseon.my_contents_cnt;
//import static com.aliseon.ott.Aliseon.my_desc;
//import static com.aliseon.ott.activity.MyActivity.myactivityhandler;
//import static com.aliseon.ott.Aliseon.myapiload;
//
//public class NetworkTaskMyInfo extends AsyncTask<Void, Void, String> {
//
//    private static String TAG = "채널 정보 가져오기";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskMyInfo(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionMyInfo requestHttpURLConnectionchannelsinfo = new RequestHttpURLConnectionMyInfo();
//        result = requestHttpURLConnectionchannelsinfo.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//    }
//
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        String my_info = s;
//
//        if (s != null) {
//            try {
//
//                JSONObject jo_my_info_total = new JSONObject(my_info);
//                String my_info_list = jo_my_info_total.getString("list");
//                JSONArray ja_my_info_list = new JSONArray(my_info_list);
//                JSONObject jo_my_info = ja_my_info_list.getJSONObject(0);
//
//                String id = jo_my_info.getString("id");
//                String nickname = jo_my_info.getString("nickname");
//                String photo = jo_my_info.getString("photo");
//                String zip = jo_my_info.getString("zip");
//                String city = jo_my_info.getString("city");
//                String state = jo_my_info.getString("state");
//                String address = jo_my_info.getString("address");
//                String subscribeto_cnt = jo_my_info.getString("subscribeto_cnt");
//                String contents_cnt = jo_my_info.getString("contents_cnt");
//                String desc = jo_my_info.getString("desc");
//
//                my_id = id;
//                my_nickname = nickname;
//                my_photo = photo;
//                my_zip = zip;
//                my_city = city;
//                my_state = state;
//                my_address = address;
//                my_subscribeto_cnt = subscribeto_cnt;
//                my_contents_cnt = contents_cnt;
//                my_desc = desc;
//
//                Log.d(TAG, "자바로 가공한 내정보 리스트>>" + id + "/" + nickname + "/" + photo + "/" + zip + "/" + city + "/" + state + "/" + address + "/" + subscribeto_cnt + "/" + contents_cnt + "/" + desc);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        if(myapiload == 0){
//
//            NetworkTaskMyList networktaskmylist = new NetworkTaskMyList(api_my_list, null);
//            networktaskmylist.execute();
//
//        } else if(myapiload == 1){
//            myactivityhandler.sendEmptyMessage(800);
//        }
//
//    }
//}