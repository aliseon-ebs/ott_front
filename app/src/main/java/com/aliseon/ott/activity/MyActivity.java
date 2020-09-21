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

import com.aliseon.ott.CircleImageView;
import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskMyInfo;
import com.aliseon.ott.networktask.NetworkTaskMyList;
import com.bumptech.glide.Glide;

import java.util.Locale;

import static com.aliseon.ott.Variable.api_my_info;
import static com.aliseon.ott.Variable.api_my_list;
import static com.aliseon.ott.Variable.my_list_description;
import static com.aliseon.ott.Variable.my_list_id;
import static com.aliseon.ott.Variable.my_list_nickname;
import static com.aliseon.ott.Variable.my_list_p_thumbnail;
import static com.aliseon.ott.Variable.my_list_profile;
import static com.aliseon.ott.Variable.my_list_view_count;
import static com.aliseon.ott.Variable.my_subscribeto_cnt;
import static com.aliseon.ott.Variable.myapiload;
import static com.aliseon.ott.Variable.imageurl;
import static com.aliseon.ott.Variable.my_desc;
import static com.aliseon.ott.Variable.my_nickname;
import static com.aliseon.ott.Variable.mystart;
import static com.aliseon.ott.Variable.mylimit;

public class MyActivity extends AppCompatActivity {

    private static String TAG = "현재 url 가져오기";

    CircleImageView My;

    public static MyActivityHandler myactivityhandler;
    public static MyActivityContentsLoadingHandler myactivitycontentsloadinghandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (myapiload == 0) {

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

            myactivityhandler = new MyActivityHandler();
            myactivitycontentsloadinghandler = new MyActivityContentsLoadingHandler();

            myactivityhandler.post(new Runnable() {
                @Override
                public void run() {
                    NetworkTaskMyInfo networktaskmyinfo = new NetworkTaskMyInfo(api_my_info, null);
                    networktaskmyinfo.execute();
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
            LinearLayout Layout3_1 = new LinearLayout(this);
            LinearLayout Layout3_1_1 = new LinearLayout(this);
            LinearLayout Layout3_1_2 = new LinearLayout(this);
            LinearLayout Layout3_1_2_1 = new LinearLayout(this);
            LinearLayout Layout3_1_2_2 = new LinearLayout(this);
            LinearLayout Layout3_1_2_3 = new LinearLayout(this);
            LinearLayout Layout3_1_3 = new LinearLayout(this);
            LinearLayout Layout3_1_3_1 = new LinearLayout(this);
            LinearLayout Layout3_1_3_2 = new LinearLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this);

            ScrollView scrollview = new ScrollView(this);

            scrollview.setVerticalScrollBarEnabled(false);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            ImageView Home = new ImageView(this);
            Home.setFocusableInTouchMode(true);
            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Search = new ImageView(this);
            Search.setFocusableInTouchMode(true);
            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView User = new ImageView(this);
            User.setFocusableInTouchMode(true);
            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Cart = new ImageView(this);
            Cart.setFocusableInTouchMode(true);
            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            My = new CircleImageView(this);
            My.setFocusableInTouchMode(true);
            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Setting = new ImageView(this);
            Setting.setFocusableInTouchMode(true);
            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            CircleImageView Profile = new CircleImageView(this);
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            Cart.setPadding(15, 15, 15, 15);
//        My.setPadding(15,15,15,15);
            Setting.setPadding(15, 15, 15, 15);

            Home.setImageResource(R.drawable.home);
            Search.setImageResource(R.drawable.search);
            User.setImageResource(R.drawable.user);
            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Cart.setId(R.id.eventcart);
            Cart.setImageResource(R.drawable.cart);
            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Layout2_1_5.setId(R.id.my);
            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));

            if (prf.getString("userinfo_picture", "").equals("empty")) {
                My.setImageResource(R.drawable.noimg_profile);
            } else {
                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(My);
            }

            Setting.setImageResource(R.drawable.setting);
            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Profile.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            Profile.setPadding(20, 20, 20, 20);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);
            LinearLayout.LayoutParams params3_1_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.66f);
            LinearLayout.LayoutParams params3_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params3_1_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params3_1_3_1 = new LinearLayout.LayoutParams(250, 70);
            LinearLayout.LayoutParams params3_1_3_2 = new LinearLayout.LayoutParams(180, 70);
            LinearLayout.LayoutParams params3_1_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50);
            LinearLayout.LayoutParams params3_1_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 70);
            LinearLayout.LayoutParams params3_1_2_3 = new LinearLayout.LayoutParams(1400, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 420);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

            paramsMainLayout.leftMargin = 15;
            paramsMainLayout.rightMargin = 15;
            paramsMainLayout.bottomMargin = 20;
            paramsTitleTV.bottomMargin = 10;
            params3_1_1.leftMargin = 10;
            params3_1_2_1.bottomMargin = 50;
            params3_1_2_2.bottomMargin = 15;
            params3_1_2_3.topMargin = 20;
            params3_1_3_1.rightMargin = 20;
            params3_1_3_2.rightMargin = 20;

            params3_3.setMargins(0, 0, 0, 30);

            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());

            margin.setMargins(10, 20, 5, 20);
            margin2.setMargins(10, 20, 5, 20);
            margin3.setMargins(10, 20, 5, 20);
            margin4.setMargins(10, 20, 5, 20);
            margin5.setMargins(0, 20, 5, 20);
            margin6.setMargins(10, 20, 20, 20);

            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout2.setLayoutParams(params2);
            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));

            Layout2_1.setLayoutParams(params2_1);

            Layout2_2.setLayoutParams(params2_1);
            Layout2_2.setGravity(Gravity.BOTTOM);

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

            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3.setLayoutParams(params3);
            Layout3_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_1.setLayoutParams(params3_1);
            Layout3_1.setPadding(15, 0, 0, 0);
//        Layout3_1.setBackgroundColor(Color.rgb(0,0,0));

            Layout3_1_3.setLayoutParams(params3_1_3);

            scrollview.setLayoutParams(params);

            Layout3_1_1.setLayoutParams(params3_1_1);
            Layout3_1_2.setLayoutParams(params3_1_2);

            Home.setId(R.id.subscribehome);
            Search.setId(R.id.subscribesearch);
            User.setId(R.id.subscribeuser);

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

            Layout3_1_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_1_2_3.setOrientation(LinearLayout.HORIZONTAL);

            Layout3_1_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
            Layout3_1_2_3.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_2_3.setGravity(Gravity.LEFT | Gravity.TOP);

            Layout2_2.addView(Layout2_2_1);

            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

                Layout3.addView(Layout3_1);

                ImageView My2 = new ImageView(this);
                My2.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
                My2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.noing_ract_shape));

                ImageView IV1 = new ImageView(this);
                ImageView IV2 = new ImageView(this);

                IV1.setImageResource(R.drawable.noing_category);
                IV1.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
                IV1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                IV2.setImageResource(R.drawable.noing_category);
                IV2.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
                IV2.setScaleType(ImageView.ScaleType.FIT_CENTER);

                Button button1 = new Button(this);
                button1.setBackground(ContextCompat.getDrawable(this, R.drawable.noingbutton));
                button1.setLayoutParams(new ViewGroup.LayoutParams(250, 70));

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MyActivity.this, MyDetailActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                    }
                });

                ImageView IVContents = new ImageView(this);
                IVContents.setImageResource(R.drawable.noing_category);
                IVContents.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
                IVContents.setScaleType(ImageView.ScaleType.FIT_CENTER);

                Layout3_1_2_1.setLayoutParams(params3_1_2_2);
                Layout3_1_2_2.setLayoutParams(params3_1_2_2);
                Layout3_1_2_3.setLayoutParams(params3_1_2_3);
                Layout3_1_3_1.setLayoutParams(params3_1_3_1);
                Layout3_1_3_2.setLayoutParams(params3_1_3_2);

                Layout3_1_1.setGravity(Gravity.LEFT | Gravity.CENTER);
                Layout3_1_2.setGravity(Gravity.LEFT | Gravity.CENTER);
                Layout3_1_3.setGravity(Gravity.RIGHT | Gravity.CENTER);

                Layout3_1_3_1.setGravity(Gravity.RIGHT | Gravity.CENTER);
                Layout3_1_3_2.setGravity(Gravity.RIGHT | Gravity.CENTER);

                Layout3_1_1.addView(My2);
                Layout3_1.addView(Layout3_1_1);

                Layout3_1_2_1.addView(IV1);
                Layout3_1_2_2.addView(IV2);
//        Layout3_1_2_3.addView(TV3_1);
//        Layout3_1_2_3.addView(TV3_2);

                Layout3_1_2.addView(Layout3_1_2_1);
                Layout3_1_2.addView(Layout3_1_2_2);
//        Layout3_1_2.addView(Layout3_1_2_3);
                Layout3_1.addView(Layout3_1_2);

                Layout3_1_3.addView(Layout3_1_3_1);

                Layout3_1_3_1.addView(button1);

                Layout3_1.addView(Layout3_1_3);

                Layout3_2.setLayoutParams(params3_2);
                Layout3_2.addView(IVContents);
                Layout3_2.setGravity(Gravity.LEFT | Gravity.CENTER);

                Layout3.addView(Layout3_2);

                for (int i = 0; i < 2; i++) {
                    LinearLayout Layout3_3 = new LinearLayout(this);
                    Layout3_3.setLayoutParams(params3_3);
                    Layout3_3.setGravity(Gravity.CENTER);
                    Layout3.addView(Layout3_3);

                    for (int ii = 0; ii < 4; ii++) {
                        LinearLayout Layout3_3_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1 = new LinearLayout(this);

                        Layout3_3_1.setGravity(Gravity.CENTER);
                        ImageView IV11 = new ImageView(this);

                        IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 486));
                        IV11.setImageResource(R.drawable.noing_layout);

                        Layout3_3_1_1.setOrientation(LinearLayout.VERTICAL);
                        Layout3_3_1_1.setLayoutParams(paramsMainLayout);

                        Layout3_3_1_1.addView(IV11);
                        Layout3_3_1.addView(Layout3_3_1_1);
                        Layout3_3.addView(Layout3_3_1);

                    }
                }

                Layout1.addView(Layout3);

                setContentView(Layout1);

                My.requestFocus();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(myapiload == 1) {

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
            LinearLayout Layout3_1 = new LinearLayout(this);
            LinearLayout Layout3_1_1 = new LinearLayout(this);
            LinearLayout Layout3_1_2 = new LinearLayout(this);
            LinearLayout Layout3_1_2_1 = new LinearLayout(this);
            LinearLayout Layout3_1_2_2 = new LinearLayout(this);
            LinearLayout Layout3_1_2_3 = new LinearLayout(this);
            LinearLayout Layout3_1_3 = new LinearLayout(this);
            LinearLayout Layout3_1_3_1 = new LinearLayout(this);
            LinearLayout Layout3_1_3_2 = new LinearLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this);
            LinearLayout Layout3_3 = new LinearLayout(this);

            ScrollView scrollview = new ScrollView(this);

            scrollview.setVerticalScrollBarEnabled(false);

            ProgressBar progressbar = new ProgressBar(this);
            progressbar.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            progressbar.setVisibility(View.GONE);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            ImageView Home = new ImageView(this);
            Home.setFocusableInTouchMode(true);
            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Search = new ImageView(this);
            Search.setFocusableInTouchMode(true);
            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView User = new ImageView(this);
            User.setFocusableInTouchMode(true);
            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Cart = new ImageView(this);
            Cart.setFocusableInTouchMode(true);
            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            My = new CircleImageView(this);
            My.setFocusableInTouchMode(true);
            My.setId(R.id.my);
            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Setting = new ImageView(this);
            Setting.setFocusableInTouchMode(true);
            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            CircleImageView Profile = new CircleImageView(this);
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            Cart.setPadding(15, 15, 15, 15);
            My.setPadding(15, 15, 15, 15);
            Setting.setPadding(15, 15, 15, 15);

            Home.setImageResource(R.drawable.home);
            Search.setImageResource(R.drawable.search);
            User.setImageResource(R.drawable.user);
            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Cart.setId(R.id.eventcart);
            Cart.setImageResource(R.drawable.cart);
            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));

            if (prf.getString("userinfo_picture", "").equals("empty")) {
                My.setImageResource(R.drawable.noimg_profile);
            } else {
                Glide.with(this).load(imageurl + prf.getString("userinfo_picture", "")).into(My);
            }

            Setting.setImageResource(R.drawable.setting);
            Setting.setId(R.id.setting);
            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Profile.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            Profile.setPadding(20, 20, 20, 20);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);
            LinearLayout.LayoutParams params3_1_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.66f);
            LinearLayout.LayoutParams params3_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params3_1_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params3_1_3_1 = new LinearLayout.LayoutParams(250, 70);
            LinearLayout.LayoutParams params3_1_3_2 = new LinearLayout.LayoutParams(180, 70);
            LinearLayout.LayoutParams params3_1_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50);
            LinearLayout.LayoutParams params3_1_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 70);
            LinearLayout.LayoutParams params3_1_2_3 = new LinearLayout.LayoutParams(1400, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 420);
            LinearLayout.LayoutParams params3_6 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,456);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

            paramsMainLayout.leftMargin = 15;
            paramsMainLayout.rightMargin = 15;
            paramsMainLayout.bottomMargin = 20;
            paramsTitleTV.bottomMargin = 10;
            params3_1_2_1.bottomMargin = 50;
            params3_1_2_2.bottomMargin = 30;
            params3_1_2_3.topMargin = 20;
            params3_1_3_1.rightMargin = 20;
            params3_1_3_2.rightMargin = 20;

            params3_3.setMargins(0, 0, 0, 30);

            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());

            margin.setMargins(10, 20, 5, 20);
            margin2.setMargins(10, 20, 5, 20);
            margin3.setMargins(10, 20, 5, 20);
            margin4.setMargins(10, 20, 5, 20);
            margin5.setMargins(0, 20, 5, 20);
            margin6.setMargins(10, 20, 20, 20);

            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout2.setLayoutParams(params2);
            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));

            Layout2_1.setLayoutParams(params2_1);

            Layout2_2.setLayoutParams(params2_1);
            Layout2_2.setGravity(Gravity.BOTTOM);

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

            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3.setLayoutParams(params3);
            Layout3_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_1.setLayoutParams(params3_1);
            Layout3_1.setPadding(15, 0, 0, 0);
//        Layout3_1.setBackgroundColor(Color.rgb(0,0,0));

            Layout3_1_3.setLayoutParams(params3_1_3);

            scrollview.setLayoutParams(params);

            Layout3_1_1.setLayoutParams(params3_1_1);
            Layout3_1_2.setLayoutParams(params3_1_2);

            Home.setId(R.id.subscribehome);
            Search.setId(R.id.subscribesearch);
            User.setId(R.id.subscribeuser);

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

            Layout3_1_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_1_2_3.setOrientation(LinearLayout.HORIZONTAL);

            Layout3_1_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
            Layout3_1_2_3.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_2_3.setGravity(Gravity.LEFT | Gravity.TOP);

            Layout2_2.addView(Layout2_2_1);

            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            Layout3.addView(Layout3_1);

            CircleImageView My2 = new CircleImageView(this);
            My2.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            if (prf.getString("userinfo_picture", "").equals("empty")) {
                My2.setImageResource(R.drawable.noimg_profile);
            } else {
                Glide.with(this).load(imageurl + prf.getString("userinfo_picture", "")).into(My2);
            }

            TextView TV1 = new TextView(this);
            TextView TV2 = new TextView(this);

            TV1.setTextColor(Color.rgb(255, 255, 255));
            TV1.setTextSize(16);
            TV1.setPadding(30, 0, 0, 0);
            TV1.setText(my_nickname);

            if (!my_desc.contains("null")) {
                TV2.setText(my_desc);
            }

            TV2.setTextColor(Color.rgb(255, 255, 255));
            TV2.setTextSize(14);
            TV2.setPadding(30, 0, 0, 0);

            Button button1 = new Button(this);
//                button1.setText("subscriber list (" + my_follower + ")");
            button1.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            button1.setText("subscriber list (" + my_subscribeto_cnt + ")");
            button1.setLayoutParams(new ViewGroup.LayoutParams(250, 70));
            button1.setTextColor(Color.rgb(255, 255, 255));
            button1.setTextSize(10);
            button1.setId(R.id.LayoutMy);
            button1.setNextFocusUpId(R.id.LayoutMy);
            button1.setNextFocusLeftId(R.id.my);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MyActivity.this, MyDetailActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);

                }
            });

            TextView Contents = new TextView(this);
            Contents.setText("Contents");
            Contents.setTextColor(Color.rgb(255, 255, 255));
            Contents.setTextSize(20);
            Contents.setPadding(30, 0, 0, 0);

            Layout3_1_2_1.setLayoutParams(params3_1_2_2);
            Layout3_1_2_2.setLayoutParams(params3_1_2_2);
            Layout3_1_2_3.setLayoutParams(params3_1_2_3);
            Layout3_1_3_1.setLayoutParams(params3_1_3_1);
            Layout3_1_3_2.setLayoutParams(params3_1_3_2);

            Layout3_1_1.setGravity(Gravity.CENTER);
            Layout3_1_2.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_3.setGravity(Gravity.RIGHT | Gravity.CENTER);

            Layout3_1_3_1.setGravity(Gravity.RIGHT | Gravity.CENTER);
            Layout3_1_3_2.setGravity(Gravity.RIGHT | Gravity.CENTER);

            Layout3_1_1.addView(My2);
            Layout3_1.addView(Layout3_1_1);

            Layout3_1_2_1.addView(TV1);
            Layout3_1_2_2.addView(TV2);
//        Layout3_1_2_3.addView(TV3_1);
//        Layout3_1_2_3.addView(TV3_2);

            Layout3_1_2.addView(Layout3_1_2_1);
            Layout3_1_2.addView(Layout3_1_2_2);
//        Layout3_1_2.addView(Layout3_1_2_3);
            Layout3_1.addView(Layout3_1_2);

            Layout3_1_3.addView(Layout3_1_3_1);

            Layout3_1_3_1.addView(button1);

            Layout3_1.addView(Layout3_1_3);

            if (my_list_id.size() == 0) {
                Log.d("CONTENTSEMPTY", "confirmed");
                Layout3_3.setLayoutParams(params);
                Layout3_3.setGravity(Gravity.CENTER);
                TextView nocontents = new TextView(this);
                nocontents.setText(getString(R.string.nocontents));
                nocontents.setTextColor(Color.rgb(255, 255, 255));
                nocontents.setPadding(0,300,0,0);
                Layout3_3.addView(nocontents);
                nocontents.setTextSize(18);

            } else {

                Layout3_2.setLayoutParams(params3_2);
                Layout3_2.addView(Contents);
                Layout3_2.setGravity(Gravity.LEFT | Gravity.CENTER);

                Layout3.addView(Layout3_2);

                Layout3_3.setLayoutParams(params4);
                Layout3_3.setOrientation(LinearLayout.VERTICAL);
                Layout3_3.setGravity(Gravity.CENTER);
                Layout3_3.setFocusableInTouchMode(true);

                Layout3_3.addView(progressbar);

            }

            Log.d(TAG, "내 영상 ori 썸네일>>" + my_list_p_thumbnail);

            int jj = my_list_p_thumbnail.size() / 4 + 1;
            int y = my_list_p_thumbnail.size() % 4;
            int j = 0; // 11번째부터 시작
            for(int i = 0; i < jj; i++) {
                LinearLayout Layout3_6 = new LinearLayout(this);
                Layout3_6.setLayoutParams(params3_6);
                Layout3_6.setGravity(Gravity.CENTER | Gravity.LEFT);
                Layout3.addView(Layout3_6);
                params3_6.bottomMargin = 20;
                params3_6.leftMargin = 15;

                if (i == jj - 1) {
                    if (y == 0) {
                        Layout3.removeView(Layout3_6);
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
                        Glide.with(this).load(imageurl + my_list_p_thumbnail.get(j).get(0)).into(IV11);
                        Glide.with(this).load(imageurl + my_list_profile.get(j)).into(CIV11);

                        IV11.setScaleType(ImageView.ScaleType.FIT_XY);
                        TextView TV11 = new TextView(this);
                        TextView TV11_1 = new TextView(this);

                        Layout3_6_1_1.setOrientation(LinearLayout.VERTICAL);
                        Layout3_6_1_1.setFocusableInTouchMode(true);

                        TV11.setText(my_list_description.get(j));
                        TV11.setTextSize(14);
                        TV11.setTextColor(Color.rgb(255, 255, 255));
                        TV11_1.setText(my_list_nickname.get(j) + "\n" + my_list_view_count.get(j) + " views");
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
//                            nowurl = imageurl + popular_video.get(jjj);
//                            maintitle = popular_content.get(jjj);
//                            subtitle = popular_content.get(jjj);
//                            creatortitle = popular_author_nickname.get(jjj);
//                            creatorprofile = imageurl + popular_author_picture.get(jjj);
//                            creatorauthorid = popular_author_id.get(jjj);
//                            Intent intent = new Intent(HomeActivityDetail.this, AliseonOTTPlayer.class);
//                            intent.putExtra("index",jjj + 1);
//                            intent.putExtra("category",0);
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
                        Glide.with(this).load(imageurl + my_list_p_thumbnail.get(j).get(0)).into(IV11);
                        Glide.with(this).load(imageurl + my_list_profile.get(j)).into(CIV11);

                        IV11.setScaleType(ImageView.ScaleType.FIT_XY);
                        TextView TV11 = new TextView(this);
                        TextView TV11_1 = new TextView(this);

                        Layout3_6_1_1.setOrientation(LinearLayout.VERTICAL);
                        Layout3_6_1_1.setFocusableInTouchMode(true);

                        TV11.setText(my_list_description.get(j));
                        TV11.setTextSize(14);
                        TV11.setTextColor(Color.rgb(255, 255, 255));
                        TV11_1.setText(my_list_nickname.get(j) + "\n" + my_list_view_count.get(j) + " views");
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
//                            nowurl = imageurl + popular_video.get(jjj);
//                            maintitle = popular_content.get(jjj);
//                            subtitle = popular_content.get(jjj);
//                            creatortitle = popular_author_nickname.get(jjj);
//                            creatorprofile = imageurl + popular_author_picture.get(jjj);
//                            creatorauthorid = popular_author_id.get(jjj);
//                            Intent intent = new Intent(HomeActivityDetail.this, AliseonOTTPlayer.class);
//                            intent.putExtra("index",jjj + 1);
//                            intent.putExtra("category",0);
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

                        myactivitycontentsloadinghandler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressbar.setVisibility(View.VISIBLE);
                                if(mystart == 0){
                                    mystart = mystart + 12;
                                } else {
                                    mystart = mystart + 8;
                                }
                                mylimit = 12;
                                NetworkTaskMyList networktaskmylist = new NetworkTaskMyList(api_my_list, null);
                                networktaskmylist.execute();
                            }
                        });

                    }
                }
            });

            Layout3.addView(Layout3_3);

            Layout1.addView(scrollview);

            scrollview.addView(Layout3);

            setContentView(Layout1);

//        Home.setNextFocusRightId(R.id.subscribe1);
//        Search.setNextFocusRightId(R.id.subscribe1);
//        User.setNextFocusRightId(R.id.subscribe1);
//        Home.setNextFocusUpId(R.id.subscribeuser);
//        User.setNextFocusDownId(R.id.subscribehome);

            My.requestFocus();
            My.setNextFocusDownId(R.id.setting);

            My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                @Override
                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                    if (hasFocus == false) {
                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(MyActivity.this, HomeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                }
                            }
                        });

                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(MyActivity.this, VoyageActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                }
                            }
                        });

                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(MyActivity.this, SubscribeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                    User.setImageResource(R.drawable.user);
                                }
                            }
                        });

                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(MyActivity.this, CartActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                }
                            }
                        });

                        Setting.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(MyActivity.this, SettingUserManagementActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                }
                            }
                        });

                    } else {
                    }
                }
            });

        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        My.requestFocus();
        overridePendingTransition(0,0);
    }

    public class MyActivityHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1000) {
                onResume();
            }
        }
    }

    public class MyActivityContentsLoadingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1000) {
                onResume();
            }
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }
}
