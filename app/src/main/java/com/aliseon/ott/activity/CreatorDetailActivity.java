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
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.aliseon.ott.API.MyList;
import com.aliseon.ott.API.SubscribeFrom;
import com.aliseon.ott.API.SubscribePost;
import com.aliseon.ott.API.SubscribeTo;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.aliseon.ott.Aliseon.CreatorDetailClear;

public class CreatorDetailActivity extends AppCompatActivity {
    CircleImageView My;

    private AliseonAPI AliseonAPI;
    private ArrayList<Integer> btnId = new ArrayList<>();

    public static CreatorActivityDetailHandler creatoractivitydetailhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();

        int creatordetailapiload = aliseon.aliseon_getCreatorDetailAPIload();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        if(creatordetailapiload == 0){

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

        creatoractivitydetailhandler = new CreatorActivityDetailHandler();

        creatoractivitydetailhandler.post(new Runnable() {
            @Override
            public void run() {
                SubscribeToPost();
            }
        });

            LinearLayout Layout1 = new LinearLayout(this);

            LinearLayout Layout2 = new LinearLayout(this);
            LinearLayout Layout2_1 = new LinearLayout(this);
            LinearLayout Layout2_2 = new LinearLayout(this);

            LinearLayout Layout3 = new LinearLayout(this);
            LinearLayout Layout3_1 = new LinearLayout(this); // top title
            LinearLayout Layout3_1_1 = new LinearLayout(this);
            LinearLayout Layout3_1_2 = new LinearLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this); // for scroller

            ScrollView scroller1 = new ScrollView(this);

            LinearLayout Layout3_2_1 = new LinearLayout(this);
            LinearLayout Layout3_2_1_1 = new LinearLayout(this);
            LinearLayout Layout3_2_1_2 = new LinearLayout(this);


            ImageView BackArrow = new ImageView(this);
            BackArrow.setFocusableInTouchMode(true);
            BackArrow.setPadding(10, 10, 10, 10);
            BackArrow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            TextView BackArrowText = new TextView(this);

            Button topbutton = new Button(this);
            topbutton.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            topbutton.setLayoutParams(new ViewGroup.LayoutParams(90, 65));
            topbutton.setTextColor(Color.rgb(255, 255, 255));
            topbutton.setTextSize(10);

            BackArrow.setImageResource(R.drawable.backarrow);
            BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);

            ImageView SubscriberImage = new ImageView(this);
            SubscriberImage.setImageResource(R.drawable.noing_category);
            SubscriberImage.setScaleType(ImageView.ScaleType.FIT_START);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT); // 90 -> 150
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
            LinearLayout.LayoutParams paramsTopButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 160);
            LinearLayout.LayoutParams params4_0 = new LinearLayout.LayoutParams(100, 160);
            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4_2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 0.65f);

            params2_2.leftMargin = 10;     // ?????? ??? ??????
            params4_2.rightMargin = 70;

            /* setOrientation */
            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2_1.setOrientation(LinearLayout.VERTICAL);
            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_1_1.setGravity(Gravity.CENTER);
            Layout3_1_2.setGravity(Gravity.CENTER | Gravity.LEFT);
            Layout3_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_2_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_2_1_1.setOrientation(LinearLayout.VERTICAL);
            Layout3_2_1_2.setOrientation(LinearLayout.VERTICAL);

            Layout2.setGravity(Gravity.CENTER);
            Layout2_1.setLayoutParams(paramsBackArrow);
            Layout2_1.addView(BackArrow);
            Layout2_1.setGravity(Gravity.CENTER);
            Layout2.addView(Layout2_1);
            Layout2_2.setLayoutParams(paramsTopButton);
            Layout2_2.addView(topbutton);
            Layout2_2.setGravity(Gravity.CENTER);
            Layout2.addView(Layout2_2);

            /* setBackgroundColor */
            Layout2.setBackgroundColor(Color.rgb(29, 29, 29));   // ??????????????? ??? ??????
            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));

            /* setLayoutParams */
            Layout1.setLayoutParams(params);
            Layout2.setLayoutParams(params2);

            Layout3.setLayoutParams(params);
            Layout3_1.setLayoutParams(params3); // height: 90
            Layout3_1_1.setLayoutParams(paramsBackArrow);
            Layout3_1_2.setLayoutParams(params);
            Layout3_2.setLayoutParams(params);
            Layout3_2_1.setLayoutParams(params);
            Layout3_2_1_1.setLayoutParams(params2_1);
            Layout3_2_1_2.setLayoutParams(params2_1);

            scroller1.setLayoutParams(params);

            Layout3_1.addView(Layout3_1_1);
            Layout3_1.addView(Layout3_1_2);

            Layout3_1_2.addView(SubscriberImage);

            Layout3_2_1.addView(Layout3_2_1_1);

            scroller1.addView(Layout3_2_1);

            for (int i = 0; i < 10; i++) {
                LinearLayout Layout4 = new LinearLayout(this);
                Layout4.setLayoutParams(params4);
                Layout4.setPadding(5, 5, 5, 5); // ????????? ?????????

                LinearLayout Layout4_0 = new LinearLayout(this);
                Layout4_0.setLayoutParams(params4_0);

                LinearLayout Layout4_1 = new LinearLayout(this);
                Layout4_1.setGravity(Gravity.CENTER);
                Layout4_1.setLayoutParams(params4_1);

                LinearLayout Layout4_2 = new LinearLayout(this);
                Layout4_2.setGravity(Gravity.CENTER);
                Layout4_2.setLayoutParams(params4_2);
                Layout4_2.setOrientation(LinearLayout.VERTICAL);
                Layout4_2.setFocusableInTouchMode(true);

                LinearLayout Layout4_3 = new LinearLayout(this);
                Layout4_3.setGravity(Gravity.LEFT | Gravity.CENTER);
                Layout4_3.setLayoutParams(params4_2);

                CircleImageView CIV = new CircleImageView(this);
                CIV.setLayoutParams(new ViewGroup.LayoutParams(120, 120));
                if(CIV != null){
                    CIV.setImageResource(R.drawable.noing_creator);
                }
                ImageView IV1 = new ImageView(this);
                IV1.setImageResource(R.drawable.noing_category);
                IV1.setScaleType(ImageView.ScaleType.FIT_CENTER);

                Button button = new Button(this);
                button.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
                button.setLayoutParams(new ViewGroup.LayoutParams(250, 70));
                button.setTextColor(Color.rgb(255, 255, 255));
                button.setTextSize(10);

                Layout4_1.addView(CIV);
                Layout4_2.addView(IV1);
                Layout4_3.addView(button);

                Layout4.addView(Layout4_0);
                Layout4.addView(Layout4_1);
                Layout4.addView(Layout4_2);
                Layout4.addView(Layout4_3);
                Layout3_2_1_1.addView(Layout4);
            }

            BackArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            Layout3_2.addView(scroller1);

            Layout3.addView(Layout3_1);
            Layout3.addView(Layout3_2);

            Layout1.addView(Layout2);
            Layout1.addView(Layout3);

            setContentView(Layout1);

        }
    }

    protected void onResume() {
        super.onResume();

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        int loginid = aliseon.aliseon_getLoginid();

        int refresh_num = aliseon.aliseon_getRefresh_num();

        int creatorapiload = aliseon.aliseon_getCreatorAPIload();
        int creatordetailapiload = aliseon.aliseon_getCreatorDetailAPIload();

        ArrayList<Integer> creatordetail_list_id = aliseon.aliseon_getCreatordetail_list_id();
        ArrayList<String> creatordetail_list_photo = aliseon.aliseon_getCreatordetail_list_photo();
        ArrayList<String> creatordetail_list_nickname = aliseon.aliseon_getCreatordetail_list_nickname();
        ArrayList<Integer> creatordeatil_list_subscribe = aliseon.aliseon_getCreatordetail_list_is_subscribe();
        ArrayList<Integer> creatordetail_list_subscribeto_cnt = aliseon.aliseon_getCreatordetail_list_subscribeto_cnt();
        ArrayList<Integer> creatordetail_list_contents_cnt = aliseon.aliseon_getCreatordetail_list_contents_cnt();

        ArrayList<Integer> subscribe_creator_list_id = aliseon.aliseon_getSubscribe_creator_list_id();
        int subscribe_checker = aliseon.aliseon_getSubscribe_checker();

        int param_subscribe_to_id = aliseon.aliseon_getParam_subscribe_to_id();
        int param_subscribe_activity = aliseon.aliseon_getParam_subscribe_activity();
        String param_subscribe_type = aliseon.aliseon_getParam_subscribe_type();

        ArrayList<Integer> creatordetail_list_is_subscribe = aliseon.aliseon_getCreatordetail_list_is_subscribe();



        if (creatordetailapiload == 1) {

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
            LinearLayout Layout3_1 = new LinearLayout(this); // top title
            LinearLayout Layout3_1_1 = new LinearLayout(this);
            LinearLayout Layout3_1_2 = new LinearLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this); // for scroller

            ScrollView scroller1 = new ScrollView(this);

            LinearLayout Layout3_2_1 = new LinearLayout(this);
            LinearLayout Layout3_2_1_1 = new LinearLayout(this);
            LinearLayout Layout3_2_1_2 = new LinearLayout(this);


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
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            Cart.setPadding(15, 15, 15, 15);
            My.setPadding(15, 15, 15, 15);
            Setting.setPadding(15, 15, 15, 15);

            ImageView BackArrow = new ImageView(this);
            BackArrow.setFocusableInTouchMode(true);
            BackArrow.setPadding(10, 10, 10, 10);
            BackArrow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            TextView BackArrowText = new TextView(this);

            Button topbutton = new Button(this);
            topbutton.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            topbutton.setLayoutParams(new ViewGroup.LayoutParams(90, 65));
            topbutton.setTextColor(Color.rgb(255, 255, 255));
            topbutton.setTextSize(10);
            topbutton.setText("TOP");

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
            Glide.with(this).load(prf.getString("userinfo_picture", "")).into(My);
            Setting.setImageResource(R.drawable.setting);
            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);

            BackArrow.setImageResource(R.drawable.backarrow);
            BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BackArrowText.setTextSize(20);
            BackArrowText.setTextColor(Color.rgb(255, 255, 255));
            BackArrowText.setText(getResources().getString(R.string.subscriber));
            BackArrowText.setPadding(0, 0, 0, 10);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT); // 90 -> 150
            LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
            LinearLayout.LayoutParams paramsTopButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 160);
            LinearLayout.LayoutParams params4_0 = new LinearLayout.LayoutParams(100, 160);
            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4_2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 0.65f);

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

            params2_2.leftMargin = 10;     // ?????? ??? ??????
            params4_2.rightMargin = 70;

            /* setOrientation */
            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2_1.setOrientation(LinearLayout.VERTICAL);
            Layout2_2.setOrientation(LinearLayout.VERTICAL);
            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_1_1.setGravity(Gravity.CENTER);
            Layout3_1_2.setGravity(Gravity.CENTER | Gravity.LEFT);
            Layout3_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_2_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout3_2_1_1.setOrientation(LinearLayout.VERTICAL);
            Layout3_2_1_2.setOrientation(LinearLayout.VERTICAL);

            Layout2.setGravity(Gravity.CENTER);
            Layout2_1.setLayoutParams(paramsBackArrow);
            Layout2_1.setGravity(Gravity.CENTER);
            Layout2_1.addView(BackArrow);
            Layout2.addView(Layout2_1);
            Layout2_2.setLayoutParams(paramsTopButton);
            Layout2_2.setGravity(Gravity.CENTER);
            Layout2_2.addView(topbutton);
            Layout2.addView(Layout2_2);

            /* setBackgroundColor */
            Layout2.setBackgroundColor(Color.rgb(29, 29, 29));   // ??????????????? ??? ??????
            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));

            /* setLayoutParams */
            Layout1.setLayoutParams(params);
            Layout2.setLayoutParams(params2);

            Layout3.setLayoutParams(params);
            Layout3_1.setLayoutParams(params3); // height: 90
            Layout3_1_1.setLayoutParams(paramsBackArrow);
            Layout3_1_2.setLayoutParams(params);
            Layout3_2.setLayoutParams(params);
            Layout3_2_1.setLayoutParams(params);
            Layout3_2_1_1.setLayoutParams(params2_1);
            Layout3_2_1_2.setLayoutParams(params2_1);

            scroller1.setLayoutParams(params);

            Layout3_1.addView(Layout3_1_1);
            Layout3_1.addView(Layout3_1_2);

//        Layout3_1_1.addView(BackArrow);
            Layout3_1_2.addView(BackArrowText);

            Layout3_2_1.addView(Layout3_2_1_1);
//        Layout3_2_1.addView(Layout3_2_1_2);

            scroller1.addView(Layout3_2_1);

            if (creatordetail_list_id.size() == 0){

                LinearLayout Layout4 = new LinearLayout(this);
                Layout4.setLayoutParams(params);
                Layout4.setGravity(Gravity.CENTER);

                TextView nocontents = new TextView(this);
                nocontents.setText(getString(R.string.nofollowers));
                nocontents.setTextColor(Color.rgb(255, 255, 255));
                Layout4.addView(nocontents);
                Layout3_2.addView(Layout4);
                nocontents.setTextSize(18);

            } else {

                creatordetail_list_is_subscribe.clear();
                for (int i = 0; i < creatordetail_list_id.size(); i++) {
                    creatordetail_list_is_subscribe.add(0);
                    aliseon.aliseon_setCreatordetail_list_is_subscribe(creatordetail_list_is_subscribe);
                }

                // FOR
                for (int i = 0; i < creatordetail_list_id.size(); i++) {

                    LinearLayout Layout4 = new LinearLayout(this);
                    Layout4.setLayoutParams(params4);
                    Layout4.setPadding(5, 5, 5, 5); // ????????? ?????????

                    LinearLayout Layout4_0 = new LinearLayout(this);
                    Layout4_0.setLayoutParams(params4_0);

                    LinearLayout Layout4_1 = new LinearLayout(this);
                    Layout4_1.setGravity(Gravity.CENTER);
                    Layout4_1.setLayoutParams(params4_1);

                    LinearLayout Layout4_2 = new LinearLayout(this);
                    Layout4_2.setGravity(Gravity.CENTER);
                    Layout4_2.setLayoutParams(params4_2);
                    Layout4_2.setOrientation(LinearLayout.VERTICAL);
                    Layout4_2.setFocusableInTouchMode(true);

                    LinearLayout Layout4_3 = new LinearLayout(this);
                    Layout4_3.setGravity(Gravity.LEFT | Gravity.CENTER);
                    Layout4_3.setLayoutParams(params4_2);

                    CircleImageView CIV = new CircleImageView(this);
                    CIV.setLayoutParams(new ViewGroup.LayoutParams(120, 120));

                    try {

                        if (creatordetail_list_photo.get(i).contains("null")) {
                            CIV.setImageResource(R.drawable.noimg_profile);
                        } else {
                            Glide.with(this).load(imageurl + creatordetail_list_photo.get(i)).into(CIV);
                        }

                    } catch (Exception e) {

                        e.printStackTrace();
                        CIV.setImageResource(R.drawable.noimg_profile);

                    }


                    TextView TV1 = new TextView(this);
                    TV1.setTextColor(Color.rgb(255, 255, 255));
                    TV1.setTextSize(18);
                    TV1.setText(creatordetail_list_nickname.get(i));
                    TextView TV2 = new TextView(this);
                    TV2.setTextColor(Color.rgb(255, 255, 255));
                    TV2.setTextSize(14);
                    TV2.setText(getResources().getString(R.string.subscriber) + " " + creatordetail_list_subscribeto_cnt.get(i) + "   ??   " + getResources().getString(R.string.contents) + " " + creatordetail_list_contents_cnt.get(i));

                    Button button = new Button(this);
                    button.setId(button.generateViewId());

                    btnId.add(button.getId());

                    for(int ii = 0; ii < subscribe_creator_list_id.size(); ii++){

                        Log.d("SUBSCRIBECHECKER", String.valueOf(creatordetail_list_id.get(i)));
                        Log.d("SUBSCRIBECHECKER", String.valueOf(subscribe_creator_list_id.get(ii)));

                        if(creatordetail_list_id.get(i) == subscribe_creator_list_id.get(ii)){
                            subscribe_checker = 1;
                            Log.d("SUBSCRIBECHECKER", "ID MATCH FOUND");
                        }

                    }

                    if(subscribe_checker == 0){

                        creatordetail_list_is_subscribe.add(0);

                    } else if(subscribe_checker == 1){

                        creatordetail_list_is_subscribe.add(1);


                    }

                    final int j = i;

                    Layout4_1.addView(CIV);
                    Layout4_2.addView(TV1);
                    Layout4_2.addView(TV2);
                    Layout4_3.addView(button);

                    if (loginid == creatordetail_list_id.get(i)) {
                        Log.d("??????", creatordetail_list_id.get(i) + " / " + loginid);
                        Layout4_3.removeView(button);
                    }

                    Layout4.addView(Layout4_0);
                    Layout4.addView(Layout4_1);
                    Layout4.addView(Layout4_2);
                    Layout4.addView(Layout4_3);
                    Layout3_2_1_1.addView(Layout4); // LEFT

                    Layout4_2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // ???????????? ?????????

                        @Override
                        public void onFocusChange(View v, boolean hasFocus) { // ???????????? ???????????? ???????????? ?????????
                            if (hasFocus == false) {
                                Layout4_1.setBackground(null);
                                Layout4_2.setBackground(null);
                                TV1.setTextColor(Color.rgb(255, 255, 255));
                                TV2.setTextColor(Color.rgb(255, 255, 255));

                                Layout4_2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // ???????????? ?????????

                                    @Override
                                    public void onFocusChange(View v, boolean hasFocus) { // ???????????? ???????????? ???????????? ?????????
                                        if (hasFocus) {
                                            Layout4_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                            Layout4_2.setBackgroundColor(Color.rgb(255, 255, 255));
                                            TV1.setTextColor(Color.rgb(0, 0, 0));
                                            TV2.setTextColor(Color.rgb(0, 0, 0));
                                        } else {
                                            Layout4_1.setBackground(null);
                                            Layout4_2.setBackground(null);
                                            TV1.setTextColor(Color.rgb(255, 255, 255));
                                            TV2.setTextColor(Color.rgb(255, 255, 255));
                                        }
                                    }
                                });

                            } else {
                                Layout4_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                Layout4_2.setBackgroundColor(Color.rgb(255, 255, 255));
                                TV1.setTextColor(Color.rgb(0, 0, 0));
                                TV2.setTextColor(Color.rgb(0, 0, 0));

                            }
                        }
                    });

                    Layout4_2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            aliseon.aliseon_setCreatorAPIload(0);
                            aliseon.aliseon_setRefresh_num(0);
                            aliseon.aliseon_setParam_creator_info(creatordetail_list_id.get(j));
//                            creator_id = follower_uid.get(j);
                            Intent intent = new Intent(CreatorDetailActivity.this, CreatorActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                        }
                    });

                    subscribe_checker = 0;


//            if (i == 0 || i % 2 == 0) { // ????????? ?????? (0 ?????? ???????????? 0??? ???)
//                LinearLayout Layout4 = new LinearLayout(this);
//                Layout4.setLayoutParams(params4);
//                Layout4.setPadding(5,5,5,5); // ????????? ?????????
//
//                LinearLayout Layout4_1 = new LinearLayout(this);
//                Layout4_1.setGravity(Gravity.CENTER);
//                Layout4_1.setLayoutParams(params4_1);
//
//                LinearLayout Layout4_2 = new LinearLayout(this);
//                Layout4_2.setGravity(Gravity.CENTER);
//                Layout4_2.setLayoutParams(params4_2);
//                Layout4_2.setOrientation(LinearLayout.VERTICAL);
//
//                LinearLayout Layout4_3 = new LinearLayout(this);
//                Layout4_3.setGravity(Gravity.CENTER);
//                Layout4_3.setLayoutParams(params4_1);
//
//                CircleImageView CIV = new CircleImageView(this);
//                CIV.setLayoutParams(new ViewGroup.LayoutParams(120,120));
//                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(CIV);
//
//                TextView TV1 = new TextView(this);
//                TV1.setTextColor(Color.rgb(255,255,255));
//                TV1.setTextSize(18);
//                TV1.setText(my_nickname);
//                TextView TV2 = new TextView(this);
//                TV2.setTextColor(Color.rgb(255,255,255));
//                TV2.setTextSize(14);
//                TV2.setText(getResources().getString(R.string.subscriber) + " " + my_follower + "   |   " + getResources().getString(R.string.posting) + " " + my_contents_cnt);
//
//                Button button = new Button(this);
//                button.setText(getResources().getString(R.string.subscribe));
//                button.setBackground(ContextCompat.getDrawable(this,R.drawable.buttonsetting));
//                button.setLayoutParams(new ViewGroup.LayoutParams(160,70));
//                button.setTextColor(Color.rgb(255,255,255));
//                button.setTextSize(10);
//
//                Layout4_1.addView(CIV);
//                Layout4_2.addView(TV1);
//                Layout4_2.addView(TV2);
//                Layout4_3.addView(button);
//
//                Layout4.addView(Layout4_1);
//                Layout4.addView(Layout4_2);
//                Layout4.addView(Layout4_3);
//                Layout3_2_1_1.addView(Layout4); // LEFT
//
//            } else if (i % 2 == 1) { // ????????? ?????? (???????????? 1??? ???)
//                LinearLayout Layout4 = new LinearLayout(this);
//                Layout4.setLayoutParams(params4);
//                Layout4.setPadding(5,5,5,5); // ????????? ?????????
//
//                LinearLayout Layout4_1 = new LinearLayout(this);
//                Layout4_1.setGravity(Gravity.CENTER);
//                Layout4_1.setLayoutParams(params4_1);
//
//                LinearLayout Layout4_2 = new LinearLayout(this);
//                Layout4_2.setGravity(Gravity.CENTER);
//                Layout4_2.setLayoutParams(params4_2);
//                Layout4_2.setOrientation(LinearLayout.VERTICAL);
//
//                LinearLayout Layout4_3 = new LinearLayout(this);
//                Layout4_3.setGravity(Gravity.CENTER);
//                Layout4_3.setLayoutParams(params4_1);
//
//                CircleImageView CIV = new CircleImageView(this);
//                CIV.setLayoutParams(new ViewGroup.LayoutParams(120,120));
//                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(CIV);
//
//                TextView TV1 = new TextView(this);
//                TV1.setTextColor(Color.rgb(255,255,255));
//                TV1.setTextSize(18);
//                TV1.setText(my_nickname);
//                TextView TV2 = new TextView(this);
//                TV2.setTextColor(Color.rgb(255,255,255));
//                TV2.setTextSize(14);
//                TV2.setText(getResources().getString(R.string.subscriber) + " " + my_follower + "   |   " + getResources().getString(R.string.posting) + " " + my_contents_cnt);
//
//                Button button = new Button(this);
//                button.setText(getResources().getString(R.string.subscribe));
//                button.setBackground(ContextCompat.getDrawable(this,R.drawable.buttonsetting));
//                button.setLayoutParams(new ViewGroup.LayoutParams(160,70));
//                button.setTextColor(Color.rgb(255,255,255));
//                button.setTextSize(10);
//
//                Layout4_1.addView(CIV);
//                Layout4_2.addView(TV1);
//                Layout4_2.addView(TV2);
//                Layout4_3.addView(button);
//
//                Layout4.addView(Layout4_1);
//                Layout4.addView(Layout4_2);
//                Layout4.addView(Layout4_3);
//                Layout3_2_1_2.addView(Layout4); // RIGHT
//            }
                }

            }

            BackArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            Layout3_2.addView(scroller1);

            Layout3.addView(Layout3_1);
            Layout3.addView(Layout3_2);

            Layout1.addView(Layout2);
            Layout1.addView(Layout3);

            setContentView(Layout1);
        }

    }

    public class CreatorActivityDetailHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // ?????? Thread?????? ???????????? Message ??????
            if (msg.what == 1000) {
                onResume();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Aliseon aliseon = (Aliseon) getApplicationContext();
        aliseon.aliseon_setRefresh_num(0);
        aliseon.aliseon_setCreatorDetailAPIload(0);

        CreatorDetailClear();
        overridePendingTransition(0,0);
    }

    // ?????? ?????????????????? ???????????? ??????????????? ??????
    private void SubscribeToPost() {

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        int user_id = aliseon.aliseon_getParam_creator_info();

        Call<SubscribeTo> call = AliseonAPI.SubscribeToPost(access_token, String.valueOf(user_id));

        call.enqueue(new Callback<SubscribeTo>() {
            @Override
            public void onResponse(Call<SubscribeTo> call, Response<SubscribeTo> response) {

                int creatordetailapiload = aliseon.aliseon_getCreatorDetailAPIload();

                SubscribeTo postResponse = (SubscribeTo) response.body();

                aliseon.aliseon_setCreatordetail_list_id(null);
                aliseon.aliseon_setCreatordetail_list_nickname(null);
                aliseon.aliseon_setCreatordetail_list_photo(null);
                aliseon.aliseon_setCreatordetail_list_subscribeto_cnt(null);
                aliseon.aliseon_setCreatordetail_list_contents_cnt(null);

                ArrayList<Integer> creatordetail_list_id = new ArrayList<>();
                ArrayList<String> creatordetail_list_nickname = new ArrayList<>();
                ArrayList<String> creatordetail_list_photo = new ArrayList<>();
                ArrayList<Integer> creatordetail_list_subscribeto_cnt = new ArrayList<>();
                ArrayList<Integer> creatordetail_list_contents_cnt = new ArrayList<>();

                for (int i = 0; i < postResponse.subscribe_to_list.size(); i++) {

                    int id = postResponse.subscribe_to_list.get(i).getId();
                    String nickname = postResponse.subscribe_to_list.get(i).getNickname();
                    String photo = postResponse.subscribe_to_list.get(i).getPhoto();
                    int subscribeto_cnt = postResponse.subscribe_to_list.get(i).getSubscribetoCnt();
                    int contents_cnt = postResponse.subscribe_to_list.get(i).getContentsCnt();

                    creatordetail_list_id.add(id);
                    creatordetail_list_nickname.add(nickname);
                    creatordetail_list_photo.add(photo);
                    creatordetail_list_subscribeto_cnt.add(subscribeto_cnt);
                    creatordetail_list_contents_cnt.add(contents_cnt);

                }

                aliseon.aliseon_setCreatordetail_list_id(creatordetail_list_id);
                aliseon.aliseon_setCreatordetail_list_nickname(creatordetail_list_nickname);
                aliseon.aliseon_setCreatordetail_list_photo(creatordetail_list_photo);
                aliseon.aliseon_setCreatordetail_list_subscribeto_cnt(creatordetail_list_subscribeto_cnt);
                aliseon.aliseon_setCreatordetail_list_contents_cnt(creatordetail_list_contents_cnt);

                if (creatordetailapiload == 0) {
                    aliseon.aliseon_setCreatorDetailAPIload(1);
                    creatoractivitydetailhandler.sendEmptyMessage(1000);
                } else if (creatordetailapiload == 1) {
                    creatoractivitydetailhandler.sendEmptyMessage(800);
                }

                SubscribeFromPost();

            }

            @Override
            public void onFailure(Call<SubscribeTo> call, Throwable t) {

            }
        });
    }

    // ??????????????? ????????? ???????????? API
    private void SubscribePost(int num, String type) {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        int user_id = aliseon.aliseon_getLoginid();
        int to_user_id = aliseon.aliseon_getParam_subscribe_to_id();

        Call<SubscribePost> call = AliseonAPI.SubscribePost(access_token, String.valueOf(user_id), String.valueOf(to_user_id), type);

        call.enqueue(new Callback<SubscribePost>() {
            @Override
            public void onResponse(Call<SubscribePost> call, Response<SubscribePost> response) {

                SubscribePost postResponse = (SubscribePost) response.body();

                if (response.code() == 404) {
                    Log.d("404ERROR", "" + response.message());
                    Log.d("404ERROR", "" + response.errorBody().toString());
                    try {
                        JSONObject jsonObject = null;
                        jsonObject = new JSONObject(response.errorBody().string());
                        String userMessage = jsonObject.getString("message");
                        Log.d("RESULTERROR", userMessage);

                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    Log.d("CREATORSTATUS", String.valueOf(postResponse.getStatus()));
                    ArrayList<Integer> creatordetail_list_is_subscribe = aliseon.aliseon_getCreatordetail_list_is_subscribe();

                    if (type == "add") {
                        creatordetail_list_is_subscribe.set(num, 1);
                    } else {
                        creatordetail_list_is_subscribe.set(num, 0);
                    }

                    SubscribeToPost();
                }

            }

            @Override
            public void onFailure(Call<SubscribePost> call, Throwable t) {

            }
        });
    }

    // ?????? ??? '?????????'??? ?????? ?????????????????? ??????????????? ???????????? ??????
    // ?????? ?????? ??????
    private void SubscribeFromPost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();

        int userid = aliseon.aliseon_getLoginid();
        Log.d("USERID", String.valueOf(userid));

        int subscribeapiload = aliseon.aliseon_getSubscribeAPIload();
        int param_subscribe_activity = aliseon.aliseon_getParam_subscribe_activity();

        Call<SubscribeFrom> call = AliseonAPI.SubscribeFromPost(access_token, String.valueOf(userid));

        call.enqueue(new Callback<SubscribeFrom>() {
            @Override
            public void onResponse(Call<SubscribeFrom> call, Response<SubscribeFrom> response) {
                SubscribeFrom postResponse = (SubscribeFrom) response.body();

                Log.d("VALUETEST", String.valueOf(postResponse));

                ArrayList<Integer> subscribe_creator_list_id = new ArrayList<>();
                ArrayList<String> subscribe_creator_list_nickname = new ArrayList<>();
                ArrayList<String> subscribe_creator_list_photo = new ArrayList<>();

                for (int i = 0; i < postResponse.subscribe_from_list.size(); i++) {
                    subscribe_creator_list_id.add(postResponse.subscribe_from_list.get(i).getId());
                    subscribe_creator_list_nickname.add(postResponse.subscribe_from_list.get(i).getNickname());
                    subscribe_creator_list_photo.add(postResponse.subscribe_from_list.get(i).getPhoto());
                }

                aliseon.aliseon_setSubscribe_creator_list_id(subscribe_creator_list_id);
                aliseon.aliseon_setSubscribe_creator_list_nickname(subscribe_creator_list_nickname);
                aliseon.aliseon_setSubscribe_creator_list_photo(subscribe_creator_list_photo);

                try {

                    ArrayList<Integer> creatordetail_list_is_subscribe = aliseon.aliseon_getCreatordetail_list_is_subscribe();
                    ArrayList<Integer> creatordetail_list_id = aliseon.aliseon_getCreatordetail_list_id();

                    for (int i = 0; i < aliseon.aliseon_getCreatordetail_list_id().size(); i++) {

                        // ????????? ????????? ????????? ????????? ?????? ID??? ???????????? btnId ????????? ??????????????? ?????????, ????????? ?????? ?????? ID??? ?????????
                        Button btn = findViewById(btnId.get(i));

                        final int j = i;

                        // ?????? ?????? ?????? (?????? ??? ?????? ??????)
                        // ???????????? ?????? ??????, ?????? ????????? ?????? ??? ????????? ???????????? ????????????
                        btn.setText(getResources().getString(R.string.subscribe));
                        btn.setBackground(ContextCompat.getDrawable(btn.getContext(), R.drawable.buttonsetting));
                        btn.setLayoutParams(new LinearLayout.LayoutParams(250, 70));
                        btn.setTextColor(Color.rgb(255, 255, 255));
                        btn.setTextSize(10);

                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                aliseon.aliseon_setParam_subscribe_to_id(creatordetail_list_id.get(j));
                                creatoractivitydetailhandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        SubscribePost(j, "add");
                                    }
                                });

                            }
                        });

                        for (int ii = 0; ii < aliseon.aliseon_getSubscribe_creator_list_id().size(); ii++) {

                            if (aliseon.aliseon_getCreatordetail_list_id().get(i).equals(aliseon.aliseon_getSubscribe_creator_list_id().get(ii))) {
                                btn.setText(getResources().getString(R.string.subscribed));
                                btn.setBackground(ContextCompat.getDrawable(btn.getContext(), R.drawable.blackbuttonsetting));
                                btn.setLayoutParams(new LinearLayout.LayoutParams(250, 70));
                                btn.setTextColor(Color.rgb(255, 255, 255));
                                btn.setTextSize(10);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        aliseon.aliseon_setParam_subscribe_to_id(creatordetail_list_id.get(j));
                                        creatoractivitydetailhandler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                SubscribePost(j, "delete");
                                            }
                                        });

                                    }
                                });
                            }

                        }



                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<SubscribeFrom> call, Throwable t) {

            }
        });
    }
}