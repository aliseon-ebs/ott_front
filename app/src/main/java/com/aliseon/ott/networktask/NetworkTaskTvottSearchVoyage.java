package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottSearchVoyage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

import static com.aliseon.ott.Variable.api_category;
import static com.aliseon.ott.Variable.category_num;
import static com.aliseon.ott.Variable.voyageapiload;
import static com.aliseon.ott.Variable.voyagecategoryapiload;
import static com.aliseon.ott.Variable.voyagefocusapiload;
import static com.aliseon.ott.Variable.voyage_category_en;
import static com.aliseon.ott.Variable.voyage_category_id;
import static com.aliseon.ott.Variable.voyage_category_kr;
import static com.aliseon.ott.Variable.voyage_comment_count;
import static com.aliseon.ott.Variable.voyage_contents_id;
import static com.aliseon.ott.Variable.voyage_contents_type;
import static com.aliseon.ott.Variable.voyage_create_at;
import static com.aliseon.ott.Variable.voyage_description;
import static com.aliseon.ott.Variable.voyage_id;
import static com.aliseon.ott.Variable.voyage_like_count;
import static com.aliseon.ott.Variable.voyage_nickname;
import static com.aliseon.ott.Variable.voyage_p_thumbnail;
import static com.aliseon.ott.Variable.voyage_photo;
import static com.aliseon.ott.Variable.voyage_product_id;
import static com.aliseon.ott.Variable.voyage_status;
import static com.aliseon.ott.Variable.voyage_update_at;
import static com.aliseon.ott.Variable.voyage_user_id;
import static com.aliseon.ott.Variable.voyage_view_count;
import static com.aliseon.ott.activity.VoyageActivity.searchactivityvoyagehandler;
import static com.aliseon.ott.Variable.voyage_c_thumbnail;

public class NetworkTaskTvottSearchVoyage extends AsyncTask<Void, Void, String> {


    private static String TAG = "피드 배열 출력";

    private String url;
    private ContentValues values;

    public NetworkTaskTvottSearchVoyage(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionTvottSearchVoyage requestHttpURLConnectiontvottsearchfeed = new RequestHttpURLConnectionTvottSearchVoyage();
        result = requestHttpURLConnectiontvottsearchfeed.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

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

                            voyage_c_thumbnail = new ArrayList<>();

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
                            String nickname = jo_voyage.getString("nickname");
                            String photo = jo_voyage.getString("photo");
                            String thumbnail = jo_voyage.getString("thumbnail");


                            voyage_id.add(id);
                            voyage_user_id.add(user_id);
                            voyage_product_id.add(product_id);
                            voyage_contents_id.add(contents_id);
                            voyage_contents_type.add(contents_type);
                            voyage_category_id.add(category_id);
                            voyage_status.add(status);
                            voyage_create_at.add(create_at);
                            voyage_update_at.add(update_at);
                            voyage_like_count.add(like_count);
                            voyage_view_count.add(view_count);
                            voyage_comment_count.add(comment_count);
                            voyage_category_en.add(category_en);
                            voyage_category_kr.add(category_kr);
                            voyage_nickname.add(nickname);
                            voyage_photo.add(photo);

                            if(description.length() > 25){
                                voyage_description.add(description.substring(0,25) + "...");
                            } else {
                                voyage_description.add(description);
                            }

                            try{

                                if (thumbnail != null && voyage_c_thumbnail != null && voyage_p_thumbnail != null) {

                                    thumbnail = thumbnail.replace("\\", "");
                                    thumbnail = thumbnail.replace("\"", "");
                                    thumbnail = thumbnail.replace("[", "");
                                    thumbnail = thumbnail.replace("]", "");

                                    String[] thumbnail_result = thumbnail.split(",");

                                    for (int ii = 0; ii < thumbnail_result.length; ii++) {

                                        voyage_c_thumbnail.add(thumbnail_result[ii]);

                                    }

                                    voyage_p_thumbnail.add(voyage_c_thumbnail);

                                } throw new Exception("error");

//                      throw new Exception(); //강제 에러 출력
                            }catch (Exception e){

                                voyage_p_thumbnail.add(voyage_c_thumbnail);

                            }

                            Log.d(TAG, "자바로 가공한 voyage0 리스트>>" + id + "/" + user_id + "/" + product_id + "/" + contents_id + "/" + contents_type + "/" + category_id + "/" + status + "/" + description + "/" + create_at
                                    + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + category_en + "/" + category_kr + "/" + nickname + "/" + photo + "/" + thumbnail);

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if(voyageapiload == 0 && voyagecategoryapiload == 0 && voyagefocusapiload == 0) {

                        Log.d("1111 >>", "1111");

                        NetworkTaskCategories networktaskcategories = new NetworkTaskCategories(api_category, null);
                        networktaskcategories.execute();

                    }else if(voyageapiload == 0 && voyagecategoryapiload == 1 && voyagefocusapiload == 1 && category_num == 0){

                        Log.d("2222 >>", "2222");

                        voyageapiload = 1;

                        searchactivityvoyagehandler.sendEmptyMessage(10000);

                    } else {

                        Log.d("3333 >>", "3333");

                        voyageapiload = 1;

                        searchactivityvoyagehandler.sendEmptyMessage(category_num * 100);
                    }
                }

    }
}