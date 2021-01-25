//package com.aliseon.ott.networktask;
//
//import android.content.ContentValues;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.aliseon.ott.request_http_url_connection.RequestHttpURLConnectionUsersManagement;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static com.aliseon.ott.activity.AccountAddActivity.AccountAddmHandler;
//import static com.aliseon.ott.Aliseon.userinfo;
//import static com.aliseon.ott.Aliseon.userinfouid;
//
//public class NetworkTaskUsersAccountAdd extends AsyncTask<Void, Void, String> {
//
//    private static String TAG = "배열 정보 가져오기";
//    private static String TAG2 = "자바로 가공한 사용자 배열 정보 가져오기";
//    private static String TAG3 = "가져온 데이터 ArrayList에 넣기";
//
//    private String url;
//    private ContentValues values;
//
//    public NetworkTaskUsersAccountAdd(String url, ContentValues values) {
//
//        this.url = url;
//        this.values = values;
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String result; // 요청 결과를 저장할 변수.
//        RequestHttpURLConnectionUsersManagement requestHttpURLConnectionusersmanagement= new RequestHttpURLConnectionUsersManagement();
//        result = requestHttpURLConnectionusersmanagement.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//        return result;
//    }
//
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        String userinfoarraylist = s;
//
//        Log.d(TAG, "사용자정보 배열 >>" + s);
//
//
//        userinfo.clear();
//        userinfouid.clear();
//
//        if (s != null) {
//            try {
//                JSONArray jarray = new JSONArray(userinfoarraylist);
//
//                for (int i = 0; i < userinfoarraylist.length(); i++) {
//                    JSONObject jobject = jarray.getJSONObject(i);
//
//                    int id = jobject.getInt("id");
//                    String nickname = jobject.getString("nickname");
//                    String seq = jobject.getString("seq");
//                    String picture = jobject.getString("picture");
//                    String lang = jobject.getString("lang");
//                    String country = jobject.getString("country");
//                    String currency = jobject.getString("currency");
//
//
//                    Log.d(TAG2, "자바로 가공한 사용자정보 배열 리스트>> " + id + " | " + nickname + " | " + seq + " | " + picture + " | " + lang + " | " + country + " | " + currency);
//
//                    switch (i){
//                        case 0 :
//                            userinfouid.add(0,id);
//                            userinfo.add(0,nickname);
//                            userinfo.add(1,seq);
//                            userinfo.add(2,picture);
//                            userinfo.add(3,lang);
//                            userinfo.add(4,country);
//                            userinfo.add(5,currency);
//                            Log.d(TAG3, "Arraylist  uid1  현황>>"  + userinfouid.get(0));
//                            Log.d(TAG3, "Arraylist info1234 현황>>"  + userinfo.get(0)+ " | " + userinfo.get(1) + " | " + userinfo.get(2) + " | " + userinfo.get(3) + " | " + userinfo.get(4) + " | " + userinfo.get(5));
//                            break;
//                        case 1 :
//                            userinfouid.add(1,id);
//                            userinfo.add(6,nickname);
//                            userinfo.add(7,seq);
//                            userinfo.add(8,picture);
//                            userinfo.add(9,lang);
//                            userinfo.add(10,country);
//                            userinfo.add(11,currency);
//                            Log.d(TAG3, "Arraylist  uid2  현황>>"  + userinfouid.get(1));
//                            Log.d(TAG3, "Arraylist info5678 현황>>"  + userinfo.get(6)+ " | " + userinfo.get(7) + " | " + userinfo.get(8) + " | " + userinfo.get(9) + " | " + userinfo.get(10) + " | " + userinfo.get(11));
//                            break;
//                        case 2:
//                            userinfouid.add(2,id);
//                            userinfo.add(12,nickname);
//                            userinfo.add(13,seq);
//                            userinfo.add(14,picture);
//                            userinfo.add(15,lang);
//                            userinfo.add(16,country);
//                            userinfo.add(17,currency);
//                            Log.d(TAG3, "Arraylist  uid3  현황>>"  + userinfouid.get(2));
//                            Log.d(TAG3, "Arraylist info9101112 현황>>"  + userinfo.get(12)+ " | " + userinfo.get(13) + " | " + userinfo.get(14) + " | " + userinfo.get(15) + " | " + userinfo.get(16) + " | " + userinfo.get(17));
//                            break;
//                    }
//
//                }
//
//            } catch(JSONException e){
//                e.printStackTrace();
//            }
//        } else{
//
//        }
//        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
//
//        AccountAddmHandler.sendEmptyMessage(1000);
//
//    }
//}
