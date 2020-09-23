package com.aliseon.ott;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import static com.aliseon.ott.Variable.addoption;

public class AdapterSpinner5  extends BaseAdapter {
    Context context;
    List<String> option;
    LayoutInflater inflater;


    public AdapterSpinner5(Context context, List<String> option){
        this.context = context;
        this.option = option;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        if(option!=null) return option.size();
        else return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.spinner_spinner_normal, parent, false);
        }

        if(option!=null){
            //데이터세팅
            String text = option.get(position);
            ((TextView)convertView.findViewById(R.id.spinnerText)).setText(text);
            ((TextView)convertView.findViewById(R.id.spinnerText)).setTextSize(10);
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = inflater.inflate(R.layout.spinner_spinner_dropdown, parent, false);
        }

        //데이터세팅
        String text = option.get(position);
        ((TextView)convertView.findViewById(R.id.spinnerText)).setText(text);
        ((TextView)convertView.findViewById(R.id.spinnerText)).setTextSize(10);

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        addoption.add(option.get(position));
        return option.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
