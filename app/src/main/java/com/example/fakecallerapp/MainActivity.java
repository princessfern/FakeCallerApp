package com.example.fakecallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rb1, rb2, rb3;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb1 = (RadioButton)findViewById(R.id.rdb15sec);
        rb2 = (RadioButton)findViewById(R.id.rdb30sec);
        rb3 = (RadioButton)findViewById(R.id.rdb1min);
    }

    // Toast to show selected button
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str="";
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rdb15sec:
                if(checked)
                    str = "15 Second Countdown Selected";
                break;
            case R.id.rdb30sec:
                if(checked)
                    str = "30 Second Countdown Selected";
                break;
            case R.id.rdb1min:
                if(checked)
                    str = "1 Minute Countdown Selected";
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public void callStart(View view){
        int selectedTime = 15000;
        // Checks the timer isn't already running before starting a new one.
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
        TextView countdownTimerVisual = (TextView)findViewById(R.id.countdownTimerVisual);
        selectedTime = (rb1.isChecked())?15000:(rb2.isChecked())?30000:(rb3.isChecked())?60000:0;
        Intent intent = new Intent(this, CallActivity.class);
        countDownTimer =  new CountDownTimer(selectedTime, 1000) {
            @Override
            public void onTick(long l) {
                countdownTimerVisual.setText("Seconds Remaining: " + l / 1000);
            }
            @Override
            public void onFinish() {
                startActivity(intent);
            }
        }.start();
    }
}