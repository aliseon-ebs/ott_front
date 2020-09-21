package com.aliseon.ott.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.aliseon.ott.AdapterSpinner2;
import com.aliseon.ott.AdapterSpinner3;
import com.aliseon.ott.AdapterSpinner4;
import com.aliseon.ott.CircleImageView;
import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskTvottLanguageSetting;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

import static com.aliseon.ott.Variable.api_usersetting;
import static com.aliseon.ott.Variable.logincurrency;
import static com.aliseon.ott.Variable.logincountry;
import static com.aliseon.ott.Variable.loginlanguage;
import static com.aliseon.ott.Variable.usersettinglanguageapiload;

public class SettingLanguagesettingActivity extends AppCompatActivity {

    private ArrayList<String> user_cate;

    //Adapter
    AdapterSpinner2 adapterSpinner2;
    AdapterSpinner3 adapterSpinner3;
    AdapterSpinner4 adapterSpinner4;

    ArrayList<String> language;
    ArrayList<String> country;
    ArrayList<String> money;

    String SpinnerSelectLanguage;
    String SpinnerSelectCountry;
    String SpinnerSelectCurrency;
    static int prfuid;

    TextView TV2;

    public static MyHandler UserLanguagemHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_languagesetting);

        SharedPreferences prf = getSharedPreferences("login_session",MODE_PRIVATE);

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

        UserLanguagemHandler = new MyHandler();

        user_cate = new ArrayList<>();

        user_cate.add(getResources().getString(R.string.account_management));
        user_cate.add(getResources().getString(R.string.language_setting));

        language = new ArrayList<>();
        country = new ArrayList<>();
        money = new ArrayList<>();

        //데이터
        language.add("English");
        language.add("한국어");
        language.add("العربية");

        //데이터
        country.add("United Arab Emirates");
        country.add("Republic of Korea");
        country.add("Socialist Republic of Vietnam");

        //데이터
        money.add("USD");
        money.add("AED");
        money.add("KRW");
        money.add("VND");

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
        Cart.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
        CircleImageView My = new CircleImageView(this);
        My.setFocusableInTouchMode(true);
        My.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
        ImageView Setting = new ImageView(this);
        Setting.setFocusableInTouchMode(true);
        Setting.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
        Cart.setPadding(15,15,15,15);
        CircleImageView Profile = new CircleImageView(this);
        Home.setPadding(15, 15, 15, 15);
        User.setPadding(15, 15, 15, 15);
        Search.setPadding(15, 15, 15, 15);
        My.setPadding(15,15,15,15);
        Setting.setPadding(15,15,15,15);

        Home.setImageResource(R.drawable.home);
        Search.setImageResource(R.drawable.search);
        User.setImageResource(R.drawable.user);
        Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
        Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
        Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
        User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
        User.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Cart.setId(R.id.languagesettingcart);
        Cart.setImageResource(R.drawable.cart);
        Cart.setLayoutParams(new ViewGroup.LayoutParams(60,60));
        Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
        My.setLayoutParams(new ViewGroup.LayoutParams(80,80));
        My.setId(R.id.my);
        if (prf.getString("userinfo_picture", "").equals("empty")) {
            My.setImageResource(R.drawable.noimg_profile);
        } else {
            Glide.with(this).load(prf.getString("userinfo_picture", "")).into(My);
        }
        Setting.setImageResource(R.drawable.setting);
        Setting.setLayoutParams(new ViewGroup.LayoutParams(60,60));
        Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Profile.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
        Profile.setPadding(20,20,20,20);


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
        ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
        ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
        ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());

        margin.setMargins(10, 20, 5, 20);
        margin2.setMargins(10, 20, 5, 20);
        margin3.setMargins(10, 20, 5, 20);
        margin4.setMargins(10, 20, 5, 20);
        margin5.setMargins(0,20,5, 20);
        margin6.setMargins(10,20,20, 20);

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
        Layout2_1_4.setLayoutParams(margin4);
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
        Layout3_2.setGravity(Gravity.BOTTOM| Gravity.LEFT);

        TextView name = new TextView(this);

        TextView TV1 = new TextView(this);
        TV2 = new TextView(this);


        Home.setId(R.id.languagesettinghome);
        Search.setId(R.id.languagesettingsearch);
        User.setId(R.id.languagesettinguser);
        Setting.setId(R.id.setting);
        TV1.setId(R.id.languagesetting1);
        TV2.setId(R.id.languagesetting2);

        TV1.setFocusableInTouchMode(true);
        TV2.setFocusableInTouchMode(true);

        TV1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
        TV2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));

        TV1.setText(user_cate.get(0));
        TV2.setText(user_cate.get(1));

        name.setTextColor(Color.rgb(255,255,255));

        name.setTextSize(10);

        TV1.setTextColor(Color.rgb(255, 255, 255));
        TV2.setTextColor(Color.rgb(066, 066, 066));

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
        Layout4.setGravity(Gravity.CENTER);

        Layout4.setLayoutParams(params4);

        LinearLayout Layout4_1 = new LinearLayout(this);
        LinearLayout Layout4_2 = new LinearLayout(this);
        LinearLayout Layout4_3 = new LinearLayout(this);
        LinearLayout Layout4_3_1 = new LinearLayout(this);
        LinearLayout Layout4_3_2 = new LinearLayout(this);
        LinearLayout Layout4_3_3 = new LinearLayout(this);
        LinearLayout Layout4_4 = new LinearLayout(this);

        LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Layout4_3.setOrientation(LinearLayout.HORIZONTAL);

        Layout4_1.setGravity(Gravity.CENTER);
        Layout4_2.setGravity(Gravity.CENTER);
        Layout4_3.setGravity(Gravity.CENTER);
        Layout4_3_1.setGravity(Gravity.CENTER);
        Layout4_3_2.setGravity(Gravity.CENTER);
        Layout4_3_3.setGravity(Gravity.CENTER);
        Layout4_4.setGravity(Gravity.CENTER);

        TextView TV10 = new TextView(this);
        TextView TV11 = new TextView(this);
        Spinner spinner1 = new Spinner(this);
        Spinner spinner2 = new Spinner(this);
        Spinner spinner3 = new Spinner(this);
        Button button = new Button(this);

        TV10.setTextSize(30);
        TV10.setTypeface(null, Typeface.BOLD);
        TV11.setTextSize(15);

        spinner1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.spinnersetting));
        spinner2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.spinnersetting));
        spinner3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.spinnersetting));
        button.setBackground(ContextCompat.getDrawable(this,R.drawable.buttonsetting));

        spinner1.setLayoutParams(new ViewGroup.LayoutParams(200, 60));
        spinner2.setLayoutParams(new ViewGroup.LayoutParams(400, 60));
        spinner3.setLayoutParams(new ViewGroup.LayoutParams(200, 60));
        button.setLayoutParams(new ViewGroup.LayoutParams(200,65));

        //Adapter
        adapterSpinner2 = new AdapterSpinner2(this, language);
        //Adapter
        adapterSpinner3 = new AdapterSpinner3(this, country);
        //Adapter
        adapterSpinner4 = new AdapterSpinner4(this, money);
        //Adapter 적용
        spinner1.setAdapter(adapterSpinner2);
        //Adapter 적용
        spinner2.setAdapter(adapterSpinner3);
        //Adapter 적용
        spinner3.setAdapter(adapterSpinner4);

        TV2.requestFocus();

        switch (prf.getString("language","")){
            case "en" :
                spinner1.setSelection(0);
                break;
            case "kr" :
                spinner1.setSelection(1);
                break;
            case "ar" :
                spinner1.setSelection(2);
                break;
        }

        switch(prf.getString("country", "")){
            case "AE" :
                spinner2.setSelection(0);
                break;
            case "KR" :
                spinner2.setSelection(1);
                break;
            case "VN" :
                spinner2.setSelection(2);
                break;
        }

        switch(prf.getString("currency","")){
            case "USD" :
                spinner3.setSelection(0);
                break;
            case "AED" :
                spinner3.setSelection(1);
                break;
            case "KRW" :
                spinner3.setSelection(2);
                break;
            case "VND" :
                spinner3.setSelection(3);
                break;
        }

        TV10.setText(getResources().getString(R.string.language_setting));
        TV11.setText(getResources().getString(R.string.want_setting));

        TV10.setTextColor(Color.rgb(255, 255, 255));
        TV11.setTextColor(Color.rgb(255, 255, 255));

        button.setTextColor(Color.rgb(255,255,255));
        button.setTextSize(10);

        TV10.setPadding(10, 10, 10, 10);
        TV11.setPadding(10, 10, 10, 10);

        button.setText(getResources().getString(R.string.complete));

        Layout4_1.addView(TV10);
        Layout4_2.addView(TV11);
        Layout4_3_1.addView(spinner1);
        Layout4_3_2.addView(spinner2);
        Layout4_3_3.addView(spinner3);
        Layout4_4.addView(button);


        ViewGroup.MarginLayoutParams margin4_2 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
        ViewGroup.MarginLayoutParams margin4_3_2 = new ViewGroup.MarginLayoutParams(spinner2.getLayoutParams());
        ViewGroup.MarginLayoutParams margin4_4 = new ViewGroup.MarginLayoutParams(button.getLayoutParams());

        margin4_2.setMargins(0, 0, 0, 50);
        margin4_3_2.setMargins(30, 0, 30, 0);
        margin4_4.setMargins(0, 50, 0, 40);

        Layout4_1.setLayoutParams(params4_1);
        Layout4_2.setLayoutParams(params4_1);
        Layout4_2.setLayoutParams(margin4_2);
        Layout4_3.setLayoutParams(params4_1);
        Layout4_3_1.setLayoutParams(params4_1);
        Layout4_3_2.setLayoutParams(params4_1);
        Layout4_3_2.setLayoutParams(margin4_3_2);
        Layout4_3_3.setLayoutParams(params4_1);
        Layout4_4.setLayoutParams(params4_1);
        Layout4_4.setLayoutParams(margin4_4);

        Layout4.addView(Layout4_1);
        Layout4.addView(Layout4_2);
        Layout4.addView(Layout4_3);
        Layout4_3.addView(Layout4_3_1);
        Layout4_3.addView(Layout4_3_2);
        Layout4_3.addView(Layout4_3_3);
        Layout4.addView(Layout4_4);

        Layout1.addView(Layout2);

        Layout2.addView(Layout2_1);
        Layout2.addView(Layout2_2);

        Layout2_1.addView(Layout2_1_1);
        Layout2_1.addView(Layout2_1_2);
        Layout2_1.addView(Layout2_1_3);
        Layout2_1.addView(Layout2_1_4);
        Layout2_1.addView(Layout2_1_5);

        Layout2_2.addView(Layout2_2_1);

        Layout2_1_1.addView(Home);
        Layout2_1_2.addView(Search);
        Layout2_1_3.addView(User);
        Layout2_1_4.addView(Cart);
        Layout2_1_5.addView(My);
        Layout2_2_1.addView(Setting);

        Layout2_1.setOrientation(LinearLayout.VERTICAL);
        Layout2_2.setOrientation(LinearLayout.VERTICAL);

        Layout1.addView(Layout3);

        Layout1.addView(Layout4);

        setContentView(Layout1);

        Home.setNextFocusRightId(R.id.languagesetting2);
        Search.setNextFocusRightId(R.id.languagesetting2);
        User.setNextFocusRightId(R.id.languagesetting2);
        Home.setNextFocusUpId(R.id.languagesettinguser);
        User.setNextFocusDownId(R.id.languagesettinghome);
        spinner1.setNextFocusLeftId(R.id.languagesetting2);
        button.setNextFocusLeftId(R.id.languagesetting2);
        TV1.setNextFocusLeftId(R.id.setting);
        TV2.setNextFocusLeftId(R.id.setting);
        Setting.setNextFocusRightId(R.id.accountmanagement2);
        Setting.setNextFocusUpId(R.id.my);

        spinner1.setId(R.id.spinner1);
        spinner2.setId(R.id.spinner2);
        spinner3.setId(R.id.spinner3);

        spinner1.setNextFocusUpId(R.id.spinner1);
        spinner2.setNextFocusUpId(R.id.spinner2);
        spinner3.setNextFocusUpId(R.id.spinner3);

        button.setId(R.id.buttonlayout);
        button.setNextFocusDownId(R.id.buttonlayout);

        Layout3_2_2.setBackgroundColor((Color.rgb(255, 255, 255)));

        TV2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
            @Override
            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                if (hasFocus == false) {
                    Layout3_2_2.setBackgroundColor(Color.rgb(50,50,50));
                    TV2.setTextColor(Color.rgb(255, 255, 255));

                    Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                            if (hasFocus) {
//                                Home.setImageResource(R.drawable.homeselect);
                                TV2.setTextColor(Color.rgb(255, 255, 255));
                                Intent intent = new Intent(SettingLanguagesettingActivity.this, HomeActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
//                finish();
                            }else {
                            }
                        }
                    });

                    Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                            if (hasFocus) {
//                                Search.setImageResource(R.drawable.searchselect);
                                TV2.setTextColor(Color.rgb(255, 255, 255));
                                Intent intent = new Intent(SettingLanguagesettingActivity.this, VoyageActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
//                finish();
                            }else {
                            }
                        }
                    });

                    User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                            if (hasFocus) {
//                                User.setImageResource(R.drawable.userselect);
                                TV2.setTextColor(Color.rgb(255, 255, 255));
                                Intent intent = new Intent(SettingLanguagesettingActivity.this, SubscribeActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                            }else{
                            }
                        }
                    });

                    Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                            if (hasFocus) {
//                                User.setImageResource(R.drawable.userselect);
                                TV2.setTextColor(Color.rgb(255, 255, 255));
                                Intent intent = new Intent(SettingLanguagesettingActivity.this, CartActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                            }else{
                            }
                        }
                    });

                    My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                            if (hasFocus) {
//                                User.setImageResource(R.drawable.userselect);
                                TV2.setTextColor(Color.rgb(255, 255, 255));
                                Intent intent = new Intent(SettingLanguagesettingActivity.this, MyActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                            }else{
                            }
                        }
                    });

                    TV1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                            if (hasFocus) {
                                TV1.setTextColor(Color.rgb(255, 255, 255));
                                TV2.setTextColor(Color.rgb(066, 066, 066));
                                Layout3_2_1.setBackgroundColor(Color.rgb(255, 255, 255));
                                Layout3_2_2.setBackground(null);
                                Intent intent = new Intent(SettingLanguagesettingActivity.this, SettingUserManagementActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
//                              finish();
                            }else {
                                Layout3_2_1.setBackground(null);
                            }
                        }
                    });

                } else {
                    TV2.setTextColor(Color.rgb(066, 066, 066));
                    Layout3_2_2.setBackgroundColor(Color.rgb(255, 255, 255));
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpinnerSelectLanguage = spinner1.getSelectedItem().toString();
                SpinnerSelectCountry = spinner2.getSelectedItem().toString();
                SpinnerSelectCurrency = spinner3.getSelectedItem().toString();
                prfuid = prf.getInt("user_id",0);

                SharedPreferences.Editor editor = prf.edit();

                switch(SpinnerSelectLanguage){
                    case "English" :
                        loginlanguage  = "en";
                        editor.putString("language", "en");
                        editor.commit();
                        break;
                    case "한국어" :
                        loginlanguage = "kr";
                        editor.putString("language", "kr");
                        editor.commit();
                        break;
                    case "العربية" :
                        loginlanguage = "ar";
                        editor.putString("language", "ar");
                        editor.commit();
                        break;
                }

                switch(SpinnerSelectCountry){
                    case "United Arab Emirates" :
                        logincountry = "AE";
                        editor.putString("country", "AE");
                        editor.commit();
                        break;
                    case "Republic of Korea" :
                        logincountry = "KR";
                        editor.putString("country", "KR");
                        editor.commit();
                        break;
                    case "Socialist Republic of Vietnam" :
                        logincountry = "VN";
                        editor.putString("country", "VN");
                        editor.commit();
                        break;
                }

                switch(SpinnerSelectCurrency){
                    case "USD" :
                        logincurrency = "USD";
                        editor.putString("currency", "USD");
                        editor.commit();
                        break;
                    case "AED" :
                        logincurrency = "AED";
                        editor.putString("currency", "AED");
                        editor.commit();
                        break;
                    case "KRW" :
                        logincurrency = "KRW";
                        editor.putString("currency", "KRW");
                        editor.commit();
                        break;
                    case "VND" :
                        logincurrency = "VND";
                        editor.putString("currency", "VND");
                        editor.commit();
                        break;
                }
                UserLanguagemHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        usersettinglanguageapiload = 1;

                        NetworkTaskTvottLanguageSetting networkTasktvottlanguagesetting = new NetworkTaskTvottLanguageSetting(api_usersetting, null);
                        networkTasktvottlanguagesetting.execute();
                    }
                });
            }
        });

    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {



                Intent intent = new Intent(SettingLanguagesettingActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        overridePendingTransition(0,0);
        TV2.requestFocus();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }

}
