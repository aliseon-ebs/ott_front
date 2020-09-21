package com.aliseon.ott.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.aliseon.ott.AdapterSpinner1;
import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskTvottEmptyAdduser;

import java.util.Locale;

import static com.aliseon.ott.Variable.api_tvott_users_add;
import static com.aliseon.ott.Variable.countrycode;
import static com.aliseon.ott.Variable.phone_number;

public class EmptyAddAccountActivity extends AppCompatActivity {

    public static MyHandler EmptyAccountAddmHandler;

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
                EmptyAccountAddmHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        EditText editText = (EditText) findViewById(R.id.addphonenumber);
                        String editTextnumber = editText.getText().toString();
                        defaultcontrycode = spinner1.getSelectedItem().toString();
                        countrycode = defaultcontrycode.substring(1);
                        phone_number = editTextnumber;
                        NetworkTaskTvottEmptyAdduser networkTasktvottemptyadduser = new NetworkTaskTvottEmptyAdduser(api_tvott_users_add, null);
                        networkTasktvottemptyadduser.execute();
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

}
