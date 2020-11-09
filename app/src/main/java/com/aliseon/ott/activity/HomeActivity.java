package com.aliseon.ott.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskAtrend;
import com.bumptech.glide.Glide;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.aliseon.ott.Variable.api_atrend;
import static com.aliseon.ott.Variable.atrend_id;
import static com.aliseon.ott.Variable.atrend_subtitle;
import static com.aliseon.ott.Variable.atrend_summary;
import static com.aliseon.ott.Variable.atrend_thumbnail;
import static com.aliseon.ott.Variable.atrend_title;
import static com.aliseon.ott.Variable.focusing;
import static com.aliseon.ott.Variable.homeapiload;
import static com.aliseon.ott.Variable.adduserapiload;
import static com.aliseon.ott.Variable.imageurl;
import static com.aliseon.ott.Variable.popular_description;
import static com.aliseon.ott.Variable.popular_nickname;
import static com.aliseon.ott.Variable.popular_p_thumbnail;
import static com.aliseon.ott.Variable.popular_photo;
import static com.aliseon.ott.Variable.popular_product_id;
import static com.aliseon.ott.Variable.popular_view_count;
import static com.aliseon.ott.Variable.selected_num;
import static com.aliseon.ott.Variable.title;
import static com.aliseon.ott.Variable.loginid;
import static com.aliseon.ott.Variable.logincurrency;
import static com.aliseon.ott.Variable.loginlanguage;
import static java.lang.System.exit;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences prf;

    ImageView Home;

    static HomeActivityTitleHandler homeactivitytitlehandler;
    static HomeActivityAconHandler homeactivityaconhandler;
    public static HomeActivityPopularHandler homeactivitypopularhandler;
    static HomeActivityCategoriesHandler homeactivitycategorieshandler;
    static HomeActivityPopularDetailHandler homeactivitypopulardetailhandler;
    static HomeActivityAtrendDetailHandler homeactivityatrenddetailhandler;

    Intent intent = getIntent();
    Intent loginintent;

    ImageView banner;

    private static String TAG = "현재 url 가져오기";
    private static String TAG2 = "Shared값 가져오기";

    private long backKeyPressedTime = 0;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        adduserapiload = 1;

        if(homeapiload == 0) {

            readData();

            homeactivitytitlehandler = new HomeActivityTitleHandler();
            homeactivityaconhandler = new HomeActivityAconHandler();
            homeactivitypopularhandler = new HomeActivityPopularHandler();
            homeactivitycategorieshandler = new HomeActivityCategoriesHandler();
            homeactivityatrenddetailhandler = new HomeActivityAtrendDetailHandler();
            homeactivitypopulardetailhandler = new HomeActivityPopularDetailHandler();

            prf = getSharedPreferences("login_session", MODE_PRIVATE);

            switch (prf.getString("language", "")) {


                case "kr":
                    loginlanguage = "kr";
                    Locale lang1 = Locale.KOREAN;
                    Configuration config1 = new Configuration();
                    config1.locale = lang1;
                    getResources().updateConfiguration(config1, getResources().getDisplayMetrics());
                    break;
                case "en":
                    loginlanguage = "en";
                    Locale lang2 = Locale.ENGLISH;
                    Configuration config2 = new Configuration();
                    config2.locale = lang2;
                    getResources().updateConfiguration(config2, getResources().getDisplayMetrics());
                case "ar":
                    loginlanguage = "ar";
                    Locale lang3 = Locale.ENGLISH;
                    Configuration config3 = new Configuration();
                    config3.locale = lang3;
                    getResources().updateConfiguration(config3, getResources().getDisplayMetrics());
            }

            loginintent = new Intent(HomeActivity.this, InfoCheckActivity.class);

            homeactivitypopularhandler.post(new Runnable() {
                @Override
                public void run() {
                    NetworkTaskAtrend networktaskatrend = new NetworkTaskAtrend(api_atrend, null);
                    networktaskatrend.execute();
                }
            });

            LinearLayout Layout1 = new LinearLayout(this);
            LinearLayout Layout2 = new LinearLayout(this);
            LinearLayout Layout2_1 = new LinearLayout(this);
            LinearLayout Layout2_2 = new LinearLayout(this);
            LinearLayout Layout2_1_1 = new LinearLayout(this);
            LinearLayout Layout2_1_2 = new LinearLayout(this);
            LinearLayout Layout2_1_3 = new LinearLayout(this);
            LinearLayout Layout2_1_4 = new LinearLayout(this);
            LinearLayout Layout2_1_5 = new LinearLayout(this);
            LinearLayout Layout2_2_1 = new LinearLayout(this);
            LinearLayout Layout3 = new LinearLayout(this);
            FrameLayout Layout3_1 = new FrameLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this);
            LinearLayout Layout3_3 = new LinearLayout(this);
            LinearLayout Layout3_3_1 = new LinearLayout(this);
            LinearLayout Layout3_4 = new LinearLayout(this);
            LinearLayout Layout3_4_1 = new LinearLayout(this);
            LinearLayout Layout3_4_1_1 = new LinearLayout(this);
            LinearLayout Layout3_5 = new LinearLayout(this);
            LinearLayout Layout3_5_1 = new LinearLayout(this);


            ScrollView scrollview = new ScrollView(this);
            HorizontalScrollView scrollView2 = new HorizontalScrollView(this);
            scrollview.setVerticalScrollBarEnabled(false);
            scrollView2.setHorizontalScrollBarEnabled(false);

            Home = new ImageView(this);
            Home.setFocusableInTouchMode(true);
            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Search = new ImageView(this);
            Search.setFocusableInTouchMode(true);
            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView User = new ImageView(this);
            User.setFocusableInTouchMode(true);
            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            ImageView Cart = new ImageView(this);
            Cart.setFocusableInTouchMode(true);
            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Cart.setPadding(15, 15, 15, 15);
            CircleImageView My = new CircleImageView(this);
            My.setFocusableInTouchMode(true);
            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            My.setPadding(15, 15, 15, 15);
            ImageView Setting = new ImageView(this);
            Setting.setFocusableInTouchMode(true);
            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Setting.setPadding(15, 15, 15, 15);


            TextView Plus = new TextView(this);
            TextView Plus2 = new TextView(this);
            TextView banner1 = new TextView(this);
            TextView banner2 = new TextView(this);
            TextView banner3 = new TextView(this);

            if (prf.getString("userinfo_picture", "").equals("empty")) {
                My.setImageResource(R.drawable.noimg_profile);
            } else {
                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(My);
            }


            Home.setId(R.id.homehome);
            Search.setId(R.id.homesearch);
            User.setId(R.id.homeuser);
            Cart.setId(R.id.homecart);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            Home.setImageResource(R.drawable.home);
            Search.setImageResource(R.drawable.search);
            User.setImageResource(R.drawable.user);
            Cart.setImageResource(R.drawable.cart);
            Setting.setImageResource(R.drawable.setting);
            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));
            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);

            ImageView CategoryIV1 = new ImageView(this);
            CategoryIV1.setImageResource(R.drawable.noing_category);
            CategoryIV1.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            CategoryIV1.setScaleType(ImageView.ScaleType.FIT_START);

            ImageView CategoryIV2 = new ImageView(this);
            CategoryIV2.setImageResource(R.drawable.noing_category);
            CategoryIV2.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            CategoryIV2.setScaleType(ImageView.ScaleType.FIT_START);


            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 500);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 226);
            LinearLayout.LayoutParams params3_5 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 456);
            LinearLayout.LayoutParams params3_m = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 226);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);
            RelativeLayout.LayoutParams paramsAconString = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 60);
            paramsTitleTV.bottomMargin = 10;
            paramsMainLayout.leftMargin = 15;
            paramsMainLayout.rightMargin = 15;

            params3_3.bottomMargin = 30;
            params3_3.leftMargin = 15;

            params2_2.rightMargin = 30;

            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());

//        ViewGroup.MarginLayoutParams margin3_2 = new ViewGroup.MarginLayoutParams(TV1.getLayoutParams());


            margin.setMargins(10, 20, 0, 20);
            margin2.setMargins(10, 20, 0, 20);
            margin3.setMargins(10, 20, 0, 20);
            margin4.setMargins(10, 20, 0, 20);
            margin5.setMargins(0, 20, 5, 20);
            margin6.setMargins(10, 20, 20, 20);


            // Color
            Layout3_1.setBackgroundColor(Color.rgb(38, 38, 38));

            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout2.setLayoutParams(params2);
            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));

            Layout3.setOrientation(LinearLayout.VERTICAL);

            Layout2_2.setGravity(Gravity.BOTTOM);

            Layout2_1.setLayoutParams(params2_1);

            Layout2_2.setLayoutParams(params2_1);

            Layout2_1_1.setLayoutParams(params2_2);
            Layout2_1_1.setLayoutParams(margin);
            Layout2_1_2.setLayoutParams(params2_2);
            Layout2_1_2.setLayoutParams(margin2);
            Layout2_1_3.setLayoutParams(params2_2);
            Layout2_1_3.setLayoutParams(margin3);
            Layout2_1_4.setLayoutParams(params2_2);
            Layout2_1_4.setLayoutParams(margin4);
            Layout2_1_5.setLayoutParams(params2_2);
            Layout2_1_5.setLayoutParams(margin5);

            Layout2_2_1.setLayoutParams(params2_2);
            Layout2_2_1.setLayoutParams(margin6);

            Layout3.setLayoutParams(params3);
            Layout3_1.setLayoutParams(params3_1);
            Layout3_2.setLayoutParams(params3_2);
            Layout3_3.setLayoutParams(params3_m);
            Layout3_3.setGravity(Gravity.CENTER);
            Layout3_3_1.setGravity(Gravity.CENTER);
            Layout3_3_1.setLayoutParams(params3_3_1);

            paramsAconString.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
            paramsAconString.leftMargin = 5;
            paramsAconString.rightMargin = 5;
            paramsAconString.bottomMargin = 9;

            scrollView2.setLayoutParams(params3_3_1);
            Layout3_4.setLayoutParams(params3_2);
            Layout3_5.setLayoutParams(params3_5);

            Layout3_5_1.setLayoutParams(params4);
            Layout3_5_1.setOrientation(LinearLayout.VERTICAL);

            Layout3_3.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_3_1.setOrientation(LinearLayout.HORIZONTAL);

            Layout3_4.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_4_1.setOrientation(LinearLayout.HORIZONTAL);


            Layout1.addView(Layout2);

            Layout2_1.addView(Layout2_1_1);
            Layout2_1.addView(Layout2_1_2);
            Layout2_1.addView(Layout2_1_3);
            Layout2_1.addView(Layout2_1_4);
            Layout2_1.addView(Layout2_1_5);

            Layout2_1_1.addView(Home);
            Layout2_1_2.addView(Search);
            Layout2_1_3.addView(User);
            Layout2_1_4.addView(Cart);
            Layout2_1_5.addView(My);
            Layout2_2_1.addView(Setting);

            Layout2_1.setOrientation(LinearLayout.VERTICAL);
            Layout2_2.setOrientation(LinearLayout.VERTICAL);

            Layout2_2.addView(Layout2_2_1);

            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            Layout3_2.addView(CategoryIV1);
            Layout3_2.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_4.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_4.addView(CategoryIV2);

            int aconviewcount = 5; // acon의 갯수
            for (int i = 0; i < aconviewcount; i++) {
                LinearLayout Layout3_3_1_1 = new LinearLayout(this);
                ImageView IV1 = new ImageView(this);
                IV1.setImageResource(R.drawable.noing_acon);
                IV1.setLayoutParams(new ViewGroup.LayoutParams(400, 236));

                if (i == 0) {
                    // 처음 이미지일 경우 왼쪽 여백
                    ViewGroup.MarginLayoutParams marginIV1 = new ViewGroup.MarginLayoutParams(IV1.getLayoutParams());
                    marginIV1.setMargins(25, 0, 10, 0);
                    Layout3_3_1_1.setLayoutParams(marginIV1);

                } else if (i == aconviewcount - 1) {
                    // 마지막 이미지일 경우 오른쪽 여백
                    ViewGroup.MarginLayoutParams marginIV1 = new ViewGroup.MarginLayoutParams(IV1.getLayoutParams());
                    marginIV1.setMargins(10, 0, 25, 0);
                    Layout3_3_1_1.setLayoutParams(marginIV1);

                } else {
                    ViewGroup.MarginLayoutParams marginIV1 = new ViewGroup.MarginLayoutParams(IV1.getLayoutParams());
                    marginIV1.setMargins(10, 0, 10, 0);
                    Layout3_3_1_1.setLayoutParams(marginIV1);
                }

                IV1.setPadding(5, 9, 5, 9);
                IV1.setScaleType(ImageView.ScaleType.FIT_XY);

                Layout3_3_1_1.addView(IV1);

                Layout3_3_1.addView(Layout3_3_1_1);
            }


            for (int i = 0; i < 2; i++) {
                LinearLayout Layout3_6 = new LinearLayout(this);
                Layout3_6.setLayoutParams(params3_3);
                Layout3_6.setGravity(Gravity.CENTER | Gravity.LEFT);
                Layout3_5_1.addView(Layout3_6);
                params3_3.bottomMargin = 30;

                for (int ii = 0; ii < 4; ii++) {
                    LinearLayout Layout3_6_1 = new LinearLayout(this);
                    LinearLayout Layout3_6_1_1 = new LinearLayout(this);
                    ImageView IV = new ImageView(this);
                    Glide.with(this).load(R.drawable.noing_layout).into(IV);

                    Layout3_6_1.setGravity(Gravity.CENTER);
                    Layout3_6_1_1.setLayoutParams(paramsMainLayout);
                    Layout3_6_1_1.setFocusableInTouchMode(true);

                    Layout3_6_1_1.addView(IV);
                    Layout3_6_1.addView(Layout3_6_1_1);
                    Layout3_6.addView(Layout3_6_1);
                }
            }

            Layout3_5.setGravity(Gravity.LEFT | Gravity.BOTTOM);

            scrollView2.addView(Layout3_3_1);
            Layout3_3.addView(scrollView2);
            Layout3.addView(Layout3_1);
            Layout3.addView(Layout3_2);
            Layout3.addView(Layout3_3);
            Layout3.addView(Layout3_4);
            Layout3_4_1.addView(Layout3_4_1_1);
            Layout3_4.addView(Layout3_4_1);
            Layout3.addView(Layout3_5_1);
            Layout3.addView(Layout3_5);

            Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                @Override
                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                    if (hasFocus == false) {
                        Home.setImageResource(R.drawable.home);
                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(HomeActivity.this, VoyageActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
                                } else {

                                }
                            }
                        });
                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Home.setImageResource(R.drawable.home);
//                                User.setImageResource(R.drawable.userselect);
                                    Intent intent = new Intent(HomeActivity.this, SubscribeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                    User.setImageResource(R.drawable.user);
                                }
                            }
                        });

                    } else {

                    }
                }
            });

            Home.requestFocus();

            scrollview.addView(Layout3);
            Layout1.addView(scrollview);

            setContentView(Layout1);

        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        switch (focusing){
            case -1 :
                focusing = 0;
                overridePendingTransition(0, 0);
                break;
            case 0 :
                Home.requestFocus();
                overridePendingTransition(0, 0);
                break;
//            case -2 :
//                recreate();
//                focusing = 0;
//                break;
        }
    }

    public void readData()
    {
        prf = getSharedPreferences("login_session",MODE_PRIVATE);
        prf.getString("userinfo_name", "");
        Log.d(TAG2, "info >>> " + prf.getString("userinfo_name", ""));
        prf.getString("userinfo_picture", "");
        Log.d(TAG2, "picture >>> " + prf.getString("userinfo_picture", ""));
        prf.getInt("user_id", 0);
        Log.d(TAG2, "id >>> " + prf.getInt("user_id", 0));
        loginid = prf.getInt("user_id", 0);
        prf.getString("language", "");
        Log.d(TAG2, "language >>> " + prf.getString("language", ""));
        loginlanguage = prf.getString("language", "");
        prf.getBoolean("selectaccount", true);
        Log.d(TAG2, "selectaccount >>> " + prf.getBoolean("selectaccount", true));
        prf.getString("country", "");
        Log.d(TAG2, "country >>> " + prf.getString("country", ""));
        prf.getString("currency", "");
        Log.d(TAG2, "currency >>> " + prf.getString("currency", ""));
        logincurrency = prf.getString("currency", "");
    }

    class HomeActivityTitleHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 800) {
                Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayerActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
            if (msg.what == 1000) {
                Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayerActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
        }
    }

    class HomeActivityAconHandler extends Handler {
        @Override

        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리

            if (msg.what == 1000) {
//                nowurl = imageurl + acondetail_videopath.get(0);
//                Log.d(TAG2, "현재주소" + nowurl);
//                Intent intent = new Intent(HomeActivity.this, PlayerHome_Acon.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);
            }

        }
    }


    @Override
    public void onBackPressed() {
        overridePendingTransition(0,0);
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, getResources().getString(R.string.backbutton), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지나지 않았으면 종료
        // 현재 표시된 Toast 취소
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            exit(0);
            toast.cancel();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(homeapiload == 1) {

            prf = getSharedPreferences("login_session", MODE_PRIVATE);

            switch (prf.getString("language", "")) {


                case "kr":
                    loginlanguage = "kr";
                    Locale lang1 = Locale.KOREAN;
                    Configuration config1 = new Configuration();
                    config1.locale = lang1;
                    getResources().updateConfiguration(config1, getResources().getDisplayMetrics());
                    break;
                case "en":
                    loginlanguage = "en";
                    Locale lang2 = Locale.ENGLISH;
                    Configuration config2 = new Configuration();
                    config2.locale = lang2;
                    getResources().updateConfiguration(config2, getResources().getDisplayMetrics());
                case "ar":
                    loginlanguage = "ar";
                    Locale lang3 = Locale.ENGLISH;
                    Configuration config3 = new Configuration();
                    config3.locale = lang3;
                    getResources().updateConfiguration(config3, getResources().getDisplayMetrics());
            }

            loginintent = new Intent(HomeActivity.this, InfoCheckActivity.class);

            LinearLayout Layout1 = new LinearLayout(this);
            LinearLayout Layout2 = new LinearLayout (this);
            LinearLayout Layout2_1 = new LinearLayout(this);
            LinearLayout Layout2_2 = new LinearLayout(this);
            LinearLayout Layout2_1_1 = new LinearLayout(this);
            LinearLayout Layout2_1_2 = new LinearLayout(this);
            LinearLayout Layout2_1_3 = new LinearLayout(this);
            LinearLayout Layout2_1_4 = new LinearLayout(this);
            LinearLayout Layout2_1_5 = new LinearLayout(this);
            LinearLayout Layout2_2_1 = new LinearLayout(this);
            LinearLayout Layout3 = new LinearLayout(this);
            FrameLayout Layout3_1 = new FrameLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this);
            LinearLayout Layout3_3 = new LinearLayout(this);
            LinearLayout Layout3_3_1 = new LinearLayout(this);

            LinearLayout Layout3_4 = new LinearLayout(this);
            LinearLayout Layout3_4_1 = new LinearLayout(this);
            LinearLayout Layout3_4_1_1 = new LinearLayout(this);
            LinearLayout Layout3_5 = new LinearLayout(this);
            LinearLayout Layout3_5_1 = new LinearLayout(this);


            ScrollView scrollview = new ScrollView(this);
            HorizontalScrollView scrollView2 = new HorizontalScrollView(this);
            scrollview.setVerticalScrollBarEnabled(false);
            scrollView2.setHorizontalScrollBarEnabled(false);

            Home = new ImageView(this);
            Home.setFocusableInTouchMode(true);
            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Search = new ImageView(this);
            Search.setFocusableInTouchMode(true);
            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView User = new ImageView(this);
            User.setFocusableInTouchMode(true);
            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            ImageView Cart = new ImageView(this);
            Cart.setFocusableInTouchMode(true);
            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
            Cart.setPadding(15,15,15,15);
            CircleImageView My = new CircleImageView(this);
            My.setFocusableInTouchMode(true);
            My.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
            My.setPadding(15,15,15,15);
            ImageView Setting = new ImageView(this);
            Setting.setFocusableInTouchMode(true);
            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
            Setting.setPadding(15,15,15,15);

            TextView Plus = new TextView(this);
            TextView Plus2 = new TextView(this);
            TextView banner1 = new TextView(this);
            TextView banner2 = new TextView(this);
            TextView banner3 = new TextView(this);

            banner = new ImageView(this);

            banner.setScaleType(ImageView.ScaleType.CENTER);

            try {
                Glide.with(this).load(imageurl + atrend_thumbnail.get(0)).into(banner);
            } catch (Exception e){

            }

            if (prf.getString("userinfo_picture", "").equals("empty")) {
                My.setImageResource(R.drawable.noimg_profile);
            } else {
                Glide.with(this).load(imageurl + prf.getString("userinfo_picture", "")).into(My);
            }

            Home.setId(R.id.homehome);
            Search.setId(R.id.homesearch);
            User.setId(R.id.homeuser);
            Cart.setId(R.id.homecart);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            Home.setImageResource(R.drawable.home);
            Search.setImageResource(R.drawable.search);
            User.setImageResource(R.drawable.user);
            Cart.setImageResource(R.drawable.cart);
            Setting.setImageResource(R.drawable.setting);
            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Cart.setLayoutParams(new ViewGroup.LayoutParams(60,60));
            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
            My.setLayoutParams(new ViewGroup.LayoutParams(80,80));
            Setting.setLayoutParams(new ViewGroup.LayoutParams(60,60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);

            banner.setLayoutParams(new ViewGroup.LayoutParams(1824, 500));


            TextView TV1 = new TextView(this);
            TextView TV2 = new TextView(this);
            TV1.setTextColor(Color.rgb(255, 255, 255));
            TV2.setTextColor(Color.rgb(255, 255, 255));
            TV1.setText(getResources().getString(R.string.todayacon));
            TV2.setText(getResources().getString(R.string.popularvideos));
            TV1.setTextSize(20);
            TV2.setTextSize(20);
            TV1.setPadding(30,0,0,20);
            TV2.setPadding(30,0,0,20);

            banner1.setTextColor(Color.rgb(255, 255, 255));
            banner2.setTextColor(Color.rgb(255, 255, 255));
            banner3.setTextColor(Color.rgb(255, 255, 255));
            banner1.setText(atrend_subtitle.get(0));
            banner2.setText(atrend_title.get(0));
            banner3.setText(atrend_summary.get(0));
            banner1.setTextSize(21);
            banner2.setTextSize(26);
            banner2.setTypeface(null, Typeface.BOLD);
            banner3.setTextSize(16);
            banner1.setPadding(30,90,0,0);
            banner2.setPadding(30,140,0,0);
            banner3.setPadding(30,240,0,0);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 500);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 226);
            LinearLayout.LayoutParams params3_5 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,456);
            LinearLayout.LayoutParams params3_m = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 226);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);
            RelativeLayout.LayoutParams paramsAconString = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 60);
            paramsTitleTV.bottomMargin = 10;
            paramsMainLayout.leftMargin = 15;
            paramsMainLayout.rightMargin = 15;
            paramsMainLayout.bottomMargin = 20;

            params3_3.bottomMargin = 30;
            params3_3.leftMargin = 15;

            params2_2.rightMargin = 30;

            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());

//        ViewGroup.MarginLayoutParams margin3_2 = new ViewGroup.MarginLayoutParams(TV1.getLayoutParams());


            margin.setMargins(10,20,0,20);
            margin2.setMargins(10,20,0,20);
            margin3.setMargins(10,20,0,20);
            margin4.setMargins(10,20,0,20);
            margin5.setMargins(0,20,5, 20);
            margin6.setMargins(10,20,20, 20);




            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setGravity(Gravity.CENTER|Gravity.TOP);
            Layout2.setLayoutParams(params2);
            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));

            Layout3.setOrientation(LinearLayout.VERTICAL);

            Layout2_2.setGravity(Gravity.BOTTOM);

            Layout2_1.setLayoutParams(params2_1);

            Layout2_2.setLayoutParams(params2_1);

            Layout2_1_1.setLayoutParams(params2_2);
            Layout2_1_1.setLayoutParams(margin);
            Layout2_1_2.setLayoutParams(params2_2);
            Layout2_1_2.setLayoutParams(margin2);
            Layout2_1_3.setLayoutParams(params2_2);
            Layout2_1_3.setLayoutParams(margin3);
            Layout2_1_4.setLayoutParams(params2_2);
            Layout2_1_4.setLayoutParams(margin4);
            Layout2_1_5.setLayoutParams(params2_2);
            Layout2_1_5.setLayoutParams(margin5);

            Layout2_2_1.setLayoutParams(params2_2);
            Layout2_2_1.setLayoutParams(margin6);

            Layout3.setLayoutParams(params3);
            Layout3_1.setLayoutParams(params3_1);
            Layout3_2.setLayoutParams(params3_2);
            Layout3_3.setLayoutParams(params3_m);
            Layout3_3.setGravity(Gravity.CENTER);
            Layout3_3_1.setGravity(Gravity.CENTER);
            Layout3_3_1.setLayoutParams(params3_3_1);

            scrollView2.setLayoutParams(params3_3_1);
            Layout3_4.setLayoutParams(params3_2);
            Layout3_5.setLayoutParams(params3_5);

            Layout3_5_1.setLayoutParams(params4);
            Layout3_5_1.setOrientation(LinearLayout.VERTICAL);

            Layout3_3.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_3_1.setOrientation(LinearLayout.HORIZONTAL);

            Layout3_4.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_4_1.setOrientation(LinearLayout.HORIZONTAL);


            Layout1.addView(Layout2);

            Layout2_1.addView(Layout2_1_1);
            Layout2_1.addView(Layout2_1_2);
            Layout2_1.addView(Layout2_1_3);
            Layout2_1.addView(Layout2_1_4);
            Layout2_1.addView(Layout2_1_5);

            Layout2_1_1.addView(Home);
            Layout2_1_2.addView(Search);
            Layout2_1_3.addView(User);
            Layout2_1_4.addView(Cart);
            Layout2_1_5.addView(My);
            Layout2_2_1.addView(Setting);

            Layout2_1.setOrientation(LinearLayout.VERTICAL);
            Layout2_2.setOrientation(LinearLayout.VERTICAL);

            Layout2_2.addView(Layout2_2_1);

            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            Layout3_1.addView(banner);
            Layout3_1.addView(banner1);
            Layout3_1.addView(banner2);
            Layout3_1.addView(banner3);
            Layout3_2.addView(TV1);
            Layout3_2.setGravity(Gravity.LEFT|Gravity.BOTTOM);
            Layout3_4.setGravity(Gravity.LEFT|Gravity.BOTTOM);

//            for (int i = 0; i < acontoday_id.size(); i++) {
//                paramsAconString.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
//                paramsAconString.leftMargin = 5;
//                paramsAconString.rightMargin = 5;
//                paramsAconString.bottomMargin = 9;
//
//                RelativeLayout Layout3_3_1_1= new RelativeLayout(this);
////                Layout3_3_1_1.setBackgroundColor(Color.rgb(255,255,255));
//
//                LinearLayout Layout3_3_1_1_1 = new LinearLayout(this);
//                Layout3_3_1_1_1.setLayoutParams(paramsAconString);
//
//                TextView AconString1 = new TextView(this);
//                AconString1.setText(acontoday_title.get(i));
//                AconString1.setTextColor(Color.rgb(255,255,255));
//
//                ImageView IV1 = new ImageView(this);
//                IV1.setFocusableInTouchMode(true);
//                IV1.setId(R.id.LayoutHome);
//                IV1.setNextFocusUpId(R.id.LayoutHome);
//                IV1.setLayoutParams(new ViewGroup.LayoutParams(400, 236));
//                IV1.setScaleType(ImageView.ScaleType.FIT_XY);
//
//                Layout3_3_1_1_1.setGravity(Gravity.CENTER);
//                Layout3_3_1_1_1.setBackgroundColor(Color.argb(80,0,0,0));
//
//                try {
//                    Glide.with(this).load(imageurl + acontoday_imagepath.get(i)).into(IV1);
//                } catch (Exception e){
//
//                }
//
//                if (i == 0) {
//                    // 처음 이미지일 경우 왼쪽 여백
//                    ViewGroup.MarginLayoutParams marginIV1 = new ViewGroup.MarginLayoutParams(IV1.getLayoutParams());
//                    marginIV1.setMargins(25, 0, 10, 0);
//                    Layout3_3_1_1.setLayoutParams(marginIV1);
//                    IV1.setNextFocusLeftId(R.id.homehome);
//
//                } else if (i == acontoday_id.size() - 1) {
//                    // 마지막 이미지일 경우 오른쪽 여백
//                    ViewGroup.MarginLayoutParams marginIV1 = new ViewGroup.MarginLayoutParams(IV1.getLayoutParams());
//                    marginIV1.setMargins(10, 0, 25, 0);
//                    Layout3_3_1_1.setLayoutParams(marginIV1);
//
//                } else {
//                    ViewGroup.MarginLayoutParams marginIV1 = new ViewGroup.MarginLayoutParams(IV1.getLayoutParams());
//                    marginIV1.setMargins(10, 0, 10, 0);
//                    Layout3_3_1_1.setLayoutParams(marginIV1);
//                }
//
//                IV1.setPadding(5, 9, 5, 9);
//                IV1.setScaleType(ImageView.ScaleType.FIT_XY);
//
//                Layout3_3_1_1.addView(IV1);
//                Layout3_3_1_1.addView(Layout3_3_1_1_1);
//                Layout3_3_1_1_1.addView(AconString1);
//                Layout3_3_1.addView(Layout3_3_1_1);
//
//                int acontodaycount = i;
//                IV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//
//                    @Override
//                    public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                        if (hasFocus) {
//                            title = acontoday_title.get(acontodaycount);
//                            Glide.with(banner).load(imageurl + acontoday_imagepath.get(acontodaycount)).into(banner);
//                            Layout3_3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
//                            banner1.setText(acontoday_sub_title.get(acontodaycount));
//                            banner2.setText(acontoday_title.get(acontodaycount));
//                            banner3.setText(acontoday_summary.get(acontodaycount));
//                            scrollview.smoothScrollTo(500, 0);
//                            scrollView2.smoothScrollTo(0,0);
//                        }else{
//                            Layout3_3_1_1.setBackground(null);
//                        }
//                    }
//                });
//
//                IV1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayer.class);
//                        nowurl = imageurl + acontoday_videopath.get(acontodaycount);
//                        maintitle = acontoday_title.get(acontodaycount);
//                        subtitle = acontoday_sub_title.get(acontodaycount);
////                    creatortitle = feedall_author_nickname.get(0);
////                    creatorprofile = imageurl + feedall_author_picture.get(0);
////                    creatorauthorid = feedall_author_id.get(0);
//
//                        intent.putExtra("index", 0);
//                        intent.putExtra("category", 30);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                        startActivity(intent);
//                    }
//                });
//            }


            for (int i = 0; i < atrend_id.size(); i++) {
                paramsAconString.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
                paramsAconString.leftMargin = 5;
                paramsAconString.rightMargin = 5;
                paramsAconString.bottomMargin = 9;

                RelativeLayout Layout3_3_1_1= new RelativeLayout(this);
//                Layout3_3_1_1.setBackgroundColor(Color.rgb(255,255,255));

                LinearLayout Layout3_3_1_1_1 = new LinearLayout(this);
                Layout3_3_1_1_1.setLayoutParams(paramsAconString);

                TextView AconString1 = new TextView(this);
                AconString1.setText(atrend_title.get(i));
                AconString1.setTextColor(Color.rgb(255,255,255));

                ImageView IV1 = new ImageView(this);
                IV1.setFocusableInTouchMode(true);
                IV1.setId(R.id.LayoutHome);
                IV1.setNextFocusUpId(R.id.LayoutHome);
                IV1.setLayoutParams(new ViewGroup.LayoutParams(400, 236));
                IV1.setScaleType(ImageView.ScaleType.FIT_XY);

                Layout3_3_1_1_1.setGravity(Gravity.CENTER);
                Layout3_3_1_1_1.setBackgroundColor(Color.argb(80,0,0,0));

                try {
                    Glide.with(this).load(imageurl + atrend_thumbnail.get(i)).into(IV1);
                } catch (Exception e){

                }

                if (i == 0) {
                    // 처음 이미지일 경우 왼쪽 여백
                    ViewGroup.MarginLayoutParams marginIV1 = new ViewGroup.MarginLayoutParams(IV1.getLayoutParams());
                    marginIV1.setMargins(25, 0, 10, 0);
                    Layout3_3_1_1.setLayoutParams(marginIV1);
                    IV1.setNextFocusLeftId(R.id.homehome);

                } else if (i == atrend_id.size() - 1) {
                    // 마지막 이미지일 경우 오른쪽 여백
                    ViewGroup.MarginLayoutParams marginIV1 = new ViewGroup.MarginLayoutParams(IV1.getLayoutParams());
                    marginIV1.setMargins(10, 0, 25, 0);
                    Layout3_3_1_1.setLayoutParams(marginIV1);

                } else {
                    ViewGroup.MarginLayoutParams marginIV1 = new ViewGroup.MarginLayoutParams(IV1.getLayoutParams());
                    marginIV1.setMargins(10, 0, 10, 0);
                    Layout3_3_1_1.setLayoutParams(marginIV1);
                }

                IV1.setPadding(5, 9, 5, 9);
                IV1.setScaleType(ImageView.ScaleType.FIT_XY);

                Layout3_3_1_1.addView(IV1);
                Layout3_3_1_1.addView(Layout3_3_1_1_1);
                Layout3_3_1_1_1.addView(AconString1);
                Layout3_3_1.addView(Layout3_3_1_1);

                int atrendcount = i;
                IV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                    @Override
                    public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                        if (hasFocus) {
                            title = atrend_title.get(atrendcount);
                            Glide.with(banner).load(imageurl + atrend_thumbnail.get(atrendcount)).into(banner);
                            Layout3_3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                            banner1.setText(atrend_subtitle.get(atrendcount));
                            banner2.setText(atrend_title.get(atrendcount));
                            banner3.setText(atrend_summary.get(atrendcount));
                            scrollview.smoothScrollTo(500, 0);
                            scrollView2.smoothScrollTo(0,0);
                        }else{
                            Layout3_3_1_1.setBackground(null);
                        }
                    }
                });

                IV1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayerActivity.class);
                        intent.putExtra("index", atrendcount);
                        intent.putExtra("category",1);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);

//                        homeactivityatrenddetailhandler.post(new Runnable() {
//                            @Override
//                            public void run() {
//
//                                //request http에 넘겨주는 atrend_id
//                                param_atrend_id = atrend_id.get(atrendcount);
//                                maintitle = atrend_title.get(atrendcount);
//                                subtitle = atrend_subtitle.get(atrendcount);
//
//                                NetworkTaskAtrendDetail networktaskatrenddetail = new NetworkTaskAtrendDetail(api_atrend_detail, null);
//                                networktaskatrenddetail.execute();
//
//                            }
//                        });

                    }
                });
            }

            Layout3_4.addView(TV2);

            int jj = 3; // 3줄까지만
            int y = 3; // 4번째 줄에서 3개 까지만

            int j = 0; // 0번째부터 시작

            Log.d("테스트값", String.valueOf(popular_nickname.size()));
            for(int i = 0; i < jj; i++) {
                LinearLayout Layout3_6 = new LinearLayout(this);
                Layout3_6.setLayoutParams(params3_3);
                Layout3_6.setGravity(Gravity.CENTER | Gravity.LEFT);
                Layout3_5_1.addView(Layout3_6);
                params3_3.bottomMargin = 20;

                if (i == jj - 1) {
                    for (int ii = 0; ii < y; ii++) {
                        if (popular_p_thumbnail.size() < j+1) {

                        } else {
                            Log.d("TESTVALUE", String.valueOf(j));
                            LinearLayout Layout3_6_1 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_1 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_2 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_2_1 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_2_2 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_2_2_1 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_2_2_2 = new LinearLayout(this);

                            Layout3_6_1.setGravity(Gravity.CENTER);
                            ImageView IV11 = new ImageView(this);
                            CircleImageView CIV11 = new CircleImageView(this);
                            IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 286));
                            CIV11.setLayoutParams(new ViewGroup.LayoutParams(60, 60));

                            IV11.setScaleType(ImageView.ScaleType.FIT_XY);
                            TextView TV11 = new TextView(this);
                            TextView TV11_1 = new TextView(this);

                            Layout3_6_1_1.setOrientation(LinearLayout.VERTICAL);
                            Layout3_6_1_1.setFocusableInTouchMode(true);

                            TV11.setTextSize(14);
                            TV11.setTextColor(Color.rgb(255, 255, 255));
                            TV11_1.setTextSize(10);
                            TV11_1.setTextColor(Color.rgb(255, 255, 255));

                            try{
                                Glide.with(this).load(imageurl + popular_p_thumbnail.get(j).get(0)).into(IV11);
                                Glide.with(this).load(imageurl + popular_photo.get(j)).into(CIV11);
                                TV11_1.setText(popular_nickname.get(j) + "\n" + popular_view_count.get(j) + " views");
                                TV11.setText(popular_description.get(j));
                            } catch (Exception e){

                            }

                            Layout3_6_1_1.addView(Layout3_6_1_1_1);
                            Layout3_6_1_1_1.addView(IV11);
                            Layout3_6_1_1.addView(Layout3_6_1_1_2);
                            Layout3_6_1_1_2.setLayoutParams(params3);
                            Layout3_6_1_1_2.setOrientation(LinearLayout.VERTICAL);
                            Layout3_6_1_1_2.addView(Layout3_6_1_1_2_1);
                            Layout3_6_1_1_2.setGravity(Gravity.CENTER);
                            Layout3_6_1_1_2_1.addView(TV11);
                            TV11.setPadding(30, 0, 30, 0);
                            Layout3_6_1_1_2_1.setLayoutParams(paramsTitleTV);
                            Layout3_6_1_1_2.addView(Layout3_6_1_1_2_2);
                            Layout3_6_1_1_2_2.setOrientation(LinearLayout.HORIZONTAL);
                            Layout3_6_1_1_2_2.addView(Layout3_6_1_1_2_2_1);
                            Layout3_6_1_1_2_2.setPadding(0, 0, 0, 10);
                            Layout3_6_1_1_2_2_1.setPadding(25, 0, 0, 0);
                            Layout3_6_1_1_2_2_1.addView(CIV11);
                            Layout3_6_1_1_2_2_2.setLayoutParams(params3);
                            Layout3_6_1_1_2_2_2.setOrientation(LinearLayout.VERTICAL);
                            Layout3_6_1_1_2_2.addView(Layout3_6_1_1_2_2_2);
                            Layout3_6_1_1_2_2_2.setGravity(Gravity.CENTER | Gravity.CENTER);
                            Layout3_6_1_1_2_2_2.addView(TV11_1);

                            Layout3_6_1_1_2_2_1.setLayoutParams(paramsCIV);
                            Layout3_6_1_1_2_2_1.setGravity(Gravity.CENTER);

                            Layout3_6_1_1.setLayoutParams(paramsMainLayout);
                            Layout3_6_1_1.setFocusableInTouchMode(true);

                            Layout3_6_1.addView(Layout3_6_1_1);
                            Layout3_6.addView(Layout3_6_1);

                            Layout3_6_1_1.setId(R.id.LayoutHome);

                            if (ii == 0) {
                                Layout3_6_1_1.setNextFocusLeftId(R.id.homehome);
                            }

                            Layout3_6_1_1.setNextFocusDownId(R.id.LayoutHome);

                            // Plus
                            final int jjj = j;
                            if (j == 10 && popular_p_thumbnail.size() > 12) {
                                FrameLayout Layout3_8_1_4 = new FrameLayout(this);

                                ImageView IV22 = new ImageView(this);

                                Plus.setText("+");
                                Plus2.setText("More");
                                Plus.setTextSize(40);
                                Plus2.setTextSize(14);
                                Plus.setTextColor(Color.rgb(255, 255, 255));
                                Plus2.setTextColor(Color.rgb(255, 255, 255));

                                Plus.setGravity(Gravity.CENTER);
                                Plus.setPadding(0,0,0,70);
                                Plus2.setGravity(Gravity.CENTER);
                                Plus2.setPadding(0,70,0,0);

                                IV22.setLayoutParams(new ViewGroup.LayoutParams(420, 256));
                                IV22.setScaleType(ImageView.ScaleType.FIT_XY);

                                ViewGroup.MarginLayoutParams marginIV22 = new ViewGroup.MarginLayoutParams(IV22.getLayoutParams());
                                Layout3_8_1_4.setLayoutParams(marginIV22);
                                Layout3_8_1_4.setBackgroundColor(Color.rgb(100, 100, 100));

                                Layout3_8_1_4.addView(Plus);
                                Layout3_8_1_4.addView(Plus2);

                                Layout3_8_1_4.setLayoutParams(paramsMainLayout);
                                Layout3_8_1_4.setFocusableInTouchMode(true);

                                Layout3_8_1_4.addView(IV22);

                                Layout3_6_1.addView(Layout3_8_1_4);

                                Layout3_8_1_4.setId(R.id.LayoutHome);
                                Layout3_8_1_4.setNextFocusDownId(R.id.LayoutHome);
                                Layout3_8_1_4.setNextFocusRightId(R.id.LayoutHome);

                                Layout3_8_1_4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                    @Override
                                    public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                        if (hasFocus) {
                                            Layout3_8_1_4.setBackgroundColor(Color.rgb(255, 255, 255));
                                            Plus.setTextColor(Color.rgb(0, 0, 0));
                                            Plus2.setTextColor(Color.rgb(0, 0, 0));
                                        }else{
                                            Layout3_8_1_4.setBackgroundColor(Color.rgb(100, 100, 100));
                                            Plus.setTextColor(Color.rgb(255, 255, 255));
                                            Plus2.setTextColor(Color.rgb(255, 255, 255));
                                        }
                                    }
                                });

                                Layout3_8_1_4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
//                                        nowurl = imageurl + popular_video.get(jjj);
//                                        maintitle = popular_content.get(jjj);
//                                        subtitle = popular_content.get(jjj);
//                                        creatortitle = popular_author_nickname.get(jjj);
//                                        creatorprofile = imageurl + popular_author_picture.get(jjj);
//                                        creatorauthorid = popular_author_id.get(jjj);
                                        Intent intent = new Intent(HomeActivity.this, HomeDetailActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                        startActivity(intent);
                                    }
                                });

                            }

                            Layout3_6_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                @Override
                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                    if (hasFocus == false) {
                                        Layout3_6_1_1.setBackground(null);
                                        TV11.setTextColor(Color.rgb(255, 255, 255));
                                        TV11_1.setTextColor(Color.rgb(255, 255, 255));

                                        Layout3_6_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                if (hasFocus) {
                                                    Layout3_6_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                                    TV11.setTextColor(Color.rgb(0, 0, 0));
                                                    TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                                } else {
                                                    Layout3_6_1_1.setBackground(null);
                                                    TV11.setTextColor(Color.rgb(255, 255, 255));
                                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                                }
                                            }
                                        });

                                    } else {
                                        Layout3_6_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                        TV11.setTextColor(Color.rgb(0, 0, 0));
                                        TV11_1.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                                        v = getWindow().getCurrentFocus();
                                        Log.d(TAG, "현재 포커스 >>" + v);
                                    }
                                }
                            });


                            Layout3_6_1_1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayerActivity.class);
                                    intent.putExtra("index", jjj);
                                    intent.putExtra("category",2);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                }
                            });
                            j++;
                        }
                    }

                } else {
                    for (int ii = 0; ii < 4; ii++) {
                        if (popular_product_id.size() < j+1) {

                        } else {
                            LinearLayout Layout3_6_1 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_1 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_2 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_2_1 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_2_2 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_2_2_1 = new LinearLayout(this);
                            LinearLayout Layout3_6_1_1_2_2_2 = new LinearLayout(this);

                            Layout3_6_1.setGravity(Gravity.CENTER);
                            ImageView IV11 = new ImageView(this);
                            CircleImageView CIV11 = new CircleImageView(this);
                            IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 286));
                            CIV11.setLayoutParams(new ViewGroup.LayoutParams(60, 60));

                            IV11.setScaleType(ImageView.ScaleType.FIT_XY);
                            TextView TV11 = new TextView(this);
                            TextView TV11_1 = new TextView(this);

                            Layout3_6_1_1.setOrientation(LinearLayout.VERTICAL);
                            Layout3_6_1_1.setFocusableInTouchMode(true);

                            TV11.setTextSize(14);
                            TV11.setTextColor(Color.rgb(255, 255, 255));
                            TV11_1.setTextSize(10);
                            TV11_1.setTextColor(Color.rgb(255, 255, 255));

                            try{
                                Glide.with(this).load(imageurl + popular_p_thumbnail.get(j).get(0)).into(IV11);
                                Glide.with(this).load(imageurl + popular_photo.get(j)).into(CIV11);
                                TV11.setText(popular_description.get(j));
                                TV11_1.setText(popular_nickname.get(j) + "\n" + popular_view_count.get(j) + " views");
                            } catch (Exception e){

                            }

                            Layout3_6_1_1.addView(Layout3_6_1_1_1);
                            Layout3_6_1_1_1.addView(IV11);
                            Layout3_6_1_1.addView(Layout3_6_1_1_2);
                            Layout3_6_1_1_2.setLayoutParams(params3);
                            Layout3_6_1_1_2.setOrientation(LinearLayout.VERTICAL);
                            Layout3_6_1_1_2.addView(Layout3_6_1_1_2_1);
                            Layout3_6_1_1_2.setGravity(Gravity.CENTER);
                            Layout3_6_1_1_2_1.addView(TV11);
                            TV11.setPadding(30, 0, 30, 0);
                            Layout3_6_1_1_2_1.setLayoutParams(paramsTitleTV);
                            Layout3_6_1_1_2.addView(Layout3_6_1_1_2_2);
                            Layout3_6_1_1_2_2.setOrientation(LinearLayout.HORIZONTAL);
                            Layout3_6_1_1_2_2.addView(Layout3_6_1_1_2_2_1);
                            Layout3_6_1_1_2_2.setPadding(0, 0, 0, 10);
                            Layout3_6_1_1_2_2_1.setPadding(25, 0, 0, 0);
                            Layout3_6_1_1_2_2_1.addView(CIV11);
                            Layout3_6_1_1_2_2_2.setLayoutParams(params3);
                            Layout3_6_1_1_2_2_2.setOrientation(LinearLayout.VERTICAL);
                            Layout3_6_1_1_2_2.addView(Layout3_6_1_1_2_2_2);
                            Layout3_6_1_1_2_2_2.setGravity(Gravity.CENTER | Gravity.CENTER);
                            Layout3_6_1_1_2_2_2.addView(TV11_1);

                            Layout3_6_1_1_2_2_1.setLayoutParams(paramsCIV);
                            Layout3_6_1_1_2_2_1.setGravity(Gravity.CENTER);

                            Layout3_6_1_1.setLayoutParams(paramsMainLayout);
                            Layout3_6_1_1.setFocusableInTouchMode(true);

                            Layout3_6_1.addView(Layout3_6_1_1);
                            Layout3_6.addView(Layout3_6_1);

                            if (ii == 0) {
                                Layout3_6_1_1.setNextFocusLeftId(R.id.homehome);
                            }

                            if (ii == 3) {
                                Layout3_6_1_1.setId(R.id.LayoutHome);
                                Layout3_6_1_1.setNextFocusRightId(R.id.LayoutHome);
                            }

                            Layout3_6_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                @Override
                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                    if (hasFocus == false) {
                                        Layout3_6_1_1.setBackground(null);
                                        TV11.setTextColor(Color.rgb(255, 255, 255));
                                        TV11_1.setTextColor(Color.rgb(255, 255, 255));

                                        Layout3_6_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                if (hasFocus) {
                                                    Layout3_6_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                                    TV11.setTextColor(Color.rgb(0, 0, 0));
                                                    TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                                } else {
                                                    Layout3_6_1_1.setBackground(null);
                                                    TV11.setTextColor(Color.rgb(255, 255, 255));
                                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                                }
                                            }
                                        });

                                    } else {
                                        Layout3_6_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                        TV11.setTextColor(Color.rgb(0, 0, 0));
                                        TV11_1.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                                        v = getWindow().getCurrentFocus();
                                        Log.d(TAG, "현재 포커스 >>" + v);
                                    }
                                }
                            });


                            final int jjj = j;
                            Layout3_6_1_1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayerActivity.class);
                                    intent.putExtra("index", jjj);
                                    intent.putExtra("category",2);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                }
                            });
                            j++;
                        }
                    }
                }
            }

            Layout3_5.setGravity(Gravity.LEFT|Gravity.BOTTOM);
            scrollView2.addView(Layout3_3_1);
            Layout3_3.addView(scrollView2);
            Layout3.addView(Layout3_1);
            Layout3.addView(Layout3_2);
            Layout3.addView(Layout3_3);
            Layout3.addView(Layout3_4);
            Layout3_4_1.addView(Layout3_4_1_1);
            Layout3_4.addView(Layout3_4_1);
            Layout3.addView(Layout3_5_1);
            Layout3.addView(Layout3_5);

            Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                @Override
                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                    if(hasFocus == false)
                    {
                        Home.setImageResource(R.drawable.home);
                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(HomeActivity.this, VoyageActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
                                }else{

                                }
                            }
                        });
                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Home.setImageResource(R.drawable.home);
//                                User.setImageResource(R.drawable.userselect);
                                    Intent intent = new Intent(HomeActivity.this, SubscribeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
//                finish();
                                } else{
                                    User.setImageResource(R.drawable.user);
                                }
                            }
                        });

//                        IV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    title = aconlast_title.get(0);
//                                    Glide.with(banner).load(imageurl + aconlast_imagepath.get(0)).into(banner);
//                                    Layout3_3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    banner1.setText(aconlast_sub_title.get(0));
//                                    banner2.setText(aconlast_title.get(0));
//                                    banner3.setText(aconlast_summary.get(0));
//                                    scrollview.smoothScrollTo(500, 0);
//                                    scrollView2.smoothScrollTo(0,0);
//                                }else{
//                                    Layout3_3_1_1.setBackground(null);
//                                }
//                            }
//                        });
//
//                        IV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    title = aconlast_title.get(1);
//                                    Glide.with(banner).load(imageurl + aconlast_imagepath.get(1)).into(banner);
//                                    Layout3_3_1_2.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    banner1.setText(aconlast_sub_title.get(1));
//                                    banner2.setText(aconlast_title.get(1));
//                                    banner3.setText(aconlast_summary.get(1));
//                                    scrollview.smoothScrollTo(500, 0);
//                                }else{
//                                    Layout3_3_1_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                        IV3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    title = aconlast_title.get(2);
//                                    Glide.with(banner).load(imageurl + aconlast_imagepath.get(2)).into(banner);
//                                    Layout3_3_1_3.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    banner1.setText(aconlast_sub_title.get(2));
//                                    banner2.setText(aconlast_title.get(2));
//                                    banner3.setText(aconlast_summary.get(2));
//                                    scrollview.smoothScrollTo(500, 0);
//                                }else{
//                                    Layout3_3_1_3.setBackground(null);
//                                }
//                            }
//                        });
//
//                        IV4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    title = aconlast_title.get(3);
//                                    Glide.with(banner).load(imageurl + aconlast_imagepath.get(3)).into(banner);
//                                    Layout3_3_1_4.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    banner1.setText(aconlast_sub_title.get(3));
//                                    banner2.setText(aconlast_title.get(3));
//                                    banner3.setText(aconlast_summary.get(3));
//                                    scrollview.smoothScrollTo(500, 0);
//                                }else{
//                                    Layout3_3_1_4.setBackground(null);
//                                }
//                            }
//                        });
//
//                        IV5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    title = aconlast_title.get(4);
//                                    Glide.with(banner).load(imageurl + aconlast_imagepath.get(4)).into(banner);
//                                    Layout3_3_1_5.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    banner1.setText(aconlast_sub_title.get(4));
//                                    banner2.setText(aconlast_title.get(4));
//                                    banner3.setText(aconlast_summary.get(4));
//                                    scrollview.smoothScrollTo(500, 0);
//                                }else{
//                                    Layout3_3_1_5.setBackground(null);
//                                }
//                            }
//                        });

                    } else{
//                    Home.setImageResource(R.drawable.homeselect);
                        v = getWindow().getCurrentFocus();
                        Log.d(TAG, "현재 포커스 >>" + v);
                    }
                }
            });

//            IV1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayer.class);
//                    nowurl = imageurl + aconlast_videopath.get(0);
//                    Log.d("URLERROR", nowurl);
//                    maintitle = aconlast_title.get(0);
//                    subtitle = aconlast_sub_title.get(0);
////                    creatortitle = feedall_author_nickname.get(0);
////                    creatorprofile = imageurl + feedall_author_picture.get(0);
////                    creatorauthorid = feedall_author_id.get(0);
//
//                    intent.putExtra("index", 0);
//                    intent.putExtra("category", 30);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//                }
//            });
//
//            IV2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayer.class);
//                    nowurl = imageurl + aconlast_videopath.get(1);
//                    Log.d("URLERROR", nowurl);
//                    maintitle = aconlast_title.get(1);
//                    subtitle = aconlast_sub_title.get(1);
////                    creatortitle = feedall_author_nickname.get(0);
////                    creatorprofile = imageurl + feedall_author_picture.get(0);
////                    creatorauthorid = feedall_author_id.get(0);
//
//                    intent.putExtra("index", 1);
//                    intent.putExtra("category", 30);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//                }
//            });
//
//            IV3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayer.class);
//                    nowurl = imageurl + aconlast_videopath.get(2);
//                    Log.d("URLERROR", nowurl);
//                    maintitle = aconlast_title.get(2);
//                    subtitle = aconlast_sub_title.get(2);
////                    creatortitle = feedall_author_nickname.get(0);
////                    creatorprofile = imageurl + feedall_author_picture.get(0);
////                    creatorauthorid = feedall_author_id.get(0);
//
//                    intent.putExtra("index", 2);
//                    intent.putExtra("category", 30);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//                }
//            });
//
//            IV4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayer.class);
//                    nowurl = imageurl + aconlast_videopath.get(3);
//                    Log.d("URLERROR", nowurl);
//                    maintitle = aconlast_title.get(3);
//                    subtitle = aconlast_sub_title.get(3);
////                    creatortitle = feedall_author_nickname.get(0);
////                    creatorprofile = imageurl + feedall_author_picture.get(0);
////                    creatorauthorid = feedall_author_id.get(0);
//
//                    intent.putExtra("index", 3);
//                    intent.putExtra("category", 30);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//                }
//            });
//
//            IV5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayer.class);
//                    nowurl = imageurl + aconlast_videopath.get(4);
//                    Log.d("URLERROR", nowurl);
//                    maintitle = aconlast_title.get(4);
//                    subtitle = aconlast_sub_title.get(4);
////                    creatortitle = feedall_author_nickname.get(0);
////                    creatorprofile = imageurl + feedall_author_picture.get(0);
////                    creatorauthorid = feedall_author_id.get(0);
//
//                    intent.putExtra("index", 4);
//                    intent.putExtra("category", 30);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//                }
//            });

            Home.requestFocus();

            scrollview.addView(Layout3);
            Layout1.addView(scrollview);

            setContentView(Layout1);


        }

    }


    public class HomeActivityPopularHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1000) {
                Home.requestFocus();
                onResume();
            }
        }
    }

    class HomeActivityAtrendDetailHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1000) {

//                select_voyage_id = popular_feed_id.get(selected_num);
//                maintitle = popular_content.get(selected_num);
//                subtitle = popular_content.get(selected_num);
//                creatortitle = popular_author_nickname.get(selected_num);
//                creatorprofile = imageurl + popular_author_picture.get(selected_num);
//                creatorauthorid = popular_author_id.get(selected_num);

//                nowurl = imageurl + atrend_detail_maincontent.get(0);

                Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayerActivity.class);
                intent.putExtra("index", selected_num + 1);
                intent.putExtra("category",0);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        }
    }

    class HomeActivityPopularDetailHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1000) {

//                select_voyage_id = popular_feed_id.get(selected_num);
//                maintitle = popular_content.get(selected_num);
//                subtitle = popular_content.get(selected_num);
//                creatortitle = popular_author_nickname.get(selected_num);
//                creatorprofile = imageurl + popular_author_picture.get(selected_num);
//                creatorauthorid = popular_author_id.get(selected_num);
//
//                Intent intent = new Intent(HomeActivity.this, AliseonOTTPlayer.class);
//                intent.putExtra("index", selected_num + 1);
//                intent.putExtra("category",0);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);

            }
        }
    }

    class HomeActivityCategoriesHandler extends Handler{

        @Override
        public void handleMessage(Message msg){

            if(msg.what == 1000){
                Home.requestFocus();
                Intent intent = new Intent(HomeActivity.this, VoyageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(0, 0);

            }

        }

    }

}


