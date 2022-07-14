package io.github.probe2k.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button changeWall;
    WallpaperManager wpm;
    Drawable d;
    Timer t;
    int c = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = new Timer();
        changeWall = findViewById(R.id.change);

        changeWall.setOnClickListener(i -> {
            setWall();
        });
    }

    private void setWall() {
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (c == 1) {
                    d = getResources().getDrawable(R.drawable.one);
                    c = 2;
                } else if (c == 2){
                    d = getResources().getDrawable(R.drawable.two);
                    c = 3;
                } else {
                    d = getResources().getDrawable(R.drawable.three);
                    c = 1;
                }
                Bitmap wall = ((BitmapDrawable) d).getBitmap();
                try {
                    wpm.setBitmap(wall);
                } catch (Exception e) {}
            }
        }, 0, 5000);
    }
}