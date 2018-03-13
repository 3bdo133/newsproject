package com.example.abdelrahmanhesham.news.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import java.net.URI;
import java.net.URL;

/**
 * Created by Abdelrahman Hesham on 3/9/2018.
 */

public class Helper {

    public static void showLongTimeToast(Context context, String message) {

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

    }

    public static void writeToLog(String message) {

        Log.i("Helper Log", message);

    }


    public static boolean validateEmail(String email) {

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        } else {
            return true;
        }

    }



}
