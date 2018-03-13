package com.example.abdelrahmanhesham.news.utils;

import android.net.Uri;

import com.example.abdelrahmanhesham.news.models.NewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Abdelrahman Hesham on 3/13/2018.
 */

public class Connector {

    public static String createTechnologyUrl(){
        Uri.Builder builder = Uri.parse(Constants.NEWS_API_URL).buildUpon()
                .appendQueryParameter(Constants.NEWS_CATEGORY_KEY,Constants.NEWS_CATEGORY_TECHNOLOGY_VALUE)
                .appendQueryParameter(Constants.NEWS_COUNTRY_KEY,Constants.NEWS_COUNTRY_VALUE)
                .appendQueryParameter(Constants.NEWS_API_KEY_KEY,Constants.NEWS_API_KEY_VALUE);

        return builder.toString();

    }

    public static String createPoliticsUrl(){
        Uri.Builder builder = Uri.parse(Constants.NEWS_API_URL).buildUpon()
                .appendQueryParameter(Constants.NEWS_CATEGORY_KEY,Constants.NEWS_CATEGORY_POLITICS_VALUE)
                .appendQueryParameter(Constants.NEWS_COUNTRY_KEY,Constants.NEWS_COUNTRY_VALUE)
                .appendQueryParameter(Constants.NEWS_API_KEY_KEY,Constants.NEWS_API_KEY_VALUE);

        return builder.toString();

    }


    public static ArrayList<NewModel> createFromJson(String response) throws JSONException {

        ArrayList<NewModel> mNews = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        for (int i = 0 ;i<jsonArray.length();i++){
            JSONObject item = jsonArray.getJSONObject(i);
            String title = item.getString("title");
            String description = item.getString("description");
            mNews.add(new NewModel(title,description));
        }
        return mNews;
    }

}
