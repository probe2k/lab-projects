package io.github.probe2k.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText op1, op2;
    TextView output;
    Button sum, diff, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1 = (EditText) findViewById(R.id.op1);
        op2 = (EditText) findViewById(R.id.op2);
        output = findViewById(R.id.output);
        sum = findViewById(R.id.sum);
        diff = findViewById(R.id.diff);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText("OUTPUT : " + (Integer.parseInt(op1.getText().toString()) + Integer.parseInt(op2.getText().toString())));
            }
        });
        diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText("OUTPUT : " + (Integer.parseInt(op1.getText().toString()) - Integer.parseInt(op2.getText().toString())));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText("OUTPUT : " + (Integer.parseInt(op1.getText().toString()) * Integer.parseInt(op2.getText().toString())));
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText("OUTPUT : " + (Integer.parseInt(op1.getText().toString()) / Integer.parseInt(op2.getText().toString())));
            }
        });
    }
}