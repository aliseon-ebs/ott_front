//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionCreatorInfo;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static com.aliseon.ott.Aliseon.api_my_list;
//import static com.aliseon.ott.Aliseon.creatorapiload;
//import static com.aliseon.ott.Aliseon.creator_id;
//import static com.aliseon.ott.Aliseon.creator_nickname;
//import static com.aliseon.ott.Aliseon.creator_photo;
//import static com.aliseon.ott.Aliseon.creator_zip;
//import static com.aliseon.ott.Aliseon.creator_city;
//import static com.aliseon.ott.Aliseon.creator_state;
//import static com.aliseon.ott.Aliseon.creator_address;
//import static com.aliseon.ott.Aliseon.creator_subscribeto_cnt;
//import static com.aliseon.ott.Aliseon.creator_contents_cnt;
//import static com.aliseon.ott.Aliseon.creator_desc;
//import static com.aliseon.ott.activity.CreatorActivity.creatoractivityhandler;
//
//public class NetworkTaskCreatorInfo extends AsyncTask<Void, Void, String> {
//
//    private static String TAG = "채널 정보 가져오기";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskCreatorInfo(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionCreatorInfo requestHttpURLConnectioncreatorinfo = new RequestHttpURLConnectionCreatorInfo();
//        result = requestHttpURLConnectioncreatorinfo.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
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
//                JSONObject jo_creator_info_total = new JSONObject(my_info);
//                String creator_info_list = jo_creator_info_total.getString("list");
//                JSONArray ja_creator_info_list = new JSONArray(creator_info_list);
//                JSONObject jo_creator_info = ja_creator_info_list.getJSONObject(0);
//
//                int id = jo_creator_info.getInt("id");
//                String name = jo_creator_info.getString("nickname");
//                String photo = jo_creator_info.getString("photo");
//                String zip = jo_creator_info.getString("zip");
//                String city = jo_creator_info.getString("city");
//                String state = jo_creator_info.getString("state");
//                String address = jo_creator_info.getString("address");
//                int subscribeto_cnt = jo_creator_info.getInt("subscribeto_cnt");
//                int contents_cnt = jo_creator_info.getInt("contents_cnt");
//                String desc = jo_creator_info.getString("desc");
//
//                creator_id = id;
//                creator_nickname = name;
//                creator_photo = photo;
//                creator_zip = zip;
//                creator_city = city;
//                creator_state = state;
//                creator_address = address;
//                creator_subscribeto_cnt = subscribeto_cnt;
//                creator_contents_cnt = contents_cnt;
//                creator_desc = desc;
//
//                Log.d(TAG, "자바로 가공한 크리에이터 정보 리스트>>" + id + "/" + name + "/" + photo + "/" + zip + "/" + city + "/" + state + "/" + address + "/" + subscribeto_cnt + "/" + contents_cnt + "/" + desc);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        if(creatorapiload == 0){
//
//            NetworkTaskCreatorList networktaskcreatorlist = new NetworkTaskCreatorList(api_my_list, null);
//            networktaskcreatorlist.execute();
//
//        } else if(creatorapiload == 1){
//            creatoractivityhandler.sendEmptyMessage(800);
//        }
//
//    }
//}