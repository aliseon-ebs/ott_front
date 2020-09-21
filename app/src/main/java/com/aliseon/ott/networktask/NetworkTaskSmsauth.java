package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionSmsauth;

public class NetworkTaskSmsauth extends AsyncTask<Void, Void, String> {

    private static String TAG = "결과값 반환";

    private String url;
    private ContentValues values;
    private TextView tv_outPut;

    public NetworkTaskSmsauth(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionSmsauth requestHttpURLConnectionsmsauth = new RequestHttpURLConnectionSmsauth();
        result = requestHttpURLConnectionsmsauth.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
        Log.d(TAG, "자바로 가공한 토큰 >>" + s);

    }


}