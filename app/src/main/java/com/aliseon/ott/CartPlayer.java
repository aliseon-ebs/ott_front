package com.aliseon.ott;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CartPlayer extends LinearLayout{

    public ImageView cartimage;

    Aliseon aliseon = (Aliseon) getContext();

    public CartPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);

        attrs.getAttributeCount();
        init(context);
    }

    public CartPlayer(Context context) {
        super(context);

        init(context);
    }
    private void init(Context context){

        String imageurl = aliseon.aliseon_getImageURL();

        int childlist = aliseon.aliseon_getChild_list();

        String logincurrency = aliseon.aliseon_getLogincurrency();

        ArrayList<String> playerfeedimage = aliseon.aliseon_getPlayer_feed_list_crop();
        ArrayList<String> playerfeedname = aliseon.aliseon_getPlayer_feed_list_author_nickname();
        ArrayList<String> playerfeedpricecomputed = aliseon.aliseon_Playerfeedpricecomputed();

        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.player_cart,this,true);

        cartimage = (ImageView) findViewById(R.id.cartimage1);

        TextView cartproductname = (TextView) findViewById(R.id.cartproductname1);
        TextView cartproductprice = (TextView) findViewById(R.id.cartproductprice1);
        Button cartproductadd = (Button) findViewById(R.id.cartproductadd1);

        Glide.with(this).load(imageurl + playerfeedimage.get(childlist)).into(cartimage);
        cartproductname.setText(playerfeedname.get(childlist));
        cartproductprice.setText(playerfeedpricecomputed.get(childlist) + " " + logincurrency);

    }
}
