package com.example.wastewatcher.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wastewatcher.R;

public class FoodActivity extends AppCompatActivity {

    private CardView inventory, donation, track, tips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        inventory = findViewById(R.id.inventory);
        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInventory();
            }
        });

        track = findViewById(R.id.TrackWaste);
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opentrack();
            }
        });

        donation = findViewById(R.id.donation);
        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDonate();
            }
        });

        tips = findViewById(R.id.TipTricks);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTip();
            }
        });



    }

    private void openInventory() {
        Intent intent = new Intent(this, InventoryActivity.class);
        startActivity(intent);
    }
    private void openTip() {
        Intent intent = new Intent(this, TipsActivity.class);
        startActivity(intent);
    }
    private void openDonate() {
        Intent intent = new Intent(this, DonationActivity.class);
        startActivity(intent);
    }
    private void opentrack() {
        Intent intent = new Intent(this, TrackWasteActivity.class);
        startActivity(intent);
    }

}