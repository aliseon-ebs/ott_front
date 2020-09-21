package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionSubscribeMyList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.aliseon.ott.Variable.subscribe_voyage_list_c_thumbnail;
import static com.aliseon.ott.activity.SubscribeActivity.subscribeactivityhandler;
import static com.aliseon.ott.Variable.subscribe_voyage_list_comment_count;
import static com.aliseon.ott.Variable.subscribe_voyage_list_create_at;
import static com.aliseon.ott.Variable.subscribe_voyage_list_description;
import static com.aliseon.ott.Variable.subscribe_voyage_list_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_like_count;
import static com.aliseon.ott.Variable.subscribe_voyage_list_name;
import static com.aliseon.ott.Variable.subscribe_voyage_list_p_thumbnail;
import static com.aliseon.ott.Variable.subscribe_voyage_list_photo;
import static com.aliseon.ott.Variable.subscribe_voyage_list_status;
import static com.aliseon.ott.Variable.subscribe_voyage_list_update_at;
import static com.aliseon.ott.Variable.subscribe_voyage_list_user_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_view_count;
import static com.aliseon.ott.Variable.subscribeapiload;
import static com.aliseon.ott.Variable.subscribefocusapiload;

public class NetworkTaskSubscribeMyList extends AsyncTask<Void, Void, String> {

    private static String TAG = "구독 크리에이터 출력";
    private static String TAG2 = "피드 변환 배열 출력";

    private String url;
    private ContentValues values;

    public NetworkTaskSubscribeMyList(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionSubscribeMyList requestHttpURLConnectionsubscribemylist = new RequestHttpURLConnectionSubscribeMyList();
        result = requestHttpURLConnectionsubscribemylist.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String original_my_list = s;

        if (s != null) {
            try {

                JSONObject jo_my_list_total = new JSONObject(original_my_list);
                String my_list_list = jo_my_list_total.getString("list");
                JSONArray ja_my_list = new JSONArray(my_list_list);

                for (int i = 0; i < ja_my_list.length(); i++) {
                    JSONObject jo_my_list = ja_my_list.getJSONObject(i);

                    subscribe_voyage_list_c_thumbnail = new ArrayList<>();

                    String id = jo_my_list.getString("id");
                    String user_id = jo_my_list.getString("user_id");
                    int status = jo_my_list.getInt("status");
                    String description = jo_my_list.getString("description");
                    String create_at = jo_my_list.getString("create_at");
                    String update_at = jo_my_list.getString("update_at");
                    int like_count = jo_my_list.getInt("like_count");
                    int view_count = jo_my_list.getInt("view_count");
                    int comment_count = jo_my_list.getInt("comment_count");
                    String name = jo_my_list.getString("name");
                    String profile = jo_my_list.getString("profile");
                    String thumbnail = jo_my_list.getString("thumbnail");

                    subscribe_voyage_list_id.add(id);
                    subscribe_voyage_list_user_id.add(user_id);
                    subscribe_voyage_list_status.add(status);
                    subscribe_voyage_list_create_at.add(create_at);
                    subscribe_voyage_list_update_at.add(update_at);
                    subscribe_voyage_list_like_count.add(like_count);
                    subscribe_voyage_list_view_count.add(view_count);
                    subscribe_voyage_list_comment_count.add(comment_count);
                    subscribe_voyage_list_name.add(name);
                    subscribe_voyage_list_photo.add(profile);

                    if(description.length() > 25){
                        subscribe_voyage_list_description.add(description.substring(0,25) + "...");
                    } else {
                        subscribe_voyage_list_description.add(description);
                    }

                    try{

                        thumbnail = thumbnail.replace("\\","");
                        thumbnail = thumbnail.replace("\"","");
                        thumbnail = thumbnail.replace("[","");
                        thumbnail = thumbnail.replace("]","");

                        Log.d(TAG, "내 영상 result>>" + thumbnail);

                        String[] thumbnail_result = thumbnail.split(",");

                        for(int ii = 0; ii < thumbnail_result.length; ii++) {

                            subscribe_voyage_list_c_thumbnail.add(thumbnail_result[ii]);

                        }

                        subscribe_voyage_list_p_thumbnail.add(subscribe_voyage_list_c_thumbnail);

                    }catch (Exception e){

                        subscribe_voyage_list_p_thumbnail.add(subscribe_voyage_list_c_thumbnail);

                    }

                    Log.d(TAG, "내 영상 리스트>>" + id + "/" + user_id + "/" + status + "/" + create_at + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + profile + "/" + thumbnail);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            if(subscribeapiload == 0 && subscribefocusapiload == 0) {

                subscribeapiload = 1;
                subscribeactivityhandler.sendEmptyMessage(700);

            } else if(subscribeapiload == 0 && subscribefocusapiload == 1) {

                subscribeactivityhandler.sendEmptyMessage(800);

            } else if(subscribeapiload == 1 && subscribefocusapiload == 0) {

                subscribeactivityhandler.sendEmptyMessage(900);

            } else if(subscribeapiload == 1 && subscribefocusapiload == 1) {

                subscribeactivityhandler.sendEmptyMessage(1000);

            }

        }

    }

}
