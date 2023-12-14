package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class HomePage extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
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

}