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

import com.example.abdelrahmanhesham.news.utils.Helper;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.join) Button mJoinButton;
    @BindView(R.id.email) EditText mEmailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mJoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mEmailEditText.getText().toString();

                if (!Helper.validateEmail(email)) {
                    Helper.showLongTimeToast(MainActivity.this,"Write Your Email");
                } else {

                    StoreManager.SaveStringInPreferences(MainActivity.this,Constants.PREFERENCES_EMAIL_KEY,email);

                    Helper.writeToLog(StoreManager.LoadStringFromPreferences(MainActivity.this,Constants.PREFERENCES_EMAIL_KEY,Constants.PREFERENCES_NOT_FOUND));


                    startActivity(new Intent(MainActivity.this, HomeScreenActivity.class));

                }
            }
        });
    }
}
