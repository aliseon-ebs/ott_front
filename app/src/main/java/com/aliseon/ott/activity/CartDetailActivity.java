package com.aliseon.ott.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.aliseon.ott.API.ProductBuy;
import com.aliseon.ott.API.ProductDetail;
import com.aliseon.ott.API.ProductInfo;
import com.aliseon.ott.AdapterSpinner5;
import com.aliseon.ott.AdapterSpinner6;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CartDetailActivity extends AppCompatActivity {

    AliseonAPI AliseonAPI;

    public static CartDetailActivityHandler cartdetailactivityhandler;
//    static CartActivityDetailItemToCartHandler cartactivitydetailitemtocarthandler;

    Spinner spinner;
    AdapterSpinner5 adapterspinner1;
    AdapterSpinner6 adapterspinner2;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_detail);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        int cartdetailapiload = aliseon.aliseon_getCartdetailAPIload();

        if(cartdetailapiload == 0) {

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

            Intent intent = getIntent();

            int select = intent.getExtras().getInt("cartdetail");
            int playerselect = intent.getExtras().getInt("playercartdetail");

//            cartactivitydetailitemtocarthandler = new CartActivityDetailItemToCartHandler();

            cartdetailactivityhandler = new CartDetailActivityHandler();
            cartdetailactivityhandler.post(new Runnable() {
                @Override
                public void run() {

                    ProductInfoPost();

                }
            });

            builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);

            /* Layout Set */
            // Max View
            LinearLayout Layout1 = new LinearLayout(this);

            // Left Icons
            LinearLayout Layout2 = new LinearLayout(this);
            LinearLayout Layout2_1 = new LinearLayout(this);
            LinearLayout Layout2_2 = new LinearLayout(this);
            LinearLayout Layout3 = new LinearLayout(this);
            LinearLayout Layout4 = new LinearLayout(this);
            LinearLayout Layout4_1 = new LinearLayout(this);
            LinearLayout Layout4_1_1 = new LinearLayout(this);
            LinearLayout Layout4_1_2 = new LinearLayout(this);
            LinearLayout Layout4_1_2_1 = new LinearLayout(this);
            LinearLayout Layout4_1_2_2 = new LinearLayout(this);
            LinearLayout Layout4_1_2_3 = new LinearLayout(this);
            LinearLayout Layout4_1_2_4 = new LinearLayout(this);
            LinearLayout Layout4_2 = new LinearLayout(this);
            LinearLayout Layout4_3 = new LinearLayout(this);
            LinearLayout Layout4_3_1 = new LinearLayout(this);
            LinearLayout Layout4_3_2 = new LinearLayout(this);
            LinearLayout Layout5 = new LinearLayout(this);
            LinearLayout Layout5_1 = new LinearLayout(this);
            LinearLayout Layout5_2 = new LinearLayout(this);
            LinearLayout Layout5_3 = new LinearLayout(this);
            LinearLayout Layout5_4 = new LinearLayout(this);
            LinearLayout Layout5_4_1 = new LinearLayout(this);
            LinearLayout Layout5_4_2 = new LinearLayout(this);
            LinearLayout Layout5_5 = new LinearLayout(this);


            ImageView BackArrow = new ImageView(this);
            BackArrow.setFocusableInTouchMode(true);
            BackArrow.setPadding(10, 10, 10, 10);

            Button button = new Button(this);
            button.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            button.setLayoutParams(new ViewGroup.LayoutParams(90, 65));
//        button.setTextColor(Color.rgb(100,100,100));
            button.setTextColor(Color.rgb(255, 255, 255));
            button.setTextSize(10);
//        button.setText("TOP");

            Button button2 = new Button(this);
            button2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 65));
            button2.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            button2.setTextColor(Color.rgb(255, 255, 255));
//        button2.setText(getResources().getString(R.string.add));
            button2.setTextSize(11);
            button2.setId(R.id.cartdetailaddbutton);

            BackArrow.setImageResource(R.drawable.backarrow_b);
            BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);

            ImageView InfoIV = new ImageView(this);
            ImageView InfoIV1 = new ImageView(this);
            ImageView InfoIV2 = new ImageView(this);
            ImageView InfoIV3 = new ImageView(this);
            ImageView InfoIV4 = new ImageView(this);
            ImageView InfoIV11 = new ImageView(this);
            ImageView InfoIV12 = new ImageView(this);
            ImageView InfoIV21 = new ImageView(this);
            ImageView InfoIV22 = new ImageView(this);
            ImageView InfoIV41 = new ImageView(this);

            ScrollView scrollview = new ScrollView(this);
            ScrollView scrollview2 = new ScrollView(this);

            InfoIV.setImageResource(R.drawable.noing_ract);
            InfoIV.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
            InfoIV.setScaleType(ImageView.ScaleType.FIT_CENTER);
            InfoIV1.setImageResource(R.drawable.noing_category);
            InfoIV1.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            InfoIV1.setScaleType(ImageView.ScaleType.FIT_CENTER);
            InfoIV2.setImageResource(R.drawable.noing_category);
            InfoIV2.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            InfoIV2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            InfoIV3.setImageResource(R.drawable.noing_category);
            InfoIV3.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            InfoIV3.setScaleType(ImageView.ScaleType.FIT_CENTER);
            InfoIV4.setImageResource(R.drawable.noing_category);
            InfoIV4.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            InfoIV4.setScaleType(ImageView.ScaleType.FIT_CENTER);
            InfoIV11.setImageResource(R.drawable.noing_ract);
            InfoIV11.setLayoutParams(new ViewGroup.LayoutParams(600, 450));
            InfoIV11.setScaleType(ImageView.ScaleType.FIT_XY);
            InfoIV12.setImageResource(R.drawable.noing_ract);
            InfoIV12.setLayoutParams(new ViewGroup.LayoutParams(600, 450));
            InfoIV12.setScaleType(ImageView.ScaleType.FIT_XY);

            InfoIV21.setImageResource(R.drawable.noing_category);
            InfoIV21.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            InfoIV21.setScaleType(ImageView.ScaleType.FIT_CENTER);
            InfoIV22.setImageResource(R.drawable.noing_category);
            InfoIV22.setLayoutParams(new ViewGroup.LayoutParams(480, 65));
            InfoIV22.setScaleType(ImageView.ScaleType.FIT_XY);
            InfoIV41.setImageResource(R.drawable.noing_category);
            InfoIV41.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
            InfoIV41.setScaleType(ImageView.ScaleType.FIT_CENTER);

            /* params, margin */
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
            LinearLayout.LayoutParams paramsTopButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.5f);
            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);
            LinearLayout.LayoutParams params4_1_1 = new LinearLayout.LayoutParams(250, 250);
            LinearLayout.LayoutParams params4_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);
            LinearLayout.LayoutParams params4_1_2_4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
            LinearLayout.LayoutParams params4_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 20);
            LinearLayout.LayoutParams params4_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4_3_1 = new LinearLayout.LayoutParams(700, 500);
            LinearLayout.LayoutParams params5 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params5_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params5_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 65);
            LinearLayout.LayoutParams params5_3 = new LinearLayout.LayoutParams(480, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params5_3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
            LinearLayout.LayoutParams params5_3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params5_3_2_1 = new LinearLayout.LayoutParams(400, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params5_3_2_2 = new LinearLayout.LayoutParams(40, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params5_3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
            LinearLayout.LayoutParams params5_3_4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
            LinearLayout.LayoutParams params5_4 = new LinearLayout.LayoutParams(480, ViewGroup.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params5_4_1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params5_4_2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 0.5f);
            LinearLayout.LayoutParams params5_5 = new LinearLayout.LayoutParams(480, ViewGroup.LayoutParams.MATCH_PARENT, 1f);


            params4_1.topMargin = 50;
            params4_1_2.leftMargin = 50;
            params4_1_2_4.rightMargin = 70;
//        params4_2.topMargin = 50;
            params4_2.bottomMargin = 50;
//        params4_2.rightMargin = 30;
            params4_1.leftMargin = 30;
//        params4_2.leftMargin = 30;
//        params4_3.leftMargin = 30;
            params4_3_1.topMargin = 50;
            params4_3_1.bottomMargin = 50;
            params5_1.topMargin = 50;
            params5_1.leftMargin = 30;
            params5_2.leftMargin = 30;
            params5_3.leftMargin = 30;
            params5_3.bottomMargin = 30;
            params5_3.topMargin = 30;
            params5_3_4.bottomMargin = 50;
            params5_4.leftMargin = 30;
            params5_4_1.leftMargin = 10;
            params5_4_2.rightMargin = 10;
            params5_5.leftMargin = 30;

            Layout1.setLayoutParams(params);
            Layout1.setOrientation(LinearLayout.HORIZONTAL);

            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setLayoutParams(params2);
            Layout2.setGravity(Gravity.CENTER);
//        Layout2.setBackgroundColor(Color.rgb(244,244,249));
            Layout2_1.setLayoutParams(paramsBackArrow);
            Layout2_1.setGravity(Gravity.CENTER);
            Layout2_1.addView(BackArrow);
            Layout2_2.setLayoutParams(paramsTopButton);
            Layout2_2.setGravity(Gravity.CENTER);
            Layout2_2.addView(button);

            scrollview.setLayoutParams(params3);
            scrollview2.setVerticalScrollBarEnabled(false);

            Layout3.setOrientation(LinearLayout.HORIZONTAL);
            Layout3.setLayoutParams(params);

            Layout4.setLayoutParams(params3);
            Layout5.setLayoutParams(params5);
            Layout4.setOrientation(LinearLayout.VERTICAL);
            Layout4_3.setOrientation(LinearLayout.VERTICAL);
            Layout4_3.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout5.setOrientation(LinearLayout.VERTICAL);

            Layout4_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_1.setLayoutParams(params4_1);
            Layout4_1_1.setLayoutParams(params4_1_1);
            Layout4_1_2.setLayoutParams(params4_1_2);
            Layout4_1_2.setOrientation(LinearLayout.VERTICAL);
            Layout4_1_2_3.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_1_2_4.setLayoutParams(params4_1_2_4);
            Layout4_1_2_4.setBackgroundColor(Color.parseColor("#252526"));

//        Layout4_1_2_1.setLayoutParams(params4_1_2_1);
//        Layout4_1_2_2.setLayoutParams(params4_1_2_1);
//        Layout4_1_2_3.setLayoutParams(params4_1_2_1);
//        Layout4_1_2_4.setLayoutParams(params4_1_2_2);

            Layout4_2.setLayoutParams(params4_2);
            Layout4_2.setBackgroundColor(Color.parseColor("#252526"));
            Layout4_3.setLayoutParams(params4_3);
            Layout4_3_1.setLayoutParams(params4_3_1);
            Layout4_3_2.setLayoutParams(params4_3_1);
            Layout4_3_1.setGravity(Gravity.CENTER);
            Layout4_3_2.setGravity(Gravity.CENTER);

            Layout5_1.setLayoutParams(params5_1);
            Layout5_2.setLayoutParams(params5_2);
            Layout5_3.setLayoutParams(params);
            Layout5_3.setOrientation(LinearLayout.VERTICAL);
            Layout5_4.setLayoutParams(params5_4);
            Layout5_4_1.setLayoutParams(params5_4_1);
            Layout5_4_2.setLayoutParams(params5_4_2);
            Layout5_4_1.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout5_4_2.setGravity(Gravity.RIGHT | Gravity.CENTER);
            Layout5_5.setLayoutParams(params5_5);

            Layout4_3.addView(Layout4_3_1);
            Layout4_3.addView(Layout4_3_2);

            Layout4_3_1.addView(InfoIV11);
            Layout4_3_2.addView(InfoIV12);

            Layout1.addView(Layout2);

            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            Layout1.addView(scrollview);

            scrollview.addView(Layout3);

            Layout4.addView(Layout4_1);
            Layout4.addView(Layout4_2);
            Layout4.addView(Layout4_3);

            Layout4_1.addView(Layout4_1_1);
            Layout4_1.addView(Layout4_1_2);

            Layout4_1_1.addView(InfoIV);
            Layout4_1_2.addView(InfoIV1);
            Layout4_1_2.addView(InfoIV2);
            Layout4_1_2.addView(InfoIV3);
            Layout4_1_2.addView(Layout4_1_2_4);
            Layout4_1_2.addView(InfoIV4);

            Layout3.addView(Layout4);

            Layout5_1.addView(InfoIV21);
            Layout5_2.addView(InfoIV22);

            Layout5.addView(Layout5_1);
            Layout5.addView(Layout5_2);
            Layout5.addView(scrollview2);
            scrollview2.addView(Layout5_3);
            Layout5.addView(Layout5_4);
            Layout5_4.addView(InfoIV41);
            Layout5.addView(Layout5_5);

            for (int i = 0; i < 13; i++) {

                LinearLayout Layout5_3_1 = new LinearLayout(this);

                Layout5_3_1.setOrientation(LinearLayout.HORIZONTAL);
                Layout5_3_1.setLayoutParams(params5_3_2);

                ImageView InfoIV31 = new ImageView(this);
                InfoIV31.setImageResource(R.drawable.noing_category);
                InfoIV31.setLayoutParams(new ViewGroup.LayoutParams(450, 84));
                InfoIV31.setScaleType(ImageView.ScaleType.FIT_XY);

                Layout5_3_1.addView(InfoIV31);
                Layout5_3.addView(Layout5_3_1);

            }

            Layout5_5.setLayoutParams(params5_5);
            Layout5_5.addView(button2);
            Layout1.addView(Layout5);

            setContentView(Layout1);

        }

    }

    @Override
    protected void onResume(){
        super.onResume();

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        int cartdetailapiload = aliseon.aliseon_getCartdetailAPIload();

        ArrayList<String> addoption = aliseon.aliseon_getAddoption();

        ArrayList<ArrayList<String>> cartitemoption = aliseon.aliseon_getCartitemoption();


        String cartdetail_productinfo_desc = aliseon.aliseon_getCartdetail_productinfo_desc();
        String cartdetail_productdetail_thumbnail = aliseon.aliseon_getCartdetail_productdetail_thumbnail();
        String cartdetail_productdetail_title = aliseon.aliseon_getCartdetail_productdetail_title();
        String cartdetail_productdetail_sub_title = aliseon.aliseon_getCartdetail_productdetail_sub_title();
        int cartdetail_productdetail_previous_price = aliseon.aliseon_getCartdetail_productdetail_previous_price();
        int cartdetail_productdetail_complete_price = aliseon.aliseon_getCartdetail_productdetail_complete_price();
        int cartdetail_productdetail_free_shipping = aliseon.aliseon_getCartdetail_productdetail_free_shipping();

        ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_original_value = aliseon.aliseon_getCartdetail_productbuy_p_option_original_value();
        ArrayList<ArrayList<Integer>> cartdetail_productbuy_p_option_original_price = aliseon.aliseon_getCartdetail_productbuy_p_option_original_price();
        ArrayList<String> cartdetail_productbuy_option_name = aliseon.aliseon_getCartdetail_productbuy_option_name();
        ArrayList<Integer> cartdetail_productbuy_option_connection = aliseon.aliseon_getCartdetail_productbuy_option_connection();


        String logincurrency = aliseon.aliseon_getLogincurrency();


        if(cartdetailapiload == 1) {

            Log.d("where", "resume1");

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

            Intent intent = getIntent();

            /* Layout Set */
            // Max View
            LinearLayout Layout1 = new LinearLayout(this);

            // Left Icons
            LinearLayout Layout2 = new LinearLayout(this);
            LinearLayout Layout2_1 = new LinearLayout(this);
            LinearLayout Layout2_2 = new LinearLayout(this);
            LinearLayout Layout3 = new LinearLayout(this);
            LinearLayout Layout3_1 = new LinearLayout(this);
            LinearLayout Layout3_1_1 = new LinearLayout(this);
            LinearLayout Layout3_1_2 = new LinearLayout(this);
            LinearLayout Layout3_1_2_3 = new LinearLayout(this);
            LinearLayout Layout3_1_2_4 = new LinearLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this);
            LinearLayout Layout3_3 = new LinearLayout(this);
            LinearLayout Layout4 = new LinearLayout(this);
            LinearLayout Layout4_1 = new LinearLayout(this);
            LinearLayout Layout4_2 = new LinearLayout(this);
            LinearLayout Layout4_3 = new LinearLayout(this);
            LinearLayout Layout4_4 = new LinearLayout(this);
            LinearLayout Layout4_4_1 = new LinearLayout(this);
            LinearLayout Layout4_4_2 = new LinearLayout(this);
            LinearLayout Layout4_5 = new LinearLayout(this);


            ImageView BackArrow = new ImageView(this);
            BackArrow.setFocusableInTouchMode(true);
            BackArrow.setPadding(10, 10, 10, 10);
            BackArrow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));

            Button button = new Button(this);
            button.setBackground(ContextCompat.getDrawable(this,R.drawable.blackbuttonsetting));
            button.setLayoutParams(new ViewGroup.LayoutParams(90,65));;
            button.setTextColor(Color.rgb(255,255,255));
            button.setTextSize(10);
            button.setText("TOP");

            Button button2 = new Button(this);
            button2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,65));
            button2.setBackground(ContextCompat.getDrawable(this,R.drawable.orderbuttonsetting));
            button2.setTextColor(Color.rgb(255,255,255));
            button2.setText(getResources().getString(R.string.add));
            button2.setTextSize(11);
            button2.setId(R.id.cartdetailaddbutton);

            BackArrow.setImageResource(R.drawable.backarrow);
            BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60,60));
            BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);

            ImageView InfoIV = new ImageView(this);
            TextView InfoTV1 = new TextView(this);
            TextView InfoTV2 = new TextView(this);
            TextView InfoTV3_1 = new TextView(this);
            TextView InfoTV3_2 = new TextView(this);
            TextView InfoTV3_3 = new TextView(this);
            TextView InfoTV4 = new TextView(this);
            Button InfoButton1 = new Button(this);
            Button InfoButton2 = new Button(this);

            TextView DetailTV1 = new TextView(this);
            TextView DetailTV2 = new TextView(this);

            String currency;

            ScrollView scrollview2 = new ScrollView(this);

            WebView webView = new WebView(this);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            // ?????? ??????
            webSettings.setUseWideViewPort(true);       // wide viewport??? ??????????????? ??????
            webSettings.setLoadWithOverviewMode(true);  // ???????????? ???????????? ??? ?????? ????????? ????????? ?????? ??????
            webView.loadData(cartdetail_productinfo_desc , "text/html; charset=UTF-8", null);

            Glide.with(this).load(imageurl + cartdetail_productdetail_thumbnail).into(InfoIV);
            InfoTV1.setText(cartdetail_productdetail_title);
            InfoTV2.setText(cartdetail_productdetail_sub_title);

            InfoIV.setLayoutParams(new ViewGroup.LayoutParams(250,250));
            InfoIV.setScaleType(ImageView.ScaleType.FIT_CENTER);
            InfoTV1.setTextSize(18);
            InfoTV1.setPadding(0,0,0,20);
            InfoTV1.setTextColor(Color.rgb(0,0,0));
            InfoTV2.setTextSize(14);
            InfoTV2.setPadding(0,0,0,20);
            InfoTV2.setTextColor(Color.rgb(0,0,0));
            InfoTV3_1.setText("" + cartdetail_productdetail_previous_price);
            InfoTV3_1.setPaintFlags(InfoTV3_1.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            InfoTV3_1.setTextSize(16);
            InfoTV3_1.setPadding(0,0,0,30);
            InfoTV3_1.setTextColor(Color.rgb(150,150,150));
            InfoTV3_1.setTypeface(Typeface.DEFAULT_BOLD);
            InfoTV3_2.setText("   ???   " + cartdetail_productdetail_complete_price);
            InfoTV3_2.setTextSize(16);
            InfoTV3_2.setPadding(0,0,0,30);
            InfoTV3_2.setTextColor(Color.rgb(204,51,51));
            InfoTV3_2.setTypeface(Typeface.DEFAULT_BOLD);
            currency = logincurrency.toUpperCase();
            InfoTV3_3.setText(" " + currency);
            InfoTV3_3.setTextSize(16);
            InfoTV3_3.setPadding(0,0,0,30);
            InfoTV3_3.setTextColor(Color.rgb(0,0,0));
            InfoTV3_3.setTypeface(Typeface.DEFAULT_BOLD);

//        String string_cartdetail_price;
//        String string_cartdetail_complete_price;
//
//        string_cartdetail_price = Double.toString(cartdetail_price);
//        string_cartdetail_complete_price = Double.toString(cartdetail_complete_price);
//
//        if(string_cartdetail_price.contains(string_cartdetail_complete_price)){
//            InfoTV3_2.setText("" + cartdetail_price + "0");
//            InfoTV3_2.setTextSize(16);
//            InfoTV3_2.setPadding(0,0,0,20);
//            InfoTV3_2.setTextColor(Color.rgb(255,255,255));
//            InfoTV3_2.setTypeface(Typeface.DEFAULT_BOLD);
//        } else {
//            InfoTV3_2.setText("" + cartdetail_price + "0");
//            InfoTV3_2.setPaintFlags(InfoTV3_2.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
//            InfoTV3_2.setTextSize(16);
//            InfoTV3_2.setPadding(0,0,0,20);
//            InfoTV3_2.setTextColor(Color.rgb(150,150,150));
//            InfoTV3_2.setTypeface(Typeface.DEFAULT_BOLD);
//            InfoTV3_3.setTextSize(16);
//            InfoTV3_3.setPadding(0,0,0,20);
//            InfoTV3_3.setTextColor(Color.rgb(255,255,255));
//            InfoTV3_3.setTypeface(Typeface.DEFAULT_BOLD);
//        }


            switch (prf.getString("language", "")) {
                case "kr":
                    InfoTV4.setText(cartdetail_productdetail_free_shipping + " " + logincurrency + " " + getResources().getString(R.string.freedeliv));
                    break;
                case "en":
                    InfoTV4.setText(getResources().getString(R.string.freedeliv) + " " + cartdetail_productdetail_free_shipping + " " + logincurrency);
                    break;
                case "ar":
                    InfoTV4.setText(getResources().getString(R.string.freedeliv) + " " + cartdetail_productdetail_free_shipping + " " + logincurrency);
                    break;
            }
            InfoTV4.setTextSize(14);
            InfoTV4.setPadding(0,10,0,0);
            InfoTV4.setTextColor(Color.rgb(0,0,0));

        DetailTV1.setTextSize(16);
        DetailTV1.setText(getString(R.string.productdetail));
        DetailTV1.setTextColor(Color.rgb(255,255,255));

            TextView InfoTV11 = new TextView(this);
            InfoTV11.setText(getString(R.string.order));
            InfoTV11.setTextSize(18);
            InfoTV11.setTextColor(Color.rgb(255,255,255));

            /* params, margin */
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
            LinearLayout.LayoutParams paramsTopButton= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,0.5f);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,300);
            LinearLayout.LayoutParams params3_1_1 = new LinearLayout.LayoutParams(250,250);
            LinearLayout.LayoutParams params3_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,300);
            LinearLayout.LayoutParams params3_1_2_4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,1);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,20);
            LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,1f);
            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,60);
            LinearLayout.LayoutParams params4_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params4_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,65);
            LinearLayout.LayoutParams params4_3 = new LinearLayout.LayoutParams(480,LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params4_3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params4_3_2_1 = new LinearLayout.LayoutParams(400, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4_3_2_2 = new LinearLayout.LayoutParams(40, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4_3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
            LinearLayout.LayoutParams params4_3_4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
            LinearLayout.LayoutParams params4_4 = new LinearLayout.LayoutParams(480, ViewGroup.LayoutParams.MATCH_PARENT,1f);
            LinearLayout.LayoutParams params4_4_1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1f);
            LinearLayout.LayoutParams params4_4_2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,0.5f);
            LinearLayout.LayoutParams params4_5 = new LinearLayout.LayoutParams(480, ViewGroup.LayoutParams.MATCH_PARENT,1f);


            params3_1.topMargin = 50;
            params3_1_2.leftMargin = 50;
            params3_1_2_4.rightMargin = 70;

            params3_1.leftMargin = 30;
            params4_1.topMargin = 50;
            params4_1.leftMargin = 30;
            params4_2.leftMargin = 30;
            params4_2_1.topMargin = 15;
            params4_2_1.bottomMargin = 15;
            params4_3.leftMargin = 30;
            params4_3.bottomMargin = 30;
            params4_3.topMargin = 30;
            params4_3_4.bottomMargin = 50;
            params4_4.leftMargin = 30;
            params4_4_1.leftMargin = 10;
            params4_4_2.rightMargin = 10;
            params4_5.leftMargin = 30;

            Layout1.setLayoutParams(params);
            Layout1.setOrientation(LinearLayout.HORIZONTAL);

            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setLayoutParams(params2);
            Layout2.setGravity(Gravity.CENTER);
//        Layout2.setBackgroundColor(Color.rgb(244,244,249));
            Layout2_1.setLayoutParams(paramsBackArrow);
            Layout2_1.setGravity(Gravity.CENTER);
            Layout2_1.addView(BackArrow);
            Layout2_2.setLayoutParams(paramsTopButton);
            Layout2_2.setGravity(Gravity.CENTER);
            Layout2_2.addView(button);

            scrollview2.setVerticalScrollBarEnabled(false);
            scrollview2.setLayoutParams(params4_3);
            webView.setLayoutParams(params);

            Layout3.setLayoutParams(params3);
            Layout4.setLayoutParams(params4);
            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3.setBackgroundColor(Color.rgb(255,255,255));
            Layout3_3.setOrientation(LinearLayout.VERTICAL);
            Layout3_3.setGravity(Gravity.TOP);
            Layout4.setOrientation(LinearLayout.VERTICAL);
            Layout4.setBackgroundColor(Color.rgb(62,62,62));

            Layout3_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_1.setLayoutParams(params3_1);
            Layout3_1_1.setLayoutParams(params3_1_1);
            Layout3_1_2.setLayoutParams(params3_1_2);
            Layout3_1_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_1_2_3.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_1_2_4.setLayoutParams(params3_1_2_4);
            Layout3_1_2_4.setBackgroundColor(Color.rgb(200,200,200));

//        Layout4_1_2_1.setLayoutParams(params4_1_2_1);
//        Layout4_1_2_2.setLayoutParams(params4_1_2_1);
//        Layout4_1_2_3.setLayoutParams(params4_1_2_1);
//        Layout4_1_2_4.setLayoutParams(params4_1_2_2);

            Layout3_2.setLayoutParams(params3_2);
            Layout3_2.setBackgroundColor(Color.rgb(240,240,240));
            Layout3_3.setLayoutParams(params3_3);

            Layout4_1.setLayoutParams(params4_1);
            Layout4_2.setLayoutParams(params4_2);
            Layout4_2.setOrientation(LinearLayout.VERTICAL);
            Layout4_3.setLayoutParams(params);
            Layout4_3.setOrientation(LinearLayout.VERTICAL);
            Layout4_4.setLayoutParams(params4_4);
            Layout4_4_1.setLayoutParams(params4_4_1);
            Layout4_4_2.setLayoutParams(params4_4_2);
            Layout4_4_1.setGravity(Gravity.LEFT|Gravity.CENTER);
            Layout4_4_2.setGravity(Gravity.RIGHT|Gravity.CENTER);
            Layout4_5.setLayoutParams(params4_5);

            Layout1.addView(Layout2);

            Layout1.addView(Layout3);

            Layout1.addView(Layout4);

            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            Layout3.addView(Layout3_1);
            Layout3.addView(Layout3_2);
            Layout3.addView(Layout3_3);

            Layout3_1.addView(Layout3_1_1);
            Layout3_1.addView(Layout3_1_2);

            Layout3_1_1.addView(InfoIV);
            Layout3_1_2.addView(InfoTV1);
            Layout3_1_2.addView(InfoTV2);
            Layout3_1_2.addView(Layout3_1_2_3);
            Layout3_1_2.addView(Layout3_1_2_4);
            Layout3_1_2.addView(InfoTV4);

            Layout3_1_2_3.addView(InfoTV3_1);
            Layout3_1_2_3.addView(InfoTV3_2);
            Layout3_1_2_3.addView(InfoTV3_3);

            Layout3_3.addView(webView);

            Layout4_1.addView(InfoTV11);
//            Layout4_2.addView(spinner);

            Layout4.addView(Layout4_1);
            Layout4.addView(Layout4_2);
            Layout4.addView(scrollview2);
            scrollview2.addView(Layout4_3);
            Layout4.addView(Layout4_4);
            Layout4_4.addView(Layout4_4_1);
            Layout4_4.addView(Layout4_4_2);
            Layout4.addView(Layout4_5);

            TextView InfoTV21 = new TextView(this);
            InfoTV21.setTextSize(12);
            InfoTV21.setTextColor(Color.rgb(255, 255, 255));
            if(addoption.size() == 0){
                InfoTV21.setText("0");
            } else {
//                addoptionsize = Integer.toString(addoption.size());
//                InfoTV21.setText(addoptionsize);
            }
            TextView InfoTV22 = new TextView(this);
            InfoTV22.setText(" " + getString(R.string.items));
            InfoTV22.setTextSize(12);
            InfoTV22.setTextColor(Color.rgb(255,255,255));
            TextView InfoTV23 = new TextView(this);
            InfoTV23.setText(getString(R.string.totalprice) + " ");
            InfoTV23.setTextSize(12);
            InfoTV23.setTextColor(Color.rgb(255,255,255));
            TextView InfoTV24 = new TextView(this);
//            InfoTV24.setText(cartdetail_cr_unit + " ");
            InfoTV24.setTextSize(12);
            InfoTV24.setTextColor(Color.rgb(255,255,255));
            TextView InfoTV25 = new TextView(this);
            InfoTV25.setText("00.00");
            InfoTV25.setTextSize(12);
            InfoTV25.setTextColor(Color.rgb(255,255,255));

                for(int ii = 0; ii < cartdetail_productbuy_p_option_original_value.size(); ii++){

                    LinearLayout Layout4_2_1 = new LinearLayout(this);
                    Layout4_2_1.setLayoutParams(params4_2_1);
                    Layout4_2_1.setOrientation(LinearLayout.VERTICAL);

                    ArrayList<String> option = new ArrayList<>();
                    option.add(cartdetail_productbuy_option_name.get(ii));

                    //?????????

                    for(int iii = 0; iii < cartdetail_productbuy_p_option_original_value.get(ii).size(); iii++){

                        option.add(cartdetail_productbuy_p_option_original_value.get(ii).get(iii) + " (+" + cartdetail_productbuy_p_option_original_price.get(ii).get(iii) + ")");
                        }

                    if(ii > 0 && cartdetail_productbuy_option_connection.get(ii) == cartdetail_productbuy_option_connection.get(ii - 1)){

                        adapterspinner2 = new AdapterSpinner6(this, option);

                        spinner = new Spinner(this);
                        spinner.setId(100 + ii);
                        Log.d("?????????", "" + spinner.getId());
                        spinner.setBackground(ContextCompat.getDrawable(this, R.drawable.disablespinnersetting));
                        spinner.setLayoutParams(new ViewGroup.LayoutParams(480, 65));
                        spinner.setAdapter(adapterspinner2);
                        spinner.setSelection(0, false);
                        spinner.setEnabled(false);

                    } else if(ii > 0 && cartdetail_productbuy_option_connection.get(ii) != cartdetail_productbuy_option_connection.get(ii - 1)) {

                        adapterspinner1 = new AdapterSpinner5(this, option);

                        spinner = new Spinner(this);
                        spinner.setId(100 + ii);
                        Log.d("?????????", "" + spinner.getId());
                        spinner.setBackground(ContextCompat.getDrawable(this, R.drawable.spinnersetting));
                        spinner.setLayoutParams(new ViewGroup.LayoutParams(480, 65));
                        spinner.setAdapter(adapterspinner1);
                        spinner.setSelection(0, false);
                        spinner.setEnabled(true);

                        final int j = ii;

                        // ????????? ????????? ?????? ( ????????? = setOnItemSelectedListener ??????)
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override   // position ?????? ????????? ?????? ??????????????? ?????? ????????????
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                Log.d("?????????", "" + position);
                                if(position != 0){

                                    spinner.findViewById(100 + j);
                                    spinner.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.spinnersetting));
                                    spinner.setAdapter(adapterspinner1);
                                    spinner.setEnabled(true);

                                } else {

                                    spinner.findViewById(100 + j);
                                    Log.d("?????????", "" + spinner.getId());
                                    spinner.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.disablespinnersetting));
                                    spinner.setAdapter(adapterspinner2);
                                    spinner.setEnabled(false);

                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                    } else {

                        adapterspinner1 = new AdapterSpinner5(this, option);

                        spinner = new Spinner(this);
                        spinner.setId(100 + ii);
                        Log.d("?????????", "" + spinner.getId());
                        spinner.setBackground(ContextCompat.getDrawable(this, R.drawable.spinnersetting));
                        spinner.setLayoutParams(new ViewGroup.LayoutParams(480, 65));
                        spinner.setAdapter(adapterspinner1);
                        spinner.setSelection(0, false);
                        spinner.setEnabled(true);

                    }

//
//            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override   // position ?????? ????????? ?????? ??????????????? ?????? ????????????
//                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                    int compareresult = 0; // ?????? ????????? ????????? ???????????? ?????? ???
//                    for (int i = 0; i < cartitemoption.size(); i++) {
//
////                        if (cartitemoption.get(i).get(0).equals(cartdetail_id)
////                                && cartitemoption.get(i).get(2).equals(cartdetail_opt_item_name.get(position - 1))
////                                && cartitemoption.get(i).get(3).equals(cartdetail_cr_unit)
////                                && cartitemoption.get(i).get(4).equals(cartdetail_opt_price.get(position - 1))) {
////                            // ?????? ?????? ?????? ????????? ?????? ????????? ????????? 1 ??????
////                            compareresult = 1;
////
////                            cartitemoption.get(i).set(5, String.valueOf(Integer.valueOf(cartitemoption.get(i).get(5)) + 1));
////                        }
//                    }
//
//                    // ?????? ????????? ?????? ??????
//                    if (compareresult == 0) {
//                        ArrayList<String> itemoption = new ArrayList<>();
//                        int cartitem_count = 1;
////                        addoption.add(cartdetail_opt_item_name.get(position - 1) + " " + cartdetail_cr_unit + " " + cartdetail_opt_price.get(position - 1));
//
//                        // ???????????? ?????? : ?????? ID > ?????? ?????? ID > ?????? ?????? ?????? >  ?????? ?????? ??????(???????) > ?????? ?????? ?????? > ?????? ?????? ?????? > ?????? ?????? ?????? ??????
////                        itemoption.add(cartdetail_id);
////                        itemoption.add(cartdetail_opt_optid.get(position - 1));
////                        itemoption.add(cartdetail_opt_item_name.get(position - 1));
////                        itemoption.add(cartdetail_cr_unit);
////                        itemoption.add(cartdetail_opt_price.get(position - 1));
////                        itemoption.add(String.valueOf(cartitem_count));
////                        cartitemoption.add(itemoption);
////                        Log.d("?????? ?????????", String.valueOf(itemoption));
//                    }
//
//                    Log.d("CartActivityDetailTest", String.valueOf(addoption));
//                    Log.d("CartActivityDetailTest", String.valueOf(cartitemoption));
//                    onResume();
//                    spinner.requestFocus();
//
//                }
//                @Override
//                public void onNothingSelected(AdapterView<?> parent) {
//
//                    onResume();
//                    spinner.requestFocus();
//
//                }
//            });
                    Layout4_2_1.addView(spinner);
                    Layout4_2.addView(Layout4_2_1);

                }

            // ?????? ??????
            double A = 0;
            for (int i = 0; i < cartitemoption.size(); i++) {
                double B = Double.valueOf(cartitemoption.get(i).get(4))*Integer.valueOf(cartitemoption.get(i).get(5));
                A = A + B;
                InfoTV25.setText(String.valueOf(A));
            }

            for(int i = 0; i < addoption.size(); i++){

                LinearLayout Layout5_3_2 = new LinearLayout(this);
                LinearLayout Layout5_3_2_1 = new LinearLayout(this);
                LinearLayout Layout5_3_2_2 = new LinearLayout(this);
                LinearLayout Layout5_3_2_3 = new LinearLayout(this);
                Layout5_3_2.setOrientation(LinearLayout.HORIZONTAL);
                Layout5_3_2.setLayoutParams(params4_3_2);
                Layout5_3_2_1.setLayoutParams(params4_3_2_1);
                Layout5_3_2_2.setLayoutParams(params4_3_2_2);
                Layout5_3_2_2.setGravity(Gravity.CENTER);
                Layout5_3_2_3.setLayoutParams(params4_3_2_2);
                Layout5_3_2_3.setGravity(Gravity.CENTER);
                TextView TV = new TextView(this);
                TextView TVcount = new TextView(this);
//            EditText TVcount = new EditText(this);

                TV.setText(cartitemoption.get(i).get(2) + "  ( + " + cartitemoption.get(i).get(3) + " " + cartitemoption.get(i).get(4) + " )");
                TV.setTextSize(11);
                TV.setTextColor(Color.rgb(255,255,255));
                TV.setPadding(10,10,10,10);

                TVcount.setText(cartitemoption.get(i).get(5));
                TVcount.setTextSize(11);
                TVcount.setSingleLine(true);
                TVcount.setTextColor(Color.rgb(255,255,255));
                TVcount.setPadding(10,10,10,10);

                ImageView IV = new ImageView(this);
                IV.setLayoutParams(new ViewGroup.LayoutParams(30,30));
                IV.setImageResource(R.drawable.cancel);
                IV.setFocusableInTouchMode(true);

                Layout5_3_2_1.addView(TV);
                Layout5_3_2_2.addView(TVcount);
                Layout5_3_2_3.addView(IV);

                Layout5_3_2.addView(Layout5_3_2_1);
                Layout5_3_2.addView(Layout5_3_2_2);
                Layout5_3_2.addView(Layout5_3_2_3);

                LinearLayout Layout5_3_3 = new LinearLayout(this);
                Layout5_3_3.setBackgroundColor(Color.rgb(50,50,50));
                Layout5_3_3.setLayoutParams(params4_3_3);

                Layout4_3.addView(Layout5_3_2);
                Layout4_3.addView(Layout5_3_3);

                int j = i;
                TVcount.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        // ???????????? ???????????? ????????? ?????? ??????
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // ????????? ????????? ??????
                        String itemcount = TVcount.getText().toString();
                        cartitemoption.get(j).set(4, itemcount);

                        Log.d("CHANGED", String.valueOf(cartitemoption));
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        // ???????????? ???
                    }
                });

                IV.setOnFocusChangeListener(new View.OnFocusChangeListener() { // ???????????? ?????????

                    @Override
                    public void onFocusChange(View v, boolean hasFocus) { // ???????????? ???????????? ???????????? ?????????
                        if (hasFocus == false) {

                            Layout5_3_2.setBackground(null);
                            TV.setTextColor(Color.rgb(255,255,255));
                            TVcount.setTextColor(Color.rgb(255,255,255));

                        } else {

                            Layout5_3_2.setBackgroundColor(Color.rgb(255,255,255));
                            TV.setTextColor(Color.rgb(0,0,0));
                            TVcount.setTextColor(Color.rgb(0,0,0));

                        }
                    }
                });

                if(i == addoption.size() - 1){
                    Layout5_3_2.setNextFocusDownId(R.id.cartdetailaddbutton);
                    IV.setNextFocusDownId(R.id.cartdetailaddbutton);
                }

                final int ii = i;

                IV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        addoption.remove(ii);
                        cartitemoption.remove(ii);
                        onResume();

                    }
                });

            }

            Layout4_4_1.addView(InfoTV21);
            Layout4_4_1.addView(InfoTV22);
            Layout4_4_2.addView(InfoTV23);
            Layout4_4_2.addView(InfoTV24);
            Layout4_4_2.addView(InfoTV25);

            BackArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    cartdetail_result_optid.clear();
//                    cartdetail_result_item_name.clear();
//                    cartdetail_result_item_price.clear();
//                    cartdetail_result_item_count.clear();
//                    cartdetail_result_item_total.clear();
//
//                    for (int i = 0; i < cartitemoption.size(); i++) {
//                        cartdetail_result_optid.add(Integer.parseInt(cartitemoption.get(i).get(1)));
//                        cartdetail_result_item_name.add("\"" + cartitemoption.get(i).get(2) + "\"");
//                        cartdetail_result_item_price.add(Double.valueOf(cartitemoption.get(i).get(4)));
//                        cartdetail_result_item_count.add(Integer.valueOf(cartitemoption.get(i).get(5)));
//                        cartdetail_result_item_total.add(Double.valueOf(cartitemoption.get(i).get(4))*Integer.valueOf(cartitemoption.get(i).get(5)));
//                    }
//
//                    Log.d("Result Item ID", String.valueOf(cartdetail_result_optid));
//                    Log.d("Result Item Name", String.valueOf(cartdetail_result_item_name));
//                    Log.d("Result Item Price", String.valueOf(cartdetail_result_item_price));
//                    Log.d("Result Item Count", String.valueOf(cartdetail_result_item_count));
//                    Log.d("Result Item Total Price", String.valueOf(cartdetail_result_item_total));

//                    cartactivitydetailitemtocarthandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            NetworkTaskItemTocart networktaskitemtocart = new NetworkTaskItemTocart(api_item_tocart, null);
//                            networktaskitemtocart.execute();
//                        }
//                    });

                }
            });

            Layout4_5.setLayoutParams(params4_5);
            Layout4_5.addView(button2);

            setContentView(Layout1);

        }

    }



    @Override
    public void onBackPressed() {
        Aliseon aliseon = (Aliseon) getApplicationContext();

        aliseon.aliseon_setCartAPIload(0);
        aliseon.aliseon_setCartdetailAPIload(0);

//        cartapiload = 0;
//        cartdetailapiload = 0;
        super.onBackPressed();
        overridePendingTransition(0,0);
    }

    @Override
    public void recreate() {
        super.recreate();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        overridePendingTransition(0,0);
    }



    public class CartDetailActivityHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // ?????? Thread?????? ???????????? Message ??????
            if (msg.what == 1000) {
                onResume();
            }
        }
    }

    class CartActivityDetailItemToCartHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {

            Aliseon aliseon = (Aliseon) getApplicationContext();
            ArrayList<String> addoption = aliseon.aliseon_getAddoption();

            // ?????? Thread?????? ???????????? Message ??????
            if (msg.what == 1000) {
                if (addoption.size() == 0) {

                    builder.setTitle(getResources().getString(R.string.noaddcartitem));

                    builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

                        @Override
                        public void onShow(DialogInterface dialog) {

                            Button positive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                            positive.requestFocus();
                        }
                    });
                    alertDialog.show();

                } else {

                    builder.setTitle(getResources().getString(R.string.addcartitem));

                    builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

                    builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            aliseon.aliseon_setCartAPIload(0);
                            aliseon.aliseon_setCartdetailAPIload(0);
                            Intent intent = new Intent(CartDetailActivity.this, CartActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

                        @Override
                        public void onShow(DialogInterface dialog) {

                            Button positive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                            positive.requestFocus();
                        }
                    });
                    alertDialog.show();

                }
            }
        }
    }

    private void ProductInfoPost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        String product_id = aliseon.aliseon_getParam_product_id();
        String lang = aliseon.aliseon_getLoginlanguage();
        String currency = aliseon.aliseon_getLogincurrency();

        Log.d("APIRUNNING", "==================================================================");
        Log.d("APIRUNNING", "==================================================================");
        Log.d("APIRUNNING", "API NAME : ProductInfoPost");
        Log.d("APIRUNNING", "DATA : " + access_token + " / " + product_id + " / " + lang + " / " + currency);
        Log.d("APIRUNNING", "==================================================================");
        Log.d("APIRUNNING", "==================================================================");

        Call<ProductInfo> call = AliseonAPI.ProductInfoPost(access_token, product_id, lang,currency);

        call.enqueue(new Callback<ProductInfo>() {
            @Override
            public void onResponse(Call<ProductInfo> call, Response<ProductInfo> response) {

                int cartdetailapiload = aliseon.aliseon_getCartdetailAPIload();

                ProductInfo postResponse = (ProductInfo) response.body();

                int id = postResponse.getList().get(0).getId();
                String desc = postResponse.getList().get(0).getDesc();

                aliseon.aliseon_setCartdetail_productinfo_id(id);
                aliseon.aliseon_setCartdetail_productinfo_desc(desc);

                if (cartdetailapiload == 0) {
                    ProductDetailPost();

                } else if (cartdetailapiload == 1) {
                    cartdetailactivityhandler.sendEmptyMessage(800);

                }

            }

            @Override
            public void onFailure(Call<ProductInfo> call, Throwable t) {

            }
        });

    }

    private void ProductDetailPost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        String product_id = aliseon.aliseon_getParam_product_id();
        String lang = aliseon.aliseon_getLoginlanguage();
        String currency = aliseon.aliseon_getLogincurrency();

        Log.d("APIRUNNING", "==================================================================");
        Log.d("APIRUNNING", "==================================================================");
        Log.d("APIRUNNING", "API NAME : ProductDetailPost");
        Log.d("APIRUNNING", "DATA : " + access_token + " / " + product_id + " / " + lang + " / " + currency);
        Log.d("APIRUNNING", "==================================================================");
        Log.d("APIRUNNING", "==================================================================");

        Call<ProductDetail> call = AliseonAPI.ProductDetailPost(access_token, product_id, lang,currency);

        call.enqueue(new Callback<ProductDetail>() {
            @Override
            public void onResponse(Call<ProductDetail> call, Response<ProductDetail> response) {

                int cartdetailapiload = aliseon.aliseon_getCartdetailAPIload();

                ProductDetail postResponse = (ProductDetail) response.body();

                int id = postResponse.getList().get(0).getId();
                int vendor_id = postResponse.getList().get(0).getVendorId();
                String thumbnail = postResponse.getList().get(0).getThumbnail();
                String title = postResponse.getList().get(0).getName();
                String sub_title = postResponse.getList().get(0).getSubName();
                int previous_price = postResponse.getList().get(0).getPreviousPrice();
                int complete_price = postResponse.getList().get(0).getCompletePrice();
                int basic_shipping = postResponse.getList().get(0).getBasicShipping();
                int free_shipping = postResponse.getList().get(0).getFreeShipping();

                aliseon.aliseon_setCartdetail_productdetail_id(id);
                aliseon.aliseon_setCartdetail_productdetail_vendor_id(vendor_id);
                aliseon.aliseon_setCartdetail_productdetail_thumbnail(thumbnail);
                aliseon.aliseon_setCartdetail_productdetail_title(title);
                aliseon.aliseon_setCartdetail_productdetail_sub_title(sub_title);
                aliseon.aliseon_setCartdetail_productdetail_previous_price(previous_price);
                aliseon.aliseon_setCartdetail_productdetail_complete_price(complete_price);
                aliseon.aliseon_setCartdetail_productdetail_basic_shipping(basic_shipping);
                aliseon.aliseon_setCartdetail_productdetail_free_shipping(free_shipping);

                if (cartdetailapiload == 0) {
                    ProductBuyPost();

                } else if (cartdetailapiload == 1) {
                    cartdetailactivityhandler.sendEmptyMessage(800);

                }


            }

            @Override
            public void onFailure(Call<ProductDetail> call, Throwable t) {

            }
        });

    }

    private void ProductBuyPost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        String product_id = aliseon.aliseon_getParam_product_id();

        Log.d("APIRUNNING", "==================================================================");
        Log.d("APIRUNNING", "==================================================================");
        Log.d("APIRUNNING", "API NAME : ProductBuyPost");
        Log.d("APIRUNNING", "DATA : " + access_token + " / " + product_id);
        Log.d("APIRUNNING", "==================================================================");
        Log.d("APIRUNNING", "==================================================================");

        Call<ProductBuy> call = AliseonAPI.ProductBuyPost(access_token, product_id);

        call.enqueue(new Callback<ProductBuy>() {
            @Override
            public void onResponse(Call<ProductBuy> call, Response<ProductBuy> response) {

                int cartdetailapiload = aliseon.aliseon_getCartdetailAPIload();

                ProductBuy postResponse = (ProductBuy) response.body();

                ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_name = new ArrayList<>();
                ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_original_value = new ArrayList<>();
                ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_original_price = new ArrayList<>();
                ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_value = new ArrayList<>();
                ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_price = new ArrayList<>();
                ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_stock = new ArrayList<>();

                for ( int i = 0; i < postResponse.getList().size(); i++ ) {

                    ArrayList<String> cartdetail_productbuy_c_option_value = new ArrayList<>();
                    ArrayList<String> cartdetail_productbuy_c_option_price = new ArrayList<>();
                    ArrayList<String> cartdetail_productbuy_c_option_stock = new ArrayList<>();

                    ArrayList<String> name = postResponse.getList().get(i).getName();
                    ArrayList<String> originalPrice = postResponse.getList().get(i).getOriginalPrice();
                    ArrayList<String> originalValue = postResponse.getList().get(i).getOriginalValue();
                    ArrayList<String> value = postResponse.getList().get(i).getValue();
                    ArrayList<String> price = postResponse.getList().get(i).getPrice();
                    ArrayList<String> stock = postResponse.getList().get(i).getStock();

                    try {

                        cartdetail_productbuy_p_option_name.add(name);
                        cartdetail_productbuy_p_option_original_value.add(originalValue);
                        cartdetail_productbuy_p_option_original_price.add(originalPrice);
                        cartdetail_productbuy_p_option_value.add(value);
                        cartdetail_productbuy_p_option_price.add(price);
                        cartdetail_productbuy_p_option_stock.add(stock);

                    } catch (Exception e) {
                        e.printStackTrace();

                        Log.d("APIERROR", "ERROR FROM Product/Buy");
                        Log.d("APIERROR", "VALUE CHECK IN THIS");
                        Log.d("APIERROR", String.valueOf(name));
                        Log.d("APIERROR", String.valueOf(originalValue));
                        Log.d("APIERROR", String.valueOf(originalPrice));
                        Log.d("APIERROR", String.valueOf(value));
                        Log.d("APIERROR", String.valueOf(price));
                        Log.d("APIERROR", String.valueOf(stock));


                    }



                }



                if (cartdetailapiload == 0) {

//                    cartdetailapiload = 1;
                    aliseon.aliseon_setCartdetailAPIload(1);
                    cartdetailactivityhandler.sendEmptyMessage(1000);


                } else if (cartdetailapiload == 1) {
                    cartdetailactivityhandler.sendEmptyMessage(800);

                }


            }

            @Override
            public void onFailure(Call<ProductBuy> call, Throwable t) {

            }
        });

    }

}
