package com.aliseon.ott.activity;

import android.content.DialogInterface;
import android.content.Intent;
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
import com.aliseon.ott.networktask.NetworkTaskUserPhoneCheckDisconnect2;

import static com.aliseon.ott.Variable.api_usersetting_user_phone;
import static com.aliseon.ott.Variable.userinfouid;
import static com.aliseon.ott.Variable.countrycode;
import static com.aliseon.ott.Variable.phone_number;
import static com.aliseon.ott.Variable.myuid;

public class AccountDisconnect2Activity extends AppCompatActivity {

    public static MyHandler Disconnect2mHandler;

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
        setContentView(R.layout.disconnect_account2);

        builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);

        Disconnect2mHandler = new MyHandler();

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
        spinner1 = (Spinner) findViewById(R.id.disconnectspinner2);

        spinner1.setFocusableInTouchMode(true);
        spinner1.requestFocus();

        //Adapter
        adapterSpinner1 = new AdapterSpinner1(this, Number, CountryImage);

        //Adapter 적용
        spinner1.setAdapter(adapterSpinner1);

        spinner1.requestFocus();

        Button button = (Button) findViewById(R.id.disconnectcancel2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AccountDisconnect2Activity.this, SettingUserManagementActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();

            }
        });

        Button button2 = (Button) findViewById(R.id.disconnectdisconnect2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    Disconnect2mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            EditText editText = (EditText) findViewById(R.id.disconnect_number2);
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

                            myuid = userinfouid.get(1);

                            NetworkTaskUserPhoneCheckDisconnect2 networkTaskuserphonedisconnect2= new NetworkTaskUserPhoneCheckDisconnect2(api_usersetting_user_phone, null);
                            networkTaskuserphonedisconnect2.execute();

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
            Intent intent = new Intent(AccountDisconnect2Activity.this, SettingUserManagementActivity.class);
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
                Intent intent = new Intent(AccountDisconnect2Activity.this, SettingUserManagementActivity.class);
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
