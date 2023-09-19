package com.example.yogaapp360;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity2 extends AppCompatActivity {

    String buttonValue;
    AppCompatButton startButton1;
    private CountDownTimer countDownTimer;
    TextView mTextView;
    private boolean mTimeRunning;
    private long mTimeLeftInMillis;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);

        Intent intent = getIntent();
        buttonValue = intent.getStringExtra("value");

        int intValue = Integer.valueOf(buttonValue);

        switch (intValue){

            case 1:
                setContentView(R.layout.activity2_pose1);
                break;
            case 2:
                setContentView(R.layout.activity2_pose2);
                break;
            case 3:
                setContentView(R.layout.activity2_pose3);
                break;
            case 4:
                setContentView(R.layout.activity2_pose4);
                break;
            case 5:
                setContentView(R.layout.activity2_pose5);
                break;
            case 6:
                setContentView(R.layout.activity2_pose6);
                break;
            case 7:
                setContentView(R.layout.activity2_pose7);
                break;
            case 8:
                setContentView(R.layout.activity2_pose8);
                break;
            case 9:
                setContentView(R.layout.activity2_pose9);
                break;
            case 10:
                setContentView(R.layout.activity2_pose10);
                break;
            case 11:
                setContentView(R.layout.activity2_pose11);
                break;
            case 12:
                setContentView(R.layout.activity2_pose12);
                break;
            case 13:
                setContentView(R.layout.activity2_pose13);
                break;
            case 14:
                setContentView(R.layout.activity2_pose14);
                break;
            case 15:
                setContentView(R.layout.activity2_pose15);
                break;
        }

        startButton1 = findViewById(R.id.startButton);
        mTextView = findViewById(R.id.time);

        startButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimeRunning){
                    stopTimer();
                }
                else{
                    startTimer();
                }
            }
        });

    }

    private void stopTimer(){
        countDownTimer.cancel();
        mTimeRunning = false;
        startButton1.setText("START");
    }

    private void startTimer(){
        final CharSequence value1 = mTextView.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);

        final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);
        mTimeLeftInMillis = number * 1000;

        countDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                int newValue = Integer.valueOf(buttonValue)+1;
                if (newValue <= 7){
                    Intent intent = new Intent(ThirdActivity2.this,ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newValue));
                    startActivity(intent);
                }
                else{
                    newValue=1;
                    Intent intent = new Intent(ThirdActivity2.this, ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newValue));
                    startActivity(intent);
                }
            }
        }.start();
        startButton1.setText("Paused");
        mTimeRunning = true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void updateTimer() {
        int minutes = (int) mTimeLeftInMillis/60000;
        int seconds = (int) mTimeLeftInMillis%60000/1000;

        String timeLeftText = "";
        if (minutes<1) {
            timeLeftText = "0";
            timeLeftText = timeLeftText + minutes + ":";
            if (seconds < 60){
                timeLeftText += seconds;
                mTextView.setText(timeLeftText);
            }
        }
    }

}