package com.example.abdelrahmanhesham.news;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button mJoinButton;
    SharedPreferences preferences;
    private final String EMAIL_KEY = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        final EditText editText = findViewById(R.id.email);


        mJoinButton = findViewById(R.id.join);
        mJoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editText.getText().toString();

                if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Write your Email", Toast.LENGTH_LONG).show();
                } else {

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(EMAIL_KEY, email);
                    editor.apply();

                    Log.i("Share Preferences : ",preferences.getString(EMAIL_KEY,"Error"));

                    startActivity(new Intent(MainActivity.this, HomeScreenActivity.class));

                }
            }
        });
    }
}
