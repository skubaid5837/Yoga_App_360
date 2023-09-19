package com.example.yogaapp360;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.main);

        button1 = findViewById(R.id.startYoga1);
        button2 = findViewById(R.id.startYoga2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.privacy){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.freeprivacypolicy.com/live/b27570f1-465f-4873-951f-4786fec60257"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.term){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.freeprivacypolicy.com/live/841ebb2e-b0d1-4881-b23c-58ecf2b3f237"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.more){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Leap+Fitness+Group"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.share){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareBody = "This is the Best App for Yoga \n By this App you will Live a Healthy Life\n" + "https://play.google.com/store/apps/details?id=" + getPackageName() + "&h1=en";
            String shareHub = "Yoga App";
            intent.putExtra(Intent.EXTRA_SUBJECT,shareHub);
            intent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
            startActivity(Intent.createChooser(intent,"Share Using"));
            return true;
        }
        if (id == R.id.rate){
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
            }catch (Exception ex){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
            }
            return true;
        }
        return true;
    }
    
    public void beforeAge18(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    public void afterAge18(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity2.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent = new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);
    }
}