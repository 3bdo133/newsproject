package com.example.abdelrahmanhesham.news;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Abdelrahman Hesham on 3/9/2018.
 */

public class StoreManager {

    public static void SaveStringInPreferences(Context context, String key, String value){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();

    }


    public static String LoadStringFromPreferences(Context context,String key,String defaultValue){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key,defaultValue);

    }


}
