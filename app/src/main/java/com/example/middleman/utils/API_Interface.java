package com.example.middleman.utils;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API_Interface {
    @GET("get_rider.php")
    Call<Object> get_AllRiders();

}
