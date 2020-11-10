package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottVoyageResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.aliseon.ott.Variable.voyageresultapiload;

import static com.aliseon.ott.Variable.voyageresult_c_thumbnail;
import static com.aliseon.ott.Variable.voyageresult_category_en;
import static com.aliseon.ott.Variable.voyageresult_category_id;
import static com.aliseon.ott.Variable.voyageresult_category_kr;
import static com.aliseon.ott.Variable.voyageresult_comment_count;
import static com.aliseon.ott.Variable.voyageresult_contents_id;
import static com.aliseon.ott.Variable.voyageresult_contents_type;
import static com.aliseon.ott.Variable.voyageresult_create_at;
import static com.aliseon.ott.Variable.voyageresult_description;
import static com.aliseon.ott.Variable.voyageresult_id;
import static com.aliseon.ott.Variable.voyageresult_like_count;
import static com.aliseon.ott.Variable.voyageresult_nickname;
import static com.aliseon.ott.Variable.voyageresult_p_thumbnail;
import static com.aliseon.ott.Variable.voyageresult_photo;
import static com.aliseon.ott.Variable.voyageresult_status;
import static com.aliseon.ott.Variable.voyageresult_update_at;
import static com.aliseon.ott.Variable.voyageresult_user_id;
import static com.aliseon.ott.Variable.voyageresult_view_count;
import static com.aliseon.ott.Variable.voyageresult_product_id;
import static com.aliseon.ott.activity.VoyageResultActivity.voyageresulthandler;
import static com.aliseon.ott.activity.VoyageResultActivity.voyageresultloadinghandler;


public class NetworkTaskTvottVoyageResult extends AsyncTask<Void, Void, String> {


    private String TAG = "검색결과 출력";

    private String url;
    private ContentValues values;

    public NetworkTaskTvottVoyageResult(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionTvottVoyageResult requestHttpURLConnectiontvottfeedresult = new RequestHttpURLConnectionTvottVoyageResult();
        result = requestHttpURLConnectiontvottfeedresult.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

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

                    voyageresult_c_thumbnail = new ArrayList<>();

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

                    voyageresult_id.add(id);
                    voyageresult_user_id.add(user_id);
                    voyageresult_product_id.add(product_id);
                    voyageresult_contents_id.add(contents_id);
                    voyageresult_contents_type.add(contents_type);
                    voyageresult_category_id.add(category_id);
                    voyageresult_status.add(status);
                    voyageresult_create_at.add(create_at);
                    voyageresult_update_at.add(update_at);
                    voyageresult_like_count.add(like_count);
                    voyageresult_view_count.add(view_count);
                    voyageresult_comment_count.add(comment_count);
                    voyageresult_category_en.add(category_en);
                    voyageresult_category_kr.add(category_kr);
                    voyageresult_nickname.add(nickname);
                    voyageresult_photo.add(photo);

                    if(description.length() > 25){
                        voyageresult_description.add(description.substring(0,25) + "...");
                    } else {
                        voyageresult_description.add(description);
                    }

                    try{

                        if (thumbnail != null && voyageresult_c_thumbnail != null && voyageresult_p_thumbnail != null) {

                            thumbnail = thumbnail.replace("\\","");
                            thumbnail = thumbnail.replace("\"","");
                            thumbnail = thumbnail.replace("[","");
                            thumbnail = thumbnail.replace("]","");

                            String[] thumbnail_result = thumbnail.split(",");

                            for(int ii = 0; ii < thumbnail_result.length; ii++) {

                                voyageresult_c_thumbnail.add(thumbnail_result[ii]);

                            }

                            voyageresult_p_thumbnail.add(voyageresult_c_thumbnail);

                        } throw new Exception("error");

//                      throw new Exception(); //강제 에러 출력



                    }catch (Exception e){

                        voyageresult_p_thumbnail.add(voyageresult_c_thumbnail);

                    }

                    Log.d(TAG, "자바로 가공한 voyage result 리스트>>" + id + "/" + user_id + "/" + product_id + "/" + contents_id + "/" + contents_type + "/" + category_id + "/" + status + "/" + description + "/" + create_at
                            + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + category_en + "/" + category_kr + "/" + nickname + "/" + photo + "/" + thumbnail);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (voyageresultapiload == 0) {

                voyageresultapiload = 1;
                voyageresulthandler.sendEmptyMessage(1000);

            } else {

              voyageresultloadinghandler.sendEmptyMessage(1000);

            }

        }

    }
}

