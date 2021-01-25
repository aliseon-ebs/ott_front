package com.aliseon.ott.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AliseonOTTPlayerCartLoginActivity extends AppCompatActivity {

    private AliseonAPI AliseonAPI;

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

        ArrayList<Integer> userinfouid = aliseon.aliseon_getTvott_userinfouid();

        setContentView(R.layout.player_login_cart);

        Button button = (Button) findViewById(R.id.playersubscribelogin);
        button.setNextFocusUpId(R.id.playersubscribelogin);
        button.setNextFocusRightId(R.id.playersubscribelogin);
        button.setNextFocusDownId(R.id.playersubscribelogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userinfouid.size() != 0) {
                    Intent intent = new Intent(AliseonOTTPlayerCartLoginActivity.this, SettingUserManagementActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(AliseonOTTPlayerCartLoginActivity.this, InfoCheckActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }
            }
        });

        button.requestFocus();

    }
}
