package com.example.middleman;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middleman.adapters.PendingAdapter;
import com.example.middleman.adapters.RidersAdapter;
import com.example.middleman.model.Rider;
import com.example.middleman.utils.API_Interface;
import com.example.middleman.utils.OnItemClickListener;
import com.example.middleman.utils.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PendingFragment extends Fragment implements OnItemClickListener {

    public PendingFragment() {
        // Required empty public constructor
    }
    RecyclerView pendingRecyclerView;
    Context mcontext;
    API_Interface api_interface;
    ArrayList<Rider> riderArrayList = new ArrayList<>();
    private static final String TAG = "PendingFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_pending, container, false);
        mcontext = getContext();
        getAllRiders();
        pendingRecyclerView = (RecyclerView) view.findViewById(R.id.pendingRecyclerView);
        pendingRecyclerView.setHasFixedSize(true);
        pendingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pendingRecyclerView.setAdapter(new PendingAdapter(getContext(),this));
        return view;
    }

    public void getAllRiders() {
        api_interface = RetrofitClient.getClient().getApi();
        api_interface.get_AllRiders().enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.body() != null && response.isSuccessful()) {
                    try {
                        String resultValue = "{ \"middle\" :" + String.valueOf(response.body()) + "}";
                        Log.d(TAG, "onResponse: "+resultValue);
                        JSONObject jsonRootObject = new JSONObject(resultValue);
                        JSONArray jsonArray = jsonRootObject.optJSONArray("middle");
                        if (jsonArray.length() > 0) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String name = jsonObject.optString("name").toString();
                                String Ids = jsonObject.optString("id").toString();
                                String mobile=jsonObject.optString("mobile");
                                Rider rider = new Rider(name, Ids,mobile);
                                riderArrayList.add(rider);


                            }
                            final Dialog dialog = new Dialog(mcontext);
                            dialog.setContentView(R.layout.dialog_riders);
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                            Button cancelBTN = dialog.findViewById(R.id.closeButton);
                            RecyclerView recyclerViewRiders = dialog.findViewById(R.id.ridersRecyclerView);
                            recyclerViewRiders.setLayoutManager(new LinearLayoutManager(mcontext));
                            recyclerViewRiders.setAdapter(new RidersAdapter(mcontext, riderArrayList));
                            cancelBTN.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });


                            dialog.show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
    }

    @Override
    public void OnItemClick(int position) {
        getAllRiders();

    }
}
