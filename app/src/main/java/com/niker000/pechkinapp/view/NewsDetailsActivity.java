package com.niker000.pechkinapp.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.niker000.pechkinapp.R;

public class NewsDetailsActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        showDetails();
    }

    private void showDetails() {
        TextView resource = (TextView) findViewById(R.id.news_resource);
        TextView title = (TextView) findViewById(R.id.news_title);
        TextView url = (TextView) findViewById(R.id.news_url);
        TextView content = (TextView) findViewById(R.id.news_content);

        resource.setText(getIntent().getStringExtra("resource"));
        title.setText(getIntent().getStringExtra("title"));
        url.setText(getIntent().getStringExtra("url"));
        content.setText(getIntent().getStringExtra("content"));
    }
}
