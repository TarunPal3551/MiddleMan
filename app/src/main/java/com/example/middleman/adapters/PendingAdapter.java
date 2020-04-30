package com.example.middleman.adapters;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middleman.OrderDetailsActivity;
import com.example.middleman.R;
import com.google.android.material.button.MaterialButton;


public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.ViewHolder> {
    Context mcontext;


    public PendingAdapter(Context mcontext) {

        this.mcontext = mcontext;

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


    public void onBindViewHolder(ViewHolder holder, int position) {
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
                final Dialog dialog = new Dialog(mcontext);
                dialog.setContentView(R.layout.dialog_riders);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button cancelBTN = dialog.findViewById(R.id.closeButton);
                RecyclerView recyclerViewRiders = dialog.findViewById(R.id.ridersRecyclerView);
                recyclerViewRiders.setLayoutManager(new LinearLayoutManager(mcontext));
                recyclerViewRiders.setAdapter(new RidersAdapter(mcontext));
                cancelBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                dialog.show();

            }
        });


    }


    @Override
    public int getItemCount() {
        return 15;
    }


}
