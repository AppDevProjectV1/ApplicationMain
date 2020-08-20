package com.example.appdevproject;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class GroupAdapter extends ArrayAdapter<ModelClass> {
    //define these variable customadapter constructor
    Context mContext;
    int layoutResourceId;





    public GroupAdapter(Context mContext,ArrayList<ModelClass> data ) {
        super(mContext,0,data);
    }

    //this method is used to set the value to listview item wih the corrosponding position and return the listviewitem
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;


        if(listItem==null){
            listItem= LayoutInflater.from(getContext()).inflate(R.layout.group_list_item, parent, false);
        }

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.groupimage);
        TextView textViewName = (TextView) listItem.findViewById(R.id.groupname);
        TextView textViewinfo = (TextView) listItem.findViewById(R.id.groupinfo);

         ModelClass folder = getItem(position);


        imageViewIcon.setImageResource(folder.getMimage());
        textViewName.setText(folder.getMname());
        textViewinfo.setText(folder.getMinfo());

        return listItem;
    }
}
