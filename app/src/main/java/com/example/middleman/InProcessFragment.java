package com.example.middleman;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.middleman.adapters.InProcessAdapter;
import com.example.middleman.adapters.PendingAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class InProcessFragment extends Fragment {

    public InProcessFragment() {
        // Required empty public constructor
    }
    RecyclerView inProcessRecyclerview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_in_process, container, false);
        inProcessRecyclerview = (RecyclerView) view.findViewById(R.id.inProcessRecyclerView);
        inProcessRecyclerview.setHasFixedSize(true);
        inProcessRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        inProcessRecyclerview.setAdapter(new InProcessAdapter(getContext()));
        return view;
    }
}
