package com.aliseon.ott.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskTvottVoyageResult;
import com.aliseon.ott.networktask.NetworkTaskRecommendCreator;
import com.bumptech.glide.Glide;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.aliseon.ott.Variable.category_num;
import static com.aliseon.ott.Variable.recommend_contents_cnt;
import static com.aliseon.ott.Variable.recommend_subscribeto_cnt;
import static com.aliseon.ott.Variable.voyageresult_category_en;
import static com.aliseon.ott.Variable.voyageresult_category_id;
import static com.aliseon.ott.Variable.voyageresult_category_kr;
import static com.aliseon.ott.Variable.voyageresult_comment_count;
import static com.aliseon.ott.Variable.voyageresult_contents_id;
import static com.aliseon.ott.Variable.voyageresult_contents_type;
import static com.aliseon.ott.Variable.voyageresult_create_at;
import static com.aliseon.ott.Variable.voyageresult_id;
import static com.aliseon.ott.Variable.voyageresult_like_count;
import static com.aliseon.ott.Variable.voyageresult_product_id;
import static com.aliseon.ott.Variable.voyageresult_status;
import static com.aliseon.ott.Variable.voyageresult_update_at;
import static com.aliseon.ott.Variable.voyageresult_user_id;
import static com.aliseon.ott.Variable.voyageresult_nickname;
import static com.aliseon.ott.Variable.voyageresult_photo;
import static com.aliseon.ott.Variable.voyageresult_description;
import static com.aliseon.ott.Variable.voyageresult_p_thumbnail;
import static com.aliseon.ott.Variable.voyageresult_view_count;
import static com.aliseon.ott.Variable.imageurl;
import static com.aliseon.ott.Variable.keyword;
import static com.aliseon.ott.Variable.recommend_id;
import static com.aliseon.ott.Variable.recommend_nickname;
import static com.aliseon.ott.Variable.recommend_photo;
import static com.aliseon.ott.Variable.voyageresultapiload;
import static com.aliseon.ott.Variable.voyageresultstart;
import static com.aliseon.ott.Variable.api_voyage;
import static com.aliseon.ott.Variable.api_recommend_creator;


public class VoyageResultActivity extends AppCompatActivity {

    private static String TAG = "카테고리 크기";

    TextView TV0;

    public static VoyageResultHandler voyageresulthandler;
    public static VoyageResultLoadingHandler voyageresultloadinghandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_all);

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
                category_num = 0;
                NetworkTaskRecommendCreator networktaskrecommendcreator = new NetworkTaskRecommendCreator(api_recommend_creator, null);
                networktaskrecommendcreator.execute();
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

        voyageresultapiload = 0;

        recommend_id.clear();
        recommend_nickname.clear();
        recommend_photo.clear();
        recommend_subscribeto_cnt.clear();
        recommend_contents_cnt.clear();

        voyageresult_id.clear();
        voyageresult_user_id.clear();
        voyageresult_product_id.clear();
        voyageresult_contents_id.clear();
        voyageresult_contents_type.clear();
        voyageresult_category_id.clear();
        voyageresult_status.clear();
        voyageresult_description.clear();
        voyageresult_create_at.clear();
        voyageresult_update_at.clear();
        voyageresult_like_count.clear();
        voyageresult_view_count.clear();
        voyageresult_comment_count.clear();
        voyageresult_category_en.clear();
        voyageresult_category_kr.clear();
        voyageresult_photo.clear();
        voyageresult_nickname.clear();
        voyageresult_p_thumbnail.clear();

        overridePendingTransition(0, 0);
    }

    @Override
    public void recreate() {
        super.recreate();
    }

    @Override
    public void onResume() {
        super.onResume();

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

                    Glide.with(this).load(imageurl + recommend_photo.get(i)).into(subscribe_image);


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
                            Intent intent = new Intent(VoyageResultActivity.this, CreatorActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                        }
                    });
                }
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
//                              nowurl = imageurl + feedresult_video.get(0);
//                              maintitle = feed_content.get(0);
                                    Intent intent = new Intent(VoyageResultActivity.this, AliseonOTTPlayerActivity.class);
//                                    nowurl = imageurl;
//                                    maintitle = voyageresult_description.get(jjj);
//                                    subtitle = voyageresult_description.get(jjj);
//                                    creatortitle = voyageresult_nickname.get(jjj);
//                                    creatorprofile = imageurl + voyageresult_photo.get(jjj);
//                                    creatorauthorid = voyageresult_user_id.get(jjj);
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
                                    voyageresultstart = voyageresultstart + 12;

                                    category_num = 0;
                                    NetworkTaskTvottVoyageResult networktasktvottvoyageresult = new NetworkTaskTvottVoyageResult(api_voyage, null);
                                    networktasktvottvoyageresult.execute();
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


}
