package com.example.newsapplication.models;

import java.util.List;

public class NewsApiResponse {
    String status;
    int totalResults;
    List<NewsArticle> newsArticleList;

    public List<NewsArticle> getNewsArticleList() {
        return newsArticleList;
    }
    public void setNewsArticleList(List<NewsArticle> newsArticleList) {
        this.newsArticleList = newsArticleList;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
