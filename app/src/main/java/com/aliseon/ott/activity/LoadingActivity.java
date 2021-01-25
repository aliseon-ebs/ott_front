package com.aliseon.ott.activity;

import android.content.*;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.aliseon.ott.API.Auth;
import com.aliseon.ott.API.TvottUsers;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.aliseon.ott.Aliseon.*;
import com.aliseon.ott.activity.*;

public class LoadingActivity extends AppCompatActivity {

    public static SharedPreferences pref;

    public static MyHandler LoadingmHandler;

    private AliseonAPI AliseonAPI;
    String android_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        aliseon.aliseon_setTvott_userinfouid(new ArrayList<>());
        aliseon.aliseon_setTvott_userinfo(new ArrayList<>());

        aliseon.aliseon_setHomeAPIload(0);
        aliseon.aliseon_setVoyageAPIload(0);
        aliseon.aliseon_setVoyageCategoryAPIload(0);
        aliseon.aliseon_setVoyageFocusAPIload(0);

        aliseon.aliseon_setSubscribeAPIload(0);
        aliseon.aliseon_setSubscribeFocusAPIload(0);
        aliseon.aliseon_setVoyageResultAPIload(0);
        aliseon.aliseon_setSettinguseraccountmanagementapiload(0);
        aliseon.aliseon_setCartAPIload(0);
        aliseon.aliseon_setCartdetailAPIload(0);
        aliseon.aliseon_setMyAPIload(0);
        aliseon.aliseon_setCreatorAPIload(0);
        aliseon.aliseon_setMyDetailAPIload(0);
        aliseon.aliseon_setCreatorDetailAPIload(0);
        aliseon.aliseon_setUsersettinglanguageAPIload(0);

        aliseon.aliseon_setAtrend_detail_detp_html(new ArrayList<>());
        aliseon.aliseon_setAtrend_detail_maincontent(new ArrayList<>());
        aliseon.aliseon_setAtrend_detail_product_id(new ArrayList<>());
        aliseon.aliseon_setAtrend_detail_product_name(new ArrayList<>());
        aliseon.aliseon_setAtrend_detail_product_brand(new ArrayList<>());
        aliseon.aliseon_setAtrend_detail_product_thumbnail(new ArrayList<>());
        aliseon.aliseon_setAtrend_detail_product_price(new ArrayList<>());
        aliseon.aliseon_setAtrend_detail_product_previous_price(new ArrayList<>());

        aliseon.aliseon_setAtrend_related_id(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_user_id(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_type(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_product_id(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_contents_id(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_title(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_subtitle(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_description(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_summary(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_view(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_like(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_color(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_start_at(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_create_at(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_update_at(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_opacity(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_status(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_background(new ArrayList<>());
        aliseon.aliseon_setAtrend_related_thumbnail(new ArrayList<>());

        aliseon.aliseon_setPopular_id(new ArrayList<>());
        aliseon.aliseon_setPopular_user_id(new ArrayList<>());
        aliseon.aliseon_setPopular_product_id(new ArrayList<>());
        aliseon.aliseon_setPopular_contents_id(new ArrayList<>());
        aliseon.aliseon_setPopular_contents_type(new ArrayList<>());
        aliseon.aliseon_setPopular_category_id(new ArrayList<>());
        aliseon.aliseon_setPopular_status(new ArrayList<>());
        aliseon.aliseon_setPopular_description(new ArrayList<>());
        aliseon.aliseon_setPopular_create_at(new ArrayList<>());
        aliseon.aliseon_setPopular_update_at(new ArrayList<>());
        aliseon.aliseon_setPopular_like_count(new ArrayList<>());
        aliseon.aliseon_setPopular_comment_count(new ArrayList<>());
        aliseon.aliseon_setPopular_category_en(new ArrayList<>());
        aliseon.aliseon_setPopular_category_kr(new ArrayList<>());
        aliseon.aliseon_setPopular_nickname(new ArrayList<>());
        aliseon.aliseon_setPopular_photo(new ArrayList<>());
        aliseon.aliseon_setPopular_p_thumbnail(new ArrayList<>());

        aliseon.aliseon_setPopular_detail_id(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_user_id(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_product_id(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_contents_id(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_contents_type(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_category_id(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_status(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_description(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_create_at(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_update_at(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_like_count(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_view_count(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_comment_count(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_category_en(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_category_kr(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_name(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_photo(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_contents(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_items(new ArrayList<>());

        aliseon.aliseon_setPopular_detail_item_id(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_item_name(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_item_brand(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_item_thumbnail(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_item_price(new ArrayList<>());
        aliseon.aliseon_setPopular_detail_item_previous_price(new ArrayList<>());

        aliseon.aliseon_setPopular_related_id(new ArrayList<>());
        aliseon.aliseon_setPopular_related_user_id(new ArrayList<>());
        aliseon.aliseon_setPopular_related_status(new ArrayList<>());
        aliseon.aliseon_setPopular_related_description(new ArrayList<>());
        aliseon.aliseon_setPopular_related_create_at(new ArrayList<>());
        aliseon.aliseon_setPopular_related_update_at(new ArrayList<>());
        aliseon.aliseon_setPopular_related_like_count(new ArrayList<>());
        aliseon.aliseon_setPopular_related_view_count(new ArrayList<>());
        aliseon.aliseon_setPopular_related_comment_count(new ArrayList<>());
        aliseon.aliseon_setPopular_related_contents(new ArrayList<>());

        aliseon.aliseon_setCart_shop_id(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_option_stock(new ArrayList<>());
        aliseon.aliseon_setCart_shop_id(new ArrayList<>());
        aliseon.aliseon_setCart_shop_photo(new ArrayList<>());
        aliseon.aliseon_setCart_shop_nickname(new ArrayList<>());
        aliseon.aliseon_setCart_shop_name(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_cart_id(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_user_id(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_option_value(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_option_price(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_product_id(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_status(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_vendor_id(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_name(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_thumbnail(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_ship(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_previous_price(new ArrayList<>());
        aliseon.aliseon_setCart_items_p_price(new ArrayList<>());

        // need check
        aliseon.aliseon_setCartdetail_productbuy_option_name(new ArrayList<>());
        aliseon.aliseon_setCartdetail_productbuy_p_option_name(new ArrayList<>());
        aliseon.aliseon_setCartdetail_productbuy_p_option_original_value(new ArrayList<>());
        aliseon.aliseon_setCartdetail_productbuy_p_option_original_price(new ArrayList<>());
        aliseon.aliseon_setCartdetail_productbuy_p_option_value(new ArrayList<>());
        aliseon.aliseon_setCartdetail_productbuy_p_option_price(new ArrayList<>());
        aliseon.aliseon_setCartdetail_productbuy_p_option_stock(new ArrayList<>());
        aliseon.aliseon_setCartdetail_productbuy_option_connection(new ArrayList<>());

        aliseon.aliseon_setAddoption(new ArrayList<>());
        aliseon.aliseon_setCartitemoption(new ArrayList<>());

        aliseon.aliseon_setVoyage_detail_id(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_user_id(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_product_id(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_contents_id(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_contents_type(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_category_id(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_status(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_description(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_create_at(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_update_at(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_like_count(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_view_count(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_comment_count(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_category_en(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_category_kr(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_nickname(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_photo(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_contents(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_items(new ArrayList<>());

        aliseon.aliseon_setVoyage_detail_item_id(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_item_name(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_item_brand(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_item_thumbnail(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_item_price(new ArrayList<>());
        aliseon.aliseon_setVoyage_detail_item_previous_price(new ArrayList<>());

        aliseon.aliseon_setVoyage_related_id(new ArrayList<>());
        aliseon.aliseon_setVoyage_related_user_id(new ArrayList<>());
        aliseon.aliseon_setVoyage_related_status(new ArrayList<>());
        aliseon.aliseon_setVoyage_related_description(new ArrayList<>());
        aliseon.aliseon_setVoyage_related_create_at(new ArrayList<>());
        aliseon.aliseon_setVoyage_related_update_at(new ArrayList<>());
        aliseon.aliseon_setVoyage_related_like_count(new ArrayList<>());
        aliseon.aliseon_setVoyage_related_view_count(new ArrayList<>());
        aliseon.aliseon_setVoyage_related_comment_count(new ArrayList<>());
        aliseon.aliseon_setVoyage_related_contents(new ArrayList<>());

        aliseon.aliseon_setVoyageresult_id(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_user_id(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_product_id(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_contents_id(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_contents_type(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_category_id(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_status(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_description(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_create_at(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_update_at(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_like_count(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_view_count(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_comment_count(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_category_en(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_category_kr(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_photo(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_nickname(new ArrayList<>());
        aliseon.aliseon_setVoyageresult_p_thumbnail(new ArrayList<>());

        aliseon.aliseon_setSubscribe_creator_list_id(new ArrayList<>());
        aliseon.aliseon_setSubscribe_creator_list_nickname(new ArrayList<>());
        aliseon.aliseon_setSubscribe_creator_list_photo(new ArrayList<>());

        aliseon.aliseon_setSubscribe_voyage_list_update_at(new ArrayList<>());
        aliseon.aliseon_setSubscribe_voyage_list_like_count(new ArrayList<>());
        aliseon.aliseon_setSubscribe_voyage_list_view_count(new ArrayList<>());
        aliseon.aliseon_setSubscribe_voyage_list_comment_count(new ArrayList<>());
        aliseon.aliseon_setSubscribe_voyage_list_category_en(new ArrayList<>());
        aliseon.aliseon_setSubscribe_voyage_list_category_kr(new ArrayList<>());
        aliseon.aliseon_setSubscribe_voyage_list_nickname(new ArrayList<>());
        aliseon.aliseon_setSubscribe_voyage_list_photo(new ArrayList<>());
        aliseon.aliseon_setSubscribe_voyage_list_create_at(new ArrayList<String>());
        aliseon.aliseon_setSubscribe_voyage_list_id(new ArrayList<String>());
        aliseon.aliseon_setSubscribe_voyage_list_user_id(new ArrayList<String>());
        aliseon.aliseon_setSubscribe_voyage_list_product_id(new ArrayList<String>());
        aliseon.aliseon_setSubscribe_voyage_list_contents_id(new ArrayList<String>());
        aliseon.aliseon_setSubscribe_voyage_list_contents_type(new ArrayList<String>());
        aliseon.aliseon_setSubscribe_voyage_list_category_id(new ArrayList<String>());
        aliseon.aliseon_setSubscribe_voyage_list_status(new ArrayList<>());
        aliseon.aliseon_setSubscribe_voyage_list_create_at(new ArrayList<String>());
        aliseon.aliseon_setSubscribe_voyage_list_description(new ArrayList<String>());
        aliseon.aliseon_setSubscribe_voyage_list_p_thumbnail(new ArrayList<>());
        aliseon.aliseon_setSubscribe_voyage_list_c_thumbnail(new ArrayList<String>());

        aliseon.aliseon_setMy_list_id(new ArrayList<>());
        aliseon.aliseon_setMy_list_user_id(new ArrayList<>());
        aliseon.aliseon_setMy_list_status(new ArrayList<>());
        aliseon.aliseon_setMy_list_description(new ArrayList<>());
        aliseon.aliseon_setMy_list_create_at(new ArrayList<>());
        aliseon.aliseon_setMy_list_update_at(new ArrayList<>());
        aliseon.aliseon_setMy_list_like_count(new ArrayList<>());
        aliseon.aliseon_setMy_list_view_count(new ArrayList<>());
        aliseon.aliseon_setMy_list_comment_count(new ArrayList<>());
        aliseon.aliseon_setMy_list_p_thumbnail(new ArrayList<>());
        aliseon.aliseon_setMy_list_nickname(new ArrayList<>());
        aliseon.aliseon_setMy_list_profile(new ArrayList<>());

        aliseon.aliseon_setCreator_list_id(new ArrayList<>());
        aliseon.aliseon_setCreator_list_user_id(new ArrayList<>());
        aliseon.aliseon_setCreator_list_status(new ArrayList<>());
        aliseon.aliseon_setCreator_list_description(new ArrayList<>());
        aliseon.aliseon_setCreator_list_create_at(new ArrayList<>());
        aliseon.aliseon_setCreator_list_update_at(new ArrayList<>());
        aliseon.aliseon_setCreator_list_like_count(new ArrayList<>());
        aliseon.aliseon_setCreator_list_view_count(new ArrayList<>());
        aliseon.aliseon_setCreator_list_comment_count(new ArrayList<>());
        aliseon.aliseon_setCreator_list_p_thumbnail(new ArrayList<>());
        aliseon.aliseon_setCreator_list_c_thumbnail(new ArrayList<>());
        aliseon.aliseon_setCreator_list_nickname(new ArrayList<>());
        aliseon.aliseon_setCreator_list_profile(new ArrayList<>());
//
        aliseon.aliseon_setCreatordetail_list_id(new ArrayList<>());
        aliseon.aliseon_setCreatordetail_list_nickname(new ArrayList<>());
        aliseon.aliseon_setCreatordetail_list_photo(new ArrayList<>());
        aliseon.aliseon_setCreatordetail_list_is_subscribe(new ArrayList<>());
        aliseon.aliseon_setCreatordetail_list_subscribeto_cnt(new ArrayList<>());
        aliseon.aliseon_setCreatordetail_list_contents_cnt(new ArrayList<>());

        aliseon.aliseon_setMydetail_list_id(new ArrayList<>());
        aliseon.aliseon_setMydetail_list_nickname(new ArrayList<>());
        aliseon.aliseon_setMydetail_list_photo(new ArrayList<>());
        aliseon.aliseon_setMydetail_list_is_subscribe(new ArrayList<>());
        aliseon.aliseon_setMydetail_list_subscribeto_cnt(new ArrayList<>());
        aliseon.aliseon_setMydetail_list_contents_cnt(new ArrayList<>());

        aliseon.aliseon_setPlayer_feed_list_author_id(new ArrayList<>());
        aliseon.aliseon_setPlayer_feed_list_crop(new ArrayList<>());
        aliseon.aliseon_setPlayer_feed_list_id(new ArrayList<>());
        aliseon.aliseon_setPlayer_feed_list_content(new ArrayList<>());
        aliseon.aliseon_setPlayer_feed_list_author_picture(new ArrayList<>());
        aliseon.aliseon_setPlayer_feed_list_author_nickname(new ArrayList<>());
        aliseon.aliseon_setPlayer_feed_list_views(new ArrayList<>());

        from_fav_channel_id = new ArrayList<>();
        from_fav_channel_nickname = new ArrayList<>();
        from_fav_channel_photo = new ArrayList<>();

        to_fav_channel_id = new ArrayList<>();
        to_fav_channel_nickname = new ArrayList<>();
        to_fav_channel_photo = new ArrayList<>();



//        recommend_id = new ArrayList<>();
//        recommend_nickname = new ArrayList<>();
//        recommend_photo = new ArrayList<>();
//        recommend_subscribeto_cnt = new ArrayList<>();
//        recommend_contents_cnt = new ArrayList<>();

        usersetting_category = new ArrayList<>();

        usersetting_category.add(getResources().getString(R.string.account_management));
        usersetting_category.add(getResources().getString(R.string.language_setting));

        pref = getSharedPreferences("login_session", MODE_PRIVATE);

        readData();

        LoadingmHandler = new MyHandler();

        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        aliseon.aliseon_setAndroid_id(android_id);

//        LoadingmHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                NetworkTaskAuth networkTaskauth = new NetworkTaskAuth(api_auth, null);
//                networkTaskauth.execute();
//            }
//        });

        AuthPost();

    }

//    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {

            Aliseon aliseon = (Aliseon) getApplicationContext();

            ArrayList<Integer> userinfouid = aliseon.aliseon_getTvott_userinfouid();

            pref = getSharedPreferences("login_session", MODE_PRIVATE);

            Log.d("CHECKING LOG", pref.getAll().toString() == "{}" ? "NULL" : "NOT NULL");

            // 다른 Thread에서 전달받은 Message 처리

//                if (pref.getString("userinfo_name", "").equals("") && pref.getString("userinfo_picture", "").equals("") && pref.getInt("user_id", 0) == 0 && pref.getString("language", "").equals("") && pref.getBoolean("selectaccount", true) == true && pref.getString("country", "").equals("") && pref.getString("currency", "").equals("") && userinfouid.size() != 0) {
//                    Intent intent = new Intent(LoadingActivity.this, SettingUserManagementActivity.class);
//                    Log.d("1000", "a");
//                    startActivity(intent);
//                    finish();
//                } //계정 정보가 있는데 로그인이 안되어 있는 경우
//                else if (pref.getString("userinfo_name", "").equals("empty") && pref.getString("userinfo_picture", "").equals("empty") && pref.getInt("user_id", 0) == 0 && pref.getString("language", "").equals("empty") && pref.getBoolean("selectaccount", true) == false && pref.getString("country", "").equals("empty") && pref.getString("currency", "").equals("empty") && userinfouid.size() != 0) {
//                    Intent intent = new Intent(LoadingActivity.this, SettingUserManagementActivity.class);
//                    Log.d("1000", "b");
//                    startActivity(intent);
//                    finish();
//                }
                //앱 첫 진입 시 경우
//              else if (pref.getString("userinfo_name", "").equals("") && pref.getString("userinfo_picture", "").equals("") && pref.getInt("user_id", 0) == 0 && pref.getString("language", "").equals("") && pref.getBoolean("selectaccount", true) == true && pref.getString("country", "").equals("") && pref.getString("currency", "").equals("") && userinfouid.size() == 0) {
//            if (pref.getString("userinfo_name", "").equals("") && pref.getString("userinfo_picture", "").equals("") && pref.getInt("user_id", 0) == 0 && pref.getString("language", "").equals("") && pref.getBoolean("selectaccount", true) == true && pref.getString("country", "").equals("") && pref.getString("currency", "").equals("") && userinfouid.size() == 0) {
                if (pref.getAll().toString() == "{}") {
                    Intent intent = new Intent(LoadingActivity.this, InfoCheckActivity.class);
                    Log.d("1000", "c");
                    startActivity(intent);
                    finish();
                }
                //앱 첫 진입 시 경우 and session empty
                else if (pref.getString("userinfo_name", "").equals("empty") && pref.getString("userinfo_picture", "").equals("empty") && pref.getInt("user_id", 0) == 0 && pref.getString("language", "").equals("empty") && pref.getBoolean("selectaccount", true) == false && pref.getString("country", "").equals("empty") && pref.getString("currency", "").equals("empty") && userinfouid.isEmpty() == true) {
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

            if(msg.what == 800){
                Intent intent = new Intent(LoadingActivity.this, InfoCheckActivity.class);
                Log.d("800", "a");
                startActivity(intent);
                finish();
            }

        }
    }

//    public static void setDataGusetinfo() {
//        SharedPreferences.Editor editor = pref.edit();
//        editor.clear();
//        editor.putString("userinfo_name", "empty");
//        editor.putString("userinfo_picture", "empty");
//        editor.putInt("user_id", 0);
//        editor.putString("language", "empty");
//        editor.putString("country", "empty");
//        editor.putString("currency", "empty");
//        editor.putBoolean("selectaccount", false);
//        logincurrency = pref.getString("currency", "");
//        loginlanguage = pref.getString("language", "");
//        editor.commit();
//    }
//
    private void setDataUserinfo() {

        Aliseon aliseon = (Aliseon) getApplicationContext();
        ArrayList<String> userinfo = aliseon.aliseon_getTvott_userinfo();
        ArrayList<Integer> userinfouid = aliseon.aliseon_getTvott_userinfouid();

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
//
//    public static void setDataLanguageSetting() {
//        SharedPreferences.Editor editor = pref.edit();
//
//        if(loginid == 0) {
//
//            editor.clear();
//            editor.putString("userinfo_name", "empty");
//            editor.putString("userinfo_picture", "empty");
//            editor.putInt("user_id", 0);
//            editor.putString("language", loginlanguage);
//            editor.putString("country", logincountry);
//            editor.putString("currency", logincurrency);
//            editor.putBoolean("selectaccount", false);
//
//            editor.commit();
//
//        } else {
//
//            editor.clear();
//            editor.putInt("userinfo_name", userinfouid.get(0));
//            editor.putString("userinfo_picture", userinfo.get(1));
//            editor.putInt("user_id", loginid);
//            editor.putString("language", loginlanguage);
//            editor.putString("country", logincountry);
//            editor.putString("currency", logincurrency);
//            editor.putBoolean("selectaccount", true);
//            editor.commit();
//
//        }
//
//    }
//
//    public static void setDefaultDataUserLanguageSetting() {
//        SharedPreferences.Editor editor = pref.edit();
//        editor.clear();
//        editor.putString("userinfo_name", userinfo.get(0));
//        editor.putString("userinfo_picture", userinfo.get(2));
//        editor.putInt("user_id", userinfouid.get(0));
//        editor.putString("language", "ar");
//        editor.putString("country", "AE");
//        editor.putString("currency", "AED");
//        editor.putBoolean("selectaccount", true);
//        editor.commit();
//    }
//
//    public static void setDefaultDataGuestLanguageSetting() {
//        SharedPreferences.Editor editor = pref.edit();
//        editor.clear();
//        editor.putString("userinfo_name", "empty");
//        editor.putString("userinfo_picture", "empty");
//        editor.putInt("user_id", 0);
//        editor.putString("language", "ar");
//        editor.putString("country", "AE");
//        editor.putString("currency", "AED");
//        editor.putBoolean("selectaccount", false);
//        editor.commit();
//    }
//
//    public static void setChangeAccount1() {
//        SharedPreferences.Editor editor = pref.edit();
//        editor.clear();
//        editor.putString("userinfo_name", userinfo.get(0));
//        editor.putString("userinfo_picture", userinfo.get(1));
//        editor.putInt("user_id", userinfouid.get(0));
//        editor.putString("language", userinfo.get(2));
//        editor.putString("country", userinfo.get(3));
//        editor.putString("currency", userinfo.get(4));
//        editor.putBoolean("selectaccount", true);
//        editor.commit();
//    }
//
//    public static void setChangeAccount2() {
//        SharedPreferences.Editor editor = pref.edit();
//        editor.clear();
//        editor.putString("userinfo_name", userinfo.get(5));
//        editor.putString("userinfo_picture", userinfo.get(6));
//        editor.putInt("user_id", userinfouid.get(1));
//        editor.putString("language", userinfo.get(7));
//        editor.putString("country", userinfo.get(8));
//        editor.putString("currency", userinfo.get(9));
//        editor.putBoolean("selectaccount", true);
//        editor.commit();
//    }
//
//    public static void setChangeAccount3() {
//        SharedPreferences.Editor editor = pref.edit();
//        editor.clear();
//        editor.putString("userinfo_name", userinfo.get(10));
//        editor.putString("userinfo_picture", userinfo.get(11));
//        editor.putInt("user_id", userinfouid.get(2));
//        editor.putString("language", userinfo.get(12));
//        editor.putString("country", userinfo.get(13));
//        editor.putString("currency", userinfo.get(14));
//        editor.putBoolean("selectaccount", true);
//        editor.commit();
//    }
//
//    public static void CheckUsedUserDisconnect1() {
//        SharedPreferences.Editor editor1 = pref.edit();
//        if(userinfouid.size() == 0){
//
//        }else if (pref.getInt("user_id", 0) == userinfouid.get(0)) {
//            editor1.putString("userinfo_name", "empty");
//            editor1.putString("userinfo_picture", "empty");
//            editor1.putInt("user_id", 0);
//            editor1.putString("language", "empty");
//            editor1.putString("country", "empty");
//            editor1.putString("currency", "empty");
//            editor1.putBoolean("selectaccount", false);
//            editor1.commit();
//        }
//    }
//
//    public static void CheckUsedUserDisconnect2() {
//        SharedPreferences.Editor editor2 = pref.edit();
//        if (pref.getInt("user_id", 0) == userinfouid.get(1)) {
//            editor2.putString("userinfo_name", "empty");
//            editor2.putString("userinfo_picture", "empty");
//            editor2.putInt("user_id", 0);
//            editor2.putString("language", "empty");
//            editor2.putString("country", "empty");
//            editor2.putString("currency", "empty");
//            editor2.putBoolean("selectaccount", false);
//            editor2.commit();
//        }
//    }
//
//    public static void CheckUsedUserDisconnect3() {
//        SharedPreferences.Editor editor3 = pref.edit();
//        if (pref.getInt("user_id", 0) == userinfouid.get(2)) {
//            editor3.putString("userinfo_name", "empty");
//            editor3.putString("userinfo_picture", "empty");
//            editor3.putInt("user_id", 0);
//            editor3.putString("language", "empty");
//            editor3.putString("country", "empty");
//            editor3.putString("currency", "empty");
//            editor3.putBoolean("selectaccount", false);
//            editor3.commit();
//        }
//    }

    public void readData()
    {
        String TAG2 = "Shared값 가져오기";
        Aliseon aliseon = (Aliseon) getApplicationContext();

        pref = getSharedPreferences("login_session",MODE_PRIVATE);

        pref.getString("userinfo_name", "");
        Log.d(TAG2, "info >>> " + pref.getString("userinfo_name", ""));

        pref.getString("userinfo_picture", "");
        Log.d(TAG2, "picture >>> " + pref.getString("userinfo_picture", ""));

        pref.getInt("user_id", 0);
        Log.d(TAG2, "id >>> " + pref.getInt("user_id", 0));
        aliseon.aliseon_setLoginid(pref.getInt("user_id", 0));

        pref.getString("language", "");
        Log.d(TAG2, "language >>> " + pref.getString("language", ""));
        aliseon.aliseon_setLoginlanguage(pref.getString("language", ""));

        pref.getBoolean("selectaccount", true);
        Log.d(TAG2, "selectaccount >>> " + pref.getBoolean("selectaccount", true));

        pref.getString("country", "");
        Log.d(TAG2, "country >>> " + pref.getString("country", ""));
        aliseon.aliseon_setLogincountry(pref.getString("country", ""));

        pref.getString("currency", "");
        Log.d(TAG2, "currency >>> " + pref.getString("currency", ""));
        aliseon.aliseon_setLogincurrency(pref.getString("currency", ""));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }

    private void AuthPost(){

        Call<Auth> call = AliseonAPI.AuthPost(android_id, "UAE");

        call.enqueue(new Callback<Auth>() {
            @Override
            public void onResponse(Call<Auth> call, Response<Auth> response) {

                Auth postResponse = (Auth) response.body();
                Log.d("STATUS:", "COMPLETE");
                Log.d("Code : ", "" + response.code());
                Log.d("Status : ", "" + postResponse.getStatus());

                Aliseon aliseon = (Aliseon) getApplicationContext();
                aliseon.aliseon_setAccesstoken(postResponse.getList().get(postResponse.getList().size() - 1).getAccessToken());

                TvottUsersPost();

            }

            @Override
            public void onFailure(Call<Auth> call, Throwable t) {
                Log.d("STATUS:", "FAILED");
                Log.d("STATUS:", t.getMessage());
            }

        });

    }

    private void TvottUsersPost(){

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();

        Call<TvottUsers> call = AliseonAPI.TvottUsersPost(access_token);

        call.enqueue(new Callback<TvottUsers>() {
            @Override
            public void onResponse(Call<TvottUsers> call, Response<TvottUsers> response) {

                TvottUsers postResponse = (TvottUsers) response.body();
                Log.d("STATUS:", "COMPLETE");
                Log.d("Code : ", "" + response.code());
                Log.d("Status : ", "" + postResponse.getList());
                Log.d("Status : ", "" + postResponse.getStatus());


                ArrayList<Integer> userinfouid = new ArrayList<>();
                ArrayList<String> userinfo = new ArrayList<>();

                for(int i = 0; i < postResponse.getList().size(); i++){

                    Log.d("result id : ", "" + postResponse.getList().get(i).getId());
                    Log.d("result nickname : ", "" + postResponse.getList().get(i).getNickname());
                    Log.d("result photo : ", "" + postResponse.getList().get(i).getPhoto());
                    Log.d("result language : ", "" + postResponse.getList().get(i).getLanguage());
                    Log.d("result country : ", "" + postResponse.getList().get(i).getCountry());
                    Log.d("result currency : ", "" + postResponse.getList().get(i).getCurrency());

                    switch (i){
                        case 0 :
                            userinfouid.add(0,postResponse.getList().get(i).getId());
                            userinfo.add(0,postResponse.getList().get(i).getNickname());
                            userinfo.add(1,postResponse.getList().get(i).getPhoto());
                            userinfo.add(2,postResponse.getList().get(i).getLanguage());
                            userinfo.add(3,postResponse.getList().get(i).getCountry());
                            userinfo.add(4,postResponse.getList().get(i).getCurrency());
                            break;
                        case 1 :
                            userinfouid.add(1,postResponse.getList().get(i).getId());
                            userinfo.add(5,postResponse.getList().get(i).getNickname());
                            userinfo.add(6,postResponse.getList().get(i).getPhoto());
                            userinfo.add(7,postResponse.getList().get(i).getLanguage());
                            userinfo.add(8,postResponse.getList().get(i).getCountry());
                            userinfo.add(9,postResponse.getList().get(i).getCurrency());
                            break;
                        case 2:
                            userinfouid.add(2,postResponse.getList().get(i).getId());
                            userinfo.add(10,postResponse.getList().get(i).getNickname());
                            userinfo.add(11,postResponse.getList().get(i).getPhoto());
                            userinfo.add(12,postResponse.getList().get(i).getLanguage());
                            userinfo.add(13,postResponse.getList().get(i).getCountry());
                            userinfo.add(14,postResponse.getList().get(i).getCurrency());
                            break;
                    }

                    aliseon.aliseon_setTvott_userinfouid(userinfouid);
                    aliseon.aliseon_setTvott_userinfo(userinfo);

                }

                LoadingmHandler.sendEmptyMessage(1000);

            }

            @Override
            public void onFailure(Call<TvottUsers> call, Throwable t) {
                Log.d("STATUS:", "FAILED");
                Log.d("STATUS:", t.getMessage());

                LoadingmHandler.sendEmptyMessage(800);

            }

        });

    }

}