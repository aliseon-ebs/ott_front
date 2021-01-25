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

import com.aliseon.ott.API.CreatorMyInfo;
import com.aliseon.ott.API.MyList;
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


public class MyActivity extends AppCompatActivity {

    private static String TAG = "현재 url 가져오기";


    private AliseonAPI AliseonAPI;

    CircleImageView My;

    public static MyActivityHandler myactivityhandler;
    public static MyActivityContentsLoadingHandler myactivitycontentsloadinghandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();
        Integer myapiload = aliseon.aliseon_getMyAPIload();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        Log.d("MYPOST", String.valueOf(myapiload));

        if (myapiload == 0) {

            Log.d("MYPOST", "API is 0");

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
                    MyInfoPost();
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
                Glide.with(this).load(imageurl + prf.getString("userinfo_picture", "")).into(My);
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

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();
        Integer myapiload = aliseon.aliseon_getMyAPIload();

        String my_id = aliseon.aliseon_getMy_id();
        String my_nickname = aliseon.aliseon_getMy_nickname();
        String my_photo = aliseon.aliseon_getMy_photo();
        String my_desc = aliseon.aliseon_getMy_desc();
        String my_subscribeto_cnt = aliseon.aliseon_getMy_subscribeto_cnt();
        ArrayList<ArrayList<String>> my_list_p_thumbnail = aliseon.aliseon_getMy_list_p_thumbnail();
        ArrayList<String> my_list_profile = aliseon.aliseon_getMy_list_profile();
        ArrayList<String> my_list_nickname = aliseon.aliseon_getMy_list_nickname();
        ArrayList<String> my_list_description = aliseon.aliseon_getMy_list_description();
        ArrayList<Integer> my_list_view_count = aliseon.aliseon_getMy_list_view_count();
        int mystart = aliseon.aliseon_getMystart();
        int mylimit = aliseon.aliseon_getMylimit();

        ArrayList<String> my_list_id = aliseon.aliseon_getMy_list_id();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

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

            Log.d("VALUEERRORTEST", "ASD : " + my_desc);

            if (my_desc != null) {
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
                                Intent intent = new Intent(MyActivity.this, AliseonOTTPlayerActivity.class);
                                intent.putExtra("index", jjj);
                                intent.putExtra("category",4);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
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

                                Intent intent = new Intent(MyActivity.this, AliseonOTTPlayerActivity.class);
                                intent.putExtra("index", jjj);
                                intent.putExtra("category",4);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
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

                                int mystart = aliseon.aliseon_getMystart();
                                int mylimit = aliseon.aliseon_getMylimit();

                                progressbar.setVisibility(View.VISIBLE);
                                if(mystart == 0){
                                    mystart = mystart + 12;
                                } else {
                                    mystart = mystart + 8;
                                }
                                mylimit = 12;
//                                NetworkTaskMyList networktaskmylist = new NetworkTaskMyList(api_my_list, null);
//                                networktaskmylist.execute();
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

    private void MyInfoPost() {

        Log.d("MYPOSTRUN", "YES IT IS");

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        Integer user_id = aliseon.aliseon_getLoginid();

        Log.d("MYPOSTRUN", "USER ID : " + user_id);
        Log.d("MYPOSTRUN", "ACCESSTOKEN : " + access_token);

        Call<CreatorMyInfo> call = AliseonAPI.CreatorMyInfoPost(access_token, String.valueOf(user_id));

        call.enqueue(new Callback<CreatorMyInfo>() {
            @Override
            public void onResponse(Call<CreatorMyInfo> call, Response<CreatorMyInfo> response) {

                Log.d("MYPOSTAPI", "MYINFORUN");

                Integer myapiload = aliseon.aliseon_getMyAPIload();

                CreatorMyInfo postResponse = (CreatorMyInfo) response.body();

                Log.d("MYPOSTAPI", String.valueOf(postResponse));

                try {

                    String id = postResponse.creator_my_list.getId();
                    String nickname = postResponse.creator_my_list.getNickname();
                    String photo = postResponse.creator_my_list.getPhoto();
                    String zip = postResponse.creator_my_list.getZip();
                    String city = postResponse.creator_my_list.getCity();
                    String state = postResponse.creator_my_list.getState();
                    String address = postResponse.creator_my_list.getAddress();
                    String subscribeto_cnt = String.valueOf(postResponse.creator_my_list.getSubscribetoCnt());
                    String contents_cnt = String.valueOf(postResponse.creator_my_list.getContentsCnt());
                    String desc = postResponse.creator_my_list.getDesc();

                    aliseon.aliseon_setMy_id(id);
                    aliseon.aliseon_setMy_nickname(nickname);
                    aliseon.aliseon_setMy_photo(photo);
                    aliseon.aliseon_setMy_zip(zip);
                    aliseon.aliseon_setMy_city(city);
                    aliseon.aliseon_setMy_state(state);
                    aliseon.aliseon_setMy_address(address);
                    aliseon.aliseon_setMy_subscribeto_cnt(subscribeto_cnt);
                    aliseon.aliseon_setMy_contents_cnt(contents_cnt);
                    aliseon.aliseon_setMy_desc(desc);

                    Log.d("MyInfoDATA", "내정보: " + id + "/" + nickname + "/" + photo + "/" + zip + "/" + city + "/" + state + "/" + address + "/" + subscribeto_cnt + "/" + contents_cnt + "/" + desc);

                    Log.d("MYPOST","APILOADCHECK " + myapiload);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (myapiload == 0) {
                    MyListPost();

                } else if (myapiload == 1) {
                    myactivityhandler.sendEmptyMessage(800);
                }



            }

            @Override
            public void onFailure(Call<CreatorMyInfo> call, Throwable t) {
                Log.d("MYPOSTAPI", "ERROR=================================");
                Log.d("MYPOSTAPI", String.valueOf(t));
                Log.d("MYPOSTAPI", "ERROR=================================");
            }
        });
    }

    private void MyListPost() {

        Log.d("MYPOSTRUN", "FROM LIST POST YES");

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        Integer user_id = aliseon.aliseon_getLoginid();
        Integer mystart = aliseon.aliseon_getMystart();
        Integer mylimit = aliseon.aliseon_getMylimit();

        // 다른 Activity와 같은 API를 사용함, 혼동 가능성 있으니 주의
        Call<MyList> call = AliseonAPI.MyListPost(access_token, String.valueOf(user_id), 1, 0, mystart, mylimit);

        call.enqueue(new Callback<MyList>() {

            @Override
            public void onResponse(Call<MyList> call, Response<MyList> response) {

                Integer myapiload = aliseon.aliseon_getMyAPIload();

                MyList postResponse = (MyList) response.body();

                ArrayList<String> my_list_id = new ArrayList<>();
                ArrayList<String> my_list_user_id = new ArrayList<>();
                ArrayList<Integer> my_list_status = new ArrayList<>();
                ArrayList<String> my_list_description = new ArrayList<>();
                ArrayList<String> my_list_create_at = new ArrayList<>();
                ArrayList<String> my_list_update_at = new ArrayList<>();
                ArrayList<Integer> my_list_like_count  = new ArrayList<>();
                ArrayList<Integer> my_list_view_count  = new ArrayList<>();
                ArrayList<Integer> my_list_comment_count  = new ArrayList<>();
                ArrayList<String> my_list_nickname  = new ArrayList<>();
                ArrayList<String> my_list_profile = new ArrayList<>();
                ArrayList<ArrayList<String>> my_list_p_thumbnail= new ArrayList<ArrayList<String>>();


                try {
                    for (int i = 0; i < postResponse.my_list.size(); i++) {

                        ArrayList<String> my_list_c_thumbnail = new ArrayList<>();

                        String id = postResponse.my_list.get(i).getId();
                        String user_id = postResponse.my_list.get(i).getUserId();
                        Integer status = postResponse.my_list.get(i).getStatus();
                        String description = postResponse.my_list.get(i).getDescription();
                        String create_at = postResponse.my_list.get(i).getCreateAt();
                        String update_at = postResponse.my_list.get(i).getUpdateAt();
                        Integer like_count = postResponse.my_list.get(i).getLikeCount();
                        Integer view_count = postResponse.my_list.get(i).getViewCount();
                        Integer comment_count = postResponse.my_list.get(i).getCommentCount();
                        String nickname = postResponse.my_list.get(i).getNickname();
                        String profile = postResponse.my_list.get(i).getProfile();
                        ArrayList<String> c_thumbnail = postResponse.my_list.get(i).getThumbnail();

                        my_list_id.add(id);
                        my_list_user_id.add(user_id);
                        my_list_status.add(status);

                        if (description.length() > 25) {
                            my_list_description.add(description.substring(0, 25) + "...");
                        } else {
                            my_list_description.add(description);
                        }

                        my_list_create_at.add(create_at);
                        my_list_update_at.add(update_at);
                        my_list_like_count.add(like_count);
                        my_list_view_count.add(view_count);
                        my_list_comment_count.add(comment_count);
                        my_list_nickname.add(nickname);
                        my_list_profile.add(profile);

                        try {
                            if (c_thumbnail != null) {
                                for (int ii = 0; ii < c_thumbnail.size(); ii++) {
                                    String thumbnail = c_thumbnail.get(ii);
                                    my_list_c_thumbnail.add(thumbnail);
                                }
                                my_list_p_thumbnail.add(my_list_c_thumbnail);

                            } else {
                                my_list_p_thumbnail.add(my_list_c_thumbnail);
                            }
                        } catch (Exception e) {

                        }
                    }

                } catch (Exception e){
                    e.printStackTrace();
                }

                aliseon.aliseon_setMy_list_id(my_list_id);
                aliseon.aliseon_setMy_list_user_id(my_list_user_id);
                aliseon.aliseon_setMy_list_status(my_list_status);
                aliseon.aliseon_setMy_list_description(my_list_description);
                aliseon.aliseon_setMy_list_create_at(my_list_create_at);
                aliseon.aliseon_setMy_list_update_at(my_list_update_at);
                aliseon.aliseon_setMy_list_like_count(my_list_like_count);
                aliseon.aliseon_setMy_list_view_count(my_list_view_count);
                aliseon.aliseon_setMy_list_comment_count(my_list_comment_count);
                aliseon.aliseon_setMy_list_nickname(my_list_nickname);
                aliseon.aliseon_setMy_list_profile(my_list_profile);
                aliseon.aliseon_setMy_list_p_thumbnail(my_list_p_thumbnail);

                if (myapiload == 0) {
                    aliseon.aliseon_setMyAPIload(1);
                    myactivityhandler.sendEmptyMessage(1000);
                } else if (myapiload == 1) {
                    myactivitycontentsloadinghandler.sendEmptyMessage(1000);
                }





            }

            @Override
            public void onFailure(Call<MyList> call, Throwable t) {

            }

        });


    }
}
