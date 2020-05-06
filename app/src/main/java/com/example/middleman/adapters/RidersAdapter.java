package com.example.middleman.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middleman.R;
import com.example.middleman.model.Rider;

import java.util.ArrayList;


public class RidersAdapter extends RecyclerView.Adapter<RidersAdapter.ViewHolder> {
    Context mcontext;
    ArrayList<Rider> riderArrayList;

    public RidersAdapter(Context mcontext, ArrayList<Rider> riderArrayList) {
        this.riderArrayList = riderArrayList;
        this.mcontext = mcontext;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewPendingJobs, textViewTotalJobs, textViewMobile;
        ImageView imageViewProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //   imgCardView = itemView.findViewById(R.id.itemImage);
            imageViewProfile = (ImageView) itemView.findViewById(R.id.imageProfile);
            textViewName = (TextView) itemView.findViewById(R.id.riderName);
            textViewTotalJobs = (TextView) itemView.findViewById(R.id.totalJobTextView);
            textViewMobile = (TextView) itemView.findViewById(R.id.textViewMobileNumber);






        }


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.riders_items, parent, false);
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
        holder.textViewName.setText("" + riderArrayList.get(position).getRider_name());
        holder.textViewMobile.setText("" + riderArrayList.get(position).getMobile());





    }




    @Override
    public int getItemCount() {
        return riderArrayList.size();
    }


}
