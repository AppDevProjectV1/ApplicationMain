package com.example.appdevproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MIntAdapter extends RecyclerView.Adapter<MIntAdapter.MIntViewHolder> {

    private List<String> selections;



    public MIntAdapter(List<String> selections)
    {
        this.selections=selections;
    }




    @NonNull
    @Override
    public MIntAdapter.MIntViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.nav2item,parent,false);
        return new MIntAdapter.MIntViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MIntAdapter.MIntViewHolder holder, int position) {
        String interest=selections.get(position);
        holder.textView.setText(interest);
    }

    @Override
    public int getItemCount() {
        return selections.size();
    }

    public class MIntViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public MIntViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textViewName);
        }



    }
}
