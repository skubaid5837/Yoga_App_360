package com.example.yogaapp360;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SecondActivity2 extends AppCompatActivity {

    int[] newArray;
    private AdView mAdView,mAdView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        mAdView = findViewById(R.id.adView);
        mAdView1 = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView1.loadAd(adRequest1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newArray = new int[]{
                R.id.pose1,R.id.pose2,R.id.pose3,R.id.pose4,R.id.pose5,R.id.pose6,R.id.pose7,R.id.pose8,
                R.id.pose9,R.id.pose10,R.id.pose11,R.id.pose12,R.id.pose13,R.id.pose14,R.id.pose15,
        };

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

    public void ImageButtonClicked(View view) {

        for (int i=0 ; i<newArray.length ; i++){
            if(view.getId() == newArray[i]){
                int value = i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent = new Intent(SecondActivity2.this,ThirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }

    }
}