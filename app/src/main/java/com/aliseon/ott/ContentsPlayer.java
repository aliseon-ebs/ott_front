package com.aliseon.ott;

import android.app.AppComponentFactory;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

public class ContentsPlayer extends LinearLayout {

    Aliseon aliseon = (Aliseon) getContext();

    public ContentsPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public ContentsPlayer(Context context) {
        super(context);

        init(context);
    }
    private void init(Context context){

        String imageurl = aliseon.aliseon_getImageURL();
        int contentcounter = aliseon.aliseon_getContent_counter();
        ArrayList<String> player_feed_list_crop = aliseon.aliseon_getPlayer_feed_list_crop();
        ArrayList<String> player_feed_list_content = aliseon.aliseon_getPlayer_feed_list_content();

        Log.d("DATA DEBUGGING", String.valueOf(contentcounter));
        Log.d("DATA DEBUGGING", String.valueOf(player_feed_list_crop));
        Log.d("DATA DEBUGGING", player_feed_list_crop.get(contentcounter));

        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.player_contents,this,true);

        LinearLayout mainlayout1 = (LinearLayout) findViewById(R.id.mainlayout1);

        ImageView contentimage = (ImageView) findViewById(R.id.contentimage);
        Glide.with(this).load(imageurl + player_feed_list_crop.get(contentcounter)).into(contentimage);

        CircleImageView contentcreatorimage = (CircleImageView) findViewById(R.id.contentcreatorimage);
//        Glide.with(this).load(imageurl + player_feed_list_author_picture.get(contentcounter)).into(contentcreatorimage);

        TextView contenttitle = (TextView) findViewById(R.id.contenttitle);
        contenttitle.setText(player_feed_list_content.get(contentcounter));

        TextView contentcreatorinfo = (TextView) findViewById(R.id.contentcreatorinfo);
//        contentcreatorinfo.setText(player_feed_list_author_nickname.get(contentcounter) + "\n" + player_feed_list_views.get(contentcounter) + " views");



    }
}

