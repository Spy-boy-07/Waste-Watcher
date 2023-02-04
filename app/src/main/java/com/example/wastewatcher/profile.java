package com.example.wastewatcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wastewatcher.logreg.loginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    TextView tvname, tvusername, tvemail, tvphone, tvcity, tvarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser == null) {
            Intent intent = new Intent(this, loginActivity.class);
            startActivity(intent);
            finish();
        }

        tvname = findViewById(R.id.tvName);
        tvusername = findViewById(R.id.tvUN);
        tvemail = findViewById(R.id.tvEmail);
        tvphone = findViewById(R.id.tvphone);
        tvcity = findViewById(R.id.tvcity);
        tvarea = findViewById(R.id.tvarea);

        Button buttlogout = findViewById(R.id.LogOut);
        buttlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutUser();
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("users").child(currentUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                if (user != null) {
                    tvname.setText("Name:  " + user.name);
                    tvemail.setText("E mail:  " + user.email);
                    tvusername.setText("User name:  " + user.username);
                    tvphone.setText("Phone:  " + user.num);
                    tvcity.setText("City:  " + user.city);
                    tvarea.setText("Area:  " + user.area);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void LogoutUser() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
        finish();
    }
}

