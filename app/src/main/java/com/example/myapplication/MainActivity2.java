package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
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
    /*
    private Button d1,d2,c1,c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //pet 1

        d1 = (Button)findViewById(R.id.d1);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               passInfo("Golden Retriever Basics:\n" +
                       "\n" +
                       "Official Name: Golden Retriever\n" +
                       "Lifespan: 10 to 12 years\n" +"\n"+
                       "Physical Characteristics:\n" +
                       "\n" +
                       "Height: 21 to 24 inches\n" +
                       "Weight: 55 to 75 pounds\n" +"\n"+
                       "Temperament and Compatibility:\n" +
                       "\n" +
                       "Temperament: Friendly, gentle, outgoing, playful, willful\n" +
                       "Good with: Cats, children, dogs, families, seniors\n"
                       ,"2 months","Golden Retriever",R.drawable.goldenretriever);
            }
        });

        //pet 2
        d2 = (Button)findViewById(R.id.d2);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passInfo("Doberman Pinscher Overview:\n" +
                                "\n" +
                                "Common Name: Doberman Pinscher\n" +
                                "Lifespan: 10 to 12 years\n" +"\n"+
                                "Physical Characteristics:\n" +
                                "\n" +
                                "Height: 24 to 28 inches\n"+
                                "Weight: 60 to 100 pounds" +"\n"+"\n"+
                                "Temperament and Compatibility:\n" +
                                "\n" +
                                "Good with: Families\n"+
                                "Temperament: Playful"
                        ,"1 year","Doberman Pinscher",R.drawable.doberman);
            }
        });

        // pet 3
        c1 = (Button)findViewById(R.id.c1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passInfo("Alternative Names: Longhair or Persian Longhair\n" +
                                "\n" +
                                "Origin: Iran\n" +
                                "\n" +
                                "Breed Description: Long haired breed of cat that has a short round face with a wide head. It has a thick coat , large eyes and a shortened muzzle.\n" +
                                "\n" +
                                "Average Lifespan: 12-17 Years"
                        ,"2 years","Persian",R.drawable.persiancat);
            }
        });

        //pet 4

        c2 = (Button)findViewById(R.id.c2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passInfo("Alternative Names: Meezer\n" +
                                "\n" +
                                "Origin: Thailand\n" +
                                "\n" +
                                "Breed Description: This breed of cat has a muscular body with a triangular head.\n" +
                                "\n" +
                                "Average Lifespan:15- 20 years"
                        ,"5 months","Siamese",R.drawable.siamesecat);
            }
        });
    }

    public void passInfo(String info,String age,String breed,int imageResourceId){
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("INFO_KEY",info);
        intent.putExtra("AGE_KEY",age);
        intent.putExtra("BREED_KEY",breed);
        intent.putExtra("IMAGE_KEY",imageResourceId);
        startActivity(intent);


    }
     */
}