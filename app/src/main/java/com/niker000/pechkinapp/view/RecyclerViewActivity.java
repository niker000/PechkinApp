package com.niker000.pechkinapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.niker000.pechkinapp.R;
import com.niker000.pechkinapp.model.Article;
import com.niker000.pechkinapp.model.DTO.ResponseNewsDTO;
import com.niker000.pechkinapp.service.DataAdapter;
import com.niker000.pechkinapp.service.NewsService;
import com.niker000.pechkinapp.model.listner.RecyclerItemListener;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class RecyclerViewActivity extends AppCompatActivity {
    private DataAdapter adapter;
    private List<Article> news;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo
        try {
            initializeData();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (news == null) {
            Toast.makeText(this, "Не удаётся найти заметок про мальчика(", Toast.LENGTH_LONG).show();
            return;
        }
        setContentView(R.layout.recyclerview_activity);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        adapter = new DataAdapter(news);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemListener(getApplicationContext(),
                recyclerView, new RecyclerItemListener.RecyclerTouchListener() {
            @Override
            public void onClickItem(View v, int position) {
                showDetails(position);
            }
        }));

    }

    private void initializeData() throws ExecutionException, InterruptedException {
        NewsService newsService = new NewsService();
        ResponseNewsDTO responseNewsDTO = newsService.execute("id").get();
        news = responseNewsDTO.getArticles();
    }

    private void showDetails(int position) {
        Intent intent = new Intent(this, NewsDetailsActivity.class);
        intent.putExtra("title", news.get(position).getTitle());
        intent.putExtra("url", news.get(position).getUrl());
        intent.putExtra("resource", news.get(position).getSource().getName());
        intent.putExtra("content", news.get(position).getContent());
        startActivity(intent);
    }
}
