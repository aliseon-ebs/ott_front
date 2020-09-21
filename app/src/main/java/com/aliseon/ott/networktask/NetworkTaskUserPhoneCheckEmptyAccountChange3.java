package com.aliseon.ott.networktask;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionUserPhone;

import static com.aliseon.ott.activity.EmptyChangeAccount3Activity.EmptyAccountChange3mHandler;
import static com.aliseon.ott.Variable.api_tvott_users;
import static com.aliseon.ott.Variable.infocheck_id;
import static com.aliseon.ott.Variable.myuid;


public class NetworkTaskUserPhoneCheckEmptyAccountChange3 extends AsyncTask<Void, Void, String> {

    private static String TAG = "ID 부여";

    private String url;
    private ContentValues values;





    public NetworkTaskUserPhoneCheckEmptyAccountChange3 (String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnectionUserPhone requestHttpURLConnectionuserphone = new RequestHttpURLConnectionUserPhone();
        result = requestHttpURLConnectionuserphone.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            String s1 = s.substring(1, s.length() - 1);
            infocheck_id = Integer.parseInt(s1);
            Log.d(TAG, "부여받은 ID >>" + infocheck_id);
        } catch(Exception e) {

        }

        if(infocheck_id != myuid){
            EmptyAccountChange3mHandler.sendEmptyMessage(800);
        } else {
            NetworkTaskUsersEmptyChange3 networktaskusersemptychange3 = new NetworkTaskUsersEmptyChange3(api_tvott_users, null);
            networktaskusersemptychange3.execute();
        }
        infocheck_id = -1;
        myuid = -2;

        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.

    }


}
