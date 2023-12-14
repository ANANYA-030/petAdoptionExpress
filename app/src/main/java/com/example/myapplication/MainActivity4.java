package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {
    EditText name,email;
    Button submit;
    String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b = getIntent().getStringExtra("BREED_KEY");

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               insertData();
               clearAll();
            }
        });

    }

    private void insertData(){
        String userName = name.getText().toString().trim();
        String userEmail = email.getText().toString().trim();

        Map<String,Object> map = new HashMap<>();
        if (!userName.isEmpty() && !userEmail.isEmpty()) {
            map.put("name", name.getText().toString());
            map.put("email", email.getText().toString());
            map.put("petSelected", b);
            map.put("status", false);
            FirebaseDatabase.getInstance().getReference().child("users").push()
                    .setValue(map)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(MainActivity4.this, "Admin will contact you soon regarding adoption", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {
                            Toast.makeText(MainActivity4.this, "Try again!!!", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else{
            Toast.makeText(MainActivity4.this, "Please enter both name and email", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearAll(){
        name.setText("");
        email.setText("");
    }
}