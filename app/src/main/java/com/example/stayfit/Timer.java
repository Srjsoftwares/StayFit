package com.example.stayfit;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Timer extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS=600000;

    TextView countdown;
    Button timerStart, timerReset;
    CountDownTimer countDownTimer;
    ImageView clock_anchor;
    Animation rotation;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis= START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        countdown = findViewById(R.id.countdown);
        clock_anchor = findViewById(R.id.clock_anchor);
        timerStart = findViewById(R.id.timerStart);
        timerReset = findViewById(R.id.timerReset);

        //load animation
        rotation = AnimationUtils.loadAnimation(this, R.anim.rotation);





        timerStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clock_anchor.startAnimation(rotation);
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        timerReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clock_anchor.clearAnimation();
                resetTimer();
            }
        });
        updateCountDownText();
    }
        private void startTimer(){
            countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis= millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    mTimerRunning=false;
                    timerStart.setText("Start");
                    timerStart.setVisibility(View.INVISIBLE);
                    timerReset.setVisibility(View.VISIBLE);


                }
            }.start();
            mTimerRunning = true;
            timerStart.setText("pause");
            timerReset.setVisibility(View.INVISIBLE);

        }

        private void pauseTimer()
        {
            countDownTimer.cancel();
            mTimerRunning=false;
            timerStart.setText("Start");
            timerReset.setVisibility(View.VISIBLE);
            clock_anchor.clearAnimation();
        }

        private void resetTimer()
        {
            mTimeLeftInMillis=START_TIME_IN_MILLIS;
            updateCountDownText();
            timerReset.setVisibility(View.VISIBLE);
            timerStart.setVisibility(View.VISIBLE);

        }

        private void updateCountDownText()
        {
            int minutes= (int) (mTimeLeftInMillis/1000)/60;
            int seconds= (int) (mTimeLeftInMillis/1000)%60;

            String timeLeftFormatted= String.format(Locale.getDefault(),"%02d:%02d",minutes, seconds);
            countdown.setText(timeLeftFormatted);
        }

}
