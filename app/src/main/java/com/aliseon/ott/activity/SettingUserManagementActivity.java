package com.aliseon.ott.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskUsersChange1;
import com.aliseon.ott.networktask.NetworkTaskUsersChange2;
import com.aliseon.ott.networktask.NetworkTaskUsersChange3;
import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.aliseon.ott.Variable.loginlanguage;
import static com.aliseon.ott.Variable.loginid;
import static com.aliseon.ott.Variable.logincurrency;
import static com.aliseon.ott.Variable.*;

public class SettingUserManagementActivity extends AppCompatActivity {

    private ArrayList<String> user_cate;

    SharedPreferences prf;

    public static SettingActivityUserAccountmanagementAccountChange1Handler settingactivityuseraccountmanagementaccountchange1handler;
    public static SettingActivityUserAccountmanagementAccountChange2Handler settingactivityuseraccountmanagementaccountchange2handler;
    public static SettingActivityUserAccountmanagementAccountChange3Handler settingactivityuseraccountmanagementaccountchange3handler;

    private static String TAG2 = "Shared값 가져오기";
    TextView TV1;

    Button addaccountbtn;
    Button logoutbtn;
    Button acc1changebtn;
    Button acc1disconnectbtn;
    Button acc2changebtn;
    Button acc2disconnectbtn;
    Button acc3changebtn;
    Button acc3disconnectbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_useraccountmanagement);

        if(settinguseraccountmanagementapiload == 0) {

            Log.d("userinfo 사이즈", "" + userinfo.size());
            Log.d("userinfouid 사이즈", "" + userinfouid.size());

            readData();

            switch (prf.getString("language", "")) {
                case "kr":
                    loginlanguage = "kr";
                    Locale lang1 = Locale.KOREAN;
                    Configuration config1 = new Configuration();
                    config1.locale = lang1;
                    getResources().updateConfiguration(config1, getResources().getDisplayMetrics());
                    break;
                case "en":
                    loginlanguage = "en";
                    Locale lang2 = Locale.ENGLISH;
                    Configuration config2 = new Configuration();
                    config2.locale = lang2;
                    getResources().updateConfiguration(config2, getResources().getDisplayMetrics());
                case "ar":
                    loginlanguage = "ar";
                    Locale lang3 = Locale.ENGLISH;
                    Configuration config3 = new Configuration();
                    config3.locale = lang3;
                    getResources().updateConfiguration(config3, getResources().getDisplayMetrics());
            }

            settingactivityuseraccountmanagementaccountchange1handler = new SettingActivityUserAccountmanagementAccountChange1Handler();
            settingactivityuseraccountmanagementaccountchange2handler = new SettingActivityUserAccountmanagementAccountChange2Handler();
            settingactivityuseraccountmanagementaccountchange3handler = new SettingActivityUserAccountmanagementAccountChange3Handler();

            user_cate = new ArrayList<>();
            user_cate.add(getResources().getString(R.string.account_management));
            user_cate.add(getResources().getString(R.string.language_setting));


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
            LinearLayout Layout4 = new LinearLayout(this);

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
            CircleImageView My = new CircleImageView(this);
            My.setFocusableInTouchMode(true);
            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Setting = new ImageView(this);
            Setting.setFocusableInTouchMode(true);
            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Cart.setPadding(15, 15, 15, 15);
            CircleImageView Profile[] = new CircleImageView[4];
            Profile[0] = new CircleImageView(this);
            Profile[1] = new CircleImageView(this);
            Profile[2] = new CircleImageView(this);
            Profile[3] = new CircleImageView(this);
            ImageView AccountPlus = new ImageView(this);
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            My.setPadding(15, 15, 15, 15);
            Setting.setPadding(15, 15, 15, 15);
            TextView name[] = new TextView[4];
            name[0] = new TextView(this);
            name[1] = new TextView(this);
            name[2] = new TextView(this);
            name[3] = new TextView(this);
            Profile[0].setId(R.id.accountmanagementprofile1);
            Profile[1].setId(R.id.accountmanagementprofile2);
            Profile[2].setId(R.id.accountmanagementprofile3);
            AccountPlus.setId(R.id.accountmanagementprofile4);

            try {
                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(Profile[3]);
                name[3].setText(prf.getString("userinfo_name", ""));
            } catch (Exception e) {

            }

            Home.setImageResource(R.drawable.home);
            Search.setImageResource(R.drawable.search);
            User.setImageResource(R.drawable.user);
            AccountPlus.setImageResource(R.drawable.accountplus);
            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Cart.setId(R.id.accountmanagementcart);
            Cart.setImageResource(R.drawable.cart);
            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));
            My.setId(R.id.my);

            if (prf.getString("userinfo_picture", "").equals("empty")) {
                My.setImageResource(R.drawable.noimg_profile);
            } else {
                Glide.with(this).load(imageurl + prf.getString("userinfo_picture", "")).into(My);
            }

            Setting.setImageResource(R.drawable.setting);
            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Profile[3].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            Profile[3].setPadding(20, 20, 20, 20);
            Profile[0].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            Profile[1].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            Profile[2].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            AccountPlus.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            AccountPlus.setScaleType(ImageView.ScaleType.FIT_CENTER);

            Profile[0].setPadding(4, 4, 4, 4);
            Profile[1].setPadding(4, 4, 4, 4);
            if(Profile[2] != null){
                Profile[2].setPadding(4, 4, 4, 4);
            }AccountPlus.setPadding(4, 4, 4, 4);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params3f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params3ff = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.1f);
            LinearLayout.LayoutParams params3_1f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.3f);
            LinearLayout.LayoutParams params3_2f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3_9 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());

            margin.setMargins(10, 20, 5, 20);
            margin2.setMargins(10, 20, 5, 20);
            margin3.setMargins(10, 20, 5, 20);
            margin3_9.setMargins(10, 20, 5, 20);
            margin5.setMargins(0, 20, 5, 20);
            margin6.setMargins(10, 20, 20, 20);

            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout2.setLayoutParams(params2);
            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
            Layout4.setBackgroundColor(Color.rgb(29, 29, 29));

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
            Layout2_1_4.setLayoutParams(margin3_9);
            Layout2_1_5.setLayoutParams(params2_2);
            Layout2_1_5.setLayoutParams(margin5);

            Layout2_2_1.setLayoutParams(params2_2);
            Layout2_2_1.setLayoutParams(margin6);

            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3.setGravity(Gravity.CENTER);

            Layout3.setLayoutParams(params3);

            LinearLayout Layout3_2 = new LinearLayout(this);
            LinearLayout Layout3_2_1 = new LinearLayout(this);
            LinearLayout Layout3_2_2 = new LinearLayout(this);

            Layout3_2_1.setLayoutParams(params3_1);
            Layout3_2_2.setLayoutParams(params3_1);

            Layout3_2.setOrientation(LinearLayout.VERTICAL);
            Layout3_2.setGravity(Gravity.BOTTOM | Gravity.LEFT);

            TV1 = new TextView(this);
            TextView TV2 = new TextView(this);

            Home.setId(R.id.accountmanagementhome);
            Search.setId(R.id.accountmanagementsearch);
            User.setId(R.id.accountmanagementuser);
            Setting.setId(R.id.setting);
            TV1.setId(R.id.accountmanagement1);
            TV2.setId(R.id.accountmanagement2);
            Setting.setNextFocusUpId(R.id.my);

            TV1.setFocusableInTouchMode(true);
            TV2.setFocusableInTouchMode(true);

            TV1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
            TV2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));

            TV1.setText(user_cate.get(0));
            TV2.setText(user_cate.get(1));

            name[0].setTextColor(Color.rgb(255, 255, 255));
            name[1].setTextColor(Color.rgb(255, 255, 255));
            name[2].setTextColor(Color.rgb(255, 255, 255));
            name[3].setTextColor(Color.rgb(255, 255, 255));

            name[0].setTextSize(20);
            name[1].setTextSize(20);
            name[2].setTextSize(20);
            name[3].setTextSize(20);

            TV1.setTextColor(Color.rgb(255, 255, 255));
            TV2.setTextColor(Color.rgb(255, 255, 255));

            TV1.setPadding(40, 21, 10, 21);
            TV2.setPadding(40, 21, 10, 21);

            Layout3_2_1.addView(TV1);
            Layout3_2_2.addView(TV2);

            ViewGroup.MarginLayoutParams margin3_1 = new ViewGroup.MarginLayoutParams(TV1.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3_2 = new ViewGroup.MarginLayoutParams(TV2.getLayoutParams());

            margin3_1.setMargins(30, 22, 0, 0);
            margin3_2.setMargins(30, 22, 0, 0);


            Layout3_2.setLayoutParams(params3f);

            Layout3.addView(Layout3_2);
            Layout3_2.addView(Layout3_2_1);
            Layout3_2.addView(Layout3_2_2);

            Layout4.setOrientation(LinearLayout.VERTICAL);
            Layout4.setGravity(Gravity.LEFT);

            Layout4.setLayoutParams(params4);

            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
            LinearLayout.LayoutParams params4_4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4_4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4_4_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.2f);
            LinearLayout.LayoutParams params4_4_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4_4_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
            LinearLayout.LayoutParams params4_4_2_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4_4_2_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.25f);
            LinearLayout.LayoutParams params4_7 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4_7_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4_7_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);

            params4_4_2_1.bottomMargin = 10;
            params4_4_2_2.topMargin = 22;
            params4_7_1.rightMargin = 10;
            params4_7_2.leftMargin = 10;

            LinearLayout Layout4_1 = new LinearLayout(this);
            LinearLayout Layout4_2 = new LinearLayout(this);
            LinearLayout Layout4_3 = new LinearLayout(this);
            LinearLayout Layout4_4 = new LinearLayout(this);
            LinearLayout Layout4_4_1 = new LinearLayout(this);
            LinearLayout Layout4_4_2 = new LinearLayout(this);
            LinearLayout Layout4_4_2_1 = new LinearLayout(this);
            LinearLayout Layout4_4_2_2 = new LinearLayout(this);
            LinearLayout Layout4_4_2_2_1 = new LinearLayout(this);
            LinearLayout Layout4_4_2_2_2 = new LinearLayout(this);
            LinearLayout Layout4_5 = new LinearLayout(this);
            LinearLayout Layout4_5_1 = new LinearLayout(this);
            LinearLayout Layout4_5_2 = new LinearLayout(this);
            LinearLayout Layout4_5_2_1 = new LinearLayout(this);
            LinearLayout Layout4_5_2_2 = new LinearLayout(this);
            LinearLayout Layout4_5_2_2_1 = new LinearLayout(this);
            LinearLayout Layout4_5_2_2_2 = new LinearLayout(this);
            LinearLayout Layout4_6 = new LinearLayout(this);
            LinearLayout Layout4_6_1 = new LinearLayout(this);
            LinearLayout Layout4_6_2 = new LinearLayout(this);
            LinearLayout Layout4_6_2_1 = new LinearLayout(this);
            LinearLayout Layout4_6_2_2 = new LinearLayout(this);
            LinearLayout Layout4_6_2_2_1 = new LinearLayout(this);
            LinearLayout Layout4_6_2_2_2 = new LinearLayout(this);
            LinearLayout Layout4_4_4 = new LinearLayout(this);
            LinearLayout Layout4_4_4_1 = new LinearLayout(this);
            LinearLayout Layout4_4_4_2 = new LinearLayout(this);
            LinearLayout Layout4_7 = new LinearLayout(this);
            LinearLayout Layout4_7_1 = new LinearLayout(this);
            LinearLayout Layout4_7_2 = new LinearLayout(this);

//        LinearLayout Layout4_1 = new LinearLayout(this);
//        LinearLayout Layout4_2 = new LinearLayout(this);
//        LinearLayout Layout4_4 = new LinearLayout(this);
//        LinearLayout Layout4_4_1 = new LinearLayout(this);
//        LinearLayout Layout4_4_1_1 = new LinearLayout(this);
//        LinearLayout Layout4_4_1_2 = new LinearLayout(this);
//        LinearLayout Layout4_4_2 = new LinearLayout(this);
//        LinearLayout Layout4_4_2_1 = new LinearLayout(this);
//        LinearLayout Layout4_4_2_2 = new LinearLayout(this);
//        LinearLayout Layout4_4_3 = new LinearLayout(this);
//        LinearLayout Layout4_4_3_1 = new LinearLayout(this);
//        LinearLayout Layout4_4_3_2 = new LinearLayout(this);
//        LinearLayout Layout4_4_4 = new LinearLayout(this);
//        LinearLayout Layout4_4_4_1 = new LinearLayout(this);
//        LinearLayout Layout4_4_4_2 = new LinearLayout(this);
//        LinearLayout Layout4_7 = new LinearLayout(this);
//        LinearLayout Layout4_7_1 = new LinearLayout(this);
//        LinearLayout Layout4_7_2 = new LinearLayout(this);

            Layout4_1.setGravity(Gravity.LEFT);
            Layout4_2.setGravity(Gravity.LEFT);
            Layout4_3.setGravity(Gravity.CENTER);
            Layout4_4.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout4_4_1.setGravity(Gravity.CENTER);
            Layout4_4_2.setGravity(Gravity.CENTER);
            Layout4_4_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
            Layout4_4_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
            Layout4_4_2_2_1.setGravity(Gravity.LEFT);
            Layout4_4_2_2_2.setGravity(Gravity.LEFT);
            Layout4_5.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout4_5_1.setGravity(Gravity.CENTER);
            Layout4_5_2.setGravity(Gravity.CENTER);
            Layout4_5_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
            Layout4_5_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
            Layout4_5_2_2_1.setGravity(Gravity.LEFT);
            Layout4_5_2_2_2.setGravity(Gravity.LEFT);
            Layout4_6.setGravity(Gravity.LEFT | Gravity.CENTER);
            Layout4_6_1.setGravity(Gravity.CENTER);
            Layout4_6_2.setGravity(Gravity.CENTER);
            Layout4_6_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
            Layout4_6_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
            Layout4_6_2_2_1.setGravity(Gravity.LEFT);
            Layout4_6_2_2_2.setGravity(Gravity.LEFT);
            Layout4_4_4.setGravity(Gravity.CENTER);
            Layout4_4_4_1.setGravity(Gravity.CENTER);
            Layout4_4_4_2.setGravity(Gravity.CENTER);
            Layout4_7.setGravity(Gravity.CENTER);
            Layout4_7_1.setGravity(Gravity.RIGHT);
            Layout4_7_2.setGravity(Gravity.LEFT);

            Layout4_3.setOrientation(LinearLayout.VERTICAL);
            Layout4_4.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_5.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_6.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_7.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_4_1.setOrientation(LinearLayout.VERTICAL);
            Layout4_4_2.setOrientation(LinearLayout.VERTICAL);
            Layout4_4_2_1.setOrientation(LinearLayout.VERTICAL);
            Layout4_4_2_2.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_4_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_4_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_5_1.setOrientation(LinearLayout.VERTICAL);
            Layout4_5_2.setOrientation(LinearLayout.VERTICAL);
            Layout4_5_2_1.setOrientation(LinearLayout.VERTICAL);
            Layout4_5_2_2.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_5_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_5_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_6_1.setOrientation(LinearLayout.VERTICAL);
            Layout4_6_2.setOrientation(LinearLayout.VERTICAL);
            Layout4_6_2_1.setOrientation(LinearLayout.VERTICAL);
            Layout4_6_2_2.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_6_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
            Layout4_6_2_2_2.setOrientation(LinearLayout.HORIZONTAL);

            TextView TV10 = new TextView(this);
            TextView TV11 = new TextView(this);
            TextView TV12 = new TextView(this);
            TextView TV13 = new TextView(this);
            TV13.setId(R.id.accountmanagementlogout);

            TV10.setTextSize(30);
            TV10.setTypeface(null, Typeface.BOLD);
            TV11.setTextSize(15);
            TV13.setTextSize(15);

            TV13.setFocusableInTouchMode(true);

            TV10.setText(getResources().getString(R.string.selectaccount));
            TV11.setText(getResources().getString(R.string.accountmax));
            TV12.setText(getResources().getString(R.string.addaccount));
            TV13.setText(getResources().getString(R.string.logout));

            TV10.setTextColor(Color.rgb(255, 255, 255));
            TV11.setTextColor(Color.rgb(255, 255, 255));
            TV12.setTextColor(Color.rgb(255, 255, 255));
            TV13.setTextColor(Color.rgb(102, 102, 102));

            TV12.setTextSize(10);

            TV10.setPadding(10, 10, 10, 10);
            TV11.setPadding(10, 10, 10, 10);

            TV11.setGravity(Gravity.CENTER);

            addaccountbtn = new Button(this);
            logoutbtn = new Button(this);
            acc1changebtn = new Button(this);
            acc1disconnectbtn = new Button(this);
            acc2changebtn = new Button(this);
            acc2disconnectbtn = new Button(this);
            acc3changebtn = new Button(this);
            acc3disconnectbtn = new Button(this);

            addaccountbtn.setTextColor(Color.rgb(255, 255, 255));
            logoutbtn.setTextColor(Color.rgb(255, 255, 255));
            acc1changebtn.setTextColor(Color.rgb(255, 255, 255));
            acc1disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
            acc2changebtn.setTextColor(Color.rgb(255, 255, 255));
            acc2disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
            acc3changebtn.setTextColor(Color.rgb(255, 255, 255));
            acc3disconnectbtn.setTextColor(Color.rgb(255, 255, 255));

            addaccountbtn.setTextSize(10);
            logoutbtn.setTextSize(10);
            acc1changebtn.setTextSize(10);
            acc1disconnectbtn.setTextSize(10);
            acc2changebtn.setTextSize(10);
            acc2disconnectbtn.setTextSize(10);
            acc3changebtn.setTextSize(10);
            acc3disconnectbtn.setTextSize(10);

            addaccountbtn.setText(getResources().getString(R.string.addaccount));
            logoutbtn.setText(getResources().getString(R.string.logout));
            acc1changebtn.setText(getResources().getString(R.string.change));
            acc1disconnectbtn.setText(getResources().getString(R.string.disconnect));
            acc2changebtn.setText(getResources().getString(R.string.change));
            acc2disconnectbtn.setText(getResources().getString(R.string.disconnect));
            acc3changebtn.setText(getResources().getString(R.string.change));
            acc3disconnectbtn.setText(getResources().getString(R.string.disconnect));

            addaccountbtn.setId(R.id.addaccountbtn);
            logoutbtn.setId(R.id.logoutbtn);
            acc1changebtn.setId(R.id.changebtn1);
            acc1disconnectbtn.setId(R.id.disconnectbtn1);
            acc2changebtn.setId(R.id.changebtn2);
            acc2disconnectbtn.setId(R.id.disconnectbtn2);
            acc3changebtn.setId(R.id.changebtn3);
            acc3disconnectbtn.setId(R.id.disconnectbtn3);

            addaccountbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            logoutbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            acc1changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            acc1disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            acc2changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            acc2disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            acc3changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            acc3disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));

            addaccountbtn.setLayoutParams(new ViewGroup.LayoutParams(600, 65));
            logoutbtn.setLayoutParams(new ViewGroup.LayoutParams(600, 65));
            acc1changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
            acc1disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
            acc2changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
            acc2disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
            acc3changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
            acc3disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));

            Layout4_1.addView(TV10);
            Layout4_2.addView(TV11);

            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
            ViewGroup.MarginLayoutParams margin4_1 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());

            margin4.setMargins(0, 0, 0, 80);
            margin4_1.setMargins(0, 100, 0, 0);

            Layout4_1.setLayoutParams(params4_1);
            Layout4_2.setLayoutParams(params4_1);
//        Layout4_2.setLayoutParams(margin4);
            Layout4_3.setLayoutParams(params4_3);
            Layout4_4.setLayoutParams(params4_4);
            Layout4_5.setLayoutParams(params4_4);
            Layout4_6.setLayoutParams(params4_4);
            Layout4_4_1.setLayoutParams(params4_4_1);
            Layout4_5_1.setLayoutParams(params4_4_1);
            Layout4_6_1.setLayoutParams(params4_4_1);
            Layout4_4_2.setLayoutParams(params4_4_2);
            Layout4_5_2.setLayoutParams(params4_4_2);
            Layout4_6_2.setLayoutParams(params4_4_2);
            Layout4_4_2_1.setLayoutParams(params4_4_2_1);
            Layout4_5_2_1.setLayoutParams(params4_4_2_1);
            Layout4_6_2_1.setLayoutParams(params4_4_2_1);
            Layout4_4_2_2.setLayoutParams(params4_4_2_2);
            Layout4_5_2_2.setLayoutParams(params4_4_2_2);
            Layout4_6_2_2.setLayoutParams(params4_4_2_2);
            Layout4_4_2_2_1.setLayoutParams(params4_4_2_2_1);
            Layout4_5_2_2_1.setLayoutParams(params4_4_2_2_1);
            Layout4_6_2_2_1.setLayoutParams(params4_4_2_2_1);
            Layout4_4_2_2_2.setLayoutParams(params4_4_2_2_2);
            Layout4_5_2_2_2.setLayoutParams(params4_4_2_2_2);
            Layout4_6_2_2_2.setLayoutParams(params4_4_2_2_2);

            Layout4_7.setLayoutParams(params4_7);
            Layout4_7_1.setLayoutParams(params4_7_1);
            Layout4_7_2.setLayoutParams(params4_7_2);
//        Layout4_5.setLayoutParams(margin4_1);


            Setting.requestFocus();

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
            Layout4_7.addView(Layout4_7_1);
            Layout4_7.addView(Layout4_7_2);
            Layout4_7_1.addView(addaccountbtn);
            Layout4_7_2.addView(logoutbtn);

            if (userinfo.size() == 15) {
                try {
                    Glide.with(this).load(imageurl + userinfo.get(1)).into(Profile[0]);
                    name[0].setText(userinfo.get(0));
                    Glide.with(this).load(imageurl + userinfo.get(6)).into(Profile[1]);
                    name[1].setText(userinfo.get(5));
                    Glide.with(this).load(imageurl + userinfo.get(11)).into(Profile[2]);
                    name[2].setText(userinfo.get(10));
                    Layout4_4.addView(Layout4_4_1);
                    Layout4_4.addView(Layout4_4_2);
                    Layout4_4_2.addView(Layout4_4_2_1);
                    Layout4_4_2.addView(Layout4_4_2_2);
                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
                    Layout4_4_1.addView(Profile[0]);
                    Layout4_4_2_1.addView(name[0]);
                    Layout4_4_2_2_1.addView(acc1changebtn);
                    Layout4_4_2_2_2.addView(acc1disconnectbtn);

                    Layout4_5.addView(Layout4_5_1);
                    Layout4_5.addView(Layout4_5_2);
                    Layout4_5_2.addView(Layout4_5_2_1);
                    Layout4_5_2.addView(Layout4_5_2_2);
                    Layout4_5_2_2.addView(Layout4_5_2_2_1);
                    Layout4_5_2_2.addView(Layout4_5_2_2_2);
                    Layout4_5_1.addView(Profile[1]);
                    Layout4_5_2_1.addView(name[1]);
                    Layout4_5_2_2_1.addView(acc2changebtn);
                    Layout4_5_2_2_2.addView(acc2disconnectbtn);

                    Layout4_6.addView(Layout4_6_1);
                    Layout4_6.addView(Layout4_6_2);
                    Layout4_6_2.addView(Layout4_6_2_1);
                    Layout4_6_2.addView(Layout4_6_2_2);
                    Layout4_6_2_2.addView(Layout4_6_2_2_1);
                    Layout4_6_2_2.addView(Layout4_6_2_2_2);
                    Layout4_6_1.addView(Profile[2]);
                    Layout4_6_2_1.addView(name[2]);
                    Layout4_6_2_2_1.addView(acc3changebtn);
                    Layout4_6_2_2_2.addView(acc3disconnectbtn);

                    Layout4_3.addView(Layout4_4);
                    Layout4_3.addView(Layout4_5);
                    Layout4_3.addView(Layout4_6);

                    params4_3.topMargin = 20;
                    params4_3.bottomMargin = 50;
                } catch (Exception e) {

                }
            } else if (userinfo.size() == 10) {
                try {
                    Glide.with(this).load(imageurl + userinfo.get(1)).into(Profile[0]);
                    name[0].setText(userinfo.get(0));
                    Glide.with(this).load(imageurl + userinfo.get(6)).into(Profile[1]);
                    name[1].setText(userinfo.get(5));
                    Layout4_4.addView(Layout4_4_1);
                    Layout4_4.addView(Layout4_4_2);
                    Layout4_4_2.addView(Layout4_4_2_1);
                    Layout4_4_2.addView(Layout4_4_2_2);
                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
                    Layout4_4_1.addView(Profile[0]);
                    Layout4_4_2_1.addView(name[0]);
                    Layout4_4_2_2_1.addView(acc1changebtn);
                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
                    Layout4_5.addView(Layout4_5_1);
                    Layout4_5.addView(Layout4_5_2);
                    Layout4_5_2.addView(Layout4_5_2_1);
                    Layout4_5_2.addView(Layout4_5_2_2);
                    Layout4_5_2_2.addView(Layout4_5_2_2_1);
                    Layout4_5_2_2.addView(Layout4_5_2_2_2);
                    Layout4_5_1.addView(Profile[1]);
                    Layout4_5_2_1.addView(name[1]);
                    Layout4_5_2_2_1.addView(acc2changebtn);
                    Layout4_5_2_2_2.addView(acc2disconnectbtn);
                    Layout4_3.addView(Layout4_4);
                    Layout4_3.addView(Layout4_5);
                    params4_3.topMargin = 120;
                    params4_3.bottomMargin = 150;
                    params4_4_1.topMargin = 2;
                } catch (Exception e) {

                }
            } else if (userinfo.size() == 5) {
                try {
                    Glide.with(this).load(imageurl + userinfo.get(1)).into(Profile[0]);
                    name[0].setText(userinfo.get(0));
                    Layout4_4.addView(Layout4_4_1);
                    Layout4_4.addView(Layout4_4_2);
                    Layout4_4_2.addView(Layout4_4_2_1);
                    Layout4_4_2.addView(Layout4_4_2_2);
                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
                    Layout4_4_1.addView(Profile[0]);
                    Layout4_4_2_1.addView(name[0]);
                    Layout4_4_2_2_1.addView(acc1changebtn);
                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
                    Layout4_3.addView(Layout4_4);
                    params4_3.topMargin = 20;
                    params4_3.bottomMargin = 50;
                    params4_4_1.bottomMargin = 35;
                } catch (Exception e) {

                }
            } else {
                Layout4_4.addView(Layout4_4_4);
                Layout4_4_4.addView(Layout4_4_4_1);
                Layout4_4_4.addView(Layout4_4_4_2);
            }

            Layout4.addView(Layout4_1);
            Layout4.addView(Layout4_2);
            Layout4.addView(Layout4_3);
            Layout4.addView(Layout4_7);

            Layout1.addView(Layout3);

            Layout1.addView(Layout4);

            setContentView(Layout1);

            Home.setNextFocusRightId(R.id.accountmanagement1);
            Search.setNextFocusRightId(R.id.accountmanagement1);
            User.setNextFocusRightId(R.id.accountmanagement1);
            Home.setNextFocusUpId(R.id.accountmanagementuser);
            User.setNextFocusDownId(R.id.accountmanagementhome);
        Profile[0].setNextFocusLeftId(R.id.accountmanagement1);
        Profile[0].setNextFocusDownId(R.id.accountmanagementlogout);
        Profile[0].setNextFocusUpId(R.id.accountmanagementlogout);
        Profile[1].setNextFocusDownId(R.id.accountmanagementlogout);
        Profile[1].setNextFocusUpId(R.id.accountmanagementlogout);
        Profile[2].setNextFocusDownId(R.id.accountmanagementlogout);
        Profile[2].setNextFocusUpId(R.id.accountmanagementlogout);
        AccountPlus.setNextFocusUpId(R.id.accountmanagementlogout);
        TV13.setNextFocusDownId(R.id.accountmanagementprofile1);
        TV13.setNextFocusUpId(R.id.accountmanagementprofile1);
            TV1.setNextFocusLeftId(R.id.setting);
            TV1.setNextFocusUpId(R.id.accountmanagement1);
            TV2.setNextFocusLeftId(R.id.setting);
            Setting.setNextFocusRightId(R.id.accountmanagement1);

            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);

            Setting.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                @Override
                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                    if (hasFocus == false) {

                        Layout3_2_1.setBackground(null);
                        TV1.setTextColor(Color.rgb(255, 255, 255));

                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
//                                Home.setImageResource(R.drawable.homeselect);
                                    TV1.setTextColor(Color.rgb(255, 255, 255));
                                    Intent intent = new Intent(SettingUserManagementActivity.this, HomeActivity.class);
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
//                                Search.setImageResource(R.drawable.searchselect);
                                    TV1.setTextColor(Color.rgb(255, 255, 255));
                                    Intent intent = new Intent(SettingUserManagementActivity.this, VoyageActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                    Search.setImageResource(R.drawable.search);
                                }
                            }
                        });

                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
//                                Search.setImageResource(R.drawable.searchselect);
                                    TV1.setTextColor(Color.rgb(255, 255, 255));
                                    Intent intent = new Intent(SettingUserManagementActivity.this, SubscribeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                }
                            }
                        });

                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
//                                Search.setImageResource(R.drawable.searchselect);
                                    TV1.setTextColor(Color.rgb(255, 255, 255));
                                    Intent intent = new Intent(SettingUserManagementActivity.this, CartActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                }
                            }
                        });

                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
//                                Search.setImageResource(R.drawable.searchselect);
                                    TV1.setTextColor(Color.rgb(255, 255, 255));
                                    Intent intent = new Intent(SettingUserManagementActivity.this, MyActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                finish();
                                } else {
                                }
                            }
                        });

                        TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    TV1.setTextColor(Color.rgb(066, 066, 066));
                                    TV2.setTextColor(Color.rgb(255, 255, 255));
                                    Layout3_2_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                    Layout3_2_2.setBackground(null);
//                              finish();
                                } else {
                                    TV1.setTextColor(Color.rgb(255, 255, 255));
                                    Layout3_2_1.setBackgroundColor(Color.rgb(66, 66, 66));
                                }
                            }
                        });

                        TV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    TV1.setTextColor(Color.rgb(255, 255, 255));
                                    TV2.setTextColor(Color.rgb(066, 066, 066));
                                    Layout3_2_1.setBackground(null);
                                    Layout3_2_2.setBackgroundColor(Color.rgb(255, 255, 255));
                                    Intent intent = new Intent(SettingUserManagementActivity.this, SettingLanguagesettingActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
//                              finish();
                                } else {
                                    TV2.setTextColor(Color.rgb(255, 255, 255));
                                    Layout3_2_2.setBackground(null);
                                }
                            }
                        });

                    } else {

                        Layout3_2_1.setBackground(null);
                        Layout3_2_2.setBackground(null);

                    }
                }
            });

            logoutbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = prf.edit();
                    editor.clear();
                    editor.commit();
                    Intent intent = new Intent(SettingUserManagementActivity.this, LoadingActivity.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    finish();
                }
            });

            addaccountbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (userinfo.size() == 18 && userinfouid.size() == 3) {
                        builder.setTitle(getResources().getString(R.string.alertdialog_maxaccount));

                        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    } else {
                        Intent intent = new Intent(SettingUserManagementActivity.this, AccountAddActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
//                finish();
                    }
                }
            });

            acc1changebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    settingactivityuseraccountmanagementaccountchange1handler.post(new Runnable() {
                        @Override
                        public void run() {
                            NetworkTaskUsersChange1 networktaskuserschange1 = new NetworkTaskUsersChange1(api_tvott_users, null);
                            networktaskuserschange1.execute();
                        }
                    });
//                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange1.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);
////                finish();
                }
            });

            acc1disconnectbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SettingUserManagementActivity.this, AccountDisconnect1Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
//                finish();
                }
            });

            acc2changebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    settingactivityuseraccountmanagementaccountchange2handler.post(new Runnable() {
                        @Override
                        public void run() {
                            NetworkTaskUsersChange2 networktaskuserschange2 = new NetworkTaskUsersChange2(api_tvott_users, null);
                            networktaskuserschange2.execute();
                        }
                    });
//                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange2.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);
////                finish();
                }
            });

            acc2disconnectbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SettingUserManagementActivity.this, AccountDisconnect2Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
//                finish();
                }
            });

            acc3changebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    settingactivityuseraccountmanagementaccountchange3handler.post(new Runnable() {
                        @Override
                        public void run() {
                            NetworkTaskUsersChange3 networktaskuserschange3 = new NetworkTaskUsersChange3(api_tvott_users, null);
                            networktaskuserschange3.execute();
                        }
                    });
//                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange3.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);
////                finish();
                }
            });

            acc3disconnectbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SettingUserManagementActivity.this, AccountDisconnect3Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
//                finish();
                }
            });

        }

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        readData();
//
//        switch (prf.getString("language","")){
//            case "kr" :
//                lang = "kr";
//                Locale lang1 = Locale.KOREAN;
//                Configuration config1 = new Configuration();
//                config1.locale = lang1;
//                getResources().updateConfiguration(config1,getResources().getDisplayMetrics());
//                break;
//            case "en" :
//                lang = "en";
//                Locale lang2 = Locale.ENGLISH;
//                Configuration config2 = new Configuration();
//                config2.locale = lang2;
//                getResources().updateConfiguration(config2,getResources().getDisplayMetrics());
//            case "ar" :
//                lang = "ar";
//                Locale lang3 = Locale.ENGLISH;
//                Configuration config3 = new Configuration();
//                config3.locale = lang3;
//                getResources().updateConfiguration(config3,getResources().getDisplayMetrics());
//        }
//
//        if(userinfouid.size() != 0 && prf.getString("userinfo_name", "").equals("empty")
//                && prf.getString("userinfo_picture", "").equals("empty")
//                && prf.getInt("user_id", 0) == 0){
//
//            settingactivityuseraccountmanagementaccountchange1handler = new SettingActivityUserAccountmanagementAccountChange1Handler();
//            settingactivityuseraccountmanagementaccountchange2handler = new SettingActivityUserAccountmanagementAccountChange2Handler();
//            settingactivityuseraccountmanagementaccountchange3handler = new SettingActivityUserAccountmanagementAccountChange3Handler();
//
//            user_cate = new ArrayList<>();
//            user_cate.add(getResources().getString(R.string.account_management));
//            user_cate.add(getResources().getString(R.string.language_setting));
//
//
//            LinearLayout Layout1 = new LinearLayout(this);
//            LinearLayout Layout2 = new LinearLayout(this);
//            LinearLayout Layout2_1 = new LinearLayout(this);
//            LinearLayout Layout2_2 = new LinearLayout(this);
//            LinearLayout Layout2_1_1 = new LinearLayout(this);
//            LinearLayout Layout2_1_2 = new LinearLayout(this);
//            LinearLayout Layout2_1_3 = new LinearLayout(this);
//            LinearLayout Layout2_1_4 = new LinearLayout(this);
//            LinearLayout Layout2_1_5 = new LinearLayout(this);
//            LinearLayout Layout2_2_1 = new LinearLayout(this);
//            LinearLayout Layout3 = new LinearLayout(this);
//            LinearLayout Layout4 = new LinearLayout(this);
//
//            Layout1.setOrientation(LinearLayout.HORIZONTAL);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            Layout1.setLayoutParams(params);
//
//            ImageView Home = new ImageView(this);
//            Home.setFocusableInTouchMode(true);
//            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Search = new ImageView(this);
//            Search.setFocusableInTouchMode(true);
//            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView User = new ImageView(this);
//            User.setFocusableInTouchMode(true);
//            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Cart = new ImageView(this);
//            Cart.setFocusableInTouchMode(true);
//            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            CircleImageView My = new CircleImageView(this);
//            My.setFocusableInTouchMode(true);
//            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Setting = new ImageView(this);
//            Setting.setFocusableInTouchMode(true);
//            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            Cart.setPadding(15, 15, 15, 15);
//            CircleImageView Profile[] = new CircleImageView[4];
//            Profile[0] = new CircleImageView(this);
//            Profile[1] = new CircleImageView(this);
//            Profile[2] = new CircleImageView(this);
//            Profile[3] = new CircleImageView(this);
//            ImageView AccountPlus = new ImageView(this);
//            Home.setPadding(15, 15, 15, 15);
//            User.setPadding(15, 15, 15, 15);
//            Search.setPadding(15, 15, 15, 15);
//            My.setPadding(15, 15, 15, 15);
//            Setting.setPadding(15, 15, 15, 15);
//            TextView name[] = new TextView[4];
//            name[0] = new TextView(this);
//            name[1] = new TextView(this);
//            name[2] = new TextView(this);
//            name[3] = new TextView(this);
//            Profile[0].setId(R.id.accountmanagementprofile1);
//            Profile[1].setId(R.id.accountmanagementprofile2);
//            Profile[2].setId(R.id.accountmanagementprofile3);
//            AccountPlus.setId(R.id.accountmanagementprofile4);
//
//            try {
//                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(Profile[3]);
//                name[3].setText(prf.getString("userinfo_name", ""));
//            } catch (Exception e) {
//
//            }
//
//            Home.setImageResource(R.drawable.home);
//            Search.setImageResource(R.drawable.search);
//            User.setImageResource(R.drawable.user);
//            AccountPlus.setImageResource(R.drawable.accountplus);
//            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Cart.setId(R.id.accountmanagementcart);
//            Cart.setImageResource(R.drawable.cart);
//            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));
//            My.setId(R.id.my);
//            if (prf.getString("userinfo_picture", "").equals("empty")) {
//                My.setImageResource(R.drawable.noimg_profile);
//            } else {
//                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(My);
//            }
//            Setting.setImageResource(R.drawable.setting);
//            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Profile[3].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[3].setPadding(20, 20, 20, 20);
//            Profile[0].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[1].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[2].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            AccountPlus.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            AccountPlus.setScaleType(ImageView.ScaleType.FIT_CENTER);
//
//            Profile[0].setPadding(4, 4, 4, 4);
//            Profile[1].setPadding(4, 4, 4, 4);
//            Profile[2].setPadding(4, 4, 4, 4);
//            AccountPlus.setPadding(4, 4, 4, 4);
//
//            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
//            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
//            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
//            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            LinearLayout.LayoutParams params3f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params3ff = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.1f);
//            LinearLayout.LayoutParams params3_1f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.3f);
//            LinearLayout.LayoutParams params3_2f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
//            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//
//            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3_9 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());
//
//            margin.setMargins(10, 20, 5, 20);
//            margin2.setMargins(10, 20, 5, 20);
//            margin3.setMargins(10, 20, 5, 20);
//            margin3_9.setMargins(10, 20, 5, 20);
//            margin5.setMargins(0, 20, 5, 20);
//            margin6.setMargins(10, 20, 20, 20);
//
//            Layout2.setOrientation(LinearLayout.VERTICAL);
//            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
//            Layout2.setLayoutParams(params2);
//            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
//            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
//            Layout4.setBackgroundColor(Color.rgb(29, 29, 29));
//
//            Layout2_1.setLayoutParams(params2_1);
//
//            Layout2_2.setLayoutParams(params2_1);
//            Layout2_2.setGravity(Gravity.BOTTOM);
//
//            Layout2_1_1.setLayoutParams(params2_2);
//            Layout2_1_1.setLayoutParams(margin);
//            Layout2_1_2.setLayoutParams(params2_2);
//            Layout2_1_2.setLayoutParams(margin2);
//            Layout2_1_3.setLayoutParams(params2_2);
//            Layout2_1_3.setLayoutParams(margin3);
//            Layout2_1_4.setLayoutParams(params2_2);
//            Layout2_1_4.setLayoutParams(margin3_9);
//            Layout2_1_5.setLayoutParams(params2_2);
//            Layout2_1_5.setLayoutParams(margin5);
//
//            Layout2_2_1.setLayoutParams(params2_2);
//            Layout2_2_1.setLayoutParams(margin6);
//
//            Layout3.setOrientation(LinearLayout.VERTICAL);
//            Layout3.setGravity(Gravity.CENTER);
//
//            Layout3.setLayoutParams(params3);
//
//            LinearLayout Layout3_2 = new LinearLayout(this);
//            LinearLayout Layout3_2_1 = new LinearLayout(this);
//            LinearLayout Layout3_2_2 = new LinearLayout(this);
//
//            Layout3_2_1.setLayoutParams(params3_1);
//            Layout3_2_2.setLayoutParams(params3_1);
//
//            Layout3_2.setOrientation(LinearLayout.VERTICAL);
//            Layout3_2.setGravity(Gravity.BOTTOM | Gravity.LEFT);
//
//            TV1 = new TextView(this);
//            TextView TV2 = new TextView(this);
//
//            Home.setId(R.id.accountmanagementhome);
//            Search.setId(R.id.accountmanagementsearch);
//            User.setId(R.id.accountmanagementuser);
//            Setting.setId(R.id.setting);
//            TV1.setId(R.id.accountmanagement1);
//            TV2.setId(R.id.accountmanagement2);
//            Setting.setNextFocusUpId(R.id.my);
//
//            TV1.setFocusableInTouchMode(true);
//            TV2.setFocusableInTouchMode(true);
//
//            TV1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
//            TV2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
//
//            TV1.setText(user_cate.get(0));
//            TV2.setText(user_cate.get(1));
//
//            name[0].setTextColor(Color.rgb(255, 255, 255));
//            name[1].setTextColor(Color.rgb(255, 255, 255));
//            name[2].setTextColor(Color.rgb(255, 255, 255));
//            name[3].setTextColor(Color.rgb(255, 255, 255));
//
//            name[0].setTextSize(20);
//            name[1].setTextSize(20);
//            name[2].setTextSize(20);
//            name[3].setTextSize(20);
//
//            TV1.setTextColor(Color.rgb(255, 255, 255));
//            TV2.setTextColor(Color.rgb(255, 255, 255));
//
//            TV1.setPadding(40, 21, 10, 21);
//            TV2.setPadding(40, 21, 10, 21);
//
//            Layout3_2_1.addView(TV1);
//            Layout3_2_2.addView(TV2);
//
//            ViewGroup.MarginLayoutParams margin3_1 = new ViewGroup.MarginLayoutParams(TV1.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3_2 = new ViewGroup.MarginLayoutParams(TV2.getLayoutParams());
//
//            margin3_1.setMargins(30, 22, 0, 0);
//            margin3_2.setMargins(30, 22, 0, 0);
//
//
//            Layout3_2.setLayoutParams(params3f);
//
//            Layout3.addView(Layout3_2);
//            Layout3_2.addView(Layout3_2_1);
//            Layout3_2.addView(Layout3_2_2);
//
//            Layout4.setOrientation(LinearLayout.VERTICAL);
//            Layout4.setGravity(Gravity.LEFT);
//
//            Layout4.setLayoutParams(params4);
//
//            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
//            LinearLayout.LayoutParams params4_4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.2f);
//            LinearLayout.LayoutParams params4_4_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
//            LinearLayout.LayoutParams params4_4_2_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_2_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.25f);
//            LinearLayout.LayoutParams params4_7 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_7_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_7_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//
//            params4_4_2_1.bottomMargin = 10;
//            params4_4_2_2.topMargin = 22;
//            params4_7_1.rightMargin = 10;
//            params4_7_2.leftMargin = 10;
//
//            LinearLayout Layout4_1 = new LinearLayout(this);
//            LinearLayout Layout4_2 = new LinearLayout(this);
//            LinearLayout Layout4_3 = new LinearLayout(this);
//            LinearLayout Layout4_4 = new LinearLayout(this);
//            LinearLayout Layout4_4_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_2 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_5 = new LinearLayout(this);
//            LinearLayout Layout4_5_1 = new LinearLayout(this);
//            LinearLayout Layout4_5_2 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_6 = new LinearLayout(this);
//            LinearLayout Layout4_6_1 = new LinearLayout(this);
//            LinearLayout Layout4_6_2 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_4_4 = new LinearLayout(this);
//            LinearLayout Layout4_4_4_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_4_2 = new LinearLayout(this);
//            LinearLayout Layout4_7 = new LinearLayout(this);
//            LinearLayout Layout4_7_1 = new LinearLayout(this);
//            LinearLayout Layout4_7_2 = new LinearLayout(this);
//
////        LinearLayout Layout4_1 = new LinearLayout(this);
////        LinearLayout Layout4_2 = new LinearLayout(this);
////        LinearLayout Layout4_4 = new LinearLayout(this);
////        LinearLayout Layout4_4_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_1_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_1_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_2_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_2_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_3 = new LinearLayout(this);
////        LinearLayout Layout4_4_3_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_3_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_4 = new LinearLayout(this);
////        LinearLayout Layout4_4_4_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_4_2 = new LinearLayout(this);
////        LinearLayout Layout4_7 = new LinearLayout(this);
////        LinearLayout Layout4_7_1 = new LinearLayout(this);
////        LinearLayout Layout4_7_2 = new LinearLayout(this);
//
//            Layout4_1.setGravity(Gravity.LEFT);
//            Layout4_2.setGravity(Gravity.LEFT);
//            Layout4_3.setGravity(Gravity.CENTER);
//            Layout4_4.setGravity(Gravity.LEFT | Gravity.CENTER);
//            Layout4_4_1.setGravity(Gravity.CENTER);
//            Layout4_4_2.setGravity(Gravity.CENTER);
//            Layout4_4_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//            Layout4_4_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
//            Layout4_4_2_2_1.setGravity(Gravity.LEFT);
//            Layout4_4_2_2_2.setGravity(Gravity.LEFT);
//            Layout4_5.setGravity(Gravity.LEFT | Gravity.CENTER);
//            Layout4_5_1.setGravity(Gravity.CENTER);
//            Layout4_5_2.setGravity(Gravity.CENTER);
//            Layout4_5_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//            Layout4_5_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
//            Layout4_5_2_2_1.setGravity(Gravity.LEFT);
//            Layout4_5_2_2_2.setGravity(Gravity.LEFT);
//            Layout4_6.setGravity(Gravity.LEFT | Gravity.CENTER);
//            Layout4_6_1.setGravity(Gravity.CENTER);
//            Layout4_6_2.setGravity(Gravity.CENTER);
//            Layout4_6_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//            Layout4_6_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
//            Layout4_6_2_2_1.setGravity(Gravity.LEFT);
//            Layout4_6_2_2_2.setGravity(Gravity.LEFT);
//            Layout4_4_4.setGravity(Gravity.CENTER);
//            Layout4_4_4_1.setGravity(Gravity.CENTER);
//            Layout4_4_4_2.setGravity(Gravity.CENTER);
//            Layout4_7.setGravity(Gravity.CENTER);
//            Layout4_7_1.setGravity(Gravity.RIGHT);
//            Layout4_7_2.setGravity(Gravity.LEFT);
//
//            Layout4_3.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_7.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_4_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4_2.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4_2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_4_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_4_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_5_2.setOrientation(LinearLayout.VERTICAL);
//            Layout4_5_2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_5_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_6_2.setOrientation(LinearLayout.VERTICAL);
//            Layout4_6_2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_6_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
//
//            TextView TV10 = new TextView(this);
//            TextView TV11 = new TextView(this);
//            TextView TV12 = new TextView(this);
//            TextView TV13 = new TextView(this);
//            TV13.setId(R.id.accountmanagementlogout);
//
//            TV10.setTextSize(30);
//            TV10.setTypeface(null, Typeface.BOLD);
//            TV11.setTextSize(15);
//            TV13.setTextSize(15);
//
//            TV13.setFocusableInTouchMode(true);
//
//            TV10.setText(getResources().getString(R.string.selectaccount));
//            TV11.setText(getResources().getString(R.string.accountmax));
//            TV12.setText(getResources().getString(R.string.addaccount));
//            TV13.setText(getResources().getString(R.string.logout));
//
//            TV10.setTextColor(Color.rgb(255, 255, 255));
//            TV11.setTextColor(Color.rgb(255, 255, 255));
//            TV12.setTextColor(Color.rgb(255, 255, 255));
//            TV13.setTextColor(Color.rgb(102, 102, 102));
//
//            TV12.setTextSize(10);
//
//            TV10.setPadding(10, 10, 10, 10);
//            TV11.setPadding(10, 10, 10, 10);
//
//            TV11.setGravity(Gravity.CENTER);
//
//            addaccountbtn = new Button(this);
//            logoutbtn = new Button(this);
//            acc1changebtn = new Button(this);
//            acc1disconnectbtn = new Button(this);
//            acc2changebtn = new Button(this);
//            acc2disconnectbtn = new Button(this);
//            acc3changebtn = new Button(this);
//            acc3disconnectbtn = new Button(this);
//
//            addaccountbtn.setTextColor(Color.rgb(255, 255, 255));
//            logoutbtn.setTextColor(Color.rgb(255, 255, 255));
//            acc1changebtn.setTextColor(Color.rgb(255, 255, 255));
//            acc1disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
//            acc2changebtn.setTextColor(Color.rgb(255, 255, 255));
//            acc2disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
//            acc3changebtn.setTextColor(Color.rgb(255, 255, 255));
//            acc3disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
//
//            addaccountbtn.setTextSize(10);
//            logoutbtn.setTextSize(10);
//            acc1changebtn.setTextSize(10);
//            acc1disconnectbtn.setTextSize(10);
//            acc2changebtn.setTextSize(10);
//            acc2disconnectbtn.setTextSize(10);
//            acc3changebtn.setTextSize(10);
//            acc3disconnectbtn.setTextSize(10);
//
//            addaccountbtn.setText(getResources().getString(R.string.addaccount));
//            logoutbtn.setText(getResources().getString(R.string.logout));
//            acc1changebtn.setText(getResources().getString(R.string.change));
//            acc1disconnectbtn.setText(getResources().getString(R.string.disconnect));
//            acc2changebtn.setText(getResources().getString(R.string.change));
//            acc2disconnectbtn.setText(getResources().getString(R.string.disconnect));
//            acc3changebtn.setText(getResources().getString(R.string.change));
//            acc3disconnectbtn.setText(getResources().getString(R.string.disconnect));
//
//            addaccountbtn.setId(R.id.addaccountbtn);
//            logoutbtn.setId(R.id.logoutbtn);
//            acc1changebtn.setId(R.id.changebtn1);
//            acc1disconnectbtn.setId(R.id.disconnectbtn1);
//            acc2changebtn.setId(R.id.changebtn2);
//            acc2disconnectbtn.setId(R.id.disconnectbtn2);
//            acc3changebtn.setId(R.id.changebtn3);
//            acc3disconnectbtn.setId(R.id.disconnectbtn3);
//
//            addaccountbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            logoutbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc1changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc1disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc2changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc2disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc3changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc3disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//
//            addaccountbtn.setLayoutParams(new ViewGroup.LayoutParams(600, 65));
//            logoutbtn.setLayoutParams(new ViewGroup.LayoutParams(600, 65));
//            acc1changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc1disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc2changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc2disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc3changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc3disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//
//            Layout4_1.addView(TV10);
//            Layout4_2.addView(TV11);
//
//            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin4_1 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
//
//            margin4.setMargins(0, 0, 0, 80);
//            margin4_1.setMargins(0, 100, 0, 0);
//
//            Layout4_1.setLayoutParams(params4_1);
//            Layout4_2.setLayoutParams(params4_1);
////        Layout4_2.setLayoutParams(margin4);
//            Layout4_3.setLayoutParams(params4_3);
//            Layout4_4.setLayoutParams(params4_4);
//            Layout4_5.setLayoutParams(params4_4);
//            Layout4_6.setLayoutParams(params4_4);
//            Layout4_4_1.setLayoutParams(params4_4_1);
//            Layout4_5_1.setLayoutParams(params4_4_1);
//            Layout4_6_1.setLayoutParams(params4_4_1);
//            Layout4_4_2.setLayoutParams(params4_4_2);
//            Layout4_5_2.setLayoutParams(params4_4_2);
//            Layout4_6_2.setLayoutParams(params4_4_2);
//            Layout4_4_2_1.setLayoutParams(params4_4_2_1);
//            Layout4_5_2_1.setLayoutParams(params4_4_2_1);
//            Layout4_6_2_1.setLayoutParams(params4_4_2_1);
//            Layout4_4_2_2.setLayoutParams(params4_4_2_2);
//            Layout4_5_2_2.setLayoutParams(params4_4_2_2);
//            Layout4_6_2_2.setLayoutParams(params4_4_2_2);
//            Layout4_4_2_2_1.setLayoutParams(params4_4_2_2_1);
//            Layout4_5_2_2_1.setLayoutParams(params4_4_2_2_1);
//            Layout4_6_2_2_1.setLayoutParams(params4_4_2_2_1);
//            Layout4_4_2_2_2.setLayoutParams(params4_4_2_2_2);
//            Layout4_5_2_2_2.setLayoutParams(params4_4_2_2_2);
//            Layout4_6_2_2_2.setLayoutParams(params4_4_2_2_2);
//
//            Layout4_7.setLayoutParams(params4_7);
//            Layout4_7_1.setLayoutParams(params4_7_1);
//            Layout4_7_2.setLayoutParams(params4_7_2);
////        Layout4_5.setLayoutParams(margin4_1);
//
//
//            Setting.requestFocus();
//
//            Layout1.addView(Layout2);
//
//            Layout2_1.addView(Layout2_1_1);
//            Layout2_1.addView(Layout2_1_2);
//            Layout2_1.addView(Layout2_1_3);
//            Layout2_1.addView(Layout2_1_4);
//            Layout2_1.addView(Layout2_1_5);
//
//            Layout2_1_1.addView(Home);
//            Layout2_1_2.addView(Search);
//            Layout2_1_3.addView(User);
//            Layout2_1_4.addView(Cart);
//            Layout2_1_5.addView(My);
//            Layout2_2_1.addView(Setting);
//
//            Layout2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout2_2.setOrientation(LinearLayout.VERTICAL);
//
//            Layout2_2.addView(Layout2_2_1);
//
//            Layout2.addView(Layout2_1);
//            Layout2.addView(Layout2_2);
//            Layout4_7.addView(Layout4_7_1);
//            Layout4_7.addView(Layout4_7_2);
//            Layout4_7_1.addView(addaccountbtn);
//            Layout4_7_2.addView(logoutbtn);
////        Layout4_5.addView(TV13);
//
//            if (userinfo.size() == 18) {
//                try {
//                    Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
//                    name[0].setText(userinfo.get(0));
//                    Glide.with(this).load(userinfo.get(8)).into(Profile[1]);
//                    name[1].setText(userinfo.get(6));
//                    Glide.with(this).load(userinfo.get(14)).into(Profile[2]);
//                    name[2].setText(userinfo.get(12));
//                    Layout4_4.addView(Layout4_4_1);
//                    Layout4_4.addView(Layout4_4_2);
//                    Layout4_4_2.addView(Layout4_4_2_1);
//                    Layout4_4_2.addView(Layout4_4_2_2);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
//                    Layout4_4_1.addView(Profile[0]);
//                    Layout4_4_2_1.addView(name[0]);
//                    Layout4_4_2_2_1.addView(acc1changebtn);
//                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
//
//                    Layout4_5.addView(Layout4_5_1);
//                    Layout4_5.addView(Layout4_5_2);
//                    Layout4_5_2.addView(Layout4_5_2_1);
//                    Layout4_5_2.addView(Layout4_5_2_2);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_1);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_2);
//                    Layout4_5_1.addView(Profile[1]);
//                    Layout4_5_2_1.addView(name[1]);
//                    Layout4_5_2_2_1.addView(acc2changebtn);
//                    Layout4_5_2_2_2.addView(acc2disconnectbtn);
//
//                    Layout4_6.addView(Layout4_6_1);
//                    Layout4_6.addView(Layout4_6_2);
//                    Layout4_6_2.addView(Layout4_6_2_1);
//                    Layout4_6_2.addView(Layout4_6_2_2);
//                    Layout4_6_2_2.addView(Layout4_6_2_2_1);
//                    Layout4_6_2_2.addView(Layout4_6_2_2_2);
//                    Layout4_6_1.addView(Profile[2]);
//                    Layout4_6_2_1.addView(name[2]);
//                    Layout4_6_2_2_1.addView(acc3changebtn);
//                    Layout4_6_2_2_2.addView(acc3disconnectbtn);
//
//                    Layout4_3.addView(Layout4_4);
//                    Layout4_3.addView(Layout4_5);
//                    Layout4_3.addView(Layout4_6);
//
//                    params4_3.topMargin = 20;
//                    params4_3.bottomMargin = 50;
//                } catch (Exception e) {
//
//                }
//            } else if (userinfo.size() == 12) {
//                try {
//                    Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
//                    name[0].setText(userinfo.get(0));
//                    Glide.with(this).load(userinfo.get(8)).into(Profile[1]);
//                    name[1].setText(userinfo.get(6));
//                    Layout4_4.addView(Layout4_4_1);
//                    Layout4_4.addView(Layout4_4_2);
//                    Layout4_4_2.addView(Layout4_4_2_1);
//                    Layout4_4_2.addView(Layout4_4_2_2);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
//                    Layout4_4_1.addView(Profile[0]);
//                    Layout4_4_2_1.addView(name[0]);
//                    Layout4_4_2_2_1.addView(acc1changebtn);
//                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
//                    Layout4_5.addView(Layout4_5_1);
//                    Layout4_5.addView(Layout4_5_2);
//                    Layout4_5_2.addView(Layout4_5_2_1);
//                    Layout4_5_2.addView(Layout4_5_2_2);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_1);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_2);
//                    Layout4_5_1.addView(Profile[1]);
//                    Layout4_5_2_1.addView(name[1]);
//                    Layout4_5_2_2_1.addView(acc2changebtn);
//                    Layout4_5_2_2_2.addView(acc2disconnectbtn);
//                    Layout4_3.addView(Layout4_4);
//                    Layout4_3.addView(Layout4_5);
//                    params4_3.topMargin = 120;
//                    params4_3.bottomMargin = 150;
//                    params4_4_1.topMargin = 2;
//                } catch (Exception e) {
//
//                }
//            } else if (userinfo.size() == 6) {
//                try {
//                    Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
//                    name[0].setText(userinfo.get(0));
//                    Layout4_4.addView(Layout4_4_1);
//                    Layout4_4.addView(Layout4_4_2);
//                    Layout4_4_2.addView(Layout4_4_2_1);
//                    Layout4_4_2.addView(Layout4_4_2_2);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
//                    Layout4_4_1.addView(Profile[0]);
//                    Layout4_4_2_1.addView(name[0]);
//                    Layout4_4_2_2_1.addView(acc1changebtn);
//                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
//                    Layout4_3.addView(Layout4_4);
//                    params4_3.topMargin = 20;
//                    params4_3.bottomMargin = 50;
//                    params4_4_1.bottomMargin = 35;
//                } catch (Exception e) {
//
//                }
//            } else {
//                Layout4_4.addView(Layout4_4_4);
//                Layout4_4_4.addView(Layout4_4_4_1);
//                Layout4_4_4.addView(Layout4_4_4_2);
//            }
//
//            TV1.setNextFocusRightId(R.id.changebtn1);
//
//            acc1changebtn.setNextFocusUpId(R.id.changebtn1);
//            acc1disconnectbtn.setNextFocusUpId(R.id.disconnectbtn1);
//
//            acc1changebtn.setNextFocusLeftId(R.id.accountmanagement1);
//            acc2changebtn.setNextFocusLeftId(R.id.accountmanagement1);
//            acc3changebtn.setNextFocusLeftId(R.id.accountmanagement1);
//
//            acc1disconnectbtn.setNextFocusRightId(R.id.disconnectbtn1);
//            acc2disconnectbtn.setNextFocusRightId(R.id.disconnectbtn2);
//            acc3disconnectbtn.setNextFocusRightId(R.id.disconnectbtn3);
//
//            logoutbtn.setNextFocusDownId(R.id.logoutbtn);
//            addaccountbtn.setNextFocusDownId(R.id.addaccountbtn);
//
//            Layout4.addView(Layout4_1);
//            Layout4.addView(Layout4_2);
//            Layout4.addView(Layout4_3);
//            Layout4.addView(Layout4_7);
//
//            Layout1.addView(Layout3);
//
//            Layout1.addView(Layout4);
//
//            setContentView(Layout1);
//
//            Home.setNextFocusRightId(R.id.accountmanagement1);
//            Search.setNextFocusRightId(R.id.accountmanagement1);
//            User.setNextFocusRightId(R.id.accountmanagement1);
//            Home.setNextFocusUpId(R.id.accountmanagementuser);
//            User.setNextFocusDownId(R.id.accountmanagementhome);
////        Profile[0].setNextFocusLeftId(R.id.accountmanagement1);
////        Profile[0].setNextFocusDownId(R.id.accountmanagementlogout);
////        Profile[0].setNextFocusUpId(R.id.accountmanagementlogout);
////        Profile[1].setNextFocusDownId(R.id.accountmanagementlogout);
////        Profile[1].setNextFocusUpId(R.id.accountmanagementlogout);
////        Profile[2].setNextFocusDownId(R.id.accountmanagementlogout);
////        Profile[2].setNextFocusUpId(R.id.accountmanagementlogout);
////        AccountPlus.setNextFocusUpId(R.id.accountmanagementlogout);
////        TV13.setNextFocusDownId(R.id.accountmanagementprofile1);
////        TV13.setNextFocusUpId(R.id.accountmanagementprofile1);
//            TV1.setNextFocusLeftId(R.id.setting);
//            TV1.setNextFocusUpId(R.id.accountmanagement1);
//            TV2.setNextFocusLeftId(R.id.setting);
//            Setting.setNextFocusRightId(R.id.accountmanagement1);
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
//
//            Setting.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                    if (hasFocus == false) {
//
//                        Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                        TV1.setTextColor(Color.rgb(255, 255, 255));
//
//                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Home.setImageResource(R.drawable.homeselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, HomeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Home.setImageResource(R.drawable.home);
//                                }
//                            }
//                        });
//
//                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SearchActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Search.setImageResource(R.drawable.search);
//                                }
//                            }
//                        });
//
//                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SubscribeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, CartActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, MyActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(066, 066, 066));
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_1.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
////                              finish();
//                                }else {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                        TV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    TV2.setTextColor(Color.rgb(066, 066, 066));
//                                    Layout3_2_1.setBackground(null);
//                                    Layout3_2_2.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SettingActivityLanguagesetting.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                              finish();
//                                }else {
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                    } else {
//                    }
//                }
//            });
//
//            TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                    if (hasFocus == false) {
//
//                        Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                        TV1.setTextColor(Color.rgb(255, 255, 255));
//
//                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Home.setImageResource(R.drawable.homeselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, HomeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Home.setImageResource(R.drawable.home);
//                                }
//                            }
//                        });
//
//                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SearchActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Search.setImageResource(R.drawable.search);
//                                }
//                            }
//                        });
//
//                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SubscribeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, CartActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, MyActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        TV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    TV2.setTextColor(Color.rgb(066, 066, 066));
//                                    Layout3_2_1.setBackground(null);
//                                    Layout3_2_2.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SettingActivityLanguagesetting.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                              finish();
//                                }else {
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                    } else {
//                        TV1.setTextColor(Color.rgb(066, 066, 066));
//                        Layout3_2_1.setBackgroundColor(Color.rgb(255, 255, 255));
//                    }
//                }
//            });
//
//            logoutbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    SharedPreferences.Editor editor = prf.edit();
//                    editor.clear();
//                    editor.commit();
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, LoadingActivity.class);
//                    intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//
//            addaccountbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (userinfo.size() == 18 && userinfouid.size() == 3) {
//                        builder.setTitle(getResources().getString(R.string.alertdialog_maxaccount));
//
//                        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int id) {
//
//                            }
//                        });
//
//                        AlertDialog alertDialog = builder.create();
//                        alertDialog.show();
//                    } else {
//                        Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountAdd.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                        startActivity(intent);
////                finish();
//                    }
//                }
//            });
//
//            acc1changebtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    settingactivityuseraccountmanagementaccountchange1handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            NetworkTaskUsersChange1 networktaskuserschange1 = new NetworkTaskUsersChange1(api_tvott_users, null);
//                            networktaskuserschange1.execute();
//                        }
//                    });
////                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange1.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
////                startActivity(intent);
//////                finish();
//                }
//            });
//
//            acc1disconnectbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountDisconnect1.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
////                finish();
//                }
//            });
//
//            acc2changebtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    settingactivityuseraccountmanagementaccountchange2handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            NetworkTaskUsersChange2 networktaskuserschange2 = new NetworkTaskUsersChange2(api_tvott_users, null);
//                            networktaskuserschange2.execute();
//                        }
//                    });
////                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange2.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
////                startActivity(intent);
//////                finish();
//                }
//            });
//
//            acc2disconnectbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountDisconnect2.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
////                finish();
//                }
//            });
//
//            acc3changebtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    settingactivityuseraccountmanagementaccountchange3handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            NetworkTaskUsersChange3 networktaskuserschange3 = new NetworkTaskUsersChange3(api_tvott_users, null);
//                            networktaskuserschange3.execute();
//                        }
//                    });
////                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange3.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
////                startActivity(intent);
//////                finish();
//                }
//            });
//
//            acc3disconnectbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountDisconnect3.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
////                finish();
//                }
//            });
//
//        }
//        else if(userinfouid.size() != 0 && prf.getString("userinfo_name", "").equals("")
//                && prf.getString("userinfo_picture", "").equals("")
//                && prf.getInt("user_id", 0) == 0){
//
//            setDefaultDataGuestLanguageSetting();
//            readData();
//
//            settingactivityuseraccountmanagementaccountchange1handler = new SettingActivityUserAccountmanagementAccountChange1Handler();
//            settingactivityuseraccountmanagementaccountchange2handler = new SettingActivityUserAccountmanagementAccountChange2Handler();
//            settingactivityuseraccountmanagementaccountchange3handler = new SettingActivityUserAccountmanagementAccountChange3Handler();
//
//            user_cate = new ArrayList<>();
//            user_cate.add(getResources().getString(R.string.account_management));
//            user_cate.add(getResources().getString(R.string.language_setting));
//
//
//            LinearLayout Layout1 = new LinearLayout(this);
//            LinearLayout Layout2 = new LinearLayout(this);
//            LinearLayout Layout2_1 = new LinearLayout(this);
//            LinearLayout Layout2_2 = new LinearLayout(this);
//            LinearLayout Layout2_1_1 = new LinearLayout(this);
//            LinearLayout Layout2_1_2 = new LinearLayout(this);
//            LinearLayout Layout2_1_3 = new LinearLayout(this);
//            LinearLayout Layout2_1_4 = new LinearLayout(this);
//            LinearLayout Layout2_1_5 = new LinearLayout(this);
//            LinearLayout Layout2_2_1 = new LinearLayout(this);
//            LinearLayout Layout3 = new LinearLayout(this);
//            LinearLayout Layout4 = new LinearLayout(this);
//
//            Layout1.setOrientation(LinearLayout.HORIZONTAL);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            Layout1.setLayoutParams(params);
//
//            ImageView Home = new ImageView(this);
//            Home.setFocusableInTouchMode(true);
//            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Search = new ImageView(this);
//            Search.setFocusableInTouchMode(true);
//            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView User = new ImageView(this);
//            User.setFocusableInTouchMode(true);
//            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Cart = new ImageView(this);
//            Cart.setFocusableInTouchMode(true);
//            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            CircleImageView My = new CircleImageView(this);
//            My.setFocusableInTouchMode(true);
//            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Setting = new ImageView(this);
//            Setting.setFocusableInTouchMode(true);
//            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            Cart.setPadding(15, 15, 15, 15);
//            CircleImageView Profile[] = new CircleImageView[4];
//            Profile[0] = new CircleImageView(this);
//            Profile[1] = new CircleImageView(this);
//            Profile[2] = new CircleImageView(this);
//            Profile[3] = new CircleImageView(this);
//            ImageView AccountPlus = new ImageView(this);
//            Home.setPadding(15, 15, 15, 15);
//            User.setPadding(15, 15, 15, 15);
//            Search.setPadding(15, 15, 15, 15);
//            My.setPadding(15, 15, 15, 15);
//            Setting.setPadding(15, 15, 15, 15);
//            TextView name[] = new TextView[4];
//            name[0] = new TextView(this);
//            name[1] = new TextView(this);
//            name[2] = new TextView(this);
//            name[3] = new TextView(this);
//            Profile[0].setId(R.id.accountmanagementprofile1);
//            Profile[1].setId(R.id.accountmanagementprofile2);
//            Profile[2].setId(R.id.accountmanagementprofile3);
//            AccountPlus.setId(R.id.accountmanagementprofile4);
//
//            try {
//                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(Profile[3]);
//                name[3].setText(prf.getString("userinfo_name", ""));
//            } catch (Exception e) {
//
//            }
//
//            Home.setImageResource(R.drawable.home);
//            Search.setImageResource(R.drawable.search);
//            User.setImageResource(R.drawable.user);
//            AccountPlus.setImageResource(R.drawable.accountplus);
//            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Cart.setId(R.id.accountmanagementcart);
//            Cart.setImageResource(R.drawable.cart);
//            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));
//            My.setId(R.id.my);
//            if (prf.getString("userinfo_picture", "").equals("empty")) {
//                My.setImageResource(R.drawable.noimg_profile);
//            } else {
//                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(My);
//            }
//            Setting.setImageResource(R.drawable.setting);
//            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Profile[3].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[3].setPadding(20, 20, 20, 20);
//            Profile[0].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[1].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[2].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            AccountPlus.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            AccountPlus.setScaleType(ImageView.ScaleType.FIT_CENTER);
//
//            Profile[0].setPadding(4, 4, 4, 4);
//            Profile[1].setPadding(4, 4, 4, 4);
//            Profile[2].setPadding(4, 4, 4, 4);
//            AccountPlus.setPadding(4, 4, 4, 4);
//
//            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
//            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
//            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
//            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            LinearLayout.LayoutParams params3f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params3ff = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.1f);
//            LinearLayout.LayoutParams params3_1f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.3f);
//            LinearLayout.LayoutParams params3_2f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
//            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//
//            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3_9 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());
//
//            margin.setMargins(10, 20, 5, 20);
//            margin2.setMargins(10, 20, 5, 20);
//            margin3.setMargins(10, 20, 5, 20);
//            margin3_9.setMargins(10, 20, 5, 20);
//            margin5.setMargins(0, 20, 5, 20);
//            margin6.setMargins(10, 20, 20, 20);
//
//            Layout2.setOrientation(LinearLayout.VERTICAL);
//            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
//            Layout2.setLayoutParams(params2);
//            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
//            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
//            Layout4.setBackgroundColor(Color.rgb(29, 29, 29));
//
//            Layout2_1.setLayoutParams(params2_1);
//
//            Layout2_2.setLayoutParams(params2_1);
//            Layout2_2.setGravity(Gravity.BOTTOM);
//
//            Layout2_1_1.setLayoutParams(params2_2);
//            Layout2_1_1.setLayoutParams(margin);
//            Layout2_1_2.setLayoutParams(params2_2);
//            Layout2_1_2.setLayoutParams(margin2);
//            Layout2_1_3.setLayoutParams(params2_2);
//            Layout2_1_3.setLayoutParams(margin3);
//            Layout2_1_4.setLayoutParams(params2_2);
//            Layout2_1_4.setLayoutParams(margin3_9);
//            Layout2_1_5.setLayoutParams(params2_2);
//            Layout2_1_5.setLayoutParams(margin5);
//
//            Layout2_2_1.setLayoutParams(params2_2);
//            Layout2_2_1.setLayoutParams(margin6);
//
//            Layout3.setOrientation(LinearLayout.VERTICAL);
//            Layout3.setGravity(Gravity.CENTER);
//
//            Layout3.setLayoutParams(params3);
//
//            LinearLayout Layout3_2 = new LinearLayout(this);
//            LinearLayout Layout3_2_1 = new LinearLayout(this);
//            LinearLayout Layout3_2_2 = new LinearLayout(this);
//
//            Layout3_2_1.setLayoutParams(params3_1);
//            Layout3_2_2.setLayoutParams(params3_1);
//
//            Layout3_2.setOrientation(LinearLayout.VERTICAL);
//            Layout3_2.setGravity(Gravity.BOTTOM | Gravity.LEFT);
//
//            TV1 = new TextView(this);
//            TextView TV2 = new TextView(this);
//
//            Home.setId(R.id.accountmanagementhome);
//            Search.setId(R.id.accountmanagementsearch);
//            User.setId(R.id.accountmanagementuser);
//            Setting.setId(R.id.setting);
//            TV1.setId(R.id.accountmanagement1);
//            TV2.setId(R.id.accountmanagement2);
//            Setting.setNextFocusUpId(R.id.my);
//
//            TV1.setFocusableInTouchMode(true);
//            TV2.setFocusableInTouchMode(true);
//
//            TV1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
//            TV2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
//
//            TV1.setText(user_cate.get(0));
//            TV2.setText(user_cate.get(1));
//
//            name[0].setTextColor(Color.rgb(255, 255, 255));
//            name[1].setTextColor(Color.rgb(255, 255, 255));
//            name[2].setTextColor(Color.rgb(255, 255, 255));
//            name[3].setTextColor(Color.rgb(255, 255, 255));
//
//            name[0].setTextSize(20);
//            name[1].setTextSize(20);
//            name[2].setTextSize(20);
//            name[3].setTextSize(20);
//
//            TV1.setTextColor(Color.rgb(255, 255, 255));
//            TV2.setTextColor(Color.rgb(255, 255, 255));
//
//            TV1.setPadding(40, 21, 10, 21);
//            TV2.setPadding(40, 21, 10, 21);
//
//            Layout3_2_1.addView(TV1);
//            Layout3_2_2.addView(TV2);
//
//            ViewGroup.MarginLayoutParams margin3_1 = new ViewGroup.MarginLayoutParams(TV1.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3_2 = new ViewGroup.MarginLayoutParams(TV2.getLayoutParams());
//
//            margin3_1.setMargins(30, 22, 0, 0);
//            margin3_2.setMargins(30, 22, 0, 0);
//
//
//            Layout3_2.setLayoutParams(params3f);
//
//            Layout3.addView(Layout3_2);
//            Layout3_2.addView(Layout3_2_1);
//            Layout3_2.addView(Layout3_2_2);
//
//            Layout4.setOrientation(LinearLayout.VERTICAL);
//            Layout4.setGravity(Gravity.LEFT);
//
//            Layout4.setLayoutParams(params4);
//
//            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
//            LinearLayout.LayoutParams params4_4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.2f);
//            LinearLayout.LayoutParams params4_4_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
//            LinearLayout.LayoutParams params4_4_2_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_2_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.25f);
//            LinearLayout.LayoutParams params4_7 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_7_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_7_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//
//            params4_4_2_1.bottomMargin = 10;
//            params4_4_2_2.topMargin = 22;
//            params4_7_1.rightMargin = 10;
//            params4_7_2.leftMargin = 10;
//
//            LinearLayout Layout4_1 = new LinearLayout(this);
//            LinearLayout Layout4_2 = new LinearLayout(this);
//            LinearLayout Layout4_3 = new LinearLayout(this);
//            LinearLayout Layout4_4 = new LinearLayout(this);
//            LinearLayout Layout4_4_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_2 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_5 = new LinearLayout(this);
//            LinearLayout Layout4_5_1 = new LinearLayout(this);
//            LinearLayout Layout4_5_2 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_6 = new LinearLayout(this);
//            LinearLayout Layout4_6_1 = new LinearLayout(this);
//            LinearLayout Layout4_6_2 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_4_4 = new LinearLayout(this);
//            LinearLayout Layout4_4_4_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_4_2 = new LinearLayout(this);
//            LinearLayout Layout4_7 = new LinearLayout(this);
//            LinearLayout Layout4_7_1 = new LinearLayout(this);
//            LinearLayout Layout4_7_2 = new LinearLayout(this);
//
////        LinearLayout Layout4_1 = new LinearLayout(this);
////        LinearLayout Layout4_2 = new LinearLayout(this);
////        LinearLayout Layout4_4 = new LinearLayout(this);
////        LinearLayout Layout4_4_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_1_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_1_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_2_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_2_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_3 = new LinearLayout(this);
////        LinearLayout Layout4_4_3_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_3_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_4 = new LinearLayout(this);
////        LinearLayout Layout4_4_4_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_4_2 = new LinearLayout(this);
////        LinearLayout Layout4_7 = new LinearLayout(this);
////        LinearLayout Layout4_7_1 = new LinearLayout(this);
////        LinearLayout Layout4_7_2 = new LinearLayout(this);
//
//            Layout4_1.setGravity(Gravity.LEFT);
//            Layout4_2.setGravity(Gravity.LEFT);
//            Layout4_3.setGravity(Gravity.CENTER);
//            Layout4_4.setGravity(Gravity.LEFT | Gravity.CENTER);
//            Layout4_4_1.setGravity(Gravity.CENTER);
//            Layout4_4_2.setGravity(Gravity.CENTER);
//            Layout4_4_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//            Layout4_4_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
//            Layout4_4_2_2_1.setGravity(Gravity.LEFT);
//            Layout4_4_2_2_2.setGravity(Gravity.LEFT);
//            Layout4_5.setGravity(Gravity.LEFT | Gravity.CENTER);
//            Layout4_5_1.setGravity(Gravity.CENTER);
//            Layout4_5_2.setGravity(Gravity.CENTER);
//            Layout4_5_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//            Layout4_5_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
//            Layout4_5_2_2_1.setGravity(Gravity.LEFT);
//            Layout4_5_2_2_2.setGravity(Gravity.LEFT);
//            Layout4_6.setGravity(Gravity.LEFT | Gravity.CENTER);
//            Layout4_6_1.setGravity(Gravity.CENTER);
//            Layout4_6_2.setGravity(Gravity.CENTER);
//            Layout4_6_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//            Layout4_6_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
//            Layout4_6_2_2_1.setGravity(Gravity.LEFT);
//            Layout4_6_2_2_2.setGravity(Gravity.LEFT);
//            Layout4_4_4.setGravity(Gravity.CENTER);
//            Layout4_4_4_1.setGravity(Gravity.CENTER);
//            Layout4_4_4_2.setGravity(Gravity.CENTER);
//            Layout4_7.setGravity(Gravity.CENTER);
//            Layout4_7_1.setGravity(Gravity.RIGHT);
//            Layout4_7_2.setGravity(Gravity.LEFT);
//
//            Layout4_3.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_7.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_4_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4_2.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4_2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_4_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_4_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_5_2.setOrientation(LinearLayout.VERTICAL);
//            Layout4_5_2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_5_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_6_2.setOrientation(LinearLayout.VERTICAL);
//            Layout4_6_2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_6_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
//
//            TextView TV10 = new TextView(this);
//            TextView TV11 = new TextView(this);
//            TextView TV12 = new TextView(this);
//            TextView TV13 = new TextView(this);
//            TV13.setId(R.id.accountmanagementlogout);
//
//            TV10.setTextSize(30);
//            TV10.setTypeface(null, Typeface.BOLD);
//            TV11.setTextSize(15);
//            TV13.setTextSize(15);
//
//            TV13.setFocusableInTouchMode(true);
//
//            TV10.setText(getResources().getString(R.string.selectaccount));
//            TV11.setText(getResources().getString(R.string.accountmax));
//            TV12.setText(getResources().getString(R.string.addaccount));
//            TV13.setText(getResources().getString(R.string.logout));
//
//            TV10.setTextColor(Color.rgb(255, 255, 255));
//            TV11.setTextColor(Color.rgb(255, 255, 255));
//            TV12.setTextColor(Color.rgb(255, 255, 255));
//            TV13.setTextColor(Color.rgb(102, 102, 102));
//
//            TV12.setTextSize(10);
//
//            TV10.setPadding(10, 10, 10, 10);
//            TV11.setPadding(10, 10, 10, 10);
//
//            TV11.setGravity(Gravity.CENTER);
//
//            addaccountbtn = new Button(this);
//            logoutbtn = new Button(this);
//            acc1changebtn = new Button(this);
//            acc1disconnectbtn = new Button(this);
//            acc2changebtn = new Button(this);
//            acc2disconnectbtn = new Button(this);
//            acc3changebtn = new Button(this);
//            acc3disconnectbtn = new Button(this);
//
//            addaccountbtn.setTextColor(Color.rgb(255, 255, 255));
//            logoutbtn.setTextColor(Color.rgb(255, 255, 255));
//            acc1changebtn.setTextColor(Color.rgb(255, 255, 255));
//            acc1disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
//            acc2changebtn.setTextColor(Color.rgb(255, 255, 255));
//            acc2disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
//            acc3changebtn.setTextColor(Color.rgb(255, 255, 255));
//            acc3disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
//
//            addaccountbtn.setTextSize(10);
//            logoutbtn.setTextSize(10);
//            acc1changebtn.setTextSize(10);
//            acc1disconnectbtn.setTextSize(10);
//            acc2changebtn.setTextSize(10);
//            acc2disconnectbtn.setTextSize(10);
//            acc3changebtn.setTextSize(10);
//            acc3disconnectbtn.setTextSize(10);
//
//            addaccountbtn.setText(getResources().getString(R.string.addaccount));
//            logoutbtn.setText(getResources().getString(R.string.logout));
//            acc1changebtn.setText(getResources().getString(R.string.change));
//            acc1disconnectbtn.setText(getResources().getString(R.string.disconnect));
//            acc2changebtn.setText(getResources().getString(R.string.change));
//            acc2disconnectbtn.setText(getResources().getString(R.string.disconnect));
//            acc3changebtn.setText(getResources().getString(R.string.change));
//            acc3disconnectbtn.setText(getResources().getString(R.string.disconnect));
//
//            addaccountbtn.setId(R.id.addaccountbtn);
//            logoutbtn.setId(R.id.logoutbtn);
//            acc1changebtn.setId(R.id.changebtn1);
//            acc1disconnectbtn.setId(R.id.disconnectbtn1);
//            acc2changebtn.setId(R.id.changebtn2);
//            acc2disconnectbtn.setId(R.id.disconnectbtn2);
//            acc3changebtn.setId(R.id.changebtn3);
//            acc3disconnectbtn.setId(R.id.disconnectbtn3);
//
//            addaccountbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            logoutbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc1changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc1disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc2changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc2disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc3changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc3disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//
//            addaccountbtn.setLayoutParams(new ViewGroup.LayoutParams(600, 65));
//            logoutbtn.setLayoutParams(new ViewGroup.LayoutParams(600, 65));
//            acc1changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc1disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc2changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc2disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc3changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc3disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//
//            Layout4_1.addView(TV10);
//            Layout4_2.addView(TV11);
//
//            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin4_1 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
//
//            margin4.setMargins(0, 0, 0, 80);
//            margin4_1.setMargins(0, 100, 0, 0);
//
//            Layout4_1.setLayoutParams(params4_1);
//            Layout4_2.setLayoutParams(params4_1);
////        Layout4_2.setLayoutParams(margin4);
//            Layout4_3.setLayoutParams(params4_3);
//            Layout4_4.setLayoutParams(params4_4);
//            Layout4_5.setLayoutParams(params4_4);
//            Layout4_6.setLayoutParams(params4_4);
//            Layout4_4_1.setLayoutParams(params4_4_1);
//            Layout4_5_1.setLayoutParams(params4_4_1);
//            Layout4_6_1.setLayoutParams(params4_4_1);
//            Layout4_4_2.setLayoutParams(params4_4_2);
//            Layout4_5_2.setLayoutParams(params4_4_2);
//            Layout4_6_2.setLayoutParams(params4_4_2);
//            Layout4_4_2_1.setLayoutParams(params4_4_2_1);
//            Layout4_5_2_1.setLayoutParams(params4_4_2_1);
//            Layout4_6_2_1.setLayoutParams(params4_4_2_1);
//            Layout4_4_2_2.setLayoutParams(params4_4_2_2);
//            Layout4_5_2_2.setLayoutParams(params4_4_2_2);
//            Layout4_6_2_2.setLayoutParams(params4_4_2_2);
//            Layout4_4_2_2_1.setLayoutParams(params4_4_2_2_1);
//            Layout4_5_2_2_1.setLayoutParams(params4_4_2_2_1);
//            Layout4_6_2_2_1.setLayoutParams(params4_4_2_2_1);
//            Layout4_4_2_2_2.setLayoutParams(params4_4_2_2_2);
//            Layout4_5_2_2_2.setLayoutParams(params4_4_2_2_2);
//            Layout4_6_2_2_2.setLayoutParams(params4_4_2_2_2);
//
//            Layout4_7.setLayoutParams(params4_7);
//            Layout4_7_1.setLayoutParams(params4_7_1);
//            Layout4_7_2.setLayoutParams(params4_7_2);
////        Layout4_5.setLayoutParams(margin4_1);
//
//
//            Setting.requestFocus();
//
//            Layout1.addView(Layout2);
//
//            Layout2_1.addView(Layout2_1_1);
//            Layout2_1.addView(Layout2_1_2);
//            Layout2_1.addView(Layout2_1_3);
//            Layout2_1.addView(Layout2_1_4);
//            Layout2_1.addView(Layout2_1_5);
//
//            Layout2_1_1.addView(Home);
//            Layout2_1_2.addView(Search);
//            Layout2_1_3.addView(User);
//            Layout2_1_4.addView(Cart);
//            Layout2_1_5.addView(My);
//            Layout2_2_1.addView(Setting);
//
//            Layout2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout2_2.setOrientation(LinearLayout.VERTICAL);
//
//            Layout2_2.addView(Layout2_2_1);
//
//            Layout2.addView(Layout2_1);
//            Layout2.addView(Layout2_2);
//            Layout4_7.addView(Layout4_7_1);
//            Layout4_7.addView(Layout4_7_2);
//            Layout4_7_1.addView(addaccountbtn);
//            Layout4_7_2.addView(logoutbtn);
////        Layout4_5.addView(TV13);
//
//            if (userinfo.size() == 18) {
//                try {
//                    Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
//                    name[0].setText(userinfo.get(0));
//                    Glide.with(this).load(userinfo.get(8)).into(Profile[1]);
//                    name[1].setText(userinfo.get(6));
//                    Glide.with(this).load(userinfo.get(14)).into(Profile[2]);
//                    name[2].setText(userinfo.get(12));
//                    Layout4_4.addView(Layout4_4_1);
//                    Layout4_4.addView(Layout4_4_2);
//                    Layout4_4_2.addView(Layout4_4_2_1);
//                    Layout4_4_2.addView(Layout4_4_2_2);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
//                    Layout4_4_1.addView(Profile[0]);
//                    Layout4_4_2_1.addView(name[0]);
//                    Layout4_4_2_2_1.addView(acc1changebtn);
//                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
//
//                    Layout4_5.addView(Layout4_5_1);
//                    Layout4_5.addView(Layout4_5_2);
//                    Layout4_5_2.addView(Layout4_5_2_1);
//                    Layout4_5_2.addView(Layout4_5_2_2);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_1);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_2);
//                    Layout4_5_1.addView(Profile[1]);
//                    Layout4_5_2_1.addView(name[1]);
//                    Layout4_5_2_2_1.addView(acc2changebtn);
//                    Layout4_5_2_2_2.addView(acc2disconnectbtn);
//
//                    Layout4_6.addView(Layout4_6_1);
//                    Layout4_6.addView(Layout4_6_2);
//                    Layout4_6_2.addView(Layout4_6_2_1);
//                    Layout4_6_2.addView(Layout4_6_2_2);
//                    Layout4_6_2_2.addView(Layout4_6_2_2_1);
//                    Layout4_6_2_2.addView(Layout4_6_2_2_2);
//                    Layout4_6_1.addView(Profile[2]);
//                    Layout4_6_2_1.addView(name[2]);
//                    Layout4_6_2_2_1.addView(acc3changebtn);
//                    Layout4_6_2_2_2.addView(acc3disconnectbtn);
//
//                    Layout4_3.addView(Layout4_4);
//                    Layout4_3.addView(Layout4_5);
//                    Layout4_3.addView(Layout4_6);
//
//                    params4_3.topMargin = 20;
//                    params4_3.bottomMargin = 50;
//                } catch (Exception e) {
//
//                }
//            } else if (userinfo.size() == 12) {
//                try {
//                    Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
//                    name[0].setText(userinfo.get(0));
//                    Glide.with(this).load(userinfo.get(8)).into(Profile[1]);
//                    name[1].setText(userinfo.get(6));
//                    Layout4_4.addView(Layout4_4_1);
//                    Layout4_4.addView(Layout4_4_2);
//                    Layout4_4_2.addView(Layout4_4_2_1);
//                    Layout4_4_2.addView(Layout4_4_2_2);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
//                    Layout4_4_1.addView(Profile[0]);
//                    Layout4_4_2_1.addView(name[0]);
//                    Layout4_4_2_2_1.addView(acc1changebtn);
//                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
//                    Layout4_5.addView(Layout4_5_1);
//                    Layout4_5.addView(Layout4_5_2);
//                    Layout4_5_2.addView(Layout4_5_2_1);
//                    Layout4_5_2.addView(Layout4_5_2_2);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_1);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_2);
//                    Layout4_5_1.addView(Profile[1]);
//                    Layout4_5_2_1.addView(name[1]);
//                    Layout4_5_2_2_1.addView(acc2changebtn);
//                    Layout4_5_2_2_2.addView(acc2disconnectbtn);
//                    Layout4_3.addView(Layout4_4);
//                    Layout4_3.addView(Layout4_5);
//                    params4_3.topMargin = 120;
//                    params4_3.bottomMargin = 150;
//                    params4_4_1.topMargin = 2;
//                } catch (Exception e) {
//
//                }
//            } else if (userinfo.size() == 6) {
//                try {
//                    Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
//                    name[0].setText(userinfo.get(0));
//                    Layout4_4.addView(Layout4_4_1);
//                    Layout4_4.addView(Layout4_4_2);
//                    Layout4_4_2.addView(Layout4_4_2_1);
//                    Layout4_4_2.addView(Layout4_4_2_2);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
//                    Layout4_4_1.addView(Profile[0]);
//                    Layout4_4_2_1.addView(name[0]);
//                    Layout4_4_2_2_1.addView(acc1changebtn);
//                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
//                    Layout4_3.addView(Layout4_4);
//                    params4_3.topMargin = 20;
//                    params4_3.bottomMargin = 50;
//                    params4_4_1.bottomMargin = 35;
//                } catch (Exception e) {
//
//                }
//            } else {
//                Layout4_4.addView(Layout4_4_4);
//                Layout4_4_4.addView(Layout4_4_4_1);
//                Layout4_4_4.addView(Layout4_4_4_2);
//            }
//
//            TV1.setNextFocusRightId(R.id.changebtn1);
//
//            acc1changebtn.setNextFocusUpId(R.id.changebtn1);
//            acc1disconnectbtn.setNextFocusUpId(R.id.disconnectbtn1);
//
//            acc1changebtn.setNextFocusLeftId(R.id.accountmanagement1);
//            acc2changebtn.setNextFocusLeftId(R.id.accountmanagement1);
//            acc3changebtn.setNextFocusLeftId(R.id.accountmanagement1);
//
//            acc1disconnectbtn.setNextFocusRightId(R.id.disconnectbtn1);
//            acc2disconnectbtn.setNextFocusRightId(R.id.disconnectbtn2);
//            acc3disconnectbtn.setNextFocusRightId(R.id.disconnectbtn3);
//
//            logoutbtn.setNextFocusDownId(R.id.logoutbtn);
//            addaccountbtn.setNextFocusDownId(R.id.addaccountbtn);
//
//            Layout4.addView(Layout4_1);
//            Layout4.addView(Layout4_2);
//            Layout4.addView(Layout4_3);
//            Layout4.addView(Layout4_7);
//
//            Layout1.addView(Layout3);
//
//            Layout1.addView(Layout4);
//
//            setContentView(Layout1);
//
//            Home.setNextFocusRightId(R.id.accountmanagement1);
//            Search.setNextFocusRightId(R.id.accountmanagement1);
//            User.setNextFocusRightId(R.id.accountmanagement1);
//            Home.setNextFocusUpId(R.id.accountmanagementuser);
//            User.setNextFocusDownId(R.id.accountmanagementhome);
////        Profile[0].setNextFocusLeftId(R.id.accountmanagement1);
////        Profile[0].setNextFocusDownId(R.id.accountmanagementlogout);
////        Profile[0].setNextFocusUpId(R.id.accountmanagementlogout);
////        Profile[1].setNextFocusDownId(R.id.accountmanagementlogout);
////        Profile[1].setNextFocusUpId(R.id.accountmanagementlogout);
////        Profile[2].setNextFocusDownId(R.id.accountmanagementlogout);
////        Profile[2].setNextFocusUpId(R.id.accountmanagementlogout);
////        AccountPlus.setNextFocusUpId(R.id.accountmanagementlogout);
////        TV13.setNextFocusDownId(R.id.accountmanagementprofile1);
////        TV13.setNextFocusUpId(R.id.accountmanagementprofile1);
//            TV1.setNextFocusLeftId(R.id.setting);
//            TV1.setNextFocusUpId(R.id.accountmanagement1);
//            TV2.setNextFocusLeftId(R.id.setting);
//            Setting.setNextFocusRightId(R.id.accountmanagement1);
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
//
//            Setting.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                    if (hasFocus == false) {
//
//                        Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                        TV1.setTextColor(Color.rgb(255, 255, 255));
//
//                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Home.setImageResource(R.drawable.homeselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, HomeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Home.setImageResource(R.drawable.home);
//                                }
//                            }
//                        });
//
//                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SearchActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Search.setImageResource(R.drawable.search);
//                                }
//                            }
//                        });
//
//                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SubscribeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, CartActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, MyActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(066, 066, 066));
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_1.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
////                              finish();
//                                }else {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                        TV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    TV2.setTextColor(Color.rgb(066, 066, 066));
//                                    Layout3_2_1.setBackground(null);
//                                    Layout3_2_2.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SettingActivityLanguagesetting.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                              finish();
//                                }else {
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                    } else {
//                    }
//                }
//            });
//
//            TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                    if (hasFocus == false) {
//
//                        Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                        TV1.setTextColor(Color.rgb(255, 255, 255));
//
//                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Home.setImageResource(R.drawable.homeselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, HomeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Home.setImageResource(R.drawable.home);
//                                }
//                            }
//                        });
//
//                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SearchActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Search.setImageResource(R.drawable.search);
//                                }
//                            }
//                        });
//
//                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SubscribeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, CartActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, MyActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        TV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    TV2.setTextColor(Color.rgb(066, 066, 066));
//                                    Layout3_2_1.setBackground(null);
//                                    Layout3_2_2.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SettingActivityLanguagesetting.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                              finish();
//                                }else {
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                    } else {
//                        TV1.setTextColor(Color.rgb(066, 066, 066));
//                        Layout3_2_1.setBackgroundColor(Color.rgb(255, 255, 255));
//                    }
//                }
//            });
//
//            logoutbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    SharedPreferences.Editor editor = prf.edit();
//                    editor.clear();
//                    editor.commit();
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, LoadingActivity.class);
//                    intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//
//            addaccountbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (userinfo.size() == 18 && userinfouid.size() == 3) {
//                        builder.setTitle(getResources().getString(R.string.alertdialog_maxaccount));
//
//                        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int id) {
//
//                            }
//                        });
//
//                        AlertDialog alertDialog = builder.create();
//                        alertDialog.show();
//                    } else {
//                        Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountAdd.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                        startActivity(intent);
////                finish();
//                    }
//                }
//            });
//
//            acc1changebtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    settingactivityuseraccountmanagementaccountchange1handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            NetworkTaskUsersChange1 networktaskuserschange1 = new NetworkTaskUsersChange1(api_tvott_users, null);
//                            networktaskuserschange1.execute();
//                        }
//                    });
////                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange1.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
////                startActivity(intent);
//////                finish();
//                }
//            });
//
//            acc1disconnectbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountDisconnect1.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
////                finish();
//                }
//            });
//
//            acc2changebtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    settingactivityuseraccountmanagementaccountchange2handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            NetworkTaskUsersChange2 networktaskuserschange2 = new NetworkTaskUsersChange2(api_tvott_users, null);
//                            networktaskuserschange2.execute();
//                        }
//                    });
////                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange2.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
////                startActivity(intent);
//////                finish();
//                }
//            });
//
//            acc2disconnectbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountDisconnect2.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
////                finish();
//                }
//            });
//
//            acc3changebtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    settingactivityuseraccountmanagementaccountchange3handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            NetworkTaskUsersChange3 networktaskuserschange3 = new NetworkTaskUsersChange3(api_tvott_users, null);
//                            networktaskuserschange3.execute();
//                        }
//                    });
////                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange3.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
////                startActivity(intent);
//////                finish();
//                }
//            });
//
//            acc3disconnectbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountDisconnect3.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
////                finish();
//                }
//            });
//
//        }
//        // 비회원 확인용
//        else if (prf.getString("userinfo_name", "").equals("empty")
//                && prf.getString("userinfo_picture", "").equals("empty")
//                && prf.getInt("user_id", 0) == 0)
//        {
//
//            settinguseraccountmanagementapiload = -1;
//
//            user_cate = new ArrayList<>();
//            user_cate.add(getResources().getString(R.string.account_management));
//            user_cate.add(getResources().getString(R.string.language_setting));
//
//            LinearLayout Layout1 = new LinearLayout(this);
//            LinearLayout Layout2 = new LinearLayout(this);
//            LinearLayout Layout2_1 = new LinearLayout(this);
//            LinearLayout Layout2_2 = new LinearLayout(this);
//            LinearLayout Layout2_1_1 = new LinearLayout(this);
//            LinearLayout Layout2_1_2 = new LinearLayout(this);
//            LinearLayout Layout2_1_3 = new LinearLayout(this);
//            LinearLayout Layout2_1_4 = new LinearLayout(this);
//            LinearLayout Layout2_1_5 = new LinearLayout(this);
//            LinearLayout Layout2_2_1 = new LinearLayout(this);
//            LinearLayout Layout3 = new LinearLayout(this);
//            LinearLayout Layout4 = new LinearLayout(this);
//
//            Layout1.setOrientation(LinearLayout.HORIZONTAL);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            Layout1.setLayoutParams(params);
//
//            ImageView Home = new ImageView(this);
//            Home.setFocusableInTouchMode(true);
//            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Search = new ImageView(this);
//            Search.setFocusableInTouchMode(true);
//            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView User = new ImageView(this);
//            User.setFocusableInTouchMode(true);
//            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Cart = new ImageView(this);
//            Cart.setFocusableInTouchMode(true);
//            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
//            CircleImageView My = new CircleImageView(this);
//            My.setFocusableInTouchMode(true);
//            My.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
//            ImageView Setting = new ImageView(this);
//            Setting.setFocusableInTouchMode(true);
//            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
//            Cart.setPadding(15,15,15,15);
//            CircleImageView Profile[] = new CircleImageView[4];
//            Profile[0] = new CircleImageView(this);
//            Profile[1] = new CircleImageView(this);
//            Profile[2] = new CircleImageView(this);
//            Profile[3] = new CircleImageView(this);
//            ImageView AccountPlus = new ImageView(this);
//            Home.setPadding(15, 15, 15, 15);
//            User.setPadding(15, 15, 15, 15);
//            Search.setPadding(15, 15, 15, 15);
//            My.setPadding(15,15,15,15);
//            Setting.setPadding(15,15,15,15);
//            TextView name[] = new TextView[4];
//            name[0] = new TextView(this);
//            name[1] = new TextView(this);
//            name[2] = new TextView(this);
//            name[3] = new TextView(this);
//            Profile[0].setId(R.id.accountmanagementprofile1);
//            Profile[1].setId(R.id.accountmanagementprofile2);
//            Profile[2].setId(R.id.accountmanagementprofile3);
//            AccountPlus.setId(R.id.accountmanagementprofile4);
//
//            try {
//                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(Profile[3]);
//                name[3].setText(prf.getString("userinfo_name", ""));
//            } catch (Exception e) {
//
//            }
//
//            Home.setImageResource(R.drawable.home);
//            Search.setImageResource(R.drawable.search);
//            User.setImageResource(R.drawable.user);
//            AccountPlus.setImageResource(R.drawable.accountplus);
//            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Cart.setId(R.id.accountmanagementcart);
//            Cart.setImageResource(R.drawable.cart);
//            Cart.setLayoutParams(new ViewGroup.LayoutParams(60,60));
//            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            My.setLayoutParams(new ViewGroup.LayoutParams(80,80));
//            My.setId(R.id.my);
//            if (prf.getString("userinfo_picture", "").equals("empty")) {
//                My.setImageResource(R.drawable.noimg_profile);
//            } else {
//                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(My);
//            }
//            Setting.setImageResource(R.drawable.setting);
//            Setting.setLayoutParams(new ViewGroup.LayoutParams(60,60));
//            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Profile[3].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[3].setPadding(20, 20, 20, 20);
//            Profile[0].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[1].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[2].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            AccountPlus.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            AccountPlus.setScaleType(ImageView.ScaleType.FIT_CENTER);
//
//            Profile[0].setPadding(4, 4, 4, 4);
//            Profile[1].setPadding(4, 4, 4, 4);
//            Profile[2].setPadding(4, 4, 4, 4);
//            AccountPlus.setPadding(4, 4, 4, 4);
//
//            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
//            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
//            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
//            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            LinearLayout.LayoutParams params3f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params3ff = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.1f);
//            LinearLayout.LayoutParams params3_1f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.3f);
//            LinearLayout.LayoutParams params3_2f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
//            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//
//            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3_9 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());
//
//            margin.setMargins(10, 20, 5, 20);
//            margin2.setMargins(10, 20, 5, 20);
//            margin3.setMargins(10, 20, 5, 20);
//            margin3_9.setMargins(10, 20, 5, 20);
//            margin5.setMargins(0,20,5, 20);
//            margin6.setMargins(10,20,20, 20);
//
//            Layout2.setOrientation(LinearLayout.VERTICAL);
//            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
//            Layout2.setLayoutParams(params2);
//            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
//            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
//            Layout4.setBackgroundColor(Color.rgb(29, 29, 29));
//
//            Layout2_1.setLayoutParams(params2_1);
//
//            Layout2_2.setLayoutParams(params2_1);
//            Layout2_2.setGravity(Gravity.BOTTOM);
//
//            Layout2_1_1.setLayoutParams(params2_2);
//            Layout2_1_1.setLayoutParams(margin);
//            Layout2_1_2.setLayoutParams(params2_2);
//            Layout2_1_2.setLayoutParams(margin2);
//            Layout2_1_3.setLayoutParams(params2_2);
//            Layout2_1_3.setLayoutParams(margin3);
//            Layout2_1_4.setLayoutParams(params2_2);
//            Layout2_1_4.setLayoutParams(margin3_9);
//            Layout2_1_5.setLayoutParams(params2_2);
//            Layout2_1_5.setLayoutParams(margin5);
//
//            Layout2_2_1.setLayoutParams(params2_2);
//            Layout2_2_1.setLayoutParams(margin6);
//
//            Layout3.setOrientation(LinearLayout.VERTICAL);
//            Layout3.setGravity(Gravity.CENTER);
//
//            Layout3.setLayoutParams(params3);
//
//            LinearLayout Layout3_2 = new LinearLayout(this);
//            LinearLayout Layout3_2_1 = new LinearLayout(this);
//            LinearLayout Layout3_2_2 = new LinearLayout(this);
//
//            Layout3_2_1.setLayoutParams(params3_1);
//            Layout3_2_2.setLayoutParams(params3_1);
//
//            Layout3_2.setOrientation(LinearLayout.VERTICAL);
//            Layout3_2.setGravity(Gravity.BOTTOM | Gravity.LEFT);
//
//            TV1 = new TextView(this);
//            TextView TV2 = new TextView(this);
//
//            Home.setId(R.id.accountmanagementhome);
//            Search.setId(R.id.accountmanagementsearch);
//            User.setId(R.id.accountmanagementuser);
//            Setting.setId(R.id.setting);
//            TV1.setId(R.id.accountmanagement1);
//            TV2.setId(R.id.accountmanagement2);
//            Setting.setNextFocusUpId(R.id.my);
//
//            TV1.setFocusableInTouchMode(true);
//            TV2.setFocusableInTouchMode(true);
//
//            TV1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
//            TV2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
//
//            TV1.setText(user_cate.get(0));
//            TV2.setText(user_cate.get(1));
//
//            name[0].setTextColor(Color.rgb(255, 255, 255));
//            name[1].setTextColor(Color.rgb(255, 255, 255));
//            name[2].setTextColor(Color.rgb(255, 255, 255));
//            name[3].setTextColor(Color.rgb(255, 255, 255));
//
//            name[0].setTextSize(20);
//            name[1].setTextSize(20);
//            name[2].setTextSize(20);
//            name[3].setTextSize(20);
//
//            TV1.setTextColor(Color.rgb(255, 255, 255));
//            TV2.setTextColor(Color.rgb(255, 255, 255));
//
//            TV1.setPadding(40, 21, 10, 21);
//            TV2.setPadding(40, 21, 10, 21);
//
//            Layout3_2_1.addView(TV1);
//            Layout3_2_2.addView(TV2);
//
//            ViewGroup.MarginLayoutParams margin3_1 = new ViewGroup.MarginLayoutParams(TV1.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3_2 = new ViewGroup.MarginLayoutParams(TV2.getLayoutParams());
//
//            margin3_1.setMargins(30, 22, 0, 0);
//            margin3_2.setMargins(30, 22, 0, 0);
//
//
//            Layout3_2.setLayoutParams(params3f);
//
//            Layout3.addView(Layout3_2);
//            Layout3_2.addView(Layout3_2_1);
//            Layout3_2.addView(Layout3_2_2);
//
//            Layout4.setOrientation(LinearLayout.VERTICAL);
//            Layout4.setGravity(Gravity.CENTER);
//
//            Layout4.setLayoutParams(params4);
//
//            TextView TV10 = new TextView(this);
//            TextView TV11 = new TextView(this);
//            Button button = new Button(this);
//
//            TV10.setText(getResources().getString(R.string.nousersettingaccountmanagementmaintitle));
//            TV10.setTextColor(Color.parseColor("#FFFFFF"));
//            TV10.setTextSize(35);
//            TV10.setGravity(Gravity.CENTER);
//            TV11.setText(getResources().getString(R.string.nousersettingaccountmanagementsubtitle));
//            TV11.setTextColor(Color.parseColor("#b0b0b0"));
//            TV11.setTextSize(18);
//            TV11.setGravity(Gravity.CENTER);
//            TV11.setPadding(0,30,0,100);
//            button.setText(getResources().getString(R.string.login));
//            button.setTextColor(Color.parseColor("#FFFFFF"));
//            button.setTextSize(10);
//            button.setBackground(ContextCompat.getDrawable(this,R.drawable.blackbuttonsetting));
//            button.setLayoutParams(new ViewGroup.LayoutParams(600,65));
//
//            Layout4.addView(TV10);
//            Layout4.addView(TV11);
//            Layout4.addView(button);
//
//            Setting.requestFocus();
//
//            Layout1.addView(Layout2);
//
//            Layout2_1.addView(Layout2_1_1);
//            Layout2_1.addView(Layout2_1_2);
//            Layout2_1.addView(Layout2_1_3);
//            Layout2_1.addView(Layout2_1_4);
//            Layout2_1.addView(Layout2_1_5);
//
//            Layout2_1_1.addView(Home);
//            Layout2_1_2.addView(Search);
//            Layout2_1_3.addView(User);
//            Layout2_1_4.addView(Cart);
//            Layout2_1_5.addView(My);
//            Layout2_2_1.addView(Setting);
//
//            Layout2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout2_2.setOrientation(LinearLayout.VERTICAL);
//
//            Layout2_2.addView(Layout2_2_1);
//
//            Layout2.addView(Layout2_1);
//            Layout2.addView(Layout2_2);
//
//            Layout1.addView(Layout3);
//
//            Layout1.addView(Layout4);
//
//            setContentView(Layout1);
//
//            Home.setNextFocusRightId(R.id.accountmanagement1);
//            Search.setNextFocusRightId(R.id.accountmanagement1);
//            User.setNextFocusRightId(R.id.accountmanagement1);
//            Home.setNextFocusUpId(R.id.accountmanagementuser);
//            User.setNextFocusDownId(R.id.accountmanagementhome);
//
//            TV1.setNextFocusLeftId(R.id.setting);
//            TV1.setNextFocusUpId(R.id.accountmanagement1);
//            TV2.setNextFocusLeftId(R.id.setting);
//            Setting.setNextFocusRightId(R.id.accountmanagement1);
//
//            button.setId(R.id.buttonlayout);
//            button.setNextFocusUpId(R.id.buttonlayout);
//            button.setNextFocusRightId(R.id.buttonlayout);
//            button.setNextFocusDownId(R.id.buttonlayout);
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
//
//            Setting.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                    if (hasFocus == false) {
//
//                        Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                        TV1.setTextColor(Color.rgb(255, 255, 255));
//
//                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Home.setImageResource(R.drawable.homeselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, HomeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Home.setImageResource(R.drawable.home);
//                                }
//                            }
//                        });
//
//                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SearchActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Search.setImageResource(R.drawable.search);
//                                }
//                            }
//                        });
//
//                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SubscribeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, CartActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, MyActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(066, 066, 066));
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_1.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
////                              finish();
//                                }else {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                        TV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    TV2.setTextColor(Color.rgb(066, 066, 066));
//                                    Layout3_2_1.setBackground(null);
//                                    Layout3_2_2.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SettingActivityLanguagesetting.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                              finish();
//                                }else {
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                    } else {
//                    }
//                }
//            });
//
//            TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                    if (hasFocus == false) {
//
//                        Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                        TV1.setTextColor(Color.rgb(255, 255, 255));
//
//                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Home.setImageResource(R.drawable.homeselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, HomeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Home.setImageResource(R.drawable.home);
//                                }
//                            }
//                        });
//
//                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SearchActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Search.setImageResource(R.drawable.search);
//                                }
//                            }
//                        });
//
//                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SubscribeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, CartActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, MyActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        TV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    TV2.setTextColor(Color.rgb(066, 066, 066));
//                                    Layout3_2_1.setBackground(null);
//                                    Layout3_2_2.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SettingActivityLanguagesetting.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                              finish();
//                                }else {
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                    } else {
//                        TV1.setTextColor(Color.rgb(066, 066, 066));
//                        Layout3_2_1.setBackgroundColor(Color.rgb(255, 255, 255));
//                    }
//                }
//            });
//
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, InfoCheck.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
////                    finish();
//                }
//            });
//
//        } else {
//
//            // 정상
//
//            settingactivityuseraccountmanagementaccountchange1handler = new SettingActivityUserAccountmanagementAccountChange1Handler();
//            settingactivityuseraccountmanagementaccountchange2handler = new SettingActivityUserAccountmanagementAccountChange2Handler();
//            settingactivityuseraccountmanagementaccountchange3handler = new SettingActivityUserAccountmanagementAccountChange3Handler();
//
//            user_cate = new ArrayList<>();
//            user_cate.add(getResources().getString(R.string.account_management));
//            user_cate.add(getResources().getString(R.string.language_setting));
//
//
//            LinearLayout Layout1 = new LinearLayout(this);
//            LinearLayout Layout2 = new LinearLayout(this);
//            LinearLayout Layout2_1 = new LinearLayout(this);
//            LinearLayout Layout2_2 = new LinearLayout(this);
//            LinearLayout Layout2_1_1 = new LinearLayout(this);
//            LinearLayout Layout2_1_2 = new LinearLayout(this);
//            LinearLayout Layout2_1_3 = new LinearLayout(this);
//            LinearLayout Layout2_1_4 = new LinearLayout(this);
//            LinearLayout Layout2_1_5 = new LinearLayout(this);
//            LinearLayout Layout2_2_1 = new LinearLayout(this);
//            LinearLayout Layout3 = new LinearLayout(this);
//            LinearLayout Layout4 = new LinearLayout(this);
//
//            Layout1.setOrientation(LinearLayout.HORIZONTAL);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            Layout1.setLayoutParams(params);
//
//            ImageView Home = new ImageView(this);
//            Home.setFocusableInTouchMode(true);
//            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Search = new ImageView(this);
//            Search.setFocusableInTouchMode(true);
//            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView User = new ImageView(this);
//            User.setFocusableInTouchMode(true);
//            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Cart = new ImageView(this);
//            Cart.setFocusableInTouchMode(true);
//            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            CircleImageView My = new CircleImageView(this);
//            My.setFocusableInTouchMode(true);
//            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            ImageView Setting = new ImageView(this);
//            Setting.setFocusableInTouchMode(true);
//            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//            Cart.setPadding(15, 15, 15, 15);
//            CircleImageView Profile[] = new CircleImageView[4];
//            Profile[0] = new CircleImageView(this);
//            Profile[1] = new CircleImageView(this);
//            Profile[2] = new CircleImageView(this);
//            Profile[3] = new CircleImageView(this);
//            ImageView AccountPlus = new ImageView(this);
//            Home.setPadding(15, 15, 15, 15);
//            User.setPadding(15, 15, 15, 15);
//            Search.setPadding(15, 15, 15, 15);
//            My.setPadding(15, 15, 15, 15);
//            Setting.setPadding(15, 15, 15, 15);
//            TextView name[] = new TextView[4];
//            name[0] = new TextView(this);
//            name[1] = new TextView(this);
//            name[2] = new TextView(this);
//            name[3] = new TextView(this);
//            Profile[0].setId(R.id.accountmanagementprofile1);
//            Profile[1].setId(R.id.accountmanagementprofile2);
//            Profile[2].setId(R.id.accountmanagementprofile3);
//            AccountPlus.setId(R.id.accountmanagementprofile4);
//
//            try {
//                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(Profile[3]);
//                name[3].setText(prf.getString("userinfo_name", ""));
//            } catch (Exception e) {
//
//            }
//
//            Home.setImageResource(R.drawable.home);
//            Search.setImageResource(R.drawable.search);
//            User.setImageResource(R.drawable.user);
//            AccountPlus.setImageResource(R.drawable.accountplus);
//            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Cart.setId(R.id.accountmanagementcart);
//            Cart.setImageResource(R.drawable.cart);
//            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));
//            My.setId(R.id.my);
//            if (prf.getString("userinfo_picture", "").equals("empty")) {
//                My.setImageResource(R.drawable.noimg_profile);
//            } else {
//                Glide.with(this).load(prf.getString("userinfo_picture", "")).into(My);
//            }
//            Setting.setImageResource(R.drawable.setting);
//            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
//            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            Profile[3].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[3].setPadding(20, 20, 20, 20);
//            Profile[0].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[1].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            Profile[2].setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            AccountPlus.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            AccountPlus.setScaleType(ImageView.ScaleType.FIT_CENTER);
//
//            Profile[0].setPadding(4, 4, 4, 4);
//            Profile[1].setPadding(4, 4, 4, 4);
//            Profile[2].setPadding(4, 4, 4, 4);
//            AccountPlus.setPadding(4, 4, 4, 4);
//
//            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
//            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
//            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
//            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            LinearLayout.LayoutParams params3f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params3ff = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.1f);
//            LinearLayout.LayoutParams params3_1f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.3f);
//            LinearLayout.LayoutParams params3_2f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
//            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//
//            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3_9 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());
//
//            margin.setMargins(10, 20, 5, 20);
//            margin2.setMargins(10, 20, 5, 20);
//            margin3.setMargins(10, 20, 5, 20);
//            margin3_9.setMargins(10, 20, 5, 20);
//            margin5.setMargins(0, 20, 5, 20);
//            margin6.setMargins(10, 20, 20, 20);
//
//            Layout2.setOrientation(LinearLayout.VERTICAL);
//            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
//            Layout2.setLayoutParams(params2);
//            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
//            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
//            Layout4.setBackgroundColor(Color.rgb(29, 29, 29));
//
//            Layout2_1.setLayoutParams(params2_1);
//
//            Layout2_2.setLayoutParams(params2_1);
//            Layout2_2.setGravity(Gravity.BOTTOM);
//
//            Layout2_1_1.setLayoutParams(params2_2);
//            Layout2_1_1.setLayoutParams(margin);
//            Layout2_1_2.setLayoutParams(params2_2);
//            Layout2_1_2.setLayoutParams(margin2);
//            Layout2_1_3.setLayoutParams(params2_2);
//            Layout2_1_3.setLayoutParams(margin3);
//            Layout2_1_4.setLayoutParams(params2_2);
//            Layout2_1_4.setLayoutParams(margin3_9);
//            Layout2_1_5.setLayoutParams(params2_2);
//            Layout2_1_5.setLayoutParams(margin5);
//
//            Layout2_2_1.setLayoutParams(params2_2);
//            Layout2_2_1.setLayoutParams(margin6);
//
//            Layout3.setOrientation(LinearLayout.VERTICAL);
//            Layout3.setGravity(Gravity.CENTER);
//
//            Layout3.setLayoutParams(params3);
//
//            LinearLayout Layout3_2 = new LinearLayout(this);
//            LinearLayout Layout3_2_1 = new LinearLayout(this);
//            LinearLayout Layout3_2_2 = new LinearLayout(this);
//
//            Layout3_2_1.setLayoutParams(params3_1);
//            Layout3_2_2.setLayoutParams(params3_1);
//
//            Layout3_2.setOrientation(LinearLayout.VERTICAL);
//            Layout3_2.setGravity(Gravity.BOTTOM | Gravity.LEFT);
//
//            TV1 = new TextView(this);
//            TextView TV2 = new TextView(this);
//
//            Home.setId(R.id.accountmanagementhome);
//            Search.setId(R.id.accountmanagementsearch);
//            User.setId(R.id.accountmanagementuser);
//            Setting.setId(R.id.setting);
//            TV1.setId(R.id.accountmanagement1);
//            TV2.setId(R.id.accountmanagement2);
//            Setting.setNextFocusUpId(R.id.my);
//
//            TV1.setFocusableInTouchMode(true);
//            TV2.setFocusableInTouchMode(true);
//
//            TV1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
//            TV2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
//
//            TV1.setText(user_cate.get(0));
//            TV2.setText(user_cate.get(1));
//
//            name[0].setTextColor(Color.rgb(255, 255, 255));
//            name[1].setTextColor(Color.rgb(255, 255, 255));
//            name[2].setTextColor(Color.rgb(255, 255, 255));
//            name[3].setTextColor(Color.rgb(255, 255, 255));
//
//            name[0].setTextSize(20);
//            name[1].setTextSize(20);
//            name[2].setTextSize(20);
//            name[3].setTextSize(20);
//
//            TV1.setTextColor(Color.rgb(255, 255, 255));
//            TV2.setTextColor(Color.rgb(255, 255, 255));
//
//            TV1.setPadding(40, 21, 10, 21);
//            TV2.setPadding(40, 21, 10, 21);
//
//            Layout3_2_1.addView(TV1);
//            Layout3_2_2.addView(TV2);
//
//            ViewGroup.MarginLayoutParams margin3_1 = new ViewGroup.MarginLayoutParams(TV1.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin3_2 = new ViewGroup.MarginLayoutParams(TV2.getLayoutParams());
//
//            margin3_1.setMargins(30, 22, 0, 0);
//            margin3_2.setMargins(30, 22, 0, 0);
//
//
//            Layout3_2.setLayoutParams(params3f);
//
//            Layout3.addView(Layout3_2);
//            Layout3_2.addView(Layout3_2_1);
//            Layout3_2.addView(Layout3_2_2);
//
//            Layout4.setOrientation(LinearLayout.VERTICAL);
//            Layout4.setGravity(Gravity.LEFT);
//
//            Layout4.setLayoutParams(params4);
//
//            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.4f);
//            LinearLayout.LayoutParams params4_4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.2f);
//            LinearLayout.LayoutParams params4_4_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
//            LinearLayout.LayoutParams params4_4_2_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_4_2_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.25f);
//            LinearLayout.LayoutParams params4_7 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_7_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//            LinearLayout.LayoutParams params4_7_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
//
//            params4_4_2_1.bottomMargin = 10;
//            params4_4_2_2.topMargin = 22;
//            params4_7_1.rightMargin = 10;
//            params4_7_2.leftMargin = 10;
//
//            LinearLayout Layout4_1 = new LinearLayout(this);
//            LinearLayout Layout4_2 = new LinearLayout(this);
//            LinearLayout Layout4_3 = new LinearLayout(this);
//            LinearLayout Layout4_4 = new LinearLayout(this);
//            LinearLayout Layout4_4_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_2 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_2_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_5 = new LinearLayout(this);
//            LinearLayout Layout4_5_1 = new LinearLayout(this);
//            LinearLayout Layout4_5_2 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_5_2_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_6 = new LinearLayout(this);
//            LinearLayout Layout4_6_1 = new LinearLayout(this);
//            LinearLayout Layout4_6_2 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_2_1 = new LinearLayout(this);
//            LinearLayout Layout4_6_2_2_2 = new LinearLayout(this);
//            LinearLayout Layout4_4_4 = new LinearLayout(this);
//            LinearLayout Layout4_4_4_1 = new LinearLayout(this);
//            LinearLayout Layout4_4_4_2 = new LinearLayout(this);
//            LinearLayout Layout4_7 = new LinearLayout(this);
//            LinearLayout Layout4_7_1 = new LinearLayout(this);
//            LinearLayout Layout4_7_2 = new LinearLayout(this);
//
////        LinearLayout Layout4_1 = new LinearLayout(this);
////        LinearLayout Layout4_2 = new LinearLayout(this);
////        LinearLayout Layout4_4 = new LinearLayout(this);
////        LinearLayout Layout4_4_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_1_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_1_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_2_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_2_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_3 = new LinearLayout(this);
////        LinearLayout Layout4_4_3_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_3_2 = new LinearLayout(this);
////        LinearLayout Layout4_4_4 = new LinearLayout(this);
////        LinearLayout Layout4_4_4_1 = new LinearLayout(this);
////        LinearLayout Layout4_4_4_2 = new LinearLayout(this);
////        LinearLayout Layout4_7 = new LinearLayout(this);
////        LinearLayout Layout4_7_1 = new LinearLayout(this);
////        LinearLayout Layout4_7_2 = new LinearLayout(this);
//
//            Layout4_1.setGravity(Gravity.LEFT);
//            Layout4_2.setGravity(Gravity.LEFT);
//            Layout4_3.setGravity(Gravity.CENTER);
//            Layout4_4.setGravity(Gravity.LEFT | Gravity.CENTER);
//            Layout4_4_1.setGravity(Gravity.CENTER);
//            Layout4_4_2.setGravity(Gravity.CENTER);
//            Layout4_4_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//            Layout4_4_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
//            Layout4_4_2_2_1.setGravity(Gravity.LEFT);
//            Layout4_4_2_2_2.setGravity(Gravity.LEFT);
//            Layout4_5.setGravity(Gravity.LEFT | Gravity.CENTER);
//            Layout4_5_1.setGravity(Gravity.CENTER);
//            Layout4_5_2.setGravity(Gravity.CENTER);
//            Layout4_5_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//            Layout4_5_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
//            Layout4_5_2_2_1.setGravity(Gravity.LEFT);
//            Layout4_5_2_2_2.setGravity(Gravity.LEFT);
//            Layout4_6.setGravity(Gravity.LEFT | Gravity.CENTER);
//            Layout4_6_1.setGravity(Gravity.CENTER);
//            Layout4_6_2.setGravity(Gravity.CENTER);
//            Layout4_6_2_1.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//            Layout4_6_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
//            Layout4_6_2_2_1.setGravity(Gravity.LEFT);
//            Layout4_6_2_2_2.setGravity(Gravity.LEFT);
//            Layout4_4_4.setGravity(Gravity.CENTER);
//            Layout4_4_4_1.setGravity(Gravity.CENTER);
//            Layout4_4_4_2.setGravity(Gravity.CENTER);
//            Layout4_7.setGravity(Gravity.CENTER);
//            Layout4_7_1.setGravity(Gravity.RIGHT);
//            Layout4_7_2.setGravity(Gravity.LEFT);
//
//            Layout4_3.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_7.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_4_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4_2.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4_2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_4_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_4_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_4_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_5_2.setOrientation(LinearLayout.VERTICAL);
//            Layout4_5_2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_5_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_5_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_6_2.setOrientation(LinearLayout.VERTICAL);
//            Layout4_6_2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout4_6_2_2.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6_2_2_1.setOrientation(LinearLayout.HORIZONTAL);
//            Layout4_6_2_2_2.setOrientation(LinearLayout.HORIZONTAL);
//
//            TextView TV10 = new TextView(this);
//            TextView TV11 = new TextView(this);
//            TextView TV12 = new TextView(this);
//            TextView TV13 = new TextView(this);
//            TV13.setId(R.id.accountmanagementlogout);
//
//            TV10.setTextSize(30);
//            TV10.setTypeface(null, Typeface.BOLD);
//            TV11.setTextSize(15);
//            TV13.setTextSize(15);
//
//            TV13.setFocusableInTouchMode(true);
//
//            TV10.setText(getResources().getString(R.string.selectaccount));
//            TV11.setText(getResources().getString(R.string.accountmax));
//            TV12.setText(getResources().getString(R.string.addaccount));
//            TV13.setText(getResources().getString(R.string.logout));
//
//            TV10.setTextColor(Color.rgb(255, 255, 255));
//            TV11.setTextColor(Color.rgb(255, 255, 255));
//            TV12.setTextColor(Color.rgb(255, 255, 255));
//            TV13.setTextColor(Color.rgb(102, 102, 102));
//
//            TV12.setTextSize(10);
//
//            TV10.setPadding(10, 10, 10, 10);
//            TV11.setPadding(10, 10, 10, 10);
//
//            TV11.setGravity(Gravity.CENTER);
//
//            addaccountbtn = new Button(this);
//            logoutbtn = new Button(this);
//            acc1changebtn = new Button(this);
//            acc1disconnectbtn = new Button(this);
//            acc2changebtn = new Button(this);
//            acc2disconnectbtn = new Button(this);
//            acc3changebtn = new Button(this);
//            acc3disconnectbtn = new Button(this);
//
//            addaccountbtn.setTextColor(Color.rgb(255, 255, 255));
//            logoutbtn.setTextColor(Color.rgb(255, 255, 255));
//            acc1changebtn.setTextColor(Color.rgb(255, 255, 255));
//            acc1disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
//            acc2changebtn.setTextColor(Color.rgb(255, 255, 255));
//            acc2disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
//            acc3changebtn.setTextColor(Color.rgb(255, 255, 255));
//            acc3disconnectbtn.setTextColor(Color.rgb(255, 255, 255));
//
//            addaccountbtn.setTextSize(10);
//            logoutbtn.setTextSize(10);
//            acc1changebtn.setTextSize(10);
//            acc1disconnectbtn.setTextSize(10);
//            acc2changebtn.setTextSize(10);
//            acc2disconnectbtn.setTextSize(10);
//            acc3changebtn.setTextSize(10);
//            acc3disconnectbtn.setTextSize(10);
//
//            addaccountbtn.setText(getResources().getString(R.string.addaccount));
//            logoutbtn.setText(getResources().getString(R.string.logout));
//            acc1changebtn.setText(getResources().getString(R.string.change));
//            acc1disconnectbtn.setText(getResources().getString(R.string.disconnect));
//            acc2changebtn.setText(getResources().getString(R.string.change));
//            acc2disconnectbtn.setText(getResources().getString(R.string.disconnect));
//            acc3changebtn.setText(getResources().getString(R.string.change));
//            acc3disconnectbtn.setText(getResources().getString(R.string.disconnect));
//
//            addaccountbtn.setId(R.id.addaccountbtn);
//            logoutbtn.setId(R.id.logoutbtn);
//            acc1changebtn.setId(R.id.changebtn1);
//            acc1disconnectbtn.setId(R.id.disconnectbtn1);
//            acc2changebtn.setId(R.id.changebtn2);
//            acc2disconnectbtn.setId(R.id.disconnectbtn2);
//            acc3changebtn.setId(R.id.changebtn3);
//            acc3disconnectbtn.setId(R.id.disconnectbtn3);
//
//            addaccountbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            logoutbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc1changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc1disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc2changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc2disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc3changebtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//            acc3disconnectbtn.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
//
//            addaccountbtn.setLayoutParams(new ViewGroup.LayoutParams(600, 65));
//            logoutbtn.setLayoutParams(new ViewGroup.LayoutParams(600, 65));
//            acc1changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc1disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc2changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc2disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc3changebtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//            acc3disconnectbtn.setLayoutParams(new ViewGroup.LayoutParams(190, 65));
//
//            Layout4_1.addView(TV10);
//            Layout4_2.addView(TV11);
//
//            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
//            ViewGroup.MarginLayoutParams margin4_1 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
//
//            margin4.setMargins(0, 0, 0, 80);
//            margin4_1.setMargins(0, 100, 0, 0);
//
//            Layout4_1.setLayoutParams(params4_1);
//            Layout4_2.setLayoutParams(params4_1);
////        Layout4_2.setLayoutParams(margin4);
//            Layout4_3.setLayoutParams(params4_3);
//            Layout4_4.setLayoutParams(params4_4);
//            Layout4_5.setLayoutParams(params4_4);
//            Layout4_6.setLayoutParams(params4_4);
//            Layout4_4_1.setLayoutParams(params4_4_1);
//            Layout4_5_1.setLayoutParams(params4_4_1);
//            Layout4_6_1.setLayoutParams(params4_4_1);
//            Layout4_4_2.setLayoutParams(params4_4_2);
//            Layout4_5_2.setLayoutParams(params4_4_2);
//            Layout4_6_2.setLayoutParams(params4_4_2);
//            Layout4_4_2_1.setLayoutParams(params4_4_2_1);
//            Layout4_5_2_1.setLayoutParams(params4_4_2_1);
//            Layout4_6_2_1.setLayoutParams(params4_4_2_1);
//            Layout4_4_2_2.setLayoutParams(params4_4_2_2);
//            Layout4_5_2_2.setLayoutParams(params4_4_2_2);
//            Layout4_6_2_2.setLayoutParams(params4_4_2_2);
//            Layout4_4_2_2_1.setLayoutParams(params4_4_2_2_1);
//            Layout4_5_2_2_1.setLayoutParams(params4_4_2_2_1);
//            Layout4_6_2_2_1.setLayoutParams(params4_4_2_2_1);
//            Layout4_4_2_2_2.setLayoutParams(params4_4_2_2_2);
//            Layout4_5_2_2_2.setLayoutParams(params4_4_2_2_2);
//            Layout4_6_2_2_2.setLayoutParams(params4_4_2_2_2);
//
//            Layout4_7.setLayoutParams(params4_7);
//            Layout4_7_1.setLayoutParams(params4_7_1);
//            Layout4_7_2.setLayoutParams(params4_7_2);
////        Layout4_5.setLayoutParams(margin4_1);
//
//
//            Setting.requestFocus();
//
//            Layout1.addView(Layout2);
//
//            Layout2_1.addView(Layout2_1_1);
//            Layout2_1.addView(Layout2_1_2);
//            Layout2_1.addView(Layout2_1_3);
//            Layout2_1.addView(Layout2_1_4);
//            Layout2_1.addView(Layout2_1_5);
//
//            Layout2_1_1.addView(Home);
//            Layout2_1_2.addView(Search);
//            Layout2_1_3.addView(User);
//            Layout2_1_4.addView(Cart);
//            Layout2_1_5.addView(My);
//            Layout2_2_1.addView(Setting);
//
//            Layout2_1.setOrientation(LinearLayout.VERTICAL);
//            Layout2_2.setOrientation(LinearLayout.VERTICAL);
//
//            Layout2_2.addView(Layout2_2_1);
//
//            Layout2.addView(Layout2_1);
//            Layout2.addView(Layout2_2);
//            Layout4_7.addView(Layout4_7_1);
//            Layout4_7.addView(Layout4_7_2);
//            Layout4_7_1.addView(addaccountbtn);
//            Layout4_7_2.addView(logoutbtn);
////        Layout4_5.addView(TV13);
//
//            if (userinfo.size() == 18) {
//                try {
//                    Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
//                    name[0].setText(userinfo.get(0));
//                    Glide.with(this).load(userinfo.get(8)).into(Profile[1]);
//                    name[1].setText(userinfo.get(6));
//                    Glide.with(this).load(userinfo.get(14)).into(Profile[2]);
//                    name[2].setText(userinfo.get(12));
//                    Layout4_4.addView(Layout4_4_1);
//                    Layout4_4.addView(Layout4_4_2);
//                    Layout4_4_2.addView(Layout4_4_2_1);
//                    Layout4_4_2.addView(Layout4_4_2_2);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
//                    Layout4_4_1.addView(Profile[0]);
//                    Layout4_4_2_1.addView(name[0]);
//                    Layout4_4_2_2_1.addView(acc1changebtn);
//                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
//
//                    Layout4_5.addView(Layout4_5_1);
//                    Layout4_5.addView(Layout4_5_2);
//                    Layout4_5_2.addView(Layout4_5_2_1);
//                    Layout4_5_2.addView(Layout4_5_2_2);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_1);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_2);
//                    Layout4_5_1.addView(Profile[1]);
//                    Layout4_5_2_1.addView(name[1]);
//                    Layout4_5_2_2_1.addView(acc2changebtn);
//                    Layout4_5_2_2_2.addView(acc2disconnectbtn);
//
//                    Layout4_6.addView(Layout4_6_1);
//                    Layout4_6.addView(Layout4_6_2);
//                    Layout4_6_2.addView(Layout4_6_2_1);
//                    Layout4_6_2.addView(Layout4_6_2_2);
//                    Layout4_6_2_2.addView(Layout4_6_2_2_1);
//                    Layout4_6_2_2.addView(Layout4_6_2_2_2);
//                    Layout4_6_1.addView(Profile[2]);
//                    Layout4_6_2_1.addView(name[2]);
//                    Layout4_6_2_2_1.addView(acc3changebtn);
//                    Layout4_6_2_2_2.addView(acc3disconnectbtn);
//
//                    Layout4_3.addView(Layout4_4);
//                    Layout4_3.addView(Layout4_5);
//                    Layout4_3.addView(Layout4_6);
//
//                    params4_3.topMargin = 20;
//                    params4_3.bottomMargin = 50;
//                } catch (Exception e) {
//
//                }
//            } else if (userinfo.size() == 12) {
//                try {
//                    Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
//                    name[0].setText(userinfo.get(0));
//                    Glide.with(this).load(userinfo.get(8)).into(Profile[1]);
//                    name[1].setText(userinfo.get(6));
//                    Layout4_4.addView(Layout4_4_1);
//                    Layout4_4.addView(Layout4_4_2);
//                    Layout4_4_2.addView(Layout4_4_2_1);
//                    Layout4_4_2.addView(Layout4_4_2_2);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
//                    Layout4_4_1.addView(Profile[0]);
//                    Layout4_4_2_1.addView(name[0]);
//                    Layout4_4_2_2_1.addView(acc1changebtn);
//                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
//                    Layout4_5.addView(Layout4_5_1);
//                    Layout4_5.addView(Layout4_5_2);
//                    Layout4_5_2.addView(Layout4_5_2_1);
//                    Layout4_5_2.addView(Layout4_5_2_2);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_1);
//                    Layout4_5_2_2.addView(Layout4_5_2_2_2);
//                    Layout4_5_1.addView(Profile[1]);
//                    Layout4_5_2_1.addView(name[1]);
//                    Layout4_5_2_2_1.addView(acc2changebtn);
//                    Layout4_5_2_2_2.addView(acc2disconnectbtn);
//                    Layout4_3.addView(Layout4_4);
//                    Layout4_3.addView(Layout4_5);
//                    params4_3.topMargin = 120;
//                    params4_3.bottomMargin = 150;
//                    params4_4_1.topMargin = 2;
//
//                } catch (Exception e) {
//
//                }
//            } else if (userinfo.size() == 6) {
//                try {
//                    Glide.with(this).load(userinfo.get(2)).into(Profile[0]);
//                    name[0].setText(userinfo.get(0));
//                    Layout4_4.addView(Layout4_4_1);
//                    Layout4_4.addView(Layout4_4_2);
//                    Layout4_4_2.addView(Layout4_4_2_1);
//                    Layout4_4_2.addView(Layout4_4_2_2);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_1);
//                    Layout4_4_2_2.addView(Layout4_4_2_2_2);
//                    Layout4_4_1.addView(Profile[0]);
//                    Layout4_4_2_1.addView(name[0]);
//                    Layout4_4_2_2_1.addView(acc1changebtn);
//                    Layout4_4_2_2_2.addView(acc1disconnectbtn);
//                    Layout4_3.addView(Layout4_4);
//                    params4_3.topMargin = 20;
//                    params4_3.bottomMargin = 50;
//                    params4_4_1.bottomMargin = 35;
//                } catch (Exception e) {
//
//                }
//            } else {
//                Layout4_4.addView(Layout4_4_4);
//                Layout4_4_4.addView(Layout4_4_4_1);
//                Layout4_4_4.addView(Layout4_4_4_2);
//            }
//
//            TV1.setNextFocusRightId(R.id.changebtn1);
//
//            acc1changebtn.setNextFocusUpId(R.id.changebtn1);
//            acc1disconnectbtn.setNextFocusUpId(R.id.disconnectbtn1);
//
//            acc1changebtn.setNextFocusLeftId(R.id.accountmanagement1);
//            acc2changebtn.setNextFocusLeftId(R.id.accountmanagement1);
//            acc3changebtn.setNextFocusLeftId(R.id.accountmanagement1);
//
//            acc1disconnectbtn.setNextFocusRightId(R.id.disconnectbtn1);
//            acc2disconnectbtn.setNextFocusRightId(R.id.disconnectbtn2);
//            acc3disconnectbtn.setNextFocusRightId(R.id.disconnectbtn3);
//
//            logoutbtn.setNextFocusDownId(R.id.logoutbtn);
//            addaccountbtn.setNextFocusDownId(R.id.addaccountbtn);
//
//            Layout4.addView(Layout4_1);
//            Layout4.addView(Layout4_2);
//            Layout4.addView(Layout4_3);
//            Layout4.addView(Layout4_7);
//
//            Layout1.addView(Layout3);
//
//            Layout1.addView(Layout4);
//
//            setContentView(Layout1);
//
//            Home.setNextFocusRightId(R.id.accountmanagement1);
//            Search.setNextFocusRightId(R.id.accountmanagement1);
//            User.setNextFocusRightId(R.id.accountmanagement1);
//            Home.setNextFocusUpId(R.id.accountmanagementuser);
//            User.setNextFocusDownId(R.id.accountmanagementhome);
////        Profile[0].setNextFocusLeftId(R.id.accountmanagement1);
////        Profile[0].setNextFocusDownId(R.id.accountmanagementlogout);
////        Profile[0].setNextFocusUpId(R.id.accountmanagementlogout);
////        Profile[1].setNextFocusDownId(R.id.accountmanagementlogout);
////        Profile[1].setNextFocusUpId(R.id.accountmanagementlogout);
////        Profile[2].setNextFocusDownId(R.id.accountmanagementlogout);
////        Profile[2].setNextFocusUpId(R.id.accountmanagementlogout);
////        AccountPlus.setNextFocusUpId(R.id.accountmanagementlogout);
////        TV13.setNextFocusDownId(R.id.accountmanagementprofile1);
////        TV13.setNextFocusUpId(R.id.accountmanagementprofile1);
//            TV1.setNextFocusLeftId(R.id.setting);
//            TV1.setNextFocusUpId(R.id.accountmanagement1);
//            TV2.setNextFocusLeftId(R.id.setting);
//            Setting.setNextFocusRightId(R.id.accountmanagement1);
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
//
//            Setting.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                    if (hasFocus == false) {
//
//                        Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                        TV1.setTextColor(Color.rgb(255, 255, 255));
//
//                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Home.setImageResource(R.drawable.homeselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, HomeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Home.setImageResource(R.drawable.home);
//                                }
//                            }
//                        });
//
//                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SearchActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Search.setImageResource(R.drawable.search);
//                                }
//                            }
//                        });
//
//                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SubscribeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, CartActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, MyActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(066, 066, 066));
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_1.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
////                              finish();
//                                }else {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                        TV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    TV2.setTextColor(Color.rgb(066, 066, 066));
//                                    Layout3_2_1.setBackground(null);
//                                    Layout3_2_2.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SettingActivityLanguagesetting.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                              finish();
//                                }else {
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                    } else {
//                    }
//                }
//            });
//
//            TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                    if (hasFocus == false) {
//
//                        Layout3_2_1.setBackgroundColor(Color.rgb(50,50,50));
//                        TV1.setTextColor(Color.rgb(255, 255, 255));
//
//                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Home.setImageResource(R.drawable.homeselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, HomeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Home.setImageResource(R.drawable.home);
//                                }
//                            }
//                        });
//
//                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SearchActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                    Search.setImageResource(R.drawable.search);
//                                }
//                            }
//                        });
//
//                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SubscribeActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, CartActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
////                                Search.setImageResource(R.drawable.searchselect);
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, MyActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                finish();
//                                }else {
//                                }
//                            }
//                        });
//
//                        TV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
//                                if (hasFocus) {
//                                    TV1.setTextColor(Color.rgb(255, 255, 255));
//                                    TV2.setTextColor(Color.rgb(066, 066, 066));
//                                    Layout3_2_1.setBackground(null);
//                                    Layout3_2_2.setBackgroundColor(Color.rgb(255, 255, 255));
//                                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, SettingActivityLanguagesetting.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
////                              finish();
//                                }else {
//                                    TV2.setTextColor(Color.rgb(255, 255, 255));
//                                    Layout3_2_2.setBackground(null);
//                                }
//                            }
//                        });
//
//                    } else {
//                        TV1.setTextColor(Color.rgb(066, 066, 066));
//                        Layout3_2_1.setBackgroundColor(Color.rgb(255, 255, 255));
//                    }
//                }
//            });
//
//            logoutbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    homeapiload = 0;
//                    searchapiload = 0;
//                    subscribeapiload = 0;
//                    searchresultapiload = 0;
//                    settinguseraccountmanagementapiload = 0;
//                    cartapiload = 0;
//                    myapiload = 0;
//
//                    userinfouid.clear();
//                    userinfo.clear();
//
//                    atrend_id.clear();
//                    atrend_user_id.clear();
//                    atrend_type.clear();
//                    atrend_product_id.clear();
//                    atrend_contents_id.clear();
//                    atrend_title.clear();
//                    atrend_subtitle.clear();
//                    atrend_description.clear();
//                    atrend_summary.clear();
//                    atrend_view.clear();
//                    atrend_like.clear();
//                    atrend_color.clear();
//                    atrend_start_at.clear();
//                    atrend_create_at.clear();
//                    atrend_update_at.clear();
//                    atrend_opacity.clear();
//                    atrend_status.clear();
//                    atrend_background.clear();
//                    atrend_thumbnail.clear();
//
//                    popular_id.clear();
//                    popular_user_id.clear();
//                    popular_product_id.clear();
//                    popular_contents_id.clear();
//                    popular_contents_type.clear();
//                    popular_category_id.clear();
//                    popular_status.clear();
//                    popular_description.clear();
//                    popular_create_at.clear();
//                    popular_update_at.clear();
//                    popular_like_count.clear();
//                    popular_view_count.clear();
//                    popular_comment_count.clear();
//                    popular_category_en.clear();
//                    popular_category_kr.clear();
//                    popular_name.clear();
//                    popular_photo.clear();
//                    popular_p_thumbnail.clear();
//                    popular_c_thumbnail.clear();
//
//                    cate_name.clear();
//                    cate_number.clear();
//
//                    cart_items_p_option_stock.clear();
//                    cart_shop_id.clear();
//                    cart_shop_photo.clear();
//                    cart_shop_name.clear();
//                    cart_shop_shop_name.clear();
//                    cart_items_p_cart_id.clear();
//                    cart_items_p_user_id.clear();
//                    cart_items_p_option_value.clear();
//                    cart_items_p_option_price.clear();
//                    cart_items_p_product_id.clear();
//                    cart_items_p_status.clear();
//                    cart_items_p_vendor_id.clear();
//                    cart_items_p_name.clear();
//                    cart_items_p_thumbnail.clear();
//                    cart_items_p_ship.clear();
//
//                    cartdetail_opt_optid.clear();
//                    cartdetail_opt_price.clear();
//                    cartdetail_opt_stock.clear();
//                    cartdetail_opt_item_name.clear();
//                    cartdetail_desc_images.clear();
//                    cartdetail_desc_text.clear();
//
//                    cartdetail_result_optid.clear();
//                    cartdetail_result_item_name.clear();
//                    cartdetail_result_item_price.clear();
//                    cartdetail_result_item_count.clear();
//                    cartdetail_result_item_total.clear();
//
//                    addoption.clear();
//                    cartitemoption.clear();
//
//                    voyage_id.clear();
//                    voyage_user_id.clear();
//                    voyage_product_id.clear();
//                    voyage_contents_id.clear();
//                    voyage_contents_type.clear();
//                    voyage_category_id.clear();
//                    voyage_status.clear();
//                    voyage_description.clear();
//                    voyage_create_at.clear();
//                    voyage_update_at.clear();
//                    voyage_like_count.clear();
//                    voyage_view_count.clear();
//                    voyage_comment_count.clear();
//                    voyage_category_en.clear();
//                    voyage_category_kr.clear();
//                    voyage_name.clear();
//                    voyage_photo.clear();
//                    voyage_p_thumbnail.clear();
//
//                    voyage1_id.clear();
//                    voyage1_user_id.clear();
//                    voyage1_product_id.clear();
//                    voyage1_contents_id.clear();
//                    voyage1_contents_type.clear();
//                    voyage1_category_id.clear();
//                    voyage1_status.clear();
//                    voyage1_description.clear();
//                    voyage1_create_at.clear();
//                    voyage1_update_at.clear();
//                    voyage1_like_count.clear();
//                    voyage1_view_count.clear();
//                    voyage1_comment_count.clear();
//                    voyage1_category_en.clear();
//                    voyage1_category_kr.clear();
//                    voyage1_name.clear();
//                    voyage1_photo.clear();
//                    voyage1_p_thumbnail.clear();
//
//                    feedlife_feed_id .clear();
//                    feedlife_content_seq .clear();
//                    feedlife_author_id .clear();
//                    feedlife_written_date .clear();
//                    feedlife_views .clear();
//                    feedlife_comment_count .clear();
//                    feedlife_author_seq .clear();
//                    feedlife_author_picture .clear();
//                    feedlife_author_nickname .clear();
//                    feedlife_content .clear();
//                    feedlife_url .clear();
//                    feedlife_video .clear();
//                    feedlife_crop .clear();
//                    feedlife_f_feed_id.clear();
//                    feedlife_f_id.clear();
//                    feedlife_f_image.clear();
//                    feedlife_f_thumb.clear();
//                    feedlife_f_name.clear();
//                    feedlife_f_cr_unit.clear();
//                    feedlife_f_price.clear();
//                    feedlife_f_price_computed.clear();
//
//                    feedfashionclothes_feed_id .clear();
//                    feedfashionclothes_content_seq .clear();
//                    feedfashionclothes_author_id .clear();
//                    feedfashionclothes_written_date .clear();
//                    feedfashionclothes_views .clear();
//                    feedfashionclothes_comment_count .clear();
//                    feedfashionclothes_author_seq .clear();
//                    feedfashionclothes_author_picture .clear();
//                    feedfashionclothes_author_nickname .clear();
//                    feedfashionclothes_content .clear();
//                    feedfashionclothes_url .clear();
//                    feedfashionclothes_video .clear();
//                    feedfashionclothes_crop .clear();
//                    feedfashionclothes_f_feed_id.clear();
//                    feedfashionclothes_f_id.clear();
//                    feedfashionclothes_f_image.clear();
//                    feedfashionclothes_f_thumb.clear();
//                    feedfashionclothes_f_name.clear();
//                    feedfashionclothes_f_cr_unit.clear();
//                    feedfashionclothes_f_price.clear();
//                    feedfashionclothes_f_price_computed.clear();
//
//                    feedbabyandkid_feed_id .clear();
//                    feedbabyandkid_content_seq .clear();
//                    feedbabyandkid_author_id .clear();
//                    feedbabyandkid_written_date .clear();
//                    feedbabyandkid_views .clear();
//                    feedbabyandkid_comment_count .clear();
//                    feedbabyandkid_author_seq .clear();
//                    feedbabyandkid_author_picture .clear();
//                    feedbabyandkid_author_nickname .clear();
//                    feedbabyandkid_content .clear();
//                    feedbabyandkid_url .clear();
//                    feedbabyandkid_video .clear();
//                    feedbabyandkid_crop .clear();
//                    feedbabyandkid_f_feed_id.clear();
//                    feedbabyandkid_f_id.clear();
//                    feedbabyandkid_f_image.clear();
//                    feedbabyandkid_f_thumb.clear();
//                    feedbabyandkid_f_name.clear();
//                    feedbabyandkid_f_cr_unit.clear();
//                    feedbabyandkid_f_price.clear();
//                    feedbabyandkid_f_price_computed.clear();
//
//                    feedfoods_feed_id .clear();
//                    feedfoods_content_seq .clear();
//                    feedfoods_author_id .clear();
//                    feedfoods_written_date .clear();
//                    feedfoods_views .clear();
//                    feedfoods_comment_count .clear();
//                    feedfoods_author_seq .clear();
//                    feedfoods_author_picture .clear();
//                    feedfoods_author_nickname .clear();
//                    feedfoods_content .clear();
//                    feedfoods_url .clear();
//                    feedfoods_video .clear();
//                    feedfoods_crop .clear();
//                    feedfoods_f_feed_id.clear();
//                    feedfoods_f_id.clear();
//                    feedfoods_f_image.clear();
//                    feedfoods_f_thumb.clear();
//                    feedfoods_f_name.clear();
//                    feedfoods_f_cr_unit.clear();
//                    feedfoods_f_price.clear();
//                    feedfoods_f_price_computed.clear();
//
//                    feedsportsandleisure_feed_id .clear();
//                    feedsportsandleisure_content_seq .clear();
//                    feedsportsandleisure_author_id .clear();
//                    feedsportsandleisure_written_date .clear();
//                    feedsportsandleisure_views .clear();
//                    feedsportsandleisure_comment_count .clear();
//                    feedsportsandleisure_author_seq .clear();
//                    feedsportsandleisure_author_picture .clear();
//                    feedsportsandleisure_author_nickname .clear();
//                    feedsportsandleisure_content .clear();
//                    feedsportsandleisure_url .clear();
//                    feedsportsandleisure_video .clear();
//                    feedsportsandleisure_crop .clear();
//                    feedsportsandleisure_f_feed_id.clear();
//                    feedsportsandleisure_f_id.clear();
//                    feedsportsandleisure_f_image.clear();
//                    feedsportsandleisure_f_thumb.clear();
//                    feedsportsandleisure_f_name.clear();
//                    feedsportsandleisure_f_cr_unit.clear();
//                    feedsportsandleisure_f_price.clear();
//                    feedsportsandleisure_f_price_computed.clear();
//
//                    feedhealthandsupplements_feed_id .clear();
//                    feedhealthandsupplements_content_seq .clear();
//                    feedhealthandsupplements_author_id .clear();
//                    feedhealthandsupplements_written_date .clear();
//                    feedhealthandsupplements_views .clear();
//                    feedhealthandsupplements_comment_count .clear();
//                    feedhealthandsupplements_author_seq .clear();
//                    feedhealthandsupplements_author_picture .clear();
//                    feedhealthandsupplements_author_nickname .clear();
//                    feedhealthandsupplements_content .clear();
//                    feedhealthandsupplements_url .clear();
//                    feedhealthandsupplements_video .clear();
//                    feedhealthandsupplements_crop .clear();
//                    feedhealthandsupplements_f_feed_id.clear();
//                    feedhealthandsupplements_f_id.clear();
//                    feedhealthandsupplements_f_image.clear();
//                    feedhealthandsupplements_f_thumb.clear();
//                    feedhealthandsupplements_f_name.clear();
//                    feedhealthandsupplements_f_cr_unit.clear();
//                    feedhealthandsupplements_f_price.clear();
//                    feedhealthandsupplements_f_price_computed.clear();
//
//                    feedelectronics_feed_id .clear();
//                    feedelectronics_content_seq .clear();
//                    feedelectronics_author_id .clear();
//                    feedelectronics_written_date .clear();
//                    feedelectronics_views .clear();
//                    feedelectronics_comment_count .clear();
//                    feedelectronics_author_seq .clear();
//                    feedelectronics_author_picture .clear();
//                    feedelectronics_author_nickname .clear();
//                    feedelectronics_content .clear();
//                    feedelectronics_url .clear();
//                    feedelectronics_video .clear();
//                    feedelectronics_crop .clear();
//                    feedelectronics_f_feed_id.clear();
//                    feedelectronics_f_id.clear();
//                    feedelectronics_f_image.clear();
//                    feedelectronics_f_thumb.clear();
//                    feedelectronics_f_name.clear();
//                    feedelectronics_f_cr_unit.clear();
//                    feedelectronics_f_price.clear();
//                    feedelectronics_f_price_computed.clear();
//
//                    feedhouseholditems_feed_id .clear();
//                    feedhouseholditems_content_seq .clear();
//                    feedhouseholditems_author_id .clear();
//                    feedhouseholditems_written_date .clear();
//                    feedhouseholditems_views .clear();
//                    feedhouseholditems_comment_count .clear();
//                    feedhouseholditems_author_seq .clear();
//                    feedhouseholditems_author_picture .clear();
//                    feedhouseholditems_author_nickname .clear();
//                    feedhouseholditems_content .clear();
//                    feedhouseholditems_url .clear();
//                    feedhouseholditems_video .clear();
//                    feedhouseholditems_crop .clear();
//                    feedhouseholditems_f_feed_id.clear();
//                    feedhouseholditems_f_id.clear();
//                    feedhouseholditems_f_image.clear();
//                    feedhouseholditems_f_thumb.clear();
//                    feedhouseholditems_f_name.clear();
//                    feedhouseholditems_f_cr_unit.clear();
//                    feedhouseholditems_f_price.clear();
//                    feedhouseholditems_f_price_computed.clear();
//
//                    feedcaraccessories_feed_id .clear();
//                    feedcaraccessories_content_seq .clear();
//                    feedcaraccessories_author_id .clear();
//                    feedcaraccessories_written_date .clear();
//                    feedcaraccessories_views .clear();
//                    feedcaraccessories_comment_count .clear();
//                    feedcaraccessories_author_seq .clear();
//                    feedcaraccessories_author_picture .clear();
//                    feedcaraccessories_author_nickname .clear();
//                    feedcaraccessories_content .clear();
//                    feedcaraccessories_url .clear();
//                    feedcaraccessories_video .clear();
//                    feedcaraccessories_crop .clear();
//                    feedcaraccessories_f_feed_id.clear();
//                    feedcaraccessories_f_id.clear();
//                    feedcaraccessories_f_image.clear();
//                    feedcaraccessories_f_thumb.clear();
//                    feedcaraccessories_f_name.clear();
//                    feedcaraccessories_f_cr_unit.clear();
//                    feedcaraccessories_f_price.clear();
//                    feedcaraccessories_f_price_computed.clear();
//
//                    feedstationeries_feed_id .clear();
//                    feedstationeries_content_seq .clear();
//                    feedstationeries_author_id .clear();
//                    feedstationeries_written_date .clear();
//                    feedstationeries_views .clear();
//                    feedstationeries_comment_count .clear();
//                    feedstationeries_author_seq .clear();
//                    feedstationeries_author_picture .clear();
//                    feedstationeries_author_nickname .clear();
//                    feedstationeries_content .clear();
//                    feedstationeries_url .clear();
//                    feedstationeries_video .clear();
//                    feedstationeries_crop .clear();
//                    feedstationeries_f_feed_id.clear();
//                    feedstationeries_f_id.clear();
//                    feedstationeries_f_image.clear();
//                    feedstationeries_f_thumb.clear();
//                    feedstationeries_f_name.clear();
//                    feedstationeries_f_cr_unit.clear();
//                    feedstationeries_f_price.clear();
//                    feedstationeries_f_price_computed.clear();
//
//                    feedpet_feed_id .clear();
//                    feedpet_content_seq .clear();
//                    feedpet_author_id .clear();
//                    feedpet_written_date .clear();
//                    feedpet_views .clear();
//                    feedpet_comment_count .clear();
//                    feedpet_author_seq .clear();
//                    feedpet_author_picture .clear();
//                    feedpet_author_nickname .clear();
//                    feedpet_content .clear();
//                    feedpet_url .clear();
//                    feedpet_video .clear();
//                    feedpet_crop .clear();
//                    feedpet_f_feed_id.clear();
//                    feedpet_f_id.clear();
//                    feedpet_f_image.clear();
//                    feedpet_f_thumb.clear();
//                    feedpet_f_name.clear();
//                    feedpet_f_cr_unit.clear();
//                    feedpet_f_price.clear();
//                    feedpet_f_price_computed.clear();
//
//                    feedtravelandtickets_feed_id .clear();
//                    feedtravelandtickets_content_seq .clear();
//                    feedtravelandtickets_author_id .clear();
//                    feedtravelandtickets_written_date .clear();
//                    feedtravelandtickets_views .clear();
//                    feedtravelandtickets_comment_count .clear();
//                    feedtravelandtickets_author_seq .clear();
//                    feedtravelandtickets_author_picture .clear();
//                    feedtravelandtickets_author_nickname .clear();
//                    feedtravelandtickets_content .clear();
//                    feedtravelandtickets_url .clear();
//                    feedtravelandtickets_video .clear();
//                    feedtravelandtickets_crop .clear();
//                    feedtravelandtickets_f_feed_id.clear();
//                    feedtravelandtickets_f_id.clear();
//                    feedtravelandtickets_f_image.clear();
//                    feedtravelandtickets_f_thumb.clear();
//                    feedtravelandtickets_f_name.clear();
//                    feedtravelandtickets_f_cr_unit.clear();
//                    feedtravelandtickets_f_price.clear();
//                    feedtravelandtickets_f_price_computed.clear();
//
//                    feedevent_feed_id .clear();
//                    feedevent_content_seq .clear();
//                    feedevent_author_id .clear();
//                    feedevent_written_date .clear();
//                    feedevent_views .clear();
//                    feedevent_comment_count .clear();
//                    feedevent_author_seq .clear();
//                    feedevent_author_picture .clear();
//                    feedevent_author_nickname .clear();
//                    feedevent_content .clear();
//                    feedevent_url .clear();
//                    feedevent_video .clear();
//                    feedevent_crop .clear();
//                    feedevent_f_feed_id.clear();
//                    feedevent_f_id.clear();
//                    feedevent_f_image.clear();
//                    feedevent_f_thumb.clear();
//                    feedevent_f_name.clear();
//                    feedevent_f_cr_unit.clear();
//                    feedevent_f_price.clear();
//                    feedevent_f_price_computed.clear();
//
//                    feedeverythingelse_feed_id .clear();
//                    feedeverythingelse_content_seq .clear();
//                    feedeverythingelse_author_id .clear();
//                    feedeverythingelse_written_date .clear();
//                    feedeverythingelse_views .clear();
//                    feedeverythingelse_comment_count .clear();
//                    feedeverythingelse_author_seq .clear();
//                    feedeverythingelse_author_picture .clear();
//                    feedeverythingelse_author_nickname .clear();
//                    feedeverythingelse_content .clear();
//                    feedeverythingelse_url .clear();
//                    feedeverythingelse_video .clear();
//                    feedeverythingelse_crop .clear();
//                    feedeverythingelse_f_feed_id.clear();
//                    feedeverythingelse_f_id.clear();
//                    feedeverythingelse_f_image.clear();
//                    feedeverythingelse_f_thumb.clear();
//                    feedeverythingelse_f_name.clear();
//                    feedeverythingelse_f_cr_unit.clear();
//                    feedeverythingelse_f_price.clear();
//                    feedeverythingelse_f_price_computed.clear();
//
//                    feedresult_feed_id.clear();
//                    feedresult_content_seq.clear();
//                    feedresult_author_id.clear();
//                    feedresult_written_date.clear();
//                    feedresult_views.clear();
//                    feedresult_comment_count.clear();
//                    feedresult_author_seq.clear();
//                    feedresult_author_picture.clear();
//                    feedresult_author_nickname.clear();
//                    feedresult_content.clear();
//                    feedresult_url.clear();
//                    feedresult_video.clear();
//                    feedresult_crop.clear();
//                    feedresult_f_feed_id.clear();
//                    feedresult_f_id.clear();
//                    feedresult_f_image.clear();
//                    feedresult_f_thumb.clear();
//                    feedresult_f_name.clear();
//                    feedresult_f_cr_unit.clear();
//                    feedresult_f_price.clear();
//                    feedresult_f_price_computed.clear();
//
//                    subscribe_list_id.clear();
//                    subscribe_list_name.clear();
//                    subscribe_list_photo.clear();
//
//                    checker_list_sbscr_id.clear();
//                    checker_list_seq.clear();
//                    checker_list_id.clear();
//                    checker_list_nickname.clear();
//                    checker_list_picture.clear();
//                    checker_list_follower.clear();
//                    checker_list_contents_cnt.clear();
//                    checker_list_social_type.clear();
//
//                    subscribe_feed_list_crop.clear();
//                    subscribe_feed_list_video.clear();
//                    subscribe_feed_list_picture.clear();
//                    subscribe_feed_list_nickname.clear();
//                    subscribe_feed_list_fe_content.clear();
//                    subscribe_feed_list_fe_views_cnt.clear();
//                    subscribe_feed_list_fe_id.clear();
//                    subscribe_feed_list_seq.clear();
//                    subscribe_feedall_list_seq.clear();
//                    subscribe_feedall_list_crop.clear();
//                    subscribe_feedall_list_video.clear();
//                    subscribe_feedall_list_picture.clear();
//                    subscribe_feedall_list_nickname.clear();
//                    subscribe_feedall_list_fe_content.clear();
//                    subscribe_feedall_list_fe_views_cnt.clear();
//                    subscribe_feedall_list_fe_id.clear();
//                    subscribe_feedall_list_seq.clear();
//
//                    feedeverythingelse_f_feed_id.clear();
//                    feedeverythingelse_f_id.clear();
//                    feedeverythingelse_f_image.clear();
//                    feedeverythingelse_f_thumb.clear();
//                    feedeverythingelse_f_name.clear();
//                    feedeverythingelse_f_cr_unit.clear();
//                    feedeverythingelse_f_price.clear();
//                    feedeverythingelse_f_price_computed.clear();
//
//                    subscribe_feedall_f_list_feed_id.clear();
//                    subscribe_feedall_f_list_id.clear();
//                    subscribe_feedall_f_list_image.clear();
//                    subscribe_feedall_f_list_thumb.clear();
//                    subscribe_feedall_f_list_name.clear();
//                    subscribe_feedall_f_list_cr_unit.clear();
//                    subscribe_feedall_f_list_price.clear();
//                    subscribe_feedall_f_list_price_computed.clear();
//                    subscribe_feed_f_list_feed_id.clear();
//                    subscribe_feed_f_list_id.clear();
//                    subscribe_feed_f_list_image.clear();
//                    subscribe_feed_f_list_thumb.clear();
//                    subscribe_feed_f_list_name.clear();
//                    subscribe_feed_f_list_cr_unit.clear();
//                    subscribe_feed_f_list_price.clear();
//                    subscribe_feed_f_list_price_computed.clear();
//
//                    player_feed_list_author_id.clear();
//                    player_feed_list_crop.clear();
//                    player_feed_list_id.clear();
//                    player_feed_list_content.clear();
//                    player_feed_list_author_nickname.clear();
//                    player_feed_list_author_picture.clear();
//                    player_feed_list_views.clear();
//                    player_feed_f_list_feed_id.clear();
//                    player_feed_f_list_id.clear();
//                    player_feed_f_list_image.clear();
//                    player_feed_f_list_thumb.clear();
//                    player_feed_f_list_name.clear();
//                    player_feed_f_list_cr_unit.clear();
//                    player_feed_f_list_price.clear();
//                    player_feed_f_list_price_computed.clear();
//
//                    creator_feed_list_crop.clear();
//                    creator_feed_list_video.clear();
//                    creator_feed_list_content.clear();
//                    creator_feed_list_author_nickname.clear();
//                    creator_feed_list_author_picture.clear();
//                    creator_feed_list_views.clear();
//                    creator_feed_f_list_feed_id.clear();
//                    creator_feed_f_list_id.clear();
//                    creator_feed_f_list_image.clear();
//                    creator_feed_f_list_thumb.clear();
//                    creator_feed_f_list_name.clear();
//                    creator_feed_f_list_cr_unit.clear();
//                    creator_feed_f_list_price.clear();
//                    creator_feed_f_list_price_computed.clear();
//
//                    my_creator_feed_f_list_feed_id.clear();
//                    my_creator_feed_f_list_id.clear();
//                    my_creator_feed_f_list_image.clear();
//                    my_creator_feed_f_list_thumb.clear();
//                    my_creator_feed_f_list_name.clear();
//                    my_creator_feed_f_list_cr_unit.clear();
//                    my_creator_feed_f_list_price.clear();
//                    my_creator_feed_f_list_price_computed.clear();
//                    my_creator_feed_list_crop.clear();
//                    my_creator_feed_list_video.clear();
//                    my_creator_feed_list_content.clear();
//                    my_creator_feed_list_author_nickname.clear();
//                    my_creator_feed_list_author_picture.clear();
//                    my_creator_feed_list_views.clear();
//
//                    follower_uid.clear();
//                    follower_seq.clear();
//                    follower_nickname.clear();
//                    follower_picture.clear();
//                    follower_follower.clear();
//                    follower_vid.clear();
//                    follower_content_cnt.clear();
//                    follower_video_cnt.clear();
//
//                    recommend_id.clear();
//                    recommend_seq.clear();
//                    recommend_nickname.clear();
//                    recommend_picture.clear();
//                    recommend_follower.clear();
//                    recommend_contents_cnts.clear();
//                    recommend_subscr_id.clear();
//
//                    user_cate.clear();
//
//                    SharedPreferences.Editor editor = prf.edit();
//                    editor.clear();
//                    editor.commit();
//                    setDataGusetinfo();
//                    ActivityCompat.finishAffinity(SettingActivityUserAccountmanagement.this);
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, LoadingActivity.class);
//                    intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//                    finish();
//
//                }
//            });
//
//            addaccountbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (userinfo.size() == 18 && userinfouid.size() == 3) {
//                        builder.setTitle(getResources().getString(R.string.alertdialog_maxaccount));
//
//                        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int id) {
//
//                            }
//                        });
//
//                        AlertDialog alertDialog = builder.create();
//                        alertDialog.show();
//                    } else {
//                        Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountAdd.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                        startActivity(intent);
////                finish();
//                    }
//                }
//            });
//
//            acc1changebtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    settingactivityuseraccountmanagementaccountchange1handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            NetworkTaskUsersChange1 networktaskuserschange1 = new NetworkTaskUsersChange1(api_tvott_users, null);
//                            networktaskuserschange1.execute();
//                        }
//                    });
////                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange1.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
////                startActivity(intent);
//////                finish();
//                }
//            });
//
//            acc1disconnectbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountDisconnect1.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
////                finish();
//                }
//            });
//
//            acc2changebtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    settingactivityuseraccountmanagementaccountchange2handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            NetworkTaskUsersChange2 networktaskuserschange2 = new NetworkTaskUsersChange2(api_tvott_users, null);
//                            networktaskuserschange2.execute();
//                        }
//                    });
////                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange2.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
////                startActivity(intent);
//////                finish();
//                }
//            });
//
//            acc2disconnectbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountDisconnect2.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
////                finish();
//                }
//            });
//
//            acc3changebtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    settingactivityuseraccountmanagementaccountchange3handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            NetworkTaskUsersChange3 networktaskuserschange3 = new NetworkTaskUsersChange3(api_tvott_users, null);
//                            networktaskuserschange3.execute();
//                        }
//                    });
////                Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountChange3.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
////                startActivity(intent);
//////                finish();
//                }
//            });
//
//            acc3disconnectbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(SettingActivityUserAccountmanagement.this, AccountDisconnect3.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
////                finish();
//                }
//            });
//
//        }
//    }

    @Override
    protected void onRestart() {
        super.onRestart();
        overridePendingTransition(0,0);
        TV1.requestFocus();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }

    public class SettingActivityUserAccountmanagementAccountChange1Handler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {

                AllClear();

                ActivityCompat.finishAffinity(SettingUserManagementActivity.this);
                Intent intent = new Intent(SettingUserManagementActivity.this, LoadingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

//                onResume();
//                acc1changebtn.requestFocus();
            }
        }
    }

    public class SettingActivityUserAccountmanagementAccountChange2Handler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {

                AllClear();

                ActivityCompat.finishAffinity(SettingUserManagementActivity.this);
                Intent intent = new Intent(SettingUserManagementActivity.this, LoadingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        }
    }

    public class SettingActivityUserAccountmanagementAccountChange3Handler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {

                AllClear();

                ActivityCompat.finishAffinity(SettingUserManagementActivity.this);
                Intent intent = new Intent(SettingUserManagementActivity.this, LoadingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        }
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
        loginid = prf.getInt("user_id", 0);
        prf.getString("language", "");
        Log.d(TAG2, "language >>> " + prf.getString("language", ""));
        loginlanguage = prf.getString("language", "");
        prf.getBoolean("selectaccount", true);
        Log.d(TAG2, "selectaccount >>> " + prf.getBoolean("selectaccount", true));
        prf.getString("country", "");
        Log.d(TAG2, "country >>> " + prf.getString("country", ""));
        prf.getString("currency", "");
        Log.d(TAG2, "currency >>> " + prf.getString("currency", ""));
        logincurrency = prf.getString("currency", "");
    }

}