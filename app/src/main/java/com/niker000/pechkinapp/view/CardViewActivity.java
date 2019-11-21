package com.niker000.pechkinapp.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.niker000.pechkinapp.R;

public class CardViewActivity extends AppCompatActivity {
    TextView title;
    TextView desctiption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_activity);
        title = (TextView) findViewById(R.id.title);
        desctiption = (TextView) findViewById(R.id.description);
    }


}
