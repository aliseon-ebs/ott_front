//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionAtrendDetail;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static com.aliseon.ott.Aliseon.atrend_detail_detp_html;
//import static com.aliseon.ott.Aliseon.atrend_detail_maincontent;
//import static com.aliseon.ott.Aliseon.atrend_detail_product_brand;
//import static com.aliseon.ott.Aliseon.atrend_detail_product_id;
//import static com.aliseon.ott.Aliseon.atrend_detail_product_name;
//import static com.aliseon.ott.Aliseon.atrend_detail_product_previous_price;
//import static com.aliseon.ott.Aliseon.atrend_detail_product_price;
//import static com.aliseon.ott.Aliseon.atrend_detail_product_thumbnail;
//import static com.aliseon.ott.activity.AliseonOTTPlayerActivity.playerdataloadhandler;
//import static com.aliseon.ott.Aliseon.atrend_related_background;
//import static com.aliseon.ott.Aliseon.atrend_related_color;
//import static com.aliseon.ott.Aliseon.atrend_related_create_at;
//import static com.aliseon.ott.Aliseon.atrend_related_description;
//import static com.aliseon.ott.Aliseon.atrend_related_id;
//import static com.aliseon.ott.Aliseon.atrend_related_like;
//import static com.aliseon.ott.Aliseon.atrend_related_opacity;
//import static com.aliseon.ott.Aliseon.atrend_related_product_id;
//import static com.aliseon.ott.Aliseon.atrend_related_start_at;
//import static com.aliseon.ott.Aliseon.atrend_related_status;
//import static com.aliseon.ott.Aliseon.atrend_related_subtitle;
//import static com.aliseon.ott.Aliseon.atrend_related_summary;
//import static com.aliseon.ott.Aliseon.atrend_related_thumbnail;
//import static com.aliseon.ott.Aliseon.atrend_related_title;
//import static com.aliseon.ott.Aliseon.atrend_related_type;
//import static com.aliseon.ott.Aliseon.atrend_related_update_at;
//import static com.aliseon.ott.Aliseon.atrend_related_user_id;
//import static com.aliseon.ott.Aliseon.atrend_related_view;
//
//public class NetworkTaskAtrendDetail extends AsyncTask<Void, Void, String> {
//
//
//    private static String TAG = "동영상 리스트 배열 출력";
//    private static String TAG2 = "동영상 변환 배열 출력";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskAtrendDetail(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionAtrendDetail requesthttpurlconnectionatrenddetail = new RequestHttpURLConnectionAtrendDetail();
//        result = requesthttpurlconnectionatrenddetail.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        String acondetaillist = s;
//
//        atrend_related_id.clear();
//        atrend_related_user_id.clear();
//        atrend_related_type.clear();
//        atrend_related_product_id.clear();
//        atrend_related_title.clear();
//        atrend_related_subtitle.clear();
//        atrend_related_description.clear();
//        atrend_related_summary.clear();
//        atrend_related_view.clear();
//        atrend_related_like.clear();
//        atrend_related_color.clear();
//        atrend_related_start_at.clear();
//        atrend_related_create_at.clear();
//        atrend_related_update_at.clear();
//        atrend_related_opacity.clear();
//        atrend_related_status.clear();
//        atrend_related_background.clear();
//        atrend_related_thumbnail.clear();
//
//        atrend_detail_detp_html.clear();
//        atrend_detail_maincontent.clear();
//        atrend_detail_product_id.clear();
//        atrend_detail_product_name.clear();
//        atrend_detail_product_brand.clear();
//        atrend_detail_product_thumbnail.clear();
//        atrend_detail_product_price.clear();
//        atrend_detail_product_previous_price.clear();
//
//        atrend_detail_product_id.clear();
//        atrend_detail_product_name.clear();
//        atrend_detail_product_brand.clear();
//        atrend_detail_product_thumbnail.clear();
//        atrend_detail_product_price.clear();
//        atrend_detail_product_previous_price.clear();
//
//        if (s != null) {
//            try {
//                JSONObject jo_atrenddetail = new JSONObject(acondetaillist);
//                String list = jo_atrenddetail.getString("list");
//
//                Log.d(TAG2, "AconLast 오리지날 리스트>>" + list);
//
//                JSONObject jo_atrenddetaillist = new JSONObject(list);
//                String detail = jo_atrenddetaillist.getString("detail");
//
//                JSONObject jo_atrendrelatedlist = new JSONObject(list);
//                String related = jo_atrendrelatedlist.getString("related");
//
//                JSONArray ja_atrenddetail = new JSONArray(detail);
//                Log.d(TAG2, "AconLast LAST 리스트>>" + ja_atrenddetail);
//
//                JSONArray ja_atrendrelated = new JSONArray(related);
//                Log.d(TAG2, "AconLast RELATED 리스트>>" + ja_atrendrelated);
//
//
//                for (int j = 0; j <  ja_atrendrelated.length(); j++) {
//                    JSONObject jo_atrendrelated = ja_atrendrelated.getJSONObject(j);
//
//                    String id = jo_atrendrelated.getString("id");
//                    String user_id = jo_atrendrelated.getString("user_id");
//                    String type = jo_atrendrelated.getString("type");
//                    String product_id = jo_atrendrelated.getString("product_id");
//                    String title = jo_atrendrelated.getString("title");
//                    String sub_title = jo_atrendrelated.getString("sub_title");
//                    String description = jo_atrendrelated.getString("description");
//                    String summary = jo_atrendrelated.getString("summary");
//                    String view = jo_atrendrelated.getString("view");
//                    String like = jo_atrendrelated.getString("like");
//                    String color = jo_atrendrelated.getString("color");
//                    String start_at = jo_atrendrelated.getString("start_at");
//                    String create_at = jo_atrendrelated.getString("create_at");
//                    String update_at = jo_atrendrelated.getString("update_at");
//                    String opacity = jo_atrendrelated.getString("opacity");
//                    String status = jo_atrendrelated.getString("status");
//                    String background = jo_atrendrelated.getString("background");
//                    String thumbnail = jo_atrendrelated.getString("thumbnail");
//
//                    Log.d("AconLast RELATED >> ", title + "/" + sub_title + "/" + description + "/" + summary + "/" + id + "/" + "/" + user_id + "/" + type + "/" + product_id + "/" + view + "/" + like + "/" + color + "/" + start_at + "/" + create_at + "/" + update_at + "/" + opacity + "/" + status + "/" + background + "/" + thumbnail);
//
//                    atrend_related_id.add(id);
//                    atrend_related_user_id.add(user_id);
//                    atrend_related_type.add(type);
//                    atrend_related_product_id.add(product_id);
//                    atrend_related_title.add(title);
//                    atrend_related_subtitle.add(sub_title);
//                    atrend_related_description.add(description);
//                    atrend_related_summary.add(summary);
//                    atrend_related_view.add(view);
//                    atrend_related_like.add(like);
//                    atrend_related_color.add(color);
//                    atrend_related_start_at.add(start_at);
//                    atrend_related_create_at.add(create_at);
//                    atrend_related_update_at.add(update_at);
//                    atrend_related_opacity.add(opacity);
//                    atrend_related_status.add(status);
//                    atrend_related_background.add(background);
//                    atrend_related_thumbnail.add(thumbnail);
//                }
//
//
//                for (int i = 0; i < ja_atrenddetail.length(); i++) {
//                    JSONObject jo_atrendlast = ja_atrenddetail.getJSONObject(i);
//
//                    String dept1_html = jo_atrendlast.getString("dept1_html");
//                    String dept2_html = jo_atrendlast.getString("dept2_html");
//                    String dept3_html = jo_atrendlast.getString("dept3_html");
//                    String dept4_html = jo_atrendlast.getString("dept4_html");
//                    String maincontent = jo_atrendlast.getString("maincontent");
//                    String items = jo_atrendlast.getString("items");
//
//                    atrend_detail_detp_html.add(dept1_html);
//                    atrend_detail_detp_html.add(dept2_html);
//                    atrend_detail_detp_html.add(dept3_html);
//                    atrend_detail_detp_html.add(dept4_html);
//                    atrend_detail_maincontent.add(maincontent);
//
//                    Log.d(TAG2, "AconLast 메인콘텐츠>>" + atrend_detail_maincontent);
//
//                    JSONArray ja_items = new JSONArray(items);
//
//                    for (int ii = 0; ii < ja_items.length(); ii++) {
//
//                        JSONObject jo_items = ja_items.getJSONObject(ii);
////
//                        String dept1_product = jo_items.getString("dept1_product");
//                        String dept2_product = jo_items.getString("dept2_product");
//                        String dept3_product = jo_items.getString("dept3_product");
//                        String dept4_product = jo_items.getString("dept4_product");
//
//                        JSONArray ja_items1 = new JSONArray(dept1_product);
//                        JSONArray ja_items2 = new JSONArray(dept2_product);
//                        JSONArray ja_items3 = new JSONArray(dept3_product);
//                        JSONArray ja_items4 = new JSONArray(dept4_product);
//
//                            for(int iii = 0; iii < ja_items1.length(); iii++){
//
//                                JSONObject jo_items11 = ja_items1.getJSONObject(ii);
//
//                                String id = jo_items11.getString("id");
//                                String name = jo_items11.getString("name");
//                                String brand = jo_items11.getString("brand");
//                                String thumbnail = jo_items11.getString("thumbnail");
//                                String price = jo_items11.getString("price");
//                                String previous_price = jo_items11.getString("previous_price");
//
//                                atrend_detail_product_id.add(id);
//                                atrend_detail_product_name.add(name);
//                                atrend_detail_product_brand.add(brand);
//                                atrend_detail_product_thumbnail.add(thumbnail);
//                                atrend_detail_product_price.add(price);
//                                atrend_detail_product_previous_price.add(previous_price);
//
//                            }
//
//                            for(int iiii = 0; iiii < ja_items2.length(); iiii++){
//
//                                JSONObject jo_items22 = ja_items2.getJSONObject(iiii);
//
//                                String id = jo_items22.getString("id");
//                                String name = jo_items22.getString("name");
//                                String brand = jo_items22.getString("brand");
//                                String thumbnail = jo_items22.getString("thumbnail");
//                                String price = jo_items22.getString("price");
//                                String previous_price = jo_items22.getString("previous_price");
//
//                                atrend_detail_product_id.add(id);
//                                atrend_detail_product_name.add(name);
//                                atrend_detail_product_brand.add(brand);
//                                atrend_detail_product_thumbnail.add(thumbnail);
//                                atrend_detail_product_price.add(price);
//                                atrend_detail_product_previous_price.add(previous_price);
//
//                            }
//
//                            for(int j = 0; j < ja_items3.length(); j++){
//
//                                JSONObject jo_items33 = ja_items3.getJSONObject(j);
//
//                                String id = jo_items33.getString("id");
//                                String name = jo_items33.getString("name");
//                                String brand = jo_items33.getString("brand");
//                                String thumbnail = jo_items33.getString("thumbnail");
//                                String price = jo_items33.getString("price");
//                                String previous_price = jo_items33.getString("previous_price");
//
//                                atrend_detail_product_id.add(id);
//                                atrend_detail_product_name.add(name);
//                                atrend_detail_product_brand.add(brand);
//                                atrend_detail_product_thumbnail.add(thumbnail);
//                                atrend_detail_product_price.add(price);
//                                atrend_detail_product_previous_price.add(previous_price);
//
//                            }
//
//                            for(int jj = 0; jj < ja_items4.length(); jj++){
//
//                                JSONObject jo_items44 = ja_items4.getJSONObject(jj);
//
//                                String id = jo_items44.getString("id");
//                                String name = jo_items44.getString("name");
//                                String brand = jo_items44.getString("brand");
//                                String thumbnail = jo_items44.getString("thumbnail");
//                                String price = jo_items44.getString("price");
//                                String previous_price = jo_items44.getString("previous_price");
//
//                                atrend_detail_product_id.add(id);
//                                atrend_detail_product_name.add(name);
//                                atrend_detail_product_brand.add(brand);
//                                atrend_detail_product_thumbnail.add(thumbnail);
//                                atrend_detail_product_price.add(price);
//                                atrend_detail_product_previous_price.add(previous_price);
//
//                            }
////
//                    }
//
//                }
//
//                Log.d(TAG2, "AconLast LAST 리스트>>" + atrend_detail_product_id + " / " + atrend_detail_product_name + " / " + atrend_detail_product_brand + " / " +
//                        atrend_detail_product_thumbnail + " / " + atrend_detail_product_price + " / " + atrend_detail_product_previous_price);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            playerdataloadhandler.sendEmptyMessage(1000);
//        } else {
//            playerdataloadhandler.sendEmptyMessage(800);
//        }
//
//        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
//
//
//    }
//}
//
