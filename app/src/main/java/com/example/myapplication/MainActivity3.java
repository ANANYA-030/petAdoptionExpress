package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import org.w3c.dom.Text;


public class MainActivity3 extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView inf = findViewById(R.id.info1);
        TextView age = findViewById(R.id.age);
        TextView breed = findViewById(R.id.breed);
        ImageView img = findViewById(R.id.image);

        String info = getIntent().getStringExtra("INFO_KEY");
        String a = getIntent().getStringExtra("AGE_KEY");
        String b = getIntent().getStringExtra("BREED_KEY");

        if(b.equals("Persian")){
           img.setImageResource(R.drawable.persiancat);
        }
        else if(b.equals("Siamese")){
            img.setImageResource(R.drawable.siamesecat);
        }
        else if(b.equals("Golden Retriever")){
            img.setImageResource(R.drawable.goldenretriever);
        }
        else if(b.equals("doberman")){
            img.setImageResource(R.drawable.doberman);
        }

        inf.setText(info);
        age.setText("AGE: "+a);
        breed.setText("BREED: "+b);


        button = (Button)findViewById(R.id.Adopt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
                intent.putExtra("BREED_KEY",b);
                intent.putExtra("AGE_KEY",a);
                startActivity(intent);
            }
        });




    }
}