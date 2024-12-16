package com.example.timer;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timer.R;

public class MainActivity extends AppCompatActivity {

    private TextView counterTextView;
    private Button startButton;
    private Button stopButton;
    private Handler handler = new Handler();
    private int seconds = 0;
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counterTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCounter();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopCounter();
            }
        });
    }

    private void startCounter() {
        if (!isRunning) {
            isRunning = true;
            handler.postDelayed(runnable, 1000);
        }
    }

    private void stopCounter() {
        isRunning = false;
        handler.removeCallbacks(runnable);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                seconds++;
                int minutes = seconds / 60;
                int secs = seconds % 60;
                counterTextView.setText(String.format("%02d:%02d", minutes, secs));
                handler.postDelayed(this, 1000);
            }
 }
};
}