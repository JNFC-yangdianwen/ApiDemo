package com.example.yangdianwen.apidemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdianwen on 16-7-11.
 */
public class DateAdapter extends BaseAdapter {
    List<String>datas;

    public DateAdapter() {
     datas=new ArrayList<>();
    }
     public void addData(List<String> data){
         datas.addAll(data);
     }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        }
        TextView tv_show = (TextView) convertView.findViewById(R.id.tv);
        tv_show.setText(datas.get(position));
        return convertView;
    }
}
