package com.aliseon.ott.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.aliseon.ott.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.aliseon.ott.Variable.userinfo;

public class EmptySelectAccount1Activity extends AppCompatActivity {

    private static String TAG = "현재 url 가져오기";

    private ArrayList<String> user_cate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_selectuser1);

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

        user_cate = new ArrayList<>();

        user_cate.add(getResources().getString(R.string.subscribe));
        user_cate.add(getResources().getString(R.string.cart));
        user_cate.add(getResources().getString(R.string.language_setting));
        user_cate.add(getResources().getString(R.string.account_management));

        LinearLayout Layout1 = new LinearLayout(this);
        LinearLayout Layout2 = new LinearLayout(this);
        LinearLayout Layout2_1 = new LinearLayout(this);
//        LinearLayout Layout2_2 = new LinearLayout(this);
//        LinearLayout Layout2_3 = new LinearLayout(this);
//        LinearLayout Layout2_4 = new LinearLayout(this);
        LinearLayout Layout3 = new LinearLayout(this);
        LinearLayout Layout4 = new LinearLayout(this);

        Layout1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        Layout1.setLayoutParams(params);

        ImageView Home = new ImageView(this);
        Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
        ImageView Search = new ImageView(this);
        Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
        ImageView User = new ImageView(this);
        User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
        ImageView Cart = new ImageView(this);
        Cart.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.ovalbuttonsetting));
        Cart.setPadding(15,15,15,15);
        ImageView ImageEmpty = new ImageView(this);
        CircleImageView Profile = new CircleImageView(this);
        Home.setPadding(15, 15, 15, 15);
        User.setPadding(15, 15, 15, 15);
        Search.setPadding(15, 15, 15, 15);
        TextView name[] = new TextView[2];
        name[0] = new TextView(this);
        name[1] = new TextView(this);

        ImageView BackArrow = new ImageView(this);
        BackArrow.setFocusableInTouchMode(true);
        BackArrow.setPadding(10, 10, 10, 10);
        BackArrow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));

        BackArrow.setImageResource(R.drawable.backarrow);
        BackArrow.setLayoutParams(new ViewGroup.LayoutParams(60,60));
        BackArrow.setScaleType(ImageView.ScaleType.FIT_CENTER);

        Home.setImageResource(R.drawable.home);
        Search.setImageResource(R.drawable.search);
        User.setImageResource(R.drawable.user);
        ImageEmpty.setImageResource(R.drawable.checkuser);
        Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
        Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
        Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
        User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
        User.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Cart.setImageResource(R.drawable.cart);
        Cart.setLayoutParams(new ViewGroup.LayoutParams(60,60));
        Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageEmpty.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
        ImageEmpty.setPadding(20,20,20,20);
        Profile.setLayoutParams(new ViewGroup.LayoutParams(200, 200));

        ImageEmpty.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
        Profile.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
        ImageEmpty.setPadding(20,20,20,20);
        if (Profile != null) {
            Profile.setPadding(20,20,20,20);
        }

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams paramsBackArrow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.1f);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params3f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
        LinearLayout.LayoutParams params3ff = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.1f);
        LinearLayout.LayoutParams params3_1f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.3f);
        LinearLayout.LayoutParams params3_2f = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.7f);
        LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
        ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
        ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
        ViewGroup.MarginLayoutParams margin3_9 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());

        margin.setMargins(0, 20, 5, 20);
        margin2.setMargins(0, 20, 5, 20);
        margin3.setMargins(0, 20, 5, 20);
        margin3_9.setMargins(0, 20, 5, 20);

        Layout2.setOrientation(LinearLayout.VERTICAL);
        Layout2.setGravity(Gravity.CENTER);
        Layout2.setLayoutParams(params2);
        Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
        Layout2_1.setGravity(Gravity.CENTER);
        Layout2_1.setLayoutParams(paramsBackArrow);
        Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
        Layout4.setBackgroundColor(Color.rgb(29, 29, 29));

//        Layout2_1.setLayoutParams(params2_1);
//        Layout2_1.setLayoutParams(margin);
//
//        Layout2_2.setLayoutParams(params2_1);
//        Layout2_2.setLayoutParams(margin2);
//
//        Layout2_3.setLayoutParams(params2_1);
//        Layout2_3.setLayoutParams(margin3);
//
//        Layout2_4.setLayoutParams(params2_1);
//        Layout2_4.setLayoutParams(margin3_9);

        Layout3.setOrientation(LinearLayout.VERTICAL);
        Layout3.setGravity(Gravity.CENTER);

        Layout3.setLayoutParams(params3);

        Layout4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.backgroundblack));

        LinearLayout Layout3_1 = new LinearLayout(this);
        LinearLayout Layout3_1_1 = new LinearLayout(this);
        LinearLayout Layout3_1_2 = new LinearLayout(this);
        LinearLayout Layout3_2 = new LinearLayout(this);
        LinearLayout Layout3_2_1 = new LinearLayout(this);
        LinearLayout Layout3_2_2 = new LinearLayout(this);
        LinearLayout Layout3_2_3 = new LinearLayout(this);
        LinearLayout Layout3_2_4 = new LinearLayout(this);
        LinearLayout Layout3_3 = new LinearLayout(this);

        Layout3_1.setOrientation(LinearLayout.VERTICAL);
        Layout3_1_1.setGravity(Gravity.CENTER | Gravity.BOTTOM);
        Layout3_1_2.setGravity(Gravity.CENTER | Gravity.TOP);
        Layout3_2.setOrientation(LinearLayout.VERTICAL);
        Layout3_2.setGravity(Gravity.CENTER | Gravity.LEFT);

        TextView TV0 = new TextView(this);
        TextView TV1 = new TextView(this);
        TextView TV2 = new TextView(this);
        TextView TV3 = new TextView(this);

        TV0.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
        TV1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
        TV2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
        TV3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));

//        TV0.setText(user_cate.get(0));
//        TV1.setText(user_cate.get(1));
//        TV2.setText(user_cate.get(2));
//        TV3.setText(user_cate.get(3));

        name[0].setTextColor(Color.rgb(255,255,255));
        name[1].setTextColor(Color.rgb(255,255,255));
        TV0.setTextColor(Color.rgb(255, 255, 255));
        TV1.setTextColor(Color.rgb(255, 255, 255));
        TV2.setTextColor(Color.rgb(255, 255, 255));
        TV3.setTextColor(Color.rgb(255, 255, 255));

        TV0.setPadding(10, 10, 10, 10);
        TV1.setPadding(10, 10, 10, 10);
        TV2.setPadding(10, 10, 10, 10);
        TV3.setPadding(10, 10, 10, 10);



        Layout3_1_1.addView(ImageEmpty);
//        Layout3_1_2.addView(name[0]);
        Layout3_2_1.addView(TV0);
        Layout3_2_2.addView(TV1);
        Layout3_2_3.addView(TV2);
        Layout3_2_4.addView(TV3);

        ViewGroup.MarginLayoutParams margin3_0 = new ViewGroup.MarginLayoutParams(TV0.getLayoutParams());
        ViewGroup.MarginLayoutParams margin3_1 = new ViewGroup.MarginLayoutParams(TV1.getLayoutParams());
        ViewGroup.MarginLayoutParams margin3_2 = new ViewGroup.MarginLayoutParams(TV2.getLayoutParams());
        ViewGroup.MarginLayoutParams margin3_3= new ViewGroup.MarginLayoutParams(TV3.getLayoutParams());

        margin3_0.setMargins(30, 17, 0, 0);
        margin3_1.setMargins(30, 22, 0, 0);
        margin3_2.setMargins(30, 22, 0, 0);
        margin3_3.setMargins(30, 22, 0, 22);


        Layout3_1.setLayoutParams(params3ff);
        Layout3_2.setLayoutParams(params3f);
        Layout3_3.setLayoutParams(params3ff);
        Layout3_1_1.setLayoutParams(params3_1f);
        Layout3_1_2.setLayoutParams(params3_2f);
        Layout3_2_1.setLayoutParams(margin3_0);
        Layout3_2_2.setLayoutParams(margin3_1);
        Layout3_2_3.setLayoutParams(margin3_2);
        Layout3_2_4.setLayoutParams(margin3_3);

        Layout3.addView(Layout3_1);
        Layout3_1.addView(Layout3_1_1);
        Layout3_1.addView(Layout3_1_2);
        Layout3.addView(Layout3_2);
        Layout3_2.addView(Layout3_2_1);
        Layout3_2.addView(Layout3_2_2);
        Layout3_2.addView(Layout3_2_3);
        Layout3_2.addView(Layout3_2_4);
        Layout3.addView(Layout3_3);

        Layout4.setOrientation(LinearLayout.VERTICAL);
        Layout4.setGravity(Gravity.CENTER);
        Layout4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.backgroundblack));

        Layout4.setLayoutParams(params4);

        LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout Layout4_1 = new LinearLayout(this);
        LinearLayout Layout4_2 = new LinearLayout(this);
        LinearLayout Layout4_3 = new LinearLayout(this);
        LinearLayout Layout4_3_1 = new LinearLayout(this);
        LinearLayout Layout4_3_2 = new LinearLayout(this);
        LinearLayout Layout4_4 = new LinearLayout(this);
        LinearLayout Layout4_4_1 = new LinearLayout(this);
        LinearLayout Layout4_4_2 = new LinearLayout(this);
        LinearLayout Layout4_4_3 = new LinearLayout(this);

        Layout4_1.setGravity(Gravity.CENTER);
        Layout4_2.setGravity(Gravity.CENTER);
        Layout4_3.setGravity(Gravity.CENTER);
        Layout4_3_1.setGravity(Gravity.CENTER);
        Layout4_3_2.setGravity(Gravity.CENTER);
        Layout4_4.setGravity(Gravity.CENTER);
        Layout4_4_1.setGravity(Gravity.CENTER);
        Layout4_4_2.setGravity(Gravity.CENTER);
        Layout4_4_3.setGravity(Gravity.CENTER);

        Layout4_3.setOrientation(LinearLayout.VERTICAL);
        Layout4_3_1.setOrientation(LinearLayout.VERTICAL);
        Layout4_3_2.setOrientation(LinearLayout.VERTICAL);
        Layout4_4.setOrientation(LinearLayout.HORIZONTAL);
        Layout4_4_1.setOrientation(LinearLayout.VERTICAL);
        Layout4_4_2.setOrientation(LinearLayout.VERTICAL);
        Layout4_4_3.setOrientation(LinearLayout.VERTICAL);

        TextView TV10 = new TextView(this);
        TextView TV11 = new TextView(this);
        TextView TV12 = new TextView(this);

        Button button1 = new Button(this);
        Button button2 = new Button(this);

        button1.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
        button2.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonsetting));

        button1.setLayoutParams(new ViewGroup.LayoutParams(200,65));
        button2.setLayoutParams(new ViewGroup.LayoutParams(200,65));

        button1.setTextColor(Color.rgb(255,255,255));
        button2.setTextColor(Color.rgb(255,255,255));

        button1.setText(getResources().getString(R.string.cancel));
        button2.setText(getResources().getString(R.string.change));

        button1.setTextSize(10);
        button2.setTextSize(10);

        TV10.setTextSize(30);
        TV10.setTypeface(null, Typeface.BOLD);
        TV11.setTextSize(15);

        TV10.setText(getResources().getString(R.string.accountchangeorremove));
        TV11.setText(getResources().getString(R.string.want_account));
        TV12.setText(getResources().getString(R.string.addaccount));

        TV10.setTextColor(Color.rgb(255, 255, 255));
        TV11.setTextColor(Color.rgb(255, 255, 255));
        TV12.setTextColor(Color.rgb(255, 255, 255));

        TV10.setPadding(10, 10, 10, 10);
        TV11.setPadding(10, 10, 10, 10);

        Layout4_1.addView(TV10);
        Layout4_2.addView(TV11);

        ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
        ViewGroup.MarginLayoutParams margin4_1 = new ViewGroup.MarginLayoutParams(TV11.getLayoutParams());
        ViewGroup.MarginLayoutParams margin4_4 = new ViewGroup.MarginLayoutParams(button2.getLayoutParams());

        margin4.setMargins(0, 0, 0, 60);
        margin4_1.setMargins(0, 60, 0, 0);
        margin4_4.setMargins(50,0,50,0);

        Layout4_1.setLayoutParams(params4_1);
        Layout4_2.setLayoutParams(params4_1);
        Layout4_2.setLayoutParams(margin4);
        Layout4_3.setLayoutParams(params4_1);
        Layout4_3_1.setLayoutParams(params4_1);
        Layout4_3_2.setLayoutParams(params4_1);
        Layout4_4.setLayoutParams(margin4_1);
        Layout4_4_1.setLayoutParams(params4_1);
        Layout4_4_2.setLayoutParams(params4_1);
        Layout4_4_2.setLayoutParams(margin4_4);
        Layout4_4_3.setLayoutParams(params4_1);


        button2.requestFocus();

        Layout1.addView(Layout2);
        Layout2.addView(Layout2_1);

        Layout2_1.addView(BackArrow);

//        Layout2_1.addView(Home);
//        Layout2_2.addView(Search);
//        Layout2_3.addView(User);
//        Layout2_4.addView(Cart);
//
//        Layout2.addView(Layout2_1);
//        Layout2.addView(Layout2_2);
//        Layout2.addView(Layout2_3);
//        Layout2.addView(Layout2_4);

        Glide.with(this).load(userinfo.get(2)).into(Profile);
        name[1].setText(userinfo.get(0));

        name[0].setTextSize(10);
        name[1].setTextSize(10);

        Layout4_3.addView(Layout4_3_1);
        Layout4_3.addView(Layout4_3_2);
        Layout4_3_1.addView(Profile);
        Layout4_3_2.addView(name[1]);
        Layout4_4.addView(Layout4_4_1);
        Layout4_4.addView(Layout4_4_2);
        Layout4_4.addView(Layout4_4_3);
        Layout4_4_1.addView(button1);
        Layout4_4_2.addView(button2);


        Layout4.addView(Layout4_1);
        Layout4.addView(Layout4_2);
        Layout4.addView(Layout4_3);
        Layout4.addView(Layout4_4);

//        Layout1.addView(Layout3);

        Layout1.addView(Layout4);

        setContentView(Layout1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmptySelectAccount1Activity.this, EmptyUserSelectActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmptySelectAccount1Activity.this, EmptyChangeAccount1Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
//                finish();
            }
        });

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
