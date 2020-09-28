package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionUserPhone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.activity.InfoCheckActivity.InfocheckmHandler;
import static com.aliseon.ott.Variable.api_tvott_users_add;
import static com.aliseon.ott.Variable.infocheck_id;


public class NetworkTaskUserPhone extends AsyncTask<Void, Void, String> {

    private static String TAG = "ID 부여";

    private String url;
    private ContentValues values;





    public NetworkTaskUserPhone (String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionUserPhone requestHttpURLConnectionuserphone = new RequestHttpURLConnectionUserPhone();
        result = requestHttpURLConnectionuserphone.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String userinfolist = s;

        Log.d(TAG, "부여받은 ID >>" + s);

        if (s != null) {
            try {
                JSONObject jo_data = new JSONObject(userinfolist);

                String list = jo_data.getString("list");

                JSONArray ja_list = new JSONArray(list);

                JSONObject jo_id = ja_list.getJSONObject(0);
                int id = jo_id.getInt("id");

                infocheck_id = id;
                Log.d(TAG, "부여받은 ID >>" + id);

            } catch (JSONException e) {

            }

        }

        if(s == null || s.contains("false") ){
            InfocheckmHandler.sendEmptyMessage(800);
        } else{
            NetworkTaskTvottAdduser networkTasktvottadduser = new NetworkTaskTvottAdduser(api_tvott_users_add, null);
            networkTasktvottadduser.execute();
        }
    }


}
