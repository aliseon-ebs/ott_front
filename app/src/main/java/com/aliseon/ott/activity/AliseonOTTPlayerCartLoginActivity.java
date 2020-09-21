package com.aliseon.ott.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.aliseon.ott.R;

import static com.aliseon.ott.Variable.userinfouid;

public class AliseonOTTPlayerCartLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
