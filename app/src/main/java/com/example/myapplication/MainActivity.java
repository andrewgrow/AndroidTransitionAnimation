package com.example.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements VerticalAdapter.OnItemCustomClickListener {

    private static final int adapterCount = 50;

    private VerticalAdapter verticalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // make recyclerView and adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                RecyclerView.VERTICAL, false));
        verticalAdapter = new VerticalAdapter(adapterCount, this);
        recyclerView.setAdapter(verticalAdapter);
    }

    @Override
    public void onItemClicked(int position, ImageView ivLogo, TextView tvName) {
        // make transition bundle
        List<Pair<View, String>> listOfViews = new ArrayList<>();
        listOfViews.add(Pair.create((View)ivLogo, "ivLogo"));
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(
                MainActivity.this, listOfViews.toArray(new android.util.Pair[]{})).toBundle();

        // make intent
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        Pair<String, Integer> object = verticalAdapter.getItem(position);
        intent.putExtra("color", object.first);
        intent.putExtra("logo", object.second);
        intent.putExtra("position", position);

        // start activity
        startActivity(intent, bundle);
    }
}
