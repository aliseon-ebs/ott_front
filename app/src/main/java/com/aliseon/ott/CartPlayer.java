package com.aliseon.ott;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.aliseon.ott.Variable.childlist;
import static com.aliseon.ott.Variable.imageurl;
import static com.aliseon.ott.Variable.logincurrency;
import static com.aliseon.ott.Variable.playerfeedimage;
import static com.aliseon.ott.Variable.playerfeedname;
import static com.aliseon.ott.Variable.playerfeedpricecomputed;

public class CartPlayer extends LinearLayout{

    public ImageView cartimage;

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
