package io.github.probe2k.dialer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    Button save, call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.phone);
        save = findViewById(R.id.save);
        call = findViewById(R.id.call);

        save.setOnClickListener(v -> {
            String n = phone.getText().toString();
            Intent i = new Intent(Intent.ACTION_INSERT);
            i.setType(ContactsContract.Contacts.CONTENT_TYPE);
            i.putExtra(ContactsContract.Intents.Insert.PHONE, n);
            startActivity(i);
        });

        call.setOnClickListener(v -> {
            String n = phone.getText().toString();
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + n));
            startActivity(i);
        });
    }
}