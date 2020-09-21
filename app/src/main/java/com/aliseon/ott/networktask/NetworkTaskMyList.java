package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionMyList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.aliseon.ott.Variable.my_list_c_thumbnail;
import static com.aliseon.ott.Variable.my_list_nickname;
import static com.aliseon.ott.Variable.my_list_p_thumbnail;
import static com.aliseon.ott.Variable.my_list_comment_count;
import static com.aliseon.ott.Variable.my_list_create_at;
import static com.aliseon.ott.Variable.my_list_description;
import static com.aliseon.ott.Variable.my_list_id;
import static com.aliseon.ott.Variable.my_list_like_count;
import static com.aliseon.ott.Variable.my_list_profile;
import static com.aliseon.ott.Variable.my_list_status;
import static com.aliseon.ott.Variable.my_list_update_at;
import static com.aliseon.ott.Variable.my_list_user_id;
import static com.aliseon.ott.Variable.my_list_view_count;
import static com.aliseon.ott.Variable.myapiload;
import static com.aliseon.ott.activity.MyActivity.myactivitycontentsloadinghandler;
import static com.aliseon.ott.activity.MyActivity.myactivityhandler;

public class NetworkTaskMyList extends AsyncTask<Void, Void, String> {

    private static String TAG = "구독 크리에이터 출력";
    private static String TAG2 = "피드 변환 배열 출력";

    private String url;
    private ContentValues values;

    public NetworkTaskMyList(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionMyList requestHttpURLConnectionmylist = new RequestHttpURLConnectionMyList();
        result = requestHttpURLConnectionmylist.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

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

                    my_list_c_thumbnail = new ArrayList<>();

                    String id = jo_my_list.getString("id");
                    String user_id = jo_my_list.getString("user_id");
                    int status = jo_my_list.getInt("status");
                    String description = jo_my_list.getString("description");
                    String create_at = jo_my_list.getString("create_at");
                    String update_at = jo_my_list.getString("update_at");
                    int like_count = jo_my_list.getInt("like_count");
                    int view_count = jo_my_list.getInt("view_count");
                    int comment_count = jo_my_list.getInt("comment_count");
                    String nickname = jo_my_list.getString("nickname");
                    String profile = jo_my_list.getString("profile");
                    String thumbnail = jo_my_list.getString("thumbnail");

                    my_list_id.add(id);
                    my_list_user_id.add(user_id);
                    my_list_status.add(status);
                    my_list_create_at.add(create_at);
                    my_list_update_at.add(update_at);
                    my_list_like_count.add(like_count);
                    my_list_view_count.add(view_count);
                    my_list_comment_count.add(comment_count);
                    my_list_nickname.add(nickname);
                    my_list_profile.add(profile);

                    if(description.length() > 25){
                        my_list_description.add(description.substring(0,25) + "...");
                    } else {
                        my_list_description.add(description);
                    }

                    try{

                        Log.d(TAG, "내 영상 ori 썸네일>>" + thumbnail);

                        thumbnail = thumbnail.replace("\\","");
                        thumbnail = thumbnail.replace("\"","");
                        thumbnail = thumbnail.replace("[","");
                        thumbnail = thumbnail.replace("]","");

                        String[] thumbnail_result = thumbnail.split(",");

                        for(int ii = 0; ii < thumbnail_result.length; ii++) {

                            my_list_c_thumbnail.add(thumbnail_result[ii]);

                        }

                        my_list_p_thumbnail.add(my_list_c_thumbnail);

                    }catch (Exception e){

                        my_list_p_thumbnail.add(my_list_c_thumbnail);

                    }

                    Log.d(TAG, "내 영상 리스트>>" + id + "/" + user_id + "/" + status + "/" + create_at + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + profile + "/" + thumbnail);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            if(myapiload == 0){

                myapiload = 1;
                myactivityhandler.sendEmptyMessage(1000);

            } else if(myapiload == 1){

                myactivitycontentsloadinghandler.sendEmptyMessage(1000);

            }

        }

    }

}
