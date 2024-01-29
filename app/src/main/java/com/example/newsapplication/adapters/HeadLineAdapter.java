package com.example.newsapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapplication.R;
import com.example.newsapplication.models.NewsArticle;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HeadLineAdapter extends RecyclerView.Adapter<HeadLineAdapter.ViewHolder> {
    Context context;
    List<NewsArticle> newsArticleList;

    public HeadLineAdapter(Context context, List<NewsArticle> newsArticleList) {
        this.context = context;
        this.newsArticleList = newsArticleList;
    }

    @NonNull
    @Override
    public HeadLineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.headlines,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadLineAdapter.ViewHolder holder, int position) {
        holder.headline.setText(newsArticleList.get(position).getTitle());
        holder.newsName.setText(newsArticleList.get(position).getSource().getName());
        Picasso.get().load(newsArticleList.get(position).getUrlToImage()).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return newsArticleList != null ? newsArticleList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView headline,newsName;
        ImageView newsImage;
        CardView newsCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            headline = itemView.findViewById(R.id.headlines_textview);
            newsName = itemView.findViewById(R.id.news_name_textview);
            newsImage = itemView.findViewById(R.id.news_image);
            newsCard = itemView.findViewById(R.id.news_cardview);
        }
    }

    public void updateData(List<NewsArticle> newData){
        this.newsArticleList = newData;
        notifyDataSetChanged();
    }
}
