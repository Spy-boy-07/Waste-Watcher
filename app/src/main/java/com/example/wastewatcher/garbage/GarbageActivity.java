package com.example.wastewatcher.garbage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wastewatcher.R;
import com.example.wastewatcher.food.DonationActivity;
import com.google.android.material.card.MaterialCardView;

public class GarbageActivity extends AppCompatActivity {

    private MaterialCardView track, tips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garbage);

        track = findViewById(R.id.trackGar);
        tips = findViewById(R.id.tipsGar);

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengartrack();
            }
        });
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengartips();
            }
        });
    }

    private void opengartips() {
        Intent intent = new Intent(this, gartips.class);
        startActivity(intent);
    }

    private void opengartrack() {
        Intent intent = new Intent(this, garbagetrack.class);
        startActivity(intent);
    }
}