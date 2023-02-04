package com.example.wastewatcher.garbage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.wastewatcher.R;
import com.example.wastewatcher.adapters.tipsAdapter;

import java.util.ArrayList;

public class gartips extends AppCompatActivity {
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gartips);

        l = findViewById(R.id.list);
        ArrayList<String> garbagetips = new ArrayList<>();

        garbagetips.add("Separate recyclables, compostables, and non-recyclable waste to ensure that each type of waste is properly disposed of.");
        garbagetips.add("Use designated bins for each type of waste to make it easier to sort and dispose of your waste.");
        garbagetips.add("Research what types of materials can be recycled in your area and make sure to recycle accordingly.");
        garbagetips.add("Composting food waste and yard waste can help reduce the amount of waste sent to landfills.");
        garbagetips.add("Items such as batteries, pesticides, and electronics can be harmful to the environment and should be disposed of properly.");
        garbagetips.add("Reduce the use of single-use items, such as plastic water bottles and disposable razors, to reduce the amount of waste sent to landfills.");
        garbagetips.add("Bring cloth bags to the grocery store instead of using single-use plastic bags.");
        garbagetips.add("Look for local recycling programs and support them by properly recycling your waste.");
        garbagetips.add("Reduce the amount of waste you generate by using fewer resources. This can include using reusable items such as water bottles and shopping bags");
        garbagetips.add("Bring your own reusable straw or refuse single-use plastic straws when dining out.");
        garbagetips.add("Avoid products containing microplastics such as microbeads in personal care products and microfibers in synthetic clothing.");
        garbagetips.add("Look for products made from recycled metal and support companies that use sustainable materials and practices.");



       

        tipsAdapter adapter = new tipsAdapter(this, R.layout.tips_rows,garbagetips);
        l.setAdapter(adapter);


    }
}