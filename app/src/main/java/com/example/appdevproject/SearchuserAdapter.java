package com.example.appdevproject;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;


class  SearchUsersAdapter extends FirebaseRecyclerAdapter<UserHelperClass,SearchUsersAdapter.myviewholder>
{
    public  SearchUsersAdapter(@NonNull FirebaseRecyclerOptions<UserHelperClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull  UserHelperClass userHelperClass)
    {
        holder.name.setText(userHelperClass.getUsername());
        holder.course.setText(userHelperClass.getDept());
        holder.year.setText(userHelperClass.getYear()+" year");
      //  holder.img.setImageResource(R.mipmap.addphoto);
        Glide.with(holder.img.getContext()).load(userHelperClass.getImageUrl()).into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.searchusersingleitem,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        TextView name,course,email,year;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.userppp);
            name = (TextView) itemView.findViewById(R.id.nametext);
            course = (TextView) itemView.findViewById(R.id.coursetext);
            year = (TextView) itemView.findViewById(R.id.yeartext);
            //  email=(TextView)itemView.findViewById(R.id.emailtext);
        }

    }

}
