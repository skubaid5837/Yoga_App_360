package com.example.yogaapp360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class FoodActivityDetals extends AppCompatActivity {

    TextView textView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detals);

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textView = findViewById(R.id.text);
        String dstory = getIntent().getStringExtra("story");
        textView.setText(dstory);

    }

    public void goBack(View view) {
        Intent intent = new Intent(FoodActivityDetals.this,FoodActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FoodActivityDetals.this,FoodActivity.class);
        startActivity(intent);
        finish();
    }
}