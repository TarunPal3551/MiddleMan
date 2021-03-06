package com.example.middleman.adapters;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middleman.OrderDetailsActivity;
import com.example.middleman.R;
import com.example.middleman.utils.OnItemClickListener;
import com.google.android.material.button.MaterialButton;


public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.ViewHolder> {
    Context mcontext;
    OnItemClickListener onItemClickListener;



    public PendingAdapter(Context mcontext, OnItemClickListener onItemClickListener) {
        this.mcontext = mcontext;
        this.onItemClickListener = onItemClickListener;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewMore;
        public ImageView imgCardView;
        MaterialButton assignButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //   imgCardView = itemView.findViewById(R.id.itemImage);
            textViewMore = itemView.findViewById(R.id.textViewMore);
            assignButton = itemView.findViewById(R.id.assignRidersButton);


        }


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pending_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    public void onBindViewHolder(ViewHolder holder, final int position) {
//        Glide.with(mcontext)
//                .asBitmap()
//                .load(images.get(position))
//                .into(holder.imgCardView);

        //  holder.textView.setText(names.get(position));
        holder.textViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, OrderDetailsActivity.class);
                mcontext.startActivity(intent);
            }

        });

        holder.assignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClick(position);
            }
        });


    }


    @Override
    public int getItemCount() {
        return 15;
    }


}
