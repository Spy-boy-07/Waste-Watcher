package com.example.wastewatcher.food;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wastewatcher.R;

public class DonationActivity extends AppCompatActivity {

    Button ngobutt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

         ngobutt = findViewById(R.id.ngo);
        ngobutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchWeb("Food donation NGO near me");
            }
        });
    }

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        startActivity(intent);
    }
}