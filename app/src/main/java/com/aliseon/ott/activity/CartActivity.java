package com.aliseon.ott.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.aliseon.ott.API.Cart;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.AliseonAPI;
import com.aliseon.ott.R;
import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.aliseon.ott.API.Cart;

public class CartActivity extends AppCompatActivity {

    public static CartActivityCartHandler cartactivitycarthandler;
    static CartActivityCartDeleteHandler cartactivitycartdeletehandler;

    private AliseonAPI AliseonAPI;
    private static String TAG = "현재 url 가져오기";

    ImageView Cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();
        Integer cartapiload = aliseon.aliseon_getCartAPIload();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        if(cartapiload == 0) {

        SharedPreferences prf = getSharedPreferences("login_session", MODE_PRIVATE);

        switch (prf.getString("language", "")) {
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
        }

            Log.d("cartactivitydetail", "create0");

            cartactivitycarthandler = new CartActivityCartHandler();
            cartactivitycartdeletehandler = new CartActivityCartDeleteHandler();

            cartactivitycarthandler.post(new Runnable() {
                @Override
                public void run() {
                    CartPost();
                }
            });

            LinearLayout Layout1 = new LinearLayout(this);
            LinearLayout Layout2 = new LinearLayout(this);
            LinearLayout Layout2_1 = new LinearLayout(this);
            LinearLayout Layout2_2 = new LinearLayout(this);
            LinearLayout Layout2_1_1 = new LinearLayout(this);
            LinearLayout Layout2_1_2 = new LinearLayout(this);
            LinearLayout Layout2_1_3 = new LinearLayout(this);
            LinearLayout Layout2_1_4 = new LinearLayout(this);
            LinearLayout Layout2_1_5 = new LinearLayout(this);
            LinearLayout Layout2_2_1 = new LinearLayout(this);
            LinearLayout Layout3 = new LinearLayout(this);
            LinearLayout Layout3_1 = new LinearLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this);
            LinearLayout Layout3_3 = new LinearLayout(this);
            LinearLayout Layout3_4 = new LinearLayout(this);
            LinearLayout Layout4 = new LinearLayout(this);
            LinearLayout Layout4_1 = new LinearLayout(this);
            LinearLayout Layout4_1_1 = new LinearLayout(this);

            ScrollView scrollview = new ScrollView(this);


            ImageView Home = new ImageView(this);
//            Home.setFocusableInTouchMode(true);
            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Search = new ImageView(this);
//            Search.setFocusableInTouchMode(true);
            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView User = new ImageView(this);
//            User.setFocusableInTouchMode(true);
            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Cart = new ImageView(this);
            Cart.setFocusableInTouchMode(true);
            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            CircleImageView My = new CircleImageView(this);
//            My.setFocusableInTouchMode(true);
            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Setting = new ImageView(this);
//            Setting.setFocusableInTouchMode(true);
            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            Cart.setPadding(15, 15, 15, 15);
            if(My != null){
                My.setPadding(15, 15, 15, 15);
            }Setting.setPadding(15, 15, 15, 15);

            ImageView CartTitle = new ImageView(this);
            ImageView CartContent1 = new ImageView(this);
            ImageView CartContent2 = new ImageView(this);
            ImageView CartImage = new ImageView(this);
            TextView CartList = new TextView(this);
            TextView CartListContent = new TextView(this);

            ImageView CartNoList = new ImageView(this);

            scrollview.setVerticalScrollBarEnabled(false);

            Home.setId(R.id.carthome);
            Search.setId(R.id.cartsearch);
            User.setId(R.id.cartuser);
            Cart.setId(R.id.cartcart);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            Home.setImageResource(R.drawable.home);
            Search.setImageResource(R.drawable.search);
            User.setImageResource(R.drawable.user);
            Cart.setImageResource(R.drawable.cart);
            CartImage.setImageResource(R.drawable.noing_ract);
            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));

            if (prf.getString("userinfo_picture", "").equals("empty")) {
                if (My != null) {
                    My.setImageResource(R.drawable.noimg_profile);
                }
            } else {
                Glide.with(this).load(imageurl + prf.getString("userinfo_picture", "")).into(My);
            }

            Setting.setImageResource(R.drawable.setting);
            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);

            CartTitle.setImageResource(R.drawable.noing_category);
            CartTitle.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            CartTitle.setScaleType(ImageView.ScaleType.FIT_CENTER);
            CartContent1.setImageResource(R.drawable.noing_category);
            CartContent1.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            CartContent1.setScaleType(ImageView.ScaleType.FIT_CENTER);
            CartContent2.setImageResource(R.drawable.noing_category);
            CartContent2.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            CartContent2.setScaleType(ImageView.ScaleType.FIT_CENTER);

            CartList.setTextColor(Color.rgb(255, 255, 255));
            CartList.setTextSize(15);
            CartListContent.setText("카트에 담긴 상품이 없습니다.");
            CartListContent.setTextColor(Color.rgb(255, 255, 255));
            CartListContent.setTextSize(14);

            CartNoList.setImageResource(R.drawable.noing_category);
            CartNoList.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            CartNoList.setScaleType(ImageView.ScaleType.FIT_CENTER);

            CartImage.setLayoutParams(new ViewGroup.LayoutParams(300, 367));

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(350, 135);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(350, 367);
            LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(350, 100);
            LinearLayout.LayoutParams params3_4 = new LinearLayout.LayoutParams(350, 100);
            LinearLayout.LayoutParams params3_9 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 456);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 456);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);
            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params4_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1000);
            LinearLayout.LayoutParams paramsline = new LinearLayout.LayoutParams(1320, 1);
            LinearLayout.LayoutParams paramsfor = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200);
            LinearLayout.LayoutParams params4_3_1 = new LinearLayout.LayoutParams(220, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4_3_2 = new LinearLayout.LayoutParams(650, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4_3_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params4_3_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

            paramsTitleTV.bottomMargin = 10;
            paramsMainLayout.leftMargin = 15;
            paramsMainLayout.rightMargin = 15;

            params3_1.rightMargin = 25;
            params3_1.topMargin = 20;

            params3_2.bottomMargin = 20;

            params3_3.rightMargin = 25;
            params3_3.topMargin = 5;
            params3_4.rightMargin = 25;

            params3_9.bottomMargin = 30;

            params3_3.topMargin = 50;

            params4_1.bottomMargin = 20;
            paramsline.leftMargin = 30;

            params4_3_1.leftMargin = 30;
            params4_3_1.topMargin = 30;

            params4_3_2.topMargin = 30;

            params4_3_3.topMargin = 15;
            params4_3_3.leftMargin = 50;

            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());

            margin.setMargins(10, 20, 5, 20);
            margin2.setMargins(10, 20, 5, 20);
            margin3.setMargins(10, 20, 5, 20);
            margin4.setMargins(10, 20, 5, 20);
            margin5.setMargins(0, 20, 5, 20);
            margin6.setMargins(10, 20, 20, 20);

            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout2.setLayoutParams(params2);
            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
            Layout4_1_1.setBackgroundColor(Color.rgb(38, 38, 38));

            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3.setGravity(Gravity.TOP | Gravity.CENTER);

            Layout4.setOrientation(LinearLayout.VERTICAL);

            Layout2_1.setLayoutParams(params2_1);

            Layout2_2.setLayoutParams(params2_1);
            Layout2_2.setGravity(Gravity.BOTTOM);

            Layout2_1_1.setLayoutParams(params2_2);
            Layout2_1_1.setLayoutParams(margin);
            Layout2_1_2.setLayoutParams(params2_2);
            Layout2_1_2.setLayoutParams(margin2);
            Layout2_1_3.setLayoutParams(params2_2);
            Layout2_1_3.setLayoutParams(margin3);
            Layout2_1_4.setLayoutParams(params2_2);
            Layout2_1_4.setLayoutParams(margin4);
            Layout2_1_5.setLayoutParams(params2_2);
            Layout2_1_5.setLayoutParams(margin5);

            Layout2_2_1.setLayoutParams(params2_2);
            Layout2_2_1.setLayoutParams(margin6);

            Layout3.setLayoutParams(params3);

            Layout1.addView(Layout2);

            Layout2_1.addView(Layout2_1_1);
            Layout2_1.addView(Layout2_1_2);
            Layout2_1.addView(Layout2_1_3);
            Layout2_1.addView(Layout2_1_4);
            Layout2_1.addView(Layout2_1_5);

            Layout2_1_1.addView(Home);
            Layout2_1_2.addView(Search);
            Layout2_1_3.addView(User);
            Layout2_1_4.addView(Cart);
            Layout2_1_5.addView(My);
            Layout2_2_1.addView(Setting);

            Layout2_1.setOrientation(LinearLayout.VERTICAL);
            Layout2_2.setOrientation(LinearLayout.VERTICAL);

            Layout2_2.addView(Layout2_2_1);

            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            Layout3_1.setLayoutParams(params3_1);
            Layout3_2.setLayoutParams(params3_2);
            Layout3_3.setLayoutParams(params3_3);
            Layout3_4.setLayoutParams(params3_4);
            Layout3_1.addView(CartTitle);
            Layout3_2.addView(CartImage);
            Layout3_3.addView(CartContent1);
            Layout3_4.addView(CartContent2);

            Layout3.addView(Layout3_1);
            Layout3.addView(Layout3_2);
            Layout3.addView(Layout3_3);
            Layout3.addView(Layout3_4);

            Layout4_1.setLayoutParams(params4_1);
            Layout4_1.setGravity(Gravity.BOTTOM);
            Layout4_1_1.setLayoutParams(paramsline);
            Layout4_1.addView(CartNoList);
            Layout4.addView(Layout4_1);
            Layout4.addView(Layout4_1_1);
            for (int i = 0; i < 5; i++) {

                LinearLayout Layout4_3 = new LinearLayout(this);
                LinearLayout Layout4_3_1 = new LinearLayout(this);
                LinearLayout Layout4_3_2 = new LinearLayout(this);
                LinearLayout Layout4_3_2_1 = new LinearLayout(this);
                LinearLayout Layout4_3_2_2 = new LinearLayout(this);
                LinearLayout Layout4_3_2_3 = new LinearLayout(this);
                LinearLayout Layout4_3_3 = new LinearLayout(this);

                ImageView IV = new ImageView(this);
                Button button = new Button(this);
                ImageView IV1 = new ImageView(this);
                ImageView IV2 = new ImageView(this);
                ImageView IV3 = new ImageView(this);

                IV.setLayoutParams(new ViewGroup.LayoutParams(220, 220));

                IV1.setImageResource(R.drawable.noing_category);
                IV1.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
                IV1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                IV2.setImageResource(R.drawable.noing_category);
                IV2.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
                IV2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                IV3.setImageResource(R.drawable.noing_category);
                IV3.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
                IV3.setScaleType(ImageView.ScaleType.FIT_CENTER);


                Layout4_3.setLayoutParams(paramsfor);
                IV.setImageResource(R.drawable.noing_ract);
                CartList.setText("Cart(" + (i + 1) + ")");
                button.setBackground(ContextCompat.getDrawable(this, R.drawable.noingbutton));
                button.setLayoutParams(new ViewGroup.LayoutParams(200, 65));
                button.setTextColor(Color.rgb(255, 255, 255));
                button.setTextSize(10);

                Layout4_3_1.setLayoutParams(params4_3_1);
                Layout4_3_2.setLayoutParams(params4_3_2);
                Layout4_3_2_1.setLayoutParams(params4_3_2_1);
                Layout4_3_2_2.setLayoutParams(params4_3_2_1);
                Layout4_3_2_3.setLayoutParams(params4_3_2_1);
                Layout4_3_3.setLayoutParams(params4_3_3);

                Layout4_3_2.setGravity(Gravity.CENTER);
                Layout4_3_3.setGravity(Gravity.CENTER);
                Layout4_3_2_1.setGravity(Gravity.LEFT | Gravity.CENTER);
                Layout4_3_2_2.setGravity(Gravity.LEFT | Gravity.CENTER);
                Layout4_3_2_3.setGravity(Gravity.LEFT | Gravity.CENTER);

                Layout4_3_2.setFocusableInTouchMode(true);

                Layout4_3_1.addView(IV);
                Layout4_3_2_1.addView(IV1);
                Layout4_3_2_2.addView(IV2);
                Layout4_3_2_3.addView(IV3);
                Layout4_3_3.addView(button);

                Layout4_3_2.setOrientation(LinearLayout.VERTICAL);
                Layout4_3_2.addView(Layout4_3_2_1);
                Layout4_3_2.addView(Layout4_3_2_2);
                Layout4_3_2.addView(Layout4_3_2_3);
                Layout4_3.addView(Layout4_3_1);
                Layout4_3.addView(Layout4_3_2);
                Layout4_3.addView(Layout4_3_3);
                Layout4.addView(Layout4_3);

            }

            Layout1.addView(Layout3);

            Layout1.addView(Layout4);

            setContentView(Layout1);

            Cart.requestFocus();

            Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                @Override
                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                    if (hasFocus == false) {
                        Cart.setImageResource(R.drawable.cart);

                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Cart.setImageResource(R.drawable.cart);
//                                Search.setImageResource(R.drawable.searchselect);
                                    Intent intent = new Intent(CartActivity.this, HomeActivity.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                    Home.setImageResource(R.drawable.home);
                                }
                            }
                        });

                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Cart.setImageResource(R.drawable.cart);
//                                Search.setImageResource(R.drawable.searchselect);
                                    Intent intent = new Intent(CartActivity.this, VoyageActivity.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                    Search.setImageResource(R.drawable.search);
                                }
                            }
                        });

                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Cart.setImageResource(R.drawable.cart);
//                                User.setImageResource(R.drawable.userselect);
                                    Intent intent = new Intent(CartActivity.this, SubscribeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                    User.setImageResource(R.drawable.user);
                                }
                            }
                        });

                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(CartActivity.this, MyActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                }
                            }
                        });

                        Setting.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
//                                    Intent intent = new Intent(CartActivity.this, SettingUserManagementActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                    startActivity(intent);
//                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                }
                            }
                        });

                    } else {
                    }
                }
            });

        }

    }

    @Override
    protected void onResume(){
        super.onResume();

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();
        String imageurl = aliseon.aliseon_getImageURL();
        Integer cartapiload = aliseon.aliseon_getCartAPIload();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        String logincurrency = aliseon.aliseon_getLogincurrency();

        ArrayList<String> cart_shop_id = aliseon.aliseon_getCart_shop_id();
        ArrayList<String> cart_shop_photo = aliseon.aliseon_getCart_shop_photo();
        ArrayList<String> cart_shop_shop_name = aliseon.aliseon_getCart_shop_name();
        ArrayList<ArrayList<String>> cart_items_p_cart_id = aliseon.aliseon_getCart_items_p_cart_id();
        ArrayList<ArrayList<String>> cart_items_p_thumbnail = aliseon.aliseon_getCart_items_p_thumbnail();
        ArrayList<ArrayList<String>> cart_items_p_name = aliseon.aliseon_getCart_items_p_name();
        ArrayList<ArrayList<String>> cart_items_p_previous_price = aliseon.aliseon_getCart_items_p_previous_price();
        ArrayList<ArrayList<String>> cart_items_p_price = aliseon.aliseon_getCart_items_p_price();
        ArrayList<ArrayList<String>> cart_items_p_product_id = aliseon.aliseon_getCart_items_p_product_id();
        ArrayList<ArrayList<String>> cart_items_p_option_value = aliseon.aliseon_getCart_items_p_price();

        if(cartapiload == 1){

            Log.d("cartactivitydetail", "resume1");

            SharedPreferences prf = getSharedPreferences("login_session", MODE_PRIVATE);

            switch (prf.getString("language", "")) {
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
            }

            LinearLayout Layout1 = new LinearLayout(this);
            LinearLayout Layout2 = new LinearLayout(this);
            LinearLayout Layout2_1 = new LinearLayout(this);
            LinearLayout Layout2_2 = new LinearLayout(this);
            LinearLayout Layout2_1_1 = new LinearLayout(this);
            LinearLayout Layout2_1_2 = new LinearLayout(this);
            LinearLayout Layout2_1_3 = new LinearLayout(this);
            LinearLayout Layout2_1_4 = new LinearLayout(this);
            LinearLayout Layout2_1_5 = new LinearLayout(this);
            LinearLayout Layout2_2_1 = new LinearLayout(this);
            LinearLayout Layout3 = new LinearLayout(this);
            LinearLayout Layout3_1 = new LinearLayout(this);
            LinearLayout Layout3_2 = new LinearLayout(this);
            LinearLayout Layout3_3 = new LinearLayout(this);
            LinearLayout Layout4 = new LinearLayout(this);
            LinearLayout Layout4_1 = new LinearLayout(this);
            LinearLayout Layout4_1_1 = new LinearLayout(this);
            LinearLayout Layout4_2 = new LinearLayout(this);

            ScrollView scrollview = new ScrollView(this);


            ImageView Home = new ImageView(this);
            Home.setFocusableInTouchMode(true);
            Home.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Search = new ImageView(this);
            Search.setFocusableInTouchMode(true);
            Search.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView User = new ImageView(this);
            User.setFocusableInTouchMode(true);
            User.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Cart = new ImageView(this);
            Cart.setFocusableInTouchMode(true);
            Cart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            CircleImageView My = new CircleImageView(this);
            My.setFocusableInTouchMode(true);
            My.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            ImageView Setting = new ImageView(this);
            Setting.setFocusableInTouchMode(true);
            Setting.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
            Home.setPadding(15, 15, 15, 15);
            User.setPadding(15, 15, 15, 15);
            Search.setPadding(15, 15, 15, 15);
            Cart.setPadding(15, 15, 15, 15);
            My.setPadding(15, 15, 15, 15);
            Setting.setPadding(15, 15, 15, 15);

            TextView CartTitle = new TextView(this);
            ImageView CartImage = new ImageView(this);
            TextView CartContent = new TextView(this);
            TextView CartList = new TextView(this);
            TextView CartListContent = new TextView(this);

            ImageView CartNoList = new ImageView(this);

            scrollview.setVerticalScrollBarEnabled(false);

            Home.setId(R.id.carthome);
            Search.setId(R.id.cartsearch);
            User.setId(R.id.cartuser);
            Cart.setId(R.id.cartcart);

            Layout1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Layout1.setLayoutParams(params);

            Home.setImageResource(R.drawable.home);
            Search.setImageResource(R.drawable.search);
            User.setImageResource(R.drawable.user);
            Cart.setImageResource(R.drawable.cart);
            CartImage.setImageResource(R.drawable.phoneimage);
            Home.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Home.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Search.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Search.setScaleType(ImageView.ScaleType.FIT_CENTER);
            User.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            User.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Cart.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Cart.setScaleType(ImageView.ScaleType.FIT_CENTER);
            My.setLayoutParams(new ViewGroup.LayoutParams(80, 80));

            if (prf.getString("userinfo_picture", "").equals("empty")) {
                My.setImageResource(R.drawable.noimg_profile);
            } else {
                Glide.with(this).load(imageurl + prf.getString("userinfo_picture", "")).into(My);
            }

            Setting.setImageResource(R.drawable.setting);
            Setting.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            Setting.setScaleType(ImageView.ScaleType.FIT_CENTER);

            CartTitle.setText("모바일 결제안내");
            CartContent.setText("장바구니에 담긴 상품은 모바일 어플리케이션에서 회원님의 계정 장바구니에 동일하게 담깁니다.\n\n주문 · 옵션 수량은 모바일 어플리케이션에서 변경 할 수 있습니다.");
            CartTitle.setTextColor(Color.rgb(255, 255, 255));
            CartContent.setTextColor(Color.rgb(255, 255, 255));
            CartTitle.setTextSize(14);
            CartTitle.setPadding(10, 33, 0, 0);
            CartContent.setTextSize(10);

            CartList.setTextColor(Color.rgb(255, 255, 255));
            CartList.setTextSize(15);
            CartListContent.setText("카트에 담긴 상품이 없습니다.");
            CartListContent.setTextColor(Color.rgb(255, 255, 255));
            CartListContent.setTextSize(14);

            CartNoList.setImageResource(R.drawable.noing_category);
            CartNoList.setLayoutParams(new ViewGroup.LayoutParams(300, 56));
            CartNoList.setScaleType(ImageView.ScaleType.FIT_CENTER);

            CartImage.setLayoutParams(new ViewGroup.LayoutParams(300, 367));

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(90, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams params2_2 = new LinearLayout.LayoutParams(90, 90);
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(450, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params3_1 = new LinearLayout.LayoutParams(350, 150);
            LinearLayout.LayoutParams params3_2 = new LinearLayout.LayoutParams(350, 370);
            LinearLayout.LayoutParams params3_3 = new LinearLayout.LayoutParams(350, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params3_9 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 456);
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams paramsMainLayout = new LinearLayout.LayoutParams(420, 456);
            LinearLayout.LayoutParams paramsTitleTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);
            LinearLayout.LayoutParams params4_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
            LinearLayout.LayoutParams params4_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1000);
            LinearLayout.LayoutParams paramsline = new LinearLayout.LayoutParams(1320, 1);
            LinearLayout.LayoutParams paramsfor = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params4_3_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150);
            LinearLayout.LayoutParams params4_3_1_1 = new LinearLayout.LayoutParams(150, 150);
            LinearLayout.LayoutParams params4_3_1_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4_4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params4_4_1 = new LinearLayout.LayoutParams(220, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4_4_2 = new LinearLayout.LayoutParams(850, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams params4_4_2_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params4_4_2_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params4_4_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

            paramsTitleTV.bottomMargin = 10;
            paramsMainLayout.leftMargin = 15;
            paramsMainLayout.rightMargin = 15;

            params3_9.bottomMargin = 30;

            params3_3.topMargin = 60;

            params4_1.leftMargin = 27;
            params4_1.bottomMargin = 20;

            params4_4.topMargin = 10;
            params4_4.bottomMargin = 10;
            params4_4.leftMargin = 25;

            paramsline.leftMargin = 30;

            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(Home.getLayoutParams());
            ViewGroup.MarginLayoutParams margin2 = new ViewGroup.MarginLayoutParams(Search.getLayoutParams());
            ViewGroup.MarginLayoutParams margin3 = new ViewGroup.MarginLayoutParams(User.getLayoutParams());
            ViewGroup.MarginLayoutParams margin4 = new ViewGroup.MarginLayoutParams(Cart.getLayoutParams());
            ViewGroup.MarginLayoutParams margin5 = new ViewGroup.MarginLayoutParams(My.getLayoutParams());
            ViewGroup.MarginLayoutParams margin6 = new ViewGroup.MarginLayoutParams(Setting.getLayoutParams());

            margin.setMargins(10, 20, 5, 20);
            margin2.setMargins(10, 20, 5, 20);
            margin3.setMargins(10, 20, 5, 20);
            margin4.setMargins(10, 20, 5, 20);
            margin5.setMargins(0, 20, 5, 20);
            margin6.setMargins(10, 20, 20, 20);

            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setGravity(Gravity.CENTER | Gravity.TOP);
            Layout2.setLayoutParams(params2);
            Layout2.setBackgroundColor(Color.rgb(0, 0, 0));
            Layout3.setBackgroundColor(Color.rgb(29, 29, 29));
            Layout4_1_1.setBackgroundColor(Color.rgb(255, 255, 255));

            Layout3.setOrientation(LinearLayout.VERTICAL);
            Layout3.setGravity(Gravity.TOP | Gravity.CENTER);

            Layout4.setOrientation(LinearLayout.VERTICAL);

            Layout2_1.setLayoutParams(params2_1);

            Layout2_2.setLayoutParams(params2_1);
            Layout2_2.setGravity(Gravity.BOTTOM);

            Layout2_1_1.setLayoutParams(params2_2);
            Layout2_1_1.setLayoutParams(margin);
            Layout2_1_2.setLayoutParams(params2_2);
            Layout2_1_2.setLayoutParams(margin2);
            Layout2_1_3.setLayoutParams(params2_2);
            Layout2_1_3.setLayoutParams(margin3);
            Layout2_1_4.setLayoutParams(params2_2);
            Layout2_1_4.setLayoutParams(margin4);
            Layout2_1_5.setLayoutParams(params2_2);
            Layout2_1_5.setLayoutParams(margin5);

            Layout2_2_1.setLayoutParams(params2_2);
            Layout2_2_1.setLayoutParams(margin6);

            Layout3.setLayoutParams(params3);
            Layout4.setLayoutParams(params4);

            Layout1.addView(Layout2);

            Layout2_1.addView(Layout2_1_1);
            Layout2_1.addView(Layout2_1_2);
            Layout2_1.addView(Layout2_1_3);
            Layout2_1.addView(Layout2_1_4);
            Layout2_1.addView(Layout2_1_5);

            Layout2_1_1.addView(Home);
            Layout2_1_2.addView(Search);
            Layout2_1_3.addView(User);
            Layout2_1_4.addView(Cart);
            Layout2_1_5.addView(My);
            Layout2_2_1.addView(Setting);

            Layout2_1.setOrientation(LinearLayout.VERTICAL);
            Layout2_2.setOrientation(LinearLayout.VERTICAL);

            Layout2_2.addView(Layout2_2_1);

            Layout2.addView(Layout2_1);
            Layout2.addView(Layout2_2);

            Layout3_1.setLayoutParams(params3_1);
            Layout3_2.setLayoutParams(params3_2);
            Layout3_3.setLayoutParams(params3_3);
            Layout3_1.addView(CartTitle);
            Layout3_2.addView(CartImage);
            Layout3_3.addView(CartContent);

            Layout3.addView(Layout3_1);
            Layout3.addView(Layout3_2);
            Layout3.addView(Layout3_3);

            Log.d("CARTDATACHECK", String.valueOf(cart_shop_id));

            if (cart_shop_id.size() == 0) {

                int i = 0;
                CartList.setText("Cart (" + i + ")");
                Layout4_1.setLayoutParams(params4_1);
                Layout4_1.setGravity(Gravity.BOTTOM);
                Layout4_1_1.setLayoutParams(paramsline);
                Layout4_2.setLayoutParams(params4_2);
                Layout4_1.addView(CartList);
                Layout4_2.addView(CartListContent);
                Layout4_2.setGravity(Gravity.CENTER | Gravity.CENTER);

                Layout4.addView(Layout4_1);
                Layout4.addView(Layout4_1_1);
                Layout4.addView(Layout4_2);
            } else {

                Layout4_1.setLayoutParams(params4_1);
                Layout4_1.setGravity(Gravity.BOTTOM);
                Layout4_1_1.setLayoutParams(paramsline);
                Layout4_1.addView(CartList);
                Layout4.addView(Layout4_1);
                Layout4.addView(Layout4_1_1);

                for (int i = 0; i < cart_shop_id.size(); i++) {

                    LinearLayout Layout4_3 = new LinearLayout(this);
                    LinearLayout Layout4_3_1 = new LinearLayout(this);
                    LinearLayout Layout4_3_1_1 = new LinearLayout(this);
                    LinearLayout Layout4_3_1_2 = new LinearLayout(this);
                    LinearLayout Layout4_3_2 = new LinearLayout(this);

                    CircleImageView shop_profile = new CircleImageView(this);
                    TextView shop_name = new TextView(this);

                    shop_profile.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
                    Glide.with(this).load(imageurl + cart_shop_photo.get(i)).into(shop_profile);

                    shop_name.setText(cart_shop_shop_name.get(i));
                    shop_name.setTextColor(Color.rgb(255, 255, 255));
                    shop_name.setTextSize(20);

                    Layout4_3.setOrientation(LinearLayout.VERTICAL);
                    Layout4_3_1.setOrientation(LinearLayout.HORIZONTAL);
                    Layout4_3_1_1.setOrientation(LinearLayout.VERTICAL);
                    Layout4_3_1_2.setOrientation(LinearLayout.VERTICAL);
                    Layout4_3_2.setOrientation(LinearLayout.VERTICAL);

                    Layout4_3_1_1.setGravity(Gravity.CENTER);
                    Layout4_3_1_2.setGravity(Gravity.CENTER);

                    Layout4_3.setLayoutParams(paramsfor);
                    Layout4_3_1.setLayoutParams(params4_3_1);
                    Layout4_3_1_1.setLayoutParams(params4_3_1_1);
                    Layout4_3_1_2.setLayoutParams(params4_3_1_2);
                    Layout4_3_2.setLayoutParams(paramsfor);

                    Layout4_3_1_1.addView(shop_profile);
                    Layout4_3_1_2.addView(shop_name);

                    Layout4_3_1.addView(Layout4_3_1_1);
                    Layout4_3_1.addView(Layout4_3_1_2);

                    Layout4_3.addView(Layout4_3_1);
                    Layout4_3.addView(Layout4_3_2);

                    final int j = i;

                    //--------------------------------------------------------------------------------------------------------//

                    for (int ii = 0; ii < cart_items_p_cart_id.get(i).size(); ii++) {

                        LinearLayout Layout4_4 = new LinearLayout(this);
                        LinearLayout Layout4_4_1 = new LinearLayout(this);
                        LinearLayout Layout4_4_2 = new LinearLayout(this);
                        LinearLayout Layout4_4_2_1 = new LinearLayout(this);
                        LinearLayout Layout4_4_2_2 = new LinearLayout(this);
                        LinearLayout Layout4_4_2_3 = new LinearLayout(this);
                        LinearLayout Layout4_4_2_4 = new LinearLayout(this);
                        LinearLayout Layout4_4_3 = new LinearLayout(this);

                        ImageView IV = new ImageView(this);
                        TextView TV1 = new TextView(this);
                        TextView TV2 = new TextView(this);
                        TextView TV3_1 = new TextView(this);
                        TextView TV3_2 = new TextView(this);
                        TextView TV3_3 = new TextView(this);
                        TextView TV4 = new TextView(this);
                        Button button = new Button(this);

                        String currency;

                        Layout4_4_2.setNextFocusLeftId(R.id.cartcart);

                        if (i == 0 && ii == 0) {
                            Layout4_4_2.setId(R.id.cart1);
                            button.setId(R.id.cart2);
                            Layout4_4_2.setNextFocusUpId(R.id.cart1);
                            button.setNextFocusUpId(R.id.cart2);
                        }

                        if (i == cart_shop_id.size() - 1 && ii == cart_items_p_cart_id.get(i).size() - 1) {
                            Layout4_4_2.setId(R.id.cart1);
                            button.setId(R.id.cart2);
                            Layout4_4_2.setNextFocusDownId(R.id.cart1);
                            button.setNextFocusDownId(R.id.cart2);
                        }

                        IV.setLayoutParams(new ViewGroup.LayoutParams(220, 220));
                        IV.setScaleType(ImageView.ScaleType.FIT_XY);

                        Layout4_4.setLayoutParams(params4_4);
                        Layout4_4.setGravity(Gravity.CENTER);
                        Glide.with(this).load(imageurl + cart_items_p_thumbnail.get(i).get(ii)).into(IV);
                        TV1.setText(cart_items_p_name.get(i).get(ii));
                        TV2.setText(cart_items_p_name.get(i).get(ii));
                        //                    TV3.setText(cart_item_price.get(i) + "  " + prf.getString("currency", ""));
                        TV3_1.setText(cart_items_p_previous_price.get(i).get(ii));
                        TV3_1.setTextSize(16);
                        TV3_1.setTextColor(Color.rgb(150, 150, 150));
                        TV3_1.setPadding(30, 0, 0, 0);
                        TV3_2.setText("   ➝   " + cart_items_p_price.get(i).get(ii));
                        TV1.setTextColor(Color.rgb(255, 255, 255));
                        TV2.setTextColor(Color.rgb(255, 255, 255));
                        TV3_2.setTextColor(Color.rgb(204, 51, 51));
                        TV1.setPadding(30, 30, 0, 0);
                        TV2.setPadding(30, 0, 0, 0);
                        TV1.setTextSize(14);
                        TV2.setTextSize(12);
                        TV3_2.setTextSize(16);
                        TV3_1.setTypeface(null, Typeface.BOLD);
                        TV3_2.setTypeface(null, Typeface.BOLD);
                        TV3_1.setPaintFlags(TV3_1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        currency = logincurrency.toUpperCase();
                        TV3_3.setText(" " + currency);
                        TV3_3.setTextColor(Color.rgb(255, 255, 255));
                        TV3_3.setTextSize(16);
                        TV3_3.setTypeface(null, Typeface.BOLD);
                        TV4.setText(cart_items_p_option_value.get(i).get(ii));
                        TV4.setTextColor(Color.rgb(255, 255, 255));
                        TV4.setPadding(30, 15, 0, 30);
                        TV4.setTextSize(12);
                        button.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonsetting));
                        button.setLayoutParams(new ViewGroup.LayoutParams(200, 65));
                        button.setText(getResources().getString(R.string.delete));
                        button.setTextColor(Color.rgb(255, 255, 255));
                        button.setTextSize(10);

                        Layout4_4_1.setLayoutParams(params4_4_1);
                        Layout4_4_2.setLayoutParams(params4_4_2);
                        Layout4_4_2_1.setLayoutParams(params4_4_2_1);
                        Layout4_4_2_2.setLayoutParams(params4_4_2_1);
                        Layout4_4_2_3.setLayoutParams(params4_4_2_1);
                        Layout4_4_2_4.setLayoutParams(params4_4_2_2);
                        Layout4_4_3.setLayoutParams(params4_4_3);

                        Layout4_4_1.setGravity(Gravity.TOP);
                        Layout4_4_2.setGravity(Gravity.LEFT|Gravity.CENTER);
                        Layout4_4_3.setGravity(Gravity.CENTER);
                        Layout4_4_2_1.setGravity(Gravity.LEFT | Gravity.TOP);
                        Layout4_4_2_2.setGravity(Gravity.LEFT | Gravity.TOP);
                        Layout4_4_2_3.setGravity(Gravity.LEFT | Gravity.TOP);
                        Layout4_4_2_4.setGravity(Gravity.LEFT | Gravity.CENTER);

                        Layout4_4_2_3.setOrientation(LinearLayout.HORIZONTAL);
                        Layout4_4_2_4.setOrientation(LinearLayout.HORIZONTAL);

                        Layout4_4_2.setFocusableInTouchMode(true);

                        Layout4_4_1.addView(IV);
                        Layout4_4_2.addView(TV1);
                        Layout4_4_2.addView(TV2);
                        Layout4_4_2_3.addView(TV3_1);
                        Layout4_4_2_3.addView(TV3_2);
                        Layout4_4_2_3.addView(TV3_3);
                        Layout4_4_2_4.addView(TV4);
                        Layout4_4_3.addView(button);

                        Layout4_4_2.setOrientation(LinearLayout.VERTICAL);
                        Layout4_4_2.addView(Layout4_4_2_3);

                        Layout4_4_2.addView(Layout4_4_2_4);
                        Layout4_4.addView(Layout4_4_1);
                        Layout4_4.addView(Layout4_4_2);
                        Layout4_4.addView(Layout4_4_3);
                        Layout4_3_2.addView(Layout4_4);

                        final int jj = ii;

                        Layout4_4_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

//                                Aliseon aliseon =(Aliseon) getApplicationContext();

                                Intent intent = new Intent(CartActivity.this, CartDetailActivity.class);
                                aliseon.aliseon_setParam_product_id(cart_items_p_product_id.get(j).get(jj));
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                                overridePendingTransition(0, 0);
                            }
                        });


                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                cartactivitycartdeletehandler.post(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                                                            param_cart_id = cart_id.get(ii);
//                                                                            param_opt_id = "";
//                                                                            NetworkTaskTvottDelcart networktasktvottdelcart = new NetworkTaskTvottDelcart(api_tvott_delcart, null);
//                                                                            networktasktvottdelcart.execute();
//                                    }
//                                });
                            }
                        });

                        Layout4_4_2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus == false) {
                                    Layout4_4_2.setBackground(null);
                                    TV1.setTextColor(Color.rgb(255, 255, 255));
                                    TV2.setTextColor(Color.rgb(255, 255, 255));
                                    TV3_1.setTextColor(Color.rgb(150, 150, 150));
                                    TV3_2.setTextColor(Color.rgb(204, 51, 51));
                                    TV3_3.setTextColor(Color.rgb(255, 255, 255));
                                    TV4.setTextColor(Color.rgb(255, 255, 255));


                                } else {

                                    Layout4_4_2.setBackgroundColor(Color.rgb(255, 255, 255));
                                    TV1.setTextColor(Color.rgb(0, 0, 0));
                                    TV2.setTextColor(Color.rgb(0, 0, 0));
                                    TV3_1.setTextColor(Color.rgb(0, 0, 0));
                                    TV3_2.setTextColor(Color.rgb(204, 51, 51));
                                    TV3_3.setTextColor(Color.rgb(0, 0, 0));
                                    TV4.setTextColor(Color.rgb(0, 0, 0));

                                    if (j == 0 && jj == 0) {

                                        scrollview.smoothScrollTo(0,0);

                                    }

                                }
                            }
                        });

                    }

                    Layout4.addView(Layout4_3);

                }
                //--------------------------------------------------------------------------------------------------------//

            }

            Layout1.addView(Layout3);

            scrollview.addView(Layout4);
            Layout1.addView(scrollview);

            setContentView(Layout1);

            Cart.requestFocus();

            Cart.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                @Override
                public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                    if (hasFocus == false) {
                        Cart.setImageResource(R.drawable.cart);

                        Home.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Cart.setImageResource(R.drawable.cart);
//                                Search.setImageResource(R.drawable.searchselect);
                                    Intent intent = new Intent(CartActivity.this, HomeActivity.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                    Home.setImageResource(R.drawable.home);
                                }
                            }
                        });

                        Search.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Cart.setImageResource(R.drawable.cart);
//                                Search.setImageResource(R.drawable.searchselect);
                                    Intent intent = new Intent(CartActivity.this, VoyageActivity.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                    Search.setImageResource(R.drawable.search);
                                }
                            }
                        });

                        User.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Cart.setImageResource(R.drawable.cart);
//                                User.setImageResource(R.drawable.userselect);
                                    Intent intent = new Intent(CartActivity.this, SubscribeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                    User.setImageResource(R.drawable.user);
                                }
                            }
                        });

                        My.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
                                    Intent intent = new Intent(CartActivity.this, MyActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                }
                            }
                        });

                        Setting.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                                if (hasFocus) {
//                                    Intent intent = new Intent(CartActivity.this, SettingUserManagementActivity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION| Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//                                    startActivity(intent);
//                                    overridePendingTransition(0, 0);
//                finish();
                                } else {
                                }
                            }
                        });

                    } else {
                    }
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Cart.requestFocus();
        overridePendingTransition(0,0);
    }

    @Override
    public void recreate() {
        super.recreate();
        Cart.requestFocus();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Cart.requestFocus();
    }

    public class CartActivityCartHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {
                Cart.requestFocus();
                Log.d("CARTRESUME","TRUE");
                onResume();
            }
        }
    }

    class CartActivityCartDeleteHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {
                onResume();
            }
        }
    }

    private void CartPost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        String user_id = String.valueOf(aliseon.aliseon_getLoginid());

        Call<Cart> call = AliseonAPI.CartPost(access_token, user_id);

        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {

                int cartapiload = aliseon.aliseon_getCartAPIload();

                Log.d("CARTAPILOAD", String.valueOf(cartapiload));

                Cart postResponse = (Cart) response.body();

                ArrayList<String> cart_shop_id = new ArrayList<>();
                ArrayList<String> cart_shop_photo = new ArrayList<>();
                ArrayList<String> cart_shop_nickname = new ArrayList<>();
                ArrayList<String> cart_shop_shop_name = new ArrayList<>();

                ArrayList<ArrayList<String>> cart_items_p_cart_id = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_user_id = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_option_value = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_option_price = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_option_stock = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_product_id = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_status = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_vendor_id = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_name = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_thumbnail = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_previous_price = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>> cart_items_p_price = new ArrayList<ArrayList<String>>();

                Log.d("CARTTESTasd", String.valueOf(postResponse));

                try {

                    Log.d("CARTTEST", String.valueOf(postResponse.cart_list.size()));

                    for (int i = 0; i < postResponse.cart_list.size(); i++) {

                        Log.d("CARTSTATUS", String.valueOf(i));
                        Log.d("CARTSTATUSVA", postResponse.cart_list.get(i).getShop().getId());
                        ArrayList<String> cart_items_c_cart_id = new ArrayList<>();
                        ArrayList<String> cart_items_c_user_id = new ArrayList<>();
                        ArrayList<String> cart_items_c_option_value = new ArrayList<>();
                        ArrayList<String> cart_items_c_option_price = new ArrayList<>();
                        ArrayList<String> cart_items_c_option_stock = new ArrayList<>();
                        ArrayList<String> cart_items_c_product_id = new ArrayList<>();
                        ArrayList<String> cart_items_c_status = new ArrayList<>();
                        ArrayList<String> cart_items_c_vendor_id = new ArrayList<>();
                        ArrayList<String> cart_items_c_name = new ArrayList<>();
                        ArrayList<String> cart_items_c_thumbnail = new ArrayList<>();
                        ArrayList<String> cart_items_c_ship = new ArrayList<>();
                        ArrayList<String> cart_items_c_previous_price = new ArrayList<>();
                        ArrayList<String> cart_items_c_price = new ArrayList<>();

                        cart_shop_id.add(postResponse.cart_list.get(i).getShop().getId());
                        cart_shop_photo.add(postResponse.cart_list.get(i).getShop().getPhoto());
                        cart_shop_nickname.add(postResponse.cart_list.get(i).getShop().getNickname());
                        cart_shop_shop_name.add(postResponse.cart_list.get(i).getShop().getShopName());

                        for (int j = 0; j < postResponse.cart_list.get(i).getItems().size(); j++) {
                            cart_items_c_cart_id.add(postResponse.cart_list.get(i).getItems().get(j).getId());
//                    cart_items_c_user_id.add(postResponse.cart_list.get(i).getShop().)

                            cart_items_c_option_value.add(postResponse.cart_list.get(i).getItems().get(j).getOptionValue());
                            cart_items_c_option_price.add(postResponse.cart_list.get(i).getItems().get(j).getOptionPrice());
                            cart_items_c_option_stock.add(postResponse.cart_list.get(i).getItems().get(j).getOptionStock());
                            cart_items_c_product_id.add(postResponse.cart_list.get(i).getItems().get(j).getProductId());
                            cart_items_c_status.add(postResponse.cart_list.get(i).getItems().get(j).getItem_Status());
                            cart_items_c_vendor_id.add(postResponse.cart_list.get(i).getItems().get(j).getSellerId());
                            cart_items_c_name.add(postResponse.cart_list.get(i).getItems().get(j).getName());
                            cart_items_c_thumbnail.add(postResponse.cart_list.get(i).getItems().get(j).getThumbnail());
//                    cart_items_c_ship
                            cart_items_c_previous_price.add(postResponse.cart_list.get(i).getItems().get(j).getPreviousPrice());
                            cart_items_c_price.add(postResponse.cart_list.get(i).getItems().get(j).getPrice());
                        }

                        cart_items_p_cart_id.add(cart_items_c_cart_id);
                        cart_items_p_user_id.add(cart_items_c_user_id);
                        cart_items_p_option_value.add(cart_items_c_option_value);
                        cart_items_p_option_price.add(cart_items_c_option_price);
                        cart_items_p_option_stock.add(cart_items_c_option_stock);
                        cart_items_p_product_id.add(cart_items_c_product_id);
                        cart_items_p_status.add(cart_items_c_status);
                        cart_items_p_vendor_id.add(cart_items_c_vendor_id);
                        cart_items_p_name.add(cart_items_c_name);
                        cart_items_p_thumbnail.add(cart_items_c_thumbnail);
                        cart_items_p_previous_price.add(cart_items_c_previous_price);
                        cart_items_p_price.add(cart_items_c_price);


                    }
                } catch (Exception e) {

                }

                aliseon.aliseon_setCart_items_p_cart_id(cart_items_p_cart_id);
                aliseon.aliseon_setCart_items_p_user_id(cart_items_p_user_id);
                aliseon.aliseon_setCart_items_p_option_value(cart_items_p_option_value);
                aliseon.aliseon_setCart_items_p_option_price(cart_items_p_option_price);
                aliseon.aliseon_setCart_items_p_option_stock(cart_items_p_option_stock);
                aliseon.aliseon_setCart_items_p_product_id(cart_items_p_product_id);
                aliseon.aliseon_setCart_items_p_status(cart_items_p_status);
                aliseon.aliseon_setCart_items_p_vendor_id(cart_items_p_vendor_id);
                aliseon.aliseon_setCart_items_p_name(cart_items_p_name);
                aliseon.aliseon_setCart_items_p_thumbnail(cart_items_p_thumbnail);
                aliseon.aliseon_setCart_items_p_previous_price(cart_items_p_previous_price);
                aliseon.aliseon_setCart_items_p_price(cart_items_p_price);

                aliseon.aliseon_setCart_shop_id(cart_shop_id);
                aliseon.aliseon_setCart_shop_photo(cart_shop_photo);
                aliseon.aliseon_setCart_shop_nickname(cart_shop_nickname);
                aliseon.aliseon_setCart_shop_name(cart_shop_shop_name);

                if (cartapiload == 0) {
                    aliseon.aliseon_setCartAPIload(1);
                    cartactivitycarthandler.sendEmptyMessage(1000);

                } else if (cartapiload == 1) {
                    cartactivitycarthandler.sendEmptyMessage(800);
                }

            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {

            }
        });
    }


}
