package com.aliseon.ott;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdapterSpinner1 extends ArrayAdapter<String> {
    String[] Number ;
    int[] CountryImage;
    Context mContext;

    public AdapterSpinner1(@NonNull Context context, String[] names, int[] images) {
        super(context, R.layout.spinner_country_dropdown);

        this.Number = names;
        this.CountryImage = images;
        this.mContext = context;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return Number.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder mViewHolder = new ViewHolder();

        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.spinner_country_dropdown, parent, false);

            mViewHolder.mImage = (ImageView) convertView.findViewById(R.id.spinnerImage);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.spinnerText);
            convertView.setTag(mViewHolder);

        } else {

            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.mImage.setImageResource(CountryImage[position]);
        mViewHolder.mName.setText(Number[position]);

        return convertView;
    }

    private static class ViewHolder {

        ImageView mImage;
        TextView mName;
    }
}


