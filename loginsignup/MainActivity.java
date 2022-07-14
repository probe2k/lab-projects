package io.github.probe2k.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signup = findViewById(R.id.signup);

//        if (isValid(password.getText().toString())) {
//            signup.setOnClickListener(i -> {
//                Intent intent = new Intent(this, SignIn.class);
//                intent.putExtra("username", username.getText().toString());
//                intent.putExtra("password", password.getText().toString());
//                startActivity(intent);
//            });
//        } else {
//            Toast.makeText(this, "Invalid password constraint", Toast.LENGTH_SHORT).show();
//        }

        signup.setOnClickListener(i -> {
            if (!isValid(password.getText().toString())) {
                Toast.makeText(this, "Invalid Password Constraints", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, SignIn.class);
                intent.putExtra("username", username.getText().toString());
                intent.putExtra("password", password.getText().toString());
                startActivity(intent);
            }
        });
    }

    Pattern lc = Pattern.compile("^.*[a-z].*$");
    Pattern uc = Pattern.compile("^.*[A-Z].*$");
    Pattern n = Pattern.compile("^.*[0-9].*$");
    Pattern sp = Pattern.compile("^.*[^a-zA-Z0-9].*$");

    private Boolean isValid(String s) {
        if (s.length() < 8)
            return false;
        if (!lc.matcher(s).matches())
            return false;
        if (!uc.matcher(s).matches())
            return false;
        if (!n.matcher(s).matches())
            return false;
        if (!sp.matcher(s).matches())
            return false;
        return true;
    }
}