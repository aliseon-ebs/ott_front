package com.aliseon.ott.activity;

import android.content.*;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskAuth;

import java.util.ArrayList;
import java.util.Locale;

import static com.aliseon.ott.Variable.*;

public class LoadingActivity extends AppCompatActivity {

    public static SharedPreferences pref;

    private static String TAG2 = "Shared값 가져오기";

    private static String TAG = "휴대폰 정보 가져오기";
    public static MyHandler LoadingmHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userinfouid = new ArrayList<>();
        userinfo = new ArrayList<>();

        atrend_id = new ArrayList<>();
        atrend_user_id = new ArrayList<>();
        atrend_type = new ArrayList<>();
        atrend_product_id = new ArrayList<>();
        atrend_contents_id = new ArrayList<>();
        atrend_title = new ArrayList<>();
        atrend_subtitle = new ArrayList<>();
        atrend_description = new ArrayList<>();
        atrend_summary = new ArrayList<>();
        atrend_view = new ArrayList<>();
        atrend_like = new ArrayList<>();
        atrend_color = new ArrayList<>();
        atrend_start_at = new ArrayList<>();
        atrend_create_at = new ArrayList<>();
        atrend_update_at = new ArrayList<>();
        atrend_opacity = new ArrayList<>();
        atrend_status = new ArrayList<>();
        atrend_background = new ArrayList<>();
        atrend_thumbnail = new ArrayList<>();

        atrend_detail_detp_html = new ArrayList<>();
        atrend_detail_maincontent = new ArrayList<>();
        atrend_detail_product_id = new ArrayList<>();
        atrend_detail_product_name = new ArrayList<>();
        atrend_detail_product_brand = new ArrayList<>();
        atrend_detail_product_thumbnail = new ArrayList<>();
        atrend_detail_product_price = new ArrayList<>();
        atrend_detail_product_previous_price = new ArrayList<>();

        atrend_related_id = new ArrayList<>();
        atrend_related_user_id = new ArrayList<>();
        atrend_related_type = new ArrayList<>();
        atrend_related_product_id = new ArrayList<>();
        atrend_related_contents_id = new ArrayList<>();
        atrend_related_title = new ArrayList<>();
        atrend_related_subtitle = new ArrayList<>();
        atrend_related_description = new ArrayList<>();
        atrend_related_summary = new ArrayList<>();
        atrend_related_view = new ArrayList<>();
        atrend_related_like = new ArrayList<>();
        atrend_related_color = new ArrayList<>();
        atrend_related_start_at = new ArrayList<>();
        atrend_related_create_at = new ArrayList<>();
        atrend_related_update_at = new ArrayList<>();
        atrend_related_opacity = new ArrayList<>();
        atrend_related_status = new ArrayList<>();
        atrend_related_background = new ArrayList<>();
        atrend_related_thumbnail = new ArrayList<>();

        popular_id = new ArrayList<>();
        popular_user_id = new ArrayList<>();
        popular_product_id = new ArrayList<>();
        popular_contents_id = new ArrayList<>();
        popular_contents_type = new ArrayList<>();
        popular_category_id = new ArrayList<>();
        popular_status = new ArrayList<>();
        popular_description = new ArrayList<>();
        popular_create_at = new ArrayList<>();
        popular_update_at = new ArrayList<>();
        popular_like_count = new ArrayList<>();
        popular_view_count = new ArrayList<>();
        popular_comment_count = new ArrayList<>();
        popular_category_en = new ArrayList<>();
        popular_category_kr = new ArrayList<>();
        popular_nickname = new ArrayList<>();
        popular_photo = new ArrayList<>();
        popular_p_thumbnail = new ArrayList<>();

        cate_name = new ArrayList<>();
        cate_number = new ArrayList<>();

        popular_detail_id = new ArrayList<>();
        popular_detail_user_id = new ArrayList<>();
        popular_detail_product_id = new ArrayList<>();
        popular_detail_contents_id = new ArrayList<>();
        popular_detail_contents_type = new ArrayList<>();
        popular_detail_category_id = new ArrayList<>();
        popular_detail_status = new ArrayList<>();
        popular_detail_description = new ArrayList<>();
        popular_detail_create_at = new ArrayList<>();
        popular_detail_update_at = new ArrayList<>();
        popular_detail_like_count = new ArrayList<>();
        popular_detail_view_count = new ArrayList<>();
        popular_detail_comment_count = new ArrayList<>();
        popular_detail_category_en = new ArrayList<>();
        popular_detail_category_kr = new ArrayList<>();
        popular_detail_name = new ArrayList<>();
        popular_detail_photo = new ArrayList<>();
        popular_detail_contents = new ArrayList<>();
        popular_detail_items = new ArrayList<>();

        popular_detail_item_id = new ArrayList<>();
        popular_detail_item_name = new ArrayList<>();
        popular_detail_item_brand = new ArrayList<>();
        popular_detail_item_thumbnail = new ArrayList<>();
        popular_detail_item_price = new ArrayList<>();
        popular_detail_item_previous_price = new ArrayList<>();

        popular_related_id = new ArrayList<>();
        popular_related_user_id = new ArrayList<>();
        popular_related_status = new ArrayList<>();
        popular_related_description = new ArrayList<>();
        popular_related_create_at = new ArrayList<>();
        popular_related_update_at = new ArrayList<>();
        popular_related_like_count = new ArrayList<>();
        popular_related_view_count = new ArrayList<>();
        popular_related_comment_count = new ArrayList<>();
        popular_related_contents = new ArrayList<>();

        cart_items_p_option_stock = new ArrayList<>();
        cart_shop_id = new ArrayList<>();
        cart_shop_photo = new ArrayList<>();
        cart_shop_nickname = new ArrayList<>();
        cart_shop_shop_name = new ArrayList<>();
        cart_items_p_cart_id = new ArrayList<>();
        cart_items_p_user_id = new ArrayList<>();
        cart_items_p_option_value = new ArrayList<>();
        cart_items_p_option_price = new ArrayList<>();
        cart_items_p_product_id = new ArrayList<>();
        cart_items_p_status = new ArrayList<>();
        cart_items_p_vendor_id = new ArrayList<>();
        cart_items_p_name = new ArrayList<>();
        cart_items_p_thumbnail = new ArrayList<>();
        cart_items_p_ship = new ArrayList<>();
        cart_items_p_previous_price = new ArrayList<>();
        cart_items_p_price = new ArrayList<>();

        cartdetail_productbuy_option_name = new ArrayList<>();
        cartdetail_productbuy_p_option_name = new ArrayList<>();
        cartdetail_productbuy_p_option_original_value = new ArrayList<>();
        cartdetail_productbuy_p_option_original_price = new ArrayList<>();
        cartdetail_productbuy_p_option_value = new ArrayList<>();
        cartdetail_productbuy_p_option_price = new ArrayList<>();
        cartdetail_productbuy_p_option_stock = new ArrayList<>();
        cartdetail_productbuy_option_connection = new ArrayList<>();

        addoption = new ArrayList<>();
        cartitemoption = new ArrayList<>();

        voyage_id = new ArrayList<>();
        voyage_user_id = new ArrayList<>();
        voyage_product_id = new ArrayList<>();
        voyage_contents_id = new ArrayList<>();
        voyage_contents_type = new ArrayList<>();
        voyage_category_id = new ArrayList<>();
        voyage_status = new ArrayList<>();
        voyage_description = new ArrayList<>();
        voyage_create_at = new ArrayList<>();
        voyage_update_at = new ArrayList<>();
        voyage_like_count = new ArrayList<>();
        voyage_view_count = new ArrayList<>();
        voyage_comment_count = new ArrayList<>();
        voyage_category_en = new ArrayList<>();
        voyage_category_kr = new ArrayList<>();
        voyage_nickname = new ArrayList<>();
        voyage_photo = new ArrayList<>();
        voyage_p_thumbnail = new ArrayList<>();

        voyage_detail_id = new ArrayList<>();
        voyage_detail_user_id = new ArrayList<>();
        voyage_detail_product_id = new ArrayList<>();
        voyage_detail_contents_id = new ArrayList<>();
        voyage_detail_contents_type = new ArrayList<>();
        voyage_detail_category_id = new ArrayList<>();
        voyage_detail_status = new ArrayList<>();
        voyage_detail_description = new ArrayList<>();
        voyage_detail_create_at = new ArrayList<>();
        voyage_detail_update_at = new ArrayList<>();
        voyage_detail_like_count = new ArrayList<>();
        voyage_detail_view_count = new ArrayList<>();
        voyage_detail_comment_count = new ArrayList<>();
        voyage_detail_category_en = new ArrayList<>();
        voyage_detail_category_kr = new ArrayList<>();
        voyage_detail_nickname = new ArrayList<>();
        voyage_detail_photo = new ArrayList<>();
        voyage_detail_contents = new ArrayList<>();
        voyage_detail_items = new ArrayList<>();

        voyage_detail_item_id = new ArrayList<>();
        voyage_detail_item_name = new ArrayList<>();
        voyage_detail_item_brand = new ArrayList<>();
        voyage_detail_item_thumbnail = new ArrayList<>();
        voyage_detail_item_price = new ArrayList<>();
        voyage_detail_item_previous_price = new ArrayList<>();

        voyage_related_id = new ArrayList<>();
        voyage_related_user_id = new ArrayList<>();
        voyage_related_status = new ArrayList<>();
        voyage_related_description = new ArrayList<>();
        voyage_related_create_at = new ArrayList<>();
        voyage_related_update_at = new ArrayList<>();
        voyage_related_like_count = new ArrayList<>();
        voyage_related_view_count = new ArrayList<>();
        voyage_related_comment_count = new ArrayList<>();
        voyage_related_contents = new ArrayList<>();

        voyageresult_id = new ArrayList<>();
        voyageresult_user_id = new ArrayList<>();
        voyageresult_product_id = new ArrayList<>();
        voyageresult_contents_id = new ArrayList<>();
        voyageresult_contents_type = new ArrayList<>();
        voyageresult_category_id = new ArrayList<>();
        voyageresult_status = new ArrayList<>();
        voyageresult_description = new ArrayList<>();
        voyageresult_create_at = new ArrayList<>();
        voyageresult_update_at = new ArrayList<>();
        voyageresult_like_count = new ArrayList<>();
        voyageresult_view_count = new ArrayList<>();
        voyageresult_comment_count = new ArrayList<>();
        voyageresult_category_en = new ArrayList<>();
        voyageresult_category_kr = new ArrayList<>();
        voyageresult_photo = new ArrayList<>();
        voyageresult_nickname = new ArrayList<>();
        voyageresult_p_thumbnail = new ArrayList<>();

        subscribe_creator_list_id = new ArrayList<>();
        subscribe_creator_list_nickname = new ArrayList<>();
        subscribe_creator_list_photo = new ArrayList<>();

        subscribe_voyage_list_update_at = new ArrayList<>();
        subscribe_voyage_list_like_count = new ArrayList<>();
        subscribe_voyage_list_view_count = new ArrayList<>();
        subscribe_voyage_list_comment_count = new ArrayList<>();
        subscribe_voyage_list_category_en = new ArrayList<>();
        subscribe_voyage_list_category_kr = new ArrayList<>();
        subscribe_voyage_list_name = new ArrayList<>();
        subscribe_voyage_list_photo = new ArrayList<>();
        subscribe_voyage_list_create_at = new ArrayList<String>();
        subscribe_voyage_list_id = new ArrayList<String>();
        subscribe_voyage_list_user_id = new ArrayList<String>();
        subscribe_voyage_list_product_id = new ArrayList<String>();
        subscribe_voyage_list_contents_id = new ArrayList<String>();
        subscribe_voyage_list_contents_type = new ArrayList<String>();
        subscribe_voyage_list_category_id = new ArrayList<String>();
        subscribe_voyage_list_status = new ArrayList<>();
        subscribe_voyage_list_create_at = new ArrayList<String>();
        subscribe_voyage_list_description = new ArrayList<String>();
        subscribe_voyage_list_p_thumbnail = new ArrayList<>();
        subscribe_voyage_list_c_thumbnail = new ArrayList<String>();

        my_list_id = new ArrayList<>();
        my_list_user_id = new ArrayList<>();
        my_list_status = new ArrayList<>();
        my_list_description = new ArrayList<>();
        my_list_create_at = new ArrayList<>();
        my_list_update_at = new ArrayList<>();
        my_list_like_count = new ArrayList<>();
        my_list_view_count = new ArrayList<>();
        my_list_comment_count = new ArrayList<>();
        my_list_p_thumbnail = new ArrayList<>();
        my_list_nickname = new ArrayList<>();
        my_list_profile = new ArrayList<>();

        creator_list_id = new ArrayList<>();
        creator_list_user_id = new ArrayList<>();
        creator_list_status = new ArrayList<>();
        creator_list_description = new ArrayList<>();
        creator_list_create_at = new ArrayList<>();
        creator_list_update_at = new ArrayList<>();
        creator_list_like_count = new ArrayList<>();
        creator_list_view_count = new ArrayList<>();
        creator_list_comment_count = new ArrayList<>();
        creator_list_p_thumbnail = new ArrayList<>();
        creator_list_c_thumbnail = new ArrayList<>();
        creator_list_nickname = new ArrayList<>();
        creator_list_profile = new ArrayList<>();

        creatordetail_list_id = new ArrayList<>();
        creatordetail_list_nickname = new ArrayList<>();
        creatordetail_list_photo = new ArrayList<>();
        creatordetail_list_is_subscribe = new ArrayList<>();
        creatordetail_list_subscribeto_cnt = new ArrayList<>();
        creatordetail_list_contents_cnt = new ArrayList<>();

        mydetail_list_id = new ArrayList<>();
        mydetail_list_nickname = new ArrayList<>();
        mydetail_list_photo = new ArrayList<>();
        mydetail_list_is_subscribe = new ArrayList<>();
        mydetail_list_subscribeto_cnt = new ArrayList<>();
        mydetail_list_contents_cnt = new ArrayList<>();

        from_fav_channel_id = new ArrayList<>();
        from_fav_channel_nickname = new ArrayList<>();
        from_fav_channel_photo = new ArrayList<>();

        to_fav_channel_id = new ArrayList<>();
        to_fav_channel_nickname = new ArrayList<>();
        to_fav_channel_photo = new ArrayList<>();



        recommend_id = new ArrayList<>();
        recommend_nickname = new ArrayList<>();
        recommend_photo = new ArrayList<>();
        recommend_subscribeto_cnt = new ArrayList<>();
        recommend_contents_cnt = new ArrayList<>();

        player_feed_list_id = new ArrayList<>();
        player_feed_list_crop = new ArrayList<>();
        player_feed_list_content = new ArrayList<>();
        player_feed_list_author_nickname = new ArrayList<>();
        player_feed_list_author_picture = new ArrayList<>();
        player_feed_list_views = new ArrayList<>();

        usersetting_category = new ArrayList<>();

        cate_name.add(getString(R.string.all));
        cate_number.add(0);

        usersetting_category.add(getResources().getString(R.string.account_management));
        usersetting_category.add(getResources().getString(R.string.language_setting));

        pref = getSharedPreferences("login_session", MODE_PRIVATE);

        readData();

        LoadingmHandler = new MyHandler();

//        int status = NetworkStatus.getConnectivityStatus(getApplicationContext());
//        if (status == NetworkStatus.TYPE_NOT_CONNECTED) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
//
//            builder.setTitle(getResources().getString(R.string.alertdialog_networkinfo));
//
//            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int id) {
//                    Intent intent = getIntent();
//                    finish();
//                    startActivity(intent);
//                }
//            });
//
//            AlertDialog alertDialog = builder.create();
//            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(051,051,051)));
//            alertDialog.show();
//
//
//        }

        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.d(TAG, "Android_ID >>> " + android_id);

        LoadingmHandler.post(new Runnable() {
            @Override
            public void run() {
                NetworkTaskAuth networkTaskauth = new NetworkTaskAuth(api_auth, null);
                networkTaskauth.execute();
            }
        });
    }

//    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {
                if (pref.getString("userinfo_name", "").equals("") && pref.getString("userinfo_picture", "").equals("") && pref.getInt("user_id", 0) == 0 && pref.getString("language", "").equals("") && pref.getBoolean("selectaccount", true) == true && pref.getString("country", "").equals("") && pref.getString("currency", "").equals("") && userinfouid.size() != 0) {
                    Intent intent = new Intent(LoadingActivity.this, SettingUserManagementActivity.class);
                    Log.d("1000", "a");
                    startActivity(intent);
                    finish();
                } //계정 정보가 있는데 로그인이 안되어 있는 경우
                else if (pref.getString("userinfo_name", "").equals("empty") && pref.getString("userinfo_picture", "").equals("empty") && pref.getInt("user_id", 0) == 0 && pref.getString("language", "").equals("empty") && pref.getBoolean("selectaccount", true) == false && pref.getString("country", "").equals("empty") && pref.getString("currency", "").equals("empty") && userinfouid.size() != 0) {
                    Intent intent = new Intent(LoadingActivity.this, SettingUserManagementActivity.class);
                    Log.d("1000", "b");
                    startActivity(intent);
                    finish();
                }
                //앱 첫 진입 시 경우
                else if (pref.getString("userinfo_name", "").equals("") && pref.getString("userinfo_picture", "").equals("") && pref.getInt("user_id", 0) == 0 && pref.getString("language", "").equals("") && pref.getBoolean("selectaccount", true) == true && pref.getString("country", "").equals("") && pref.getString("currency", "").equals("") && userinfouid.size() == 0) {
                    Intent intent = new Intent(LoadingActivity.this, InfoCheckActivity.class);
                    Log.d("1000", "c");
                    startActivity(intent);
                    finish();
                }
                //앱 첫 진입 시 경우 and session empty
                else if (pref.getString("userinfo_name", "").equals("empty") && pref.getString("userinfo_picture", "").equals("empty") && pref.getInt("user_id", 0) == 0 && pref.getString("language", "").equals("empty") && pref.getBoolean("selectaccount", true) == false && pref.getString("country", "").equals("empty") && pref.getString("currency", "").equals("empty") && userinfouid.size() == 0) {
                    Intent intent = new Intent(LoadingActivity.this, InfoCheckActivity.class);
                    Log.d("1000", "d");
                    startActivity(intent);
                    finish();
                } else {
                    switch (pref.getString("language", "")) {
                        case "kr":
                            Locale lang1 = Locale.KOREAN;
                            Configuration config1 = new Configuration();
                            config1.locale = lang1;
                            getResources().updateConfiguration(config1, getResources().getDisplayMetrics());
                            break;
                        case "en":
                            Locale lang2 = Locale.ENGLISH;
                            Configuration config2 = new Configuration();
                            config2.locale = lang2;
                            getResources().updateConfiguration(config2, getResources().getDisplayMetrics());
                        case "ar":
                            Locale lang3 = Locale.ENGLISH;
                            Configuration config3 = new Configuration();
                            config3.locale = lang3;
                            getResources().updateConfiguration(config3, getResources().getDisplayMetrics());
                    }
                    Intent intent = new Intent(LoadingActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            if(msg.what == 800){
                Intent intent = new Intent(LoadingActivity.this, InfoCheckActivity.class);
                Log.d("800", "a");
                startActivity(intent);
                finish();
            }

        }
    }

    public static void setDataGusetinfo() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putString("userinfo_name", "empty");
        editor.putString("userinfo_picture", "empty");
        editor.putInt("user_id", 0);
        editor.putString("language", "empty");
        editor.putString("country", "empty");
        editor.putString("currency", "empty");
        editor.putBoolean("selectaccount", false);
        logincurrency = pref.getString("currency", "");
        loginlanguage = pref.getString("language", "");
        editor.commit();
    }

    public static void setDataUserinfo() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();

        editor.putString("userinfo_name", userinfo.get(0));
        editor.putString("userinfo_picture", userinfo.get(1));
        editor.putInt("user_id", userinfouid.get(0));
        editor.putString("language", userinfo.get(2));
        editor.putString("country", userinfo.get(3));
        editor.putString("currency", userinfo.get(4));
        editor.putBoolean("selectaccount", true);
        editor.commit();
    }

    public static void setDataLanguageSetting() {
        SharedPreferences.Editor editor = pref.edit();

        if(loginid == 0) {

            editor.clear();
            editor.putString("userinfo_name", "empty");
            editor.putString("userinfo_picture", "empty");
            editor.putInt("user_id", 0);
            editor.putString("language", loginlanguage);
            editor.putString("country", logincountry);
            editor.putString("currency", logincurrency);
            editor.putBoolean("selectaccount", false);

            editor.commit();

        } else {

            editor.clear();
            editor.putInt("userinfo_name", userinfouid.get(0));
            editor.putString("userinfo_picture", userinfo.get(1));
            editor.putInt("user_id", loginid);
            editor.putString("language", loginlanguage);
            editor.putString("country", logincountry);
            editor.putString("currency", logincurrency);
            editor.putBoolean("selectaccount", true);
            editor.commit();

        }

    }

    public static void setDefaultDataUserLanguageSetting() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putString("userinfo_name", userinfo.get(0));
        editor.putString("userinfo_picture", userinfo.get(2));
        editor.putInt("user_id", userinfouid.get(0));
        editor.putString("language", "ar");
        editor.putString("country", "AE");
        editor.putString("currency", "AED");
        editor.putBoolean("selectaccount", true);
        editor.commit();
    }

    public static void setDefaultDataGuestLanguageSetting() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putString("userinfo_name", "empty");
        editor.putString("userinfo_picture", "empty");
        editor.putInt("user_id", 0);
        editor.putString("language", "ar");
        editor.putString("country", "AE");
        editor.putString("currency", "AED");
        editor.putBoolean("selectaccount", false);
        editor.commit();
    }

    public static void setChangeAccount1() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putString("userinfo_name", userinfo.get(0));
        editor.putString("userinfo_picture", userinfo.get(1));
        editor.putInt("user_id", userinfouid.get(0));
        editor.putString("language", userinfo.get(2));
        editor.putString("country", userinfo.get(3));
        editor.putString("currency", userinfo.get(4));
        editor.putBoolean("selectaccount", true);
        editor.commit();
    }

    public static void setChangeAccount2() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putString("userinfo_name", userinfo.get(5));
        editor.putString("userinfo_picture", userinfo.get(6));
        editor.putInt("user_id", userinfouid.get(1));
        editor.putString("language", userinfo.get(7));
        editor.putString("country", userinfo.get(8));
        editor.putString("currency", userinfo.get(9));
        editor.putBoolean("selectaccount", true);
        editor.commit();
    }

    public static void setChangeAccount3() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putString("userinfo_name", userinfo.get(10));
        editor.putString("userinfo_picture", userinfo.get(11));
        editor.putInt("user_id", userinfouid.get(2));
        editor.putString("language", userinfo.get(12));
        editor.putString("country", userinfo.get(13));
        editor.putString("currency", userinfo.get(14));
        editor.putBoolean("selectaccount", true);
        editor.commit();
    }

    public static void CheckUsedUserDisconnect1() {
        SharedPreferences.Editor editor1 = pref.edit();
        if(userinfouid.size() == 0){

        }else if (pref.getInt("user_id", 0) == userinfouid.get(0)) {
            editor1.putString("userinfo_name", "empty");
            editor1.putString("userinfo_picture", "empty");
            editor1.putInt("user_id", 0);
            editor1.putString("language", "empty");
            editor1.putString("country", "empty");
            editor1.putString("currency", "empty");
            editor1.putBoolean("selectaccount", false);
            editor1.commit();
        }
    }

    public static void CheckUsedUserDisconnect2() {
        SharedPreferences.Editor editor2 = pref.edit();
        if (pref.getInt("user_id", 0) == userinfouid.get(1)) {
            editor2.putString("userinfo_name", "empty");
            editor2.putString("userinfo_picture", "empty");
            editor2.putInt("user_id", 0);
            editor2.putString("language", "empty");
            editor2.putString("country", "empty");
            editor2.putString("currency", "empty");
            editor2.putBoolean("selectaccount", false);
            editor2.commit();
        }
    }

    public static void CheckUsedUserDisconnect3() {
        SharedPreferences.Editor editor3 = pref.edit();
        if (pref.getInt("user_id", 0) == userinfouid.get(2)) {
            editor3.putString("userinfo_name", "empty");
            editor3.putString("userinfo_picture", "empty");
            editor3.putInt("user_id", 0);
            editor3.putString("language", "empty");
            editor3.putString("country", "empty");
            editor3.putString("currency", "empty");
            editor3.putBoolean("selectaccount", false);
            editor3.commit();
        }
    }

    public void readData()
    {

        pref = getSharedPreferences("login_session",MODE_PRIVATE);
        pref.getString("userinfo_name", "");
        Log.d(TAG2, "info >>> " + pref.getString("userinfo_name", ""));
        pref.getString("userinfo_picture", "");
        Log.d(TAG2, "picture >>> " + pref.getString("userinfo_picture", ""));
        pref.getInt("user_id", 0);
        Log.d(TAG2, "id >>> " + pref.getInt("user_id", 0));
        loginid = pref.getInt("user_id", 0);
        pref.getString("language", "");
        Log.d(TAG2, "language >>> " + pref.getString("language", ""));
        loginlanguage = pref.getString("language", "");
        pref.getBoolean("selectaccount", true);
        Log.d(TAG2, "selectaccount >>> " + pref.getBoolean("selectaccount", true));
        pref.getString("country", "");
        Log.d(TAG2, "country >>> " + pref.getString("country", ""));
        pref.getString("currency", "");
        Log.d(TAG2, "currency >>> " + pref.getString("currency", ""));
        logincurrency = pref.getString("currency", "");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }

}