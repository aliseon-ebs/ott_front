//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottVoyageDetail;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static com.aliseon.ott.activity.AliseonOTTPlayerActivity.playerdataloadhandler;
//import static com.aliseon.ott.Aliseon.voyage_detail_category_en;
//import static com.aliseon.ott.Aliseon.voyage_detail_category_id;
//import static com.aliseon.ott.Aliseon.voyage_detail_category_kr;
//import static com.aliseon.ott.Aliseon.voyage_detail_comment_count;
//import static com.aliseon.ott.Aliseon.voyage_detail_contents;
//import static com.aliseon.ott.Aliseon.voyage_detail_contents_id;
//import static com.aliseon.ott.Aliseon.voyage_detail_contents_type;
//import static com.aliseon.ott.Aliseon.voyage_detail_create_at;
//import static com.aliseon.ott.Aliseon.voyage_detail_description;
//import static com.aliseon.ott.Aliseon.voyage_detail_id;
//import static com.aliseon.ott.Aliseon.voyage_detail_item_brand;
//import static com.aliseon.ott.Aliseon.voyage_detail_item_id;
//import static com.aliseon.ott.Aliseon.voyage_detail_item_name;
//import static com.aliseon.ott.Aliseon.voyage_detail_item_previous_price;
//import static com.aliseon.ott.Aliseon.voyage_detail_item_price;
//import static com.aliseon.ott.Aliseon.voyage_detail_item_thumbnail;
//import static com.aliseon.ott.Aliseon.voyage_detail_items;
//import static com.aliseon.ott.Aliseon.voyage_detail_like_count;
//import static com.aliseon.ott.Aliseon.voyage_detail_nickname;
//import static com.aliseon.ott.Aliseon.voyage_detail_photo;
//import static com.aliseon.ott.Aliseon.voyage_detail_product_id;
//import static com.aliseon.ott.Aliseon.voyage_detail_status;
//import static com.aliseon.ott.Aliseon.voyage_detail_update_at;
//import static com.aliseon.ott.Aliseon.voyage_detail_user_id;
//import static com.aliseon.ott.Aliseon.voyage_detail_view_count;
//import static com.aliseon.ott.Aliseon.voyage_related_comment_count;
//import static com.aliseon.ott.Aliseon.voyage_related_contents;
//import static com.aliseon.ott.Aliseon.voyage_related_create_at;
//import static com.aliseon.ott.Aliseon.voyage_related_description;
//import static com.aliseon.ott.Aliseon.voyage_related_id;
//import static com.aliseon.ott.Aliseon.voyage_related_like_count;
//import static com.aliseon.ott.Aliseon.voyage_related_status;
//import static com.aliseon.ott.Aliseon.voyage_related_update_at;
//import static com.aliseon.ott.Aliseon.voyage_related_user_id;
//import static com.aliseon.ott.Aliseon.voyage_related_view_count;
//
//public class NetworkTaskTvottVoyageDetail extends AsyncTask<Void, Void, String> {
//
//
//    private static String TAG = "구독 크리에이터 출력";
//    private static String TAG2 = "피드 변환 배열 출력";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskTvottVoyageDetail(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionTvottVoyageDetail requestHttpURLConnectiontvottvoyagedetail = new RequestHttpURLConnectionTvottVoyageDetail();
//        result = requestHttpURLConnectiontvottvoyagedetail.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        voyage_detail_id.clear();
//        voyage_detail_user_id.clear();
//        voyage_detail_product_id.clear();
//        voyage_detail_contents_id.clear();
//        voyage_detail_contents_type.clear();
//        voyage_detail_category_id.clear();
//        voyage_detail_status.clear();
//        voyage_detail_description.clear();
//        voyage_detail_create_at.clear();
//        voyage_detail_update_at.clear();
//        voyage_detail_like_count.clear();
//        voyage_detail_view_count.clear();
//        voyage_detail_comment_count.clear();
//        voyage_detail_category_en.clear();
//        voyage_detail_category_kr.clear();
//        voyage_detail_nickname.clear();
//        voyage_detail_photo.clear();
//        voyage_detail_contents.clear();
//        voyage_detail_items.clear();
//
//        voyage_detail_item_id.clear();
//        voyage_detail_item_name.clear();
//        voyage_detail_item_brand.clear();
//        voyage_detail_item_thumbnail.clear();
//        voyage_detail_item_price.clear();
//        voyage_detail_item_previous_price.clear();
//
//        voyage_related_id.clear();
//        voyage_related_user_id.clear();
//        voyage_related_status.clear();
//        voyage_related_description.clear();
//        voyage_related_create_at.clear();
//        voyage_related_update_at.clear();
//        voyage_related_like_count.clear();
//        voyage_related_view_count.clear();
//        voyage_related_comment_count.clear();
//        voyage_related_contents.clear();
//
//        String list = s;
//        Log.d("RESULT_DETAIL :: ", s);
//
//        if (s != null) {
//            try {
//                JSONObject jsonObject = new JSONObject(list);
//                list = jsonObject.getString("list");
//
//                Log.d(TAG2, "Voyage List >>" + list);
//
//                JSONObject jo_voyagedetaillist = new JSONObject(list);
//                String detail = jo_voyagedetaillist.getString("detail");
//
//                JSONObject jo_voyagerelatedlist = new JSONObject(list);
//                String related = jo_voyagerelatedlist.getString("related");
//
//                JSONArray ja_voyagedetail = new JSONArray(detail);
//                Log.d(TAG2, "Voyage DETAIL 리스트>>" + ja_voyagedetail);
//
//                JSONArray ja_voyagerelated = new JSONArray(related);
//                Log.d(TAG2, "Voyage RELATED 리스트>>" + ja_voyagerelated);
//
//                for (int i = 0; i < ja_voyagedetail.length(); i++) {
//                    JSONObject jo_voyagedetaildata = ja_voyagedetail.getJSONObject(i);
//
//                    String id = jo_voyagedetaildata.getString("id");
//                    String user_id = jo_voyagedetaildata.getString("user_id");
//                    String product_id = jo_voyagedetaildata.getString("product_id");
//                    String contents_id = jo_voyagedetaildata.getString("contents_id");
//                    String contents_type = jo_voyagedetaildata.getString("contents_type");
//                    String category_id = jo_voyagedetaildata.getString("category_id");
//                    String status = jo_voyagedetaildata.getString("status");
//                    String description = jo_voyagedetaildata.getString("description");
//                    String create_at = jo_voyagedetaildata.getString("create_at");
//                    String update_at = jo_voyagedetaildata.getString("update_at");
//                    String like_count = jo_voyagedetaildata.getString("like_count");
//                    String view_count = jo_voyagedetaildata.getString("view_count");
//                    String comment_count = jo_voyagedetaildata.getString("comment_count");
//                    String category_en = jo_voyagedetaildata.getString("category_en");
//                    String category_kr = jo_voyagedetaildata.getString("category_ko");
//                    String name = jo_voyagedetaildata.getString("nickname");
//                    String photo = jo_voyagedetaildata.getString("photo");
//                    String contents = jo_voyagedetaildata.getString("contents");
//                    String items = jo_voyagedetaildata.getString("items");
//
//                    JSONArray ja_contents = new JSONArray(contents);
//                    String jo_contents = ja_contents.getString(0);
//
//                    contents = jo_contents;
//
//                    voyage_detail_id.add(id);
//                    voyage_detail_user_id.add(user_id);
//                    voyage_detail_product_id.add(product_id);
//                    voyage_detail_contents_id.add(contents_id);
//                    voyage_detail_contents_type.add(contents_type);
//                    voyage_detail_category_id.add(category_id);
//                    voyage_detail_status.add(status);
//                    voyage_detail_description.add(description);
//                    voyage_detail_create_at.add(create_at);
//                    voyage_detail_update_at.add(update_at);
//                    voyage_detail_like_count.add(like_count);
//                    voyage_detail_view_count.add(view_count);
//                    voyage_detail_comment_count.add(comment_count);
//                    voyage_detail_category_en.add(category_en);
//                    voyage_detail_category_kr.add(category_kr);
//                    voyage_detail_nickname.add(name);
//                    voyage_detail_photo.add(photo);
//                    voyage_detail_contents.add(contents);
//                    voyage_detail_items.add(items);
//
//                    Log.d(TAG2,
//                            "VoyageDetail DETAIL LIST >> "
//                                    + id + "/" + user_id + "/" + product_id + "/" + contents_id + "/" + contents_type +
//                                    "/" + category_id + "/" + category_en + "/" + category_kr + "/" + status + "/" + description + "/" +
//                            create_at + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + name + "/" + photo + "/" + contents);
//
//
//                    JSONArray ja_items = new JSONArray(items);
//
//                    for (int ii = 0; ii < ja_items.length(); ii++) {
//                        JSONObject jo_items = ja_items.getJSONObject(ii);
//
//                        String item_id = jo_items.getString("id");
//                        String item_name = jo_items.getString("name");
//                        String item_brand = jo_items.getString("brand");
//                        String item_thumbnail = jo_items.getString("thumbnail");
//                        String item_price = jo_items.getString("price");
//                        String item_previous_price = jo_items.getString("previous_price");
//
//                        voyage_detail_item_id.add(item_id);
//                        voyage_detail_item_name.add(item_name);
//                        voyage_detail_item_brand.add(item_brand);
//                        voyage_detail_item_thumbnail.add(item_thumbnail);
//                        voyage_detail_item_price.add(item_price);
//                        voyage_detail_item_previous_price.add(item_previous_price);
//
//                    }
//                }
//                for (int j = 0; j < ja_voyagerelated.length(); j++) {
//                    JSONObject jo_voyagerelateddata = ja_voyagerelated.getJSONObject(j);
//
//                    String id = jo_voyagerelateddata.getString("id");
//                    String user_id = jo_voyagerelateddata.getString("user_id");
//                    String status = jo_voyagerelateddata.getString("status");
//                    String description = jo_voyagerelateddata.getString("description");
//                    String create_at = jo_voyagerelateddata.getString("create_at");
//                    String update_at = jo_voyagerelateddata.getString("update_at");
//                    String like_count = jo_voyagerelateddata.getString("like_count");
//                    String view_count = jo_voyagerelateddata.getString("view_count");
//                    String comment_count = jo_voyagerelateddata.getString("comment_count");
//                    String thumbnail_list = jo_voyagerelateddata.getString("thumbnail");
//
//                    JSONArray ja_contents = new JSONArray(thumbnail_list);
//                    String thumbnail = ja_contents.getString(0);
//
//                    Log.d(TAG2, "VoyageDetail RELATED LIST >> " + id + "/" + user_id + "/" + status + "/" + description + "/" + create_at + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + thumbnail);
//
//                    voyage_related_id.add(id);
//                    voyage_related_user_id.add(user_id);
//                    voyage_related_status.add(status);
//                    voyage_related_description.add(description);
//                    voyage_related_create_at.add(create_at);
//                    voyage_related_update_at.add(update_at);
//                    voyage_related_like_count.add(like_count);
//                    voyage_related_view_count.add(view_count);
//                    voyage_related_comment_count.add(comment_count);
//                    voyage_related_contents.add(thumbnail);
//                }
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            playerdataloadhandler.sendEmptyMessage(1000);
//        } else {
//            playerdataloadhandler.sendEmptyMessage(800);
//        }
//    }
//}
//
