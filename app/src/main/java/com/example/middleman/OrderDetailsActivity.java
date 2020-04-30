package com.example.middleman;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middleman.adapters.DeliveryLocationAdapter;
import com.example.middleman.adapters.RidersAdapter;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public class OrderDetailsActivity extends AppCompatActivity {
    MaterialToolbar toolbar;
    MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        toolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        materialButton = findViewById(R.id.assignRidersButton);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(OrderDetailsActivity.this);
                dialog.setContentView(R.layout.dialog_riders);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button cancelBTN = dialog.findViewById(R.id.closeButton);
                RecyclerView recyclerViewRiders = dialog.findViewById(R.id.ridersRecyclerView);
                recyclerViewRiders.setLayoutManager(new LinearLayoutManager(OrderDetailsActivity.this));
                recyclerViewRiders.setAdapter(new RidersAdapter(OrderDetailsActivity.this));
                cancelBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                dialog.show();
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDetailsActivity.super.onBackPressed();
            }
        });
        RecyclerView recyclerViewlocation = findViewById(R.id.locationRecyclerView);
        recyclerViewlocation.setLayoutManager(new LinearLayoutManager(OrderDetailsActivity.this));
        recyclerViewlocation.setAdapter(new DeliveryLocationAdapter(OrderDetailsActivity.this));

    }
}
