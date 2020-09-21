package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.activity.LoadingActivity;
import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottDeluser3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.activity.AccountDisconnect3Activity.Disconnect3mHandler;
import static com.aliseon.ott.activity.LoadingActivity.CheckUsedUserDisconnect3;
import static com.aliseon.ott.Variable.userinfo;
import static com.aliseon.ott.Variable.userinfouid;

public class NetworkTaskTvottDeluser3 extends AsyncTask<Void, Void, String> {

    private static String TAG = "배열 정보 가져오기";
    private static String TAG2 = "자바로 가공한 사용자 배열 정보 가져오기";
    private static String TAG3 = "가져온 데이터 ArrayList에 넣기";

    private String url;
    private ContentValues values;

    public NetworkTaskTvottDeluser3(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionTvottDeluser3 requestHttpURLConnectiontvottdeluser3 = new RequestHttpURLConnectionTvottDeluser3();
        result = requestHttpURLConnectiontvottdeluser3.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String userinfoarraylist = s;

        Log.d(TAG, "사용자정보 배열 >>" + s);

        CheckUsedUserDisconnect3();

        userinfo.clear();
        userinfouid.clear();

        if (s != null) {
            try {
                JSONObject jo_user_del_total = new JSONObject(s);
                String jo_user_del_list = jo_user_del_total.getString("list");
                JSONArray ja_del_list = new JSONArray(jo_user_del_list);

                for (int i = 0; i < ja_del_list.length(); i++) {
                    JSONObject jobject = ja_del_list.getJSONObject(i);

                    int id = jobject.getInt("id");
                    String name = jobject.getString("name");
                    String photo = jobject.getString("photo");
                    String ott_language = jobject.getString("ott_language");
                    String ott_country = jobject.getString("ott_country");
                    String ott_currency = jobject.getString("ott_currency");

                    Log.d(TAG2, "자바로 가공한 사용자정보 배열 리스트>> " + id + " | " + name + " | " + photo + " | " + ott_language + " | " + ott_country + " | " + ott_currency);

                    switch (i){
                        case 0 :
                            userinfouid.add(0,id);
                            userinfo.add(0,name);
                            userinfo.add(1,photo);
                            userinfo.add(2,ott_language);
                            userinfo.add(3,ott_country);
                            userinfo.add(4,ott_currency);
                            Log.d(TAG3, "Arraylist  uid1  현황>>"  + userinfouid.get(0));
                            Log.d(TAG3, "Arraylist info1234 현황>>"  + userinfo.get(0)+ " | " + userinfo.get(1) + " | " + userinfo.get(2) + " | " + userinfo.get(3) + " | " + userinfo.get(4));
                            break;
                        case 1 :
                            userinfouid.add(1,id);
                            userinfo.add(5,name);
                            userinfo.add(6,photo);
                            userinfo.add(7,ott_language);
                            userinfo.add(8,ott_country);
                            userinfo.add(9,ott_currency);
                            Log.d(TAG3, "Arraylist  uid2  현황>>"  + userinfouid.get(1));
                            Log.d(TAG3, "Arraylist info5678 현황>>"  + userinfo.get(5)+ " | " + userinfo.get(6) + " | " + userinfo.get(7) + " | " + userinfo.get(8) + " | " + userinfo.get(9));
                            break;
                        case 2:
                            userinfouid.add(2,id);
                            userinfo.add(10,name);
                            userinfo.add(11,photo);
                            userinfo.add(12,ott_language);
                            userinfo.add(13,ott_country);
                            userinfo.add(14,ott_currency);
                            Log.d(TAG3, "Arraylist  uid3  현황>>"  + userinfouid.get(2));
                            Log.d(TAG3, "Arraylist info9101112 현황>>"  + userinfo.get(10)+ " | " + userinfo.get(11) + " | " + userinfo.get(12) + " | " + userinfo.get(13) + " | " + userinfo.get(14));
                            break;
                    }

                }

            } catch(JSONException e){
                e.printStackTrace();
            }
        } else{

        }
        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.

//        CheckUsedUserDisconnect3();

        if(LoadingActivity.pref.getBoolean("selectaccount", true) == false){
            Disconnect3mHandler.sendEmptyMessage(600);
        } else {
            Disconnect3mHandler.sendEmptyMessage(1000);
        }

    }
}
