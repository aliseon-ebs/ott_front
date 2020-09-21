package com.aliseon.ott.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import com.aliseon.ott.CircleImageView;
import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskTvottSearchVoyage;
import com.bumptech.glide.Glide;

import java.util.Locale;

import static com.aliseon.ott.Variable.loginlanguage;
import static com.aliseon.ott.Variable.cate_number;
import static com.aliseon.ott.Variable.keyword;
import static com.aliseon.ott.Variable.voyageapiload;
import static com.aliseon.ott.Variable.cate_name;
import static com.aliseon.ott.Variable.category_num;
import static com.aliseon.ott.Variable.voyagecategoryapiload;
import static com.aliseon.ott.Variable.voyagefocusapiload;
import static com.aliseon.ott.Variable.voyage_category_en;
import static com.aliseon.ott.Variable.voyage_category_id;
import static com.aliseon.ott.Variable.voyage_category_kr;
import static com.aliseon.ott.Variable.voyage_comment_count;
import static com.aliseon.ott.Variable.voyage_contents_id;
import static com.aliseon.ott.Variable.voyage_contents_type;
import static com.aliseon.ott.Variable.voyage_create_at;
import static com.aliseon.ott.Variable.voyage_id;
import static com.aliseon.ott.Variable.voyage_like_count;
import static com.aliseon.ott.Variable.voyage_nickname;
import static com.aliseon.ott.Variable.voyage_photo;
import static com.aliseon.ott.Variable.voyage_description;
import static com.aliseon.ott.Variable.voyage_p_thumbnail;
import static com.aliseon.ott.Variable.voyage_product_id;
import static com.aliseon.ott.Variable.voyage_status;
import static com.aliseon.ott.Variable.voyage_update_at;
import static com.aliseon.ott.Variable.voyage_user_id;
import static com.aliseon.ott.Variable.voyage_view_count;
import static com.aliseon.ott.Variable.imageurl;
import static com.aliseon.ott.Variable.api_voyage;


public class VoyageActivity extends AppCompatActivity {

    private static String TAG = "카테고리 크기";

    TextView TV0;
    ImageView Search;
    LinearLayout Layout3_0;

    int iii = 0;

    public static SearchActivityVoyageHandler searchactivityvoyagehandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_all);

        cate_name.clear();
        cate_number.clear();
        cate_name.add(getString(R.string.all));
        cate_number.add("0");

        voyage_id.clear();
        voyage_user_id.clear();
        voyage_product_id.clear();
        voyage_contents_id.clear();
        voyage_contents_type.clear();
        voyage_category_id.clear();
        voyage_status.clear();
        voyage_description.clear();
        voyage_create_at.clear();
        voyage_update_at.clear();
        voyage_like_count.clear();
        voyage_view_count.clear();
        voyage_comment_count.clear();
        voyage_category_en.clear();
        voyage_category_kr.clear();
        voyage_nickname.clear();
        voyage_photo.clear();
        voyage_p_thumbnail.clear();

        SharedPreferences prf = getSharedPreferences("login_session", MODE_PRIVATE);

        switch (prf.getString("language", "")) {
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

        searchactivityvoyagehandler = new SearchActivityVoyageHandler();

        if(loginlanguage.contains("empty")){
            loginlanguage = "en";
        }

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
            LinearLayout Layout4 = new LinearLayout(this);

            ScrollView scroller = new ScrollView(this);
            ScrollView scroller2 = new ScrollView(this);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            ImageView Home = new ImageView(this);
            Home.setFocusableInTouchMode(true);
            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Search = new ImageView(this);
            Search.setFocusableInTouchMode(true);
            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView User = new ImageView(this);
            User.setFocusableInTouchMode(true);
            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            EditText edittext = new EditText(this);
            ImageView logo = new ImageView(this);
            ImageView Cart = new ImageView(this);
            Cart.setFocusableInTouchMode(true);
            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Cart.setPadding(15, 15, 15, 15);

            CircleImageView My = new CircleImageView(this);
            My.setFocusableInTouchMode(true);
            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            My.setPadding(15, 15, 15, 15);

            if (prf.getString("userinfo_picture", "").equals("empty")) {
                My.setImageResource(R.drawable.noimg_profile);
            } else {
                Glide.with(this).load(imageurl + prf.getString("userinfo_picture", "")).into(My);
            }

            ImageView Setting = new ImageView(this);
            Setting.setFocusableInTouchMode(true);
            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Setting.setPadding(15, 15, 15, 15);


            Home.setImageResource(R.drawable.home);
            Search.setImageResource(R.drawable.search);
            User.setImageResource(R.drawable.user);
            Setting.setImageResource(R.drawable.setting);
            logo.setImageResource(R.drawable.aliseonblackwhilte);
            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Cart.setId(R.id.allcart);
            Cart.setImageResource(R.drawable.cart);
            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);

            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));

            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);

            edittext.setLayoutParams(new ViewGroup.LayoutParams(1130, 60));
            edittext.setTextSize(12);
            edittext.setPadding(20, 10, 0, 10);
            edittext.setHintTextColor(Color.rgb(255, 255, 255));
            edittext.setTextColor(Color.rgb(255, 255, 255));
            edittext.setSingleLine(true);
            edittext.setId(R.id.editAll);
            edittext.setText(keyword);
            logo.setLayoutParams(new ViewGroup.LayoutParams(150, 60));
            logo.setScaleType(ImageView.ScaleType.FIT_CENTER);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 110);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180);
            LinearLayout.LayoutParams params4_1_1 = new LinearLayout.LayoutParams(1160, 180);
            LinearLayout.LayoutParams params4_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180);
            LinearLayout.LayoutParams params4_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 420);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

            paramsTitleTV.bottomMargin = 10;
            paramsMainLayout.leftMargin = 15;
            paramsMainLayout.rightMargin = 15;
            paramsMainLayout.bottomMargin = 20;
            params4_2.bottomMargin = 30;
            params4_2.leftMargin = 15;


            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
            ViewGroup.MarginLayoutParams marginlogo = new ViewGroup.MarginLayoutParams(logo.getLayoutParams());
            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());

            margin.setMargins(10, 20, 5, 20);
            margin2.setMargins(10, 20, 5, 20);
            margin3.setMargins(10, 20, 5, 20);
            margin4.setMargins(10, 20, 5, 20);
            margin5.setMargins(0, 20, 5, 20);
            margin6.setMargins(10, 20, 20, 20);
            marginlogo.setMargins(40, 58, 0, 0);

            scroller.setLayoutParams(params3);
            scroller.setVerticalScrollBarEnabled(false);
            scroller2.setLayoutParams(params4);
            scroller2.setVerticalScrollBarEnabled(false);


            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout2.setLayoutParams(params2);
            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
            Layout4.setBackgroundColor(Color.rgb(29, 29, 29));

            Layout2_1.setLayoutParams(params2_1);

            Layout2_2.setLayoutParams(params2_1);
            Layout2_2.setGravity(Gravity.BOTTOM);

            Layout2_1_1.setLayoutParams(params2_1);
            Layout2_1_1.setLayoutParams(margin);
            Layout2_1_2.setLayoutParams(params2_1);
            Layout2_1_2.setLayoutParams(margin2);
            Layout2_1_3.setLayoutParams(params2_1);
            Layout2_1_3.setLayoutParams(margin3);
            Layout2_1_4.setLayoutParams(params2_1);
            Layout2_1_4.setLayoutParams(margin4);
            Layout2_1_5.setLayoutParams(params2_1);
            Layout2_1_5.setLayoutParams(margin5);

            Layout2_2_1.setLayoutParams(params2_1);
            Layout2_2_1.setLayoutParams(margin6);

            if (voyageapiload == 0) {

                LinearLayout Layout3_0 = new LinearLayout(this);
                LinearLayout Layout3_1 = new LinearLayout(this);
                LinearLayout Layout3_2 = new LinearLayout(this);
                LinearLayout Layout3_3 = new LinearLayout(this);
                LinearLayout Layout3_4 = new LinearLayout(this);
                LinearLayout Layout3_5 = new LinearLayout(this);
                LinearLayout Layout3_6 = new LinearLayout(this);
                LinearLayout Layout3_7 = new LinearLayout(this);
                LinearLayout Layout3_8 = new LinearLayout(this);
                LinearLayout Layout3_9 = new LinearLayout(this);
                LinearLayout Layout3_10 = new LinearLayout(this);
                LinearLayout Layout3_11 = new LinearLayout(this);
                LinearLayout Layout3_12 = new LinearLayout(this);
                LinearLayout Layout3_13 = new LinearLayout(this);
                LinearLayout Layout3_14 = new LinearLayout(this);
                LinearLayout Layout3_15 = new LinearLayout(this);
                Layout3_0.setLayoutParams(params3_1);
                Layout3_1.setLayoutParams(params3_1);
                Layout3_2.setLayoutParams(params3_1);
                Layout3_3.setLayoutParams(params3_1);
                Layout3_4.setLayoutParams(params3_1);
                Layout3_5.setLayoutParams(params3_1);
                Layout3_6.setLayoutParams(params3_1);
                Layout3_7.setLayoutParams(params3_1);
                Layout3_8.setLayoutParams(params3_1);
                Layout3_9.setLayoutParams(params3_1);
                Layout3_10.setLayoutParams(params3_1);
                Layout3_11.setLayoutParams(params3_1);
                Layout3_12.setLayoutParams(params3_1);
                Layout3_13.setLayoutParams(params3_1);
                Layout3_14.setLayoutParams(params3_1);
                Layout3_15.setLayoutParams(params3_1);
                Layout3_0.setGravity(Gravity.CENTER);
                Layout3_1.setGravity(Gravity.CENTER);
                Layout3_2.setGravity(Gravity.CENTER);
                Layout3_3.setGravity(Gravity.CENTER);
                Layout3_4.setGravity(Gravity.CENTER);
                Layout3_5.setGravity(Gravity.CENTER);
                Layout3_6.setGravity(Gravity.CENTER);
                Layout3_7.setGravity(Gravity.CENTER);
                Layout3_8.setGravity(Gravity.CENTER);
                Layout3_9.setGravity(Gravity.CENTER);
                Layout3_10.setGravity(Gravity.CENTER);
                Layout3_11.setGravity(Gravity.CENTER);
                Layout3_12.setGravity(Gravity.CENTER);
                Layout3_13.setGravity(Gravity.CENTER);
                Layout3_14.setGravity(Gravity.CENTER);
                Layout3_15.setGravity(Gravity.CENTER);

                ImageView IV000 = new ImageView(this);
                IV000.setImageResource(R.drawable.noing_category);
                IV000.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV000.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV001 = new ImageView(this);
                IV001.setImageResource(R.drawable.noing_category);
                IV001.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV001.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV002 = new ImageView(this);
                IV002.setImageResource(R.drawable.noing_category);
                IV002.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV002.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV003 = new ImageView(this);
                IV003.setImageResource(R.drawable.noing_category);
                IV003.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV003.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV004 = new ImageView(this);
                IV004.setImageResource(R.drawable.noing_category);
                IV004.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV004.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV005 = new ImageView(this);
                IV005.setImageResource(R.drawable.noing_category);
                IV005.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV005.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV006 = new ImageView(this);
                IV006.setImageResource(R.drawable.noing_category);
                IV006.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV006.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV007 = new ImageView(this);
                IV007.setImageResource(R.drawable.noing_category);
                IV007.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV007.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV008 = new ImageView(this);
                IV008.setImageResource(R.drawable.noing_category);
                IV008.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV008.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV009 = new ImageView(this);
                IV009.setImageResource(R.drawable.noing_category);
                IV009.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV009.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV010 = new ImageView(this);
                IV010.setImageResource(R.drawable.noing_category);
                IV010.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV010.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV011 = new ImageView(this);
                IV011.setImageResource(R.drawable.noing_category);
                IV011.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV011.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV012 = new ImageView(this);
                IV012.setImageResource(R.drawable.noing_category);
                IV012.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV012.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV013 = new ImageView(this);
                IV013.setImageResource(R.drawable.noing_category);
                IV013.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV013.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV014 = new ImageView(this);
                IV014.setImageResource(R.drawable.noing_category);
                IV014.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV014.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView IV015 = new ImageView(this);
                IV015.setImageResource(R.drawable.noing_category);
                IV015.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                IV015.setScaleType(ImageView.ScaleType.FIT_CENTER);
                Layout3_0.addView(IV000);
                Layout3_1.addView(IV001);
                Layout3_2.addView(IV002);
                Layout3_3.addView(IV003);
                Layout3_4.addView(IV004);
                Layout3_5.addView(IV005);
                Layout3_6.addView(IV006);
                Layout3_7.addView(IV007);
                Layout3_8.addView(IV008);
                Layout3_9.addView(IV009);
                Layout3_10.addView(IV010);
                Layout3_11.addView(IV011);
                Layout3_12.addView(IV012);
                Layout3_13.addView(IV013);
                Layout3_14.addView(IV014);
                Layout3_15.addView(IV015);

                LinearLayout Layout4_1 = new LinearLayout(this);
                LinearLayout Layout4_1_1 = new LinearLayout(this);
                LinearLayout Layout4_1_2 = new LinearLayout(this);

                Layout4_1.setOrientation(LinearLayout.HORIZONTAL);
                Layout4_1_1.setOrientation(LinearLayout.VERTICAL);
                Layout4_1_2.setOrientation(LinearLayout.VERTICAL);

                Layout4_1_1.setGravity(Gravity.CENTER);
                Layout4_1_2.setGravity(Gravity.CENTER);

                edittext.setBackgroundColor(Color.rgb(38, 38, 38));

                Layout4_1.setLayoutParams(params4_1);
                Layout4_1_1.setLayoutParams(params4_1_1);
                Layout4_1_1.setPadding(30, 0, 0, 0);
                Layout4_1_2.setLayoutParams(params4_1_2);
                Layout4_1_2.setLayoutParams(marginlogo);

                Layout4.addView(Layout4_1);
                Layout4_1.addView(Layout4_1_1);
                Layout4_1_1.addView(edittext);
                Layout4_1.addView(Layout4_1_2);
                Layout4_1_2.addView(logo);


                Home.setId(R.id.allhome);
                Search.setId(R.id.allsearch);
                User.setId(R.id.alluser);

                Layout4.setLayoutParams(params4);

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

                Layout3.setOrientation(LinearLayout.VERTICAL);

                Layout3.addView(Layout3_0);
                Layout3.addView(Layout3_1);
                Layout3.addView(Layout3_2);
                Layout3.addView(Layout3_3);
                Layout3.addView(Layout3_4);
                Layout3.addView(Layout3_5);
                Layout3.addView(Layout3_6);
                Layout3.addView(Layout3_7);
                Layout3.addView(Layout3_8);
                Layout3.addView(Layout3_9);
                Layout3.addView(Layout3_10);
                Layout3.addView(Layout3_11);
                Layout3.addView(Layout3_12);
                Layout3.addView(Layout3_13);
                Layout3.addView(Layout3_14);
                Layout3.addView(Layout3_15);

                Layout1.addView(Layout3);

                Layout4.setOrientation(LinearLayout.VERTICAL);

                Layout1.addView(Layout4);

                Log.d("create 통과", "false 통과");

                if (voyageapiload == 0) {

                    for (int i = 0; i < 2; i++) {
                        LinearLayout Layout4_2 = new LinearLayout(this);
                        Layout4_2.setLayoutParams(params4_2);
                        Layout4_2.setGravity(Gravity.CENTER | Gravity.LEFT);
                        Layout4.addView(Layout4_2);

                        for (int ii = 0; ii < 3; ii++) {
                            LinearLayout Layout4_2_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1 = new LinearLayout(this);
                            ImageView IV11 = new ImageView(this);
                            Glide.with(this).load(R.drawable.noing_layout).into(IV11);

                            Layout4_2_1.setGravity(Gravity.CENTER);
                            Layout4_2_1_1.setLayoutParams(paramsMainLayout);
                            Layout4_2_1_1.setFocusableInTouchMode(true);

                            Layout4_2_1_1.addView(IV11);
                            Layout4_2_1.addView(Layout4_2_1_1);
                            Layout4_2.addView(Layout4_2_1);
                        }
                    }

//                ProgressBar progressbar = new ProgressBar(this);
//                progressbar.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
//                LinearLayout Layout4_3 = new LinearLayout(this);
//                LinearLayout.LayoutParams params4_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
//                Layout4_3.setLayoutParams(params4_3);
//                Layout4_3.setGravity(Gravity.CENTER);
//                Layout4_3.addView(progressbar);
//                Layout4.addView(Layout4_3);
                    Search.requestFocus();

                    setContentView(Layout1);

                } else {

                    int jj = voyage_p_thumbnail.size() / 3 + 1;
                    int y = voyage_p_thumbnail.size() % 3;

                    int j = 0;
                    for (int i = 0; i < jj; i++) {
                        LinearLayout Layout4_2 = new LinearLayout(this);
                        Layout4_2.setLayoutParams(params4_2);
                        Layout4_2.setGravity(Gravity.CENTER | Gravity.LEFT);

                        // 마지막 줄일때
                        if (i == jj - 1) {

                            // 나머지가 0일 경우 위의 for에서 빈칸만 생성한 것이 되므로 삭제
                            if (y == 0) {
                                Layout4.removeView(Layout4_2);
                            }

                            // 나머지의 수만큼 컨텐츠를 추가함 (만약 나머지. 즉 y가 0일 경우, 작동하지 않음)
                            for (int ii = 0; ii < y; ii++) {
                                LinearLayout Layout4_2_1 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_1 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_2 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_2_1 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_2_2 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_2_2_1 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_2_2_2 = new LinearLayout(this);


                                Layout4_2_1.setGravity(Gravity.CENTER);
                                ImageView IV11 = new ImageView(this);
                                CircleImageView CIV11 = new CircleImageView(this);
                                IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 286));
                                CIV11.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
                                TextView TV11_1 = new TextView(this);
                                TextView TV11_2 = new TextView(this);

                                try {
                                    Glide.with(this).load(imageurl + voyage_p_thumbnail.get(j).get(0)).into(IV11);
                                    Glide.with(this).load(imageurl + voyage_photo.get(j)).into(CIV11);

                                    IV11.setScaleType(ImageView.ScaleType.FIT_XY);

                                    Layout4_2_1_1.setOrientation(LinearLayout.VERTICAL);
                                    Layout4_2_1_1.setFocusableInTouchMode(true);

                                    TV11_1.setText(voyage_description.get(j));
                                    TV11_1.setTextSize(14);
                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                    TV11_2.setText(voyage_nickname.get(j) + "\n" + voyage_view_count.get(j) + " views");
                                    TV11_2.setTextSize(10);
                                    TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                } catch (Exception e) {
                                    Layout4_2_1_1_1.setBackgroundColor(Color.rgb(100, 100, 100));
                                }

                                Layout4_2_1_1.addView(Layout4_2_1_1_1);
                                Layout4_2_1_1_1.addView(IV11);
                                Layout4_2_1_1.addView(Layout4_2_1_1_2);
                                Layout4_2_1_1_2.setLayoutParams(params3);
                                Layout4_2_1_1_2.setOrientation(LinearLayout.VERTICAL);
                                Layout4_2_1_1_2.addView(Layout4_2_1_1_2_1);
                                Layout4_2_1_1_2.setGravity(Gravity.CENTER);
                                Layout4_2_1_1_2_1.addView(TV11_1);
                                TV11_1.setPadding(30, 0, 60, 0);
                                Layout4_2_1_1_2_1.setLayoutParams(paramsTitleTV);
                                Layout4_2_1_1_2.addView(Layout4_2_1_1_2_2);
                                Layout4_2_1_1_2_2.setOrientation(LinearLayout.HORIZONTAL);
                                Layout4_2_1_1_2_2.addView(Layout4_2_1_1_2_2_1);
                                Layout4_2_1_1_2_2.setPadding(0, 0, 0, 10);
                                Layout4_2_1_1_2_2_1.setPadding(25, 0, 0, 0);
                                Layout4_2_1_1_2_2_1.addView(CIV11);
                                Layout4_2_1_1_2_2_2.setLayoutParams(params3);
                                Layout4_2_1_1_2_2_2.setOrientation(LinearLayout.VERTICAL);
                                Layout4_2_1_1_2_2.addView(Layout4_2_1_1_2_2_2);
                                Layout4_2_1_1_2_2_2.setGravity(Gravity.CENTER | Gravity.CENTER);
                                Layout4_2_1_1_2_2_2.addView(TV11_2);

                                Layout4_2_1_1_2_2_1.setLayoutParams(paramsCIV);
                                Layout4_2_1_1_2_2_1.setGravity(Gravity.CENTER);

                                Layout4_2_1_1.setLayoutParams(paramsMainLayout);
                                Layout4_2_1_1.setFocusableInTouchMode(true);

                                Layout4_2_1.addView(Layout4_2_1_1);
                                Layout4_2.addView(Layout4_2_1);

                                Layout4_2_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                    @Override
                                    public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                        if (hasFocus == false) {
                                            Layout4_2_1_1.setBackground(null);
                                            TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                            TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                            Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                                @Override
                                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                    if (hasFocus) {
                                                        Home.setImageResource(R.drawable.home);
//                                Search.setImageResource(R.drawable.searchselect);
                                                        Intent intent = new Intent(VoyageActivity.this, HomeActivity.class);
                                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                        startActivity(intent);
                                                        voyageapiload = 0;
//                finish();
                                                    } else {
                                                        Home.setImageResource(R.drawable.home);
                                                    }
                                                }
                                            });
                                            User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                                @Override
                                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                    if (hasFocus) {
                                                        Home.setImageResource(R.drawable.home);
//                                User.setImageResource(R.drawable.userselect);
                                                        Intent intent = new Intent(VoyageActivity.this, SubscribeActivity.class);
                                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                        startActivity(intent);
//                finish();
                                                    } else {
                                                        User.setImageResource(R.drawable.user);
                                                    }
                                                }
                                            });

                                            Layout4_2_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                                @Override
                                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                    if (hasFocus) {
                                                        Layout4_2_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                                        TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                                        TV11_2.setTextColor(Color.rgb(0, 0, 0));
                                                    } else {
                                                        Layout4_2_1_1.setBackground(null);
                                                        TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                                        TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                                    }
                                                }
                                            });

                                        } else {
                                            Layout4_2_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                            TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                            TV11_2.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                                        }
                                    }
                                });

                                if (i == 0 && ii == 0) {
                                    Layout4_2_1_1.setId(R.id.LayoutAll);
//                    Layout4_2_1_1.requestFocus();
                                    TV0.setNextFocusRightId(R.id.LayoutAll);
                                    Layout4_2_1_1.setNextFocusLeftId(R.id.all1);
                                }

                                if (ii == 0) {
                                    Layout4_2_1_1.setId(R.id.LayoutAll);
                                    Layout4_2_1_1.setNextFocusLeftId(R.id.all1);
                                }

                                final int jjj = j;
                                Layout4_2_1_1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
//                        nowurl = imageurl + feed_video.get(0);
//                        maintitle = feed_content.get(0);
//                                        Intent intent = new Intent(SearchActivityAll.this, AliseonOTTPlayer.class);
//                                        nowurl = imageurl + feedall_video.get(jjj);
//                                        maintitle = voyageall_description.get(jjj);
//                                        subtitle = voyageall_description.get(jjj);
//                                        creatortitle = voyageall_name.get(jjj);
//                                        creatorprofile = imageurl + voyageall_photo.get(jjj);
//                                        creatorauthorid = voyageall_user_id.get(jjj);
//                                        intent.putExtra("index", jjj + 1);
//                                        intent.putExtra("category", 1);
//                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                        startActivity(intent);
                                    }
                                });

                                j++;
                            }

                        } else {
                            for (int ii = 0; ii < 3; ii++) {
                                LinearLayout Layout4_2_1 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_1 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_2 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_2_1 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_2_2 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_2_2_1 = new LinearLayout(this);
                                LinearLayout Layout4_2_1_1_2_2_2 = new LinearLayout(this);


                                Layout4_2_1.setGravity(Gravity.CENTER);
                                ImageView IV11 = new ImageView(this);
                                CircleImageView CIV11 = new CircleImageView(this);
                                IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 286));
                                CIV11.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
                                TextView TV11_1 = new TextView(this);
                                TextView TV11_2 = new TextView(this);

                                try {
                                    Glide.with(this).load(imageurl + voyage_p_thumbnail.get(j).get(0)).into(IV11);
                                    Glide.with(this).load(imageurl + voyage_photo.get(j)).into(CIV11);

                                    IV11.setScaleType(ImageView.ScaleType.FIT_XY);

                                    Layout4_2_1_1.setOrientation(LinearLayout.VERTICAL);
                                    Layout4_2_1_1.setFocusableInTouchMode(true);

                                    TV11_1.setText(voyage_description.get(j));
                                    TV11_1.setTextSize(14);
                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                    TV11_2.setText(voyage_nickname.get(j) + "\n" + voyage_view_count.get(j) + " views");
                                    TV11_2.setTextSize(10);
                                    TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                } catch (Exception e) {
                                    Layout4_2_1_1_1.setBackgroundColor(Color.rgb(100, 100, 100));
                                }

                                Layout4_2_1_1.addView(Layout4_2_1_1_1);
                                Layout4_2_1_1_1.addView(IV11);
                                Layout4_2_1_1.addView(Layout4_2_1_1_2);
                                Layout4_2_1_1_2.setLayoutParams(params3);
                                Layout4_2_1_1_2.setOrientation(LinearLayout.VERTICAL);
                                Layout4_2_1_1_2.addView(Layout4_2_1_1_2_1);
                                Layout4_2_1_1_2.setGravity(Gravity.CENTER);
                                Layout4_2_1_1_2_1.addView(TV11_1);
                                TV11_1.setPadding(30, 0, 60, 0);
                                Layout4_2_1_1_2_1.setLayoutParams(paramsTitleTV);
                                Layout4_2_1_1_2.addView(Layout4_2_1_1_2_2);
                                Layout4_2_1_1_2_2.setOrientation(LinearLayout.HORIZONTAL);
                                Layout4_2_1_1_2_2.addView(Layout4_2_1_1_2_2_1);
                                Layout4_2_1_1_2_2.setPadding(0, 0, 0, 10);
                                Layout4_2_1_1_2_2_1.setPadding(25, 0, 0, 0);
                                Layout4_2_1_1_2_2_1.addView(CIV11);
                                Layout4_2_1_1_2_2_2.setLayoutParams(params3);
                                Layout4_2_1_1_2_2_2.setOrientation(LinearLayout.VERTICAL);
                                Layout4_2_1_1_2_2.addView(Layout4_2_1_1_2_2_2);
                                Layout4_2_1_1_2_2_2.setGravity(Gravity.CENTER | Gravity.CENTER);
                                Layout4_2_1_1_2_2_2.addView(TV11_2);

                                Layout4_2_1_1_2_2_1.setLayoutParams(paramsCIV);
                                Layout4_2_1_1_2_2_1.setGravity(Gravity.CENTER);

                                Layout4_2_1_1.setLayoutParams(paramsMainLayout);
                                Layout4_2_1_1.setFocusableInTouchMode(true);

                                Layout4_2_1.addView(Layout4_2_1_1);
                                Layout4_2.addView(Layout4_2_1);

                                Layout4_2_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                    @Override
                                    public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                        if (hasFocus == false) {
                                            Layout4_2_1_1.setBackground(null);
                                            TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                            TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                            Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                                @Override
                                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                    if (hasFocus) {
                                                        Home.setImageResource(R.drawable.home);
//                                Search.setImageResource(R.drawable.searchselect);
                                                        Intent intent = new Intent(VoyageActivity.this, HomeActivity.class);
                                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                        startActivity(intent);
                                                        voyageapiload = 0;
//                finish();
                                                    } else {
                                                        Home.setImageResource(R.drawable.home);
                                                    }
                                                }
                                            });
                                            User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                                @Override
                                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                    if (hasFocus) {
                                                        Home.setImageResource(R.drawable.home);
//                                User.setImageResource(R.drawable.userselect);
                                                        Intent intent = new Intent(VoyageActivity.this, SubscribeActivity.class);
                                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                        startActivity(intent);
//                finish();
                                                    } else {
                                                        User.setImageResource(R.drawable.user);
                                                    }
                                                }
                                            });

                                            Layout4_2_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                                @Override
                                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                    if (hasFocus) {
                                                        Layout4_2_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                                        TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                                        TV11_2.setTextColor(Color.rgb(0, 0, 0));
                                                    } else {
                                                        Layout4_2_1_1.setBackground(null);
                                                        TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                                        TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                                    }
                                                }
                                            });

                                        } else {
                                            Layout4_2_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                            TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                            TV11_2.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                                        }
                                    }
                                });

                                edittext.setImeOptions(EditorInfo.IME_ACTION_SEARCH);

                                edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                                    @Override
                                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                                        switch (actionId) {
                                            case EditorInfo.IME_ACTION_SEARCH:
                                                keyword = edittext.getText().toString();
                                                category_num = 0;
                                                Intent intent = new Intent(VoyageActivity.this, VoyageResultActivity.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                startActivity(intent);
                                                break;
                                            case EditorInfo.IME_ACTION_GO:
                                                keyword = edittext.getText().toString();
                                                category_num = 0;
                                                Intent intent2 = new Intent(VoyageActivity.this, VoyageResultActivity.class);
                                                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                startActivity(intent2);
                                                break;
                                            case EditorInfo.IME_ACTION_NEXT:
                                                keyword = edittext.getText().toString();
                                                category_num = 0;
                                                Intent intent3 = new Intent(VoyageActivity.this, VoyageResultActivity.class);
                                                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                startActivity(intent3);
                                                break;
                                            default:
                                                keyword = edittext.getText().toString();
                                                category_num = 0;
                                                Intent intent4 = new Intent(VoyageActivity.this, VoyageResultActivity.class);
                                                intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                startActivity(intent4);
                                                return false;
                                        }
                                        return true;
                                    }
                                });

                                if (i == 0 && ii == 0) {
                                    Layout4_2_1_1.setId(R.id.LayoutAll);
//                    Layout4_2_1_1.requestFocus();
                                    TV0.setNextFocusRightId(R.id.LayoutAll);
                                    Layout4_2_1_1.setNextFocusLeftId(R.id.all1);
                                }

                                if (ii == 0) {
                                    Layout4_2_1_1.setId(R.id.LayoutAll);
                                    Layout4_2_1_1.setNextFocusLeftId(R.id.all1);
                                }

                                final int jjj = j;
                                Layout4_2_1_1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
//                        nowurl = imageurl + feed_video.get(0);
//                        maintitle = feed_content.get(0);
//                                        Intent intent = new Intent(SearchActivityAll.this, AliseonOTTPlayer.class);
//                                        nowurl = imageurl + feedall_video.get(jjj);
//                                        maintitle = voyageall_description.get(jjj);
//                                        subtitle = voyageall_description.get(jjj);
//                                        creatortitle = voyageall_name.get(jjj);
//                                        creatorprofile = imageurl + voyageall_photo.get(jjj);
//                                        creatorauthorid = voyageall_user_id.get(jjj);
//                                        intent.putExtra("index", jjj + 1);
//                                        intent.putExtra("category", 1);
//                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                        startActivity(intent);
                                    }
                                });

                                j++;
                            }

                        }

                    }
                }

                searchactivityvoyagehandler = new SearchActivityVoyageHandler();

                if(voyageapiload == 0) {
                    searchactivityvoyagehandler.post(new Runnable() {
                        @Override
                        public void run() {
                            NetworkTaskTvottSearchVoyage networktasktvottsearchvoyage = new NetworkTaskTvottSearchVoyage(api_voyage, null);
                            networktasktvottsearchvoyage.execute();
                        }
                    });
                }
            }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Search.requestFocus();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Search.requestFocus();
        overridePendingTransition(0, 0);
        voyageapiload = 0;
        voyagecategoryapiload = 0;
        category_num = 0;
    }

    @Override
    public void recreate() {
        super.recreate();
        Search.requestFocus();
    }

    @Override
    public void onResume(){
        super.onResume();

        if(voyageapiload == 1) {

            SharedPreferences prf = getSharedPreferences("login_session", MODE_PRIVATE);

            switch (prf.getString("language", "")) {
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
            LinearLayout Layout4 = new LinearLayout(this);

            ScrollView scroller = new ScrollView(this);
            ScrollView scroller2 = new ScrollView(this);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            ImageView Home = new ImageView(this);
            Home.setFocusableInTouchMode(true);
            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Search = new ImageView(this);
            Search.setFocusableInTouchMode(true);
            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView User = new ImageView(this);
            User.setFocusableInTouchMode(true);
            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            EditText edittext = new EditText(this);
            ImageView logo = new ImageView(this);
            ImageView Cart = new ImageView(this);
            Cart.setFocusableInTouchMode(true);
            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Cart.setPadding(15, 15, 15, 15);

            CircleImageView My = new CircleImageView(this);
            My.setFocusableInTouchMode(true);
            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            My.setPadding(15, 15, 15, 15);

            if (prf.getString("userinfo_picture", "").equals("empty")) {
                My.setImageResource(R.drawable.noimg_profile);
            } else {
                Glide.with(this).load(imageurl + prf.getString("userinfo_picture", "")).into(My);
            }

            ImageView Setting = new ImageView(this);
            Setting.setFocusableInTouchMode(true);
            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Setting.setPadding(15, 15, 15, 15);


            Home.setImageResource(R.drawable.home);
            Search.setImageResource(R.drawable.search);
            User.setImageResource(R.drawable.user);
            Setting.setImageResource(R.drawable.setting);
            logo.setImageResource(R.drawable.aliseonblackwhilte);
            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Cart.setId(R.id.allcart);
            Cart.setImageResource(R.drawable.cart);
            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);

            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));

            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);

            edittext.setLayoutParams(new ViewGroup.LayoutParams(1130, 60));
            edittext.setTextSize(12);
            edittext.setPadding(20, 10, 0, 10);
            edittext.setHintTextColor(Color.rgb(255, 255, 255));
            edittext.setTextColor(Color.rgb(255, 255, 255));
            edittext.setSingleLine(true);
            edittext.setId(R.id.editAll);
            edittext.setText(keyword);
            logo.setLayoutParams(new ViewGroup.LayoutParams(150, 60));
            logo.setScaleType(ImageView.ScaleType.FIT_CENTER);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180);
            LinearLayout.LayoutParams params4_1_1 = new LinearLayout.LayoutParams(1160, 180);
            LinearLayout.LayoutParams params4_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180);
            LinearLayout.LayoutParams params4_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 420);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

            paramsTitleTV.bottomMargin = 10;
            paramsMainLayout.leftMargin = 15;
            paramsMainLayout.rightMargin = 15;
            paramsMainLayout.bottomMargin = 20;
            params4_2.bottomMargin = 30;
            params4_2.leftMargin = 15;


            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
            ViewGroup.MarginLayoutParams marginlogo = new ViewGroup.MarginLayoutParams(logo.getLayoutParams());
            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());

            margin.setMargins(10, 20, 5, 20);
            margin2.setMargins(10, 20, 5, 20);
            margin3.setMargins(10, 20, 5, 20);
            margin4.setMargins(10, 20, 5, 20);
            margin5.setMargins(0, 20, 5, 20);
            margin6.setMargins(10, 20, 20, 20);
            marginlogo.setMargins(40, 58, 0, 0);

            scroller.setLayoutParams(params3);
            scroller.setVerticalScrollBarEnabled(false);
            scroller2.setLayoutParams(params4);
            scroller2.setVerticalScrollBarEnabled(false);


            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout2.setLayoutParams(params2);
            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
            Layout4.setBackgroundColor(Color.rgb(29, 29, 29));

            Layout2_1.setLayoutParams(params2_1);

            Layout2_2.setLayoutParams(params2_1);
            Layout2_2.setGravity(Gravity.BOTTOM);

            Layout2_1_1.setLayoutParams(params2_1);
            Layout2_1_1.setLayoutParams(margin);
            Layout2_1_2.setLayoutParams(params2_1);
            Layout2_1_2.setLayoutParams(margin2);
            Layout2_1_3.setLayoutParams(params2_1);
            Layout2_1_3.setLayoutParams(margin3);
            Layout2_1_4.setLayoutParams(params2_1);
            Layout2_1_4.setLayoutParams(margin4);
            Layout2_1_5.setLayoutParams(params2_1);
            Layout2_1_5.setLayoutParams(margin5);

            Layout2_2_1.setLayoutParams(params2_1);
            Layout2_2_1.setLayoutParams(margin6);


            edittext.setHint("Search");

            Layout3.setOrientation(LinearLayout.VERTICAL);

            Layout3.setLayoutParams(params3);

            Home.setId(R.id.allhome);
            Search.setId(R.id.allsearch);
            User.setId(R.id.alluser);

            edittext.setBackgroundColor(Color.rgb(100, 100, 100));

            Layout4.setLayoutParams(params4);

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

            scroller.addView(Layout3);
            Layout1.addView(scroller);

            LinearLayout Layout4_1 = new LinearLayout(this);
            LinearLayout Layout4_1_1 = new LinearLayout(this);
            LinearLayout Layout4_1_2 = new LinearLayout(this);

            Layout4.setOrientation(LinearLayout.VERTICAL);
            Layout4_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_1_1.setOrientation(LinearLayout.VERTICAL);
            Layout4_1_2.setOrientation(LinearLayout.VERTICAL);

            Layout4_1_1.setGravity(Gravity.CENTER);
            Layout4_1_2.setGravity(Gravity.CENTER);

            Layout4_1.setLayoutParams(params4_1);
            Layout4_1_1.setLayoutParams(params4_1_1);
            Layout4_1_1.setPadding(30, 0, 0, 0);
            Layout4_1_2.setLayoutParams(params4_1_2);
            Layout4_1_2.setLayoutParams(marginlogo);

            Layout4.addView(Layout4_1);
            Layout4_1.addView(Layout4_1_1);
            Layout4_1_1.addView(edittext);
            Layout4_1.addView(Layout4_1_2);
            Layout4_1_2.addView(logo);

            Log.d("create 통과", "true 통과");
            if (voyage_p_thumbnail.size() == 0) {

                LinearLayout Layout4_3 = new LinearLayout(this);
                LinearLayout.LayoutParams params4_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                Layout4_3.setLayoutParams(params4_3);
                Layout4_3.setGravity(Gravity.CENTER);
                TextView nocontents = new TextView(this);
                nocontents.setText(getString(R.string.nocontents));
                nocontents.setTextColor(Color.rgb(255, 255, 255));
                Layout4_3.addView(nocontents);
                nocontents.setTextSize(18);
                Layout4.addView(Layout4_3);
//                TV1.requestFocus();

            } else {

                Log.d(TAG, "내 영상 ori 썸네일>>" +  voyage_p_thumbnail);

                int jj = voyage_p_thumbnail.size() / 3 + 1;
                int y = voyage_p_thumbnail.size() % 3;

                int j = 0;
                for (int i = 0; i < jj; i++) {
                    LinearLayout Layout4_2 = new LinearLayout(this);
                    Layout4_2.setLayoutParams(params4_2);
                    Layout4_2.setGravity(Gravity.CENTER | Gravity.LEFT);
                    Layout4.addView(Layout4_2);

                    if (i == jj - 1) {
                        Log.d("활성화된 라인 :", String.valueOf(i));
                        if (y == 0) {
                            Layout4.removeView(Layout4_2);
                        }
                        for (int ii = 0; ii < y; ii++) {
                            LinearLayout Layout4_2_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_2 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_2_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_2_2 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_2_2_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_2_2_2 = new LinearLayout(this);


                            Layout4_2_1.setGravity(Gravity.CENTER);
                            ImageView IV11 = new ImageView(this);
                            CircleImageView CIV11 = new CircleImageView(this);
                            IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 286));
                            CIV11.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
                            TextView TV11_1 = new TextView(this);
                            TextView TV11_2 = new TextView(this);

                            try {
                                Glide.with(this).load(imageurl + voyage_p_thumbnail.get(j).get(0)).into(IV11);
                                Glide.with(this).load(imageurl + voyage_photo.get(j)).into(CIV11);

                                IV11.setScaleType(ImageView.ScaleType.FIT_XY);

                                Layout4_2_1_1.setOrientation(LinearLayout.VERTICAL);
                                Layout4_2_1_1.setFocusableInTouchMode(true);

                                TV11_1.setText(voyage_description.get(j));
                                TV11_1.setTextSize(14);
                                TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                TV11_2.setText(voyage_nickname.get(j) + "\n" + voyage_view_count.get(j) + " views");
                                TV11_2.setTextSize(10);
                                TV11_2.setTextColor(Color.rgb(255, 255, 255));
                            } catch (Exception e) {
                                Layout4_2_1_1_1.setBackgroundColor(Color.rgb(100, 100, 100));
                            }

                            Layout4_2_1_1.addView(Layout4_2_1_1_1);
                            Layout4_2_1_1_1.addView(IV11);
                            Layout4_2_1_1.addView(Layout4_2_1_1_2);
                            Layout4_2_1_1_2.setLayoutParams(params3);
                            Layout4_2_1_1_2.setOrientation(LinearLayout.VERTICAL);
                            Layout4_2_1_1_2.addView(Layout4_2_1_1_2_1);
                            Layout4_2_1_1_2.setGravity(Gravity.CENTER);
                            Layout4_2_1_1_2_1.addView(TV11_1);
                            TV11_1.setPadding(30, 0, 60, 0);
                            Layout4_2_1_1_2_1.setLayoutParams(paramsTitleTV);
                            Layout4_2_1_1_2.addView(Layout4_2_1_1_2_2);
                            Layout4_2_1_1_2_2.setOrientation(LinearLayout.HORIZONTAL);
                            Layout4_2_1_1_2_2.addView(Layout4_2_1_1_2_2_1);
                            Layout4_2_1_1_2_2.setPadding(0, 0, 0, 10);
                            Layout4_2_1_1_2_2_1.setPadding(25, 0, 0, 0);
                            Layout4_2_1_1_2_2_1.addView(CIV11);
                            Layout4_2_1_1_2_2_2.setLayoutParams(params3);
                            Layout4_2_1_1_2_2_2.setOrientation(LinearLayout.VERTICAL);
                            Layout4_2_1_1_2_2.addView(Layout4_2_1_1_2_2_2);
                            Layout4_2_1_1_2_2_2.setGravity(Gravity.CENTER | Gravity.CENTER);
                            Layout4_2_1_1_2_2_2.addView(TV11_2);

                            Layout4_2_1_1_2_2_1.setLayoutParams(paramsCIV);
                            Layout4_2_1_1_2_2_1.setGravity(Gravity.CENTER);

                            Layout4_2_1_1.setLayoutParams(paramsMainLayout);
                            Layout4_2_1_1.setFocusableInTouchMode(true);

                            Layout4_2_1.addView(Layout4_2_1_1);
                            Layout4_2.addView(Layout4_2_1);

                            Layout4_2_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                @Override
                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                    if (hasFocus == false) {
                                        Layout4_2_1_1.setBackground(null);
                                        TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                        TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                if (hasFocus) {
                                                    Home.setImageResource(R.drawable.home);
//                                Search.setImageResource(R.drawable.searchselect);
                                                    Intent intent = new Intent(VoyageActivity.this, HomeActivity.class);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                    startActivity(intent);
                                                    voyageapiload = 0;
//                finish();
                                                } else {
                                                    Home.setImageResource(R.drawable.home);
                                                }
                                            }
                                        });
                                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                if (hasFocus) {
                                                    Home.setImageResource(R.drawable.home);
//                                User.setImageResource(R.drawable.userselect);
                                                    Intent intent = new Intent(VoyageActivity.this, SubscribeActivity.class);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                    startActivity(intent);
//                finish();
                                                } else {
                                                    User.setImageResource(R.drawable.user);
                                                }
                                            }
                                        });

                                        Layout4_2_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                if (hasFocus) {
                                                    Layout4_2_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                                    TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                                    TV11_2.setTextColor(Color.rgb(0, 0, 0));
                                                } else {
                                                    Layout4_2_1_1.setBackground(null);
                                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                                    TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                                }
                                            }
                                        });

                                    } else {
                                        Layout4_2_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                        TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                        TV11_2.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                                    }
                                }
                            });

                            if (i == 0 && ii == 0) {
                                Layout4_2_1_1.setId(R.id.LayoutAll);
//                    Layout4_2_1_1.requestFocus();
//                                TV0.setNextFocusRightId(R.id.LayoutAll);
                                Layout4_2_1_1.setNextFocusLeftId(R.id.all1);
                            }

                            if (ii == 0) {
                                Layout4_2_1_1.setId(R.id.LayoutAll);
                                Layout4_2_1_1.setNextFocusLeftId(R.id.all1);
                            }

                            final int jjj = j;
                            Layout4_2_1_1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                        nowurl = imageurl + feed_video.get(0);
//                        maintitle = feed_content.get(0);

//                                    nowurl = imageurl + feedall_video.get(jjj);
//                                    maintitle = feedall_content.get(jjj);
//                                    subtitle = feedall_content.get(jjj);
//                                    creatortitle = feedall_author_nickname.get(jjj);
//                                    creatorprofile = imageurl + feedall_author_picture.get(jjj);
//                                    creatorauthorid = feedall_author_id.get(jjj);
                                    Intent intent = new Intent(VoyageActivity.this, AliseonOTTPlayerActivity.class);
                                    intent.putExtra("index", jjj);
                                    intent.putExtra("category", 3);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                }
                            });

                            j++;
                        }

                    } else {
                        Log.d("라인 :", String.valueOf(i));
                        for (int ii = 0; ii < 3; ii++) {
                            LinearLayout Layout4_2_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_2 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_2_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_2_2 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_2_2_1 = new LinearLayout(this);
                            LinearLayout Layout4_2_1_1_2_2_2 = new LinearLayout(this);


                            Layout4_2_1.setGravity(Gravity.CENTER);
                            ImageView IV11 = new ImageView(this);
                            CircleImageView CIV11 = new CircleImageView(this);
                            IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 286));
                            CIV11.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
                            TextView TV11_1 = new TextView(this);
                            TextView TV11_2 = new TextView(this);


                            try {
                                Glide.with(this).load(imageurl + voyage_p_thumbnail.get(j).get(0)).into(IV11);
                                Glide.with(this).load(imageurl + voyage_photo.get(j)).into(CIV11);

                                IV11.setScaleType(ImageView.ScaleType.FIT_XY);

                                Layout4_2_1_1.setOrientation(LinearLayout.VERTICAL);
                                Layout4_2_1_1.setFocusableInTouchMode(true);

                                TV11_1.setText(voyage_description.get(j));
                                TV11_1.setTextSize(14);
                                TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                TV11_2.setText(voyage_nickname.get(j) + "\n" + voyage_view_count.get(j) + " views");
                                TV11_2.setTextSize(10);
                                TV11_2.setTextColor(Color.rgb(255, 255, 255));
                            } catch (Exception e) {
                                Layout4_2_1_1_1.setBackgroundColor(Color.rgb(100, 100, 100));
                            }

                            Layout4_2_1_1.addView(Layout4_2_1_1_1);
                            Layout4_2_1_1_1.addView(IV11);
                            Layout4_2_1_1.addView(Layout4_2_1_1_2);
                            Layout4_2_1_1_2.setLayoutParams(params3);
                            Layout4_2_1_1_2.setOrientation(LinearLayout.VERTICAL);
                            Layout4_2_1_1_2.addView(Layout4_2_1_1_2_1);
                            Layout4_2_1_1_2.setGravity(Gravity.CENTER);
                            Layout4_2_1_1_2_1.addView(TV11_1);
                            TV11_1.setPadding(30, 0, 60, 0);
                            Layout4_2_1_1_2_1.setLayoutParams(paramsTitleTV);
                            Layout4_2_1_1_2.addView(Layout4_2_1_1_2_2);
                            Layout4_2_1_1_2_2.setOrientation(LinearLayout.HORIZONTAL);
                            Layout4_2_1_1_2_2.addView(Layout4_2_1_1_2_2_1);
                            Layout4_2_1_1_2_2.setPadding(0, 0, 0, 10);
                            Layout4_2_1_1_2_2_1.setPadding(25, 0, 0, 0);
                            Layout4_2_1_1_2_2_1.addView(CIV11);
                            Layout4_2_1_1_2_2_2.setLayoutParams(params3);
                            Layout4_2_1_1_2_2_2.setOrientation(LinearLayout.VERTICAL);
                            Layout4_2_1_1_2_2.addView(Layout4_2_1_1_2_2_2);
                            Layout4_2_1_1_2_2_2.setGravity(Gravity.CENTER | Gravity.CENTER);
                            Layout4_2_1_1_2_2_2.addView(TV11_2);

                            Layout4_2_1_1_2_2_1.setLayoutParams(paramsCIV);
                            Layout4_2_1_1_2_2_1.setGravity(Gravity.CENTER);

                            Layout4_2_1_1.setLayoutParams(paramsMainLayout);
                            Layout4_2_1_1.setFocusableInTouchMode(true);

                            Layout4_2_1.addView(Layout4_2_1_1);
                            Layout4_2.addView(Layout4_2_1);

                            Layout4_2_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                @Override
                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                    if (hasFocus == false) {
                                        Layout4_2_1_1.setBackground(null);
                                        TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                        TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                if (hasFocus) {
                                                    Home.setImageResource(R.drawable.home);
//                                Search.setImageResource(R.drawable.searchselect);
                                                    Intent intent = new Intent(VoyageActivity.this, HomeActivity.class);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                    startActivity(intent);
                                                    voyageapiload = 0;
//                finish();
                                                } else {
                                                    Home.setImageResource(R.drawable.home);
                                                }
                                            }
                                        });
                                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                if (hasFocus) {
                                                    Home.setImageResource(R.drawable.home);
//                                User.setImageResource(R.drawable.userselect);
                                                    Intent intent = new Intent(VoyageActivity.this, SubscribeActivity.class);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                    startActivity(intent);
//                finish();
                                                } else {
                                                    User.setImageResource(R.drawable.user);
                                                }
                                            }
                                        });

                                        Layout4_2_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                if (hasFocus) {
                                                    Layout4_2_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                                    TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                                    TV11_2.setTextColor(Color.rgb(0, 0, 0));
                                                } else {
                                                    Layout4_2_1_1.setBackground(null);
                                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                                    TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                                }
                                            }
                                        });

                                    } else {
                                        Layout4_2_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                        TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                        TV11_2.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                                    }
                                }
                            });

                            edittext.setImeOptions(EditorInfo.IME_ACTION_SEARCH);

                            edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                                @Override
                                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                                    switch (actionId) {
                                        case EditorInfo.IME_ACTION_SEARCH:
                                            keyword = edittext.getText().toString();
                                            category_num = 0;
                                            Intent intent = new Intent(VoyageActivity.this, VoyageResultActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                            startActivity(intent);
                                            break;
                                        case EditorInfo.IME_ACTION_GO:
                                            keyword = edittext.getText().toString();
                                            category_num = 0;
                                            Intent intent2 = new Intent(VoyageActivity.this, VoyageResultActivity.class);
                                            intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                            startActivity(intent2);
                                            break;
                                        case EditorInfo.IME_ACTION_NEXT:
                                            keyword = edittext.getText().toString();
                                            category_num = 0;
                                            Intent intent3 = new Intent(VoyageActivity.this, VoyageResultActivity.class);
                                            intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                            startActivity(intent3);
                                            break;
                                        default:
                                            keyword = edittext.getText().toString();
                                            category_num = 0;
                                            Intent intent4 = new Intent(VoyageActivity.this, VoyageResultActivity.class);
                                            intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                            startActivity(intent4);
                                            return false;
                                    }
                                    return true;
                                }
                            });

                            if (i == 0 && ii == 0) {
                                Layout4_2_1_1.setId(R.id.LayoutAll);
//                    Layout4_2_1_1.requestFocus();
//                                TV0.setNextFocusRightId(R.id.LayoutAll);
                                Layout4_2_1_1.setNextFocusLeftId(R.id.all1);
                            }

                            if (ii == 0) {
                                Layout4_2_1_1.setId(R.id.LayoutAll);
                                Layout4_2_1_1.setNextFocusLeftId(R.id.all1);
                            }

                            // 만약 나머지가 없고 마지막 생성줄인 경우
//                            if (i == jj - 2 && y == 0) {
//                                Layout4_2_1_1.setId(R.id.LayoutAll);
//                                Layout4_2_1_1.setNextFocusDownId(R.id.LayoutAll);
//                            }

                            final int jjj = j;
                            Layout4_2_1_1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(VoyageActivity.this, AliseonOTTPlayerActivity.class);
                                    intent.putExtra("index", jjj);
                                    intent.putExtra("category", 3);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                }
                            });

                            j++;
                        }

                    }

                }
            }

            Search.requestFocus();
//            TV0.setTextColor(Color.rgb(255, 255, 255));
            Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                @Override
                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                    if (hasFocus == false) {
                        Search.setImageResource(R.drawable.search);
                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(VoyageActivity.this, HomeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    voyageapiload = 0;
                                    voyagecategoryapiload = 0;
                                    category_num = 0;
//                finish();
                                } else {
                                    Home.setImageResource(R.drawable.home);
                                }
                            }
                        });
                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(VoyageActivity.this, SubscribeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                } else {
                                    User.setImageResource(R.drawable.user);
                                }
                            }
                        });

                        edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    edittext.setHint(null);
                                } else {
                                    edittext.setHint("Search");
                                }
                            }
                        });

                    } else {
//                            Search.setImageResource(R.drawable.searchselect);
                        TV0.setTextColor(Color.rgb(255, 255, 255));
                        Layout3_0.setBackground(null);
                    }
                }
            });

//            Layout5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                    if (hasFocus == false) {
//
//                    } else {
//
//                        if (prf.getString("userinfo_name", "").equals("empty")
//                                && prf.getString("userinfo_picture", "").equals("empty")
//                                && prf.getInt("user_id", 0) == 0) {
//                            // 비회원
//                            searchactivityallloadinghandler.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    progressbar.setVisibility(View.VISIBLE);
//                                    searchpopularallstart = searchpopularallstart + 12;
//
//                                    category_num = 0;
//                                    NetworkTaskTvottSearchPopular networktasktvottsearchpopular = new NetworkTaskTvottSearchPopular(url20, null);
//                                    networktasktvottsearchpopular.execute();
//                                }
//                            });
//
//                        } else {
//                            // 회원
//                            searchactivityallloadinghandler.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    progressbar.setVisibility(View.VISIBLE);
//                                    searchfeedallstart = searchfeedallstart + 12;
//
//                                    category_num = 0;
//                                    NetworkTaskTvottSearchFeed networktasktvottsearchfeed = new NetworkTaskTvottSearchFeed(url14, null);
//                                    networktasktvottsearchfeed.execute();
//                                }
//                            });
//                        }
//                    }
//                }
//            });
//
//            Layout5.addView(progressbar);
//            Layout4.addView(Layout5);

            scroller2.addView(Layout4);
            Layout1.addView(scroller2);

            setContentView(Layout1);

            for (int i = 0; i < cate_name.size(); i++) {

                Layout3_0 = new LinearLayout(this);
                Layout3_0.setLayoutParams(params3_1);
                TV0 = new TextView(this);
                int ll_set_id = View.generateViewId();
                int tv_set_id = View.generateViewId();
                Layout3_0.setId(ll_set_id);
                TV0.setId(tv_set_id);
                TV0.setFocusableInTouchMode(true);
                TV0.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
                TV0.setText(cate_name.get(i));
                TV0.setTextSize(14);
                TV0.setTextColor(Color.rgb(255, 255, 255));
                TV0.setPadding(40, 25, 0, 25);
                Layout3_0.addView(TV0);
                ViewGroup.MarginLayoutParams margin3_0 = new ViewGroup.MarginLayoutParams(TV0.getLayoutParams());
//                margin3_0.setMargins(30, 17, 0, 0);
                Layout3.addView(Layout3_0);

                final int ii = i;

                int tv_get_id = TV0.getId();
                int ll_get_id = Layout3_0.getId();
                TextView TV1 = (TextView) findViewById(tv_get_id);
                LinearLayout Layout3_1 = (LinearLayout) findViewById(ll_get_id);
                final TextView TV2 = TV1;
                final LinearLayout Layout3_2 = Layout3_1;

                TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때

                        if (hasFocus) {

                            Log.d("if 현재 id : ", "" + ii);
                            Log.d("if Voyage_id : ", "" + voyage_id);
                            TV2.setTextColor(Color.rgb(66, 66, 66));
                            Layout3_2.setBackgroundColor(Color.rgb(255, 255, 255));

                            Log.d("focus searchapiload : ", "" + voyageapiload);
                            Log.d("focus focusapiload : ", "" + voyagefocusapiload);
                            Log.d("focus iii : ", "" + iii);
                            Log.d("focus ii : ", "" + ii);

                            if (iii != ii && voyageapiload == 0 && voyagefocusapiload == 0) {

                                voyage_id.clear();
                                voyage_user_id.clear();
                                voyage_product_id.clear();
                                voyage_contents_id.clear();
                                voyage_contents_type.clear();
                                voyage_category_id.clear();
                                voyage_status.clear();
                                voyage_description.clear();
                                voyage_create_at.clear();
                                voyage_update_at.clear();
                                voyage_like_count.clear();
                                voyage_view_count.clear();
                                voyage_comment_count.clear();
                                voyage_category_en.clear();
                                voyage_category_kr.clear();
                                voyage_nickname.clear();
                                voyage_photo.clear();
                                voyage_p_thumbnail.clear();

                                searchactivityvoyagehandler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        category_num = ii;
                                        voyagefocusapiload = 1;
                                        NetworkTaskTvottSearchVoyage networktasktvottsearchvoyage = new NetworkTaskTvottSearchVoyage(api_voyage, null);
                                        networktasktvottsearchvoyage.execute();

                                    }
                                });
                            } else if (iii == 0 && ii == 1 && voyageapiload == 0 && voyagefocusapiload == 0) {

                                voyage_id.clear();
                                voyage_user_id.clear();
                                voyage_product_id.clear();
                                voyage_contents_id.clear();
                                voyage_contents_type.clear();
                                voyage_category_id.clear();
                                voyage_status.clear();
                                voyage_description.clear();
                                voyage_create_at.clear();
                                voyage_update_at.clear();
                                voyage_like_count.clear();
                                voyage_view_count.clear();
                                voyage_comment_count.clear();
                                voyage_category_en.clear();
                                voyage_category_kr.clear();
                                voyage_nickname.clear();
                                voyage_photo.clear();
                                voyage_p_thumbnail.clear();

                                searchactivityvoyagehandler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        category_num = ii;
                                        voyagefocusapiload = 1;
                                        NetworkTaskTvottSearchVoyage networktasktvottsearchvoyage = new NetworkTaskTvottSearchVoyage(api_voyage, null);
                                        networktasktvottsearchvoyage.execute();

                                    }
                                });
                            } else {



                            }

                        } else {
                            iii = ii;
                            Log.d("else 현재 id : ", "" + ii);
                            TV2.setTextColor(Color.rgb(255, 255, 255));
                            Layout3_2.setBackground(null);

//                            Log.d("un searchapiload : ", "" + searchapiload);
//                            Log.d("un focusapiload : ", "" + searchcfocusapiload);
//                            Log.d("un iii : ", "" + iii);
//                            Log.d("un ii : ", "" + ii);

                            Log.d("else Voyage_id : ", "" + voyage_id);

                            voyageapiload = 0;

                        }
                    }
                });

                if (i == category_num) {
                    TV0.requestFocus();
                }

            }

            Home.setNextFocusRightId(R.id.all1);
            Search.setNextFocusRightId(R.id.all1);
            User.setNextFocusRightId(R.id.all1);
            Home.setNextFocusUpId(R.id.alluser);
            User.setNextFocusDownId(R.id.allhome);
            TV0.setNextFocusLeftId(R.id.allsearch);
//            TV1.setNextFocusLeftId(R.id.allsearch);
//            TV2.setNextFocusLeftId(R.id.allsearch);
//            TV3.setNextFocusLeftId(R.id.allsearch);
//            TV4.setNextFocusLeftId(R.id.allsearch);
//            TV5.setNextFocusLeftId(R.id.allsearch);
//            TV6.setNextFocusLeftId(R.id.allsearch);
//            TV7.setNextFocusLeftId(R.id.allsearch);
//            TV8.setNextFocusLeftId(R.id.allsearch);
//            TV9.setNextFocusLeftId(R.id.allsearch);
//            TV10.setNextFocusLeftId(R.id.allsearch);
//            TV11.setNextFocusLeftId(R.id.allsearch);
//            TV12.setNextFocusLeftId(R.id.allsearch);
//            TV13.setNextFocusLeftId(R.id.allsearch);
//            TV14.setNextFocusLeftId(R.id.allsearch);
//            TV15.setNextFocusLeftId(R.id.allsearch);
//            TV0.setNextFocusUpId(R.id.all16);
//            TV15.setNextFocusDownId(R.id.all1);
            edittext.setNextFocusLeftId(R.id.all1);
            edittext.setNextFocusUpId(R.id.editAll);
            edittext.setNextFocusRightId(R.id.editAll);

//            if (searchfocus == 0) {
//                Search.requestFocus();
//            } else if (searchfocus == 1) {
//                TV0.requestFocus();
//            }

        }

    }

    public class SearchActivityVoyageHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 10000) {

                onResume();

                voyagefocusapiload = 0;

            }
            else if (msg.what == 0) {

                onResume();

            } else if (msg.what == 100){

                onResume();

                voyagefocusapiload = 0;

            } else if (msg.what == category_num * 100){

                onResume();

                voyagefocusapiload = 0;

            }
        }
    }

}
