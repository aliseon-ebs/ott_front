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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import com.aliseon.ott.API.Popular;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class HomeDetailActivity extends AppCompatActivity {

    private AliseonAPI AliseonAPI;

    private static String TAG = "현재 url 가져오기";

    public static HomeActivityDetailContentsLoadingHandler homeactivitydetailcontentsloadinghandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        int popularstart = aliseon.aliseon_getPopularStart();
        int popularlimit = aliseon.aliseon_getPopularLimit();

        SharedPreferences prf = getSharedPreferences("login_session",MODE_PRIVATE);

        switch (prf.getString("language","")){
            case "kr" :
                Locale lang1 = Locale.KOREAN;
                Configuration config1 = new Configuration();
                config1.locale = lang1;
                getResources().updateConfiguration(config1,getResources().getDisplayMetrics());
                break;
            case "en" :
                Locale lang2 = Locale.ENGLISH;
                Configuration config2 = new Configuration();
                config2.locale = lang2;
                getResources().updateConfiguration(config2,getResources().getDisplayMetrics());
            case "ar" :
                Locale lang3 = Locale.ENGLISH;
                Configuration config3 = new Configuration();
                config3.locale = lang3;
                getResources().updateConfiguration(config3,getResources().getDisplayMetrics());

        }

        homeactivitydetailcontentsloadinghandler = new HomeActivityDetailContentsLoadingHandler();

        LinearLayout Layout1 = new LinearLayout(this);
        LinearLayout Layout2 = new LinearLayout (this);
        LinearLayout Layout2_1 = new LinearLayout(this);
        LinearLayout Layout2_2 = new LinearLayout(this);

        LinearLayout Layout3 = new LinearLayout(this);
        LinearLayout Layout3_1 = new LinearLayout(this);
        LinearLayout Layout3_1_1 = new LinearLayout(this);
        LinearLayout Layout3_1_2 = new LinearLayout(this);
        LinearLayout Layout3_2 = new LinearLayout(this);

        ScrollView scrollview = new ScrollView(this);

        Layout1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        Layout1.setLayoutParams(params);
        LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
        LinearLayout.LayoutParams paramsTopButton= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(1824, 100);
        LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,420);
        LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
        LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
        LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);
        paramsTitleTV.bottomMargin = 10;
        paramsMainLayout.rightMargin = 10;
        paramsMainLayout.leftMargin = 10;
        paramsMainLayout.bottomMargin = 20;

        ImageView BackArrow = new ImageView(this);
        BackArrow.setFocusableInTouchMode(true);
        BackArrow.setPadding(10, 10, 10, 10);
        BackArrow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));

        Button button = new Button(this);
        button.setBackground(ContextCompat.getDrawable(this,R.drawable.blackbuttonsetting));
        button.setLayoutParams(new ViewGroup.LayoutParams(90,65));
        button.setTextColor(Color.rgb(255,255,255));
        button.setTextSize(10);
        button.setText("TOP");

        BackArrow.setImageResource(R.drawable.backarrow);
        BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60,60));
        BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);

        // for Loading
        ImageView CategoryIV1 = new ImageView(this);
        CategoryIV1.setImageResource(R.drawable.noing_category);
        CategoryIV1.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
        CategoryIV1.setScaleType(ImageView.ScaleType.FIT_START);

//        BackArrowText.setTextSize(20);
//        BackArrowText.setTextColor(Color.rgb(255, 255, 255));
//        BackArrowText.setText(getResources().getString(R.string.popularvideos));
//        BackArrowText.setPadding(10,0,0,10);

        scrollview.setLayoutParams(params);
        scrollview.setVerticalScrollBarEnabled(true);

        Layout2.setOrientation(LinearLayout.VERTICAL);
        Layout2.setGravity(Gravity.CENTER);
        Layout2.setLayoutParams(params2);
        Layout2.setBackgroundColor(Color.rgb(34, 34, 34));

        Layout3.setOrientation(LinearLayout.VERTICAL);
        Layout3_1.setOrientation(LinearLayout.HORIZONTAL);

        Layout2.setLayoutParams(params2);
        Layout2.setGravity(Gravity.CENTER);
        Layout2_1.setLayoutParams(paramsBackArrow);
        Layout2_1.setGravity(Gravity.CENTER);
        Layout2_1.addView(BackArrow);
        Layout2_2.setLayoutParams(paramsTopButton);
        Layout2_2.setGravity(Gravity.CENTER);
        Layout2_2.addView(button);


        Layout3.setLayoutParams(params3);

        Layout3_1.setLayoutParams(params3_1);
        Layout3_1_1.setLayoutParams(paramsBackArrow);
        Layout3_1_1.setGravity(Gravity.CENTER);
        Layout3_1_2.setLayoutParams(params3);
        Layout3_1_2.setGravity(Gravity.CENTER | Gravity.LEFT);

        Layout3_2.setLayoutParams(params3);
        Layout3_2.setOrientation(LinearLayout.VERTICAL);

        Layout1.addView(Layout2);

        Layout2.addView(Layout2_1);
        Layout2.addView(Layout2_2);

        Layout3.addView(Layout3_1);
        Layout3_1.addView(Layout3_1_1);

        Layout3_1.addView(Layout3_1_2);

        Layout3_1_2.addView(CategoryIV1);

        Layout1.addView(Layout3);

        // for Loading
        for (int i = 0; i < 3; i++) {
            LinearLayout Layout3_6 = new LinearLayout(this);
            Layout3_6.setLayoutParams(params3_3);
            Layout3_6.setGravity(Gravity.CENTER | Gravity.LEFT);
            Layout3_2.addView(Layout3_6);
            params3_3.bottomMargin = 20;

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

        scrollview.addView(Layout3_2);

        Layout3.addView(scrollview);

        setContentView(Layout1);

        BackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollview.smoothScrollTo(0,0);
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
                overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }

    @Override
    public void onResume() {
        super.onResume();

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        int homeapiload = aliseon.aliseon_getHomeAPIload();
        String imageurl = aliseon.aliseon_getImageURL();

        ArrayList<ArrayList<String>> popular_p_thumbnail = aliseon.aliseon_getPopular_p_thumbnail();
        ArrayList<String> popular_photo = aliseon.aliseon_getPopular_photo();
        ArrayList<String> popular_description = aliseon.aliseon_getPopular_description();
        ArrayList<String> popular_nickname = aliseon.aliseon_getPopular_nickname();
        ArrayList<Integer> popular_view_count = aliseon.aliseon_getPopular_view_count();

        int homepopularstart = aliseon.aliseon_getPopularStart();
        int homepopularlimit = aliseon.aliseon_getPopularLimit();


        SharedPreferences prf = getSharedPreferences("login_session",MODE_PRIVATE);

        switch (prf.getString("language","")){
            case "kr" :
                Locale lang1 = Locale.KOREAN;
                Configuration config1 = new Configuration();
                config1.locale = lang1;
                getResources().updateConfiguration(config1,getResources().getDisplayMetrics());
                break;
            case "en" :
                Locale lang2 = Locale.ENGLISH;
                Configuration config2 = new Configuration();
                config2.locale = lang2;
                getResources().updateConfiguration(config2,getResources().getDisplayMetrics());
            case "ar" :
                Locale lang3 = Locale.ENGLISH;
                Configuration config3 = new Configuration();
                config3.locale = lang3;
                getResources().updateConfiguration(config3,getResources().getDisplayMetrics());

        }

        LinearLayout Layout1 = new LinearLayout(this);
        LinearLayout Layout2 = new LinearLayout (this);
        LinearLayout Layout2_1 = new LinearLayout(this);
        LinearLayout Layout2_2 = new LinearLayout(this);

        LinearLayout Layout3 = new LinearLayout(this);
        LinearLayout Layout3_1 = new LinearLayout(this);
        LinearLayout Layout3_1_1 = new LinearLayout(this);
        LinearLayout Layout3_1_2 = new LinearLayout(this);
        LinearLayout Layout3_2 = new LinearLayout(this);
        LinearLayout Layout3_3 = new LinearLayout(this);

        ScrollView scrollview = new ScrollView(this);

        Layout1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        Layout1.setLayoutParams(params);
        LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
        LinearLayout.LayoutParams paramsTopButton= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
        LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150);
        LinearLayout.LayoutParams params3_6 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,456);
        LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
        LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
        LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);
        paramsTitleTV.bottomMargin = 10;
        paramsMainLayout.leftMargin = 10;
        paramsMainLayout.rightMargin = 10;
        paramsMainLayout.bottomMargin = 15;

        ImageView BackArrow = new ImageView(this);
        BackArrow.setFocusableInTouchMode(true);
        BackArrow.setPadding(10, 10, 10, 10);
        BackArrow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));

        TextView BackArrowText = new TextView(this);

        Button button = new Button(this);
        button.setBackground(ContextCompat.getDrawable(this,R.drawable.blackbuttonsetting));
        button.setLayoutParams(new ViewGroup.LayoutParams(90,65));
        button.setTextColor(Color.rgb(255,255,255));
        button.setTextSize(10);
        button.setText("TOP");

        button.setId(R.id.top);
        button.setNextFocusDownId(R.id.top);

        BackArrow.setImageResource(R.drawable.backarrow);
        BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60,60));
        BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);

        BackArrowText.setTextSize(20);
        BackArrowText.setTextColor(Color.rgb(255, 255, 255));
        BackArrowText.setText(getResources().getString(R.string.popularvideos));
        BackArrowText.setPadding(10,0,0,10);
        BackArrow.setId(R.id.viewback);

        scrollview.setLayoutParams(params);
        scrollview.setVerticalScrollBarEnabled(true);

        ProgressBar progressbar = new ProgressBar(this);
        progressbar.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
        progressbar.setVisibility(View.GONE);

        Layout2.setOrientation(LinearLayout.VERTICAL);
        Layout2.setGravity(Gravity.CENTER);
        Layout2.setLayoutParams(params2);
        Layout2.setBackgroundColor(Color.rgb(34, 34, 34));

        Layout3.setOrientation(LinearLayout.VERTICAL);
        Layout3_1.setOrientation(LinearLayout.HORIZONTAL);


        Layout2.setLayoutParams(params2);
        Layout2.setGravity(Gravity.CENTER);
        Layout2_1.setLayoutParams(paramsBackArrow);
        Layout2_1.setGravity(Gravity.CENTER);
        Layout2_1.addView(BackArrow);
        Layout2_2.setLayoutParams(paramsTopButton);
        Layout2_2.setGravity(Gravity.CENTER);
        Layout2_2.addView(button);


        Layout3.setLayoutParams(params3);

        Layout3_1.setLayoutParams(params3_1);
        Layout3_1_1.setLayoutParams(paramsBackArrow);
        Layout3_1_1.setGravity(Gravity.CENTER);
        Layout3_1_2.setLayoutParams(params3);
        Layout3_1_2.setGravity(Gravity.CENTER | Gravity.LEFT);

        Layout3_2.setLayoutParams(params3);
        Layout3_2.setOrientation(LinearLayout.VERTICAL);

        Layout3_3.setLayoutParams(params3_3);
        Layout3_3.setOrientation(LinearLayout.VERTICAL);
        Layout3_3.setGravity(Gravity.CENTER);
        Layout3_3.setFocusableInTouchMode(true);

        Layout1.addView(Layout2);

        Layout2.addView(Layout2_1);
        Layout2.addView(Layout2_2);

        Layout3.addView(Layout3_1);
        Layout3_1.addView(Layout3_1_1);
        Layout3_1.addView(Layout3_1_2);

        Layout3_1_2.addView(BackArrowText);

        Layout3_3.addView(progressbar);

        Layout1.addView(Layout3);

        // home에서는 0 ~ 11까지만 표시하기에 오류 수정
        int jj = (popular_p_thumbnail.size() - 11) / 4 + 1;
        int y = (popular_p_thumbnail.size() - 11) % 4;
        int j = 11; // 11번째부터 시작
        for(int i = 0; i < jj; i++) {
            LinearLayout Layout3_6 = new LinearLayout(this);
            Layout3_6.setLayoutParams(params3_6);
            Layout3_6.setGravity(Gravity.CENTER | Gravity.LEFT);
            Layout3_2.addView(Layout3_6);
            params3_6.bottomMargin = 20;

            if (i == jj - 1) {
                    if (y == 0) {
                        Layout3_2.removeView(Layout3_6);
                    }
                for (int ii = 0; ii < y; ii++) {
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
                    Glide.with(this).load(imageurl + popular_p_thumbnail.get(j)).into(IV11);
                    Glide.with(this).load(imageurl + popular_photo.get(j)).into(CIV11);

                    IV11.setScaleType(ImageView.ScaleType.FIT_XY);
                    TextView TV11 = new TextView(this);
                    TextView TV11_1 = new TextView(this);

                    Layout3_6_1_1.setOrientation(LinearLayout.VERTICAL);
                    Layout3_6_1_1.setFocusableInTouchMode(true);

                    TV11.setText(popular_description.get(j));
                    TV11.setTextSize(14);
                    TV11.setTextColor(Color.rgb(255, 255, 255));
                    TV11_1.setText(popular_nickname.get(j) + "\n" + popular_view_count.get(j) + " views");
                    TV11_1.setTextSize(10);
                    TV11_1.setTextColor(Color.rgb(255, 255, 255));

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

                    Layout3_6_1_1.setNextFocusDownId(R.id.viewback);

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

                            }
                        }
                    });


                    final int jjj = j;
                    Layout3_6_1_1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            Intent intent = new Intent(HomeDetailActivity.this, AliseonOTTPlayerActivity.class);
//                            intent.putExtra("index", jjj);
//                            intent.putExtra("category",2);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                            startActivity(intent);
                        }
                    });
                    j++;

                    if(i == 0 && ii == 0){
                        Layout3_6_1_1.setId(R.id.homedetaillayout);
//                        Layout3_6_1_1.requestFocus();
                    }

                    if (ii == 0) {
                        Layout3_6_1_1.setNextFocusLeftId(R.id.viewback);
                    }
                }

            } else {
                for (int ii = 0; ii < 4; ii++) {
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
                    Glide.with(this).load(imageurl + popular_p_thumbnail.get(j).get(0)).into(IV11);
                    Glide.with(this).load(imageurl + popular_photo.get(j)).into(CIV11);

                    IV11.setScaleType(ImageView.ScaleType.FIT_XY);
                    TextView TV11 = new TextView(this);
                    TextView TV11_1 = new TextView(this);

                    Layout3_6_1_1.setOrientation(LinearLayout.VERTICAL);
                    Layout3_6_1_1.setFocusableInTouchMode(true);

                    TV11.setText(popular_description.get(j));
                    TV11.setTextSize(14);
                    TV11.setTextColor(Color.rgb(255, 255, 255));
                    TV11_1.setText(popular_nickname.get(j) + "\n" + popular_view_count.get(j) + " views");
                    TV11_1.setTextSize(10);
                    TV11_1.setTextColor(Color.rgb(255, 255, 255));

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
//                            Intent intent = new Intent(HomeDetailActivity.this, AliseonOTTPlayerActivity.class);
//                            intent.putExtra("index", jjj);
//                            intent.putExtra("category",2);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                            startActivity(intent);
                        }
                    });
                    j++;

                    if(i == 0 && ii == 0){
                        Layout3_6_1_1.setId(R.id.homedetaillayout);
//                        Layout3_6_1_1.requestFocus();
                    }

                    if (ii == 0) {
                        Layout3_6_1_1.setNextFocusLeftId(R.id.viewback);
                    }

                    // 만약 나머지가 없고 마지막 생성줄인 경우
                    if (i == jj - 2 && y == 0) {
                        Layout3_6_1_1.setId(R.id.LayoutHome);
//                        Layout3_6_1_1.setNextFocusDownId(R.id.LayoutHome);
                    }
                }
            }
        }

        Layout3_3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

            @Override
            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                if (hasFocus == false) {

                } else {

                    homeactivitydetailcontentsloadinghandler.post(new Runnable() {
                        @Override
                        public void run() {

                            Aliseon aliseon = (Aliseon) getApplicationContext();

                            int popularstart = aliseon.aliseon_getPopularStart();
                            int popularlimit = aliseon.aliseon_getPopularLimit();

                            progressbar.setVisibility(View.VISIBLE);

                            if(popularstart == 0){
                                popularstart = popularstart + 23;
                            } else {
                                popularstart = popularstart + 12;
                            }
                            popularlimit = 12;

                            PopularPost();
                        }
                    });

                }
            }
        });

        scrollview.addView(Layout3_2);
        Layout3_2.addView(Layout3_3);

        Layout3.addView(scrollview);

        setContentView(Layout1);

        BackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollview.smoothScrollTo(0,0);
                LinearLayout Layout3_6_1_1 = (LinearLayout)findViewById(R.id.homedetaillayout);
                Layout3_6_1_1.requestFocus();
            }
        });

    }

    public class HomeActivityDetailContentsLoadingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {
                onResume();
            }
        }
    }

    private void PopularPost(){

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        int popularstart = aliseon.aliseon_getPopularStart();
        int popularlimit = aliseon.aliseon_getPopularLimit();

        Call<Popular> call = AliseonAPI.PopularPost(access_token, "0", 0 , popularstart, popularlimit);

        call.enqueue(new Callback<Popular>() {
            @Override
            public void onResponse(Call<Popular> call, Response<Popular> response) {

                int homeapiload = aliseon.aliseon_getHomeAPIload();

                Popular postResponse = (Popular) response.body();
                Log.d("STATUS:", "COMPLETE");
                Log.d("Code : ", "" + response.code());
                Log.d("Status : ", "" + postResponse.getStatus());

                ArrayList<String> popular_id = aliseon.aliseon_getPopular_id();
                ArrayList<String> popular_user_id = aliseon.aliseon_getPopular_user_id();
                ArrayList<String> popular_product_id = aliseon.aliseon_getPopular_product_id();
                ArrayList<String> popular_contents_id = aliseon.aliseon_getPopular_contents_id();
                ArrayList<String> popular_contents_type = aliseon.aliseon_getPopular_contents_type();
                ArrayList<String> popular_category_id = aliseon.aliseon_getPopular_category_id();
                ArrayList<Integer> popular_status = aliseon.aliseon_getPopular_status();
                ArrayList<String> popular_description = aliseon.aliseon_getPopular_description();
                ArrayList<String> popular_create_at = aliseon.aliseon_getPopular_create_at();
                ArrayList<String> popular_update_at = aliseon.aliseon_getPopular_update_at();
                ArrayList<Integer> popular_like_count = aliseon.aliseon_getPopular_like_count();
                ArrayList<Integer> popular_view_count = aliseon.aliseon_getPopular_view_count();
                ArrayList<Integer> popular_comment_count = aliseon.aliseon_getPopular_comment_count();
                ArrayList<String> popular_category_en = aliseon.aliseon_getPopular_category_en();
                ArrayList<String> popular_category_kr = aliseon.aliseon_getPopular_category_kr();
                ArrayList<String> popular_nickname = aliseon.aliseon_getPopular_nickname();
                ArrayList<String> popular_photo = aliseon.aliseon_getPopular_photo();
                ArrayList<ArrayList<String>> popular_p_thumbnail = aliseon.aliseon_getPopular_p_thumbnail();
                ArrayList<String> popular_c_thumbnail = new ArrayList<>();

                for(int i = 0; i < postResponse.popular_list.size(); i++) {

                    popular_id.add(postResponse.popular_list.get(i).getId());
                    popular_user_id.add(postResponse.popular_list.get(i).getUserId());
                    popular_product_id.add(postResponse.popular_list.get(i).getProductId());
                    popular_contents_id.add(postResponse.popular_list.get(i).getContentsId());
                    popular_contents_type.add(postResponse.popular_list.get(i).getContentsType());
                    popular_category_id.add(postResponse.popular_list.get(i).getCategoryId());
                    popular_status.add(postResponse.popular_list.get(i).getStatus());
                    popular_description.add(postResponse.popular_list.get(i).getDescription());
                    popular_create_at.add(postResponse.popular_list.get(i).getCreateAt());
                    popular_update_at.add(postResponse.popular_list.get(i).getUpdateAt());
                    popular_like_count.add(postResponse.popular_list.get(i).getLikeCount());
                    popular_view_count.add(postResponse.popular_list.get(i).getViewCount());
                    popular_comment_count.add(postResponse.popular_list.get(i).getCommentCount());
                    popular_category_en.add(postResponse.popular_list.get(i).getCategoryEn());
                    popular_category_kr.add(postResponse.popular_list.get(i).getCategoryKo());
                    popular_nickname.add(postResponse.popular_list.get(i).getNickname());
                    popular_photo.add(postResponse.popular_list.get(i).getPhoto());
                    popular_p_thumbnail.add(postResponse.popular_list.get(i).getThumbnail());

                }

                aliseon.aliseon_setPopular_id(popular_id);
                aliseon.aliseon_setPopular_user_id(popular_user_id);
                aliseon.aliseon_setPopular_product_id(popular_product_id);
                aliseon.aliseon_setPopular_contents_id(popular_contents_id);
                aliseon.aliseon_setPopular_contents_type(popular_contents_type);
                aliseon.aliseon_setPopular_category_id(popular_category_id);
                aliseon.aliseon_setPopular_status(popular_status);
                aliseon.aliseon_setPopular_description(popular_description);
                aliseon.aliseon_setPopular_create_at(popular_create_at);
                aliseon.aliseon_setPopular_update_at(popular_update_at);
                aliseon.aliseon_setPopular_like_count(popular_like_count);
                aliseon.aliseon_setPopular_view_count(popular_view_count);
                aliseon.aliseon_setPopular_comment_count(popular_comment_count);
                aliseon.aliseon_setPopular_category_en(popular_category_en);
                aliseon.aliseon_setPopular_category_kr(popular_category_kr);
                aliseon.aliseon_setPopular_nickname(popular_nickname);
                aliseon.aliseon_setPopular_photo(popular_photo);
                aliseon.aliseon_setPopular_p_thumbnail(popular_p_thumbnail);


                if (homeapiload == 0) {

                    aliseon.aliseon_setHomeAPIload(1);
//                    homeactivitypopularhandler.sendEmptyMessage(1000);

                } else if (homeapiload == 1) {

                    aliseon.aliseon_setHomeAPIload(1);
//                    homeactivitypopularhandler.sendEmptyMessage(1000);
                    homeactivitydetailcontentsloadinghandler.sendEmptyMessage(1000);

                }

            }

            @Override
            public void onFailure(Call<Popular> call, Throwable t) {
                Log.d("STATUS:", "FAILED");
                Log.d("STATUS:", t.getMessage());

//                LoadingmHandler.sendEmptyMessage(800);

            }

        });

    }

    private void AtrendDetailPost() {

    }

    private void PopularDetailPost() {

    }

    private void VoyageDetailPost() {

    }

}
