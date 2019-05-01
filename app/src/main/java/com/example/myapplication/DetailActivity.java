package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String color = getIntent().getStringExtra("color");
        int logo = getIntent().getIntExtra("logo", 0);
        int position = getIntent().getIntExtra("position", 0);

        ImageView ivLogo = findViewById(R.id.ivLogo);
        ivLogo.setBackgroundColor(Color.parseColor(color));
        ivLogo.setImageResource(logo);
        ivLogo.setTransitionName("ivLogo");

        TextView tvName = findViewById(R.id.tvName);
        tvName.setText("Item position " + position);

        supportStartPostponedEnterTransition();
    }
}
