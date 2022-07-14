package io.github.probe2k.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    EditText username, password;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signin = findViewById(R.id.signin);

        signin.setOnClickListener(i -> {
            String resUser = getIntent().getStringExtra("username");
            String resPass = getIntent().getStringExtra("password");

            if (username.getText().toString().equals(resUser) && password.getText().toString().equals(resPass))
                startActivity(new Intent(this, Successful.class));
            else
                Toast.makeText(this, "Credentials not matching", Toast.LENGTH_SHORT).show();
        });
    }
}