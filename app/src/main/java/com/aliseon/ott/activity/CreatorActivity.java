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

import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskCreatorInfo;
import com.aliseon.ott.networktask.NetworkTaskCreatorList;
import com.bumptech.glide.Glide;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.aliseon.ott.Variable.CreatorClear;
import static com.aliseon.ott.Variable.api_my_info;
import static com.aliseon.ott.Variable.api_my_list;
import static com.aliseon.ott.Variable.creator_desc;
import static com.aliseon.ott.Variable.creator_id;
import static com.aliseon.ott.Variable.creator_list_description;
import static com.aliseon.ott.Variable.creator_list_nickname;
import static com.aliseon.ott.Variable.creator_list_p_thumbnail;
import static com.aliseon.ott.Variable.creator_list_profile;
import static com.aliseon.ott.Variable.creator_list_view_count;
import static com.aliseon.ott.Variable.creator_nickname;
import static com.aliseon.ott.Variable.creator_photo;
import static com.aliseon.ott.Variable.creator_subscribeto_cnt;
import static com.aliseon.ott.Variable.creatorapiload;
import static com.aliseon.ott.Variable.creatorstart;
import static com.aliseon.ott.Variable.imageurl;
import static com.aliseon.ott.Variable.loginid;
import static com.aliseon.ott.Variable.param_creator_info;
import static com.aliseon.ott.Variable.refresh_num;
import static com.aliseon.ott.Variable.subscribe_checker;
import static com.aliseon.ott.Variable.subscribe_creator_list_id;

public class CreatorActivity extends AppCompatActivity {

    public static CreatorActivityHandler creatoractivityhandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        if(creatorapiload == 0) {

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

            Log.d("creator create", "0");

            creatoractivityhandler = new CreatorActivityHandler();

            creatoractivityhandler.post(new Runnable() {
                @Override
                public void run() {
                    NetworkTaskCreatorInfo networktaskcreatorinfo = new NetworkTaskCreatorInfo(api_my_info, null);
                    networktaskcreatorinfo.execute();
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

            ImageView BackArrow = new ImageView(this);
            BackArrow.setFocusableInTouchMode(true);
            BackArrow.setPadding(10, 10, 10, 10);

            Button topbutton = new Button(this);
            topbutton.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            topbutton.setLayoutParams(new ViewGroup.LayoutParams(90, 65));
            topbutton.setTextColor(Color.rgb(255, 255, 255));
            topbutton.setTextSize(10);

            BackArrow.setImageResource(R.drawable.backarrow_b);
            BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);

            CircleImageView My2 = new CircleImageView(this);

            My2.setImageResource(R.drawable.noing_creator);
            My2.setLayoutParams(new ViewGroup.LayoutParams(150, 150));

            TextView TV1 = new TextView(this);
            TextView TV2 = new TextView(this);
            TextView TV3_1 = new TextView(this);
            TextView TV3_2 = new TextView(this);

            TV1.setText(creator_nickname);
            TV1.setTextColor(Color.rgb(255, 255, 255));
            TV1.setTextSize(16);
            TV1.setPadding(10, 0, 0, 0);
            TV2.setTextColor(Color.rgb(255, 255, 255));
            TV2.setTextSize(14);
            TV2.setPadding(10, 0, 0, 0);
            ImageView IV1 = new ImageView(this);
            IV1.setImageResource(R.drawable.noing_category);
            IV1.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            IV1.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ImageView IV2 = new ImageView(this);
            IV2.setImageResource(R.drawable.noing_category);
            IV2.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            IV2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ImageView IV3 = new ImageView(this);
            IV3.setImageResource(R.drawable.noing_category);
            IV3.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            IV3.setScaleType(ImageView.ScaleType.FIT_CENTER);

            Button button1 = new Button(this);
            button1.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            button1.setLayoutParams(new ViewGroup.LayoutParams(250, 70));
            button1.setTextColor(Color.rgb(255, 255, 255));
            button1.setTextSize(10);
            Button button2 = new Button(this);
            button2.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            button2.setLayoutParams(new ViewGroup.LayoutParams(180, 70));
            button2.setTextColor(Color.rgb(255, 255, 255));
            button2.setTextSize(10);

            BackArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            TextView Contents = new TextView(this);
            Contents.setText("Contents");
            Contents.setTextColor(Color.rgb(255, 255, 255));
            Contents.setTextSize(20);
            Contents.setPadding(30, 0, 0, 0);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
            LinearLayout.LayoutParams paramsTopButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);
            LinearLayout.LayoutParams params3_1_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.6f);
            LinearLayout.LayoutParams params3_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params3_1_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params3_1_3_1 = new LinearLayout.LayoutParams(250, 70);
            LinearLayout.LayoutParams params3_1_3_2 = new LinearLayout.LayoutParams(180, 70);
            LinearLayout.LayoutParams params3_1_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50);
            LinearLayout.LayoutParams params3_1_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_1_2_3 = new LinearLayout.LayoutParams(1400, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 420);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

            paramsMainLayout.leftMargin = 10;
            paramsMainLayout.rightMargin = 10;
            paramsMainLayout.bottomMargin = 5;
            paramsTitleTV.bottomMargin = 10;
            params3_1_1.leftMargin = 20;
            params3_1_2_1.bottomMargin = 10;
            params3_1_2_3.topMargin = 20;
            params3_1_3_1.rightMargin = 20;
            params3_1_3_2.rightMargin = 20;

            params3_3.setMargins(0, 0, 0, 20);

            Layout2.setLayoutParams(params2);
            Layout2.setGravity(Gravity.CENTER);
            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2_1.setLayoutParams(paramsBackArrow);
            Layout2_1.setGravity(Gravity.CENTER);
            Layout2_1.addView(BackArrow);
            Layout2_2.setLayoutParams(paramsTopButton);
            Layout2_2.setGravity(Gravity.CENTER);
            Layout2_2.addView(topbutton);
            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            Layout2.setBackgroundColor(Color.rgb(29, 29, 29));   // 백그라운드 색 조정
            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));

            Layout2.setLayoutParams(params2);

            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3.setLayoutParams(params3);
            Layout3_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_1.setLayoutParams(params3_1);
            Layout3_1.setPadding(15, 0, 0, 0);

            Layout3_1_2_1.setLayoutParams(params3_1_2_1);
            Layout3_1_2_2.setLayoutParams(params3_1_2_2);
            Layout3_1_2_3.setLayoutParams(params3_1_2_3);
            Layout3_1_3_1.setLayoutParams(params3_1_3_1);
            Layout3_1_3_2.setLayoutParams(params3_1_3_2);

            Layout3_1_3.setLayoutParams(params3_1_3);

            scrollview.setLayoutParams(params);

            Layout3_1_1.setLayoutParams(params3_1_1);
            Layout3_1_2.setLayoutParams(params3_1_2);

            Layout1.addView(Layout2);

            Layout3_1_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_1_2_3.setOrientation(LinearLayout.HORIZONTAL);

            Layout3_1_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
            Layout3_1_2_2.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_2_3.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_2_3.setGravity(Gravity.LEFT | Gravity.TOP);

            Layout3.addView(Layout3_1);

            Layout3_1_1.setGravity(Gravity.CENTER);
            Layout3_1_2.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_3.setGravity(Gravity.RIGHT | Gravity.CENTER);

            Layout3_1_3_1.setGravity(Gravity.RIGHT | Gravity.CENTER);
            Layout3_1_3_2.setGravity(Gravity.RIGHT | Gravity.CENTER);

            Layout3_1_1.addView(My2);
            Layout3_1.addView(Layout3_1_1);

            Layout3_1_2_1.addView(IV1);
            Layout3_1_2_2.addView(IV2);

            Layout3_1_2.addView(Layout3_1_2_1);
            Layout3_1_2.addView(Layout3_1_2_2);

            Layout3_1.addView(Layout3_1_2);

            Layout3_1_3.addView(Layout3_1_3_1);
            Layout3_1_3.addView(Layout3_1_3_2);

            Layout3_1_3_1.addView(button1);
            Layout3_1_3_2.addView(button2);

            Layout3_1.addView(Layout3_1_3);

            Layout3_2.setLayoutParams(params3_2);
            Layout3_2.addView(IV3);
            Layout3_2.setGravity(Gravity.LEFT | Gravity.CENTER);

            Layout3.addView(Layout3_2);

            for (int i = 0; i < 3; i++) {
                LinearLayout Layout3_3 = new LinearLayout(this);
                Layout3_3.setLayoutParams(params3_3);
                Layout3_3.setGravity(Gravity.CENTER);
                Layout3.addView(Layout3_3);

                for (int iii = 0; iii < 4; iii++) {
                    LinearLayout Layout3_3_1 = new LinearLayout(this);
                    LinearLayout Layout3_3_1_1 = new LinearLayout(this);

                    Layout3_3_1.setGravity(Gravity.CENTER);
                    ImageView IV11 = new ImageView(this);
                    IV11.setImageResource(R.drawable.noing_layout);
                    IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 486));

                    Layout3_3_1_1.setLayoutParams(paramsMainLayout);
                    Layout3_3_1_1.setFocusableInTouchMode(true);

                    Layout3_3_1_1.addView(IV11);
                    Layout3_3_1.addView(Layout3_3_1_1);
                    Layout3_3.addView(Layout3_3_1);

                }
            }

            Layout1.addView(Layout3);

            setContentView(Layout1);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        overridePendingTransition(0,0);
    }

    public class CreatorActivityHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {
                Log.d("resume 탐", "");
                onResume();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        CreatorClear();
        overridePendingTransition(0,0);

    }


    @Override
    protected void onResume() {
        super.onResume();

        if (creatorapiload == 1) {

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

            Log.d("creator resume", "1");

            refresh_num = 0;

            LinearLayout Layout1 = new LinearLayout(this);
            LinearLayout Layout2 = new LinearLayout(this);
            LinearLayout Layout2_1 = new LinearLayout(this);
            LinearLayout Layout2_2 = new LinearLayout(this);

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
            LinearLayout Layout4 = new LinearLayout(this);

            ScrollView scrollview = new ScrollView(this);

            scrollview.setVerticalScrollBarEnabled(false);

            ProgressBar progressbar = new ProgressBar(this);
            progressbar.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            progressbar.setVisibility(View.GONE);


            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            ImageView BackArrow = new ImageView(this);
            BackArrow.setFocusableInTouchMode(true);
            BackArrow.setPadding(10, 10, 10, 10);
            BackArrow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));

            Button topbutton = new Button(this);
            topbutton.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            topbutton.setLayoutParams(new ViewGroup.LayoutParams(90, 65));
            topbutton.setTextColor(Color.rgb(255, 255, 255));
            topbutton.setTextSize(10);
            topbutton.setText("TOP");

            BackArrow.setImageResource(R.drawable.backarrow);
            BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BackArrow.setId(R.id.backarrow);
            BackArrow.setNextFocusUpId(R.id.backarrow);

            CircleImageView My = new CircleImageView(this);

            My.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            Glide.with(this).load(imageurl + creator_photo).into(My);

            TextView TV1 = new TextView(this);
            TextView TV2 = new TextView(this);
//            TextView TV3_1 = new TextView(this);
//            TextView TV3_2 = new TextView(this);

            TV1.setText(creator_nickname);
            TV1.setTextColor(Color.rgb(255, 255, 255));
            TV1.setTextSize(16);
            TV1.setPadding(10, 0, 0, 0);

            if (!creator_desc.contains("null")) {
                TV2.setText(creator_desc);
            }

            TV2.setTextColor(Color.rgb(255, 255, 255));
            TV2.setTextSize(14);
            TV2.setPadding(10, 0, 0, 0);
//        TV3_1.setText(getResources().getString(R.string.subscriber) + " " + my_follower);
//        TV3_1.setTextColor(Color.rgb(255,255,255));
//        TV3_1.setTextSize(14);
//        TV3_1.setFocusableInTouchMode(true);
//        TV3_1.setBackground(getResources().getDrawable(R.drawable.boxlinesetting));
//        TV3_2.setText("   |   " + getResources().getString(R.string.posting) + " " + my_contents_cnt);
//        TV3_2.setTextColor(Color.rgb(255,255,255));
//        TV3_2.setTextSize(14);

            Button button1 = new Button(this);
            button1.setText("subscriber list (" + creator_subscribeto_cnt + ")");
            button1.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            button1.setLayoutParams(new ViewGroup.LayoutParams(250, 70));
            button1.setTextColor(Color.rgb(255, 255, 255));
            button1.setTextSize(10);
            Button button2 = new Button(this);
            

            for(int i = 0; i < subscribe_creator_list_id.size(); i++){

                if(subscribe_creator_list_id.get(i) == param_creator_info){

                    subscribe_checker = 1;

                }

            }

            if (subscribe_checker == 0) {

                Log.d("isSubscribe", "NO");
                button2.setText(getResources().getString(R.string.subscribe));
                button2.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonsetting));
                button2.setLayoutParams(new ViewGroup.LayoutParams(180, 70));
                button2.setTextColor(Color.rgb(255, 255, 255));
                button2.setTextSize(10);

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
////                        param_subscr_id = creator_id;
//                        subscribe_checker = 1;
//                        creatorapiload = 0;
//                        NetworkTaskSubscribeChannels networktasksubscribechannels = new NetworkTaskSubscribeChannels(api_subscribe_channels, null);
//                        networktasksubscribechannels.execute();

                    }
                });
            } else if (subscribe_checker == 1) {
                Log.d("isSubscribe", "YES");
                button2.setText(getResources().getString(R.string.subscribed));
                button2.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
                button2.setLayoutParams(new ViewGroup.LayoutParams(180, 70));
                button2.setTextColor(Color.rgb(255, 255, 255));
                button2.setTextSize(10);

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        // 단순히 클릭하면 구독 해제됨, 주의
////                        param_unsubscr_id = creator_subscr_id;
//                        subscribe_checker = 0;
//                        creatorapiload = 0;
//                        NetworkTaskSubscribeUnsubscribe networktasksubscribeunsubscribe = new NetworkTaskSubscribeUnsubscribe(api_subscribe_unsubscribe, null);
//                        networktasksubscribeunsubscribe.execute();
                    }
                });
            }

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CreatorActivity.this, CreatorDetailActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }
            });

            TextView Contents = new TextView(this);
            Contents.setText("Contents");
            Contents.setTextColor(Color.rgb(255, 255, 255));
            Contents.setTextSize(20);
            Contents.setPadding(15, 0, 0, 0);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
            LinearLayout.LayoutParams paramsTopButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);
            LinearLayout.LayoutParams params3_1_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.65f);
            LinearLayout.LayoutParams params3_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params3_1_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params3_1_3_1 = new LinearLayout.LayoutParams(250, 70);
            LinearLayout.LayoutParams params3_1_3_2 = new LinearLayout.LayoutParams(180, 70);
            LinearLayout.LayoutParams params3_1_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50);
            LinearLayout.LayoutParams params3_1_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_1_2_3 = new LinearLayout.LayoutParams(1400, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 420);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150);
            LinearLayout.LayoutParams paramsCIV = new LinearLayout.LayoutParams(100, 60);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 486);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);

            paramsTitleTV.bottomMargin = 10;
            paramsMainLayout.leftMargin = 10;
            paramsMainLayout.rightMargin = 10;
            paramsMainLayout.bottomMargin = 15;
            params3_1_2_1.bottomMargin = 10;
            params3_1_2_3.topMargin = 20;
            params3_1_3_1.rightMargin = 20;
            params3_1_3_2.rightMargin = 20;

            params3_3.setMargins(0, 0, 0, 20);

            Layout2.setLayoutParams(params2);
            Layout2.setGravity(Gravity.CENTER);
            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2_1.setLayoutParams(paramsBackArrow);
            Layout2_1.setGravity(Gravity.CENTER);
            Layout2_1.addView(BackArrow);
            Layout2_2.setLayoutParams(paramsTopButton);
            Layout2_2.setGravity(Gravity.CENTER);
            Layout2_2.addView(topbutton);
            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            Layout2.setBackgroundColor(Color.rgb(29, 29, 29));   // 백그라운드 색 조정
            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));

            Layout2.setLayoutParams(params2);

            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3.setLayoutParams(params3);
            Layout3_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_1.setLayoutParams(params3_1);
            Layout3_1.setPadding(15, 0, 0, 0);

            Layout3_1_2_1.setLayoutParams(params3_1_2_1);
            Layout3_1_2_2.setLayoutParams(params3_1_2_2);
            Layout3_1_2_3.setLayoutParams(params3_1_2_3);
            Layout3_1_3_1.setLayoutParams(params3_1_3_1);
            Layout3_1_3_2.setLayoutParams(params3_1_3_2);

            Layout3_1_3.setLayoutParams(params3_1_3);

            scrollview.setLayoutParams(params);

            Layout3_1_1.setLayoutParams(params3_1_1);
            Layout3_1_2.setLayoutParams(params3_1_2);

            Layout1.addView(Layout2);

            Layout3_1_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_1_2_3.setOrientation(LinearLayout.HORIZONTAL);

            Layout3_1_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
            Layout3_1_2_3.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_2_3.setGravity(Gravity.LEFT | Gravity.TOP);

            Layout3.addView(Layout3_1);

            Layout3_1_1.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_2.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout3_1_3.setGravity(Gravity.RIGHT | Gravity.CENTER);

            Layout3_1_3_1.setGravity(Gravity.RIGHT | Gravity.CENTER);
            Layout3_1_3_2.setGravity(Gravity.RIGHT | Gravity.CENTER);

            Layout3_1_1.addView(My);
            Layout3_1.addView(Layout3_1_1);

            Layout3_1_2_1.addView(TV1);
            Layout3_1_2_2.addView(TV2);

            Layout3_1_2.addView(Layout3_1_2_1);
            Layout3_1_2.addView(Layout3_1_2_2);

            Layout3_1.addView(Layout3_1_2);

            Layout3_1_3.addView(Layout3_1_3_1);

            if (loginid == creator_id) {

            } else {
                Layout3_1_3.addView(Layout3_1_3_2);
            }

            Layout3_1_3_1.addView(button1);
            Layout3_1_3_2.addView(button2);

            Layout3_1.addView(Layout3_1_3);

            Layout3_2.setLayoutParams(params3_2);
            Layout3_2.addView(Contents);
            Layout3_2.setGravity(Gravity.LEFT | Gravity.CENTER);

            Layout3.addView(Layout3_2);

            // 크리에이터의 컨텐츠가 없을 경우
            if (creator_list_p_thumbnail.size() == 0) {
                LinearLayout Layout3_3 = new LinearLayout(this);
                LinearLayout.LayoutParams params3_4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 430);
                Layout3_3.setLayoutParams(params3_4);
                Layout3_3.setGravity(Gravity.CENTER);
                TextView nocontents = new TextView(this);
                nocontents.setText(getString(R.string.nocontents));
                nocontents.setTextColor(Color.rgb(255, 255, 255));
                Layout3_3.addView(nocontents);
                nocontents.setTextSize(18);
                Layout3.addView(Layout3_3);
            } else {
                Layout4.setLayoutParams(params4);
                Layout4.setOrientation(LinearLayout.VERTICAL);
                Layout4.setGravity(Gravity.CENTER);
                Layout4.setFocusableInTouchMode(true);
                Layout4.addView(progressbar);
            }

            int jj = creator_list_p_thumbnail.size() / 4 + 1;
            int y = creator_list_p_thumbnail.size() % 4;

            int j = 0;
            for (int ii = 0; ii < jj; ii++) {
                LinearLayout Layout3_3 = new LinearLayout(this);
                Layout3_3.setLayoutParams(params3_3);
                Layout3_3.setGravity(Gravity.CENTER | Gravity.LEFT);
                Layout3.addView(Layout3_3);

                if (ii == jj - 1) {
                    if (y == 0) {
                        Layout3.removeView(Layout3_3);
                    }
                    for (int iii = 0; iii < y; iii++) {
                        LinearLayout Layout3_3_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_2 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_2_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_2_2 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_2_2_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_2_2_2 = new LinearLayout(this);

                        Layout3_3_1.setGravity(Gravity.CENTER);
                        ImageView IV11 = new ImageView(this);
                        CircleImageView CIV11 = new CircleImageView(this);
                        IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 286));
                        CIV11.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
                        TextView TV11_1 = new TextView(this);
                        TextView TV11_2 = new TextView(this);

                        try {
                            Glide.with(this).load(imageurl + creator_list_p_thumbnail.get(j).get(0)).into(IV11);
                            Glide.with(this).load(imageurl + creator_list_profile.get(j)).into(CIV11);

                            IV11.setScaleType(ImageView.ScaleType.FIT_XY);

                            Layout3_3_1_1.setOrientation(LinearLayout.VERTICAL);
                            Layout3_3_1_1.setFocusableInTouchMode(true);

                            TV11_1.setText(creator_list_description.get(j));
                            TV11_1.setTextSize(14);
                            TV11_1.setTextColor(Color.rgb(255, 255, 255));
                            TV11_2.setText(creator_list_nickname.get(j) + "\n" + creator_list_view_count.get(j) + " views");
                            TV11_2.setTextSize(10);
                            TV11_2.setTextColor(Color.rgb(255, 255, 255));

                        } catch (Exception e) {
                            Layout3_3_1_1_1.setBackgroundColor(Color.rgb(100, 100, 100));
                        }

                        Layout3_3_1_1.addView(Layout3_3_1_1_1);
                        Layout3_3_1_1_1.addView(IV11);
                        Layout3_3_1_1.addView(Layout3_3_1_1_2);
                        Layout3_3_1_1_2.setLayoutParams(params3);
                        Layout3_3_1_1_2.setOrientation(LinearLayout.VERTICAL);
                        Layout3_3_1_1_2.addView(Layout3_3_1_1_2_1);
                        Layout3_3_1_1_2.setGravity(Gravity.CENTER);
                        Layout3_3_1_1_2_1.addView(TV11_1);
                        TV11_1.setPadding(30, 0, 60, 0);
                        Layout3_3_1_1_2_1.setLayoutParams(paramsTitleTV);
                        Layout3_3_1_1_2.addView(Layout3_3_1_1_2_2);
                        Layout3_3_1_1_2_2.setOrientation(LinearLayout.HORIZONTAL);
                        Layout3_3_1_1_2_2.addView(Layout3_3_1_1_2_2_1);
                        Layout3_3_1_1_2_2.setPadding(0, 0, 0, 10);
                        Layout3_3_1_1_2_2_1.setPadding(25, 0, 0, 0);
                        Layout3_3_1_1_2_2_1.addView(CIV11);
                        Layout3_3_1_1_2_2_2.setLayoutParams(params3);
                        Layout3_3_1_1_2_2_2.setOrientation(LinearLayout.VERTICAL);
                        Layout3_3_1_1_2_2.addView(Layout3_3_1_1_2_2_2);
                        Layout3_3_1_1_2_2_2.setGravity(Gravity.CENTER | Gravity.CENTER);
                        Layout3_3_1_1_2_2_2.addView(TV11_2);

                        Layout3_3_1_1_2_2_1.setLayoutParams(paramsCIV);
                        Layout3_3_1_1_2_2_1.setGravity(Gravity.CENTER);

                        Layout3_3_1_1.setLayoutParams(paramsMainLayout);
                        Layout3_3_1_1.setFocusableInTouchMode(true);

                        Layout3_3_1.addView(Layout3_3_1_1);
                        Layout3_3.addView(Layout3_3_1);

                        Layout3_3_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus == false) {
                                    Layout3_3_1_1.setBackground(null);
                                    TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));

                                    Layout3_3_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                        @Override
                                        public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                            if (hasFocus) {
                                                Layout3_3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                                TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                                TV11_2.setTextColor(Color.rgb(0, 0, 0));
                                            } else {
                                                Layout3_3_1_1.setBackground(null);
                                                TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                                TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                            }
                                        }
                                    });

                                } else {
                                    Layout3_3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                    TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                    TV11_2.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                                }
                            }
                        });

                        if (ii == 0 && iii == 0) {
                            Layout3_3_1_1.setId(R.id.LayoutCreator);
                            Layout3_3_1_1.requestFocus();
                            Layout3_3_1_1.setNextFocusLeftId(R.id.creator1);
                        }

                        if (iii == 0) {
                            Layout3_3_1_1.setId(R.id.LayoutCreator);
                            Layout3_3_1_1.setNextFocusLeftId(R.id.creator1);
                        }

                        final int jjj = j;
                        Layout3_3_1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                nowurl = imageurl + creator_feed_list_video.get(jjj);
//                                maintitle = creator_feed_list_content.get(jjj);
//                                subtitle = creator_feed_list_content.get(jjj);
//                                creatortitle = creator_feed_list_author_nickname.get(jjj);
//                                creatorprofile = imageurl + creator_feed_list_author_picture.get(jjj);
//                                creatorauthorid = creator_id;
                                Intent intent = new Intent(CreatorActivity.this, AliseonOTTPlayerActivity.class);
                                intent.putExtra("index", jjj);
                                intent.putExtra("category", 6);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                            }
                        });

                        j++;

                    }
                } else {
                    for (int iii = 0; iii < 4; iii++) {
                        LinearLayout Layout3_3_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_2 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_2_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_2_2 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_2_2_1 = new LinearLayout(this);
                        LinearLayout Layout3_3_1_1_2_2_2 = new LinearLayout(this);

                        Layout3_3_1.setGravity(Gravity.CENTER);
                        ImageView IV11 = new ImageView(this);
                        CircleImageView CIV11 = new CircleImageView(this);
                        IV11.setLayoutParams(new ViewGroup.LayoutParams(420, 286));
                        CIV11.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
                        TextView TV11_1 = new TextView(this);
                        TextView TV11_2 = new TextView(this);

                        try {
                            Glide.with(this).load(imageurl + creator_list_p_thumbnail.get(j).get(0)).into(IV11);
                            Glide.with(this).load(imageurl + creator_list_profile.get(j)).into(CIV11);

                            IV11.setScaleType(ImageView.ScaleType.FIT_XY);

                            Layout3_3_1_1.setOrientation(LinearLayout.VERTICAL);
                            Layout3_3_1_1.setFocusableInTouchMode(true);

                            TV11_1.setText(creator_list_description.get(j));
                            TV11_1.setTextSize(14);
                            TV11_1.setTextColor(Color.rgb(255, 255, 255));
                            TV11_2.setText(creator_list_nickname.get(j) + "\n" + creator_list_view_count.get(j) + " views");
                            TV11_2.setTextSize(10);
                            TV11_2.setTextColor(Color.rgb(255, 255, 255));

                        } catch (Exception e) {

                        }

                        Layout3_3_1_1.addView(Layout3_3_1_1_1);
                        Layout3_3_1_1_1.addView(IV11);
                        Layout3_3_1_1.addView(Layout3_3_1_1_2);
                        Layout3_3_1_1_2.setLayoutParams(params3);
                        Layout3_3_1_1_2.setOrientation(LinearLayout.VERTICAL);
                        Layout3_3_1_1_2.addView(Layout3_3_1_1_2_1);
                        Layout3_3_1_1_2.setGravity(Gravity.CENTER);
                        Layout3_3_1_1_2_1.addView(TV11_1);
                        TV11_1.setPadding(30, 0, 60, 0);
                        Layout3_3_1_1_2_1.setLayoutParams(paramsTitleTV);
                        Layout3_3_1_1_2.addView(Layout3_3_1_1_2_2);
                        Layout3_3_1_1_2_2.setOrientation(LinearLayout.HORIZONTAL);
                        Layout3_3_1_1_2_2.addView(Layout3_3_1_1_2_2_1);
                        Layout3_3_1_1_2_2.setPadding(0, 0, 0, 10);
                        Layout3_3_1_1_2_2_1.setPadding(25, 0, 0, 0);
                        Layout3_3_1_1_2_2_1.addView(CIV11);
                        Layout3_3_1_1_2_2_2.setLayoutParams(params3);
                        Layout3_3_1_1_2_2_2.setOrientation(LinearLayout.VERTICAL);
                        Layout3_3_1_1_2_2.addView(Layout3_3_1_1_2_2_2);
                        Layout3_3_1_1_2_2_2.setGravity(Gravity.CENTER | Gravity.CENTER);
                        Layout3_3_1_1_2_2_2.addView(TV11_2);

                        Layout3_3_1_1_2_2_1.setLayoutParams(paramsCIV);
                        Layout3_3_1_1_2_2_1.setGravity(Gravity.CENTER);

                        Layout3_3_1_1.setLayoutParams(paramsMainLayout);
                        Layout3_3_1_1.setFocusableInTouchMode(true);

                        Layout3_3_1.addView(Layout3_3_1_1);
                        Layout3_3.addView(Layout3_3_1);

                        Layout3_3_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus == false) {
                                    Layout3_3_1_1.setBackground(null);
                                    TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                    TV11_1.setTextColor(Color.rgb(255, 255, 255));

                                    Layout3_3_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                                        @Override
                                        public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                            if (hasFocus) {
                                                Layout3_3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                                TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                                TV11_2.setTextColor(Color.rgb(0, 0, 0));
                                            } else {
                                                Layout3_3_1_1.setBackground(null);
                                                TV11_1.setTextColor(Color.rgb(255, 255, 255));
                                                TV11_2.setTextColor(Color.rgb(255, 255, 255));
                                            }
                                        }
                                    });

                                } else {
                                    Layout3_3_1_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                    TV11_1.setTextColor(Color.rgb(0, 0, 0));
                                    TV11_2.setTextColor(Color.rgb(0, 0, 0));
//                    Home.setImageResource(R.drawable.homeselect);
                                }
                            }
                        });

                        if (ii == 0 && iii == 0) {
                            Layout3_3_1_1.setId(R.id.LayoutCreator);
                            Layout3_3_1_1.requestFocus();
                            Layout3_3_1_1.setNextFocusLeftId(R.id.creator1);
                        }

                        if (iii == 0) {
                            Layout3_3_1_1.setId(R.id.LayoutCreator);
                            Layout3_3_1_1.setNextFocusLeftId(R.id.creator1);
                        }

                        final int jjj = j;
                        Layout3_3_1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(CreatorActivity.this, AliseonOTTPlayerActivity.class);
                                intent.putExtra("index", jjj);
                                intent.putExtra("category", 6);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                            }
                        });

                        j++;

                    }
                }
            }

            Layout4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus == false) {

                    } else {

                        creatoractivityhandler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressbar.setVisibility(View.VISIBLE);
                                creatorstart = creatorstart + 12;

                                NetworkTaskCreatorList networktaskcreatorlist = new NetworkTaskCreatorList(api_my_list, null);
                                networktaskcreatorlist.execute();

                            }
                        });
                    }
                }
            });

            Layout1.addView(scrollview);

            scrollview.addView(Layout3);
            Layout3.addView(Layout4);

            setContentView(Layout1);

            topbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scrollview.smoothScrollTo(0, 0);
                    LinearLayout Layout3_3_1_1 = (LinearLayout) findViewById(R.id.LayoutCreator);
                    Layout3_3_1_1.requestFocus();
                }
            });

//        Home.setNextFocusRightId(R.id.subscribe1);
//        Search.setNextFocusRightId(R.id.subscribe1);
//        User.setNextFocusRightId(R.id.subscribe1);
//        Home.setNextFocusUpId(R.id.subscribeuser);
//        User.setNextFocusDownId(R.id.subscribehome);

        }
    }

}
