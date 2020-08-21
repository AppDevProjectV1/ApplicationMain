package com.example.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CanteenAdapter extends ArrayAdapter<CanteenClass> {
    //define these variable customadapter constructor


    public CanteenAdapter(@NonNull Context context, ArrayList<CanteenClass> data) {
        super(context,0,data);
    }

    //this method is used to set the value to listview item wih the corrosponding position and return the listviewitem
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;


        if(listItem==null){
            listItem= LayoutInflater.from(getContext()).inflate(R.layout.canteen_list_item, parent, false);
        }

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.canteenimage);
        TextView textViewName = (TextView) listItem.findViewById(R.id.canteentext);

       CanteenClass folder = getItem(position);
        imageViewIcon.setImageResource(folder.getMimagecanteen());
        textViewName.setText(folder.getMnamecanteen());
        return listItem;
    }
}