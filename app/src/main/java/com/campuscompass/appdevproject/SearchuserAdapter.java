package com.campuscompass.appdevproject;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appdevproject.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;


class  SearchUsersAdapter extends FirebaseRecyclerAdapter<UserHelperClass,SearchUsersAdapter.myviewholder>
{  private   FirebaseRecyclerOptions<UserHelperClass> moptions;
 //private List<UserHelperClass> helperClasses;
    String mobilenumber;

    Context mcontext;

    public  SearchUsersAdapter(Context context,@NonNull FirebaseRecyclerOptions<UserHelperClass> options) {
        super(options);

        this.mcontext=context;
        this.moptions=options;

    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull  UserHelperClass userHelperClass)
    {
        holder.name.setText(userHelperClass.getUsername());
        holder.course.setText(userHelperClass.getDept());
        holder.year.setText(userHelperClass.getYear()+" year");
        holder.phonenumber.setText(userHelperClass.getMobilenumber() );
      //  holder.img.setImageResource(R.mipmap.addphoto);
        Glide.with(holder.img.getContext()).load(userHelperClass.getImageUrl()).into(holder.img);
          mobilenumber= userHelperClass.getMobilenumber();

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.searchusersingleitem,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder  implements View.OnClickListener
    {
        CircleImageView img;
        View loadingindicator;
        TextView name,course,email,year,phonenumber;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.userppp);
            name = (TextView) itemView.findViewById(R.id.nametext);
            course = (TextView) itemView.findViewById(R.id.coursetext);
            year = (TextView) itemView.findViewById(R.id.yeartext);
           phonenumber=(TextView)itemView.findViewById(R.id.movno);
            itemView.setOnClickListener(this);
            //  email=(TextView)itemView.findViewById(R.id.emailtext);
        }
        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();

            //Toast.makeText(mcontext,"position"+adapterPosition,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mcontext , IndividualUserProfile.class);
            intent.putExtra("apkmobile" ,phonenumber.getText().toString());
            mcontext.startActivity(intent);
         //   Intent intent =new Intent(context,)

        }
    }

}
