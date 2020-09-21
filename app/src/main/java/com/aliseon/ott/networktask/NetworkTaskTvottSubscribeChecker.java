package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionMySubscribeFrom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.activity.AliseonOTTPlayerActivity.playercreatorselecthandler;
import static com.aliseon.ott.activity.CreatorActivity.creatoractivityhandler;
import static com.aliseon.ott.activity.CreatorDetailActivity.creatoractivitydetailhandler;
import static com.aliseon.ott.Variable.creatorapiload;
import static com.aliseon.ott.Variable.creatordetailapiload;
import static com.aliseon.ott.Variable.refresh_num;

public class NetworkTaskTvottSubscribeChecker extends AsyncTask<Void, Void, String> {

    private static String TAG = "토큰 정보 가져오기";
    private static String TAG2 = "자바로 가공한 토큰 정보 가져오기";

    private String url;
    private ContentValues values;

    public NetworkTaskTvottSubscribeChecker(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionMySubscribeFrom requesthttpurlconnectiontvottchannel = new RequestHttpURLConnectionMySubscribeFrom();
        result = requesthttpurlconnectiontvottchannel.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String ch_list = s;

        if (s != null) {
            try {
                JSONObject jsonObject = new JSONObject(ch_list);
                ch_list = jsonObject.getString("ch_list");

                Log.d(TAG2, "tvottchecker ch_list >>" + ch_list);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String list = ch_list;
        String feed = s;

        if (ch_list != null) {
            try {
                JSONObject jsonObject = new JSONObject(list);
//                subscribe_num = jsonObject.getInt("num");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (ch_list != null) {
            try {
                JSONObject jsonObject = new JSONObject(list);
                list = jsonObject.getString("list");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (list != null) {
            try {
                JSONArray jarray = new JSONArray(list);

                for (int i = 0; i < list.length(); i++) {
                    JSONObject jobject = jarray.getJSONObject(i);

                    String sbscr_id = jobject.getString("sbscr_id");
                    String seq = jobject.getString("seq");
                    String id = jobject.getString("id");
                    String nickname = jobject.getString("nickname");
                    String picture = jobject.getString("picture");
                    String follower = jobject.getString("follower");
                    String contents_cnt = jobject.getString("contents_cnt");
                    String social_type = jobject.getString("social_type");

                    Log.d(TAG2,"Check list 정보 >>" + sbscr_id + " / " + seq + " / " + id + " / " + nickname + " / " + picture + " / " + follower + " / " + contents_cnt + " / "  + social_type);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        if (ch_list != null) {
            try {
                JSONObject jsonObject = new JSONObject(feed);
                feed = jsonObject.getString("feed");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String feed_list = feed;

        if (feed != null) {
            try {
                JSONObject jsonObject = new JSONObject(feed);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (feed != null) {
            try {
                JSONObject jsonObject = new JSONObject(feed);
                feed_list = jsonObject.getString("list");

                Log.d(TAG, "tvottchecker feedlist >>" + feed_list);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Log.d("refrash_num", "" + refresh_num);
        // 구독 확인 여부는 여러 곳에서 쓰임, 꼬이는 것을 방지하기 위해 스위치문 사용
        switch (refresh_num) {
            case 0:
                if (creatorapiload == 0) {
                    creatorapiload = 1;
                    creatoractivityhandler.sendEmptyMessage(1000);
                    Log.d("resume 탐", "1000");
                } else {
                    creatoractivityhandler.sendEmptyMessage(1000);
                    Log.d("resume 탐", "800");
                }

                break;

            case 1:
                if (creatordetailapiload == 0) {
                    creatordetailapiload = 1;
                    creatoractivitydetailhandler.sendEmptyMessage(1000);
                } else {
                    creatoractivitydetailhandler.sendEmptyMessage(1000);
                }
                break;

            case 2:
                playercreatorselecthandler.sendEmptyMessage(1000);
                break;
        }
    }
}