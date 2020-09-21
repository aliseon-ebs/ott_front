package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionRecommendCreator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.Variable.recommend_contents_cnt;
import static com.aliseon.ott.Variable.recommend_subscribeto_cnt;
import static com.aliseon.ott.Variable.recommend_id;
import static com.aliseon.ott.Variable.recommend_nickname;
import static com.aliseon.ott.Variable.recommend_photo;

public class NetworkTaskPopularChannels extends AsyncTask<Void, Void, String> {

    private static String TAG = "추천";

    private String url;
    private ContentValues values;

    public NetworkTaskPopularChannels(String url, ContentValues values) {

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

        String recommend = s;

        Log.d(TAG, "추천 크리에이터 original >>" + s);

        if (s != null) {
            try {

                JSONArray jarray = new JSONArray(recommend);

                for (int i = 0; i < recommend.length(); i++) {
                    JSONObject jobject = jarray.getJSONObject(i);

                    String id = jobject.getString("id");
                    String nickname = jobject.getString("nickname");
                    String picture = jobject.getString("picture");
                    String follower = jobject.getString("follower");
                    String contents_cnt = jobject.getString("contents_cnt");
                    String subscr_id = jobject.getString("subscr_id");

                    recommend_id.add(id);
                    recommend_nickname.add(nickname);
                    recommend_photo.add(picture);
                    recommend_subscribeto_cnt.add(follower);
                    recommend_contents_cnt.add(contents_cnt);

                    Log.d(TAG, "추천크리에이터 리스트>>" + id + " / " + nickname + " / " + picture + " / " + follower + " / " + contents_cnt + " / " + subscr_id);

                }

            } catch(JSONException e){
                e.printStackTrace();
            }

        }

//        NetworkTaskTvottPopularResult networktasktvottsearchpopularresult = new NetworkTaskTvottPopularResult(api_tvott_popular, null);
//        networktasktvottsearchpopularresult.execute();

    }
}