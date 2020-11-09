package com.aliseon.ott;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.aliseon.ott.Variable.contentcounter;
import static com.aliseon.ott.Variable.imageurl;
import static com.aliseon.ott.Variable.player_feed_list_content;
import static com.aliseon.ott.Variable.player_feed_list_crop;

public class ContentsPlayer extends LinearLayout {

    public ContentsPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public ContentsPlayer(Context context) {
        super(context);

        init(context);
    }
    private void init(Context context){

        Log.d("DATA DEBUGGING", String.valueOf(contentcounter));

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

        mainlayout1.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == false)
                {
                    mainlayout1.setBackground(null);
                    contenttitle.setTextColor(Color.rgb(255,255,255));
                    contentcreatorinfo.setTextColor(Color.rgb(255,255,255));
                } else {
                    mainlayout1.setBackgroundColor(Color.rgb(255,255,255));
                    contenttitle.setTextColor(Color.rgb(0,0,0));
                    contentcreatorinfo.setTextColor(Color.rgb(0,0,0));
                }
            }

        });



    }
}

