package com.example.appdevproject;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CareerAdapter extends ArrayAdapter<DrawerModel> {


    Context mContext;
    int layoutResourceId;
    DrawerModel[] data=null;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void OnItemClick(String name);
    }


    public CareerAdapter(Context mContext, int layoutResourceId, DrawerModel[] data,OnItemClickListener onItemClickListener)
    {
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data=data;
        this.onItemClickListener=onItemClickListener;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName =  listItem.findViewById(R.id.textViewName);

        DrawerModel folder = data[position];


        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClick(folder.name);
                v.setBackgroundColor(Color.parseColor("#311B92"));
                textViewName.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        return listItem;
    }
}
