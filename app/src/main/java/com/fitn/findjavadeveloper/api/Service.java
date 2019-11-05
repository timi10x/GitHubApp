package com.fitn.findjavadeveloper.api;

import com.fitn.findjavadeveloper.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;



public interface Service {
    @GET("/search/users?q=language:java+location:lagos&per_page=100&sort=followers")
    Call<ItemResponse> getItems();
}
