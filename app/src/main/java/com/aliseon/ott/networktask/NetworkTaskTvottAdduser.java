package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottAdduser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.Variable.countrycode;
import static com.aliseon.ott.activity.AccountAddActivity.AccountAddmHandler;
import static com.aliseon.ott.activity.InfoCheckActivity.InfocheckmHandler;
import static com.aliseon.ott.Variable.adduserapiload;
import static com.aliseon.ott.Variable.userinfo;
import static com.aliseon.ott.Variable.userinfouid;
import static com.aliseon.ott.activity.LoadingActivity.setDataUserinfo;


public class NetworkTaskTvottAdduser extends AsyncTask<Void, Void, String> {

    private static String TAG2 = "자바로 가공한 사용자 배열 정보 가져오기";
    private static String TAG3 = "가져온 데이터 ArrayList에 넣기";

    private static String TAG = "유저 추가하기 True & False";

    private String url;
    private ContentValues values;

    public NetworkTaskTvottAdduser(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionTvottAdduser requestHttpURLConnectiontvottadduser = new RequestHttpURLConnectionTvottAdduser();
        result = requestHttpURLConnectiontvottadduser.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String userinfoarraylist = s;

        Log.d(TAG, "사용자정보 배열 >>" + s);

        userinfo.clear();
        userinfouid.clear();

        if (s != null) {
            try {
                JSONObject jo_data = new JSONObject(userinfoarraylist);
                String list = jo_data.getString("list");

                JSONArray ja_list = new JSONArray(list);

                Log.d("FROMUUPHONE", ja_list.toString());

                for (int i = 0; i < ja_list.length(); i++) {
                    JSONObject jobject = ja_list.getJSONObject(i);

                    int id = jobject.getInt("id");
                    String name = jobject.getString("name");
                    String photo = jobject.getString("photo");
                    String language = jobject.getString("language");
                    String country = jobject.getString("country");
                    String currency = jobject.getString("currency");

                    Log.d(TAG2, "자바로 가공한 사용자정보 배열 리스트>> " + id + " | " + name + " | " + photo + " | " + language + " | " + country + " | " + currency);

                    switch (i){
                        case 0 :
                            userinfouid.add(0,id);
                            userinfo.add(0,name);
                            userinfo.add(1,photo);
                            userinfo.add(2,language);
                            userinfo.add(3,country);
                            userinfo.add(4,currency);
                            Log.d(TAG3, "Arraylist  uid1  현황>>"  + userinfouid.get(0));
                            Log.d(TAG3, "Arraylist info1234 현황>>"  + userinfo.get(0)+ " | " + userinfo.get(1) + " | " + userinfo.get(2) + " | " + userinfo.get(3) + " | " + userinfo.get(4));
                            break;
                        case 1 :
                            userinfouid.add(1,id);
                            userinfo.add(5,name);
                            userinfo.add(6,photo);
                            userinfo.add(7,language);
                            userinfo.add(8,country);
                            userinfo.add(9,currency);
                            Log.d(TAG3, "Arraylist  uid2  현황>>"  + userinfouid.get(1));
                            Log.d(TAG3, "Arraylist info5678 현황>>"  + userinfo.get(5)+ " | " + userinfo.get(6) + " | " + userinfo.get(7) + " | " + userinfo.get(8) + " | " + userinfo.get(9));
                            break;
                        case 2:
                            userinfouid.add(2,id);
                            userinfo.add(10,name);
                            userinfo.add(11,photo);
                            userinfo.add(12,language);
                            userinfo.add(13,country);
                            userinfo.add(14,currency);
                            Log.d(TAG3, "Arraylist  uid3  현황>>"  + userinfouid.get(2));
                            Log.d(TAG3, "Arraylist info9101112 현황>>"  + userinfo.get(10)+ " | " + userinfo.get(11) + " | " + userinfo.get(12) + " | " + userinfo.get(13) + " | " + userinfo.get(14));
                            break;
                    }

                }

            } catch(JSONException e){
                e.printStackTrace();
            }

        }

        if(adduserapiload == 0) {

            setDataUserinfo();

            adduserapiload = 1;
            InfocheckmHandler.sendEmptyMessage(1000);

        } else {

            AccountAddmHandler.sendEmptyMessage(1000);

        }
        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.

    }
}