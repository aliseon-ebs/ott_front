package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottPopular;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.aliseon.ott.activity.HomeActivity.homeactivitypopularhandler;
import static com.aliseon.ott.activity.HomeDetailActivity.homeactivitydetailcontentsloadinghandler;
import static com.aliseon.ott.Variable.homeapiload;
import static com.aliseon.ott.Variable.popular_c_thumbnail;
import static com.aliseon.ott.Variable.popular_category_en;
import static com.aliseon.ott.Variable.popular_category_id;
import static com.aliseon.ott.Variable.popular_category_kr;
import static com.aliseon.ott.Variable.popular_comment_count;
import static com.aliseon.ott.Variable.popular_contents_id;
import static com.aliseon.ott.Variable.popular_contents_type;
import static com.aliseon.ott.Variable.popular_create_at;
import static com.aliseon.ott.Variable.popular_description;
import static com.aliseon.ott.Variable.popular_id;
import static com.aliseon.ott.Variable.popular_like_count;
import static com.aliseon.ott.Variable.popular_nickname;
import static com.aliseon.ott.Variable.popular_p_thumbnail;
import static com.aliseon.ott.Variable.popular_photo;
import static com.aliseon.ott.Variable.popular_product_id;
import static com.aliseon.ott.Variable.popular_status;
import static com.aliseon.ott.Variable.popular_update_at;
import static com.aliseon.ott.Variable.popular_user_id;
import static com.aliseon.ott.Variable.popular_view_count;

public class NetworkTaskTvottPopular extends AsyncTask<Void, Void, String> {

    private static String TAG = "인기동영상";

    private String url;
    private ContentValues values;

    public NetworkTaskTvottPopular(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionTvottPopular requestHttpURLConnectiontvottpopular = new RequestHttpURLConnectionTvottPopular();
        result = requestHttpURLConnectiontvottpopular.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s != null) {
            try {

                JSONObject jo_popular_total = new JSONObject(s);
                String popular_list = jo_popular_total.getString("list");
                JSONArray ja_popular_list = new JSONArray(popular_list);

                for (int i = 0; i < ja_popular_list.length(); i++) {
                    JSONObject jo_popular = ja_popular_list.getJSONObject(i);

                    popular_c_thumbnail = new ArrayList<>();

                    String id = jo_popular.getString("id");
                    String user_id = jo_popular.getString("user_id");
                    String product_id = jo_popular.getString("product_id");
                    String contents_id = jo_popular.getString("contents_id");
                    String contents_type = jo_popular.getString("contents_type");
                    String category_id = jo_popular.getString("category_id");
                    int status = jo_popular.getInt("status");
                    String description = jo_popular.getString("description");
                    String create_at = jo_popular.getString("create_at");
                    String update_at = jo_popular.getString("update_at");
                    int like_count = jo_popular.getInt("like_count");
                    int view_count = jo_popular.getInt("view_count");
                    int comment_count = jo_popular.getInt("comment_count");
                    String category_en = jo_popular.getString("category_en");
                    String category_kr = jo_popular.getString("category_ko");
                    String nickname = jo_popular.getString("nickname");
                    String photo = jo_popular.getString("photo");
                    String thumbnail = jo_popular.getString("thumbnail");


                    popular_id.add(id);
                    popular_user_id.add(user_id);
                    popular_product_id.add(product_id);
                    popular_contents_id.add(contents_id);
                    popular_contents_type.add(contents_type);
                    popular_category_id.add(category_id);
                    popular_status.add(status);
                    popular_create_at.add(create_at);
                    popular_update_at.add(update_at);
                    popular_like_count.add(like_count);
                    popular_view_count.add(view_count);
                    popular_comment_count.add(comment_count);
                    popular_category_en.add(category_en);
                    popular_category_kr.add(category_kr);
                    popular_nickname.add(nickname);
                    popular_photo.add(photo);

                    if(description.length() > 25){
                        popular_description.add(description.substring(0,25) + "...");
                    } else {
                        popular_description.add(description);
                    }

                    try{

                        thumbnail = thumbnail.replace("\\","");
                        thumbnail = thumbnail.replace("\"","");
                        thumbnail = thumbnail.replace("[","");
                        thumbnail = thumbnail.replace("]","");

                        String[] thumbnail_result = thumbnail.split(",");

                        for(int ii = 0; ii < thumbnail_result.length; ii++) {

                            popular_c_thumbnail.add(thumbnail_result[ii]);

                        }

                        popular_p_thumbnail.add(popular_c_thumbnail);

//                      throw new Exception(); //강제 에러 출력
                    }catch (Exception e){

                        popular_p_thumbnail.add(popular_c_thumbnail);

                    }

                    Log.d(TAG, "자바로 가공한 인기동영상 리스트>>" + id + "/" + user_id + "/" + product_id + "/" + contents_id + "/" + contents_type + "/" + category_id + "/" + status + "/" + description + "/" + create_at
                            + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + category_en + "/" + category_kr + "/" + nickname + "/" + photo + "/" + thumbnail);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            if(homeapiload == 0){
                homeapiload = 1;
                homeactivitypopularhandler.sendEmptyMessage(1000);
            } else if(homeapiload == 1){
                homeactivitypopularhandler.sendEmptyMessage(800);
                homeactivitydetailcontentsloadinghandler.sendEmptyMessage(1000);
            }

        }
    }
}

