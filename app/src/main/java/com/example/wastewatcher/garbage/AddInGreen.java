package com.example.wastewatcher.garbage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wastewatcher.R;
import com.example.wastewatcher.food.AddInINventory;
import com.example.wastewatcher.food.items;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddInGreen extends AppCompatActivity {

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();
    DatabaseReference uref,gref;
    items wasteinG;
    Button add;
    EditText desc,weight;
    String discrip,weighting;
    String nodename;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_in_green);

        desc = findViewById(R.id.descg);
        weight = findViewById(R.id.wweight);
        add = findViewById(R.id.addtogb);



        add.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                uref = FirebaseDatabase.getInstance().getReference("users");
                gref = FirebaseDatabase.getInstance().getReference("Green");
                wasteinG = new items(desc.getText().toString(),weight.getText().toString());

                uref.child(user.getUid()).child("city").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        nodename = (String) snapshot.getValue();
                        uref.child(user.getUid()).child("area").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                gref.child(nodename).child(snapshot.getValue().toString()).child(user.getUid()).setValue(wasteinG);
                                Toast.makeText(AddInGreen.this,"Garbage Added",Toast.LENGTH_SHORT).show();
                                desc.setText("");
                                weight.setText("");
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}