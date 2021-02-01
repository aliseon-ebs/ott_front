package com.aliseon.ott.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;

import com.aliseon.ott.API.AtrendDetail;
import com.aliseon.ott.API.MyList;
import com.aliseon.ott.API.PopularDetail;
import com.aliseon.ott.API.SubscribeFrom;
import com.aliseon.ott.API.SubscribePost;
import com.aliseon.ott.API.VoyageDetail;
import com.aliseon.ott.Aliseon;
import com.aliseon.ott.CartPlayer;
import com.aliseon.ott.ContentsPlayer;
import com.aliseon.ott.R;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.aliseon.ott.AliseonAPI;

import org.json.JSONException;
import org.json.JSONObject;


public class AliseonOTTPlayerActivity extends AppCompatActivity {

    PlayerCreatorSelectHandler playercreatorselecthandler;
    PlayerDataLoadHandler playerdataloadhandler;

    private PlayerView exoPlayerView;
    private SimpleExoPlayer player;

    private Boolean playWhenReady = true;
    private int currentWindow = 0;
    private Long playbackPosition = 0L;

    private AliseonAPI AliseonAPI;

    ProgressBar progressbar;
    FrameLayout framelayoutprogressbar;
    FrameLayout framelayoutplaypause;
    ImageView imageView3;
    ImageView imageView4;
    TextView TV5;
    int nexttime = 5;

    SharedPreferences prf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_default);

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        prf = getSharedPreferences("login_session", MODE_PRIVATE);

        playercreatorselecthandler = new PlayerCreatorSelectHandler();
        playerdataloadhandler = new PlayerDataLoadHandler();

        int childlist = aliseon.aliseon_getChild_list();
        int contentcounter = aliseon.aliseon_getContent_counter();

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

        aliseon.aliseon_clearPlayer_feed_list_author_id();
        aliseon.aliseon_clearPlayer_feed_list_author_nickname();
        aliseon.aliseon_clearPlayer_feed_list_author_picture();
        aliseon.aliseon_clearPlayer_feed_list_content();
        aliseon.aliseon_clearPlayer_feed_list_crop();
        aliseon.aliseon_clearPlayer_feed_list_id();
        aliseon.aliseon_clearPlayer_feed_list_views();

        Intent intent = getIntent();

        exoPlayerView = findViewById(R.id.exoPlayerView);

        ImageView imageView = (ImageView) findViewById(R.id.exoplayerback);
        imageView3 = (ImageView) findViewById(R.id.exo_play);
        imageView4 = (ImageView) findViewById(R.id.exo_pause);

        progressbar = (ProgressBar) findViewById(R.id.exo_progressbar);
        framelayoutprogressbar = (FrameLayout) findViewById(R.id.exo_framelayoutprogressbar);
        framelayoutplaypause = (FrameLayout) findViewById(R.id.exo_framelayoutplaypause);

        DefaultTimeBar timebar = (DefaultTimeBar) findViewById(R.id.exo_progress);

        imageView.setFocusableInTouchMode(true);
        imageView.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
        imageView3.setFocusableInTouchMode(true);
        imageView3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
        imageView4.setFocusableInTouchMode(true);
        imageView4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
        progressbar.setFocusableInTouchMode(true);
        progressbar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));

        progressbar.requestFocus();

        TextView TV1 = (TextView) findViewById(R.id.title_tv1);
        TextView TV2 = (TextView) findViewById(R.id.title_tv2);
        TextView TV3 = (TextView) findViewById(R.id.title_tv3);
        CircleImageView CIV = (CircleImageView) findViewById(R.id.creator_profile);
        TextView TV4 = (TextView) findViewById(R.id.creator_name);
        Button button = (Button) findViewById(R.id.creator_subscribe);

        String subtitle = aliseon.aliseon_getSub_title();
        String maintitle = aliseon.aliseon_getMain_title();
        String creatortitle = aliseon.aliseon_getCreator_title();
        String creatorprofile = aliseon.aliseon_getCreator_profile();

        aliseon.aliseon_setSelect(intent.getExtras().getInt("index"));
        aliseon.aliseon_setType_selector(intent.getExtras().getInt("category"));

        int typeselector = aliseon.aliseon_getType_selector();
        int select = aliseon.aliseon_getSelect();

        String nowurl = aliseon.aliseon_getNowurl();

        TV1.setText(subtitle);
        TV2.setText(maintitle);
//        TV3.setText(creatortitle);
        Glide.with(this).load(creatorprofile).into(CIV);
        TV4.setText(creatortitle);
        TV1.setTextSize(14);
        TV2.setTextSize(18);
        TV3.setTextSize(14);
        TV1.setTextColor(Color.rgb(255, 255, 255));
        TV2.setTextColor(Color.rgb(255, 255, 255));
        TV3.setTextColor(Color.rgb(255, 255, 255));
        TV2.setTypeface(Typeface.DEFAULT_BOLD);

        childlist = 0;
        contentcounter = 0;

        Log.d("불러온 카테고리 번호 : ", String.valueOf(typeselector));
        Log.d("불러온 Index 번호 : ", String.valueOf(select));

        // 기본값 = 카테고리 없음
//        playercrop = feed_crop;
//        playercontent = feed_content;
//        playerauthorpicture = feed_author_picture;
//        playerauthornickname = feed_author_nickname;
//        playerviews = feed_views;
//        playerfeedid = feed_f_feed_id;
//        playerfeedimage = feed_f_image;
//        playerfeedname = feed_f_name;
//        playerfeedpricecomputed = feed_f_price_computed;


//
//        for (int i = 0; i < playerfeedid.get(parentlist).size(); i++) {
//
//            CartPlayer cartplayer = new CartPlayer(getApplicationContext());
//            LinearLayout cartplayerlayout = (LinearLayout) findViewById(R.id.cartlayout);
//
//            cartplayerlayout.addView(cartplayer);
//
//            childlist++;
//
//        }
//
        // ContentsPlayer
        // player_setting, player_contents, player_cart xml 참조

        // 주의 : 플레이어가 연결된 모든 클래스들에게 author_id를 지정할 수 있는 코드가 필요함, HomeActivity 참고
//        for (int i = 0; i < player_feed_list_content.size(); i++) {
//
//            ContentsPlayer contentsplayer = new ContentsPlayer(getApplicationContext());
//            LinearLayout contentlayout = (LinearLayout) findViewById(R.id.contentlayout);
//
//            contentlayout.addView(contentsplayer);
//
//            contentcounter++;
//
//            // CartPlayer, ContentsPlayer
//            // 레이아웃을 찾아 지정
//
//            // 만들어진 ContentsPlayer 레이아웃을 지정한 레이아웃에 넣기
//
//        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        timebar.setPlayedColor(Color.parseColor("#FF0000"));
        timebar.setScrubberColor(Color.parseColor("#FF0000"));
    }

    @Override
    protected void onStart() {
        super.onStart();
//        initializePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    private void initializePlayer() {

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String aliseonapi = aliseon.aliseon_getAliseonapi();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(aliseonapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AliseonAPI = retrofit.create(AliseonAPI.class);

        String nowurl = aliseon.aliseon_getNowurl();

        if (player == null) {

            /*DefaultRenderersFactory renderersFactory = new DefaultRenderersFactory(this.getApplicationContext());
            DefaultTrackSelector trackSelector = new DefaultTrackSelector();
            DefaultLoadControl loadControl = new DefaultLoadControl();

            player = ExoPlayerFactory.newSimpleInstance(
                    this.getApplicationContext(),
                    renderersFactory,
                    trackSelector,
                    loadControl);*/

            player = ExoPlayerFactory.newSimpleInstance(this.getApplicationContext());

            //플레이어 연결
            exoPlayerView.setPlayer(player);

            player.addListener(new Player.EventListener() {

                @Override
                public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

                    switch (playbackState) {

                        case Player.STATE_IDLE: // 1
                            //재생 실패
                            break;
                        case Player.STATE_BUFFERING: // 2
                            // 재생 준비
                            framelayoutprogressbar.setVisibility(View.VISIBLE);
                            framelayoutplaypause.setVisibility(View.INVISIBLE);
                            break;
                        case Player.STATE_READY: // 3
                            framelayoutprogressbar.setVisibility(View.GONE);
                            framelayoutplaypause.setVisibility(View.VISIBLE);
                            imageView3.requestFocus();
                            imageView4.requestFocus();
                            // 재생 준비 완료
                            break;
                        case Player.STATE_ENDED: // 4
                            // 재생 마침
                            break;
                        default:
                            break;
                    }
                }
            });

            //컨트롤러 없애기
            //exoPlayerView.setUseController(false);

            //사이즈 조절
            exoPlayerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);
            //exoPlayerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM); // or RESIZE_MODE_FILL

            exoPlayerView.setControllerShowTimeoutMs(3000);

            //음량조절
            //player.setVolume(0);

            //프레임 포지션 설정
            //player.seekTo(currentWindow, playbackPosition);

        }

        MediaSource mediaSource = buildMediaSource(Uri.parse(nowurl));

        //prepare
        player.prepare(mediaSource, true, false);

        //start,stop
        player.setPlayWhenReady(playWhenReady);

    }

    private MediaSource buildMediaSource(Uri uri) {

        String userAgent = Util.getUserAgent(this, "blackJin");

        if (uri.getLastPathSegment().contains("mp3") || uri.getLastPathSegment().contains("mp4")) {

            return new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory(userAgent))
                    .createMediaSource(uri);

        } else if (uri.getLastPathSegment().contains("m3u8")) {

            //com.google.android.exoplayer:exoplayer-hls 확장 라이브러리를 빌드 해야 합니다.
            return new HlsMediaSource.Factory(new DefaultHttpDataSourceFactory(userAgent))
                    .createMediaSource(uri);

        } else {

            return new ExtractorMediaSource.Factory(new DefaultDataSourceFactory(this, userAgent))
                    .createMediaSource(uri);
        }

    }

    private void releasePlayer() {
        if (player != null) {
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();

            exoPlayerView.setPlayer(null);
            player.release();
            player = null;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Aliseon aliseon = (Aliseon) getApplicationContext();

        aliseon.aliseon_setPlayerdataload(0);
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
                exoPlayerView.setFocusableInTouchMode(true);
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:

                break;
            case KeyEvent.KEYCODE_DPAD_UP:

                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:

                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:

                break;

            case KeyEvent.FLAG_KEEP_TOUCH_MODE:

                break;
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
                exoPlayerView.showController();
                break;
            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
                exoPlayerView.showController();
                exoPlayerView.setFastForwardIncrementMs(10000);
                break;
            case KeyEvent.KEYCODE_MEDIA_REWIND:
                exoPlayerView.showController();
                exoPlayerView.setRewindIncrementMs(10000);
                break;
        }

        return super.dispatchKeyEvent(event);
    }

    public void onResume() {

        super.onResume();

        // 필요한 값 import
        Aliseon aliseon = (Aliseon) getApplicationContext();

        String imageurl = aliseon.aliseon_getImageURL();
        int childlist = aliseon.aliseon_getChild_list();
        int contentcounter = aliseon.aliseon_getContent_counter();

        int refresh_num = aliseon.aliseon_getRefresh_num();
        int playerdataload = aliseon.aliseon_getPlayerdataload();

        Log.d("DATALOAD", String.valueOf(playerdataload));

        ArrayList<String> playerfeedimage = aliseon.aliseon_getPlayerfeedimage();
        ArrayList<String> playerfeedid = aliseon.aliseon_getPlayerfeedid();

        String param_atrend_id = aliseon.aliseon_getParam_atrend_id();
        String select_voyage_id = aliseon.aliseon_getSelect_voyage_id();
        ArrayList<String> atrend_id = aliseon.aliseon_getAtrend_id();
        ArrayList<String> atrend_related_id = aliseon.aliseon_getAtrend_related_id();

        int loginid = aliseon.aliseon_getLoginid();
        String creatorauthorid = aliseon.aliseon_getCreator_author_id();

        String maintitle = aliseon.aliseon_getMain_title();
        String subtitle = aliseon.aliseon_getSub_title();
        ArrayList<String> player_feed_list_content = aliseon.aliseon_getPlayer_feed_list_content();
        ArrayList<String> player_feed_list_crop = aliseon.aliseon_getPlayer_feed_list_crop();

        ArrayList<String> atrend_title = aliseon.aliseon_getAtrend_title();
        ArrayList<String> atrend_subtitle = aliseon.aliseon_getAtrend_sub_title();
        ArrayList<String> atrend_related_description = aliseon.aliseon_getAtrend_related_description();
        ArrayList<String> atrend_related_thumbnail = aliseon.aliseon_getAtrend_related_thumbnail();

        ArrayList<String> popular_description = aliseon.aliseon_getPopular_description();
        ArrayList<String> popular_photo = aliseon.aliseon_getPopular_photo();
        ArrayList<String> popular_nickname = aliseon.aliseon_getPopular_nickname();
        ArrayList<String> popular_author_id = aliseon.aliseon_getPopular_user_id();

        ArrayList<String> voyage_description = aliseon.aliseon_getVoyage_description();
        ArrayList<String> voyage_nickname = aliseon.aliseon_getVoyage_nickname();
        ArrayList<String> voyage_photo = aliseon.aliseon_getVoyage_photo();
        ArrayList<String> voyage_author_id = aliseon.aliseon_getVoyage_user_id();

        ArrayList<String> my_list_description = aliseon.aliseon_getMy_list_description();
        ArrayList<String> my_list_nickname = aliseon.aliseon_getMy_list_nickname();
        ArrayList<String> my_list_profile = aliseon.aliseon_getMy_list_profile();
        ArrayList<String> my_list_author_id = aliseon.aliseon_getMy_list_user_id();

        ArrayList<String> voyageresult_description = aliseon.aliseon_getVoyageresult_description();
        ArrayList<String> voyageresult_nickname = aliseon.aliseon_getVoyageresult_nickname();
        ArrayList<String> voyageresult_photo = aliseon.aliseon_getVoyageresult_photo();
        ArrayList<String> voyageresult_author_id = aliseon.aliseon_getVoyageresult_user_id();

        ArrayList<String> creator_list_description = aliseon.aliseon_getCreator_list_description();
        ArrayList<String> creator_list_nickname = aliseon.aliseon_getCreator_list_nickname();
        ArrayList<String> creator_list_profile = aliseon.aliseon_getCreator_list_profile();
        ArrayList<String> creator_list_author_id = aliseon.aliseon_getCreator_list_user_id();

        ArrayList<String> subscribe_voyage_list_description = aliseon.aliseon_getSubscribe_voyage_list_description();
        ArrayList<String> subscribe_voyage_list_name = aliseon.aliseon_getSubscribe_voyage_list_nickname();
        ArrayList<String> subscribe_voyage_list_photo = aliseon.aliseon_getSubscribe_voyage_list_photo();
        ArrayList<String> subscribe_voyage_list_author_id = aliseon.aliseon_getSubscribe_voyage_list_user_id();

        aliseon.aliseon_setRefresh_num(2);


        Intent intent = getIntent();

        int typeselector = aliseon.aliseon_getType_selector();
        int select = aliseon.aliseon_getSelect();

        Log.d("불러온 카테고리 번호 : ", String.valueOf(typeselector));
        Log.d("불러온 Index 번호 : ", String.valueOf(select));

        String creatortitle = aliseon.aliseon_getCreator_title();
        String creatorprofile = aliseon.aliseon_getCreator_profile();
        String creatorid = aliseon.aliseon_getCreator_author_id();

        // 선택한 영상의 데이터
        switch (typeselector) {
            case 1:
                // Atrend
                maintitle = atrend_title.get(select);
                subtitle = atrend_subtitle.get(select);
                creatorid = "0";
                player_feed_list_content = atrend_related_description;
                player_feed_list_crop = atrend_related_thumbnail;

                aliseon.aliseon_setMain_title(maintitle);
                aliseon.aliseon_setSub_title(subtitle);
                aliseon.aliseon_setCreator_author_id(creatorid);
                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                break;

            case 2:
                // Popular
                maintitle = popular_description.get(select);
                subtitle = popular_description.get(select);
                creatortitle = popular_nickname.get(select);
                creatorprofile = popular_photo.get(select);
                creatorid = String.valueOf(popular_author_id.get(select));

                aliseon.aliseon_setMain_title(maintitle);
                aliseon.aliseon_setSub_title(subtitle);
                aliseon.aliseon_setCreator_author_id(creatorid);
                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                break;
            case 3:
                // Popular
                maintitle = voyage_description.get(select);
                subtitle = voyage_description.get(select);
                creatortitle = voyage_nickname.get(select);
                creatorprofile = voyage_photo.get(select);
                creatorid = String.valueOf(voyage_author_id.get(select));

                aliseon.aliseon_setMain_title(maintitle);
                aliseon.aliseon_setSub_title(subtitle);
                aliseon.aliseon_setCreator_author_id(creatorid);
                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                break;
            case 4:
                // My
                maintitle = my_list_description.get(select);
                subtitle = my_list_description.get(select);
                creatortitle = my_list_nickname.get(select);
                creatorprofile = my_list_profile.get(select);
                creatorid = String.valueOf(my_list_author_id.get(select));

                aliseon.aliseon_setMain_title(maintitle);
                aliseon.aliseon_setSub_title(subtitle);
                aliseon.aliseon_setCreator_author_id(creatorid);
                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                break;

            case 5:
                // Voyage result
                maintitle = voyageresult_description.get(select);
                subtitle = voyageresult_description.get(select);
                creatortitle = voyageresult_nickname.get(select);
                creatorprofile = voyageresult_photo.get(select);
                creatorid = String.valueOf(voyageresult_author_id.get(select));

                aliseon.aliseon_setMain_title(maintitle);
                aliseon.aliseon_setSub_title(subtitle);
                aliseon.aliseon_setCreator_author_id(creatorid);
                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                break;

            case 6:
                // Creator
                maintitle = creator_list_description.get(select);
                subtitle = creator_list_description.get(select);
                creatortitle = creator_list_nickname.get(select);
                creatorprofile = creator_list_profile.get(select);
                creatorid = String.valueOf(creator_list_author_id.get(select));

                aliseon.aliseon_setMain_title(maintitle);
                aliseon.aliseon_setSub_title(subtitle);
                aliseon.aliseon_setCreator_author_id(creatorid);
                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                break;

            case 7:
                // Subscribe
                maintitle = subscribe_voyage_list_description.get(select);
                subtitle = subscribe_voyage_list_description.get(select);
                creatortitle = subscribe_voyage_list_name.get(select);
                creatorprofile = subscribe_voyage_list_photo.get(select);
                creatorid = subscribe_voyage_list_author_id.get(select);

                aliseon.aliseon_setMain_title(maintitle);
                aliseon.aliseon_setSub_title(subtitle);
                aliseon.aliseon_setCreator_author_id(creatorid);
                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                break;

            case 11:
                // Atrend - related
                maintitle = aliseon.aliseon_getAtrend_detail_title();
                subtitle = aliseon.aliseon_getAtrend_detail_title();
                creatorid = "0";

                aliseon.aliseon_setMain_title(maintitle);
                aliseon.aliseon_setSub_title(subtitle);
                aliseon.aliseon_setCreator_author_id(creatorid);
//                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
//                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                break;

            case 12:
                // Popular - related
                maintitle = aliseon.aliseon_getPopular_detail_description().get(0);
                subtitle = aliseon.aliseon_getPopular_detail_description().get(0);
                aliseon.aliseon_setCreator_author_id(creatorid);
                creatortitle = aliseon.aliseon_getPopular_detail_name().get(0);
                creatorprofile = aliseon.aliseon_getPopular_detail_photo().get(0);
                creatorid = aliseon.aliseon_getPopular_detail_user_id().get(0);

                aliseon.aliseon_setMain_title(maintitle);
                aliseon.aliseon_setSub_title(subtitle);
                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                break;

            case 13:
                // Voyage - related
            case 14:
                // My - related
            case 15:
                // Voyage Result - related
            case 16:
                // Creator - related
            case 17:
                // Subscribe - related

                maintitle = aliseon.aliseon_getVoyage_detail_description().get(0);
                subtitle = aliseon.aliseon_getVoyage_detail_description().get(0);
                creatortitle = aliseon.aliseon_getVoyage_detail_nickname().get(0);
                creatorprofile = aliseon.aliseon_getVoyage_detail_photo().get(0);
                creatorid = aliseon.aliseon_getVoyage_detail_user_id().get(0);

                aliseon.aliseon_setMain_title(maintitle);
                aliseon.aliseon_setSub_title(subtitle);
                aliseon.aliseon_setCreator_author_id(creatorid);
                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                break;

        }

        Log.d("MAINTITLE :: ", maintitle);
        Log.d("SubTITLE :: ", subtitle);

        SubscribeFromPost();

        // API 로드를 위한 코드
        if (playerdataload == 0) {
            playerdataloadhandler.post(new Runnable() {
                @Override
                public void run() {
                    Log.d("Selected ::", typeselector + "/" + select);
                    switch (typeselector) {
                        case 1:
                            // Atrend
                            aliseon.aliseon_setParam_atrend_id(atrend_id.get(select));
                            AtrendDetailPost();
                            break;

                        case 2:
                            // Popular
                            aliseon.aliseon_setSelect_voyage_id(aliseon.aliseon_getPopular_id().get(select));
                            PopularDetailPost();
                            break;

                        case 3:
                            // Voyage
                            aliseon.aliseon_setSelect_voyage_id(aliseon.aliseon_getVoyage_id().get(select));
                            VoyageDetailPost();
                            break;

                        case 4:
                            // My
                            aliseon.aliseon_setSelect_voyage_id(aliseon.aliseon_getMy_list_id().get(select));
                            VoyageDetailPost();
                            break;

                        case 5:
                            // Voyage Result
                            aliseon.aliseon_setSelect_voyage_id(aliseon.aliseon_getVoyageresult_id().get(select));
                            VoyageDetailPost();
                            break;

                        case 6:
                            // Creator
                            aliseon.aliseon_setSelect_voyage_id(aliseon.aliseon_getCreator_list_id().get(select));
                            VoyageDetailPost();
                            break;

                        case 7:
                            // Subscribe
                            aliseon.aliseon_setSelect_voyage_id(aliseon.aliseon_getSubscribe_voyage_list_id().get(select));
                            VoyageDetailPost();
                            break;

                        case 11:
                            aliseon.aliseon_setParam_atrend_id(aliseon.aliseon_getAtrend_related_id().get(select));
                            AtrendDetailPost();
                            break;

                        case 12:
                            aliseon.aliseon_setSelect_voyage_id(aliseon.aliseon_getPopular_related_id().get(select));
                            PopularDetailPost();
                            break;

                        case 13:
                            // Voyage - related
                        case 14:
                            // My - related
                        case 15:
                            // Voyage Result - related
                        case 16:
                            // Creator - related
                        case 17:
                            // Subscribe - related
                            aliseon.aliseon_setSelect_voyage_id(aliseon.aliseon_getVoyage_related_id().get(select));
                            VoyageDetailPost();
                            break;
                    }
                }
            });
        }


        exoPlayerView = findViewById(R.id.exoPlayerView);

        ImageView imageView = (ImageView) findViewById(R.id.exoplayerback);
//        ImageView imageView2= (ImageView) findViewById(R.id.exo_rew);
//        ImageView imageView5= (ImageView) findViewById(R.id.exo_ffwd);

        ScrollView scrollview = (ScrollView) findViewById(R.id.playerscrollview);
        HorizontalScrollView contentscrollview = (HorizontalScrollView) findViewById(R.id.contentscrollview);

        LinearLayout cartscrollview = (LinearLayout) findViewById(R.id.cartscrollview);
        LinearLayout contentlayout = (LinearLayout) findViewById(R.id.contentlayout);

        DefaultTimeBar timebar = (DefaultTimeBar) findViewById(R.id.exo_progress);

        imageView.setFocusableInTouchMode(true);
        imageView.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
        imageView3.setFocusableInTouchMode(true);
        imageView3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
        imageView4.setFocusableInTouchMode(true);
        imageView4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
        progressbar.setFocusableInTouchMode(true);
        progressbar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));

        progressbar.requestFocus();

        TextView TV1 = (TextView) findViewById(R.id.title_tv1);
        TextView TV2 = (TextView) findViewById(R.id.title_tv2);
        TextView TV3 = (TextView) findViewById(R.id.title_tv3);
        CircleImageView CIV = (CircleImageView) findViewById(R.id.creator_profile);
        TextView TV4 = (TextView) findViewById(R.id.creator_name);
        TV5 = (TextView) findViewById(R.id.nextvideotimer);
        Button button = (Button) findViewById(R.id.creator_subscribe);




        // Acon을 클릭시 일부 뷰를 보이지 않게 만듬
        if (typeselector == 1) {
            button.setVisibility(View.GONE);
            CIV.setVisibility(View.GONE);
            TV4.setVisibility(View.GONE);
            TV3.setVisibility(View.GONE);
        } else {
            if (String.valueOf(loginid).equals(String.valueOf(creatorauthorid))) {
                button.setVisibility(View.GONE);
            } else {
                button.setVisibility(View.VISIBLE);
            }
            contentscrollview.setVisibility(View.VISIBLE);
            contentlayout.setVisibility(View.VISIBLE);
            CIV.setVisibility(View.VISIBLE);
            TV4.setVisibility(View.VISIBLE);
            TV3.setVisibility(View.VISIBLE);
        }

        TV1.setText(subtitle);
        TV2.setText(maintitle);
//        TV3.setText(creatortitle);
        Glide.with(this).load(imageurl + creatorprofile).into(CIV);
        TV4.setText(creatortitle);
        TV1.setTextSize(14);
        TV2.setTextSize(18);
        TV3.setTextSize(14);
        TV1.setTextColor(Color.rgb(255, 255, 255));
        TV2.setTextColor(Color.rgb(255, 255, 255));
        TV3.setTextColor(Color.rgb(255, 255, 255));
        TV2.setTypeface(Typeface.DEFAULT_BOLD);

        childlist = 0;
        contentcounter = 0;

        Log.d("불러온 카테고리 번호 : ", String.valueOf(typeselector));

        // 기본값 = 카테고리 없음
//        playercrop = feed_crop;
//        playercontent = feed_content;
//        playerauthorpicture = feed_author_picture;
//        playerauthornickname = feed_author_nickname;
//        playerviews = feed_views;
//        playerfeedid = feed_f_feed_id;
//        playerfeedimage = feed_f_image;
//        playerfeedname = feed_f_name;
//        playerfeedpricecomputed = feed_f_price_computed;

        int subscribe_checker = aliseon.aliseon_getSubscribe_checker();

        if (subscribe_checker == 0) {
            button.setText(getResources().getString(R.string.subscribe));
            button.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonsetting));
            button.setTextColor(Color.rgb(255, 255, 255));
        }

        if (subscribe_checker == 1) {
            button.setText(getResources().getString(R.string.subscribed));
            button.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
            button.setTextColor(Color.rgb(255, 255, 255));
        }

        switch (aliseon.aliseon_getSubscribe_checker()) {
            case 0:
                // 구독 안된 크리에이터일 경우
                Log.d("isSubscribe", "NO");
                button.setText(getResources().getString(R.string.subscribe));
                button.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonsetting));
                button.setTextColor(Color.rgb(255, 255, 255));

                break;

            case 1:
                // 구독한 크리에이터일 경우
                Log.d("isSubscribe", "YES");
                button.setText(getResources().getString(R.string.subscribed));
                button.setBackground(ContextCompat.getDrawable(this, R.drawable.blackbuttonsetting));
                button.setTextColor(Color.rgb(255, 255, 255));

                break;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int subscribe_checker = aliseon.aliseon_getSubscribe_checker();

                if (prf.getString("userinfo_name", "").equals("empty")
                        && prf.getString("userinfo_picture", "").equals("empty")
                        && prf.getInt("user_id", 0) == 0) {
                    // 비회원일 경우 아무것도 작동하지 않음, 차후 이를 로그인 유도 또는 다른 것으로 대체할 필요가 있음
                }
                else {
                    if (subscribe_checker == 0) {
//                        SubscribePost("add");
                    }

                    if (subscribe_checker == 1) {
//                        SubscribePost("delete");
                    }
                }
            }
        });


        // 기존에 추가된 상품 목록을 지우기 위함
        LinearLayout cartplayerlayout = (LinearLayout) findViewById(R.id.cartlayout);
        cartplayerlayout.removeAllViews();



        try {

            // 영상의 상품 목록 표시
            for (int i = 0; i < playerfeedimage.size(); i++) {

                try {

                    aliseon.aliseon_setChild_list(i);

                    CartPlayer cartplayer = new CartPlayer(getApplicationContext());

                    Button cartproductadd = (Button) cartplayer.findViewById(R.id.cartproductadd1);

                    // 정비 필요

                    final int j = i;
                    cartproductadd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if (prf.getString("userinfo_name", "").equals("empty")
                                    && prf.getString("userinfo_picture", "").equals("empty")
                                    && prf.getInt("user_id", 0) == 0) {

                                aliseon.aliseon_setPlayerdataload(0);

                                Intent intent = new Intent(AliseonOTTPlayerActivity.this, AliseonOTTPlayerCartLoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);

                            } else {
                                Log.d("WHAT ITEMS:::", String.valueOf(playerfeedid));
                                Log.d("WHAT ITEMS:::", String.valueOf(playerfeedid.get(0)));

                                aliseon.aliseon_setParam_product_id(playerfeedid.get(j));

                                aliseon.aliseon_setPlayerdataload(0);

                                Intent intent = new Intent(AliseonOTTPlayerActivity.this, CartDetailActivity.class);
                                intent.putExtra("cartdetail", j);
                                intent.putExtra("playercartdetail", 1);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);

                            }

                        }
                    });

                    cartplayerlayout.addView(cartplayer);

                } catch (Exception e) {
                    // 영상 플레이어에 수정 필요
                    Log.d("ERRORLOG", "카트 오류 발생");
                    e.printStackTrace();
                }

                childlist++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 기존에 추가된 크리에이터의 영상 목록을 지우기 위함

        contentlayout.removeAllViews();

        // 영상의 크리에이터가 보유한 영상 목록 표시
        // Atrend일 경우 Related 영상 목록 표시

            try {

                for (int i = 0; i < player_feed_list_content.size(); i++) {

                    Log.d("TESTING ::", "IS WORKING??? "+i);
                    Log.d("TESTING ::", "IS WORKING??? "+ player_feed_list_content.get(i));

                    if (player_feed_list_content.size() - 1 == 0) {
                        contentscrollview.setVisibility(View.GONE);
                    } else {
                        contentscrollview.setVisibility(View.VISIBLE);
                    }

                    try {
                        /* Atrend의 경우 닉네임이 없어 현재는 하단의 뷰가 닉네임, 프로필 이미지가 등장하지 않음.
                           예외처리 필요,
                        */
                        contentcounter = i;
                        aliseon.aliseon_setContent_count(i);
                        ContentsPlayer contentsplayer = new ContentsPlayer(getApplicationContext());
                        LinearLayout mainlayout1 = (LinearLayout) contentsplayer.findViewById(R.id.mainlayout1);
                        TextView contenttitle = (TextView) contentsplayer.findViewById(R.id.contenttitle);
                        TextView contentcreatorinfo = (TextView) contentsplayer.findViewById(R.id.contentcreatorinfo);

                        Log.d("VIDEOCHECKER", player_feed_list_content.get(i));

                    final int j = i;

                    contentsplayer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                            if (hasFocus == false)
                            {
                                Log.d("RESULT","UNLUCKY?");
                                mainlayout1.setBackground(null);
                                contenttitle.setTextColor(Color.rgb(255,255,255));
                                contentcreatorinfo.setTextColor(Color.rgb(255,255,255));
                            } else {
                                Log.d("RESULT","LUCKY!!");
                                mainlayout1.setBackgroundColor(Color.rgb(255,255,255));
                                contenttitle.setTextColor(Color.rgb(0,0,0));
                                contentcreatorinfo.setTextColor(Color.rgb(0,0,0));

//                                scrollview.fullScroll(View.FOCUS_DOWN);
//                                contentsplayer.requestFocus();

                            }
                        }
                    });

                    contentsplayer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            int typeselector = aliseon.aliseon_getType_selector();
                            aliseon.aliseon_setPlayerdataload(0);

                            if (typeselector < 10) {
                                aliseon.aliseon_setType_selector(typeselector + 10);
                                typeselector = typeselector + 10;
                            }

                            Log.d("VIDEOCHECKER", String.valueOf(playerfeedid));
                            Log.d("VIDEOCHECKER", playerfeedid.get(j));
                            Log.d("VIDEONUM", String.valueOf(j));

                            aliseon.aliseon_setSelect(j);


                            Intent intent = new Intent(AliseonOTTPlayerActivity.this, AliseonOTTPlayerActivity.class);
                            intent.putExtra("index", j);
                            intent.putExtra("category", typeselector);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                        }
                    });

//                    if (i == 0) {
//
//                        player.addListener(new Player.EventListener() {
//
//                            @Override
//                            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
//
//                                switch (playbackState) {
//
//                                    case Player.STATE_ENDED:
//                                        playernextvideohandler.post(new Runnable() {
//                                            @Override
//                                            public void run() {
//                                                playernextvideohandler.sendEmptyMessage(1000);
//                                            }
//                                        });
//
//                                }
//                            }
//                        });
//
//                    }

                        contentlayout.addView(contentsplayer);


                        // 재생되는 영상과 하단에 표시되는 영상들중 같을 경우 삭제하기 위한 코드
                        // 영상 주소를 비교, 일치시 생성된 뷰를 삭제함
//                    String testcrop1 = nowurl;
//                    String testcrop2 = imageurl + player_feed_list_video.get(i);

                        // 기존의 == 는 비교가 안되어 equals를 사용함
//                    if (testcrop1.equals(testcrop2)) {
//                        contentlayout.removeView(contentsplayer);
//                    }
                    } catch (Exception e) {
                        Log.d("ERRORLOG", "하단 컨텐츠 오류 발생");
                        e.printStackTrace();
                    }
                    aliseon.aliseon_setContent_count(contentcounter);
//                    contentcounter++;

                }

            } catch (Exception e) {
                Log.d("ERRORLOG", "하단 컨텐츠 오류");
                e.printStackTrace();

            }



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        timebar.setPlayedColor(Color.parseColor("#FF0000"));
        timebar.setScrubberColor(Color.parseColor("#FF0000"));

        imageView3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

            @Override
            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                if (hasFocus == false) {

                } else {

                    scrollview.smoothScrollTo(0, 0);

                }
            }
        });

        imageView4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // 포커스를 얻으면

            @Override
            public void onFocusChange(View v, boolean hasFocus) { // 포커스가 한뷰에서 다른뷰로 바뀔때
                if (hasFocus == false) {

                } else {

                    scrollview.smoothScrollTo(0, 0);

                }
            }
        });

    }

    public class PlayerCreatorSelectHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 다른 Thread에서 전달받은 Message 처리
            if (msg.what == 1000) {
                onResume();
            }
        }
    }

    public class PlayerDataLoadHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1000) {

                Log.d("REALLY :", "IS WORKING.");


                Aliseon aliseon = (Aliseon) getApplicationContext();

                String imageurl = aliseon.aliseon_getImageURL();

                int playerdataload = aliseon.aliseon_getPlayerdataload();
                int typeselector = aliseon.aliseon_getType_selector();
                String nowurl = aliseon.aliseon_getNowurl();

                ArrayList<String> player_feed_list_content = aliseon.aliseon_getPlayer_feed_list_content();
                ArrayList<String> player_feed_list_crop = aliseon.aliseon_getPlayer_feed_list_crop();
                ArrayList<String> player_feed_list_id = aliseon.aliseon_getPlayer_feed_list_id();

                ArrayList<String> playerfeedid = aliseon.aliseon_getPlayerfeedid();
                ArrayList<String> playerfeedimage = aliseon.aliseon_getPlayerfeedimage();
                ArrayList<String> playerfeedname = aliseon.aliseon_getPlayerfeedname();
                ArrayList<String> playerfeedpricecomputed = aliseon.aliseon_getPlayerfeedpricecomputed();

                ArrayList<String> popular_related_description = aliseon.aliseon_getPopular_related_description();
                ArrayList<String> popular_related_contents = aliseon.aliseon_getPopular_related_contents();
                ArrayList<String> popular_related_id = aliseon.aliseon_getPopular_related_id();

                ArrayList<String> popular_detail_item_id = aliseon.aliseon_getPopular_detail_item_id();
                ArrayList<String> popular_detail_contents = aliseon.aliseon_getPopular_detail_contents();
                ArrayList<String> popular_detail_product_id = aliseon.aliseon_getPopular_detail_product_id();
                ArrayList<String> popular_detail_item_thumbnail = aliseon.aliseon_getPopular_detail_item_thumbnail();
                ArrayList<String> popular_detail_item_name = aliseon.aliseon_getPopular_detail_item_name();
                ArrayList<String> popular_detail_item_price = aliseon.aliseon_getPopular_detail_item_price();

                ArrayList<String> voyage_related_description = aliseon.aliseon_getVoyage_related_description();
                ArrayList<String> voyage_related_contents = aliseon.aliseon_getVoyage_related_contents();
                ArrayList<String> voyage_related_id = aliseon.aliseon_getVoyage_related_id();

                ArrayList<String> voyage_detail_item_id = aliseon.aliseon_getVoyage_detail_item_id();
                ArrayList<String> voyage_detail_product_id = aliseon.aliseon_getVoyage_detail_product_id();
                ArrayList<String> voyage_detail_item_thumbnail = aliseon.aliseon_getVoyage_detail_item_thumbnail();
                ArrayList<String> voyage_detail_item_name = aliseon.aliseon_getVoyage_detail_item_name();
                ArrayList<String> voyage_detail_item_price = aliseon.aliseon_getVoyage_detail_item_price();
                ArrayList<String> voyage_detail_contents = aliseon.aliseon_getVoyage_detail_contents();

                Log.d("ATRENDPLAYER", String.valueOf(typeselector));

                aliseon.aliseon_setPlayerdataload(1);

                switch (typeselector) {
                    case 1:
                        // Atrend
                        nowurl = imageurl + aliseon.aliseon_getAtrend_detail_maincontent().get(0);
                        player_feed_list_content = aliseon.aliseon_getAtrend_related_description();
                        player_feed_list_crop = aliseon.aliseon_getAtrend_related_thumbnail();
                        player_feed_list_id = aliseon.aliseon_getAtrend_related_id();

                        playerfeedid = aliseon.aliseon_getAtrend_detail_product_id();
                        playerfeedimage = aliseon.aliseon_getAtrend_detail_product_thumbnail();
                        playerfeedname = aliseon.aliseon_getAtrend_detail_product_name();
                        playerfeedpricecomputed = aliseon.aliseon_getAtrend_detail_product_price();
                        break;
                    case 2:
                        // Popular
                        nowurl = imageurl + popular_detail_contents.get(0);

                        player_feed_list_content = popular_related_description;
                        player_feed_list_crop = popular_related_contents;
                        player_feed_list_id = popular_related_id;

                        playerfeedid = popular_detail_product_id;
                        playerfeedimage = popular_detail_item_thumbnail;
                        playerfeedname = popular_detail_item_name;
                        playerfeedpricecomputed = popular_detail_item_price;
                        break;

                    case 3:
                        // Voyage
                        nowurl = imageurl + voyage_detail_contents.get(0);

                        player_feed_list_content = voyage_related_description;
                        player_feed_list_crop = voyage_related_contents;
                        player_feed_list_id = voyage_related_id;

                        playerfeedid = voyage_detail_product_id;
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;

                    case 4:
                        // My
                        nowurl = imageurl + voyage_detail_contents.get(0);

                        player_feed_list_content = voyage_related_description;
                        player_feed_list_crop = voyage_related_contents;
                        player_feed_list_id = voyage_related_id;

                        playerfeedid = voyage_detail_product_id;
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;

                    case 5:
                        // Voyage Result
                        nowurl = imageurl + voyage_detail_contents.get(0);

                        player_feed_list_content = voyage_related_description;
                        player_feed_list_crop = voyage_related_contents;
                        player_feed_list_id = voyage_related_id;

                        playerfeedid = voyage_detail_product_id;
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;

                    case 6:
                        // Creator
                        nowurl = imageurl + voyage_detail_contents.get(0);

                        player_feed_list_content = voyage_related_description;
                        player_feed_list_crop = voyage_related_contents;
                        player_feed_list_id = voyage_related_id;

                        playerfeedid = voyage_detail_product_id;
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;

                    case 7:
                        // Subscribe
                        nowurl = imageurl + voyage_detail_contents.get(0);

                        player_feed_list_content = voyage_related_description;
                        player_feed_list_crop = voyage_related_contents;
                        player_feed_list_id = voyage_related_id;

                        playerfeedid = voyage_detail_product_id;
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;

                    case 11:
                        // Atrend - Related
                        nowurl = imageurl + aliseon.aliseon_getAtrend_detail_maincontent().get(0);
                        player_feed_list_content = aliseon.aliseon_getAtrend_related_description();
                        player_feed_list_crop = aliseon.aliseon_getAtrend_related_thumbnail();
                        player_feed_list_id = aliseon.aliseon_getAtrend_related_id();

                        playerfeedid = aliseon.aliseon_getAtrend_detail_product_id();
                        playerfeedimage = aliseon.aliseon_getAtrend_detail_product_thumbnail();
                        playerfeedname = aliseon.aliseon_getAtrend_detail_product_name();
                        playerfeedpricecomputed = aliseon.aliseon_getAtrend_detail_product_price();
                        break;

                    case 12:
                        // Popular - Related
                        nowurl = imageurl + popular_detail_contents.get(0);

                        player_feed_list_content = popular_related_description;
                        player_feed_list_crop = popular_related_contents;
                        player_feed_list_id = popular_related_id;

                        playerfeedid = popular_detail_item_id;
                        playerfeedimage = popular_detail_item_thumbnail;
                        playerfeedname = popular_detail_item_name;
                        playerfeedpricecomputed = popular_detail_item_price;
                        break;

                    case 13:
                        // Voyage - Related
                        nowurl = imageurl + voyage_detail_contents.get(0);

                        player_feed_list_content = voyage_related_description;
                        player_feed_list_crop = voyage_related_contents;
                        player_feed_list_id = voyage_related_id;

                        playerfeedid = voyage_detail_item_id;
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;

                    case 14:
                        // My - Related
                        nowurl = imageurl + voyage_detail_contents.get(0);

                        player_feed_list_content = voyage_related_description;
                        player_feed_list_crop = voyage_related_contents;
                        player_feed_list_id = voyage_related_id;

                        playerfeedid = voyage_detail_item_id;
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;

                    case 15:
                        // Voyage Result - Related
                        nowurl = imageurl + voyage_detail_contents.get(0);

                        player_feed_list_content = voyage_related_description;
                        player_feed_list_crop = voyage_related_contents;
                        player_feed_list_id = voyage_related_id;

                        playerfeedid = voyage_detail_item_id;
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;

                    case 16:
                        // Voyage Result - Related
                        nowurl = imageurl + voyage_detail_contents.get(0);

                        player_feed_list_content = voyage_related_description;
                        player_feed_list_crop = voyage_related_contents;
                        player_feed_list_id = voyage_related_id;

                        playerfeedid = voyage_detail_item_id;
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;

                    case 17:
                        // Voyage Result - Related
                        nowurl = imageurl + voyage_detail_contents.get(0);

                        player_feed_list_content = voyage_related_description;
                        player_feed_list_crop = voyage_related_contents;
                        player_feed_list_id = voyage_related_id;

                        playerfeedid = voyage_detail_item_id;
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;
                }

                aliseon.aliseon_setNowurl(nowurl);
                aliseon.aliseon_setPlayer_feed_list_content(player_feed_list_content);
                aliseon.aliseon_setPlayer_feed_list_crop(player_feed_list_crop);
                aliseon.aliseon_setPlayer_feed_list_id(player_feed_list_id);

                aliseon.aliseon_setPlayerfeedid(playerfeedid);
                aliseon.aliseon_setPlayerfeedimage(playerfeedimage);
                aliseon.aliseon_setPlayerfeedname(playerfeedname);
                aliseon.aliseon_setPlayerfeedpricecomputed(playerfeedpricecomputed);

                Log.d("재생되는 링크 ::", nowurl);

                // API 로드가 완료될 경우 영상 재생과 onResume으로 화면을 새로고침
                initializePlayer();
                onResume();

            } else if (msg.what == 800) {
                Log.d("ERROR ::", "Player Data Loader ERROR");
            }
        }
    }

    private void AtrendDetailPost() {

        Log.d("ATRENDPOST", "============================================================");
        Log.d("ATRENDPOST", "============================================================");
        Log.d("ATRENDPOST", "============================================================");

        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        int user_id = aliseon.aliseon_getLoginid();
        String atrend_id = aliseon.aliseon_getParam_atrend_id();
        String lang = aliseon.aliseon_getLoginlanguage();
        String currency = aliseon.aliseon_getLogincurrency();

        Call<AtrendDetail> call = AliseonAPI.AtrendDetailPost(access_token, user_id, atrend_id, lang, currency);

        call.enqueue(new Callback<AtrendDetail>() {
            @Override
            public void onResponse(Call<AtrendDetail> call, Response<AtrendDetail> response) {
                AtrendDetail postResponse = (AtrendDetail) response.body();


                ArrayList<String> atrend_detail_product_id = new ArrayList<>();
                ArrayList<String> atrend_detail_product_name = new ArrayList<>();
                ArrayList<String> atrend_detail_product_brand = new ArrayList<>();
                ArrayList<String> atrend_detail_product_thumbnail = new ArrayList<>();
                ArrayList<String> atrend_detail_product_price = new ArrayList<>();
                ArrayList<String> atrend_detail_product_previous_price = new ArrayList<>();

                ArrayList<String> atrend_related_id = new ArrayList<>();
                ArrayList<String> atrend_related_user_id = new ArrayList<>();
                ArrayList<String> atrend_related_type = new ArrayList<>();
                ArrayList<String> atrend_related_product_id = new ArrayList<>();
                ArrayList<String> atrend_related_title = new ArrayList<>();
                ArrayList<String> atrend_related_subtitle = new ArrayList<>();
                ArrayList<String> atrend_related_description = new ArrayList<>();
                ArrayList<String> atrend_related_summary = new ArrayList<>();
                ArrayList<String> atrend_related_view = new ArrayList<>();
                ArrayList<String> atrend_related_like = new ArrayList<>();
                ArrayList<String> atrend_related_color = new ArrayList<>();
                ArrayList<String> atrend_related_start_at = new ArrayList<>();
                ArrayList<String> atrend_related_create_at = new ArrayList<>();
                ArrayList<String> atrend_related_update_at = new ArrayList<>();
                ArrayList<String> atrend_related_opacity = new ArrayList<>();
                ArrayList<String> atrend_related_status = new ArrayList<>();
                ArrayList<String> atrend_related_background = new ArrayList<>();
                ArrayList<String> atrend_related_thumbnail = new ArrayList<>();

                String atrend_detail_title = postResponse.atrend_detail_list.getDetail().get(0).getTitle();
                String dept1_html = postResponse.atrend_detail_list.getDetail().get(0).getDept1Html();
                String dept2_html = postResponse.atrend_detail_list.getDetail().get(0).getDept2Html();
                String dept3_html = postResponse.atrend_detail_list.getDetail().get(0).getDept3Html();
                String dept4_html = postResponse.atrend_detail_list.getDetail().get(0).getDept4Html();
                String maincontent = postResponse.atrend_detail_list.getDetail().get(0).getMaincontent();

                ArrayList<AtrendDetail.List.Detail.Item.Dept1Product> dept1_product = postResponse.atrend_detail_list.getDetail().get(0).getItems().get(0).getDept1Product();
                ArrayList<AtrendDetail.List.Detail.Item.Dept1Product> dept2_product = postResponse.atrend_detail_list.getDetail().get(0).getItems().get(0).getDept2Product();
                ArrayList<AtrendDetail.List.Detail.Item.Dept1Product> dept3_product = postResponse.atrend_detail_list.getDetail().get(0).getItems().get(0).getDept3Product();
                ArrayList<AtrendDetail.List.Detail.Item.Dept1Product> dept4_product = postResponse.atrend_detail_list.getDetail().get(0).getItems().get(0).getDept4Product();

                // detail
                for (int i = 0; i < dept1_product.size(); i++) {

                    int id = dept1_product.get(i).getId();
                    String name = dept1_product.get(i).getName();
                    String brand = dept1_product.get(i).getBrand();
                    String thumbnail = dept1_product.get(i).getThumbnail();
                    int price = dept1_product.get(i).getPrice();
                    int previousprice = dept1_product.get(i).getPreviousPrice();

                    atrend_detail_product_id.add(String.valueOf(id));
                    atrend_detail_product_name.add(name);
                    atrend_detail_product_brand.add(brand);
                    atrend_detail_product_thumbnail.add(thumbnail);
                    atrend_detail_product_price.add(String.valueOf(price));
                    atrend_detail_product_previous_price.add(String.valueOf(previousprice));

                }
                for (int i = 0; i < dept2_product.size(); i++) {

                    int id = dept2_product.get(i).getId();
                    String name = dept2_product.get(i).getName();
                    String brand = dept2_product.get(i).getBrand();
                    String thumbnail = dept2_product.get(i).getThumbnail();
                    int price = dept2_product.get(i).getPrice();
                    int previousprice = dept2_product.get(i).getPreviousPrice();

                    atrend_detail_product_id.add(String.valueOf(id));
                    atrend_detail_product_name.add(name);
                    atrend_detail_product_brand.add(brand);
                    atrend_detail_product_thumbnail.add(thumbnail);
                    atrend_detail_product_price.add(String.valueOf(price));
                    atrend_detail_product_previous_price.add(String.valueOf(previousprice));

                }
                for (int i = 0; i < dept3_product.size(); i++) {

                    int id = dept3_product.get(i).getId();
                    String name = dept3_product.get(i).getName();
                    String brand = dept3_product.get(i).getBrand();
                    String thumbnail = dept3_product.get(i).getThumbnail();
                    int price = dept3_product.get(i).getPrice();
                    int previousprice = dept3_product.get(i).getPreviousPrice();

                    atrend_detail_product_id.add(String.valueOf(id));
                    atrend_detail_product_name.add(name);
                    atrend_detail_product_brand.add(brand);
                    atrend_detail_product_thumbnail.add(thumbnail);
                    atrend_detail_product_price.add(String.valueOf(price));
                    atrend_detail_product_previous_price.add(String.valueOf(previousprice));

                }
                for (int i = 0; i < dept4_product.size(); i++) {

                    int id = dept4_product.get(i).getId();
                    String name = dept4_product.get(i).getName();
                    String brand = dept4_product.get(i).getBrand();
                    String thumbnail = dept4_product.get(i).getThumbnail();
                    int price = dept4_product.get(i).getPrice();
                    int previousprice = dept4_product.get(i).getPreviousPrice();

                    atrend_detail_product_id.add(String.valueOf(id));
                    atrend_detail_product_name.add(name);
                    atrend_detail_product_brand.add(brand);
                    atrend_detail_product_thumbnail.add(thumbnail);
                    atrend_detail_product_price.add(String.valueOf(price));
                    atrend_detail_product_previous_price.add(String.valueOf(previousprice));

                }

                // related
                for (int i = 0; i < postResponse.atrend_detail_list.getRelated().size(); i++) {
                    int id = postResponse.atrend_detail_list.getRelated().get(i).getId();
                    int user_id = postResponse.atrend_detail_list.getRelated().get(i).getUserId();
                    String type = postResponse.atrend_detail_list.getRelated().get(i).getType();
                    String product_id = postResponse.atrend_detail_list.getRelated().get(i).getProductId();
                    String title = postResponse.atrend_detail_list.getRelated().get(i).getTitle();
                    String sub_title = postResponse.atrend_detail_list.getRelated().get(i).getSubTitle();
                    String description = postResponse.atrend_detail_list.getRelated().get(i).getDescription();
                    String summary = postResponse.atrend_detail_list.getRelated().get(i).getSummary();
                    int view = postResponse.atrend_detail_list.getRelated().get(i).getView();
                    int like = postResponse.atrend_detail_list.getRelated().get(i).getLike();
                    String color = postResponse.atrend_detail_list.getRelated().get(i).getColor();
                    String start_at = postResponse.atrend_detail_list.getRelated().get(i).getStartAt();
                    String create_at = postResponse.atrend_detail_list.getRelated().get(i).getCreateAt();
                    String update_at = postResponse.atrend_detail_list.getRelated().get(i).getUpdateAt();
                    String opacity = postResponse.atrend_detail_list.getRelated().get(i).getOpacity();
                    int status = postResponse.atrend_detail_list.getRelated().get(i).getStatus();
                    String background = postResponse.atrend_detail_list.getRelated().get(i).getBackground();
                    String thumbnail = postResponse.atrend_detail_list.getRelated().get(i).getThumbnail();

                    atrend_related_id.add(String.valueOf(id));
                    atrend_related_user_id.add(String.valueOf(user_id));
                    atrend_related_type.add(type);
                    atrend_related_product_id.add(product_id);
                    atrend_related_title.add(title);
                    atrend_related_subtitle.add(sub_title);
                    atrend_related_description.add(description);
                    atrend_related_summary.add(summary);
                    atrend_related_view.add(String.valueOf(view));
                    atrend_related_like.add(String.valueOf(like));
                    atrend_related_color.add(color);
                    atrend_related_start_at.add(start_at);
                    atrend_related_create_at.add(create_at);
                    atrend_related_update_at.add(update_at);
                    atrend_related_opacity.add(opacity);
                    atrend_related_status.add(String.valueOf(status));
                    atrend_related_background.add(background);
                    atrend_related_thumbnail.add(thumbnail);
                }

                ArrayList<String> a_trend_maincontent = new ArrayList<>();
                a_trend_maincontent.add(postResponse.atrend_detail_list.getDetail().get(0).getMaincontent());

                aliseon.aliseon_setAtrend_detail_title(atrend_detail_title);

                aliseon.aliseon_setAtrend_detail_maincontent(a_trend_maincontent);

                aliseon.aliseon_setAtrend_detail_product_id(atrend_detail_product_id);
                aliseon.aliseon_setAtrend_detail_product_name(atrend_detail_product_name);
                aliseon.aliseon_setAtrend_detail_product_brand(atrend_detail_product_brand);
                aliseon.aliseon_setAtrend_detail_product_thumbnail(atrend_detail_product_thumbnail);
                aliseon.aliseon_setAtrend_detail_product_price(atrend_detail_product_price);
                aliseon.aliseon_setAtrend_detail_product_previous_price(atrend_detail_product_previous_price);

                aliseon.aliseon_setAtrend_detail_product_id(atrend_detail_product_id);
                aliseon.aliseon_setAtrend_detail_product_name(atrend_detail_product_name);
                aliseon.aliseon_setAtrend_detail_product_brand(atrend_detail_product_brand);
                aliseon.aliseon_setAtrend_detail_product_thumbnail(atrend_detail_product_thumbnail);
                aliseon.aliseon_setAtrend_detail_product_price(atrend_detail_product_price);
                aliseon.aliseon_setAtrend_detail_product_previous_price(atrend_detail_product_previous_price);

                aliseon.aliseon_setAtrend_related_id(atrend_related_id);
                aliseon.aliseon_setAtrend_related_user_id(atrend_related_user_id);
                aliseon.aliseon_setAtrend_related_type(atrend_related_type);
                aliseon.aliseon_setAtrend_related_product_id(atrend_related_product_id);
                aliseon.aliseon_setAtrend_related_title(atrend_related_title);
                aliseon.aliseon_setAtrend_related_subtitle(atrend_related_subtitle);
                aliseon.aliseon_setAtrend_related_description(atrend_related_description);
                aliseon.aliseon_setAtrend_related_summary(atrend_related_summary);
                aliseon.aliseon_setAtrend_related_view(atrend_related_view);
                aliseon.aliseon_setAtrend_related_like(atrend_related_like);
                aliseon.aliseon_setAtrend_related_color(atrend_related_color);
                aliseon.aliseon_setAtrend_related_start_at(atrend_related_start_at);
                aliseon.aliseon_setAtrend_related_create_at(atrend_related_create_at);
                aliseon.aliseon_setAtrend_related_update_at(atrend_related_update_at);
                aliseon.aliseon_setAtrend_related_opacity(atrend_related_opacity);
                aliseon.aliseon_setAtrend_related_status(atrend_related_status);
                aliseon.aliseon_setAtrend_related_background(atrend_related_background);
                aliseon.aliseon_setAtrend_related_thumbnail(atrend_related_thumbnail);

                playerdataloadhandler.sendEmptyMessage(1000);

            }

            @Override
            public void onFailure(Call<AtrendDetail> call, Throwable t) {

            }
        });


    }

    private void PopularDetailPost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        String voyage_id = aliseon.aliseon_getSelect_voyage_id();
        String lang = aliseon.aliseon_getLoginlanguage();
        String currency = aliseon.aliseon_getLogincurrency();

        Call<PopularDetail> call = AliseonAPI.PopularDetailPost(access_token, voyage_id, lang, currency);

        call.enqueue(new Callback<PopularDetail>() {
            @Override
            public void onResponse(Call<PopularDetail> call, Response<PopularDetail> response) {

                PopularDetail postResponse = (PopularDetail) response.body();

                ArrayList<String> popular_detail_id = new ArrayList<>();
                ArrayList<String> popular_detail_user_id = new ArrayList<>();
                ArrayList<String> popular_detail_product_id = new ArrayList<>();
                ArrayList<String> popular_detail_contents_id = new ArrayList<>();
                ArrayList<String> popular_detail_contents_type = new ArrayList<>();
                ArrayList<String> popular_detail_category_id = new ArrayList<>();
                ArrayList<String> popular_detail_status = new ArrayList<>();
                ArrayList<String> popular_detail_description = new ArrayList<>();
                ArrayList<String> popular_detail_create_at = new ArrayList<>();
                ArrayList<String> popular_detail_update_at = new ArrayList<>();
                ArrayList<String> popular_detail_like_count = new ArrayList<>();
                ArrayList<String> popular_detail_view_count = new ArrayList<>();
                ArrayList<String> popular_detail_comment_count = new ArrayList<>();
                ArrayList<String> popular_detail_category_en = new ArrayList<>();
                ArrayList<String> popular_detail_category_kr = new ArrayList<>();
                ArrayList<String> popular_detail_name = new ArrayList<>();
                ArrayList<String> popular_detail_photo = new ArrayList<>();
                ArrayList<String> popular_detail_contents = new ArrayList<>();
                ArrayList<String> popular_detail_items = new ArrayList<>();

                ArrayList<String> popular_detail_item_id = new ArrayList<>();
                ArrayList<String> popular_detail_item_name = new ArrayList<>();
                ArrayList<String> popular_detail_item_brand = new ArrayList<>();
                ArrayList<String> popular_detail_item_thumbnail = new ArrayList<>();
                ArrayList<String> popular_detail_item_price = new ArrayList<>();
                ArrayList<String> popular_detail_item_previous_price = new ArrayList<>();

                ArrayList<String> popular_related_id = new ArrayList<>();
                ArrayList<String> popular_related_user_id = new ArrayList<>();
                ArrayList<String> popular_related_status = new ArrayList<>();
                ArrayList<String> popular_related_description = new ArrayList<>();
                ArrayList<String> popular_related_create_at = new ArrayList<>();
                ArrayList<String> popular_related_update_at = new ArrayList<>();
                ArrayList<String> popular_related_like_count = new ArrayList<>();
                ArrayList<String> popular_related_view_count = new ArrayList<>();
                ArrayList<String> popular_related_comment_count = new ArrayList<>();
                ArrayList<String> popular_related_contents = new ArrayList<>();

                String id = String.valueOf(postResponse.getList().getDetail().get(0).getId());
                String user_id = String.valueOf(postResponse.getList().getDetail().get(0).getUserId());
                String product_id = postResponse.getList().getDetail().get(0).getProductId();
                String contents_id = postResponse.getList().getDetail().get(0).getContentsId();
                String contents_type = postResponse.getList().getDetail().get(0).getContentsType();
                String category_id = String.valueOf(postResponse.getList().getDetail().get(0).getCategoryId());
                String status = String.valueOf(postResponse.getList().getDetail().get(0).getStatus());
                String description = postResponse.getList().getDetail().get(0).getDescription();
                String create_at = postResponse.getList().getDetail().get(0).getCreateAt();
                String update_at = postResponse.getList().getDetail().get(0).getUpdateAt();
                String like_count = String.valueOf(postResponse.getList().getDetail().get(0).getLikeCount());
                String view_count = String.valueOf(postResponse.getList().getDetail().get(0).getViewCount());
                String comment_count = String.valueOf(postResponse.getList().getDetail().get(0).getCommentCount());
                String category_en = postResponse.getList().getDetail().get(0).getCategoryEn();
                String category_kr = postResponse.getList().getDetail().get(0).getCategoryKo();
                String name = postResponse.getList().getDetail().get(0).getNickname();
                String photo = postResponse.getList().getDetail().get(0).getPhoto();
                String contents = postResponse.getList().getDetail().get(0).getContents().get(0);

                popular_detail_id.add(id);
                popular_detail_user_id.add(user_id);
                popular_detail_product_id.add(product_id);
                popular_detail_contents_id.add(contents_id);
                popular_detail_contents_type.add(contents_type);
                popular_detail_category_id.add(category_id);
                popular_detail_status.add(status);
                popular_detail_description.add(description);
                popular_detail_create_at.add(create_at);
                popular_detail_update_at.add(update_at);
                popular_detail_like_count.add(like_count);
                popular_detail_view_count.add(view_count);
                popular_detail_comment_count.add(comment_count);
                popular_detail_category_en.add(category_en);
                popular_detail_category_kr.add(category_kr);
                popular_detail_name.add(name);
                popular_detail_photo.add(photo);
                popular_detail_contents.add(contents);


                for (int i = 0; i < postResponse.getList().getDetail().get(0).getItems().size(); i++) {
                    String item_id = String.valueOf(postResponse.getList().getDetail().get(0).getItems().get(i).getId());
                    String item_name = postResponse.getList().getDetail().get(0).getItems().get(i).getName();
                    String item_brand = postResponse.getList().getDetail().get(0).getItems().get(i).getBrand();
                    String item_thumbnail = postResponse.getList().getDetail().get(0).getItems().get(i).getThumbnail();
                    String item_price = String.valueOf(postResponse.getList().getDetail().get(0).getItems().get(i).getPrice());
                    String item_previous_price = String.valueOf(postResponse.getList().getDetail().get(0).getItems().get(i).getPreviousPrice());

                    popular_detail_item_id.add(item_id);
                    popular_detail_item_name.add(item_name);
                    popular_detail_item_brand.add(item_brand);
                    popular_detail_item_thumbnail.add(item_thumbnail);
                    popular_detail_item_price.add(item_price);
                    popular_detail_item_previous_price.add(item_previous_price);
                }

                for (int j = 0; j < postResponse.getList().getRelated().size(); j++) {
                    String r_id = String.valueOf(postResponse.getList().getRelated().get(j).getId());
                    String r_user_id = String.valueOf(postResponse.getList().getRelated().get(j).getUserId());
                    String r_status = String.valueOf(postResponse.getList().getRelated().get(j).getStatus());
                    String r_description = postResponse.getList().getRelated().get(j).getDescription();
                    String r_create_at = postResponse.getList().getRelated().get(j).getCreateAt();
                    String r_update_at = postResponse.getList().getRelated().get(j).getUpdateAt();
                    String r_like_count = String.valueOf(postResponse.getList().getRelated().get(j).getLikeCount());
                    String r_view_count = String.valueOf(postResponse.getList().getRelated().get(j).getViewCount());
                    String r_comment_count = String.valueOf(postResponse.getList().getRelated().get(j).getCommentCount());
                    String r_thumbnail = postResponse.getList().getRelated().get(j).getThumbnail();

                    popular_related_id.add(r_id);
                    popular_related_user_id.add(r_user_id);
                    popular_related_status.add(r_status);
                    popular_related_description.add(r_description);
                    popular_related_create_at.add(r_create_at);
                    popular_related_update_at.add(r_update_at);
                    popular_related_like_count.add(r_like_count);
                    popular_related_view_count.add(r_view_count);
                    popular_related_comment_count.add(r_comment_count);
                    popular_related_contents.add(r_thumbnail);

                }

                aliseon.aliseon_setPopular_detail_id(popular_detail_id);
                aliseon.aliseon_setPopular_detail_user_id(popular_detail_user_id);
                aliseon.aliseon_setPopular_detail_product_id(popular_detail_product_id);
                aliseon.aliseon_setPopular_detail_contents_id(popular_detail_contents_id);
                aliseon.aliseon_setPopular_detail_contents_type(popular_detail_contents_type);
                aliseon.aliseon_setPopular_detail_category_id(popular_detail_category_id);
                aliseon.aliseon_setPopular_detail_status(popular_detail_status);
                aliseon.aliseon_setPopular_detail_description(popular_detail_description);
                aliseon.aliseon_setPopular_detail_create_at(popular_detail_create_at);
                aliseon.aliseon_setPopular_detail_update_at(popular_detail_update_at);
                aliseon.aliseon_setPopular_detail_like_count(popular_detail_like_count);
                aliseon.aliseon_setPopular_detail_view_count(popular_detail_view_count);
                aliseon.aliseon_setPopular_detail_comment_count(popular_detail_comment_count);
                aliseon.aliseon_setPopular_detail_category_en(popular_detail_category_en);
                aliseon.aliseon_setPopular_detail_category_kr(popular_detail_category_kr);
                aliseon.aliseon_setPopular_detail_name(popular_detail_name);
                aliseon.aliseon_setPopular_detail_photo(popular_detail_photo);
                aliseon.aliseon_setPopular_detail_contents(popular_detail_contents);

                aliseon.aliseon_setPopular_detail_item_id(popular_detail_item_id);
                aliseon.aliseon_setPopular_detail_item_name(popular_detail_item_name);
                aliseon.aliseon_setPopular_detail_item_brand(popular_detail_item_brand);
                aliseon.aliseon_setPopular_detail_item_thumbnail(popular_detail_item_thumbnail);
                aliseon.aliseon_setPopular_detail_item_price(popular_detail_item_price);
                aliseon.aliseon_setPopular_detail_item_previous_price(popular_detail_item_previous_price);

                aliseon.aliseon_setPopular_related_id(popular_related_id);
                aliseon.aliseon_setPopular_related_user_id(popular_related_user_id);
                aliseon.aliseon_setPopular_related_status(popular_related_status);
                aliseon.aliseon_setPopular_related_description(popular_related_description);
                aliseon.aliseon_setPopular_related_create_at(popular_related_create_at);
                aliseon.aliseon_setPopular_related_update_at(popular_related_update_at);
                aliseon.aliseon_setPopular_related_like_count(popular_related_like_count);
                aliseon.aliseon_setPopular_related_view_count(popular_related_view_count);
                aliseon.aliseon_setPopular_related_comment_count(popular_related_comment_count);
                aliseon.aliseon_setPopular_related_contents(popular_related_contents);

                playerdataloadhandler.sendEmptyMessage(1000);

            }

            @Override
            public void onFailure(Call<PopularDetail> call, Throwable t) {

            }
        });

    }

    private void VoyageDetailPost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        String user_id = String.valueOf(aliseon.aliseon_getLoginid());
        String voyage_id = aliseon.aliseon_getSelect_voyage_id();
        String lang = aliseon.aliseon_getLoginlanguage();
        String currency = aliseon.aliseon_getLogincurrency();

        Call<VoyageDetail> call = AliseonAPI.VoyageDetailPost(access_token, user_id, voyage_id, 1, lang, currency);

        call.enqueue(new Callback<VoyageDetail>() {
            @Override
            public void onResponse(Call<VoyageDetail> call, Response<VoyageDetail> response) {

                VoyageDetail postResponse = (VoyageDetail) response.body();

               ArrayList<String> voyage_detail_id = new ArrayList<>();
               ArrayList<String> voyage_detail_user_id = new ArrayList<>();
               ArrayList<String> voyage_detail_product_id = new ArrayList<>();
               ArrayList<String> voyage_detail_contents_id = new ArrayList<>();
               ArrayList<String> voyage_detail_contents_type = new ArrayList<>();
               ArrayList<String> voyage_detail_category_id = new ArrayList<>();
               ArrayList<String> voyage_detail_status = new ArrayList<>();
               ArrayList<String> voyage_detail_description = new ArrayList<>();
               ArrayList<String> voyage_detail_create_at = new ArrayList<>();
               ArrayList<String> voyage_detail_update_at = new ArrayList<>();
               ArrayList<String> voyage_detail_like_count = new ArrayList<>();
               ArrayList<String> voyage_detail_view_count = new ArrayList<>();
               ArrayList<String> voyage_detail_comment_count = new ArrayList<>();
               ArrayList<String> voyage_detail_category_en = new ArrayList<>();
               ArrayList<String> voyage_detail_category_kr = new ArrayList<>();
               ArrayList<String> voyage_detail_nickname = new ArrayList<>();
               ArrayList<String> voyage_detail_photo = new ArrayList<>();
               ArrayList<String> voyage_detail_contents = new ArrayList<>();
               ArrayList<String> voyage_detail_items = new ArrayList<>();

               ArrayList<String> voyage_detail_item_id = new ArrayList<>();
               ArrayList<String> voyage_detail_item_name = new ArrayList<>();
               ArrayList<String> voyage_detail_item_brand = new ArrayList<>();
               ArrayList<String> voyage_detail_item_thumbnail = new ArrayList<>();
               ArrayList<String> voyage_detail_item_price = new ArrayList<>();
               ArrayList<String> voyage_detail_item_previous_price = new ArrayList<>();

               ArrayList<String> voyage_related_id = new ArrayList<>();
               ArrayList<String> voyage_related_user_id = new ArrayList<>();
               ArrayList<String> voyage_related_status = new ArrayList<>();
               ArrayList<String> voyage_related_description = new ArrayList<>();
               ArrayList<String> voyage_related_create_at = new ArrayList<>();
               ArrayList<String> voyage_related_update_at = new ArrayList<>();
               ArrayList<String> voyage_related_like_count = new ArrayList<>();
               ArrayList<String> voyage_related_view_count = new ArrayList<>();
               ArrayList<String> voyage_related_comment_count = new ArrayList<>();
               ArrayList<String> voyage_related_contents = new ArrayList<>();

                String id = String.valueOf(postResponse.getList().getDetail().get(0).getId());
                String user_id = String.valueOf(postResponse.getList().getDetail().get(0).getUserId());
                String product_id = postResponse.getList().getDetail().get(0).getProductId();
                String contents_id = postResponse.getList().getDetail().get(0).getContentsId();
                String contents_type = postResponse.getList().getDetail().get(0).getContentsType();
                String category_id = String.valueOf(postResponse.getList().getDetail().get(0).getCategoryId());
                String status = String.valueOf(postResponse.getList().getDetail().get(0).getStatus());
                String description = postResponse.getList().getDetail().get(0).getDescription();
                String create_at = postResponse.getList().getDetail().get(0).getCreateAt();
                String update_at = postResponse.getList().getDetail().get(0).getUpdateAt();
                String like_count = String.valueOf(postResponse.getList().getDetail().get(0).getLikeCount());
                String view_count = String.valueOf(postResponse.getList().getDetail().get(0).getViewCount());
                String comment_count = String.valueOf(postResponse.getList().getDetail().get(0).getCommentCount());
                String category_en = postResponse.getList().getDetail().get(0).getCategoryEn();
                String category_kr = postResponse.getList().getDetail().get(0).getCategoryKo();
                String name = postResponse.getList().getDetail().get(0).getNickname();
                String photo = postResponse.getList().getDetail().get(0).getPhoto();
                String contents = postResponse.getList().getDetail().get(0).getContents().get(0);

                voyage_detail_id.add(id);
                voyage_detail_user_id.add(user_id);
                voyage_detail_product_id.add(product_id);
                voyage_detail_contents_id.add(contents_id);
                voyage_detail_contents_type.add(contents_type);
                voyage_detail_category_id.add(category_id);
                voyage_detail_status.add(status);
                voyage_detail_description.add(description);
                voyage_detail_create_at.add(create_at);
                voyage_detail_update_at.add(update_at);
                voyage_detail_like_count.add(like_count);
                voyage_detail_view_count.add(view_count);
                voyage_detail_comment_count.add(comment_count);
                voyage_detail_category_en.add(category_en);
                voyage_detail_category_kr.add(category_kr);
                voyage_detail_nickname.add(name);
                voyage_detail_photo.add(photo);
                voyage_detail_contents.add(contents);


                for (int i = 0; i < postResponse.getList().getDetail().get(0).getItems().size(); i++) {
                    String item_id = String.valueOf(postResponse.getList().getDetail().get(0).getItems().get(i).getId());
                    String item_name = postResponse.getList().getDetail().get(0).getItems().get(i).getName();
                    String item_brand = postResponse.getList().getDetail().get(0).getItems().get(i).getBrand();
                    String item_thumbnail = postResponse.getList().getDetail().get(0).getItems().get(i).getThumbnail();
                    String item_price = String.valueOf(postResponse.getList().getDetail().get(0).getItems().get(i).getPrice());
                    String item_previous_price = String.valueOf(postResponse.getList().getDetail().get(0).getItems().get(i).getPreviousPrice());

                    voyage_detail_item_id.add(item_id);
                    voyage_detail_item_name.add(item_name);
                    voyage_detail_item_brand.add(item_brand);
                    voyage_detail_item_thumbnail.add(item_thumbnail);
                    voyage_detail_item_price.add(item_price);
                    voyage_detail_item_previous_price.add(item_previous_price);
                }

                for (int j = 0; j < postResponse.getList().getRelated().size(); j++) {
                    String r_id = String.valueOf(postResponse.getList().getRelated().get(j).getId());
                    String r_user_id = String.valueOf(postResponse.getList().getRelated().get(j).getUserId());
                    String r_status = String.valueOf(postResponse.getList().getRelated().get(j).getStatus());
                    String r_description = postResponse.getList().getRelated().get(j).getDescription();
                    String r_create_at = postResponse.getList().getRelated().get(j).getCreateAt();
                    String r_update_at = postResponse.getList().getRelated().get(j).getUpdateAt();
                    String r_like_count = String.valueOf(postResponse.getList().getRelated().get(j).getLikeCount());
                    String r_view_count = String.valueOf(postResponse.getList().getRelated().get(j).getViewCount());
                    String r_comment_count = String.valueOf(postResponse.getList().getRelated().get(j).getCommentCount());
                    String r_thumbnail = postResponse.getList().getRelated().get(j).getThumbnail().get(0);

                    voyage_related_id.add(r_id);
                    voyage_related_user_id.add(r_user_id);
                    voyage_related_status.add(r_status);
                    voyage_related_description.add(r_description);
                    voyage_related_create_at.add(r_create_at);
                    voyage_related_update_at.add(r_update_at);
                    voyage_related_like_count.add(r_like_count);
                    voyage_related_view_count.add(r_view_count);
                    voyage_related_comment_count.add(r_comment_count);
                    voyage_related_contents.add(r_thumbnail);

                }

                aliseon.aliseon_setVoyage_detail_id(voyage_detail_id);
                aliseon.aliseon_setVoyage_detail_user_id(voyage_detail_user_id);
                aliseon.aliseon_setVoyage_detail_product_id(voyage_detail_product_id);
                aliseon.aliseon_setVoyage_detail_contents_id(voyage_detail_contents_id);
                aliseon.aliseon_setVoyage_detail_contents_type(voyage_detail_contents_type);
                aliseon.aliseon_setVoyage_detail_category_id(voyage_detail_category_id);
                aliseon.aliseon_setVoyage_detail_status(voyage_detail_status);
                aliseon.aliseon_setVoyage_detail_description(voyage_detail_description);
                aliseon.aliseon_setVoyage_detail_create_at(voyage_detail_create_at);
                aliseon.aliseon_setVoyage_detail_update_at(voyage_detail_update_at);
                aliseon.aliseon_setVoyage_detail_like_count(voyage_detail_like_count);
                aliseon.aliseon_setVoyage_detail_view_count(voyage_detail_view_count);
                aliseon.aliseon_setVoyage_detail_comment_count(voyage_detail_comment_count);
                aliseon.aliseon_setVoyage_detail_category_en(voyage_detail_category_en);
                aliseon.aliseon_setVoyage_detail_category_kr(voyage_detail_category_kr);
                aliseon.aliseon_setVoyage_detail_nickname(voyage_detail_nickname);
                aliseon.aliseon_setVoyage_detail_photo(voyage_detail_photo);
                aliseon.aliseon_setVoyage_detail_contents(voyage_detail_contents);

                aliseon.aliseon_setVoyage_detail_item_id(voyage_detail_item_id);
                aliseon.aliseon_setVoyage_detail_item_name(voyage_detail_item_name);
                aliseon.aliseon_setVoyage_detail_item_brand(voyage_detail_item_brand);
                aliseon.aliseon_setVoyage_detail_item_thumbnail(voyage_detail_item_thumbnail);
                aliseon.aliseon_setVoyage_detail_item_price(voyage_detail_item_price);
                aliseon.aliseon_setVoyage_detail_item_previous_price(voyage_detail_item_previous_price);

                aliseon.aliseon_setVoyage_related_id(voyage_related_id);
                aliseon.aliseon_setVoyage_related_user_id(voyage_related_user_id);
                aliseon.aliseon_setVoyage_related_status(voyage_related_status);
                aliseon.aliseon_setVoyage_related_description(voyage_related_description);
                aliseon.aliseon_setVoyage_related_create_at(voyage_related_create_at);
                aliseon.aliseon_setVoyage_related_update_at(voyage_related_update_at);
                aliseon.aliseon_setVoyage_related_like_count(voyage_related_like_count);
                aliseon.aliseon_setVoyage_related_view_count(voyage_related_view_count);
                aliseon.aliseon_setVoyage_related_comment_count(voyage_related_comment_count);
                aliseon.aliseon_setVoyage_related_contents(voyage_related_contents);

                playerdataloadhandler.sendEmptyMessage(1000);
            }

            @Override
            public void onFailure(Call<VoyageDetail> call, Throwable t) {

            }
        });
    }

    private void SubscribeFromPost() {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();

        int userid = aliseon.aliseon_getLoginid();
        Log.d("USERID", String.valueOf(userid));

        int subscribeapiload = aliseon.aliseon_getSubscribeAPIload();
//        int param_subscribe_activity = Integer.parseInt(aliseon.aliseon_getCreator_author_id());

        Call<SubscribeFrom> call = AliseonAPI.SubscribeFromPost(access_token, String.valueOf(userid));

        call.enqueue(new Callback<SubscribeFrom>() {
            @Override
            public void onResponse(Call<SubscribeFrom> call, Response<SubscribeFrom> response) {
                SubscribeFrom postResponse = (SubscribeFrom) response.body();

                Log.d("VALUETEST", String.valueOf(postResponse));

                ArrayList<Integer> subscribe_creator_list_id = new ArrayList<>();
                ArrayList<String> subscribe_creator_list_nickname = new ArrayList<>();
                ArrayList<String> subscribe_creator_list_photo = new ArrayList<>();

                for (int i = 0; i < postResponse.subscribe_from_list.size(); i++) {
                    subscribe_creator_list_id.add(postResponse.subscribe_from_list.get(i).getId());
                    subscribe_creator_list_nickname.add(postResponse.subscribe_from_list.get(i).getNickname());
                    subscribe_creator_list_photo.add(postResponse.subscribe_from_list.get(i).getPhoto());
                }

                aliseon.aliseon_setSubscribe_creator_list_id(subscribe_creator_list_id);
                aliseon.aliseon_setSubscribe_creator_list_nickname(subscribe_creator_list_nickname);
                aliseon.aliseon_setSubscribe_creator_list_photo(subscribe_creator_list_photo);


                // 구독 여부 확인 (버튼 색 변화 위함)
                // 구독중이 아닐 경우, 미리 준비한 설정 및 디폴트 버튼으로 지정해줌
                Button button2 = findViewById(R.id.creator_subscribe);
                button2.setText(getResources().getString(R.string.subscribe));
                button2.setBackground(ContextCompat.getDrawable(button2.getContext(), R.drawable.buttonsetting));

                aliseon.aliseon_setSubscribe_checker(0);

                Log.d("PLAYERSUBSCRIBE", aliseon.aliseon_getCreator_author_id());

                for (int i = 0; i < subscribe_creator_list_id.size(); i++) {

                    // 문자열 비교를 위해서는 .equals를 사용해야함
                    if(subscribe_creator_list_id.get(i).equals(Integer.valueOf(aliseon.aliseon_getCreator_author_id()))) {

                        Log.d("PLAYERSUBSCRIBE", "FOUND IT!");
                        Log.d("PLAYERSUBSCRIBE", String.valueOf(aliseon.aliseon_getSubscribe_checker()));

                        // 구독 중임을 확인하였을 경우 단어 및 색 변화 적용
                        aliseon.aliseon_setSubscribe_checker(1);
                        Log.d("PLAYERSUBSCRIBE", "FOUND IT!");
                        Log.d("PLAYERSUBSCRIBE", String.valueOf(aliseon.aliseon_getSubscribe_checker()));
                        button2.setText(getResources().getString(R.string.subscribed));
                        button2.setBackground(ContextCompat.getDrawable(button2.getContext(), R.drawable.blackbuttonsetting));

                    }

                }

            }

            @Override
            public void onFailure(Call<SubscribeFrom> call, Throwable t) {

            }
        });
    }

    private void SubscribePost(String type) {
        Aliseon aliseon = (Aliseon) getApplicationContext();
        String access_token = aliseon.aliseon_getAccesstoken();
        String user_id = String.valueOf(aliseon.aliseon_getLoginid());
        String creator_id = String.valueOf(aliseon.aliseon_getCreator_author_id());

        Button button2 = findViewById(R.id.creator_subscribe);

        Call<SubscribePost> call = AliseonAPI.SubscribePost(access_token, user_id, creator_id, type);

        call.enqueue(new Callback<SubscribePost>() {
            @Override
            public void onResponse(Call<SubscribePost> call, Response<SubscribePost> response) {

                SubscribePost postResponse = (SubscribePost) response.body();

                if (response.code() == 404) {
                    Log.d("404ERROR", "" + response.message());
                    Log.d("404ERROR", "" + response.errorBody().toString());
                    try {
                        JSONObject jsonObject = null;
                        jsonObject = new JSONObject(response.errorBody().string());
                        String userMessage = jsonObject.getString("message");
                        Log.d("RESULTERROR", userMessage);

                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }

                } else {


                    Log.d("CREATORSTATUS", String.valueOf(postResponse.getStatus()));

                    SubscribeFromPost();
//                    onResume();

                }

            }

            @Override
            public void onFailure(Call<SubscribePost> call, Throwable t) {

            }
        });
    }

//    public class playerNextVideoHandler extends Handler {
//        @Override
//        public void handleMessage(Message msg) {
//            // 다른 Thread에서 전달받은 Message 처리
//            if (msg.what == 1000) {
//                if (nexttime == 0) {
//                    Log.d("state_ended", "end");
//                    nexttime = 5;
//                    finish();
//
//                    playerdataload = 0;
//                    if (typeselector < 10) {
//                        typeselector = typeselector + 10;
//                    }
//                    Intent intent = new Intent(AliseonOTTPlayerActivity.this, AliseonOTTPlayerActivity.class);
//                    intent.putExtra("index", 0);
//                    intent.putExtra("category", typeselector);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//
//
//                } else {
//                    switch (prf.getString("language", "")) {
//                        case "kr":
//                            TV5.setText(nexttime + getResources().getString(R.string.second) + " " + getResources().getString(R.string.nextvideo));
//                            break;
//                        case "en":
//                            TV5.setText(getResources().getString(R.string.nextvideo) + " " + nexttime + " " + getResources().getString(R.string.second));
//                            break;
//                        case "ar":
//                            TV5.setText(getResources().getString(R.string.nextvideo) + " " + nexttime + " " + getResources().getString(R.string.second));
//                            break;
//                    }
//                    nexttime--;
//                    playernextvideohandler.sendEmptyMessageDelayed(1000, 1000);
//                }
//            }
//        }
//    }

}