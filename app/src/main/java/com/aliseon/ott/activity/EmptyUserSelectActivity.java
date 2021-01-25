package com.aliseon.ott.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;
import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmptyUserSelectActivity extends AppCompatActivity {

        AliseonAPI AliseonAPI;

        private ArrayList<String> user_cate;

        SharedPreferences prf;

        private static String TAG2 = "Shared값 가져오기";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_account_useraccountmanagement);

            Aliseon aliseon = (Aliseon) getApplicationContext();
            String aliseonapi = aliseon.aliseon_getAliseonapi();
            String imageurl = aliseon.aliseon_getImageURL();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(aliseonapi)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            AliseonAPI = retrofit.create(AliseonAPI.class);

            ArrayList<String> userinfo = aliseon.aliseon_getTvott_userinfo();
            ArrayList<Integer> userinfouid = aliseon.aliseon_getTvott_userinfouid();

            readData();

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

            String TAG = "array 사이즈";

            user_cate = new ArrayList<>();

            user_cate.add(getResources().getString(R.string.subscribe));
            user_cate.add(getResources().getString(R.string.cart));
            user_cate.add(getResources().getString(R.string.language_setting));
            user_cate.add(getResources().getString(R.string.account_management));


            LinearLayout Layout1 = new LinearLayout(this);
            LinearLayout Layout2 = new LinearLayout(this);
            LinearLayout Layout2_1 = new LinearLayout(this);
            LinearLayout Layout2_2 = new LinearLayout(this);
            LinearLayout Layout2_3 = new LinearLayout(this);
            LinearLayout Layout2_4 = new LinearLayout(this);
            LinearLayout Layout3 = new LinearLayout(this);
            LinearLayout Layout4 = new LinearLayout(this);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            ImageView Home = new ImageView(this);
            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
            ImageView Search = new ImageView(this);
            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
            ImageView User = new ImageView(this);
            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
            ImageView Cart = new ImageView(this);
            Cart.setFocusableInTouchMode(true);
            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
            Cart.setPadding(15,15,15,15);
            CircleImageView Profile[] = new CircleImageView[3];
            Profile[0] = new CircleImageView(this);
            Profile[1] = new CircleImageView(this);
            Profile[2] = new CircleImageView(this);
            ImageView ImageEmpty = new ImageView(this);
            ImageView AccountPlus = new ImageView(this);
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            TextView name[] = new TextView[4];
            name[0] = new TextView(this);
            name[1] = new TextView(this);
            name[2] = new TextView(this);
            name[3] = new TextView(this);

            Home.setImageResource(R.drawable.home);
            Search.setImageResource(R.drawable.search);
            User.setImageResource(R.drawable.user);
            ImageEmpty.setImageResource(R.drawable.checkuser);
            AccountPlus.setImageResource(R.drawable.accountplus);
            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Cart.setId(R.id.homecart);
            Cart.setImageResource(R.drawable.cart);
            Cart.setLayoutParams(new ViewGroup.LayoutParams(60,60));
            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ImageEmpty.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            ImageEmpty.setPadding(20, 20, 20, 20);
            ImageEmpty.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Profile[0].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            Profile[1].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            Profile[2].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            AccountPlus.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            AccountPlus.setScaleType(ImageView.ScaleType.FIT_CENTER);

            Profile[0].setFocusableInTouchMode(true);
            Profile[1].setFocusableInTouchMode(true);
            Profile[2].setFocusableInTouchMode(true);
            AccountPlus.setFocusableInTouchMode(true);
            Profile[0].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.selectusersetting));
            Profile[1].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.selectusersetting));
            Profile[2].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.selectusersetting));
            AccountPlus.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.selectusersetting));
            Profile[0].setPadding(4, 4, 4, 4);
            Profile[1].setPadding(4, 4, 4, 4);
            Profile[2].setPadding(4, 4, 4, 4);
            AccountPlus.setPadding(4, 4, 4, 4);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params3f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params3ff = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.1f);
            LinearLayout.LayoutParams params3_1f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.3f);
            LinearLayout.LayoutParams params3_2f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4empty = new LinearLayout.LayoutParams(200, LinearLayout.LayoutParams.MATCH_PARENT);

            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3_9 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());

            margin.setMargins(0, 20, 5, 20);
            margin2.setMargins(0, 20, 5, 20);
            margin3.setMargins(0, 20, 5, 20);
            margin3_9.setMargins(0, 20, 5, 20);

            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout2.setLayoutParams(params2);
            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
            Layout4.setBackgroundColor(Color.rgb(29, 29, 29));

            Layout2_1.setLayoutParams(params2_1);
            Layout2_1.setLayoutParams(margin);

            Layout2_2.setLayoutParams(params2_1);
            Layout2_2.setLayoutParams(margin2);

            Layout2_3.setLayoutParams(params2_1);
            Layout2_3.setLayoutParams(margin3);

            Layout2_4.setLayoutParams(params2_1);
            Layout2_4.setLayoutParams(margin3_9);

            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3.setGravity(Gravity.CENTER);

            Layout3.setLayoutParams(params3);

            Layout4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.backgroundblack));

            LinearLayout Layout3_1 = new LinearLayout(this);
            LinearLayout Layout3_1_1 = new LinearLayout(this);
            LinearLayout Layout3_1_2 = new LinearLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this);
            LinearLayout Layout3_2_1 = new LinearLayout(this);
            LinearLayout Layout3_2_2 = new LinearLayout(this);
            LinearLayout Layout3_2_3 = new LinearLayout(this);
            LinearLayout Layout3_2_4 = new LinearLayout(this);
            LinearLayout Layout3_3 = new LinearLayout(this);

            Layout3_1.setOrientation(LinearLayout.VERTICAL);
            Layout3_1_1.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            Layout3_1_2.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout3_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_2.setGravity(Gravity.CENTER | Gravity.LEFT);

            TextView TV0 = new TextView(this);
            TextView TV1 = new TextView(this);
            TextView TV2 = new TextView(this);
            TextView TV3 = new TextView(this);

            TV0.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
            TV1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
            TV2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
            TV3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));

            TV0.setText(user_cate.get(0));
            TV1.setText(user_cate.get(1));
            TV2.setText(user_cate.get(2));
            TV3.setText(user_cate.get(3));

            name[0].setTextColor(Color.rgb(255, 255, 255));
            name[1].setTextColor(Color.rgb(255, 255, 255));
            name[2].setTextColor(Color.rgb(255, 255, 255));
            name[3].setTextColor(Color.rgb(255, 255, 255));

            name[0].setTextSize(10);
            name[1].setTextSize(10);
            name[2].setTextSize(10);
            name[3].setTextSize(10);

            TV0.setTextColor(Color.rgb(255, 255, 255));
            TV1.setTextColor(Color.rgb(255, 255, 255));
            TV2.setTextColor(Color.rgb(255, 255, 255));
            TV3.setTextColor(Color.rgb(255, 255, 255));

            TV0.setPadding(10, 10, 10, 10);
            TV1.setPadding(10, 10, 10, 10);
            TV2.setPadding(10, 10, 10, 10);
            TV3.setPadding(10, 10, 10, 10);


            Layout3_1_1.addView(ImageEmpty);
//            Layout3_1_2.addView(name[3]);
            Layout3_2_1.addView(TV0);
            Layout3_2_2.addView(TV1);
            Layout3_2_3.addView(TV2);
            Layout3_2_4.addView(TV3);

            ViewGroup.MarginLayoutParams margin3_0 = new ViewGroup.MarginLayoutParams(TV0.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3_1 = new ViewGroup.MarginLayoutParams(TV1.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3_2 = new ViewGroup.MarginLayoutParams(TV2.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3_3 = new ViewGroup.MarginLayoutParams(TV3.getLayoutParams());

            margin3_0.setMargins(30, 17, 0, 0);
            margin3_1.setMargins(30, 22, 0, 0);
            margin3_2.setMargins(30, 22, 0, 0);
            margin3_3.setMargins(30, 22, 0, 22);


            Layout3_1.setLayoutParams(params3ff);
            Layout3_2.setLayoutParams(params3f);
            Layout3_3.setLayoutParams(params3ff);
            Layout3_1_1.setLayoutParams(params3_1f);
            Layout3_1_2.setLayoutParams(params3_2f);
            Layout3_2_1.setLayoutParams(margin3_0);
            Layout3_2_2.setLayoutParams(margin3_1);
            Layout3_2_3.setLayoutParams(margin3_2);
            Layout3_2_4.setLayoutParams(margin3_3);

            Layout3.addView(Layout3_1);
            Layout3_1.addView(Layout3_1_1);
            Layout3_1.addView(Layout3_1_2);
            Layout3.addView(Layout3_2);
            Layout3_2.addView(Layout3_2_1);
            Layout3_2.addView(Layout3_2_2);
            Layout3_2.addView(Layout3_2_3);
            Layout3_2.addView(Layout3_2_4);
            Layout3.addView(Layout3_3);

            Layout4.setOrientation(LinearLayout.VERTICAL);
            Layout4.setGravity(Gravity.CENTER);
            Layout4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.backgroundblack));

            Layout4.setLayoutParams(params4);

            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params4_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params4_3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            LinearLayout Layout4_1 = new LinearLayout(this);
            LinearLayout Layout4_2 = new LinearLayout(this);
            LinearLayout Layout4_3 = new LinearLayout(this);
            LinearLayout Layout4_3_1 = new LinearLayout(this);
            LinearLayout Layout4_3_1_1 = new LinearLayout(this);
            LinearLayout Layout4_3_1_2 = new LinearLayout(this);
            LinearLayout Layout4_3_2 = new LinearLayout(this);
            LinearLayout Layout4_3_2_1 = new LinearLayout(this);
            LinearLayout Layout4_3_2_2 = new LinearLayout(this);
            LinearLayout Layout4_3_3 = new LinearLayout(this);
            LinearLayout Layout4_3_3_1 = new LinearLayout(this);
            LinearLayout Layout4_3_3_2 = new LinearLayout(this);
            LinearLayout Layout4_3_4 = new LinearLayout(this);
            LinearLayout Layout4_3_4_1 = new LinearLayout(this);
            LinearLayout Layout4_3_4_2 = new LinearLayout(this);
            LinearLayout Layout4_4 = new LinearLayout(this);
            LinearLayout Layout4empty1 = new LinearLayout(this);
            LinearLayout Layout4empty2 = new LinearLayout(this);

            Layout4_1.setGravity(Gravity.CENTER);
            Layout4_2.setGravity(Gravity.CENTER);
            Layout4_3.setGravity(Gravity.CENTER);
            Layout4_3_1.setGravity(Gravity.CENTER);
            Layout4_3_1_1.setGravity(Gravity.CENTER);
            Layout4_3_1_2.setGravity(Gravity.CENTER);
            Layout4_3_2.setGravity(Gravity.CENTER);
            Layout4_3_2_1.setGravity(Gravity.CENTER);
            Layout4_3_2_2.setGravity(Gravity.CENTER);
            Layout4_3_3.setGravity(Gravity.CENTER);
            Layout4_3_3_1.setGravity(Gravity.CENTER);
            Layout4_3_3_2.setGravity(Gravity.CENTER);
            Layout4_3_4.setGravity(Gravity.CENTER);
            Layout4_3_4_1.setGravity(Gravity.CENTER);
            Layout4_3_4_2.setGravity(Gravity.CENTER);
            Layout4_4.setGravity(Gravity.CENTER);
            Layout4empty1.setGravity(Gravity.CENTER);
            Layout4empty2.setGravity(Gravity.CENTER);

            Layout4_3.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_3_1.setOrientation(LinearLayout.VERTICAL);
            Layout4_3_2.setOrientation(LinearLayout.VERTICAL);
            Layout4_3_3.setOrientation(LinearLayout.VERTICAL);
            Layout4_3_4.setOrientation(LinearLayout.VERTICAL);

            TextView TV10 = new TextView(this);
            TextView TV11 = new TextView(this);
            TextView TV12 = new TextView(this);

            TV10.setTextSize(30);
            TV10.setTypeface(null, Typeface.BOLD);
            TV11.setTextSize(15);

            TV10.setText(getResources().getString(R.string.selectaccount));
            TV11.setText(getResources().getString(R.string.accountmax));
            TV12.setText(getResources().getString(R.string.addaccount));

            TV10.setTextColor(Color.rgb(255, 255, 255));
            TV11.setTextColor(Color.rgb(255, 255, 255));
            TV12.setTextColor(Color.rgb(255, 255, 255));

            TV12.setTextSize(10);

            TV10.setPadding(10, 10, 10, 10);
            TV11.setPadding(10, 10, 10, 10);

            TV11.setGravity(Gravity.CENTER);

            Layout4_1.addView(TV10);
            Layout4_2.addView(TV11);

            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
            ViewGroup.MarginLayoutParams margin4_1 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
            margin4.setMargins(0, 0, 0, 80);
            margin4_1.setMargins(0, 230, 0, 0);

            params4_3_1.setMargins(20,0,20,0);

            Layout4_1.setLayoutParams(params4_1);
            Layout4_2.setLayoutParams(params4_1);
            Layout4_2.setLayoutParams(margin4);
            Layout4_3.setLayoutParams(params4_3);
            Layout4_3_1.setLayoutParams(params4_3_1);
            Layout4_3_2.setLayoutParams(params4_3_1);
            Layout4_3_3.setLayoutParams(params4_3_1);
            Layout4_3_4.setLayoutParams(params4_3_1);
            Layout4_4.setLayoutParams(margin4_1);
            Layout4empty1.setLayoutParams(params4empty);
            Layout4empty2.setLayoutParams(params4empty);

            Layout1.addView(Layout2);

            Layout2_1.addView(Home);
            Layout2_2.addView(Search);
            Layout2_3.addView(User);
            Layout2_4.addView(Cart);

            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);
            Layout2.addView(Layout2_3);
            Layout2.addView(Layout2_4);

            Log.d(TAG, "info userinfo >>> " + userinfo.size());
            Log.d(TAG, "info useruid >>> " + userinfouid.size());

            Profile[0].requestFocus();

            if (userinfo.size() == 18) {
                try {

                    if (userinfo != null && Profile != null && name != null && Layout4_3 != null && Layout4empty1 != null &&
                            Layout4_3_1 != null && Layout4_3_2 != null && Layout4_3_3 != null && Layout4_3_4 != null && Layout4empty2 != null &&
                            Layout4_3_1_1 != null && Layout4_3_1_2 != null && Layout4_3_2_1 != null && Layout4_3_2_2 != null && Layout4_3_3_1 != null &&
                            Layout4_3_3_2 != null && Layout4_3_4_1 != null && Layout4_3_4_2 != null && AccountPlus != null && TV12 != null) {


                    Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
                    name[0].setText(userinfo.get(0));
                    Glide.with(this).load(userinfo.get(8)).into(Profile[1]);
                    name[1].setText(userinfo.get(6));
                    Glide.with(this).load(userinfo.get(14)).into(Profile[2]);
                    name[2].setText(userinfo.get(12));
                    Layout4_3.addView(Layout4empty1);
                    Layout4_3.addView(Layout4_3_1);
                    Layout4_3.addView(Layout4_3_2);
                    Layout4_3.addView(Layout4_3_3);
                    Layout4_3.addView(Layout4_3_4);
                    Layout4_3.addView(Layout4empty2);
                    Layout4_3_1.addView(Layout4_3_1_1);
                    Layout4_3_1.addView(Layout4_3_1_2);
                    Layout4_3_2.addView(Layout4_3_2_1);
                    Layout4_3_2.addView(Layout4_3_2_2);
                    Layout4_3_3.addView(Layout4_3_3_1);
                    Layout4_3_3.addView(Layout4_3_3_2);
                    Layout4_3_4.addView(Layout4_3_4_1);
                    Layout4_3_4.addView(Layout4_3_4_2);
                    Layout4_3_1_1.addView(Profile[0]);
                    Layout4_3_1_2.addView(name[0]);
                    Layout4_3_2_1.addView(Profile[1]);
                    Layout4_3_2_2.addView(name[1]);
                    Layout4_3_3_1.addView(Profile[2]);
                    Layout4_3_3_2.addView(name[2]);
                    Layout4_3_4_1.addView(AccountPlus);
                    Layout4_3_4_2.addView(TV12);

                    } throw new Exception("error");

                } catch (Exception e) {

                }
            } else if (userinfo.size() == 12) {
                try {

                    if (userinfo != null && Profile != null && name != null && Layout4_3 != null && Layout4empty1 != null &&
                            Layout4_3_1 != null && Layout4_3_2 != null && Layout4_3_3 != null && Layout4_3_4 != null && Layout4empty2 != null &&
                            Layout4_3_1_1 != null && Layout4_3_1_2 != null && Layout4_3_2_1 != null && Layout4_3_2_2 != null && Layout4_3_3_1 != null &&
                            Layout4_3_3_2 != null && Layout4_3_4_1 != null && Layout4_3_4_2 != null && AccountPlus != null && TV12 != null) {

                        Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
                        name[0].setText(userinfo.get(0));
                        Glide.with(this).load(userinfo.get(8)).into(Profile[1]);
                        name[1].setText(userinfo.get(6));
                        Layout4_3.addView(Layout4empty1);
                        Layout4_3.addView(Layout4_3_1);
                        Layout4_3.addView(Layout4_3_2);
                        Layout4_3.addView(Layout4_3_4);
                        Layout4_3.addView(Layout4empty2);
                        Layout4_3_1.addView(Layout4_3_1_1);
                        Layout4_3_1.addView(Layout4_3_1_2);
                        Layout4_3_2.addView(Layout4_3_2_1);
                        Layout4_3_2.addView(Layout4_3_2_2);
                        Layout4_3_1_1.addView(Profile[0]);
                        Layout4_3_1_2.addView(name[0]);
                        Layout4_3_2_1.addView(Profile[1]);
                        Layout4_3_2_2.addView(name[1]);
                        Layout4_3_4_1.addView(AccountPlus);
                        Layout4_3_4_2.addView(TV12);
                        Layout4_3_4.addView(Layout4_3_4_1);
                        Layout4_3_4.addView(Layout4_3_4_2);

                    } throw new Exception("error");
                } catch (Exception e) {

                }
            } else if (userinfo.size() == 6) {
                try {

                    if (userinfo != null && Profile != null && name != null && Layout4_3 != null && Layout4empty1 != null &&
                            Layout4_3_1 != null && Layout4_3_2 != null && Layout4_3_3 != null && Layout4_3_4 != null && Layout4empty2 != null &&
                            Layout4_3_1_1 != null && Layout4_3_1_2 != null && Layout4_3_2_1 != null && Layout4_3_2_2 != null && Layout4_3_3_1 != null &&
                            Layout4_3_3_2 != null && Layout4_3_4_1 != null && Layout4_3_4_2 != null && AccountPlus != null && TV12 != null) {

                        Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
                        name[0].setText(userinfo.get(0));
                        Layout4_3.addView(Layout4empty1);
                        Layout4_3.addView(Layout4_3_1);
                        Layout4_3.addView(Layout4_3_4);
                        Layout4_3.addView(Layout4empty2);
                        Layout4_3_1.addView(Layout4_3_1_1);
                        Layout4_3_1.addView(Layout4_3_1_2);
                        Layout4_3_1_1.addView(Profile[0]);
                        Layout4_3_1_2.addView(name[0]);
                        Layout4_3_4_1.addView(AccountPlus);
                        Layout4_3_4_2.addView(TV12);
                        Layout4_3_4.addView(Layout4_3_4_1);
                        Layout4_3_4.addView(Layout4_3_4_2);

                    } throw new Exception("error");

                } catch (Exception e) {

                }
            }
            else {
                Layout4_3.addView(Layout4empty1);
                Layout4_3.addView(Layout4_3_4);
                Layout4_3.addView(Layout4empty2);
                Layout4_3_4_1.addView(AccountPlus);
                Layout4_3_4_2.addView(TV12);
                Layout4_3_4.addView(Layout4_3_4_1);
                Layout4_3_4.addView(Layout4_3_4_2);
            }

            Layout4.addView(Layout4_1);
            Layout4.addView(Layout4_2);
            Layout4.addView(Layout4_3);
            Layout4.addView(Layout4_4);

            Layout1.addView(Layout3);

            Layout1.addView(Layout4);

            setContentView(Layout1);

            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);

            AccountPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(userinfo.size() == 18 && userinfouid.size() == 3){
                        builder.setTitle(getResources().getString(R.string.alertdialog_maxaccount));

                        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    } else {
                        Intent intent = new Intent(EmptyUserSelectActivity.this, EmptyAddAccountActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
//                finish();
                    }
                }
            });

            Profile[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(EmptyUserSelectActivity.this, EmptySelectAccount1Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
//                finish();
                }
            });
            Profile[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(EmptyUserSelectActivity.this, EmptySelectAccount2Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
//                finish();
                }
            });
            Profile[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(EmptyUserSelectActivity.this, EmptySelectAccount3Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
//                finish();
                }
            });

        }


        public void readData()
        {
            prf = getSharedPreferences("login_session",MODE_PRIVATE);
            prf.getString("userinfo_name", "");
            Log.d(TAG2, "info >>> " + prf.getString("userinfo_name", ""));
            prf.getString("userinfo_picture", "");
            Log.d(TAG2, "picture >>> " + prf.getString("userinfo_picture", ""));
            prf.getInt("user_id", 0);
            Log.d(TAG2, "id >>> " + prf.getInt("user_id", 0));
            prf.getString("language", "");
            Log.d(TAG2, "language >>> " + prf.getString("language", ""));
            prf.getBoolean("selectaccount", true);
            Log.d(TAG2, "selectaccount >>> " + prf.getBoolean("selectaccount", true));

        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            overridePendingTransition(0,0);
        }

        @Override
        protected void onRestart() {
            super.onRestart();
            overridePendingTransition(0,0);
            }

    }
