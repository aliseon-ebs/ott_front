package com.aliseon.ott;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterSpinner4  extends BaseAdapter {
    Context context;
    List<String> money;
    LayoutInflater inflater;


    public AdapterSpinner4(Context context, List<String> money){
        this.context = context;
        this.money = money;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        if(money!=null) return money.size();
        else return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.spinner_spinner_normal, parent, false);
        }

        if(money!=null){
            //데이터세팅
            String text = money.get(position);
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
        String text = money.get(position);
        ((TextView)convertView.findViewById(R.id.spinnerText)).setText(text);
        ((TextView)convertView.findViewById(R.id.spinnerText)).setTextSize(10);

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return money.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
