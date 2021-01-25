package com.aliseon.ott.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.aliseon.ott.API.TvottAddUser;
import com.aliseon.ott.API.UserPhone;
import com.aliseon.ott.AdapterSpinner1;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;
import com.google.android.exoplayer2.util.ErrorMessageProvider;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AccountAddActivity extends AppCompatActivity {



    public static MyHandler AccountAddmHandler;

    //
    //UI
    Spinner spinner1;

    int defaultcontrycode;

    SharedPreferences pref;

    //Adapter
    AdapterSpinner1 adapterSpinner1;

    AlertDialog.Builder builder;

    String[] Number;
    int[] CountryImage;

    AliseonAPI AliseonAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_account);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String phone_number = aliseon.aliseon_getPhone_number();
        String countrycode = aliseon.aliseon_getCountrycode();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        pref = getSharedPreferences("login_session", MODE_PRIVATE);

        builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);

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

        AccountAddmHandler = new MyHandler();

        //데이터
        Number = new String[]{"+971", "+82", "+966", "+98","+90", "+20", "+84", "+62"};
        CountryImage = new int[]{R.drawable.unitedarabemirates
                ,R.drawable.southkorea
                ,R.drawable.saudiarabia
                ,R.drawable.iran
                ,R.drawable.turkey
                ,R.drawable.egypt
                ,R.drawable.vietnam
                ,R.drawable.indonesia};

        //UI생성
        spinner1 = (Spinner) findViewById(R.id.addspinner);

        spinner1.setFocusableInTouchMode(true);
        spinner1.requestFocus();

        //Adapter
        adapterSpinner1 = new AdapterSpinner1(this, Number, CountryImage);

        //Adapter 적용
        spinner1.setAdapter(adapterSpinner1);

        spinner1.requestFocus();

        Button button = (Button) findViewById(R.id.addbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountAddmHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        EditText editText = (EditText) findViewById(R.id.addphonenumber);
                        String editTextnumber = editText.getText().toString();
                        String countrycode = aliseon.aliseon_getCountrycode();
                        String phone_number = aliseon.aliseon_getPhone_number();

                        defaultcontrycode = spinner1.getSelectedItemPosition();    //국가번호 지정코드
                        switch (defaultcontrycode) {
                            case 0:
                                countrycode = "AE";
                                break;
                            case 1:
                                countrycode = "KR";
                                break;
                            case 2:
                                countrycode = "SA";
                                break;
                            case 3:
                                countrycode = "IR";
                                break;
                            case 4:
                                countrycode = "TR";
                                break;
                            case 5:
                                countrycode = "EG";
                                break;
                            case 6:
                                countrycode = "VN";
                                break;
                            case 7:
                                countrycode = "ID";
                                break;
                        }
                        phone_number = editTextnumber;

                        aliseon.aliseon_setCountrycode(countrycode);
                        aliseon.aliseon_setPhone_number(phone_number);

                        UserPhonePost();
                    }
                });

            }
        });

        Button button2 = (Button) findViewById(R.id.addacountcancel);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountAddActivity.this, SettingUserManagementActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
        });

    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 800) {
                builder.setTitle(getResources().getString(R.string.alertdialog_notvaild));

                builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
            if (msg.what == 1000) {
                Intent intent = new Intent(AccountAddActivity.this, SettingUserManagementActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
        }
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

    private void UserPhonePost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        String phonenumber = aliseon.aliseon_getPhone_number();
        String countrycode = aliseon.aliseon_getCountrycode();

        Call<UserPhone> call = AliseonAPI.UserPhonePost(access_token, countrycode, phonenumber);

        call.enqueue(new Callback<UserPhone>() {
            @Override
            public void onResponse(Call<UserPhone> call, Response<UserPhone> response) {

                UserPhone postResponse = (UserPhone) response.body();
                Log.d("ITWORKS?", String.valueOf(postResponse));
                Log.d("ITWORKS?", String.valueOf(postResponse.userphone_list.get(0).getId()));

                int id = postResponse.userphone_list.get(postResponse.userphone_list.size() - 1).getId();
                aliseon.aliseon_setInfocheck_id(id);

                if ( response.body() == null || response.body().toString().contains("false") ) {

                } else {
                    AddUserPost();
                }


            }

            @Override
            public void onFailure(Call<UserPhone> call, Throwable t) {
                Log.d("STATUS:", "FAILED");
                Log.d("STATUS:", t.getMessage());
            }
        });

    }

    private void AddUserPost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        int infocheck_id = aliseon.aliseon_getInfocheck_id();

        int adduserapiload = aliseon.aliseon_getAddUserAPIload();


        Call<TvottAddUser> call = AliseonAPI.TvottAddUserPost(access_token, infocheck_id);

        call.enqueue(new Callback<TvottAddUser>() {
            @Override
            public void onResponse(Call<TvottAddUser> call, Response<TvottAddUser> response) {

                TvottAddUser postResponse = (TvottAddUser) response.body();

                Log.d("ISWORK?", String.valueOf(postResponse));


                for (int i = 0; i < postResponse.getList().size(); i++) {
                    int id = postResponse.getList().get(i).getId();
                    String name = postResponse.getList().get(i).getNickname();
                    String photo = postResponse.getList().get(i).getPhoto();
                    String language = postResponse.getList().get(i).getLanguage();
                    String country = postResponse.getList().get(i).getCountry();
                    String currency = postResponse.getList().get(i).getCurrency();

                    Log.d("DATALIST", String.valueOf(id));
                    Log.d("DATALIST", name);
                    Log.d("DATALIST", photo);
                    Log.d("DATALIST", language);
                    Log.d("DATALIST", country);
                    Log.d("DATALIST", currency);


                    ArrayList<String> sample = aliseon.aliseon_getTvott_userinfo();
                    ArrayList<Integer> uid = aliseon.aliseon_getTvott_userinfouid();



                    try {

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    switch (i) {

                        case 0:

                            Log.d("CASE 1", "ON");

                            try {
                                Log.d("CASE 1", "TRY");
                                uid.add(0, Integer.valueOf(id));

                                sample.set(0, name);
                                sample.set(1, photo);
                                sample.set(2, language);
                                sample.set(3, country);
                                sample.set(4, currency);
                            } catch (Exception e) {
                                Log.d("CASE 1", "CATCH");
                                e.printStackTrace();

                                uid.add(id);

                                sample.add(name);
                                sample.add(photo);
                                sample.add(language);
                                sample.add(country);
                                sample.add(currency);
                            }

                            aliseon.aliseon_setTvott_userinfo(sample);
                            aliseon.aliseon_setTvott_userinfouid(uid);
                            Log.d("CASE 1", sample.toString());
                            Log.d("CASE 1", uid.toString());
                            break;

                        case 1:

                            try {
                                uid.set(1, id);

                                sample.set(5, name);
                                sample.set(6, photo);
                                sample.set(7, language);
                                sample.set(8, country);
                                sample.set(9, currency);
                            } catch (Exception e) {
                                e.printStackTrace();

                                uid.add(id);

                                sample.add(name);
                                sample.add(photo);
                                sample.add(language);
                                sample.add(country);
                                sample.add(currency);
                            }

                            aliseon.aliseon_setTvott_userinfo(sample);
                            aliseon.aliseon_setTvott_userinfouid(uid);
                            Log.d("CASE 2", sample.toString());
                            Log.d("CASE 2", uid.toString());
                            break;

                        case 2:

                            try {
                                uid.set(2, id);

                                sample.set(10, name);
                                sample.set(11, photo);
                                sample.set(12, language);
                                sample.set(13, country);
                                sample.set(14, currency);
                            } catch (Exception e) {
                                e.printStackTrace();

                                uid.add(id);

                                sample.add(name);
                                sample.add(photo);
                                sample.add(language);
                                sample.add(country);
                                sample.add(currency);
                            }

                            aliseon.aliseon_setTvott_userinfo(sample);
                            aliseon.aliseon_setTvott_userinfouid(uid);
                            Log.d("CASE 3", sample.toString());
                            Log.d("CASE 3", uid.toString());
                            break;

                    }

                }

                Log.d("CASE E", aliseon.aliseon_getTvott_userinfo().toString());
                Log.d("CASE E", aliseon.aliseon_getTvott_userinfouid().toString());

                if (adduserapiload == 0) {

//                    setDataUserinfo();

                    ArrayList<String> userinfo = aliseon.aliseon_getTvott_userinfo();
                    ArrayList<Integer> userinfouid = aliseon.aliseon_getTvott_userinfouid();

                    SharedPreferences.Editor editor = pref.edit();
                    editor.clear();

                    editor.putString("userinfo_name", userinfo.get(0));
                    editor.putString("userinfo_picture", userinfo.get(1));
                    editor.putInt("user_id", userinfouid.get(0));
                    editor.putString("language", userinfo.get(2));
                    editor.putString("country", userinfo.get(3));
                    editor.putString("currency", userinfo.get(4));
                    editor.putBoolean("selectaccount", true);
                    editor.commit();

                    aliseon.aliseon_setAddUserAPIload(1);
//                    InfocheckmHandler.sendEmptyMessage(1000);

                } else {
                    AccountAddmHandler.sendEmptyMessage(1000);
                }

            }

            @Override
            public void onFailure(Call<TvottAddUser> call, Throwable t) {

            }
        });


    }

}
