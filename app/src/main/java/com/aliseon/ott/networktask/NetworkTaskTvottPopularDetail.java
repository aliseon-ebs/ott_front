package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottPopularDetail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.activity.AliseonOTTPlayerActivity.playerdataloadhandler;
import static com.aliseon.ott.Variable.popular_detail_category_en;
import static com.aliseon.ott.Variable.popular_detail_category_id;
import static com.aliseon.ott.Variable.popular_detail_category_kr;
import static com.aliseon.ott.Variable.popular_detail_comment_count;
import static com.aliseon.ott.Variable.popular_detail_contents;
import static com.aliseon.ott.Variable.popular_detail_contents_id;
import static com.aliseon.ott.Variable.popular_detail_contents_type;
import static com.aliseon.ott.Variable.popular_detail_create_at;
import static com.aliseon.ott.Variable.popular_detail_description;
import static com.aliseon.ott.Variable.popular_detail_id;
import static com.aliseon.ott.Variable.popular_detail_item_brand;
import static com.aliseon.ott.Variable.popular_detail_item_id;
import static com.aliseon.ott.Variable.popular_detail_item_name;
import static com.aliseon.ott.Variable.popular_detail_item_previous_price;
import static com.aliseon.ott.Variable.popular_detail_item_price;
import static com.aliseon.ott.Variable.popular_detail_item_thumbnail;
import static com.aliseon.ott.Variable.popular_detail_items;
import static com.aliseon.ott.Variable.popular_detail_like_count;
import static com.aliseon.ott.Variable.popular_detail_name;
import static com.aliseon.ott.Variable.popular_detail_photo;
import static com.aliseon.ott.Variable.popular_detail_product_id;
import static com.aliseon.ott.Variable.popular_detail_status;
import static com.aliseon.ott.Variable.popular_detail_update_at;
import static com.aliseon.ott.Variable.popular_detail_user_id;
import static com.aliseon.ott.Variable.popular_detail_view_count;
import static com.aliseon.ott.Variable.popular_related_comment_count;
import static com.aliseon.ott.Variable.popular_related_contents;
import static com.aliseon.ott.Variable.popular_related_create_at;
import static com.aliseon.ott.Variable.popular_related_description;
import static com.aliseon.ott.Variable.popular_related_id;
import static com.aliseon.ott.Variable.popular_related_like_count;
import static com.aliseon.ott.Variable.popular_related_status;
import static com.aliseon.ott.Variable.popular_related_update_at;
import static com.aliseon.ott.Variable.popular_related_user_id;
import static com.aliseon.ott.Variable.popular_related_view_count;

public class NetworkTaskTvottPopularDetail extends AsyncTask<Void, Void, String> {

    private static String TAG = "인기동영상";
    private static String TAG2 = "피드 변환 배열 출력";

    private String url;
    private ContentValues values;

    public NetworkTaskTvottPopularDetail(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionTvottPopularDetail requestHttpURLConnectiontvottpopulardetail = new RequestHttpURLConnectionTvottPopularDetail();
        result = requestHttpURLConnectiontvottpopulardetail.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String list = s;

        if (s != null) {

            popular_detail_id.clear();
            popular_detail_user_id.clear();
            popular_detail_product_id.clear();
            popular_detail_contents_id.clear();
            popular_detail_contents_type.clear();
            popular_detail_category_id.clear();
            popular_detail_status.clear();
            popular_detail_description.clear();
            popular_detail_create_at.clear();
            popular_detail_update_at.clear();
            popular_detail_like_count.clear();
            popular_detail_view_count.clear();
            popular_detail_comment_count.clear();
            popular_detail_category_en.clear();
            popular_detail_category_kr.clear();
            popular_detail_name.clear();
            popular_detail_photo.clear();
            popular_detail_contents.clear();
            popular_detail_items.clear();

            popular_detail_item_id.clear();
            popular_detail_item_name.clear();
            popular_detail_item_brand.clear();
            popular_detail_item_thumbnail.clear();
            popular_detail_item_price.clear();
            popular_detail_item_previous_price.clear();

            popular_related_id.clear();
            popular_related_user_id.clear();
            popular_related_status.clear();
            popular_related_description.clear();
            popular_related_create_at.clear();
            popular_related_update_at.clear();
            popular_related_like_count.clear();
            popular_related_view_count.clear();
            popular_related_comment_count.clear();
            popular_related_contents.clear();

            try {
                JSONObject jsonObject = new JSONObject(list);
                list = jsonObject.getString("list");

                Log.d(TAG2, "popular List >>" + list);

                JSONObject jo_populardetaillist = new JSONObject(list);
                String detail = jo_populardetaillist.getString("detail");

                JSONObject jo_popularrelatedlist = new JSONObject(list);
                String related = jo_popularrelatedlist.getString("related");

                JSONArray ja_populardetail = new JSONArray(detail);
                Log.d(TAG2, "popular DETAIL 리스트>>" + ja_populardetail);

                JSONArray ja_popularrelated = new JSONArray(related);
                Log.d(TAG2, "popular RELATED 리스트>>" + ja_popularrelated);

                for (int i = 0; i < ja_populardetail.length(); i++) {
                    JSONObject jo_populardetaildata = ja_populardetail.getJSONObject(i);

                    String id = jo_populardetaildata.getString("id");
                    String user_id = jo_populardetaildata.getString("user_id");
                    String product_id = jo_populardetaildata.getString("product_id");
                    String contents_id = jo_populardetaildata.getString("contents_id");
                    String contents_type = jo_populardetaildata.getString("contents_type");
                    String category_id = jo_populardetaildata.getString("category_id");
                    String status = jo_populardetaildata.getString("status");
                    String description = jo_populardetaildata.getString("description");
                    String create_at = jo_populardetaildata.getString("create_at");
                    String update_at = jo_populardetaildata.getString("update_at");
                    String like_count = jo_populardetaildata.getString("like_count");
                    String view_count = jo_populardetaildata.getString("view_count");
                    String comment_count = jo_populardetaildata.getString("comment_count");
                    String category_en = jo_populardetaildata.getString("category_en");
                    String category_kr = jo_populardetaildata.getString("category_ko");
                    String name = jo_populardetaildata.getString("nickname");
                    String photo = jo_populardetaildata.getString("photo");
                    String contents = jo_populardetaildata.getString("contents");
                    String items = jo_populardetaildata.getString("items");

                    JSONArray ja_contents = new JSONArray(contents);
                    String jo_contents = ja_contents.getString(0);

                    contents = jo_contents;

                    popular_detail_id.add(id);
                    popular_detail_user_id.add(user_id);
                    popular_detail_product_id.add(product_id);
                    popular_detail_contents_id.add(contents_id);
                    popular_detail_contents_type.add(contents_type);
                    popular_detail_category_id.add(category_id);
                    popular_detail_status.add(status);
                    popular_detail_description.add(description);
                    popular_detail_create_at.add(create_at);
                    popular_detail_update_at.add(update_at);
                    popular_detail_like_count.add(like_count);
                    popular_detail_view_count.add(view_count);
                    popular_detail_comment_count.add(comment_count);
                    popular_detail_category_en.add(category_en);
                    popular_detail_category_kr.add(category_kr);
                    popular_detail_name.add(name);
                    popular_detail_photo.add(photo);
                    popular_detail_contents.add(contents);
                    popular_detail_items.add(items);

                    Log.d(TAG2,
                            "popularDetail DETAIL LIST >> "
                                    + id + "/" + user_id + "/" + product_id + "/" + contents_id + "/" + contents_type +
                                    "/" + category_id + "/" + category_en + "/" + category_kr + "/" + status + "/" + description + "/" +
                                    create_at + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + name + "/" + photo + "/" + contents);


                    JSONArray ja_items = new JSONArray(items);

                    for (int ii = 0; ii < ja_items.length(); ii++) {
                        JSONObject jo_items = ja_items.getJSONObject(ii);

                        String item_id = jo_items.getString("id");
                        String item_name = jo_items.getString("name");
                        String item_brand = jo_items.getString("brand");
                        String item_thumbnail = jo_items.getString("thumbnail");
                        String item_price = jo_items.getString("price");
                        String item_previous_price = jo_items.getString("previous_price");

                        popular_detail_item_id.add(item_id);
                        popular_detail_item_name.add(item_name);
                        popular_detail_item_brand.add(item_brand);
                        popular_detail_item_thumbnail.add(item_thumbnail);
                        popular_detail_item_price.add(item_price);
                        popular_detail_item_previous_price.add(item_previous_price);

                    }
                }
                for (int j = 0; j < ja_popularrelated.length(); j++) {
                    JSONObject jo_popularrelateddata = ja_popularrelated.getJSONObject(j);

                    String id = jo_popularrelateddata.getString("id");
                    String user_id = jo_popularrelateddata.getString("user_id");
                    String status = jo_popularrelateddata.getString("status");
                    String description = jo_popularrelateddata.getString("description");
                    String create_at = jo_popularrelateddata.getString("create_at");
                    String update_at = jo_popularrelateddata.getString("update_at");
                    String like_count = jo_popularrelateddata.getString("like_count");
                    String view_count = jo_popularrelateddata.getString("view_count");
                    String comment_count = jo_popularrelateddata.getString("comment_count");
                    String thumbnail = jo_popularrelateddata.getString("thumbnail");
                    Log.d(TAG2, "popularDetail RELATED LIST >> " + id + "/" + user_id + "/" + status + "/" + description + "/" + create_at + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + thumbnail);

                    popular_related_id.add(id);
                    popular_related_user_id.add(user_id);
                    popular_related_status.add(status);
                    popular_related_description.add(description);
                    popular_related_create_at.add(create_at);
                    popular_related_update_at.add(update_at);
                    popular_related_like_count.add(like_count);
                    popular_related_view_count.add(view_count);
                    popular_related_comment_count.add(comment_count);
                    popular_related_contents.add(thumbnail);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            playerdataloadhandler.sendEmptyMessage(1000);
        } else {
            playerdataloadhandler.sendEmptyMessage(800);
        }
    }
}

