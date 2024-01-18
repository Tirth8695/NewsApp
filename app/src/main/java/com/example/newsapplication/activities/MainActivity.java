package com.example.newsapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newsapplication.R;
import com.example.newsapplication.adapters.HeadLineAdapter;
import com.example.newsapplication.models.NewsArticle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //variable declared for the api key
    private static final String API_KEY = "api_key";
    //Recyclerview
    private RecyclerView recyclerView;
    //Adapter
    private HeadLineAdapter headLineAdapter;
    //News Article List
    private List<NewsArticle> newsArticleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}