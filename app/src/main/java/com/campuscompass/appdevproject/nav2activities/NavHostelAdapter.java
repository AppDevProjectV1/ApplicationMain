package com.campuscompass.appdevproject.nav2activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdevproject.R;

public class NavHostelAdapter extends RecyclerView.Adapter<NavHostelAdapter.NavHostelViewHolder> {


    private String[] deptNames;
    private Integer[] deptImages;
    private String[] deptInfos;


    public NavHostelAdapter(String[] deptNames,Integer[] deptImages,String[] deptInfos ) {
        this.deptNames = deptNames;
        this.deptImages = deptImages;
        this.deptInfos = deptInfos;
    }


    public class NavHostelViewHolder extends RecyclerView.ViewHolder{

        private TextView deptName;
        private ImageView deptImage;
        private TextView deptInfo;

        public NavHostelViewHolder(@NonNull View itemView) {
            super(itemView);


            deptName=itemView.findViewById(R.id.hostelname);
            deptImage=itemView.findViewById(R.id.hostelimage);
            deptInfo=itemView.findViewById(R.id.hostelinfo);
        }



    }






    @NonNull
    @Override
    public NavHostelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.hostelitem,parent,false);
        return new NavHostelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NavHostelViewHolder holder, int position) {
        String deptname=deptNames[position];
        Integer deptImage=deptImages[position];
        String deptinfo=deptInfos[position];

        holder.deptName.setText(deptname);
        holder.deptImage.setImageResource(deptImage);
        holder.deptInfo.setText(deptinfo);


    }

    @Override
    public int getItemCount() {
        return deptNames.length;
    }
}
