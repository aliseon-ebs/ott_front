package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionRecommendCreator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.Variable.api_voyage;
import static com.aliseon.ott.Variable.recommend_contents_cnt;
import static com.aliseon.ott.Variable.recommend_subscribeto_cnt;
import static com.aliseon.ott.Variable.recommend_id;
import static com.aliseon.ott.Variable.recommend_nickname;
import static com.aliseon.ott.Variable.recommend_photo;
import static com.aliseon.ott.Variable.voyageresultapiload;
import static com.aliseon.ott.activity.VoyageResultActivity.voyageresulthandler;

public class NetworkTaskRecommendCreator extends AsyncTask<Void, Void, String> {

    private static String TAG = "추천";

    private String url;
    private ContentValues values;

    public NetworkTaskRecommendCreator(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionRecommendCreator requesthttpurlconnectionchannels = new RequestHttpURLConnectionRecommendCreator();
        result = requesthttpurlconnectionchannels.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s != null) {
            try {

                JSONObject jo_recommendcreator_total = new JSONObject(s);
                String recommendcreator_list = jo_recommendcreator_total.getString("list");
                JSONArray ja_recommendcreator_list = new JSONArray(recommendcreator_list);

                for (int i = 0; i < ja_recommendcreator_list.length(); i++) {
                    JSONObject jo_recommedcreator = ja_recommendcreator_list.getJSONObject(i);

                    String id = jo_recommedcreator.getString("id");
                    String nickname = jo_recommedcreator.getString("nickname");
                    String photo = jo_recommedcreator.getString("photo");
                    String subscribeto_cnt = jo_recommedcreator.getString("subscribeto_cnt");
                    String contents_cnt = jo_recommedcreator.getString("contents_cnt");

                    recommend_id.add(id);
                    recommend_nickname.add(nickname);
                    recommend_photo.add(photo);
                    recommend_subscribeto_cnt.add(subscribeto_cnt);
                    recommend_contents_cnt.add(contents_cnt);

                    Log.d(TAG, "자바로 가공한 인기동영상 리스트>>" + id + "/" + nickname + "/" + photo + "/" + subscribeto_cnt + "/" + contents_cnt);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        if(voyageresultapiload == 0) {

            NetworkTaskTvottVoyageResult networktasktvottsearchfeedresult = new NetworkTaskTvottVoyageResult(api_voyage, null);
            networktasktvottsearchfeedresult.execute();

        } else {

            voyageresultapiload = 1;
            voyageresulthandler.sendEmptyMessage(1000);

        }

    }
}