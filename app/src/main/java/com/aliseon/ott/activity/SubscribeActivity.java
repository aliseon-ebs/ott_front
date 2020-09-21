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
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.aliseon.ott.CircleImageView;
import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskMySubscribeFrom;
import com.aliseon.ott.networktask.NetworkTaskSubscribeMyList;
import com.aliseon.ott.networktask.NetworkTaskTvottSubscribeVoyage;
import com.bumptech.glide.Glide;

import java.util.Locale;

import static com.aliseon.ott.Variable.api_my_list;
import static com.aliseon.ott.Variable.api_subscribe_from;
import static com.aliseon.ott.Variable.api_voyage;
import static com.aliseon.ott.Variable.imageurl;
import static com.aliseon.ott.Variable.param_creator_info;
import static com.aliseon.ott.Variable.subscribe_creator_list_id;
import static com.aliseon.ott.Variable.subscribe_creator_list_nickname;
import static com.aliseon.ott.Variable.subscribe_creator_list_photo;
import static com.aliseon.ott.Variable.subscribe_select_creator_id;
import static com.aliseon.ott.Variable.subscribe_select_creator_num;
import static com.aliseon.ott.Variable.subscribe_voyage_list_category_en;
import static com.aliseon.ott.Variable.subscribe_voyage_list_category_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_category_kr;
import static com.aliseon.ott.Variable.subscribe_voyage_list_comment_count;
import static com.aliseon.ott.Variable.subscribe_voyage_list_contents_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_contents_type;
import static com.aliseon.ott.Variable.subscribe_voyage_list_create_at;
import static com.aliseon.ott.Variable.subscribe_voyage_list_description;
import static com.aliseon.ott.Variable.subscribe_voyage_list_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_like_count;
import static com.aliseon.ott.Variable.subscribe_voyage_list_name;
import static com.aliseon.ott.Variable.subscribe_voyage_list_p_thumbnail;
import static com.aliseon.ott.Variable.subscribe_voyage_list_photo;
import static com.aliseon.ott.Variable.subscribe_voyage_list_product_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_status;
import static com.aliseon.ott.Variable.subscribe_voyage_list_update_at;
import static com.aliseon.ott.Variable.subscribe_voyage_list_user_id;
import static com.aliseon.ott.Variable.subscribe_voyage_list_view_count;
import static com.aliseon.ott.Variable.subscribeapiload;
import static com.aliseon.ott.Variable.subscribefocusapiload;
import static com.aliseon.ott.Variable.subscribevoyagestart;
import static com.aliseon.ott.Variable.subscribevoyagelimit;

public class SubscribeActivity extends AppCompatActivity {

    public static SubscribeActivityHandler subscribeactivityhandler;
    static SubscribeActivityContentsLoadingHandler subscribeactivitycontentsloadinghandler;

    private static String TAG = "현재 url 가져오기";

    ImageView User;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        if (subscribeapiload == 0) {

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

            subscribeactivitycontentsloadinghandler = new SubscribeActivityContentsLoadingHandler();
            subscribeactivityhandler = new SubscribeActivityHandler();

            subscribeactivityhandler.post(new Runnable() {
                @Override
                public void run() {
                    NetworkTaskMySubscribeFrom networktasksubscribefrom = new NetworkTaskMySubscribeFrom(api_subscribe_from, null);
                    networktasksubscribefrom.execute();
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
            User = new ImageView(this);
            User.setFocusableInTouchMode(true);
            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Cart = new ImageView(this);
            Cart.setFocusableInTouchMode(true);
            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            CircleImageView My = new CircleImageView(this);
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
                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(My);
            }

            Setting.setImageResource(R.drawable.setting);
            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Profile.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            Profile.setPadding(20, 20, 20, 20);

            ImageView subscribe_image = new ImageView(this);
            subscribe_image.setImageResource(R.drawable.noing_category);
            subscribe_image.setLayoutParams(new ViewGroup.LayoutParams(337, 63));
            subscribe_image.setScaleType(ImageView.ScaleType.FIT_CENTER);
            subscribe_image.setPadding(5,0,0,0);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);
            LinearLayout.LayoutParams params3_1_1 = new LinearLayout.LayoutParams(250, 280);
            LinearLayout.LayoutParams params3_1_1_1 = new LinearLayout.LayoutParams(155, 155);
            LinearLayout.LayoutParams params3_1_1_2 = new LinearLayout.LayoutParams(225, 50);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 420);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

            paramsMainLayout.leftMargin = 15;
            paramsMainLayout.rightMargin = 15;
            paramsMainLayout.bottomMargin = 20;
            paramsTitleTV.bottomMargin = 10;
            params3_3.leftMargin = 15;
            params3_3.bottomMargin = 30;
//        params3_3.setMargins(0,0,0,30);

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
            Layout3_1.setPadding(30, 0, 0, 0);

            scrollview.setLayoutParams(params);

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

            Layout2_2.addView(Layout2_2_1);

            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            User.requestFocus();

                LinearLayout Layout3_3 = new LinearLayout(this);

                Layout3.addView(Layout3_1);


                for (int i = 0; i < 9; i++) {

                    LinearLayout Layout3_1_1 = new LinearLayout(this);
                    LinearLayout Layout3_1_1_1 = new LinearLayout(this);
                    LinearLayout Layout3_1_1_2 = new LinearLayout(this);
                    Layout3_1_1.setOrientation(LinearLayout.VERTICAL);
                    Layout3_1_1.setGravity(Gravity.CENTER);
                    Layout3_1_1.setLayoutParams(params3_1_1);
                    Layout3_1_1_1.setFocusableInTouchMode(true);
                    Layout3_1_1_1.setGravity(Gravity.CENTER);
                    Layout3_1_1_2.setGravity(Gravity.CENTER);
                    Layout3_1_1_1.setLayoutParams(params3_1_1_1);
                    Layout3_1_1_2.setLayoutParams(params3_1_1_2);

                    CircleImageView subscribe_image2 = new CircleImageView(this);
                    ImageView subscribe_image3 = new ImageView(this);

                    subscribe_image2.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
                    subscribe_image2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.noing_ract_shape));

                    subscribe_image3.setImageResource(R.drawable.noing_category);
                    subscribe_image3.setLayoutParams(new ViewGroup.LayoutParams(225, 42));
                    subscribe_image3.setScaleType(ImageView.ScaleType.FIT_CENTER);


                    Layout3_1_1_1.addView(subscribe_image2);
                    Layout3_1_1_2.addView(subscribe_image3);

                    Layout3_1_1.addView(Layout3_1_1_1);
                    Layout3_1_1.addView(Layout3_1_1_2);

                    Layout3_1.addView(Layout3_1_1);

                }

                Layout3_2.setLayoutParams(params3_2);
                Layout3_2.addView(subscribe_image);
                Layout3_2.setGravity(Gravity.LEFT | Gravity.CENTER);

                Layout3_3.setLayoutParams(params);
                Layout3_3.setOrientation(LinearLayout.VERTICAL);

                Layout3.addView(Layout3_2);

                for (int i = 0; i < 3; i++) {
                    LinearLayout Layout3_3_1 = new LinearLayout(this);
                    Layout3_3_1.setLayoutParams(params3_3);
                    Layout3_3_1.setGravity(Gravity.CENTER | Gravity.LEFT);
                    Layout3_3.addView(Layout3_3_1);

                    for (int ii = 0; ii < 4; ii++) {
                        LinearLayout Layout3_3_1_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_1 = new LinearLayout(this);

                        Layout3_3_1_1.setGravity(Gravity.CENTER);
                        ImageView IV = new ImageView(this);
                        IV.setImageResource(R.drawable.noing_layout);
                        IV.setLayoutParams(new ViewGroup.LayoutParams(420, 455));

                        Layout3_3_1_1_1.setOrientation(LinearLayout.VERTICAL);
                        Layout3_3_1_1_1.setFocusableInTouchMode(true);

                        Layout3_3_1_1_1.setLayoutParams(paramsMainLayout);

                        Layout3_3_1_1_1.addView(IV);
                        Layout3_3_1_1.addView(Layout3_3_1_1_1);
                        Layout3_3_1.addView(Layout3_3_1_1);

                    }

                }

                Layout3.addView(Layout3_3);

                Layout1.addView(Layout3);

                setContentView(Layout1);

                User.requestFocus();

            }

    }

    protected void onResume() {
        super.onResume();

        SharedPreferences prf = getSharedPreferences("login_session", MODE_PRIVATE);

        if (subscribeapiload == 1) {

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
        LinearLayout Layout3_2 = new LinearLayout(this);
        LinearLayout Layout3_3 = new LinearLayout(this);

        LinearLayout Layout4 = new LinearLayout(this);

        ScrollView scrollview = new ScrollView(this);
        HorizontalScrollView scrollview2 = new HorizontalScrollView(this);

        scrollview.setVerticalScrollBarEnabled(false);
        scrollview2.setHorizontalScrollBarEnabled(false);

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
        User = new ImageView(this);
        User.setFocusableInTouchMode(true);
        User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
        ImageView Cart = new ImageView(this);
        Cart.setFocusableInTouchMode(true);
        Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
        CircleImageView My = new CircleImageView(this);
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
        Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
        Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Profile.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
        Profile.setPadding(20, 20, 20, 20);

        TextView Contents = new TextView(this);
        Contents.setText("Contents");
        Contents.setTextColor(Color.rgb(255, 255, 255));
        Contents.setTextSize(20);
        Contents.setPadding(30, 0, 0, 0);

        ImageView nocontentsiv = new ImageView(this);
        nocontentsiv.setImageResource(R.drawable.noing_category);
        nocontentsiv.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
        nocontentsiv.setScaleType(ImageView.ScaleType.FIT_CENTER);

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
        LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);
        LinearLayout.LayoutParams params3_1_1 = new LinearLayout.LayoutParams(250, 280);
        LinearLayout.LayoutParams params3_1_1_1 = new LinearLayout.LayoutParams(155, 155);
        LinearLayout.LayoutParams params3_1_1_2 = new LinearLayout.LayoutParams(225, 50);
        LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
        LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150);
        LinearLayout.LayoutParams params3_6 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,456);
        LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150);
        LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
        LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
        LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

        paramsMainLayout.leftMargin = 15;
        paramsMainLayout.rightMargin = 15;
        paramsMainLayout.bottomMargin = 20;
        paramsTitleTV.bottomMargin = 10;
        params3_3.leftMargin = 15;
        params3_3.bottomMargin = 30;
//        params3_3.setMargins(0,0,0,30);

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
        Layout3_1.setLayoutParams(params);
        Layout3_1.setPadding(30, 0, 0, 0);

        scrollview.setLayoutParams(params);
        scrollview2.setLayoutParams(params3_1);

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

        Layout2_2.addView(Layout2_2_1);

        Layout2.addView(Layout2_1);
        Layout2.addView(Layout2_2);

        Layout4.setLayoutParams(params4);
        Layout4.setOrientation(LinearLayout.VERTICAL);
        Layout4.setGravity(Gravity.CENTER);
        Layout4.setFocusableInTouchMode(true);

        Layout3.addView(scrollview2);
        scrollview2.addView(Layout3_1);

            for (int i = 0; i < subscribe_creator_list_id.size(); i++) {

                if (i == 0) {

                    LinearLayout Layout3_1_1 = new LinearLayout(this);
                    FrameLayout Layout3_1_1_1 = new FrameLayout(this);
                    LinearLayout Layout3_1_1_2 = new LinearLayout(this);
                    Layout3_1_1.setOrientation(LinearLayout.VERTICAL);
                    Layout3_1_1.setGravity(Gravity.CENTER);
                    Layout3_1_1.setLayoutParams(params3_1_1);
                    Layout3_1_1_1.setFocusableInTouchMode(true);
                    Layout3_1_1_1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.layoutovalshape));
                    Layout3_1_1_1.setNextFocusLeftId(R.id.subscribeuser);
                    Layout3_1_1_2.setGravity(Gravity.CENTER | Gravity.TOP);
                    Layout3_1_1_1.setLayoutParams(params3_1_1_1);
                    Layout3_1_1_2.setLayoutParams(params3_1_1_2);

                    CircleImageView subscribe_image2 = new CircleImageView(this);

                    subscribe_image2.setLayoutParams(new ViewGroup.LayoutParams(150, 150));

                    TextView subscribe_tv1_1 = new TextView(this);
                    TextView subscribe_tv1_2 = new TextView(this);

                    subscribe_tv1_1.setText(" ");
                    subscribe_tv1_1.setTextColor(Color.rgb(255, 255, 255));
                    subscribe_tv1_2.setText(getResources().getString(R.string.all));
                    subscribe_tv1_2.setTextColor(Color.rgb(0, 0, 0));
                    subscribe_tv1_2.setGravity(Gravity.CENTER);

                    Layout3_1_1_1.addView(subscribe_image2);
                    Layout3_1_1_2.addView(subscribe_tv1_1);
                    Layout3_1_1_1.addView(subscribe_tv1_2);

                    Layout3_1_1.addView(Layout3_1_1_1);
                    Layout3_1_1.addView(Layout3_1_1_2);

                    Layout3_1.addView(Layout3_1_1);

                    Layout3_1_1_1.setId(R.id.subscribe1);
                    Layout3_1_1_1.setNextFocusUpId(R.id.subscribe1);
                    Layout3_1_1_1.setNextFocusDownId(R.id.subscribe2);

                    if (subscribe_select_creator_num == 1) {
                        Layout3_1_1_1.requestFocus();
                        Layout3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                    } else if (subscribe_select_creator_num == i + 2) {
                        Layout3_1_1.setBackground(null);
                        subscribe_tv1_2.setTextColor(Color.rgb(0, 0, 0));
                    }

                    Layout3_1_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                        @Override
                        public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                            if (hasFocus == false) {
                                Layout3_1_1.setBackground(null);
                                Layout3_1_1_1.setId(R.id.all1);

                                Log.d("all false", "id" + subscribe_select_creator_id);
                                Log.d("all false", "num" + subscribe_select_creator_num);

                            } else {
                                Layout3_1_1_1.setId(R.id.subscribe1);
                                Layout3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                subscribevoyagestart = 0;
                                subscribe_select_creator_num = 1;

                                if (subscribeapiload == 1 && subscribefocusapiload == 0) {

                                    subscribefocusapiload = 1;

                                    subscribe_voyage_list_id.clear();
                                    subscribe_voyage_list_user_id.clear();
                                    subscribe_voyage_list_product_id.clear();
                                    subscribe_voyage_list_contents_id.clear();
                                    subscribe_voyage_list_contents_type.clear();
                                    subscribe_voyage_list_category_id.clear();
                                    subscribe_voyage_list_status.clear();
                                    subscribe_voyage_list_create_at.clear();
                                    subscribe_voyage_list_update_at.clear();
                                    subscribe_voyage_list_like_count.clear();
                                    subscribe_voyage_list_view_count.clear();
                                    subscribe_voyage_list_comment_count.clear();
                                    subscribe_voyage_list_category_en.clear();
                                    subscribe_voyage_list_category_kr.clear();
                                    subscribe_voyage_list_name.clear();
                                    subscribe_voyage_list_photo.clear();
                                    subscribe_voyage_list_description.clear();
                                    subscribe_voyage_list_p_thumbnail.clear();

                                    subscribeactivityhandler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            NetworkTaskTvottSubscribeVoyage networktasktvottvoyage = new NetworkTaskTvottSubscribeVoyage(api_voyage, null);
                                            networktasktvottvoyage.execute();
                                        }
                                    });

                                    Log.d("all true", "id" + subscribe_select_creator_id);
                                    Log.d("all true", "num" + subscribe_select_creator_num);

                                }

                            }
                        }
                    });

                }

                LinearLayout Layout3_1_1 = new LinearLayout(this);
                LinearLayout Layout3_1_1_1 = new LinearLayout(this);
                LinearLayout Layout3_1_1_2 = new LinearLayout(this);
                Layout3_1_1.setOrientation(LinearLayout.VERTICAL);
                Layout3_1_1.setGravity(Gravity.CENTER);
                Layout3_1_1.setLayoutParams(params3_1_1);
                Layout3_1_1_1.setFocusableInTouchMode(true);
//            Layout3_1_1_1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.selectusersetting));
                Layout3_1_1_1.setGravity(Gravity.CENTER);
                Layout3_1_1_2.setGravity(Gravity.CENTER | Gravity.TOP);
                Layout3_1_1_1.setLayoutParams(params3_1_1_1);
                Layout3_1_1_2.setLayoutParams(params3_1_1_2);

                CircleImageView subscribe_image2 = new CircleImageView(this);
                TextView subscribe_tv2 = new TextView(this);

                subscribe_image2.setLayoutParams(new ViewGroup.LayoutParams(150, 150));

                subscribe_tv2.setText(subscribe_creator_list_nickname.get(i));
                subscribe_tv2.setTextColor(Color.rgb(255, 255, 255));

                Glide.with(this).load(imageurl + subscribe_creator_list_photo.get(i)).into(subscribe_image2);

                subscribe_tv2.setPadding(0, 15, 0, 0);

                Layout3_1_1_1.addView(subscribe_image2);
                Layout3_1_1_2.addView(subscribe_tv2);

                Layout3_1_1.addView(Layout3_1_1_1);
                Layout3_1_1.addView(Layout3_1_1_2);

                Layout3_1.addView(Layout3_1_1);

                Layout3_1_1_1.setNextFocusUpId(R.id.subscribe1);
                Layout3_1_1_1.setNextFocusDownId(R.id.subscribe2);

                if (subscribe_select_creator_num == i + 2) {
                    Layout3_1_1_1.requestFocus();
                    Layout3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                    subscribe_tv2.setTextColor(Color.rgb(0, 0, 0));
                }

                final int iii = i;

                Layout3_1_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {// 포커스를 얻으면

                    @Override
                    public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때

                        if (hasFocus == false) {
                            Layout3_1_1_1.setId(R.id.all1);
                            Layout3_1_1.setBackground(null);
                            subscribe_tv2.setTextColor(Color.rgb(255, 255, 255));

                            Log.d("false", "id" + subscribe_select_creator_id);
                            Log.d("false", "num" + subscribe_select_creator_num);

                        } else {
                            Layout3_1_1_1.setId(R.id.subscribe1);
                            subscribe_select_creator_id = subscribe_creator_list_id.get(iii);
                            subscribe_select_creator_num = iii + 2;

                            Layout3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                            subscribe_tv2.setTextColor(Color.rgb(0, 0, 0));

                            subscribevoyagestart = 0;

                            if (subscribeapiload == 1 &&subscribefocusapiload == 0) {

                                subscribefocusapiload = 1;

                                subscribe_voyage_list_id.clear();
                                subscribe_voyage_list_user_id.clear();
                                subscribe_voyage_list_product_id.clear();
                                subscribe_voyage_list_contents_id.clear();
                                subscribe_voyage_list_contents_type.clear();
                                subscribe_voyage_list_category_id.clear();
                                subscribe_voyage_list_status.clear();
                                subscribe_voyage_list_create_at.clear();
                                subscribe_voyage_list_update_at.clear();
                                subscribe_voyage_list_like_count.clear();
                                subscribe_voyage_list_view_count.clear();
                                subscribe_voyage_list_comment_count.clear();
                                subscribe_voyage_list_category_en.clear();
                                subscribe_voyage_list_category_kr.clear();
                                subscribe_voyage_list_name.clear();
                                subscribe_voyage_list_photo.clear();
                                subscribe_voyage_list_description.clear();
                                subscribe_voyage_list_p_thumbnail.clear();

                                subscribeactivityhandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        NetworkTaskSubscribeMyList networktasksubscribemylist = new NetworkTaskSubscribeMyList(api_my_list, null);
                                        networktasksubscribemylist.execute();
                                    }
                                });

                                Log.d("true", "id" + subscribe_select_creator_id);
                                Log.d("true", "num" + subscribe_select_creator_num);

                            }

                        }
                    }
                });

                Layout3_1_1_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        creatorapiload = 0;
//                        creator_id = subscribe_list_id.get(iii);
//                        param_unsubscr_id = subscribe_list_sbscr_id.get(iii);

                        param_creator_info = subscribe_select_creator_id;

                        Intent intent = new Intent(SubscribeActivity.this, CreatorActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);

                    }
                });

            }

            if (subscribe_voyage_list_id.size() == 0) {
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

                Layout3_3.setLayoutParams(params3_3);
                Layout3_3.setOrientation(LinearLayout.VERTICAL);
                Layout3_3.setGravity(Gravity.CENTER);
                Layout3_3.setFocusableInTouchMode(true);

                Layout3_3.addView(progressbar);

            }

            int jj = subscribe_voyage_list_p_thumbnail.size() / 4 + 1;
            int y = subscribe_voyage_list_p_thumbnail.size() % 4;

            int j = 0;
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
                        Glide.with(this).load(imageurl + subscribe_voyage_list_p_thumbnail.get(j).get(0)).into(IV11);
                        Glide.with(this).load(imageurl + subscribe_voyage_list_photo.get(j)).into(CIV11);

                        IV11.setScaleType(ImageView.ScaleType.FIT_XY);
                        TextView TV11 = new TextView(this);
                        TextView TV11_1 = new TextView(this);

                        Layout3_6_1_1.setOrientation(LinearLayout.VERTICAL);
                        Layout3_6_1_1.setFocusableInTouchMode(true);

                        TV11.setText(subscribe_voyage_list_description.get(j));
                        TV11.setTextSize(14);
                        TV11.setTextColor(Color.rgb(255, 255, 255));
                        TV11_1.setText(subscribe_voyage_list_name.get(j) + "\n" + subscribe_voyage_list_view_count.get(j) + " views");
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

                        Glide.with(this).load(imageurl + subscribe_voyage_list_p_thumbnail.get(j).get(0)).into(IV11);
                        Glide.with(this).load(imageurl + subscribe_voyage_list_photo.get(j)).into(CIV11);

                        IV11.setScaleType(ImageView.ScaleType.FIT_XY);
                        TextView TV11 = new TextView(this);
                        TextView TV11_1 = new TextView(this);

                        Layout3_6_1_1.setOrientation(LinearLayout.VERTICAL);
                        Layout3_6_1_1.setFocusableInTouchMode(true);

                        TV11.setText(subscribe_voyage_list_description.get(j));
                        TV11.setTextSize(14);
                        TV11.setTextColor(Color.rgb(255, 255, 255));
                        TV11_1.setText(subscribe_voyage_list_name.get(j) + "\n" + subscribe_voyage_list_view_count.get(j) + " views");
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

            if(subscribe_select_creator_num == 1) {

                Layout3_3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                    @Override
                    public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                        if (hasFocus == false) {

                        } else {

                            subscribeactivitycontentsloadinghandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressbar.setVisibility(View.VISIBLE);
                                    if (subscribevoyagestart == 0) {
                                        subscribevoyagestart = subscribevoyagestart + 12;
                                    } else {
                                        subscribevoyagestart = subscribevoyagestart + 8;
                                    }
                                    subscribevoyagelimit = 12;
                                    NetworkTaskTvottSubscribeVoyage networktasktvottsubscribevoyage = new NetworkTaskTvottSubscribeVoyage(api_voyage, null);
                                    networktasktvottsubscribevoyage.execute();
                                }
                            });

                        }
                    }
                });

            } else {

                Layout3_3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                    @Override
                    public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                        if (hasFocus == false) {

                        } else {

                            subscribeactivitycontentsloadinghandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressbar.setVisibility(View.VISIBLE);
                                    if (subscribevoyagestart == 0) {
                                        subscribevoyagestart = subscribevoyagestart + 12;
                                    } else {
                                        subscribevoyagestart = subscribevoyagestart + 8;
                                    }
                                    subscribevoyagelimit = 12;
                                    NetworkTaskSubscribeMyList networktasksubscribemylist = new NetworkTaskSubscribeMyList(api_my_list, null);
                                    networktasksubscribemylist.execute();
                                }
                            });

                        }
                    }
                });

            }

            Layout3.addView(Layout3_3);

            Layout1.addView(scrollview);

            scrollview.addView(Layout3);

            setContentView(Layout1);

            if (subscribe_select_creator_num == 0) {
                User.requestFocus();
            }

            User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                @Override
                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                    if (hasFocus == false) {
                        User.setImageResource(R.drawable.user);

                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
//                                        Home.setImageResource(R.drawable.homeselect);
                                    User.setImageResource(R.drawable.user);
                                    Intent intent = new Intent(SubscribeActivity.this, HomeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                    Home.setImageResource(R.drawable.home);
                                }
                            }
                        });
                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
//                                        Search.setImageResource(R.drawable.searchselect);
                                    subscribeapiload = 0;
                                    subscribe_creator_list_id.clear();
                                    subscribe_creator_list_nickname.clear();
                                    subscribe_creator_list_photo.clear();
                                    subscribe_select_creator_num = 0;
                                    User.setImageResource(R.drawable.user);
                                    Intent intent = new Intent(SubscribeActivity.this, VoyageActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                    Search.setImageResource(R.drawable.search);
                                }
                            }
                        });

                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
//                                        Search.setImageResource(R.drawable.searchselect);
                                    subscribe_select_creator_num = 0;
                                    Cart.setImageResource(R.drawable.cart);
                                    Intent intent = new Intent(SubscribeActivity.this, CartActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                    Cart.setImageResource(R.drawable.cart);
                                }
                            }
                        });

                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
//                                        Search.setImageResource(R.drawable.searchselect);
                                    Intent intent = new Intent(SubscribeActivity.this, MyActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                }
                            }
                        });


                    } else {
//                            User.setImageResource(R.drawable.userselect);
                    }
                }
            });


        }

    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 800) {
                Intent intent = new Intent(SubscribeActivity.this, AliseonOTTPlayerActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
            if (msg.what == 1000) {
                Intent intent = new Intent(SubscribeActivity.this, AliseonOTTPlayerActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        subscribe_select_creator_num = 0;
        subscribeapiload = 0;
        subscribe_creator_list_id.clear();
        subscribe_creator_list_nickname.clear();
        subscribe_creator_list_photo.clear();
        User.requestFocus();
        overridePendingTransition(0, 0);
    }

    @Override
    public void recreate() {
        super.recreate();
        User.requestFocus();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        User.requestFocus();
    }

    public class SubscribeActivityHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 700) {

                subscribeapiload = 1;
                subscribefocusapiload = 0;
                onResume();

            }

            if (msg.what == 800) {

                subscribeapiload = 1;
                subscribefocusapiload = 0;
                onResume();

            }

            if (msg.what == 900) {

                subscribeapiload = 1;
                subscribefocusapiload = 0;
                onResume();

            }

            if (msg.what == 1000) {

                subscribeapiload = 1;
                subscribefocusapiload = 0;
                onResume();

            }
        }
    }

    class SubscribeActivityCreatorSelectHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1000) {
                onResume();
            }
        }
    }

    class SubscribeActivityContentsLoadingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {
                onResume();
            }
        }
    }

}
