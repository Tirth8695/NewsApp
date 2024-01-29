package com.example.newsapplication.rests;

import android.widget.Toast;

import com.example.newsapplication.constants.Constants;
import com.example.newsapplication.models.NewsApiResponse;
import com.example.newsapplication.models.NewsArticle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

// apiService = apiInterface
// NewsApiService = APIInterface
public class NewsRepository {
    private APIInterface apiInterface;

    public NewsRepository(){
        apiInterface = ApiClient.getClient().create(APIInterface.class);
    }

    public void getHeadlines(String query, String country, String category, String api_key,final Callback<NewsApiResponse> callback){
        String apikey = Constants.API_KEY;

        Call<NewsApiResponse> call = apiInterface.getHeadlines("in", "general", "q", Constants.API_KEY);
        call.enqueue(new Callback<NewsApiResponse>() {
            @Override
            public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                if(response.isSuccessful()){
                    NewsApiResponse newsApiResponse = response.body();
                    if(newsApiResponse != null){
                        List<NewsArticle> newsArticles = newsApiResponse.getNewsArticleList();
                        callback.onResponse(call,response);
                    }else{
                        callback.onFailure(call,new Throwable("Empty response body"));
                    }
                }else {
                    callback.onFailure(call,new Throwable("Unsuccessful response"));
                }
            }

            @Override
            public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                callback.onFailure(call,t);
            }
        });
    }
}
