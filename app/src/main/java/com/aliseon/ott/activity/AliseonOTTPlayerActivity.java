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

import com.aliseon.ott.CartPlayer;
import com.aliseon.ott.CircleImageView;
import com.aliseon.ott.ContentsPlayer;
import com.aliseon.ott.R;
import com.aliseon.ott.networktask.NetworkTaskAtrendDetail;
import com.aliseon.ott.networktask.NetworkTaskTvottPopularDetail;
import com.aliseon.ott.networktask.NetworkTaskTvottVoyageDetail;
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

import java.util.Locale;

import static com.aliseon.ott.Variable.loginid;
import static com.aliseon.ott.Variable.my_list_description;
import static com.aliseon.ott.Variable.my_list_id;
import static com.aliseon.ott.Variable.nowurl;
import static com.aliseon.ott.Variable.api_atrend_detail;
import static com.aliseon.ott.Variable.api_tvott_popular_detail;
import static com.aliseon.ott.Variable.api_voyage_detail;
import static com.aliseon.ott.Variable.atrend_detail_maincontent;
import static com.aliseon.ott.Variable.atrend_detail_product_name;
import static com.aliseon.ott.Variable.atrend_detail_product_price;
import static com.aliseon.ott.Variable.atrend_detail_product_thumbnail;
import static com.aliseon.ott.Variable.atrend_id;
import static com.aliseon.ott.Variable.atrend_related_description;
import static com.aliseon.ott.Variable.atrend_related_id;
import static com.aliseon.ott.Variable.atrend_related_thumbnail;
import static com.aliseon.ott.Variable.atrend_subtitle;
import static com.aliseon.ott.Variable.atrend_title;
import static com.aliseon.ott.Variable.creatorauthorid;
import static com.aliseon.ott.Variable.creatorprofile;
import static com.aliseon.ott.Variable.creatortitle;
import static com.aliseon.ott.Variable.imageurl;
import static com.aliseon.ott.Variable.maintitle;
import static com.aliseon.ott.Variable.player_feed_list_author_nickname;
import static com.aliseon.ott.Variable.player_feed_list_author_picture;
import static com.aliseon.ott.Variable.player_feed_list_content;
import static com.aliseon.ott.Variable.player_feed_list_crop;
import static com.aliseon.ott.Variable.player_feed_list_id;
import static com.aliseon.ott.Variable.player_feed_list_views;
import static com.aliseon.ott.Variable.playerfeedimage;
import static com.aliseon.ott.Variable.popular_description;
import static com.aliseon.ott.Variable.popular_detail_contents;
import static com.aliseon.ott.Variable.popular_detail_item_name;
import static com.aliseon.ott.Variable.popular_detail_item_price;
import static com.aliseon.ott.Variable.popular_detail_item_thumbnail;
import static com.aliseon.ott.Variable.popular_id;
import static com.aliseon.ott.Variable.popular_related_contents;
import static com.aliseon.ott.Variable.popular_related_description;
import static com.aliseon.ott.Variable.popular_related_id;
import static com.aliseon.ott.Variable.select;
import static com.aliseon.ott.Variable.subscribe_checker;
import static com.aliseon.ott.Variable.subtitle;
import static com.aliseon.ott.Variable.typeselector;
import static com.aliseon.ott.Variable.childlist;
import static com.aliseon.ott.Variable.contentcounter;
import static com.aliseon.ott.Variable.focusing;
import static com.aliseon.ott.Variable.playerdataload;
import static com.aliseon.ott.Variable.refresh_num;
import static com.aliseon.ott.Variable.voyage_description;
import static com.aliseon.ott.Variable.voyage_detail_contents;
import static com.aliseon.ott.Variable.voyage_detail_item_name;
import static com.aliseon.ott.Variable.voyage_detail_item_price;
import static com.aliseon.ott.Variable.voyage_detail_item_thumbnail;
import static com.aliseon.ott.Variable.voyage_id;
import static com.aliseon.ott.Variable.voyage_related_contents;
import static com.aliseon.ott.Variable.voyage_related_description;
import static com.aliseon.ott.Variable.voyage_related_id;
import static com.aliseon.ott.Variable.param_atrend_id;
import static com.aliseon.ott.Variable.select_voyage_id;
import static com.aliseon.ott.Variable.playerfeedname;
import static com.aliseon.ott.Variable.playerfeedpricecomputed;
import static com.aliseon.ott.Variable.voyageresult_description;
import static com.aliseon.ott.Variable.voyageresult_id;

public class AliseonOTTPlayerActivity extends AppCompatActivity {

    public static PlayerCreatorSelectHandler playercreatorselecthandler;
//    public static playerNextVideoHandler playernextvideohandler;
    public static PlayerDataLoadHandler playerdataloadhandler;

    private PlayerView exoPlayerView;
    private SimpleExoPlayer player;

    private Boolean playWhenReady = true;
    private int currentWindow = 0;
    private Long playbackPosition = 0L;

    private static String TAG = "데이터 값";



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

        prf = getSharedPreferences("login_session", MODE_PRIVATE);

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

        playercreatorselecthandler = new PlayerCreatorSelectHandler();
//        playernextvideohandler = new playerNextVideoHandler();
        playerdataloadhandler = new PlayerDataLoadHandler();

        player_feed_list_id.clear();
        player_feed_list_crop.clear();
        player_feed_list_content.clear();
        player_feed_list_author_nickname.clear();
        player_feed_list_author_picture.clear();
        player_feed_list_views.clear();

        Intent intent = getIntent();

        select = intent.getExtras().getInt("index");
        // this is just idea
        typeselector = intent.getExtras().getInt("category");

//        if (prf.getString("userinfo_name", "").equals("empty")
//                && prf.getString("userinfo_picture", "").equals("empty")
//                && prf.getInt("user_id", 0) == 0) {
//            playercreatorselecthandler.post(new Runnable() {
//                @Override
//                public void run() {
//                    offlinemode = 1;
//                    NetworkTaskTvottPlayerVoyage networktasktvottplayerfeed = new NetworkTaskTvottPlayerVoyage(api_tvott_popular, null);
////                    networktasktvottplayerfeed.execute();
//                }
//            });
//        } else {
//            playercreatorselecthandler.post(new Runnable() {
//                @Override
//                public void run() {
//                    offlinemode = 0;
//                    NetworkTaskTvottPlayerVoyage networktasktvottplayerfeed = new NetworkTaskTvottPlayerVoyage(api_voyage, null);
////                    networktasktvottplayerfeed.execute();
//                }
//            });
//        }







        exoPlayerView = findViewById(R.id.exoPlayerView);

        ImageView imageView = (ImageView) findViewById(R.id.exoplayerback);
//        ImageView imageView2= (ImageView) findViewById(R.id.exo_rew);
        imageView3 = (ImageView) findViewById(R.id.exo_play);
        imageView4 = (ImageView) findViewById(R.id.exo_pause);
//        ImageView imageView5= (ImageView) findViewById(R.id.exo_ffwd);

        progressbar = (ProgressBar) findViewById(R.id.exo_progressbar);
        framelayoutprogressbar = (FrameLayout) findViewById(R.id.exo_framelayoutprogressbar);
        framelayoutplaypause = (FrameLayout) findViewById(R.id.exo_framelayoutplaypause);

        DefaultTimeBar timebar = (DefaultTimeBar) findViewById(R.id.exo_progress);

        imageView.setFocusableInTouchMode(true);
        imageView.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//        imageView2.setFocusableInTouchMode(true);
//        imageView2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));
        imageView3.setFocusableInTouchMode(true);
        imageView3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
        imageView4.setFocusableInTouchMode(true);
        imageView4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
        progressbar.setFocusableInTouchMode(true);
        progressbar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ovalbuttonsetting));
//        imageView5.setFocusableInTouchMode(true);
//        imageView5.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.mainbuttonsetting));

        progressbar.requestFocus();

        TextView TV1 = (TextView) findViewById(R.id.title_tv1);
        TextView TV2 = (TextView) findViewById(R.id.title_tv2);
        TextView TV3 = (TextView) findViewById(R.id.title_tv3);
        CircleImageView CIV = (CircleImageView) findViewById(R.id.creator_profile);
        TextView TV4 = (TextView) findViewById(R.id.creator_name);
        Button button = (Button) findViewById(R.id.creator_subscribe);

        TV1.setText(subtitle);
        TV2.setText(maintitle);
        TV3.setText(creatortitle);
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
        focusing = -1;
        playerdataload = 0;
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

        refresh_num = 2;

        super.onResume();
        Intent intent = getIntent();

        select = intent.getExtras().getInt("index");
        // this is just idea
        typeselector = intent.getExtras().getInt("category");

        Log.d("불러온 카테고리 번호 : ", String.valueOf(typeselector));
        Log.d("불러온 Index 번호 : ", String.valueOf(select));


        // 선택한 영상의 데이터
        switch (typeselector) {
            case 1:
                // Atrend
                maintitle = atrend_title.get(select);
                subtitle = atrend_subtitle.get(select);
                player_feed_list_content = atrend_related_description;
                player_feed_list_crop = atrend_related_thumbnail;
                break;
            case 2:
                // Popular
                maintitle = popular_description.get(select);
                subtitle = popular_description.get(select);
                break;
            case 3:
                // Popular
                maintitle = voyage_description.get(select);
                subtitle = voyage_description.get(select);
                break;
            case 4:
                // My
                maintitle = my_list_description.get(select);
                subtitle = my_list_description.get(select);
                break;

            case 5:
                // Voyage result
                maintitle = voyageresult_description.get(select);
                subtitle = voyageresult_description.get(select);
                break;

            case 11:
                // Atrend - related
                maintitle = player_feed_list_content.get(select);
                subtitle = player_feed_list_content.get(select);
                break;

            case 12:


        }

        Log.d("MAINTITLE :: ", maintitle);
        Log.d("SubTITLE :: ", subtitle);

        // API 로드를 위한 코드
        if (playerdataload == 0) {
            playerdataloadhandler.post(new Runnable() {
                @Override
                public void run() {
                    Log.d("Selected ::", typeselector + "/" + select);
                    switch (typeselector) {
                        case 1:
                            // Atrend
                            param_atrend_id = atrend_id.get(select);
                            NetworkTaskAtrendDetail networktastatrenddetail = new NetworkTaskAtrendDetail(api_atrend_detail, null);
                            networktastatrenddetail.execute();
                            break;

                        case 2:
                            // Popular
                            select_voyage_id = popular_id.get(select);
                            NetworkTaskTvottPopularDetail networkTaskTvottpopularDetail = new NetworkTaskTvottPopularDetail(api_tvott_popular_detail, null);
                            networkTaskTvottpopularDetail.execute();
                            break;

                        case 3:
                            // Voyage
                            select_voyage_id = voyage_id.get(select);
                            NetworkTaskTvottVoyageDetail networkTaskTvottVoyageDetail = new NetworkTaskTvottVoyageDetail(api_voyage_detail, null);
                            networkTaskTvottVoyageDetail.execute();
                            break;

                        case 4:
                            // My
                            select_voyage_id = my_list_id.get(select);
                            NetworkTaskTvottVoyageDetail networkTaskTvottMyDetail = new NetworkTaskTvottVoyageDetail(api_voyage_detail, null);
                            networkTaskTvottMyDetail.execute();
                            break;

                        case 5:
                            // Voyage Result
                            select_voyage_id = voyageresult_id.get(select);
                            NetworkTaskTvottVoyageDetail networkTaskTvottvoyageresultDetail = new NetworkTaskTvottVoyageDetail(api_voyage_detail, null);
                            networkTaskTvottvoyageresultDetail.execute();
                            break;

                        case 11:
                            param_atrend_id = atrend_related_id.get(select);
                            NetworkTaskAtrendDetail networktastatrendrelateddetail = new NetworkTaskAtrendDetail(api_atrend_detail, null);
                            networktastatrendrelateddetail.execute();
                            break;

                        case 12:
                            select_voyage_id = popular_related_id.get(select);
                            NetworkTaskTvottPopularDetail networkTaskTvottpopularrelatedDetail = new NetworkTaskTvottPopularDetail(api_tvott_popular_detail, null);
                            networkTaskTvottpopularrelatedDetail.execute();
                            break;

                        case 13:
                            select_voyage_id = voyage_related_id.get(select);
                            NetworkTaskTvottVoyageDetail networkTaskTvottVoyagerelatedDetail = new NetworkTaskTvottVoyageDetail(api_voyage_detail, null);
                            networkTaskTvottVoyagerelatedDetail.execute();
                            break;

                        case 14:
                            select_voyage_id = voyage_related_id.get(select);
                            NetworkTaskTvottVoyageDetail networkTaskTvottMyrelatedDetail = new NetworkTaskTvottVoyageDetail(api_voyage_detail, null);
                            networkTaskTvottMyrelatedDetail.execute();
                            break;

                        case 15:
                            select_voyage_id = voyage_related_id.get(select);
                            NetworkTaskTvottVoyageDetail networkTaskTvottvoyageresultrelatedDetail = new NetworkTaskTvottVoyageDetail(api_voyage_detail, null);
                            networkTaskTvottvoyageresultrelatedDetail.execute();
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
        TV3.setText(creatortitle);
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (prf.getString("userinfo_name", "").equals("empty")
                        && prf.getString("userinfo_picture", "").equals("empty")
                        && prf.getInt("user_id", 0) == 0)
                {
                    // 비회원일 경우


                } else {
//                    if (subscribe_checker == 0) {
//                        param_subscr_id = creatorauthorid;
//                        subscribe_checker = 1;
//                        NetworkTaskSubscribeChannels networktasksubscribechannels = new NetworkTaskSubscribeChannels(api_subscribe_channels, null);
//                        networktasksubscribechannels.execute();
//                    }
//
//                    if (subscribe_checker == 1) {
//                    param_unsubscr_id = creatorauthorid;
//                    subscribe_checker = 0;
//                        NetworkTaskSubscribeUnsubscribe networktasksubscribeunsubscribe = new NetworkTaskSubscribeUnsubscribe(api_subscribe_unsubscribe, null);
//                        networktasksubscribeunsubscribe.execute();
//                    }
                }
            }
        });


        // 기존에 추가된 상품 목록을 지우기 위함
        LinearLayout cartplayerlayout = (LinearLayout) findViewById(R.id.cartlayout);
        cartplayerlayout.removeAllViews();

        try {

//            if (playerfeedid.size() == 0) {
//                cartscrollview.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
//            }

            // 영상의 상품 목록 표시
            for (int i = 0; i < playerfeedimage.size(); i++) {

                try {
                    CartPlayer cartplayer = new CartPlayer(getApplicationContext());

                    Button cartproductadd = (Button) cartplayer.findViewById(R.id.cartproductadd1);

                    final int j = i;
                    cartproductadd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (prf.getString("userinfo_name", "").equals("empty")
                                    && prf.getString("userinfo_picture", "").equals("empty")
                                    && prf.getInt("user_id", 0) == 0) {

                                Intent intent = new Intent(AliseonOTTPlayerActivity.this, AliseonOTTPlayerCartLoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);

                            } else {
//                                param_cart_id = playerfeedmipid.get(parentlist).get(j);
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

                    if (player_feed_list_content.size() - 1 == 0) {
                        contentscrollview.setVisibility(View.GONE);
                    } else {
                        contentscrollview.setVisibility(View.VISIBLE);
                    }
                    try {
                        /* Atrend의 경우 닉네임이 없어 현재는 하단의 뷰가 닉네임, 프로필 이미지가 등장하지 않음.
                           예외처리 필요,
                        */
                        ContentsPlayer contentsplayer = new ContentsPlayer(getApplicationContext());
                        LinearLayout mainlayout1 = (LinearLayout) contentsplayer.findViewById(R.id.contentlayout);

                    final int j = i;
                    contentsplayer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            playerdataload = 0;

                            if (typeselector < 10) {
                                typeselector = typeselector + 10;
                            }

                            intent.putExtra("index", j);
                            intent.putExtra("category", typeselector);
                            Intent intent = new Intent(AliseonOTTPlayerActivity.this, AliseonOTTPlayerActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                        }
                    });

                    if (i == 0) {

                        player.addListener(new Player.EventListener() {

                            @Override
                            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

                                switch (playbackState) {

//                                    case Player.STATE_ENDED:
//                                        playernextvideohandler.post(new Runnable() {
//                                            @Override
//                                            public void run() {
//                                                playernextvideohandler.sendEmptyMessage(1000);
//                                            }
//                                        });

                                }
                            }
                        });

                    }

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
                    contentcounter++;
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

                playerdataload = 1;

                switch (typeselector) {
                    case 1:
                        // Atrend
                        nowurl = imageurl + atrend_detail_maincontent.get(0);
                        player_feed_list_content = atrend_related_description;
                        player_feed_list_crop = atrend_related_thumbnail;
                        player_feed_list_id = atrend_related_id;

                        playerfeedimage = atrend_detail_product_thumbnail;
                        playerfeedname = atrend_detail_product_name;
                        playerfeedpricecomputed = atrend_detail_product_price;
                        break;
                    case 2:
                        // Popular
                        nowurl = imageurl + popular_detail_contents.get(0);

                        player_feed_list_content = popular_related_description;
                        player_feed_list_crop = popular_related_contents;
                        player_feed_list_id = popular_related_id;

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
                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;

                    case 11:
                        // Atrend - Related
                        nowurl = imageurl + atrend_detail_maincontent.get(0);

                        player_feed_list_content = atrend_related_description;
                        player_feed_list_crop = atrend_related_thumbnail;
                        player_feed_list_id = atrend_related_id;

                        playerfeedimage = atrend_detail_product_thumbnail;
                        playerfeedname = atrend_detail_product_name;
                        playerfeedpricecomputed = atrend_detail_product_price;
                        break;

                    case 12:
                        // Popular - Related
                        nowurl = imageurl + popular_detail_contents.get(0);

                        player_feed_list_content = popular_related_description;
                        player_feed_list_crop = popular_related_contents;
                        player_feed_list_id = popular_related_id;

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

                        playerfeedimage = voyage_detail_item_thumbnail;
                        playerfeedname = voyage_detail_item_name;
                        playerfeedpricecomputed = voyage_detail_item_price;
                        break;
                }

                Log.d("재생되는 링크 ::", nowurl);

                // API 로드가 완료될 경우 영상 재생과 onResume으로 화면을 새로고침
                initializePlayer();
                onResume();

            } else if (msg.what == 800) {
                Log.d("ERROR ::", "Player Data Loader ERROR");
            }
        }
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