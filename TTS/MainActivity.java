package io.github.probe2k.tts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText data;
    Button speak;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(getApplicationContext(), i -> {
            if (i != TextToSpeech.ERROR) {
                tts.setLanguage(Locale.US);
            }
        });
        data = (EditText) findViewById(R.id.data);
        speak = findViewById(R.id.speak);

        speak.setOnClickListener(v -> {
            String s = data.getText().toString();
            Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null, null);
        });
    }
}