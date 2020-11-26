package com.campuscompass.appdevproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdevproject.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


class  StudentFeedsAdapter extends  RecyclerView.Adapter<StudentFeedsAdapter.myviewholder> {
    private List<InterestsClass> moptions;
    //private List<UserHelperClass> helperClasses;
    String mobilenumber;

    Context mcontext;

    public StudentFeedsAdapter(Context context,List<InterestsClass> options) {

        moptions = options;
        mcontext=context;
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feeds_list_item, parent, false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.interestname.setText(moptions.get(position).getMinterestname());
        holder.basicinfo.setText(moptions.get(position).getMbasictext());
        holder.src1.setImageResource(moptions.get(position).getMimageid1());
        holder.src2.setImageResource(moptions.get(position).getMimageid2());
        holder.src3.setImageResource(moptions.get(position).getMimageid3());
        holder.src4.setImageResource(moptions.get(position).getMimageid4());
        holder.link1.setText(moptions.get(position).getMlink1());
        holder.link2.setText(moptions.get(position).getMlink2());
        holder.link3.setText(moptions.get(position).getMlink3());
       holder.link4.setText(moptions.get(position).getMlink4());
        holder.link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(moptions.get(position).getMlink1()));
                mcontext.startActivity(intent);
            }
        });
        holder.link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(moptions.get(position).getMlink2()));
                mcontext.startActivity(intent);
            }
        });
        holder.link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(moptions.get(position).getMlink3()));
                mcontext.startActivity(intent);
            }
        });
        holder.link4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(moptions.get(position).getMlink4()));
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moptions.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        CircleImageView src1, src2, src3,src4;

        TextView interestname, basicinfo, link1, link2, link3,link4;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            src1 = (CircleImageView) itemView.findViewById(R.id.src1img);
            src2 = (CircleImageView) itemView.findViewById(R.id.src2img);
            src3 = (CircleImageView) itemView.findViewById(R.id.src3img);
            src4 = (CircleImageView) itemView.findViewById(R.id.src4img);
            interestname = (TextView) itemView.findViewById(R.id.textinterests);
            basicinfo = (TextView) itemView.findViewById(R.id.basicknowinfo);
            link1 = (TextView) itemView.findViewById(R.id.src1link);
            link2 = (TextView) itemView.findViewById(R.id.src2link);
            link3 = (TextView) itemView.findViewById(R.id.src3link);
            link4 = itemView.findViewById(R.id.src4link);


            //   itemView.setOnClickListener(this);
            //  email=(TextView)itemView.findViewById(R.id.emailtext);
        }
//        @Override
//        public void onClick(View v) {
//            int adapterPosition = getAdapterPosition();
//
//            //Toast.makeText(mcontext,"position"+adapterPosition,Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(mcontext , IndividualUserProfile.class);
//            intent.putExtra("apkmobile" ,phonenumber.getText().toString());
//            mcontext.startActivity(intent);
//            //   Intent intent =new Intent(context,)
//
//        }    }

    }
}
