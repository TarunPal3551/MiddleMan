package com.example.middleman;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.middleman.adapters.PendingAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PendingFragment extends Fragment {

    public PendingFragment() {
        // Required empty public constructor
    }
    RecyclerView pendingRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_pending, container, false);
        pendingRecyclerView = (RecyclerView) view.findViewById(R.id.pendingRecyclerView);
        pendingRecyclerView.setHasFixedSize(true);
        pendingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pendingRecyclerView.setAdapter(new PendingAdapter(getContext()));
        return view;
    }
}
