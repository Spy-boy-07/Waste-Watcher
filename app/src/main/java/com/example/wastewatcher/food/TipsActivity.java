package com.example.wastewatcher.food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.wastewatcher.adapters.tipsAdapter;
import com.example.wastewatcher.R;

import java.util.ArrayList;

public class TipsActivity extends AppCompatActivity {


    ListView l;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        l = findViewById(R.id.list);

        ArrayList<String> foodtips = new ArrayList<>();

        foodtips.add("Before shopping for groceries, make a list of what you need and stick to it. This can help you avoid buying excess food that is likely to go to waste.");
        foodtips.add("Proper storage can help extend the life of your food and prevent waste. ");
        foodtips.add("Cook extra food with the intention of eating it later in the week as leftovers. This can help you avoid having to prepare new meals every day, reducing the amount of food that goes to waste.");
        foodtips.add(" Make a habit of checking expiration dates on food items in your pantry and refrigerator. Try to eat or freeze perishable items before they go bad.");
        foodtips.add("Start a compost bin to turn food waste into fertilizer for your garden. This is a great way to reduce food waste and give back to the earth at the same time.");
        foodtips.add("If you have extra food that you are unable to eat, consider donating it to a local food bank or shelter.");
        foodtips.add("Keep bananas out of the fruit bowl");
        foodtips.add(" Be mindful of \"buy one, get one free\" deals, as you may end up buying more than you need.");
        foodtips.add("Keep a tally of how much food you throw away each week. This can help you identify areas where you can make changes to reduce waste. Waste Watcher is all you need for that.");
        foodtips.add("Turn leftovers into new meals, such as making a frittata from yesterday's dinner or using leftover rice to make fried rice.");
        foodtips.add("Avoid buying in bulk unless you know you will use the food before it goes bad.");
        foodtips.add("If you can't eat it, give it to someone who can");

        tipsAdapter adapter = new tipsAdapter(this, R.layout.tips_rows,foodtips);
        l.setAdapter(adapter);



    }
}