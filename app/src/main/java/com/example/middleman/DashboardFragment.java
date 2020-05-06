package com.example.middleman;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middleman.adapters.PendingAdapter;
import com.example.middleman.adapters.RidersAdapter;
import com.example.middleman.model.Rider;
import com.example.middleman.utils.API_Interface;
import com.example.middleman.utils.OnItemClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements OnItemClickListener {

    public DashboardFragment() {
        // Required empty public constructor
    }

    private static final String BASE_URL = "http://ibaymovelah.robovytech.co.in/";

    RecyclerView pendingRecyclerView;
    Context mcontext;
    API_Interface api_interface;
    ArrayList<Rider> riderArrayList = new ArrayList<>();
    TextView textViewRiderCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mcontext = getContext();
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        pendingRecyclerView = (RecyclerView) view.findViewById(R.id.pendingRecyclerView);
        pendingRecyclerView.setHasFixedSize(true);
        pendingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pendingRecyclerView.setAdapter(new PendingAdapter(getContext(), this));
        textViewRiderCount = (TextView) view.findViewById(R.id.totalRiderCount);
        getRiderCount();


        
        return view;
    }

    public void getRiderCount() {
        class Callwebservice extends AsyncTask<Void, List<String>, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... params) {


                String resultValue = "";
                try {
                    String finalurl_setstatus = BASE_URL + "get_allriders.php";
                    URL url_setstatus = new URL(finalurl_setstatus.replace(" ", "%20"));
                    URLConnection connectionurl_setstatus = url_setstatus.openConnection();
                    connectionurl_setstatus.setDoOutput(true);
                    connectionurl_setstatus.connect();


                    BufferedReader inpu = new BufferedReader(new InputStreamReader(connectionurl_setstatus.getInputStream()));
                    String inputL = "";


                    while ((inputL = inpu.readLine()) != null) {
                        resultValue = inputL;

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return resultValue;

            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                String resultValue = "{ \"middle\" :" + result + "}";
                JSONObject jsonRootObject = null;
                try {
                    jsonRootObject = new JSONObject(resultValue);
                    JSONArray jsonArray = jsonRootObject.optJSONArray("middle");
                    if (jsonArray.length() > 0) {
                        textViewRiderCount.setText("" + jsonArray.length());
                    } else {
                        textViewRiderCount.setText("0");
                    }


                } catch (JSONException ex) {
                    ex.printStackTrace();
                }

            }


        }

        Callwebservice uv = new Callwebservice();
        uv.execute();
    }

    public void getAllRiders() {
        class Callwebservice extends AsyncTask<Void, List<String>, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... params) {


                String resultValue = "";
                try {
                    String finalurl_setstatus = BASE_URL + "get_allriders.php";
                    URL url_setstatus = new URL(finalurl_setstatus.replace(" ", "%20"));
                    URLConnection connectionurl_setstatus = url_setstatus.openConnection();
                    connectionurl_setstatus.setDoOutput(true);
                    connectionurl_setstatus.connect();


                    BufferedReader inpu = new BufferedReader(new InputStreamReader(connectionurl_setstatus.getInputStream()));
                    String inputL = "";


                    while ((inputL = inpu.readLine()) != null) {
                        resultValue = inputL;

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return resultValue;

            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                String resultValue = "{ \"middle\" :" + result + "}";
                JSONObject jsonRootObject = null;
                try {
                    jsonRootObject = new JSONObject(resultValue);
                    JSONArray jsonArray = jsonRootObject.optJSONArray("middle");
                    riderArrayList.clear();
                    riderArrayList = new ArrayList<>();
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
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }

            }


        }

        Callwebservice uv = new Callwebservice();
        uv.execute();
    }

    @Override
    public void OnItemClick(int position) {
        getAllRiders();
    }
}
