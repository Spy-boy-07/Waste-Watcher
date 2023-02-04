package com.example.wastewatcher.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wastewatcher.R;
import com.example.wastewatcher.garbage.GarbageActivity;

public class InventoryActivity extends AppCompatActivity {

    private CardView addItems, deleteItems, scanItems, viewInventory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        addItems = (CardView) findViewById(R.id.addItems);
        deleteItems = (CardView) findViewById(R.id.deleteItems);
        scanItems = (CardView) findViewById(R.id.scanItems);
        viewInventory = (CardView) findViewById(R.id.viewInventory);

        addItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdd();
            }
        });

        deleteItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendel();
            }
        });

        scanItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openscan();
            }
        });

        viewInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 openview();
            }
        });

    }

    private void openscan() {
        Intent intent = new Intent(this, AddInINventory.class);
        startActivity(intent);
    }

    private void openview() {
        Intent intent = new Intent(this, AddInINventory.class);
        startActivity(intent);
    }

    private void opendel() {
        Intent intent = new Intent(this, AddInINventory.class);
        startActivity(intent);
    }

    private void openAdd() {
        Intent intent = new Intent(this, AddInINventory.class);
        startActivity(intent);
    }

}