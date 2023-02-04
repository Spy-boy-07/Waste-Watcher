package com.example.wastewatcher.garbage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wastewatcher.R;

public class wet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wet);

        Button buyblue = findViewById(R.id.gogreen);
        buyblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amagreen();
            }
        });
    }

    private void amagreen() {
        Uri uri = Uri.parse("https://www.amazon.in/s?k=green+dustbin&sprefix=%2Caps%2C169&ref=nb_sb_ss_recent_2_0_recent");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage("com.amazon.android");
        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.amazon.in/s?k=green+dustbin&sprefix=%2Caps%2C169&ref=nb_sb_ss_recent_2_0_recent")));
        }
    }
}