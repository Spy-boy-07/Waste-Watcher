package com.example.wastewatcher.garbage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.wastewatcher.R;
import com.google.android.material.card.MaterialCardView;

public class garbagetrack extends AppCompatActivity {

    RelativeLayout greenwet,bluedry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garbagetrack);

        greenwet = findViewById(R.id.wetgreen);
        bluedry = findViewById(R.id.dryblue);

        greenwet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengreen();
            }
        });

        bluedry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBlue();
            }
        });
    }

    private void opengreen() {
        Intent intent = new Intent(this, wet.class);
        startActivity(intent);
    }

    public void openBlue() {
        Intent intent = new Intent(this, dry.class);
        startActivity(intent);
    }

}