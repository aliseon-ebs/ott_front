package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionCreatorSubscribeTo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.Variable.creatordetail_list_contents_cnt;
import static com.aliseon.ott.Variable.creatordetail_list_id;
import static com.aliseon.ott.Variable.creatordetail_list_nickname;
import static com.aliseon.ott.Variable.creatordetail_list_photo;
import static com.aliseon.ott.Variable.creatordetail_list_subscribeto_cnt;
import static com.aliseon.ott.Variable.creatordetailapiload;
import static com.aliseon.ott.activity.CreatorDetailActivity.creatoractivitydetailhandler;

public class NetworkTaskCreatorSubscribeTo extends AsyncTask<Void, Void, String> {

    private static String TAG = "팔로우";

    private String url;
    private ContentValues values;

    public NetworkTaskCreatorSubscribeTo(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionCreatorSubscribeTo requesthttpurlconnectioncreatorsubscribeto = new RequestHttpURLConnectionCreatorSubscribeTo();
        result = requesthttpurlconnectioncreatorsubscribeto.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String creator_subscribefrom_list = s;

        if (s != null) {
            try {

                creatordetail_list_id.clear();
                creatordetail_list_nickname.clear();
                creatordetail_list_photo.clear();
                creatordetail_list_subscribeto_cnt.clear();
                creatordetail_list_contents_cnt.clear();

                JSONObject jo_creator_subscribefrom = new JSONObject(creator_subscribefrom_list);
                String list = jo_creator_subscribefrom.getString("list");

                Log.d("CreatorTo" , "CreatorTo 오리지날 리스트>>" + list);

                JSONArray ja_creator_subscribefrom = new JSONArray(list);
                Log.d("CreatorTo" , "CreatorTo  리스트>>" + ja_creator_subscribefrom);

                for (int i = 0; i < ja_creator_subscribefrom.length(); i++) {
                    JSONObject jo_creator_subscribefrom_value = ja_creator_subscribefrom.getJSONObject(i);

                    int id = jo_creator_subscribefrom_value.getInt("id");
                    String nickname = jo_creator_subscribefrom_value.getString("nickname");
                    String photo = jo_creator_subscribefrom_value.getString("photo");
                    int subscribeto_cnt = jo_creator_subscribefrom_value.getInt("subscribeto_cnt");
                    int contents_cnt = jo_creator_subscribefrom_value.getInt("contents_cnt");

                    creatordetail_list_id.add(id);
                    creatordetail_list_nickname.add(nickname);
                    creatordetail_list_photo.add(photo);
                    creatordetail_list_subscribeto_cnt.add(subscribeto_cnt);
                    creatordetail_list_contents_cnt.add(contents_cnt);

                    Log.d("CreatorTo" ,"구독list 정보 >>" + id + " / " + nickname + " / " + photo + " / " + subscribeto_cnt + " / " + contents_cnt);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        if(creatordetailapiload == 0){

            creatordetailapiload = 1;
            creatoractivitydetailhandler.sendEmptyMessage(1000);

        } else if(creatordetailapiload == 1){
            creatoractivitydetailhandler.sendEmptyMessage(800);
        }

    }
}