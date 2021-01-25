//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionTvottAdduser;
//
//import static com.aliseon.ott.activity.EmptyAddAccountActivity.EmptyAccountAddmHandler;
//import static com.aliseon.ott.Aliseon.api_tvott_users;
//
//
//public class NetworkTaskTvottEmptyAdduser extends AsyncTask<Void, Void, String> {
//
//    private static String TAG = "유저 추가하기 True & False";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskTvottEmptyAdduser(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionTvottAdduser requestHttpURLConnectiontvottadduser = new RequestHttpURLConnectionTvottAdduser();
//        result = requestHttpURLConnectiontvottadduser.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//    }
//
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        Log.d(TAG, "유저 추가여부 >>" + s);
//        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
//
//        if(s == null){
//            EmptyAccountAddmHandler.sendEmptyMessage(800);
//        } else {
//            NetworkTaskUsersEmptyAccountAdd networkTaskusersemptyaccountadd = new NetworkTaskUsersEmptyAccountAdd(api_tvott_users, null);
//            networkTaskusersemptyaccountadd.execute();
//        }
//
//    }
//}