package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddEmergencyService extends AppCompatActivity {
     EditText name,type,contact;
     Button submit,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emergency_service);

        name = (EditText) findViewById(R.id.name);
        type = (EditText) findViewById(R.id.type);
        contact = (EditText) findViewById(R.id.contact);
        submit = (Button) findViewById(R.id.submit);
        back = (Button) findViewById(R.id.back);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              insertData();
              clearAll();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(AddEmergencyService.this,MainActivity2.class);
               startActivity(i);
            }
        });

    }

    private void insertData(){
        Map<String,Object> map = new HashMap<>();
        map.put("contactNumber",Long.parseLong(contact.getText().toString()));
        map.put("serviceName",name.getText().toString());
        map.put("serviceType",type.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("emergency").push().setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddEmergencyService.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddEmergencyService.this, "Error while insertion", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void clearAll(){
        name.setText("");
        type.setText("");
        contact.setText("");
    }
}