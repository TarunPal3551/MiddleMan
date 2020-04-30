package com.example.middleman;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middleman.adapters.CompletdAdapter;
import com.example.middleman.adapters.PendingAdapter;

public class CompletedFragments extends Fragment {


    public CompletedFragments() {
        // Required empty public constructor
    }

    RecyclerView completedRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_completed_fragments, container, false);
        completedRecyclerView = (RecyclerView) view.findViewById(R.id.completedRecyclerView);
        completedRecyclerView.setHasFixedSize(true);
        completedRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        completedRecyclerView.setAdapter(new CompletdAdapter(getContext()));
        return view;
    }
}
