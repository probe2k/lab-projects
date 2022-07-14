package io.github.probe2k.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button start, stop;
    int counter = 1;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        tv.setText("COUNTER : " + counter);
        handler = new Handler();

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        start.setOnClickListener(i -> {
            handler.postDelayed(r, 0);
        });

        stop.setOnClickListener(i -> {
            handler.removeCallbacks(r);
        });
    }

    private final Runnable r = new Runnable() {
        @Override
        public void run() {
            counter++;
            handler.postDelayed(this, 1000);
            tv.setText("COUNTER : " + counter);
        }
    };
}