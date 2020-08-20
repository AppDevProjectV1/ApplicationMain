package com.example.appdevproject;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.w3c.dom.Text;

import java.text.BreakIterator;

public class CanteenAdapter extends RecyclerView.Adapter<CanteenAdapter.CantViewHolder>{


    private String[] canteens;

    final private ListItemClickListener mOnClickListener;



    public CanteenAdapter(ListItemClickListener listener,String[] canteens) {
        mOnClickListener = listener;
        this.canteens=canteens;
    }


    public interface ListItemClickListener {
        void onListItemClick(String username);
    }



    public class CantViewHolder extends RecyclerView.ViewHolder
            implements OnClickListener {

        public final TextView canteen;

        public CantViewHolder(View view) {
            super(view);

            canteen=(TextView) view.findViewById(R.id.canteenname);

            view.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String canteen=canteens[adapterPosition];
            mOnClickListener.onListItemClick(canteen);
        }


    }

    @Override
    public CantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.canteen_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        CantViewHolder viewHolder = new CantViewHolder(view);

        return viewHolder;


        /*viewHolderCount++;
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;*/

    }

    @Override
    public void onBindViewHolder(CantViewHolder ViewHolder, int position) {
        String name= canteens[position];
        ViewHolder.canteen.setText(name);
    }


    @Override
    public int getItemCount() {
        return canteens.length;
    }


}
