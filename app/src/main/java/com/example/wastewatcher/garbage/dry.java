package com.example.wastewatcher.garbage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wastewatcher.R;

public class dry extends AppCompatActivity {

    CardView addblue,viewblue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dry);

        Button buyblue = findViewById(R.id.goblue);
        buyblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amablue();
            }
        });

        addblue = findViewById(R.id.addblue);
        viewblue = findViewById(R.id.viewblue);

        addblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddb();
            }
        });
    }

    private void openaddb() {
        Intent intent = new Intent(this, AddInBlue.class);
        startActivity(intent);
    }

    private void amablue() {
        Uri uri = Uri.parse("https://www.amazon.in/s?k=blue+dustbin&sprefix=%2Caps%2C169&ref=nb_sb_ss_recent_2_0_recent");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage("com.amazon.android");
        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.amazon.in/s?k=blue+dustbin&sprefix=%2Caps%2C169&ref=nb_sb_ss_recent_2_0_recent")));
        }
    }
}