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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.aliseon.ott.API.TvottAddUser;
import com.aliseon.ott.API.TvottUsers;
import com.aliseon.ott.AdapterSpinner1;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmptyAddAccountActivity extends AppCompatActivity {

    public static MyHandler EmptyAccountAddmHandler;

    AliseonAPI AliseonAPI;

    AlertDialog.Builder builder;

    String defaultcontrycode;

    //UI
    Spinner spinner1;

    //Adapter
    AdapterSpinner1 adapterSpinner1;

    String[] Number;
    int[] CountryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_account);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

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

        EmptyAccountAddmHandler = new MyHandler();

        //?????????
        Number = new String[]{"+971", "+82", "+966", "+98","+90", "+20", "+84", "+62"};
        CountryImage = new int[]{R.drawable.unitedarabemirates
                ,R.drawable.southkorea
                ,R.drawable.saudiarabia
                ,R.drawable.iran
                ,R.drawable.turkey
                ,R.drawable.egypt
                ,R.drawable.vietnam
                ,R.drawable.indonesia};

        //UI??????
        spinner1 = (Spinner) findViewById(R.id.addspinner);

        spinner1.setFocusableInTouchMode(true);
        spinner1.requestFocus();

        //Adapter
        adapterSpinner1 = new AdapterSpinner1(this, Number, CountryImage);

        //Adapter ??????
        spinner1.setAdapter(adapterSpinner1);

        spinner1.requestFocus();

        Button button = (Button) findViewById(R.id.addbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyAccountAddmHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        String countrycode = aliseon.aliseon_getCountrycode();
                        String phone_number = aliseon.aliseon_getPhone_number();

                        EditText editText = (EditText) findViewById(R.id.addphonenumber);
                        String editTextnumber = editText.getText().toString();
                        defaultcontrycode = spinner1.getSelectedItem().toString();
                        countrycode = defaultcontrycode.substring(1);
                        phone_number = editTextnumber;

                        aliseon.aliseon_setCountrycode(countrycode);
                        aliseon.aliseon_setPhone_number(countrycode);

                        AddUserPost();
                    }
                });

            }
        });

        Button button2 = (Button) findViewById(R.id.addacountcancel);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmptyAddAccountActivity.this, EmptyUserSelectActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
        });
    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // ?????? Thread?????? ???????????? Message ??????
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
                Intent intent = new Intent(EmptyAddAccountActivity.this, EmptyUserSelectActivity.class);
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


                if (postResponse == null) {
                    EmptyAccountAddmHandler.sendEmptyMessage(800);
                } else {
                    TvottUsersPost();
                }

            }

            @Override
            public void onFailure(Call<TvottAddUser> call, Throwable t) {

            }
        });


    }

    private void TvottUsersPost(){

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();

        Call<TvottUsers> call = AliseonAPI.TvottUsersPost(access_token);

        call.enqueue(new Callback<TvottUsers>() {
            @Override
            public void onResponse(Call<TvottUsers> call, Response<TvottUsers> response) {

                TvottUsers postResponse = (TvottUsers) response.body();
                Log.d("STATUS:", "COMPLETE");
                Log.d("Code : ", "" + response.code());
                Log.d("Status : ", "" + postResponse.getList());
                Log.d("Status : ", "" + postResponse.getStatus());


                ArrayList<Integer> userinfouid = new ArrayList<>();
                ArrayList<String> userinfo = new ArrayList<>();

                for(int i = 0; i < postResponse.getList().size(); i++){

                    Log.d("result id : ", "" + postResponse.getList().get(i).getId());
                    Log.d("result nickname : ", "" + postResponse.getList().get(i).getNickname());
                    Log.d("result photo : ", "" + postResponse.getList().get(i).getPhoto());
                    Log.d("result language : ", "" + postResponse.getList().get(i).getLanguage());
                    Log.d("result country : ", "" + postResponse.getList().get(i).getCountry());
                    Log.d("result currency : ", "" + postResponse.getList().get(i).getCurrency());

                    switch (i){
                        case 0 :
                            userinfouid.add(0,postResponse.getList().get(i).getId());
                            userinfo.add(0,postResponse.getList().get(i).getNickname());
                            userinfo.add(1,postResponse.getList().get(i).getPhoto());
                            userinfo.add(2,postResponse.getList().get(i).getLanguage());
                            userinfo.add(3,postResponse.getList().get(i).getCountry());
                            userinfo.add(4,postResponse.getList().get(i).getCurrency());
                            break;
                        case 1 :
                            userinfouid.add(1,postResponse.getList().get(i).getId());
                            userinfo.add(5,postResponse.getList().get(i).getNickname());
                            userinfo.add(6,postResponse.getList().get(i).getPhoto());
                            userinfo.add(7,postResponse.getList().get(i).getLanguage());
                            userinfo.add(8,postResponse.getList().get(i).getCountry());
                            userinfo.add(9,postResponse.getList().get(i).getCurrency());
                            break;
                        case 2:
                            userinfouid.add(2,postResponse.getList().get(i).getId());
                            userinfo.add(10,postResponse.getList().get(i).getNickname());
                            userinfo.add(11,postResponse.getList().get(i).getPhoto());
                            userinfo.add(12,postResponse.getList().get(i).getLanguage());
                            userinfo.add(13,postResponse.getList().get(i).getCountry());
                            userinfo.add(14,postResponse.getList().get(i).getCurrency());
                            break;
                    }

                    aliseon.aliseon_setTvott_userinfouid(userinfouid);
                    aliseon.aliseon_setTvott_userinfo(userinfo);

                }

                EmptyAccountAddmHandler.sendEmptyMessage(1000);

            }

            @Override
            public void onFailure(Call<TvottUsers> call, Throwable t) {
                Log.d("STATUS:", "FAILED");
                Log.d("STATUS:", t.getMessage());

//                LoadingmHandler.sendEmptyMessage(800);

            }

        });

    }

}
