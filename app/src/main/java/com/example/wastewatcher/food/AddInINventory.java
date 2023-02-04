package com.example.wastewatcher.food;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wastewatcher.R;
import com.example.wastewatcher.User;
import com.example.wastewatcher.logreg.loginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddInINventory extends AppCompatActivity {


String name,weight;
FirebaseDatabase db;
Task<Void> ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_in_inventory);

        EditText pname = findViewById(R.id.proname);
        EditText pw = findViewById(R.id.proweight);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser curruser = auth.getCurrentUser();
        if (curruser == null) {
            Intent intent = new Intent(this, loginActivity.class);
            startActivity(intent);
            finish();
        }
        Button add = findViewById(R.id.additembuttontodatabase);




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = pname.getText().toString();
                weight=pw.getText().toString();

                if (!name.isEmpty() && !weight.isEmpty()){
                    final String[] nodename = new String[1];

                    items Item = new items(name,weight);

                    DatabaseReference userref = FirebaseDatabase.getInstance().getReference("users").child(curruser.getUid());
                    db = FirebaseDatabase.getInstance();
                    ref = db.getReference("Inventory").child("Items").child(name).setValue(Item).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            pname.setText("");
                            pw.setText("");
                            Toast.makeText(AddInINventory.this,"Success",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}