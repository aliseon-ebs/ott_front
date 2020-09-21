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

import com.aliseon.ott.AdapterSpinner1;
import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskUserPhone;

import java.util.Locale;

import static com.aliseon.ott.activity.LoadingActivity.setDataGusetinfo;
import static com.aliseon.ott.Variable.android_id;
import static com.aliseon.ott.Variable.api_usersetting_user_phone;
import static com.aliseon.ott.Variable.pref;
import static com.aliseon.ott.Variable.countrycode;
import static com.aliseon.ott.Variable.phone_number;

public class InfoCheckActivity extends AppCompatActivity {

    int defaultcontrycode;

    public static MyHandler InfocheckmHandler;

    AlertDialog.Builder builder;

    private static String TAG = "휴대폰 정보 가져오기";

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

        // 유니크한 단말 번호 >>> Android ID 사용
        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.d(TAG, "Android_ID >>> " + android_id);

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
                switch (defaultcontrycode) {
                    case 0:
                        countrycode = "971";
                        break;
                    case 1:
                        countrycode = "82";
                        break;
                    case 2:
                        countrycode = "966";
                        break;
                    case 3:
                        countrycode = "98";
                        break;
                    case 4:
                        countrycode = "90";
                        break;
                    case 5:
                        countrycode = "20";
                        break;
                    case 6:
                        countrycode = "84";
                        break;
                    case 7:
                        countrycode = "62";
                        break;
                }
                phone_number = editTextnumber;

                InfocheckmHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        NetworkTaskUserPhone networkTaskuserphone = new NetworkTaskUserPhone(api_usersetting_user_phone, null);
                        networkTaskuserphone.execute();
                    }
                });
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDataGusetinfo();
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
            if (msg.what == 1000) {
                Intent intent = new Intent(InfoCheckActivity.this, LanguageSettingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

}

//                AndroidNetworking.initialize (getApplicationContext ());
//
//                AndroidNetworking.post ( "https://hurd.aliseon.com/api/item/tocart")
//                        .addBodyParameter ( "access_token" , access_token)
//                        .addBodyParameter ( "uid", Integer.toString(loginid))
//                        .addBodyParameter ( "lang", "AED")
//                        .addBodyParameter ( "item_id", cartdetail_id)
//                        .addBodyParameter ( "item_name", cartdetail_name)
//                        .addBodyParameter ( "item_price", Double.toString(cartdetail_price))
//                        .addBodyParameter ( "sale_price", Double.toString(cartdetail_sale_price))
//                        .addBodyParameter ( "opt_id", "751")
////                        .addBodyParameter ( "opt_id", "753")
////                        .addBodyParameter ( "opt_id", "755")
//                        .addBodyParameter ( "opt_name", cartdetail_result_item_name.get(0))
//                        .addBodyParameter ( "opt_count", cartdetail_result_item_count.toString())
//                        .addBodyParameter ( "opt_org_price", cartdetail_result_item_price.toString())
//                        .addBodyParameter ( "opt_tot_price", cartdetail_result_item_total.toString())
//                        .setPriority (Priority.MEDIUM)
//                        .build ()
//                        .getAsJSONObject (new JSONObjectRequestListener() {
//                            @Override
//                            public void onResponse (JSONObject response) {
//                                // 응답이있는 작업 수행
//                                Log.d("통신 결과 값 ", ""+ response);
//                            }
//                            @Override
//                            public void onError (ANError error) {
//                                // 오류 처리
//                                Log.d("통신 결과 값 에러 ", ""+ error);
//                            }
//                        });