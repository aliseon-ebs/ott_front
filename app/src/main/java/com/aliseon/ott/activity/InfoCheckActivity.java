package com.aliseon.ott.activity;

import android.content.res.Configuration;
import android.os.Handler;
import android.content.*;
import android.os.Bundle;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.aliseon.ott.API.TvottAddUser;
import com.aliseon.ott.API.UserPhone;
import com.aliseon.ott.AdapterSpinner1;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;
//import com.aliseon.ott.networktask.NetworkTaskUserPhone;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

//import static com.aliseon.ott.activity.LoadingActivity.setDataGusetinfo;
//import static com.aliseon.ott.Aliseon.android_id;
//import static com.aliseon.ott.Aliseon.api_usersetting_user_phone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import static com.aliseon.ott.activity.LoadingActivity.setDataUserinfo;

public class InfoCheckActivity extends AppCompatActivity {

    int defaultcontrycode;

    private AliseonAPI AliseonAPI;

    public static MyHandler InfocheckmHandler;

    AlertDialog.Builder builder;

    SharedPreferences pref;

    //UI
    Spinner spinner1;

    //Adapter
    AdapterSpinner1 adapterSpinner1;

    String[] Number;
    int[] CountryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_info);

        builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);

        InfocheckmHandler = new MyHandler();

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();

        String phone_number = aliseon.aliseon_getPhone_number();
        String countrycode = aliseon.aliseon_getCountrycode();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        pref = getSharedPreferences("login_session", MODE_PRIVATE);

        switch (pref.getString("language", "")) {
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
            case "":
                break;
        }

        Number = new String[]{"+971", "+82", "+966", "+98", "+90", "+20", "+84", "+62"};
        CountryImage = new int[]{R.drawable.unitedarabemirates
                , R.drawable.southkorea
                , R.drawable.saudiarabia
                , R.drawable.iran
                , R.drawable.turkey
                , R.drawable.egypt
                , R.drawable.vietnam
                , R.drawable.indonesia};

        EditText editText1 = (EditText) findViewById(R.id.phonenumber);
        EditText editText2 = (EditText) findViewById(R.id.cnumber);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        //UI생성
        spinner1 = (Spinner) findViewById(R.id.spinner1);

        //Adapter
        adapterSpinner1 = new AdapterSpinner1(this, Number, CountryImage);

        //Adapter 적용
        spinner1.setAdapter(adapterSpinner1);
        spinner1.setSelection(0, false);
        spinner1.requestFocus();

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override   // position 으로 몇번째 것이 선택됬는지 값을 넘겨준다
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                editText1.requestFocus();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                editText1.requestFocus();

            }
        });

        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
            @Override
            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                if (hasFocus) {
                    editText1.setHint(null);
                } else {
                    editText1.setHint(getResources().getString(R.string.input_phone));
                }
            }
        });

        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면
            @Override
            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                if (hasFocus) {
                    editText2.setHint(null);
                } else {
                    editText2.setHint(getResources().getString(R.string.code_number
                    ));
                }
            }
        });

        editText1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Enter key Action
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //Enter키눌렀을떄 처리
                    button1.requestFocus();
                    return true;
                }
                return false;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText2.requestFocus();
            }
        });

        editText2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Enter key Action
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //Enter키눌렀을떄 처리
                    button2.requestFocus();
                    return true;
                }
                return false;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.phonenumber);
                String editTextnumber = editText.getText().toString();
                defaultcontrycode = spinner1.getSelectedItemPosition();    //국가번호 지정코드
                String countrycode = aliseon.aliseon_getCountrycode();
                String phone_number = aliseon.aliseon_getPhone_number();

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

                InfocheckmHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        PhonePost();
                    }
                });
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.putString("userinfo_name", "empty");
                editor.putString("userinfo_picture", "empty");
                editor.putInt("user_id", 0);
                editor.putString("language", "empty");
                editor.putString("country", "empty");
                editor.putString("currency", "empty");
                editor.putBoolean("selectaccount", false);
                aliseon.aliseon_setLogincurrency(pref.getString("currency", ""));
                aliseon.aliseon_setLoginlanguage(pref.getString("language", ""));
                editor.commit();

//                setDataGusetinfo();
                Intent intent = new Intent(InfoCheckActivity.this, LanguageSettingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onResume(){
        super.onResume();

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
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

                    @Override
                    public void onShow(DialogInterface dialog) {

                        Button negative = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        negative.requestFocus();
                    }
                });
                alertDialog.show();
            }

            if (msg.what == 900) {
                builder.setTitle("This phone number is already logined this device. please use other phone number or skip and go to settings for change account.");
                builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

                    @Override
                    public void onShow(DialogInterface dialog) {

                        Button negative = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        negative.requestFocus();
                    }
                });
                alertDialog.show();
            }

            if (msg.what == 1000) {
                Intent intent = new Intent(InfoCheckActivity.this, LanguageSettingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    private void PhonePost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        String phonenumber = aliseon.aliseon_getPhone_number();
        String countrycode = aliseon.aliseon_getCountrycode();

        Log.d("DATACHECKER", "DATA : " + access_token + " / " + countrycode + " / " + phonenumber);

        Call<UserPhone> call = AliseonAPI.UserPhonePost(access_token, countrycode, phonenumber);

        call.enqueue(new Callback<UserPhone>() {
            @Override
            public void onResponse(Call<UserPhone> call, Response<UserPhone> response) {

                UserPhone postResponse = (UserPhone) response.body();
                Log.d("ITWORKS?", String.valueOf(postResponse));
                Log.d("ITWORKS?", String.valueOf(postResponse.userphone_list.get(0).getId()));

                int id = postResponse.userphone_list.get(0).getId();
                aliseon.aliseon_setInfocheck_id(id);

                if ( response.body() == null || response.body().toString().contains("false") ) {
                    InfocheckmHandler.sendEmptyMessage(800);
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

        Log.d("CHEKCINGWORKS", access_token + " / " + infocheck_id);

        Call<TvottAddUser> call = AliseonAPI.TvottAddUserPost(access_token, infocheck_id);

        call.enqueue(new Callback<TvottAddUser>() {
            @Override
            public void onResponse(Call<TvottAddUser> call, Response<TvottAddUser> response) {

                TvottAddUser postResponse = (TvottAddUser) response.body();

                Log.d("Code : ", "" + response.code());

                if (response.code() == 404) {
                    Log.d("404ERROR", "" + response.message());
                    Log.d("404ERROR", "" + response.errorBody().toString());
                    try {
                        JSONObject jsonObject = null;
                        jsonObject = new JSONObject(response.errorBody().string());
                        String userMessage = jsonObject.getString("message");
                        Log.d("RESULTERROR", userMessage);

                        if (userMessage.contains("ott user always exists") == true) {
                            Log.d("ERRORCONFIRM", "IS SAME USER!!!");
                            InfocheckmHandler.sendEmptyMessage(900);
                        }

                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }

                } else {

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


                        ArrayList<String> sample = new ArrayList<String>();
                        ArrayList<Integer> uid = new ArrayList<Integer>();

                        try {

                            switch (i) {

                                case 0:
                                    uid.add(0, Integer.valueOf(id));

                                    sample.add(0, name);
                                    sample.add(1, photo);
                                    sample.add(2, language);
                                    sample.add(3, country);
                                    sample.add(4, currency);

                                    Log.d("IsWorking?", String.valueOf(uid));
                                    Log.d("IsWorking?", String.valueOf(sample));

                                    aliseon.aliseon_setTvott_userinfo(sample);
                                    aliseon.aliseon_setTvott_userinfouid(uid);
                                    break;

                                case 1:
                                    uid.add(1, id);

                                    sample.add(5, name);
                                    sample.add(6, photo);
                                    sample.add(7, language);
                                    sample.add(8, country);
                                    sample.add(9, currency);

                                    aliseon.aliseon_setTvott_userinfo(sample);
                                    aliseon.aliseon_setTvott_userinfouid(uid);
                                    break;

                                case 2:
                                    uid.add(2, id);

                                    sample.add(10, name);
                                    sample.add(11, photo);
                                    sample.add(12, language);
                                    sample.add(13, country);
                                    sample.add(14, currency);

                                    aliseon.aliseon_setTvott_userinfo(sample);
                                    aliseon.aliseon_setTvott_userinfouid(uid);
                                    break;

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

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
                        InfocheckmHandler.sendEmptyMessage(1000);

                    } else {
//                    AccountAddmHandler.sendEmptyMessage(1000);
                    }
                }

            }

            @Override
            public void onFailure(Call<TvottAddUser> call, Throwable t) {

            }
        });


    }

}