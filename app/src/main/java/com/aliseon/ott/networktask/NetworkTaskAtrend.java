package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionAtrend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.Variable.api_tvott_popular;
import static com.aliseon.ott.Variable.atrend_background;
import static com.aliseon.ott.Variable.atrend_color;
import static com.aliseon.ott.Variable.atrend_id;
import static com.aliseon.ott.Variable.atrend_opacity;
import static com.aliseon.ott.Variable.atrend_subtitle;
import static com.aliseon.ott.Variable.atrend_summary;
import static com.aliseon.ott.Variable.atrend_thumbnail;
import static com.aliseon.ott.Variable.atrend_title;
import static com.aliseon.ott.Variable.atrend_type;

public class NetworkTaskAtrend extends AsyncTask<Void, Void, String> {


    private static String TAG = "동영상 리스트 배열 출력";
    private static String TAG2 = "동영상 변환 배열 출력";

    private String url;
    private ContentValues values;

    public NetworkTaskAtrend(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionAtrend requesthttpurlconnectionatrend = new RequestHttpURLConnectionAtrend();
        result = requesthttpurlconnectionatrend.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String atrendlist = s;

        if (s != null) {
            try {
                JSONObject jo_atrend = new JSONObject(atrendlist);
                String list = jo_atrend.getString("list");

                Log.d(TAG2, "AconLast 오리지날 리스트>>" + list);

                JSONObject jo_atrendlist = new JSONObject(list);
                String last = jo_atrendlist.getString("last");

                JSONArray ja_atrendlast = new JSONArray(last);
                Log.d(TAG2, "AconLast LAST 리스트>>" + ja_atrendlast);

                for (int i = 0; i < ja_atrendlast.length(); i++) {
                    JSONObject jo_atrendlast = ja_atrendlast.getJSONObject(i);

                    String id = jo_atrendlast.getString("id");
                    String user_id = jo_atrendlast.getString("user_id");
                    String type = jo_atrendlast.getString("type");
                    String product_id = jo_atrendlast.getString("product_id");
                    String contents_id = jo_atrendlast.getString("contents_id");
                    String title = jo_atrendlast.getString("title");
                    String sub_title = jo_atrendlast.getString("sub_title");
                    String description = jo_atrendlast.getString("description");
                    String summary = jo_atrendlast.getString("summary");
                    int view = jo_atrendlast.getInt("view");
                    int like = jo_atrendlast.getInt("like");
                    String color = jo_atrendlast.getString("color");
                    String start_at = jo_atrendlast.getString("start_at");
                    String create_at = jo_atrendlast.getString("create_at");
                    String update_at = jo_atrendlast.getString("update_at");
                    String opacity = jo_atrendlast.getString("opacity");
                    int status = jo_atrendlast.getInt("status");
                    String background = jo_atrendlast.getString("background");
                    String thumbnail = jo_atrendlast.getString("thumbnail");

                    atrend_id.add(id);

                    if(title.length() > 25){
                        atrend_title.add(title.substring(0,25) + "...");
                    } else {
                        atrend_title.add(title);
                    }

                    if(sub_title.length() > 35){
                        atrend_subtitle.add(sub_title.substring(0,35) + "...");
                    } else {
                        atrend_subtitle.add(sub_title);
                    }

                    if(summary.length() > 40){
                        atrend_summary.add(summary.substring(0,40) + "...");
                    } else {
                        atrend_summary.add(summary);
                    }

                    atrend_type.add(type);
                    atrend_thumbnail.add(thumbnail);
                    atrend_background.add(background);
                    atrend_opacity.add(opacity);
                    atrend_color.add(color);

                    Log.d(TAG2, "자바로 가공한 tvottlast 리스트>>" + id + "/" + user_id + "/" + type + "/" + product_id + "/" + contents_id + "/" + title + "/" + sub_title + "/" + description + "/" + summary + "/" + view + "/" + like + "/" + color + "/" + start_at + "/" + create_at + "/" + update_at + "/" + opacity + "/" + status + "/" + background + "/" + thumbnail);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        NetworkTaskTvottPopular networktasktvottpopular = new NetworkTaskTvottPopular(api_tvott_popular, null);
        networktasktvottpopular.execute();

        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
    }
}

