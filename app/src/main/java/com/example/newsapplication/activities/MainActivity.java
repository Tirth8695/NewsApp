package com.example.newsapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.newsapplication.R;
import com.example.newsapplication.adapters.HeadLineAdapter;
import com.example.newsapplication.constants.Constants;
import com.example.newsapplication.models.NewsApiResponse;
import com.example.newsapplication.models.NewsArticle;
import com.example.newsapplication.rests.APIInterface;
import com.example.newsapplication.rests.ApiClient;
import com.example.newsapplication.rests.NewsRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //Adapter
    private HeadLineAdapter headLineAdapter;
    private NewsRepository newsRepository;
    //News Article List
    //private List<NewsArticle> newsArticleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable declared for the api key
        //Recyclerview
        RecyclerView recyclerView = findViewById(R.id.headlines_recyclerview);
        recyclerView.setHasFixedSize(true);

        headLineAdapter = new HeadLineAdapter(this,new ArrayList<>());
        recyclerView.setAdapter(headLineAdapter);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        final APIInterface apiService = ApiClient.getClient().create(APIInterface.class);
        Call<NewsApiResponse> call = apiService.getHeadlines("in", "general", "q", Constants.API_KEY);
       call.enqueue(new Callback<NewsApiResponse>() {
         @Override
           public void onResponse(@NonNull Call<NewsApiResponse> call, @NonNull Response<NewsApiResponse> response) {
                if(response.isSuccessful()){
                    NewsApiResponse newsApiResponse = response.body();
                    if(newsApiResponse != null){
                        List<NewsArticle> newsArticles = newsApiResponse.getNewsArticleList();
                        headLineAdapter.updateData(newsArticles);
                    if(newsArticles.size()>0){
                        headLineAdapter.updateData(newsArticles);

                    }
                    }
                }
            }

            @Override
           public void onFailure(@NonNull Call<NewsApiResponse> call, @NonNull Throwable t) {
                Log.e("out", t.toString());
            }
        });
    }
}