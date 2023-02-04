package com.example.wastewatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wastewatcher.food.FoodActivity;
import com.example.wastewatcher.garbage.GarbageActivity;
import com.example.wastewatcher.logreg.loginActivity;
import com.example.wastewatcher.logreg.registrationActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    CardView food,garbage,profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        if(currentUser == null){
            Intent intent = new Intent(this, registrationActivity.class);
            startActivity(intent);
            finish();
        }

        Button buttlogout = findViewById(R.id.logout_button);
        buttlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutUser();
            }
        });


        food = findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFood();
            }
        });

        garbage = findViewById(R.id.garbage);
        garbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGarbage();
            }
        });

        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfile();
            }
        });
    }

    private void openProfile() {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
    private void openGarbage() {
        Intent intent = new Intent(this, GarbageActivity.class);
        startActivity(intent);
    }
    private void openFood() {
        Intent intent = new Intent(this, FoodActivity.class);
        startActivity(intent);
    }

    private void LogoutUser() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
        finish();
    }
}