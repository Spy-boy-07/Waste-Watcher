package com.example.wastewatcher.food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wastewatcher.R;

public class TipsActivity extends AppCompatActivity {


    ListView l;
    String tips[]
            = { "Make a grocery list and schedule your meals: Only purchase what you absolutely need and make a weekly plan.", "Food should be stored properly to prevent rotting and to extend its freshness. Apply the 'first in, first out' principle: Prioritize consuming older goods so they don't expire.", "Keep an eye on portion sizes by cooking only what you can consume and freezing the rest for later.", "Utilize leftovers inventively: Make new dishes out of leftovers, like soups or stir-fries.", "Instead of tossing away food scraps and yard debris, compost them.", "If you have extra food, think about giving it to a food bank or neighbourhood shelter.","Purchase 'imperfect' produce. Though sometimes thrown, 'imperfect' fruits and vegetables are completely edible.", "Use the freezer: Freeze food to preserve it for later use before it goes bad.", "Be careful when you shop and refrain from buying too much, especially when buying perishables."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        l = findViewById(R.id.list);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                tips);
        l.setAdapter(arr);


    }
}