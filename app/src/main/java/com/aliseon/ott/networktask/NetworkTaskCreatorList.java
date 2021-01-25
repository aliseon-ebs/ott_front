//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionCreatorList;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
//import static com.aliseon.ott.Aliseon.creator_list_c_thumbnail;
//import static com.aliseon.ott.Aliseon.creator_list_nickname;
//import static com.aliseon.ott.Aliseon.creator_list_p_thumbnail;
//import static com.aliseon.ott.Aliseon.creator_list_comment_count;
//import static com.aliseon.ott.Aliseon.creator_list_create_at;
//import static com.aliseon.ott.Aliseon.creator_list_description;
//import static com.aliseon.ott.Aliseon.creator_list_id;
//import static com.aliseon.ott.Aliseon.creator_list_like_count;
//import static com.aliseon.ott.Aliseon.creator_list_profile;
//import static com.aliseon.ott.Aliseon.creator_list_status;
//import static com.aliseon.ott.Aliseon.creator_list_update_at;
//import static com.aliseon.ott.Aliseon.creator_list_user_id;
//import static com.aliseon.ott.Aliseon.creator_list_view_count;
//import static com.aliseon.ott.Aliseon.creatorapiload;
//import static com.aliseon.ott.activity.CreatorActivity.creatoractivityhandler;
//
//public class NetworkTaskCreatorList extends AsyncTask<Void, Void, String> {
//
//    private static String TAG = "구독 크리에이터 출력";
//    private static String TAG2 = "피드 변환 배열 출력";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskCreatorList(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionCreatorList requestHttpURLConnectioncreatorlist = new RequestHttpURLConnectionCreatorList();
//        result = requestHttpURLConnectioncreatorlist.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        String original_creator_list = s;
//
//        if (s != null) {
//            try {
//
//                creator_list_p_thumbnail.clear();
//                creator_list_c_thumbnail.clear();
//
//                creator_list_id.clear();
//                creator_list_user_id.clear();
//                creator_list_status.clear();
//                creator_list_create_at.clear();
//                creator_list_update_at.clear();
//                creator_list_like_count.clear();
//                creator_list_view_count.clear();
//                creator_list_comment_count.clear();
//                creator_list_nickname.clear();
//                creator_list_profile.clear();
//                creator_list_description.clear();
//
//                JSONObject jo_creator_list_total = new JSONObject(original_creator_list);
//                String creator_list_list = jo_creator_list_total.getString("list");
//                JSONArray ja_creator_list = new JSONArray(creator_list_list);
//
//                for (int i = 0; i < ja_creator_list.length(); i++) {
//                    JSONObject jo_creator_list = ja_creator_list.getJSONObject(i);
//
//                    creator_list_c_thumbnail = new ArrayList<>();
//
//                    String id = jo_creator_list.getString("id");
//                    String user_id = jo_creator_list.getString("user_id");
//                    int status = jo_creator_list.getInt("status");
//                    String description = jo_creator_list.getString("description");
//                    String create_at = jo_creator_list.getString("create_at");
//                    String update_at = jo_creator_list.getString("update_at");
//                    int like_count = jo_creator_list.getInt("like_count");
//                    int view_count = jo_creator_list.getInt("view_count");
//                    int comment_count = jo_creator_list.getInt("comment_count");
//                    String nickname = jo_creator_list.getString("nickname");
//                    String profile = jo_creator_list.getString("profile");
//                    String thumbnail = jo_creator_list.getString("thumbnail");
//
//                    creator_list_id.add(id);
//                    creator_list_user_id.add(user_id);
//                    creator_list_status.add(status);
//                    creator_list_create_at.add(create_at);
//                    creator_list_update_at.add(update_at);
//                    creator_list_like_count.add(like_count);
//                    creator_list_view_count.add(view_count);
//                    creator_list_comment_count.add(comment_count);
//                    creator_list_nickname.add(nickname);
//                    creator_list_profile.add(profile);
//
//                    if(description.length() > 25){
//                        creator_list_description.add(description.substring(0,25) + "...");
//                    } else {
//                        creator_list_description.add(description);
//                    }
//
//                    try{
//
//                        if (thumbnail != null && creator_list_c_thumbnail != null && creator_list_p_thumbnail != null) {
//
//                            Log.d(TAG, "내 영상 ori 썸네일>>" + thumbnail);
//
//                            thumbnail = thumbnail.replace("\\", "");
//                            thumbnail = thumbnail.replace("\"", "");
//                            thumbnail = thumbnail.replace("[", "");
//                            thumbnail = thumbnail.replace("]", "");
//
//                            String[] thumbnail_result = thumbnail.split(",");
//
//                            for (int ii = 0; ii < thumbnail_result.length; ii++) {
//
//                                creator_list_c_thumbnail.add(thumbnail_result[ii]);
//
//                            }
//
//                            creator_list_p_thumbnail.add(creator_list_c_thumbnail);
//
//                        } throw new Exception("error");
//
//                    }catch (Exception e){
//
//                        creator_list_p_thumbnail.add(creator_list_c_thumbnail);
//
//                    }
//
//                    Log.d(TAG, "내 영상 리스트>>" + id + "/" + user_id + "/" + status + "/" + create_at + "/" + update_at + "/" + like_count + "/" + view_count + "/" + comment_count + "/" + profile + "/" + thumbnail);
//
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            if(creatorapiload == 0){
//
//                creatorapiload = 1;
//                creatoractivityhandler.sendEmptyMessage(1000);
//
//            } else if(creatorapiload == 1){
//
////                creatoractivitycontentsloadinghandler.sendEmptyMessage(1000);
//
//            }
//
//        }
//
//    }
//
//}
