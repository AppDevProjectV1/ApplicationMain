package com.example.appdevproject.nav2activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdevproject.R;

public class NavDeptAdapter extends RecyclerView.Adapter<NavDeptAdapter.NavDeptViewHolder> {


    private String[] deptNames;
    private Integer[] deptImages;
    private String[] deptInfos;


    public NavDeptAdapter(String[] deptNames,Integer[] deptImages,String[] deptInfos ) {
        this.deptNames = deptNames;
        this.deptImages = deptImages;
        this.deptInfos = deptInfos;
    }


    public class NavDeptViewHolder extends RecyclerView.ViewHolder{

        private TextView deptName;
        private ImageView deptImage;
        private TextView deptInfo;

        public NavDeptViewHolder(@NonNull View itemView) {
            super(itemView);


            deptName=itemView.findViewById(R.id.deptname);
            deptImage=itemView.findViewById(R.id.deptimage);
            deptInfo=itemView.findViewById(R.id.deptinfo);
        }



    }






    @NonNull
    @Override
    public NavDeptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.nav2deptitem,parent,false);
        return new NavDeptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NavDeptViewHolder holder, int position) {
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
