//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionAuth;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static com.aliseon.ott.Aliseon.access_token;
//import static com.aliseon.ott.Aliseon.api_tvott_users;
//
//
//public class NetworkTaskAuth extends AsyncTask<Void, Void, String> {
//
//    private static String TAG = "토큰 정보 가져오기";
//    private static String TAG2 = "자바로 가공한 토큰 정보 가져오기";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskAuth(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionAuth requestHttpURLConnectionauth = new RequestHttpURLConnectionAuth();
//        result = requestHttpURLConnectionauth.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//    }
//
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//        access_token = s;
//
//
//        if (access_token != null) {
//            try {
//
//                JSONObject jsonObject = new JSONObject(access_token);
//                String status = jsonObject.getString("status");
//                String list = jsonObject.getString("list");
//
//                Log.d(TAG, "auth status>>" + status);
//                Log.d(TAG, "auth list>>" + list);
//
//                JSONArray jarray = new JSONArray(list);
//
//                JSONObject jsonObject2 = jarray.getJSONObject(0);
//
//                String id = jsonObject2.getString("access_token");
//
//                Log.d(TAG2, "자바로 가공한 카테고리 리스트>>" + id);
//
//                access_token = id;
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        NetworkTaskTvottUsers networkTasktvottusers = new NetworkTaskTvottUsers(api_tvott_users, null);
//        networkTasktvottusers.execute();
//
//    }
//}