package com.aliseon.ott.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.aliseon.ott.API.TvottLanguageSetting;
import com.aliseon.ott.AdapterSpinner2;
import com.aliseon.ott.AdapterSpinner3;
import com.aliseon.ott.AdapterSpinner4;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;

//import com.aliseon.ott.networktask.NetworkTaskTvottLanguageSetting;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LanguageSettingActivity extends AppCompatActivity {

    //UI
     Spinner spinner2;
     Spinner spinner3;
     Spinner spinner4;

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

    public static MyHandler LanguagemHandler;

    private static String TAG2 = "Shared값 가져오기";

    private AliseonAPI AliseonAPI;

    SharedPreferences pref;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Aliseon aliseon = (Aliseon) getApplicationContext();
            String aliseonapi = aliseon.aliseon_getAliseonapi();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(aliseonapi)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            AliseonAPI = retrofit.create(AliseonAPI.class);



            setContentView(R.layout.setting_language);

            pref = getSharedPreferences("login_session", MODE_PRIVATE);

            if (pref.getString("userinfo_name", "").equals("empty")
                    && pref.getString("userinfo_picture", "").equals("empty")
                    && pref.getInt("user_id", 0) == 0) {

                aliseon.aliseon_setSubscribeAPIload(-1);
                aliseon.aliseon_setCartAPIload(-1);
                aliseon.aliseon_setMyAPIload(-1);

            } else {
                aliseon.aliseon_setSubscribeAPIload(0);
                aliseon.aliseon_setCartAPIload(0);
                aliseon.aliseon_setMyAPIload(0);
            }

            readData();

            LanguagemHandler = new MyHandler();

            language = new ArrayList<>();
            country = new ArrayList<>();
            money = new ArrayList<>();

            //데이터
            language.add("English");
            language.add("한국어");
            language.add("العربية");

//            NetworkTaskCategories networkTaskcategories = new NetworkTaskCategories(url4, null);
//            networkTaskcategories.execute();

            //UI생성
            spinner2 = (Spinner)findViewById(R.id.spinner2);

            spinner2.setFocusableInTouchMode(true);
            spinner2.requestFocus();

            //Adapter
            adapterSpinner2 = new AdapterSpinner2(this, language);

            //Adapter 적용
            spinner2.setAdapter(adapterSpinner2);
            spinner2.setSelection(0, false);

            //데이터
            country.add("United Arab Emirates");
            country.add("Saudi Arabia");
            country.add("Korea, Republic of");
            country.add("Vietnam");
            country.add("Indonesia");

            //UI생성
            spinner3 = (Spinner)findViewById(R.id.spinner3);

            //Adapter
            adapterSpinner3 = new AdapterSpinner3(this, country);

            //Adapter 적용
            spinner3.setAdapter(adapterSpinner3);
            spinner3.setSelection(0, false);

            //데이터
            money.add("AED");
            money.add("USD");
            money.add("KRW");
            money.add("BDT");
            money.add("EUR");
            money.add("INR");
            money.add("NGN");
            money.add("BRL");

            //UI생성
            spinner4 = (Spinner)findViewById(R.id.spinner4);

            //Adapter
            adapterSpinner4 = new AdapterSpinner4(this, money);

            //Adapter 적용
            spinner4.setAdapter(adapterSpinner4);
            spinner4.setSelection(0, false);

            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override   // position 으로 몇번째 것이 선택됬는지 값을 넘겨준다
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    spinner3.requestFocus();

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                    spinner3.requestFocus();

                }
            });

            Button button = (Button) findViewById(R.id.button3);
            Button button2 = (Button) findViewById(R.id.button4);

            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override   // position 으로 몇번째 것이 선택됬는지 값을 넘겨준다
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    spinner4.requestFocus();

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                    spinner4.requestFocus();

                }
            });

            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override   // position 으로 몇번째 것이 선택됬는지 값을 넘겨준다
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    button.requestFocus();

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                    button.requestFocus();

                }
            });


            switch (pref.getString("language","")){
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
                case "" :
                    break;
            }

            if (pref.getString("userinfo_name", "").equals("empty") && pref.getString("userinfo_picture", "").equals("empty") && pref.getInt("user_id", 0) == 0 && pref.getString("language", "").equals("empty") && pref.getBoolean("selectaccount", true) == false && pref.getString("country", "").equals("empty") && pref.getString("currency", "").equals("empty")) {

                Log.d("게스트 통과", "O");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SpinnerSelectLanguage = spinner2.getSelectedItem().toString();
                        SpinnerSelectCountry = spinner3.getSelectedItem().toString();
                        SpinnerSelectCurrency = spinner4.getSelectedItem().toString();

                        aliseon.aliseon_setLoginid(pref.getInt("user_id", 0));

                        SharedPreferences.Editor editor = pref.edit();

                        switch (SpinnerSelectLanguage) {
                            case "العربية":
                                aliseon.aliseon_setLoginlanguage("ar");
                                editor.putString("language", "ar");
                                editor.commit();
                                break;
                            case "English":
                                aliseon.aliseon_setLoginlanguage("en");
                                editor.putString("language", "en");
                                editor.commit();
                                break;
                            case "한국어":
                                aliseon.aliseon_setLoginlanguage("ko");
                                editor.putString("language", "ko");
                                editor.commit();
                                break;
                        }

                        switch (SpinnerSelectCountry) {
                            case "United Arab Emirates":
                                aliseon.aliseon_setLogincountry("AE");
                                editor.putString("country", "AE");
                                editor.commit();
                                break;
                            case "Saudi Arabia":
                                aliseon.aliseon_setLogincountry("SA");
                                editor.putString("country", "SA");
                                editor.commit();
                                break;
                            case "Korea, Republic of":
                                aliseon.aliseon_setLogincountry("KR");
                                editor.putString("country", "KR");
                                editor.commit();
                                break;
                            case "Vietnam":
                                aliseon.aliseon_setLogincountry("VN");
                                editor.putString("country", "VN");
                                editor.commit();
                                break;
                            case "Indonesia":
                                aliseon.aliseon_setLogincountry("ID");
                                editor.putString("country", "ID");
                                editor.commit();
                                break;
                        }

                        switch (SpinnerSelectCurrency) {
                            case "AED":
                                aliseon.aliseon_setLogincurrency("AED");
                                editor.putString("currency", "AED");
                                editor.commit();
                                break;
                            case "USD":
                                aliseon.aliseon_setLogincurrency("USD");
                                editor.putString("currency", "USD");
                                editor.commit();
                                break;
                            case "KRW":
                                aliseon.aliseon_setLogincurrency("KRW");
                                editor.putString("currency", "KRW");
                                editor.commit();
                                break;
                            case "BDT":
                                aliseon.aliseon_setLogincurrency("BDT");
                                editor.putString("currency", "BDT");
                                editor.commit();
                                break;
                            case "EUR":
                                aliseon.aliseon_setLogincurrency("EUR");
                                editor.putString("currency", "EUR");
                                editor.commit();
                                break;
                            case "INR":
                                aliseon.aliseon_setLogincurrency("INR");
                                editor.putString("currency", "INR");
                                editor.commit();
                                break;
                            case "NGN":
                                aliseon.aliseon_setLogincurrency("NGN");
                                editor.putString("currency", "NGN");
                                editor.commit();
                                break;
                            case "BRL":
                                aliseon.aliseon_setLogincurrency("BRL");
                                editor.putString("currency", "BRL");
                                editor.commit();
                                break;

                        }
                        Intent intent = new Intent(LanguageSettingActivity.this, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setDefaultDataGuestLanguageSetting();
                        Intent intent = new Intent(LanguageSettingActivity.this, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                        readData();
                    }
                });

            } else {
                Log.d("유저 통과", "O");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SpinnerSelectLanguage = spinner2.getSelectedItem().toString();
                        SpinnerSelectCountry = spinner3.getSelectedItem().toString();
                        SpinnerSelectCurrency = spinner4.getSelectedItem().toString();

                        aliseon.aliseon_setLoginid(pref.getInt("user_id", 0));

                        SharedPreferences.Editor editor = pref.edit();

                        switch (SpinnerSelectLanguage) {
                            case "العربية":
                                aliseon.aliseon_setLoginlanguage("ar");
                                editor.putString("language", "ar");
                                editor.commit();
                                break;
                            case "English":
                                aliseon.aliseon_setLoginlanguage("en");
                                editor.putString("language", "en");
                                editor.commit();
                                break;
                            case "한국어":
                                aliseon.aliseon_setLoginlanguage("ko");
                                editor.putString("language", "ko");
                                editor.commit();
                                break;

                        }

                        switch (SpinnerSelectCountry) {
                            case "United Arab Emirates":
                                aliseon.aliseon_setLogincountry("AE");
                                editor.putString("country", "AE");
                                editor.commit();
                                break;
                            case "Saudi Arabia":
                                aliseon.aliseon_setLogincountry("SA");
                                editor.putString("country", "SA");
                                editor.commit();
                                break;
                            case "Korea, Republic of":
                                aliseon.aliseon_setLogincountry("KR");
                                editor.putString("country", "KR");
                                editor.commit();
                                break;
                            case "Vietnam":
                                aliseon.aliseon_setLogincountry("VN");
                                editor.putString("country", "VN");
                                editor.commit();
                                break;
                            case "Indonesia":
                                aliseon.aliseon_setLogincountry("ID");
                                editor.putString("country", "ID");
                                editor.commit();
                                break;
                        }

                        switch (SpinnerSelectCurrency) {
                            case "AED":
                                aliseon.aliseon_setLogincurrency("AED");
                                editor.putString("currency", "AED");
                                editor.commit();
                                break;
                            case "USD":
                                aliseon.aliseon_setLogincurrency("USD");
                                editor.putString("currency", "USD");
                                editor.commit();
                                break;
                            case "KRW":
                                aliseon.aliseon_setLogincurrency("KRW");
                                editor.putString("currency", "KRW");
                                editor.commit();
                                break;
                            case "BDT":
                                aliseon.aliseon_setLogincurrency("BDT");
                                editor.putString("currency", "BDT");
                                editor.commit();
                                break;
                            case "EUR":
                                aliseon.aliseon_setLogincurrency("EUR");
                                editor.putString("currency", "EUR");
                                editor.commit();
                                break;
                            case "INR":
                                aliseon.aliseon_setLogincurrency("INR");
                                editor.putString("currency", "INR");
                                editor.commit();
                                break;
                            case "NGN":
                                aliseon.aliseon_setLogincurrency("NGN");
                                editor.putString("currency", "NGN");
                                editor.commit();
                                break;
                            case "BRL":
                                aliseon.aliseon_setLogincurrency("BRL");
                                editor.putString("currency", "BRL");
                                editor.commit();
                                break;

                        }
                        LanguagemHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                TvottLanguageSettingPost();
                            }
                        });
                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setDefaultDataUserLanguageSetting();
                        Intent intent = new Intent(LanguageSettingActivity.this, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                    }
                });
            }

}

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {
                Intent intent = new Intent(LanguageSettingActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
        }
    }

    public void setDefaultDataGuestLanguageSetting() {

    }

    public void setDefaultDataUserLanguageSetting() {

    }

    public void readData()
    {
        Aliseon aliseon = (Aliseon) getApplicationContext();

//        pref = getSharedPreferences("login_session",MODE_PRIVATE);
//        pref.getString("userinfo_name", "");
//        pref.getString("userinfo_picture", "");
//        pref.getInt("user_id", 0);
//        loginid = pref.getInt("user_id", 0);
//        pref.getString("language", "");
//        loginlanguage = pref.getString("language", "");
//        pref.getBoolean("selectaccount", true);
//        pref.getString("country", "");
//        pref.getString("currency", "");
//        logincurrency = pref.getString("currency", "");
        pref = getSharedPreferences("login_session",MODE_PRIVATE);
        pref.getString("userinfo_name", "");
        Log.d(TAG2, "info >>> " + pref.getString("userinfo_name", ""));
        pref.getString("userinfo_picture", "");
        Log.d(TAG2, "picture >>> " + pref.getString("userinfo_picture", ""));
        pref.getInt("user_id", 0);
        Log.d(TAG2, "id >>> " + pref.getInt("user_id", 0));
        aliseon.aliseon_setLoginid(pref.getInt("user_id", 0));
        pref.getString("language", "");
        Log.d(TAG2, "language >>> " + pref.getString("language", ""));
        aliseon.aliseon_setLoginlanguage(pref.getString("language", ""));
        pref.getBoolean("selectaccount", true);
        Log.d(TAG2, "selectaccount >>> " + pref.getBoolean("selectaccount", true));
        pref.getString("country", "");
        Log.d(TAG2, "country >>> " + pref.getString("country", ""));
        pref.getString("currency", "");
        Log.d(TAG2, "currency >>> " + pref.getString("currency", ""));
        aliseon.aliseon_setLogincurrency(pref.getString("currency", ""));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }

    private void TvottLanguageSettingPost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        int user_id = aliseon.aliseon_getLoginid();
        String lang = aliseon.aliseon_getLoginlanguage();
        String country = aliseon.aliseon_getLogincountry();
        String currency = aliseon.aliseon_getLogincurrency();

        int usersettingsettingapiload = aliseon.aliseon_getUsersettinglanguageAPIload();

    Call<TvottLanguageSetting> call = AliseonAPI.TvottLanguageSettingPost(access_token, user_id, lang, country, currency);

    call.enqueue(new Callback<TvottLanguageSetting>() {
        @Override
        public void onResponse(Call<TvottLanguageSetting> call, Response<TvottLanguageSetting> response) {

            TvottLanguageSetting postResponse = (TvottLanguageSetting) response.body();

            if (usersettingsettingapiload == 0) {
                LanguagemHandler.sendEmptyMessage(1000);
            } else if (usersettingsettingapiload == 1) {
                LanguagemHandler.sendEmptyMessage(1000);
            }

        }

        @Override
        public void onFailure(Call<TvottLanguageSetting> call, Throwable t) {

        }
    });
    }

}
