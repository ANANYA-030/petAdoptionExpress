package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button Vbtn, emergency, adoptablePets;
    RecyclerView recyclerView;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Vbtn = (Button) findViewById(R.id.video);
        emergency = (Button) findViewById(R.id.emergency);
        adoptablePets = (Button) findViewById(R.id.adopt);
        Vbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, VideoPage.class);
                startActivity(i);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, EmergencyServiceActivity.class);
                startActivity(i);
            }
        });

        adoptablePets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, AdoptableActivity.class);
                startActivity(i);
            }
        });
/*
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Information> options =
                new FirebaseRecyclerOptions.Builder<Information>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("pets"), Information.class)
                        .build();
        mainAdapter = new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);

    }
    @Override
    protected void onStart(){
        super.onStart();
        mainAdapter.startListening();

    }

    @Override
    protected void onStop(){
        super.onStop();
        mainAdapter.stopListening();


    }
*/
    }


}