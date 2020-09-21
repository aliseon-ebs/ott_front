package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottSubscribeVoyage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.aliseon.ott.Variable.subscribe_voyage_list_c_thumbnail;
import static com.aliseon.ott.activity.SubscribeActivity.subscribeactivityhandler;
import static com.aliseon.ott.Variable.subscribe_voyage_list_category_en;
import static com.aliseon.ott.Variable.subscribe_voyage_list_category_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_category_kr;
import static com.aliseon.ott.Variable.subscribe_voyage_list_comment_count;
import static com.aliseon.ott.Variable.subscribe_voyage_list_contents_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_contents_type;
import static com.aliseon.ott.Variable.subscribe_voyage_list_create_at;
import static com.aliseon.ott.Variable.subscribe_voyage_list_description;
import static com.aliseon.ott.Variable.subscribe_voyage_list_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_like_count;
import static com.aliseon.ott.Variable.subscribe_voyage_list_name;
import static com.aliseon.ott.Variable.subscribe_voyage_list_p_thumbnail;
import static com.aliseon.ott.Variable.subscribe_voyage_list_photo;
import static com.aliseon.ott.Variable.subscribe_voyage_list_product_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_status;
import static com.aliseon.ott.Variable.subscribe_voyage_list_update_at;
import static com.aliseon.ott.Variable.subscribe_voyage_list_user_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_view_count;
import static com.aliseon.ott.Variable.subscribeapiload;
import static com.aliseon.ott.Variable.subscribefocusapiload;

public class NetworkTaskTvottSubscribeVoyage extends AsyncTask<Void, Void, String> {


    private static String TAG = "구독 크리에이터 출력";
    private static String TAG2 = "피드 변환 배열 출력";

    private String url;
    private ContentValues values;

    public NetworkTaskTvottSubscribeVoyage(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionTvottSubscribeVoyage requestHttpURLConnectiontvottvoyageSubscribe = new RequestHttpURLConnectionTvottSubscribeVoyage();
        result = requestHttpURLConnectiontvottvoyageSubscribe.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String voyage = s;

        if (voyage != null) {
            try {

                JSONObject jo_voyage_total = new JSONObject(voyage);
                String voyage_list = jo_voyage_total.getString("list");
                JSONArray ja_voyage_list = new JSONArray(voyage_list);

                for (int i = 0; i < ja_voyage_list.length(); i++) {
                    JSONObject jo_voyage = ja_voyage_list.getJSONObject(i);

                    subscribe_voyage_list_c_thumbnail = new ArrayList<>();

                    String id = jo_voyage.getString("id");
                    String user_id = jo_voyage.getString("user_id");
                    String product_id = jo_voyage.getString("product_id");
                    String contents_id = jo_voyage.getString("contents_id");
                    String contents_type = jo_voyage.getString("contents_type");
                    String category_id = jo_voyage.getString("category_id");
                    int status = jo_voyage.getInt("status");
                    String description = jo_voyage.getString("description");
                    String create_at = jo_voyage.getString("create_at");
                    String update_at = jo_voyage.getString("update_at");
                    int like_count = jo_voyage.getInt("like_count");
                    int view_count = jo_voyage.getInt("view_count");
                    int comment_count = jo_voyage.getInt("comment_count");
                    String category_en = jo_voyage.getString("category_en");
                    String category_kr = jo_voyage.getString("category_ko");
                    String name = jo_voyage.getString("name");
                    String photo = jo_voyage.getString("photo");
                    String thumbnail = jo_voyage.getString("thumbnail");

                    subscribe_voyage_list_id.add(id);
                    subscribe_voyage_list_user_id.add(user_id);
                    subscribe_voyage_list_product_id.add(product_id);
                    subscribe_voyage_list_contents_id.add(contents_id);
                    subscribe_voyage_list_contents_type.add(contents_type);
                    subscribe_voyage_list_category_id.add(category_id);
                    subscribe_voyage_list_status.add(status);
                    subscribe_voyage_list_create_at.add(create_at);
                    subscribe_voyage_list_update_at.add(update_at);
                    subscribe_voyage_list_like_count.add(like_count);
                    subscribe_voyage_list_view_count.add(view_count);
                    subscribe_voyage_list_comment_count.add(comment_count);
                    subscribe_voyage_list_category_en.add(category_en);
                    subscribe_voyage_list_category_kr.add(category_kr);
                    subscribe_voyage_list_name.add(name);
                    subscribe_voyage_list_photo.add(photo);

                    if (description.length() > 25) {
                        subscribe_voyage_list_description.add(description.substring(0, 25) + "...");
                    } else {
                        subscribe_voyage_list_description.add(description);
                    }

                    try {

                        thumbnail = thumbnail.replace("\\", "");
                        thumbnail = thumbnail.replace("\"", "");
                        thumbnail = thumbnail.replace("[", "");
                        thumbnail = thumbnail.replace("]", "");

                        String[] thumbnail_result = thumbnail.split(",");

                        for (int ii = 0; ii < thumbnail_result.length; ii++) {

                            subscribe_voyage_list_c_thumbnail.add(thumbnail_result[ii]);

                        }

                        subscribe_voyage_list_p_thumbnail.add(subscribe_voyage_list_c_thumbnail);

//                      throw new Exception(); //강제 에러 출력
                    } catch (Exception e) {

                      subscribe_voyage_list_p_thumbnail.add(subscribe_voyage_list_c_thumbnail);

                    }

                    Log.d(TAG, "자바로 가공한 voyage0 리스트>>" + id + "/" + user_id + "/" + product_id + "/" + contents_id + "/" + contents_type + "/" + category_id + "/" + status + "/" + description + "/" + create_at
                            + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + category_en + "/" + category_kr + "/" + name + "/" + photo + "/" + thumbnail);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            if(subscribeapiload == 0 && subscribefocusapiload == 0) {

                subscribeapiload = 1;
                subscribeactivityhandler.sendEmptyMessage(1000);

            } else if(subscribeapiload == 0 && subscribefocusapiload == 1) {

                subscribeactivityhandler.sendEmptyMessage(1000);

            } else if(subscribeapiload == 1 && subscribefocusapiload == 0) {

            subscribeactivityhandler.sendEmptyMessage(1000);

            } else if(subscribeapiload == 1 && subscribefocusapiload == 1) {

                subscribeactivityhandler.sendEmptyMessage(1000);

            }

        }

    }
}