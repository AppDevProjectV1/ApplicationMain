package com.campuscompass.appdevproject.nav2activities;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdevproject.R;

public class FestAdapter extends RecyclerView.Adapter<FestAdapter.FestViewHolder> {



    public interface linkClickListener {
        void onListItemClick(String link);
    }


    private String[] deptNames;
    private Integer[] deptImages;
    private String[] deptInfos;
    private String[] links;
    private linkClickListener linkClickListener;


    public FestAdapter(String[] deptNames,Integer[] deptImages,String[] deptInfos ,String[] links,linkClickListener linkClickListener) {
        this.deptNames = deptNames;
        this.deptImages = deptImages;
        this.deptInfos = deptInfos;
        this.links=links;
        this.linkClickListener=linkClickListener;

    }


    public class FestViewHolder extends RecyclerView.ViewHolder{

        private TextView deptName;
        private ImageView deptImage;
        private TextView deptInfo;
        private TextView link;

        public FestViewHolder(@NonNull View itemView) {
            super(itemView);


            deptName=itemView.findViewById(R.id.festname);
            deptImage=itemView.findViewById(R.id.festimage);
            deptInfo=itemView.findViewById(R.id.festinfo);
            link=itemView.findViewById(R.id.link);

            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linkClickListener.onListItemClick(link.getText().toString());

                }
            });
        }



    }






    @NonNull
    @Override
    public FestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.festitem,parent,false);
        return new FestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FestViewHolder holder, int position) {
        String deptname=deptNames[position];
        Integer deptImage=deptImages[position];
        String deptinfo=deptInfos[position];
        String weblink =links[position];

        holder.deptName.setText(deptname);
        holder.deptImage.setImageResource(deptImage);
        holder.deptInfo.setText(deptinfo);
        holder.link.setText(weblink);


    }

    @Override
    public int getItemCount() {
        return deptNames.length;
    }
}
