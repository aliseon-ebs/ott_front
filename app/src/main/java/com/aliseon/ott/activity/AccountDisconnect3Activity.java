package com.aliseon.ott.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.aliseon.ott.API.UserDelete;
import com.aliseon.ott.API.UserPhone;
import com.aliseon.ott.AdapterSpinner1;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccountDisconnect3Activity extends AppCompatActivity {

    public static MyHandler Disconnect3mHandler;

    AliseonAPI AliseonAPI;

    SharedPreferences pref;

    AlertDialog.Builder builder;

    int defaultcontrycode;

    //UI
    Spinner spinner1;

    //Adapter
    AdapterSpinner1 adapterSpinner1;

    String[] Number;
    int[] CountryImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disconnect_account3);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);

        Disconnect3mHandler = new MyHandler();

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
        spinner1 = (Spinner) findViewById(R.id.disconnectspinner3);

        spinner1.setFocusableInTouchMode(true);
        spinner1.requestFocus();

        //Adapter
        adapterSpinner1 = new AdapterSpinner1(this, Number, CountryImage);

        //Adapter 적용
        spinner1.setAdapter(adapterSpinner1);

        spinner1.requestFocus();

        Button button = (Button) findViewById(R.id.disconnectcancel3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AccountDisconnect3Activity.this, SettingUserManagementActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();

            }
        });

        Button button2 = (Button) findViewById(R.id.disconnectdisconnect3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disconnect3mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        String countrycode = aliseon.aliseon_getCountrycode();
                        String phone_number = aliseon.aliseon_getPhone_number();

                        int myuid = aliseon.aliseon_getMyuid();

                        ArrayList<Integer> userinfouid = aliseon.aliseon_getTvott_userinfouid();

                        EditText editText = (EditText) findViewById(R.id.disconnect_number3);
                        String editTextnumber = editText.getText().toString();
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

                        aliseon.aliseon_setMyuid(userinfouid.get(2));
//                        myuid = userinfouid.get(2);

                        UserPhonePost();
                    }
                });
            }
        });
    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 600) {
                Intent intent = new Intent(AccountDisconnect3Activity.this, SettingUserManagementActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
            if (msg.what == 800) {
                builder.setTitle(getResources().getString(R.string.alertdialog_notnumber));

                builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
            if (msg.what == 1000) {
                Intent intent = new Intent(AccountDisconnect3Activity.this, SettingUserManagementActivity.class);
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

                int id = postResponse.userphone_list.get(0).getId();
                aliseon.aliseon_setInfocheck_id(id);

                int infocheck_id = aliseon.aliseon_getInfocheck_id();
                int myuid = aliseon.aliseon_getMyuid();

                if(infocheck_id != myuid){
                    Disconnect3mHandler.sendEmptyMessage(800);
                } else {
                    UserDeletePost();
                }
//                aliseon.aliseon_setInfocheck_id(-1);
//                aliseon.aliseon_setMyuid(-2);


            }

            @Override
            public void onFailure(Call<UserPhone> call, Throwable t) {
                Log.d("STATUS:", "FAILED");
                Log.d("STATUS:", t.getMessage());
            }
        });

    }

    private void UserDeletePost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();

        ArrayList<Integer> userinfouid = aliseon.aliseon_getTvott_userinfouid();

        String access_token = aliseon.aliseon_getAccesstoken();
        String user_id = String.valueOf(aliseon.aliseon_getInfocheck_id());


        Call<UserDelete> call = AliseonAPI.UserDeletePost(access_token, user_id);

        call.enqueue(new Callback<UserDelete>() {
            @Override
            public void onResponse(Call<UserDelete> call, Response<UserDelete> response) {

                UserDelete postResponse = (UserDelete) response.body();

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


                    ArrayList<String> sample = new ArrayList<>();
                    ArrayList<Integer> uid = new ArrayList<>();

                    switch (i) {

                        case 0:
                            uid.add(0, Integer.valueOf(id));

                            sample.add(0, name);
                            sample.add(1, photo);
                            sample.add(2, language);
                            sample.add(3, country);
                            sample.add(4, currency);

                            aliseon.aliseon_setTvott_userinfo(sample);
                            break;

                        case 1:
                            uid.add(1, id);

                            sample.add(5, name);
                            sample.add(6, photo);
                            sample.add(7, language);
                            sample.add(8, country);
                            sample.add(9, currency);

                            aliseon.aliseon_setTvott_userinfo(sample);
                            break;

                        case 2:
                            uid.add(2, id);

                            sample.add(10, name);
                            sample.add(11, photo);
                            sample.add(12, language);
                            sample.add(13, country);
                            sample.add(14, currency);

                            aliseon.aliseon_setTvott_userinfo(sample);
                            break;

                    }

                }

                SharedPreferences.Editor editor3 = pref.edit();
                if (pref.getInt("user_id", 0) == userinfouid.get(2)) {
                    editor3.putString("userinfo_name", "empty");
                    editor3.putString("userinfo_picture", "empty");
                    editor3.putInt("user_id", 0);
                    editor3.putString("language", "empty");
                    editor3.putString("country", "empty");
                    editor3.putString("currency", "empty");
                    editor3.putBoolean("selectaccount", false);
                    editor3.commit();
                }

                if(LoadingActivity.pref.getBoolean("selectaccount", true) == false){
                    Disconnect3mHandler.sendEmptyMessage(600);
                } else {
                    Disconnect3mHandler.sendEmptyMessage(1000);
                }

            }

            @Override
            public void onFailure(Call<UserDelete> call, Throwable t) {
                Log.d("STATUS:", "FAILED");
                Log.d("STATUS:", t.getMessage());
            }
        });

    }

}
