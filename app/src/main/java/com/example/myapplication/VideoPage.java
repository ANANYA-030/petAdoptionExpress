package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class VideoPage extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        WebView webView = findViewById(R.id.webView1);
        WebView webView1 = findViewById(R.id.webView2);

        String video="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lArwj8ELa10?si=FUVWb7r0MnVdBRgC\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        webView.loadData(video, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        String video1="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ppkBktPF6FI?si=k684yvYVVnbfq5pM\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        webView1.loadData(video1, "text/html", "utf-8");
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.setWebChromeClient(new WebChromeClient());
    }
}