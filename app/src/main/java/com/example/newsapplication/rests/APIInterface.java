package com.example.newsapplication.rests;

import com.example.newsapplication.models.NewsApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
@GET("top-headlines")
Call<NewsApiResponse> getHeadlines(
        @Query("country") String country,
        @Query("category") String category,
        @Query("q") String query,
        @Query("apiKey") String api_Key
);
}
