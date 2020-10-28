package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionCategories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.aliseon.ott.Variable.cate_name;
import static com.aliseon.ott.Variable.cate_number;
import static com.aliseon.ott.Variable.voyageapiload;
import static com.aliseon.ott.Variable.voyagecategoryapiload;
import static com.aliseon.ott.activity.VoyageActivity.searchactivityvoyagehandler;

public class NetworkTaskCategories extends AsyncTask<Void, Void, String> {


    private static String TAG = "카테고리 배열 출력";
    private static String TAG2 = "카테고리 변환 배열 출력";

    private String url;
    private ContentValues values;

    public NetworkTaskCategories(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionCategories requestHttpURLConnectioncategories = new RequestHttpURLConnectionCategories();
        result = requestHttpURLConnectioncategories.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String categories = s;

        Log.d(TAG, "카테고리 배열 >>" + s);

        if (s != null) {
            try {

                JSONObject jo_category_total = new JSONObject(s);
                String category_list = jo_category_total.getString("list");
                JSONArray ja_category_list = new JSONArray(category_list);

                for (int i = 0; i < ja_category_list.length(); i++) {
                    JSONObject jo_category = ja_category_list.getJSONObject(i);

                    String id = jo_category.getString("id");
                    String name = jo_category.getString("dept1");

                    cate_number.add(id);
                    cate_name.add(name);

                    Log.d(TAG2, "자바로 가공한 카테고리 리스트>>" + id + ". " + name);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

//            if(searchapiload == 0 && searchcategoryapiload == 0){

                voyageapiload = 1;
                voyagecategoryapiload = 1;
                searchactivityvoyagehandler.sendEmptyMessage(0);

//            }

        }
        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.

    }
}

