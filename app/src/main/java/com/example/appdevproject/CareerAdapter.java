package com.example.appdevproject;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CareerAdapter extends RecyclerView.Adapter<CareerAdapter.CareerViewHolder> {


    private String[] options;
    public CareerAdapter(String[] options)
    {
        this.options=options;
    }

    @NonNull
    @Override
    public CareerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.career_list_item,parent,false);
        return new CareerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CareerViewHolder holder, int position) {
        String option=options[position];
        holder.checkBox.setText(option);
    }

    @Override
    public int getItemCount() {
        return options.length;
    }

    public class CareerViewHolder extends RecyclerView.ViewHolder{

        private CheckBox checkBox;
        public CareerViewHolder(@NonNull View itemView) {
            super(itemView);

            checkBox=itemView.findViewById(R.id.careercheck);
        }
    }

}
