//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionUserPhone;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static com.aliseon.ott.activity.AccountDisconnect3Activity.Disconnect3mHandler;
//import static com.aliseon.ott.Aliseon.api_tvott_deluser;
//import static com.aliseon.ott.Aliseon.infocheck_id;
//import static com.aliseon.ott.Aliseon.myuid;
//
//
//public class NetworkTaskUserPhoneCheckDisconnect3 extends AsyncTask<Void, Void, String> {
//
//    private static String TAG = "ID 부여";
//
//    private String url;
//    private ContentValues values;
//
//
//
//
//
//    public NetworkTaskUserPhoneCheckDisconnect3(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionUserPhone requestHttpURLConnectionuserphone = new RequestHttpURLConnectionUserPhone();
//        result = requestHttpURLConnectionuserphone.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        String userinfolist = s;
//
//        if (s != null) {
//            try {
//                JSONObject jo_data = new JSONObject(userinfolist);
//
//                String status = jo_data.getString("status");
//                String list = jo_data.getString("list");
//
//                JSONArray ja_list = new JSONArray(list);
//
//                JSONObject jo_id = ja_list.getJSONObject(0);
//                int id = jo_id.getInt("id");
//
//                infocheck_id = id;
//                Log.d(TAG, "부여받은 ID >>" + id);
//
//            } catch (JSONException e) {
//
//            }
//
//        }
//
//        if(infocheck_id != myuid){
//            Disconnect3mHandler.sendEmptyMessage(800);
//        } else {
//            NetworkTaskTvottDeluser3 networkTasktvottdeluser3 = new NetworkTaskTvottDeluser3(api_tvott_deluser, null);
//            networkTasktvottdeluser3.execute();
//        }
//        infocheck_id = -1;
//        myuid = -2;
//
//        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
//
//    }
//
//
//}
