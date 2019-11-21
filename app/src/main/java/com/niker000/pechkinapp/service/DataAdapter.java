package com.niker000.pechkinapp.service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.niker000.pechkinapp.R;
import com.niker000.pechkinapp.model.Article;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<Article> newsList;


    public DataAdapter(List<Article> newsList) {
        this.newsList = newsList;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_activity, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Article news = newsList.get(position);
        holder.title.setText(news.getTitle());
        holder.description.setText(news.getDescription());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public Article getItem(int id) {
        return newsList.get(id);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView news;
        final TextView title, description;

        ViewHolder(View view) {
            super(view);
            news = (CardView) view.findViewById(R.id.article);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
        }

    }

}
