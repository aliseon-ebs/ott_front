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
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import com.aliseon.ott.API.RecommendCreator;
import com.aliseon.ott.API.VoyageResult;
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


public class VoyageResultActivity extends AppCompatActivity {

    private static String TAG = "카테고리 크기";

    private AliseonAPI AliseonAPI;

    TextView TV0;

    public static VoyageResultHandler voyageresulthandler;
    public static VoyageResultLoadingHandler voyageresultloadinghandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_all);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();

        int voyageresultstart = aliseon.aliseon_getVoyageresultstart();

        String keyword = aliseon.aliseon_getKeyword();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        voyageresultstart = 0;

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

        voyageresulthandler = new VoyageResultHandler();
        voyageresultloadinghandler = new VoyageResultLoadingHandler();

        voyageresulthandler.post(new Runnable() {
            @Override
            public void run() {
                aliseon.aliseon_setCategory_num(0);

                RecommendCreatorPost();
            }
        });

        LinearLayout Layout1 = new LinearLayout(this);
        LinearLayout Layout2 = new LinearLayout(this);
        LinearLayout Layout2_1 = new LinearLayout(this);
        LinearLayout Layout2_2 = new LinearLayout(this);

        LinearLayout Layout3 = new LinearLayout(this);
        LinearLayout Layout3_1 = new LinearLayout(this);
        LinearLayout Layout3_1_1 = new LinearLayout(this);
        LinearLayout Layout3_1_2 = new LinearLayout(this);
        LinearLayout Layout3_2 = new LinearLayout(this);
        LinearLayout Layout3_3 = new LinearLayout(this);
        LinearLayout Layout3_4 = new LinearLayout(this);
        LinearLayout Layout3_5 = new LinearLayout(this);
        LinearLayout Layout3_6 = new LinearLayout(this);

        ScrollView scroller = new ScrollView(this);

        Layout1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        Layout1.setLayoutParams(params);

        ImageView BackArrow = new ImageView(this);
        BackArrow.setFocusableInTouchMode(true);
        BackArrow.setPadding(10, 10, 10, 10);

        Button button = new Button(this);
        button.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
        button.setLayoutParams(new ViewGroup.LayoutParams(90, 65));
        button.setTextColor(Color.rgb(255, 255, 255));
        button.setTextSize(10);

        TextView BackArrowText = new TextView(this);

        EditText edittext = new EditText(this);
        ImageView logo = new ImageView(this);

        logo.setImageResource(R.drawable.aliseonblackwhilte);

        BackArrow.setImageResource(R.drawable.backarrow_b);
        BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
        BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);
        BackArrowText.setTextSize(20);
        BackArrowText.setTextColor(Color.rgb(255, 255, 255));
        BackArrowText.setText(getResources().getString(R.string.subscriber));
        BackArrowText.setPadding(0, 0, 0, 10);

        edittext.setLayoutParams(new ViewGroup.LayoutParams(860, 60));
        edittext.setTextSize(12);
        edittext.setPadding(20, 10, 0, 10);
        edittext.setHintTextColor(Color.rgb(255, 255, 255));
        edittext.setTextColor(Color.rgb(255, 255, 255));
        edittext.setSingleLine(true);
        edittext.setId(R.id.editAll);
        edittext.setText(keyword);

//        edittext.setLayoutParams(new ViewGroup.LayoutParams(860, 60));
//        edittext.setHint("Search");
//        edittext.setTextSize(12);
//        edittext.setPadding(20,10,0,10);
//        edittext.setHintTextColor(Color.rgb(255, 255, 255));
//        edittext.setTextColor(Color.rgb(255, 255, 255));
//        edittext.setSingleLine(true);
//        edittext.setId(R.id.editAll);


//        String getString = getIntent().getStringExtra("result");
//        if(!getString.isEmpty()){
//            edittext.setText(getString);
//        }

        logo.setLayoutParams(new ViewGroup.LayoutParams(150, 60));
        logo.setScaleType(ImageView.ScaleType.FIT_CENTER);

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
        LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
        LinearLayout.LayoutParams paramsTopButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
        LinearLayout.LayoutParams paramsrecommandTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 70);
        LinearLayout.LayoutParams paramsrecommandTV2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
        LinearLayout.LayoutParams paramsrecommandList = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 330);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180);
        LinearLayout.LayoutParams params3_1_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180, 1f);
        LinearLayout.LayoutParams params3_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180, 1f);
        LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 420);
        LinearLayout.LayoutParams params3_4_1 = new LinearLayout.LayoutParams(250, 280);
        LinearLayout.LayoutParams params3_4_1_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.3f);
        LinearLayout.LayoutParams params3_4_1_1_1 = new LinearLayout.LayoutParams(160, 160);
        LinearLayout.LayoutParams params3_4_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
        LinearLayout.LayoutParams params3_8 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
        LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
        LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

        paramsTitleTV.bottomMargin = 10;
        paramsMainLayout.leftMargin = 10;
        paramsMainLayout.rightMargin = 10;
        paramsMainLayout.bottomMargin = 20;
        paramsrecommandList.bottomMargin = 30;
        params3_2.bottomMargin = 20;
        params3_1_2.rightMargin = 20;
        params3_4_1.leftMargin = 10;

        scroller.setLayoutParams(params3);
        scroller.setVerticalScrollBarEnabled(false);

        Layout2.setLayoutParams(params2);
        Layout2.setGravity(Gravity.CENTER);
        Layout2.setOrientation(LinearLayout.VERTICAL);
        Layout2_1.setLayoutParams(paramsBackArrow);
        Layout2_1.setGravity(Gravity.CENTER);
        Layout2_1.addView(BackArrow);
        Layout2_2.setLayoutParams(paramsTopButton);
        Layout2_2.setGravity(Gravity.CENTER);
        Layout2_2.addView(button);


        Layout2.addView(Layout2_1);
        Layout2.addView(Layout2_2);

        edittext.setBackgroundColor(Color.rgb(38, 38, 38));

        Layout1.addView(Layout2);

        Layout3.setLayoutParams(params3);
        Layout3.setOrientation(LinearLayout.VERTICAL);

        Layout3_1.setOrientation(LinearLayout.HORIZONTAL);
        Layout3_1.setLayoutParams(params3_1);
        Layout3_1_1.setOrientation(LinearLayout.VERTICAL);
        Layout3_1_1.setGravity(Gravity.LEFT | Gravity.CENTER);
        Layout3_1_1.setLayoutParams(params3_1_1);
        Layout3_1_1.setPadding(10, 0, 0, 0);
        Layout3_1_2.setOrientation(LinearLayout.VERTICAL);
        Layout3_1_2.setGravity(Gravity.RIGHT | Gravity.CENTER);
        Layout3_1_2.setLayoutParams(params3_1_2);

        Layout3.addView(Layout3_1);
        Layout3_1.addView(Layout3_1_1);
        Layout3_1_1.addView(edittext);
        Layout3_1.addView(Layout3_1_2);
        Layout3_1_2.addView(logo);

        Layout3_2.setLayoutParams(params);
        Layout3_2.setOrientation(LinearLayout.VERTICAL);

        Layout3_3.setOrientation(LinearLayout.HORIZONTAL);
        Layout3_3.setLayoutParams(paramsrecommandTV);

        Layout3_5.setGravity(Gravity.LEFT | Gravity.CENTER);
        Layout3_5.setLayoutParams(paramsrecommandTV2);


        // Only for Loading
        ImageView CategoryIV1 = new ImageView(this);
        CategoryIV1.setImageResource(R.drawable.noing_category);
        CategoryIV1.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
        CategoryIV1.setScaleType(ImageView.ScaleType.FIT_START);

        Layout3_3.addView(CategoryIV1);

        // TEXTVIEW TV1

//        TextView TV1 = new TextView(this);
//        TV1.setTextColor(Color.rgb(255, 255, 255));
//        TV1.setText(getResources().getString(R.string.recommendationCreator));
//        TV1.setTextSize(15);
//        TV1.setPadding(10,0,0,0);

        scroller.addView(Layout3_2);
//        Layout3_3.addView(TV1);
        Layout3_2.addView(Layout3_3);

        for (int i = 0; i < 9; i++) {

            LinearLayout Layout3_4_1 = new LinearLayout(this);
            LinearLayout Layout3_4_1_1 = new LinearLayout(this);
            LinearLayout Layout3_4_1_2 = new LinearLayout(this);
            Layout3_4_1.setOrientation(LinearLayout.VERTICAL);
            Layout3_4_1.setGravity(Gravity.CENTER);
            Layout3_4_1.setLayoutParams(params3_4_1);
            Layout3_4_1_1.setFocusableInTouchMode(true);
            Layout3_4_1_1.setGravity(Gravity.CENTER);
            Layout3_4_1_2.setGravity(Gravity.CENTER);
            Layout3_4_1_1.setLayoutParams(params3_4_1_1);
            Layout3_4_1_2.setLayoutParams(params3_4_1_2);

            CircleImageView subscribe_image = new CircleImageView(this);
            ImageView subscribe_image2 = new ImageView(this);

            subscribe_image.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            subscribe_image.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.noing_ract_shape));

            subscribe_image2.setImageResource(R.drawable.noing_category);
            subscribe_image2.setLayoutParams(new ViewGroup.LayoutParams(225, 42));
            subscribe_image2.setScaleType(ImageView.ScaleType.FIT_CENTER);


            Layout3_4_1_1.addView(subscribe_image);
            Layout3_4_1_2.addView(subscribe_image2);

            Layout3_4_1.addView(Layout3_4_1_1);
            Layout3_4_1.addView(Layout3_4_1_2);

            Layout3_4.addView(Layout3_4_1);

        }

        Layout3_2.addView(Layout3_4);

        ImageView CategoryIV2 = new ImageView(this);
        CategoryIV2.setImageResource(R.drawable.noing_category);
        CategoryIV2.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
        CategoryIV2.setScaleType(ImageView.ScaleType.FIT_START);
        Layout3_5.addView(CategoryIV2);

        Layout3_2.addView(Layout3_5);

        Layout3_6.setLayoutParams(params);
        Layout3_6.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < 2; i++) {
            LinearLayout Layout3_8 = new LinearLayout(this);
            Layout3_8.setLayoutParams(params3_2);
            Layout3_8.setGravity(Gravity.CENTER | Gravity.LEFT);
            Layout3_6.addView(Layout3_8);

            for (int ii = 0; ii < 4; ii++) {
                LinearLayout Layout3_8_1 = new LinearLayout(this);
                LinearLayout Layout3_8_1_1 = new LinearLayout(this);
                ImageView IV11 = new ImageView(this);
                Glide.with(this).load(R.drawable.noing_layout).into(IV11);

                Layout3_8_1.setGravity(Gravity.CENTER);
                Layout3_8_1_1.setLayoutParams(paramsMainLayout);
                Layout3_8_1_1.setFocusableInTouchMode(true);

                Layout3_8_1_1.addView(IV11);
                Layout3_8_1.addView(Layout3_8_1_1);
                Layout3_8.addView(Layout3_8_1);
            }
        }

        Layout3.addView(scroller);
        Layout3_2.addView(Layout3_6);
        Layout1.addView(Layout3);
        setContentView(Layout1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scroller.smoothScrollTo(0,0);
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

        Aliseon aliseon = (Aliseon) getApplicationContext();

        aliseon.aliseon_setVoyageResultAPIload(0);

        aliseon.aliseon_setRecommend_id(new ArrayList<String>());
        aliseon.aliseon_setRecommend_nickname(new ArrayList<String>());
        aliseon.aliseon_setRecommend_photo(new ArrayList<String>());
        aliseon.aliseon_setRecommend_subscribeto_cnt(new ArrayList<String>());
        aliseon.aliseon_setRecommend_contents_cnt(new ArrayList<String>());

        aliseon.aliseon_setVoyageresult_id(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_user_id(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_product_id(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_contents_id(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_contents_type(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_category_id(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_status(new ArrayList<Integer>());
        aliseon.aliseon_setVoyageresult_description(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_create_at(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_update_at(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_like_count(new ArrayList<Integer>());
        aliseon.aliseon_setVoyageresult_view_count(new ArrayList<Integer>());
        aliseon.aliseon_setVoyageresult_comment_count(new ArrayList<Integer>());
        aliseon.aliseon_setVoyageresult_category_en(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_category_kr(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_photo(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_nickname(new ArrayList<String>());
        aliseon.aliseon_setVoyageresult_p_thumbnail(new ArrayList<ArrayList<String>>());




//        recommend_id.clear();
//        recommend_nickname.clear();
//        recommend_photo.clear();
//        recommend_subscribeto_cnt.clear();
//        recommend_contents_cnt.clear();

//        voyageresult_id.clear();
//        voyageresult_user_id.clear();
//        voyageresult_product_id.clear();
//        voyageresult_contents_id.clear();
//        voyageresult_contents_type.clear();
//        voyageresult_category_id.clear();
//        voyageresult_status.clear();
//        voyageresult_description.clear();
//        voyageresult_create_at.clear();
//        voyageresult_update_at.clear();
//        voyageresult_like_count.clear();
//        voyageresult_view_count.clear();
//        voyageresult_comment_count.clear();
//        voyageresult_category_en.clear();
//        voyageresult_category_kr.clear();
//        voyageresult_photo.clear();
//        voyageresult_nickname.clear();
//        voyageresult_p_thumbnail.clear();

        overridePendingTransition(0, 0);
    }

    @Override
    public void recreate() {
        super.recreate();
    }

    @Override
    public void onResume() {
        super.onResume();

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();

        int voyageresultapiload = aliseon.aliseon_getVoyageResultAPIload();
        String keyword = aliseon.aliseon_getKeyword();

        ArrayList<String> recommend_id = aliseon.aliseon_getRecommend_id();
        ArrayList<String> recommend_nickname = aliseon.aliseon_getRecommend_nickname();
        ArrayList<String> recommend_photo = aliseon.aliseon_getRecommend_photo();
        ArrayList<String> recommend_subscribeto_cnt = aliseon.aliseon_getRecommend_subscribeto_cnt();
        ArrayList<String> recommend_contents_cnt = aliseon.aliseon_getRecommend_contnets_cnt();

        ArrayList<String> voyageresult_photo = aliseon.aliseon_getVoyageresult_photo();
        ArrayList<String> voyageresult_description = aliseon.aliseon_getVoyageresult_description();
        ArrayList<String> voyageresult_nickname = aliseon.aliseon_getVoyageresult_nickname();
        ArrayList<Integer> voyageresult_view_count = aliseon.aliseon_getVoyageresult_view_count();
        ArrayList<ArrayList<String>> voyageresult_p_thumbnail = aliseon.aliseon_getVoyageresult_p_thumbnail();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        if (voyageresultapiload == 0) {
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

            LinearLayout Layout3 = new LinearLayout(this);
            LinearLayout Layout3_1 = new LinearLayout(this);
            LinearLayout Layout3_1_1 = new LinearLayout(this);
            LinearLayout Layout3_1_2 = new LinearLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this);
            LinearLayout Layout3_3 = new LinearLayout(this);
            LinearLayout Layout3_4 = new LinearLayout(this);
            LinearLayout Layout3_5 = new LinearLayout(this);
            LinearLayout Layout3_6 = new LinearLayout(this);

            ScrollView scroller = new ScrollView(this);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            ImageView BackArrow = new ImageView(this);
            BackArrow.setFocusableInTouchMode(true);
            BackArrow.setPadding(10, 10, 10, 10);
            BackArrow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));

            Button button = new Button(this);
            button.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            button.setLayoutParams(new ViewGroup.LayoutParams(90, 65));
            button.setTextColor(Color.rgb(255, 255, 255));
            button.setTextSize(10);
            button.setText("TOP");

            TextView BackArrowText = new TextView(this);

            EditText edittext = new EditText(this);
            ImageView logo = new ImageView(this);

            logo.setImageResource(R.drawable.aliseonblackwhilte);

            BackArrow.setImageResource(R.drawable.backarrow);
            BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BackArrowText.setTextSize(20);
            BackArrowText.setTextColor(Color.rgb(255, 255, 255));
            BackArrowText.setText(getResources().getString(R.string.subscriber));
            BackArrowText.setPadding(0, 0, 0, 10);

            edittext.setLayoutParams(new ViewGroup.LayoutParams(860, 60));
            edittext.setTextSize(12);
            edittext.setPadding(20, 10, 0, 10);
            edittext.setHintTextColor(Color.rgb(255, 255, 255));
            edittext.setTextColor(Color.rgb(255, 255, 255));
            edittext.setSingleLine(true);
            edittext.setId(R.id.editAll);
            edittext.setText(keyword);

//        edittext.setLayoutParams(new ViewGroup.LayoutParams(860, 60));
//        edittext.setHint("Search");
//        edittext.setTextSize(12);
//        edittext.setPadding(20,10,0,10);
//        edittext.setHintTextColor(Color.rgb(255, 255, 255));
//        edittext.setTextColor(Color.rgb(255, 255, 255));
//        edittext.setSingleLine(true);
//        edittext.setId(R.id.editAll);


//        String getString = getIntent().getStringExtra("result");
//        if(!getString.isEmpty()){
//            edittext.setText(getString);
//        }

            logo.setLayoutParams(new ViewGroup.LayoutParams(150, 60));
            logo.setScaleType(ImageView.ScaleType.FIT_CENTER);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
            LinearLayout.LayoutParams paramsTopButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams paramsrecommandTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 70);
            LinearLayout.LayoutParams paramsrecommandTV2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams paramsrecommandList = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 330);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180);
            LinearLayout.LayoutParams params3_1_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180, 1f);
            LinearLayout.LayoutParams params3_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180, 1f);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 420);
            LinearLayout.LayoutParams params3_4_1 = new LinearLayout.LayoutParams(250, 280);
            LinearLayout.LayoutParams params3_4_1_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.3f);
            LinearLayout.LayoutParams params3_4_1_1_1 = new LinearLayout.LayoutParams(160, 160);
            LinearLayout.LayoutParams params3_4_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params3_8 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

            paramsTitleTV.bottomMargin = 10;
            paramsMainLayout.leftMargin = 10;
            paramsMainLayout.rightMargin = 10;
            paramsMainLayout.bottomMargin = 20;
            paramsrecommandList.bottomMargin = 30;
            params3_2.bottomMargin = 20;
            params3_1_2.rightMargin = 20;
            params3_4_1.leftMargin = 10;

            scroller.setLayoutParams(params3);
            scroller.setVerticalScrollBarEnabled(false);

            Layout2.setLayoutParams(params2);
            Layout2.setGravity(Gravity.CENTER);
            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2_1.setLayoutParams(paramsBackArrow);
            Layout2_1.setGravity(Gravity.CENTER);
            Layout2_1.addView(BackArrow);
            Layout2_2.setLayoutParams(paramsTopButton);
            Layout2_2.setGravity(Gravity.CENTER);
            Layout2_2.addView(button);


            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            edittext.setBackgroundColor(Color.rgb(38, 38, 38));

            Layout1.addView(Layout2);

            Layout3.setLayoutParams(params3);
            Layout3.setOrientation(LinearLayout.VERTICAL);

            Layout3_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_1.setLayoutParams(params3_1);
            Layout3_1_1.setOrientation(LinearLayout.VERTICAL);
            Layout3_1_1.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_1.setLayoutParams(params3_1_1);
            Layout3_1_1.setPadding(10, 0, 0, 0);
            Layout3_1_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_1_2.setGravity(Gravity.RIGHT | Gravity.CENTER);
            Layout3_1_2.setLayoutParams(params3_1_2);

            Layout3.addView(Layout3_1);
            Layout3_1.addView(Layout3_1_1);
            Layout3_1_1.addView(edittext);
            Layout3_1.addView(Layout3_1_2);
            Layout3_1_2.addView(logo);

            Layout3_2.setLayoutParams(params);
            Layout3_2.setOrientation(LinearLayout.VERTICAL);

            Layout3_3.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_3.setLayoutParams(paramsrecommandTV);

            Layout3_5.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_5.setLayoutParams(paramsrecommandTV2);


            // Only for Loading
            ImageView CategoryIV1 = new ImageView(this);
            CategoryIV1.setImageResource(R.drawable.noing_category);
            CategoryIV1.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            CategoryIV1.setScaleType(ImageView.ScaleType.FIT_START);

            Layout3_3.addView(CategoryIV1);

            // TEXTVIEW TV1

//        TextView TV1 = new TextView(this);
//        TV1.setTextColor(Color.rgb(255, 255, 255));
//        TV1.setText(getResources().getString(R.string.recommendationCreator));
//        TV1.setTextSize(15);
//        TV1.setPadding(10,0,0,0);

            scroller.addView(Layout3_2);
//        Layout3_3.addView(TV1);
            Layout3_2.addView(Layout3_3);

            for (int i = 0; i < 9; i++) {

                LinearLayout Layout3_4_1 = new LinearLayout(this);
                LinearLayout Layout3_4_1_1 = new LinearLayout(this);
                LinearLayout Layout3_4_1_2 = new LinearLayout(this);
                Layout3_4_1.setOrientation(LinearLayout.VERTICAL);
                Layout3_4_1.setGravity(Gravity.CENTER);
                Layout3_4_1.setLayoutParams(params3_4_1);
                Layout3_4_1_1.setFocusableInTouchMode(true);
                Layout3_4_1_1.setGravity(Gravity.CENTER);
                Layout3_4_1_2.setGravity(Gravity.CENTER);
                Layout3_4_1_1.setLayoutParams(params3_4_1_1);
                Layout3_4_1_2.setLayoutParams(params3_4_1_2);

                CircleImageView subscribe_image = new CircleImageView(this);
                ImageView subscribe_image2 = new ImageView(this);

                subscribe_image.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
                subscribe_image.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.noing_ract_shape));

                subscribe_image2.setImageResource(R.drawable.noing_category);
                subscribe_image2.setLayoutParams(new ViewGroup.LayoutParams(225, 42));
                subscribe_image2.setScaleType(ImageView.ScaleType.FIT_CENTER);


                Layout3_4_1_1.addView(subscribe_image);
                Layout3_4_1_2.addView(subscribe_image2);

                Layout3_4_1.addView(Layout3_4_1_1);
                Layout3_4_1.addView(Layout3_4_1_2);

                Layout3_4.addView(Layout3_4_1);

            }

            Layout3_2.addView(Layout3_4);

            ImageView CategoryIV2 = new ImageView(this);
            CategoryIV2.setImageResource(R.drawable.noing_category);
            CategoryIV2.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            CategoryIV2.setScaleType(ImageView.ScaleType.FIT_START);
            Layout3_5.addView(CategoryIV2);

            Layout3_2.addView(Layout3_5);

            Layout3_6.setLayoutParams(params);
            Layout3_6.setOrientation(LinearLayout.VERTICAL);

            for (int i = 0; i < 2; i++) {
                LinearLayout Layout3_8 = new LinearLayout(this);
                Layout3_8.setLayoutParams(params3_2);
                Layout3_8.setGravity(Gravity.CENTER | Gravity.LEFT);
                Layout3_6.addView(Layout3_8);

                for (int ii = 0; ii < 4; ii++) {
                    LinearLayout Layout3_8_1 = new LinearLayout(this);
                    LinearLayout Layout3_8_1_1 = new LinearLayout(this);
                    ImageView IV11 = new ImageView(this);
                    Glide.with(this).load(R.drawable.noing_layout).into(IV11);

                    Layout3_8_1.setGravity(Gravity.CENTER);
                    Layout3_8_1_1.setLayoutParams(paramsMainLayout);
                    Layout3_8_1_1.setFocusableInTouchMode(true);

                    Layout3_8_1_1.addView(IV11);
                    Layout3_8_1.addView(Layout3_8_1_1);
                    Layout3_8.addView(Layout3_8_1);
                }
            }

            Layout3.addView(scroller);
            Layout3_2.addView(Layout3_6);
            Layout1.addView(Layout3);
            setContentView(Layout1);

        } else {
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

            LinearLayout Layout3 = new LinearLayout(this);
            LinearLayout Layout3_1 = new LinearLayout(this);
            LinearLayout Layout3_1_1 = new LinearLayout(this);
            LinearLayout Layout3_1_2 = new LinearLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this);
            LinearLayout Layout3_3 = new LinearLayout(this);
            LinearLayout Layout3_4 = new LinearLayout(this);
            LinearLayout Layout3_5 = new LinearLayout(this);
            LinearLayout Layout3_6 = new LinearLayout(this);
            LinearLayout Layout4 = new LinearLayout(this);

            ScrollView scroller = new ScrollView(this);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            ImageView BackArrow = new ImageView(this);
            BackArrow.setFocusableInTouchMode(true);
            BackArrow.setPadding(10, 10, 10, 10);
            BackArrow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));

            Button button = new Button(this);
            button.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            button.setLayoutParams(new ViewGroup.LayoutParams(90, 65));
            button.setTextColor(Color.rgb(255, 255, 255));
            button.setTextSize(10);
            button.setText("TOP");

            TextView BackArrowText = new TextView(this);

            EditText edittext = new EditText(this);
            ImageView logo = new ImageView(this);

            logo.setImageResource(R.drawable.aliseonblackwhilte);

            BackArrow.setImageResource(R.drawable.backarrow);
            BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BackArrowText.setTextSize(20);
            BackArrowText.setTextColor(Color.rgb(255, 255, 255));
            BackArrowText.setText(getResources().getString(R.string.subscriber));
            BackArrowText.setPadding(0, 0, 0, 10);

            edittext.setLayoutParams(new ViewGroup.LayoutParams(860, 60));
            edittext.setHint("Search");
            edittext.setTextSize(12);
            edittext.setPadding(20, 10, 0, 10);
            edittext.setHintTextColor(Color.rgb(255, 255, 255));
            edittext.setTextColor(Color.rgb(255, 255, 255));
            edittext.setSingleLine(true);
            edittext.setId(R.id.editAll);
            edittext.setText(keyword);


//        String getString = getIntent().getStringExtra("result");
//        if(!getString.isEmpty()){
//            edittext.setText(getString);
//        }

            logo.setLayoutParams(new ViewGroup.LayoutParams(150, 60));
            logo.setScaleType(ImageView.ScaleType.FIT_CENTER);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
            LinearLayout.LayoutParams paramsTopButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams paramsrecommandTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 70);
            LinearLayout.LayoutParams paramsrecommandTV2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams paramsrecommandList = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 330);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180);
            LinearLayout.LayoutParams params3_1_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180, 1f);
            LinearLayout.LayoutParams params3_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180, 1f);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 420);
            LinearLayout.LayoutParams params3_4_1 = new LinearLayout.LayoutParams(250, 280);
            LinearLayout.LayoutParams params3_4_1_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.3f);
            LinearLayout.LayoutParams params3_4_1_1_1 = new LinearLayout.LayoutParams(160, 160);
            LinearLayout.LayoutParams params3_4_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params3_8 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

            paramsTitleTV.bottomMargin = 10;
            paramsMainLayout.leftMargin = 10;
            paramsMainLayout.rightMargin = 10;
            paramsMainLayout.bottomMargin = 20;
            paramsrecommandList.bottomMargin = 30;
            params3_2.bottomMargin = 20;
            params3_1_2.rightMargin = 20;
            params3_4_1.leftMargin = 10;

            scroller.setLayoutParams(params3);
            scroller.setVerticalScrollBarEnabled(false);

            Layout4.setLayoutParams(params4);
            Layout4.setOrientation(LinearLayout.VERTICAL);
            Layout4.setGravity(Gravity.CENTER);
            Layout4.setFocusableInTouchMode(true);

            ProgressBar progressbar = new ProgressBar(this);
            progressbar.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            progressbar.setVisibility(View.GONE);

            Layout2.setLayoutParams(params2);
            Layout2.setGravity(Gravity.CENTER);
            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2_1.setLayoutParams(paramsBackArrow);
            Layout2_1.setGravity(Gravity.CENTER);
            Layout2_1.addView(BackArrow);
            Layout2_2.setLayoutParams(paramsTopButton);
            Layout2_2.setGravity(Gravity.CENTER);
            Layout2_2.addView(button);


            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            edittext.setBackgroundColor(Color.rgb(38, 38, 38));

            Layout1.addView(Layout2);

            Layout3.setLayoutParams(params3);
            Layout3.setOrientation(LinearLayout.VERTICAL);

            Layout3_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_1.setLayoutParams(params3_1);
            Layout3_1_1.setOrientation(LinearLayout.VERTICAL);
            Layout3_1_1.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_1.setLayoutParams(params3_1_1);
            Layout3_1_1.setPadding(10, 0, 0, 0);
            Layout3_1_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_1_2.setGravity(Gravity.RIGHT | Gravity.CENTER);
            Layout3_1_2.setLayoutParams(params3_1_2);

            Layout3.addView(Layout3_1);
            Layout3_1.addView(Layout3_1_1);
            Layout3_1_1.addView(edittext);
            Layout3_1.addView(Layout3_1_2);
            Layout3_1_2.addView(logo);

            Layout3_2.setLayoutParams(params);
            Layout3_2.setOrientation(LinearLayout.VERTICAL);

            Layout3_3.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_3.setLayoutParams(paramsrecommandTV);

            Layout3_5.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_5.setLayoutParams(paramsrecommandTV2);


            // Only for Loading
//            ImageView CategoryIV1 = new ImageView(this);
//            CategoryIV1.setImageResource(R.drawable.noing_category);
//            CategoryIV1.setLayoutParams(new ViewGroup.LayoutParams(300,56));
//            CategoryIV1.setScaleType(ImageView.ScaleType.FIT_START);
//
//            Layout3_3.addView(CategoryIV1);

            // TEXTVIEW TV1

            TextView TV1 = new TextView(this);
            TV1.setTextColor(Color.rgb(255, 255, 255));
            TV1.setText(getResources().getString(R.string.recommendationCreator));
            TV1.setTextSize(15);
            TV1.setPadding(10, 0, 0, 0);

            scroller.addView(Layout3_2);
            Layout3_3.addView(TV1);
            Layout3_2.addView(Layout3_3);

//            for (int i = 0; i < 9; i++) {
//
//                LinearLayout Layout3_4_1 = new LinearLayout(this);
//                LinearLayout Layout3_4_1_1 = new LinearLayout(this);
//                LinearLayout Layout3_4_1_2 = new LinearLayout(this);
//                Layout3_4_1.setOrientation(LinearLayout.VERTICAL);
//                Layout3_4_1.setGravity(Gravity.CENTER);
//                Layout3_4_1.setLayoutParams(params3_4_1);
//                Layout3_4_1_1.setFocusableInTouchMode(true);
//                Layout3_4_1_1.setGravity(Gravity.CENTER);
//                Layout3_4_1_2.setGravity(Gravity.CENTER);
//                Layout3_4_1_1.setLayoutParams(params3_4_1_1);
//                Layout3_4_1_2.setLayoutParams(params3_4_1_2);
//
//                CircleImageView subscribe_image = new CircleImageView(this);
//                ImageView subscribe_image2 = new ImageView(this);
//
//                subscribe_image.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//                subscribe_image.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.noing_ract_shape));
//
//                subscribe_image2.setImageResource(R.drawable.noing_category);
//                subscribe_image2.setLayoutParams(new ViewGroup.LayoutParams(225, 42));
//                subscribe_image2.setScaleType(ImageView.ScaleType.FIT_CENTER);
//
//
//                Layout3_4_1_1.addView(subscribe_image);
//                Layout3_4_1_2.addView(subscribe_image2);
//
//                Layout3_4_1.addView(Layout3_4_1_1);
//                Layout3_4_1.addView(Layout3_4_1_2);
//
//                Layout3_4.addView(Layout3_4_1);
//
//            }

            try {

                if (params3_4_1_1 != null && params3_4_1_1_1 != null && params3_4_1_2 != null && Layout3_4 != null) {

                for (int i = 0; i < 5; i++) {

                    LinearLayout Layout3_4_1 = new LinearLayout(this);
                    LinearLayout Layout3_4_1_1 = new LinearLayout(this);
                    LinearLayout Layout3_4_1_1_1 = new LinearLayout(this);
                    LinearLayout Layout3_4_1_2 = new LinearLayout(this);
                    LinearLayout Layout3_4_1_3 = new LinearLayout(this);
                    Layout3_4_1.setOrientation(LinearLayout.VERTICAL);
                    Layout3_4_1.setLayoutParams(params3_4_1);
                    Layout3_4_1.setGravity(Gravity.CENTER);
                    Layout3_4_1_1_1.setFocusableInTouchMode(true);
                    Layout3_4_1_1_1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.selectusersetting));
                    Layout3_4_1_1.setGravity(Gravity.CENTER | Gravity.BOTTOM);
                    Layout3_4_1_1_1.setGravity(Gravity.CENTER);
                    Layout3_4_1_2.setGravity(Gravity.CENTER | Gravity.TOP);
                    Layout3_4_1_3.setGravity(Gravity.CENTER);
                    Layout3_4_1_1.setLayoutParams(params3_4_1_1);
                    Layout3_4_1_1_1.setLayoutParams(params3_4_1_1_1);
                    Layout3_4_1_2.setLayoutParams(params3_4_1_2);
                    Layout3_4_1_3.setLayoutParams(params3_4_1_2);

                    CircleImageView subscribe_image = new CircleImageView(this);
                    TextView subscribe_tv = new TextView(this);

                    subscribe_image.setLayoutParams(new ViewGroup.LayoutParams(150, 150));

                    subscribe_tv.setText(recommend_nickname.get(i));
                    subscribe_tv.setTextColor(Color.rgb(255, 255, 255));

                    if (recommend_photo.get(i) == null) {
                        subscribe_image.setImageResource(R.drawable.noimg_profile);
                    } else {
                        Glide.with(this).load(imageurl + recommend_photo.get(i)).into(subscribe_image);

                    }

                    Log.d("PHOTOLOG", "IMAGE : " + recommend_photo.get(i));


                    Layout3_4_1_1_1.addView(subscribe_image);
                    Layout3_4_1_2.addView(subscribe_tv);

                    Layout3_4_1_1.addView(Layout3_4_1_1_1);
                    Layout3_4_1.addView(Layout3_4_1_1);
                    Layout3_4_1.addView(Layout3_4_1_2);
                    Layout3_4_1.addView(Layout3_4_1_3);

                    Layout3_4.addView(Layout3_4_1);

                    Layout3_4_1_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                        @Override
                        public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                            if (hasFocus == false) {
                                Layout3_4_1.setBackground(null);
                                subscribe_tv.setTextColor(Color.rgb(255, 255, 255));

                                Layout3_4_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                    @Override
                                    public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                        if (hasFocus) {
                                            Layout3_4_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                            subscribe_tv.setTextColor(Color.rgb(0, 0, 0));
                                        } else {
                                            Layout3_4_1.setBackground(null);
                                            subscribe_tv.setTextColor(Color.rgb(255, 255, 255));
                                        }
                                    }
                                });

                            } else {
                                Layout3_4_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                subscribe_tv.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                            }
                        }
                    });

                    final int j = i;

                    Layout3_4_1_1_1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            aliseon.aliseon_setParam_creator_info(Integer.parseInt(recommend_id.get(j)));

                            Intent intent = new Intent(VoyageResultActivity.this, CreatorActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                        }
                    });
                }

                } throw new Exception("error");

            } catch (Exception e) {

            }

            Layout3_2.addView(Layout3_4);


            // Only for Loading 2
//            ImageView CategoryIV2 = new ImageView(this);
//            CategoryIV2.setImageResource(R.drawable.noing_category);
//            CategoryIV2.setLayoutParams(new ViewGroup.LayoutParams(300,56));
//            CategoryIV2.setScaleType(ImageView.ScaleType.FIT_START);
//            Layout3_5.addView(CategoryIV2);

            // TEXTVIEW 2
            TextView TV2 = new TextView(this);
            TV2.setTextColor(Color.rgb(255, 255, 255));
            TV2.setText("Contents");
            TV2.setTextSize(15);
            TV2.setPadding(10, 0, 0, 0);

            Layout3_5.addView(TV2);

            Layout3_2.addView(Layout3_5);

            Layout3_6.setLayoutParams(params);
            Layout3_6.setOrientation(LinearLayout.VERTICAL);

            if (voyageresult_p_thumbnail.size() == 0) {
                LinearLayout Layout3_7 = new LinearLayout(this);
                LinearLayout.LayoutParams params4_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                Layout3_7.setLayoutParams(params4_3);
                Layout3_7.setGravity(Gravity.CENTER);
                TextView nocontents = new TextView(this);
                nocontents.setText(getString(R.string.nocontents));
                nocontents.setTextColor(Color.rgb(255, 255, 255));
                Layout3_7.addView(nocontents);
                nocontents.setTextSize(18);
                Layout3_6.addView(Layout3_7);
            } else {

                int jj = voyageresult_p_thumbnail.size() / 4 + 1;
                int y = voyageresult_p_thumbnail.size() % 4;

                int j = 0;
                for (int i = 0; i < jj; i++) {
                    LinearLayout Layout3_8 = new LinearLayout(this);
                    Layout3_8.setLayoutParams(params3_2);
                    Layout3_8.setGravity(Gravity.CENTER | Gravity.LEFT);
                    Layout3_6.addView(Layout3_8);

                    if (i == jj - 1) {
                        // 나머지가 0일 경우 위의 for에서 빈칸만 생성한 것이 되므로 삭제
                        if (y == 0) {
                            Layout3_6.removeView(Layout3_8);
                        }
                        for (int ii = 0; ii < y; ii++) {
                            LinearLayout Layout3_8_1 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_1 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_2 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_2_1 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_2_2 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_2_2_1 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_2_2_2 = new LinearLayout(this);


                            Layout3_8_1.setGravity(Gravity.CENTER);
                            ImageView IV11 = new ImageView(this);
                            CircleImageView CIV11 = new CircleImageView(this);
                            IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 286));
                            CIV11.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
                            TextView TV11_1 = new TextView(this);
                            TextView TV11_2 = new TextView(this);

                            try {

                                if (IV11 != null && imageurl != null & voyageresult_p_thumbnail != null && voyageresult_photo != null && Layout3_8_1_1 != null && TV11_1 != null && TV11_2 != null) {

                                    Glide.with(this).load(imageurl + voyageresult_p_thumbnail.get(j).get(0)).into(IV11);
                                    Glide.with(this).load(imageurl + voyageresult_photo.get(j)).into(CIV11);

                                    IV11.setScaleType(ImageView.ScaleType.FIT_XY);

                                    Layout3_8_1_1.setOrientation(LinearLayout.VERTICAL);
                                    Layout3_8_1_1.setFocusableInTouchMode(true);

                                    TV11_1.setText(voyageresult_description.get(j));
                                    TV11_1.setTextSize(14);
                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                    TV11_2.setText(voyageresult_nickname.get(j) + "\n" + voyageresult_view_count.get(j) + " views");
                                    TV11_2.setTextSize(10);
                                    TV11_2.setTextColor(Color.rgb(255, 255, 255));

                                } throw new Exception("error");

                            } catch (Exception e) {
                                Layout3_8_1_1_1.setBackgroundColor(Color.rgb(100, 100, 100));
                            }

                            Layout3_8_1_1.addView(Layout3_8_1_1_1);
                            Layout3_8_1_1_1.addView(IV11);
                            Layout3_8_1_1.addView(Layout3_8_1_1_2);
                            Layout3_8_1_1_2.setLayoutParams(params3_8);
                            Layout3_8_1_1_2.setOrientation(LinearLayout.VERTICAL);
                            Layout3_8_1_1_2.addView(Layout3_8_1_1_2_1);
                            Layout3_8_1_1_2.setGravity(Gravity.CENTER);
                            Layout3_8_1_1_2_1.addView(TV11_1);
                            TV11_1.setPadding(30, 0, 60, 0);
                            Layout3_8_1_1_2_1.setLayoutParams(paramsTitleTV);
                            Layout3_8_1_1_2.addView(Layout3_8_1_1_2_2);
                            Layout3_8_1_1_2_2.setOrientation(LinearLayout.HORIZONTAL);
                            Layout3_8_1_1_2_2.addView(Layout3_8_1_1_2_2_1);
                            Layout3_8_1_1_2_2.setPadding(0, 0, 0, 10);
                            Layout3_8_1_1_2_2_1.setPadding(25, 0, 0, 0);
                            Layout3_8_1_1_2_2_1.addView(CIV11);
                            Layout3_8_1_1_2_2_2.setLayoutParams(params3_8);
                            Layout3_8_1_1_2_2_2.setOrientation(LinearLayout.VERTICAL);
                            Layout3_8_1_1_2_2.addView(Layout3_8_1_1_2_2_2);
                            Layout3_8_1_1_2_2_2.setGravity(Gravity.CENTER | Gravity.CENTER);
                            Layout3_8_1_1_2_2_2.addView(TV11_2);

                            Layout3_8_1_1_2_2_1.setLayoutParams(paramsCIV);
                            Layout3_8_1_1_2_2_1.setGravity(Gravity.CENTER);

                            Layout3_8_1_1.setLayoutParams(paramsMainLayout);
                            Layout3_8_1_1.setFocusableInTouchMode(true);

                            Layout3_8_1.addView(Layout3_8_1_1);
                            Layout3_8.addView(Layout3_8_1);

                            Layout3_8_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                @Override
                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                    if (hasFocus == false) {
                                        Layout3_8_1_1.setBackground(null);
                                        TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                        TV11_1.setTextColor(Color.rgb(255, 255, 255));

                                        Layout3_8_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                if (hasFocus) {
                                                    Layout3_8_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                                    TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                                    TV11_2.setTextColor(Color.rgb(0, 0, 0));
                                                } else {
                                                    Layout3_8_1_1.setBackground(null);
                                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                                    TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                                }
                                            }
                                        });

                                    } else {
                                        Layout3_8_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                        TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                        TV11_2.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                                    }
                                }
                            });

                            if (i == 0 && ii == 0) {
                                Layout3_8_1_1.setId(R.id.LayoutAll);
                                Layout3_8_1_1.requestFocus();
                                Layout3_8_1_1.setNextFocusLeftId(R.id.all1);
                            }

                            if (ii == 0) {
                                Layout3_8_1_1.setId(R.id.LayoutAll);
                                Layout3_8_1_1.setNextFocusLeftId(R.id.all1);
                            }

                            final int jjj = j;
                            Layout3_8_1_1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
////                              nowurl = imageurl + feedresult_video.get(0);
////                              maintitle = feed_content.get(0);
                                    Intent intent = new Intent(VoyageResultActivity.this, AliseonOTTPlayerActivity.class);
////                                    nowurl = imageurl;
////                                    maintitle = voyageresult_description.get(jjj);
////                                    subtitle = voyageresult_description.get(jjj);
////                                    creatortitle = voyageresult_nickname.get(jjj);
////                                    creatorprofile = imageurl + voyageresult_photo.get(jjj);
////                                    creatorauthorid = voyageresult_user_id.get(jjj);
                                    intent.putExtra("index", jjj);
                                    intent.putExtra("category", 5);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                }
                            });

                            j++;
                        }

                    } else {
                        for (int ii = 0; ii < 4; ii++) {
                            LinearLayout Layout3_8_1 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_1 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_2 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_2_1 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_2_2 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_2_2_1 = new LinearLayout(this);
                            LinearLayout Layout3_8_1_1_2_2_2 = new LinearLayout(this);


                            Layout3_8_1.setGravity(Gravity.CENTER);
                            ImageView IV11 = new ImageView(this);
                            CircleImageView CIV11 = new CircleImageView(this);
                            IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 286));
                            CIV11.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
                            TextView TV11_1 = new TextView(this);
                            TextView TV11_2 = new TextView(this);

                            try {

                                if (IV11 != null && imageurl != null & voyageresult_p_thumbnail != null && voyageresult_photo != null && Layout3_8_1_1 != null && TV11_1 != null && TV11_2 != null) {

                                    Glide.with(this).load(imageurl + voyageresult_p_thumbnail.get(j).get(0)).into(IV11);
                                    Glide.with(this).load(imageurl + voyageresult_photo.get(j)).into(CIV11);

                                    IV11.setScaleType(ImageView.ScaleType.FIT_XY);

                                    Layout3_8_1_1.setOrientation(LinearLayout.VERTICAL);
                                    Layout3_8_1_1.setFocusableInTouchMode(true);

                                    TV11_1.setText(voyageresult_description.get(j));
                                    TV11_1.setTextSize(14);
                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                    TV11_2.setText(voyageresult_nickname.get(j) + "\n" + voyageresult_view_count.get(j) + " views");
                                    TV11_2.setTextSize(10);
                                    TV11_2.setTextColor(Color.rgb(255, 255, 255));

                                } throw new Exception("error");

                            } catch (Exception e) {
                                Layout3_8_1_1_1.setBackgroundColor(Color.rgb(100, 100, 100));
                            }

                            Layout3_8_1_1.addView(Layout3_8_1_1_1);
                            Layout3_8_1_1_1.addView(IV11);
                            Layout3_8_1_1.addView(Layout3_8_1_1_2);
                            Layout3_8_1_1_2.setLayoutParams(params3_8);
                            Layout3_8_1_1_2.setOrientation(LinearLayout.VERTICAL);
                            Layout3_8_1_1_2.addView(Layout3_8_1_1_2_1);
                            Layout3_8_1_1_2.setGravity(Gravity.CENTER);
                            Layout3_8_1_1_2_1.addView(TV11_1);
                            TV11_1.setPadding(30, 0, 60, 0);
                            Layout3_8_1_1_2_1.setLayoutParams(paramsTitleTV);
                            Layout3_8_1_1_2.addView(Layout3_8_1_1_2_2);
                            Layout3_8_1_1_2_2.setOrientation(LinearLayout.HORIZONTAL);
                            Layout3_8_1_1_2_2.addView(Layout3_8_1_1_2_2_1);
                            Layout3_8_1_1_2_2.setPadding(0, 0, 0, 10);
                            Layout3_8_1_1_2_2_1.setPadding(25, 0, 0, 0);
                            Layout3_8_1_1_2_2_1.addView(CIV11);
                            Layout3_8_1_1_2_2_2.setLayoutParams(params3_8);
                            Layout3_8_1_1_2_2_2.setOrientation(LinearLayout.VERTICAL);
                            Layout3_8_1_1_2_2.addView(Layout3_8_1_1_2_2_2);
                            Layout3_8_1_1_2_2_2.setGravity(Gravity.CENTER | Gravity.CENTER);
                            Layout3_8_1_1_2_2_2.addView(TV11_2);

                            Layout3_8_1_1_2_2_1.setLayoutParams(paramsCIV);
                            Layout3_8_1_1_2_2_1.setGravity(Gravity.CENTER);

                            Layout3_8_1_1.setLayoutParams(paramsMainLayout);
                            Layout3_8_1_1.setFocusableInTouchMode(true);

                            Layout3_8_1.addView(Layout3_8_1_1);
                            Layout3_8.addView(Layout3_8_1);

                            Layout3_8_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                @Override
                                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                    if (hasFocus == false) {
                                        Layout3_8_1_1.setBackground(null);
                                        TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                        TV11_1.setTextColor(Color.rgb(255, 255, 255));

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

                                        Layout3_8_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                                if (hasFocus) {
                                                    Layout3_8_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                                    TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                                    TV11_2.setTextColor(Color.rgb(0, 0, 0));
                                                } else {
                                                    Layout3_8_1_1.setBackground(null);
                                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                                    TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                                }
                                            }
                                        });

                                    } else {
                                        Layout3_8_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                        TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                        TV11_2.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                                    }
                                }
                            });

                            if (i == 0 && ii == 0) {
                                Layout3_8_1_1.setId(R.id.LayoutAll);
                                Layout3_8_1_1.requestFocus();
                                Layout3_8_1_1.setNextFocusLeftId(R.id.all1);
                            }

                            if (ii == 0) {
                                Layout3_8_1_1.setId(R.id.LayoutAll);
                                Layout3_8_1_1.setNextFocusLeftId(R.id.all1);
                            }

                            final int jjj = j;
                            Layout3_8_1_1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(VoyageResultActivity.this, AliseonOTTPlayerActivity.class);

                                    intent.putExtra("index", jjj);
                                    intent.putExtra("category", 5);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                }
                            });

                            j++;
                        }

                    }

                }
            }

            Layout3.addView(scroller);
            Layout4.addView(progressbar);

            Layout4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                @Override
                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때

                            // 회원
                            voyageresultloadinghandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressbar.setVisibility(View.VISIBLE);

                                    int voyageresultstart = aliseon.aliseon_getVoyageresultstart();

                                    aliseon.aliseon_setVoyageresultstart(voyageresultstart + 12);

                                    int category_num = aliseon.aliseon_getCategory_num();
                                    category_num = 0;

                                    VoyageResultPost();
                                }
                            });
                }
            });

            BackArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            Layout3_2.addView(Layout3_6);
            Layout3_2.addView(Layout4);
            Layout1.addView(Layout3);

            setContentView(Layout1);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scroller.smoothScrollTo(0,0);
                    LinearLayout Layout3_8_1_1 = (LinearLayout)findViewById(R.id.LayoutAll);
                    Layout3_8_1_1.requestFocus();
                }
            });

        }
    }

    public class VoyageResultHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1000) {
                onResume();
            }
        }
    }

    public class VoyageResultLoadingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1000) {
                onResume();
            }
        }
    }

    private void RecommendCreatorPost() {

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        int loginid = aliseon.aliseon_getLoginid();

        Call<RecommendCreator> call = AliseonAPI.RecommendCreatorPost(access_token, String.valueOf(loginid));

        call.enqueue(new Callback<RecommendCreator>() {
            @Override
            public void onResponse(Call<RecommendCreator> call, Response<RecommendCreator> response) {

                int voyageresultapiload = aliseon.aliseon_getVoyageResultAPIload();

                RecommendCreator postResponse = (RecommendCreator) response.body();
                Log.d("STATUS:", "COMPLETE");
                Log.d("Code : ", "" + response.code());

                ArrayList<String> recommend_id = new ArrayList<>();
                ArrayList<String> recommend_nickname = new ArrayList<>();
                ArrayList<String> recommend_photo = new ArrayList<>();
                ArrayList<String> recommend_subscribeto_cnt = new ArrayList<>();
                ArrayList<String> recommend_contents_cnt = new ArrayList<>();


                for (int i = 0; i < postResponse.getRecommend_creator_list().size(); i++) {

                    String id = postResponse.getRecommend_creator_list().get(i).getId();
                    String nickname = postResponse.getRecommend_creator_list().get(i).getNickname();
                    String photo = postResponse.getRecommend_creator_list().get(i).getPhoto();
                    String subscribeto_cnt = String.valueOf(postResponse.getRecommend_creator_list().get(i).getSubscribetoCnt());
                    String contents_cnt = String.valueOf(postResponse.getRecommend_creator_list().get(i).getContentsCnt());

                    recommend_id.add(id);
                    recommend_nickname.add(nickname);
                    recommend_photo.add(photo);
                    recommend_subscribeto_cnt.add(subscribeto_cnt);
                    recommend_contents_cnt.add(contents_cnt);

                    Log.d(TAG, "자바로 가공한 인기동영상 리스트>>" + id + "/" + nickname + "/" + photo + "/" + subscribeto_cnt + "/" + contents_cnt);

                }

                aliseon.aliseon_setRecommend_id(recommend_id);
                aliseon.aliseon_setRecommend_nickname(recommend_nickname);
                aliseon.aliseon_setRecommend_photo(recommend_photo);
                aliseon.aliseon_setRecommend_subscribeto_cnt(recommend_subscribeto_cnt);
                aliseon.aliseon_setRecommend_contents_cnt(recommend_contents_cnt);

                if (voyageresultapiload == 0) {

                    VoyageResultPost();

                } else {

                    aliseon.aliseon_setVoyageResultAPIload(1);
                    voyageresulthandler.sendEmptyMessage(1000);

                }


            }

            @Override
            public void onFailure(Call<RecommendCreator> call, Throwable t) {

            }
        });

    }

    private void VoyageResultPost() {

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();

        int voyageresultstart = 0;
        int voyageresultlimit = 0;

        int loginid = aliseon.aliseon_getLoginid();
        String loginlanguage = aliseon.aliseon_getLoginlanguage();

        String keyword = aliseon.aliseon_getKeyword();

        Call<VoyageResult> call = AliseonAPI.VoyageSearchPost(access_token, String.valueOf(loginid), 1, 0, 0, 10, loginlanguage, keyword);

        call.enqueue(new Callback<VoyageResult>() {
            @Override
            public void onResponse(Call<VoyageResult> call, Response<VoyageResult> response) {

                int voyageresultapiload = aliseon.aliseon_getVoyageResultAPIload();

                VoyageResult postResponse = (VoyageResult) response.body();
                Log.d("STATUS:", "COMPLETE");
                Log.d("Code : ", "" + response.code());

                ArrayList<ArrayList<String>> voyageresult_p_thumbnail = new ArrayList<>();

                ArrayList<String> voyageresult_id = new ArrayList<>();
                ArrayList<String> voyageresult_user_id = new ArrayList<>();
                ArrayList<String> voyageresult_product_id = new ArrayList<>();
                ArrayList<String> voyageresult_contents_id = new ArrayList<>();
                ArrayList<String> voyageresult_contents_type = new ArrayList<>();
                ArrayList<String> voyageresult_category_id = new ArrayList<>();
                ArrayList<Integer> voyageresult_status = new ArrayList<>();
                ArrayList<String> voyageresult_description = new ArrayList<>();
                ArrayList<String> voyageresult_create_at = new ArrayList<>();
                ArrayList<String> voyageresult_update_at = new ArrayList<>();
                ArrayList<Integer> voyageresult_like_count = new ArrayList<>();
                ArrayList<Integer> voyageresult_view_count = new ArrayList<>();
                ArrayList<Integer> voyageresult_comment_count = new ArrayList<>();
                ArrayList<String> voyageresult_category_en = new ArrayList<>();
                ArrayList<String> voyageresult_category_kr = new ArrayList<>();
                ArrayList<String> voyageresult_nickname = new ArrayList<>();
                ArrayList<String> voyageresult_photo = new ArrayList<>();



                try {

                    for (int i = 0; i < postResponse.voyageresult_list.size(); i++) {

                        String id = postResponse.voyageresult_list.get(i).getId();
                        String userid = postResponse.voyageresult_list.get(i).getUserId();
                        String productid = postResponse.voyageresult_list.get(i).getProductId();
                        String contentsid = postResponse.voyageresult_list.get(i).getContentsId();
                        String contentstype = postResponse.voyageresult_list.get(i).getContentsType();
                        String categoryid = postResponse.voyageresult_list.get(i).getCategoryId();
                        int status = postResponse.voyageresult_list.get(i).getStatus();
                        String description = postResponse.voyageresult_list.get(i).getDescription();
                        String createat = postResponse.voyageresult_list.get(i).getCreateAt();
                        String updateat = postResponse.voyageresult_list.get(i).getUpdateAt();
                        int likecount = postResponse.voyageresult_list.get(i).getLikeCount();
                        int viewcount = postResponse.voyageresult_list.get(i).getViewCount();
                        int commentcount = postResponse.voyageresult_list.get(i).getCommentCount();
                        String categoryen = postResponse.voyageresult_list.get(i).getCategoryEn();
                        String categoryko = postResponse.voyageresult_list.get(i).getCategoryKo();
                        String nickname = postResponse.voyageresult_list.get(i).getNickname();
                        String photo = postResponse.voyageresult_list.get(i).getPhoto();
                        ArrayList<String> c_thumbnail = postResponse.voyageresult_list.get(i).getThumbnail();

                        if (c_thumbnail != null) {
                            voyageresult_p_thumbnail.add(c_thumbnail);
                        }

                        voyageresult_id.add(id);
                        voyageresult_user_id.add(userid);
                        voyageresult_product_id.add(productid);
                        voyageresult_contents_id.add(contentsid);
                        voyageresult_contents_type.add(contentstype);
                        voyageresult_category_id.add(categoryid);
                        voyageresult_status.add(status);
                        voyageresult_description.add(description);
                        voyageresult_create_at.add(createat);
                        voyageresult_update_at.add(updateat);
                        voyageresult_like_count.add(likecount);
                        voyageresult_view_count.add(viewcount);
                        voyageresult_comment_count.add(commentcount);
                        voyageresult_category_en.add(categoryen);
                        voyageresult_category_kr.add(categoryko);
                        voyageresult_nickname.add(nickname);
                        voyageresult_photo.add(photo);

                    }

                    aliseon.aliseon_setVoyageresult_id(voyageresult_id);
                    aliseon.aliseon_setVoyageresult_user_id(voyageresult_user_id);
                    aliseon.aliseon_setVoyageresult_product_id(voyageresult_product_id);
                    aliseon.aliseon_setVoyageresult_contents_id(voyageresult_contents_id);
                    aliseon.aliseon_setVoyageresult_contents_type(voyageresult_contents_type);
                    aliseon.aliseon_setVoyageresult_category_id(voyageresult_category_id);
                    aliseon.aliseon_setVoyageresult_status(voyageresult_status);
                    aliseon.aliseon_setVoyageresult_description(voyageresult_description);
                    aliseon.aliseon_setVoyageresult_create_at(voyageresult_create_at);
                    aliseon.aliseon_setVoyageresult_update_at(voyageresult_update_at);
                    aliseon.aliseon_setVoyageresult_like_count(voyageresult_like_count);
                    aliseon.aliseon_setVoyageresult_view_count(voyageresult_view_count);
                    aliseon.aliseon_setVoyageresult_comment_count(voyageresult_comment_count);
                    aliseon.aliseon_setVoyageresult_category_en(voyageresult_category_en);
                    aliseon.aliseon_setVoyageresult_category_kr(voyageresult_category_kr);
                    aliseon.aliseon_setVoyageresult_nickname(voyageresult_nickname);
                    aliseon.aliseon_setVoyageresult_photo(voyageresult_photo);
                    aliseon.aliseon_setVoyageresult_p_thumbnail(voyageresult_p_thumbnail);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (voyageresultapiload == 0) {

                    aliseon.aliseon_setVoyageResultAPIload(1);
                    voyageresulthandler.sendEmptyMessage(1000);

                } else {

                    voyageresultloadinghandler.sendEmptyMessage(1000);

                }


            }

            @Override
            public void onFailure(Call<VoyageResult> call, Throwable t) {

            }
        });

    }


}
