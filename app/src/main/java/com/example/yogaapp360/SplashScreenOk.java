package com.example.yogaapp360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenOk extends AppCompatActivity {

    Animation up,down;
    ImageView splashIcon;
    TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_ok);

        splashIcon = findViewById(R.id.appSplash);
        up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        splashIcon.setAnimation(up);

        appName = findViewById(R.id.appName);
        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        appName.setAnimation(down);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },3500);
    }
}