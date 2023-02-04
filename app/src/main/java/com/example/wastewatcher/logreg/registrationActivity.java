package com.example.wastewatcher.logreg;

import static java.sql.Types.NULL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wastewatcher.MainActivity;
import com.example.wastewatcher.R;
import com.example.wastewatcher.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class registrationActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            finish();
            return;
        }

        Button RegButton = findViewById(R.id.Reg_button);

        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterUser();
            }
        });

        TextView RegtoLog = findViewById(R.id.regtolog);
        RegtoLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchToLogin();
            }
        });


    }

    private void SwitchToLogin() {
        Intent intent = new Intent(this,loginActivity.class );
        startActivity(intent);
        finish();
    }

    private void RegisterUser() {
        EditText ETRegName = findViewById(R.id.full_name_et);
        EditText ETRegUserName = findViewById(R.id.user_name_et);
        EditText ETRegEmail = findViewById(R.id.email_et);
        EditText ETRegPassword = findViewById(R.id.u_password_et);
        EditText ETRegphone = findViewById(R.id.u_phone_et);
        EditText ETRegcity = findViewById(R.id.u_city_et);
        EditText ETRegarea = findViewById(R.id.u_area_et);


        String name = ETRegName.getText().toString();
        String usename = ETRegUserName.getText().toString();
        String email = ETRegEmail.getText().toString();
        String pass = ETRegPassword.getText().toString();
        String phone = ETRegphone.getText().toString();
//        long no = Long.parseLong(phone);
        String city = ETRegcity.getText().toString();
        String area = ETRegarea.getText().toString();

        if (name.isEmpty() || usename.isEmpty() || email.isEmpty() || pass.isEmpty() || phone.isEmpty() || city.isEmpty() || area.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User ouruser = new User(FirebaseAuth.getInstance().getCurrentUser().getUid(),usename, name, email,phone,city,area);
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(ouruser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            showMainMethod();
                                        }
                                    });
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
                            Toast.makeText(registrationActivity.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });
    }
    private void showMainMethod() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}