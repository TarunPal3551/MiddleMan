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


public class CompletdAdapter extends RecyclerView.Adapter<CompletdAdapter.ViewHolder> {
    Context mcontext;



    public CompletdAdapter(Context mcontext) {

        this.mcontext = mcontext;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewMore;
        public ImageView imgCardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //   imgCardView = itemView.findViewById(R.id.itemImage);
            textViewMore = itemView.findViewById(R.id.textViewMore);


        }


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.completd_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    public void onBindViewHolder(ViewHolder holder, int position) {
//        Glide.with(mcontext)
//                .asBitmap()
//                .load(images.get(position))
//                .into(holder.imgCardView);

      //  holder.textView.setText(names.get(position));
//        holder.textViewMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mcontext, OrderInfoActivity.class);
//                mcontext.startActivity(intent);
//            }
//
//        });
        holder.textViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, OrderDetailsActivity.class);
                mcontext.startActivity(intent);
            }

        });




    }



    @Override
    public int getItemCount() {
        return 15;
    }


}
