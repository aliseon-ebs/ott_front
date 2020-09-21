package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottLanguageSetting;

import static com.aliseon.ott.Variable.usersettinglanguageapiload;
import static com.aliseon.ott.activity.LanguageSettingActivity.LanguagemHandler;
import static com.aliseon.ott.activity.SettingLanguagesettingActivity.UserLanguagemHandler;

public class NetworkTaskTvottLanguageSetting extends AsyncTask<Void, Void, String> {

    private static String TAG = "사용자 국가 설정";

    private String url;
    private ContentValues values;

    public NetworkTaskTvottLanguageSetting(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionTvottLanguageSetting requestHttpURLConnectiontvottlanguagesetting = new RequestHttpURLConnectionTvottLanguageSetting();
        result = requestHttpURLConnectiontvottlanguagesetting.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.d(TAG, "language setting 결과 값>>" + s);

        if(usersettinglanguageapiload == 0){

            LanguagemHandler.sendEmptyMessage(1000);

        } else if(usersettinglanguageapiload == 1){

            UserLanguagemHandler.sendEmptyMessage(1000);

        }

    }
}
