package com.example.abdelrahmanhesham.news.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.abdelrahmanhesham.news.models.NewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Abdelrahman Hesham on 3/13/2018.
 */

public class Connector {

    private Context mContext;
    private LoadCallback mLoadCallback;
    private ErrorCallback mErrorCallback;
    private RequestQueue mQueue;


    public interface LoadCallback {

        void onComplete(String tag, String response);

    }

    public interface ErrorCallback {

        void onError(String error);

    }

    public Connector(Context mContext, LoadCallback mLoadCallback, ErrorCallback mErrorCallback) {
        this.mContext = mContext;
        this.mLoadCallback = mLoadCallback;
        this.mErrorCallback = mErrorCallback;
    }


    public void getRequest(final String tag, final String url) {
        Helper.writeToLog(url);
        if (isOnline(mContext)) {
            mQueue = Volley.newRequestQueue(mContext);
            StringRequest mStringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Helper.writeToLog(response);
                            mLoadCallback.onComplete(tag, response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Helper.writeToLog(error.toString());
                    mErrorCallback.onError(error.toString());
                }
            });
            mStringRequest.setTag(tag);
            mQueue.add(mStringRequest);
        } else {
            mLoadCallback.onComplete(tag,null);
        }


    }

    public void cancelAllRequests(final String tag){
        if (mQueue != null) {
            mQueue.cancelAll(tag);
        }
    }


    public static String createTechnologyUrl() {
        Uri.Builder builder = Uri.parse(Constants.NEWS_API_URL).buildUpon()
                .appendQueryParameter(Constants.NEWS_CATEGORY_KEY, Constants.NEWS_CATEGORY_TECHNOLOGY_VALUE)
                .appendQueryParameter(Constants.NEWS_COUNTRY_KEY, Constants.NEWS_COUNTRY_VALUE)
                .appendQueryParameter(Constants.NEWS_API_KEY_KEY, Constants.NEWS_API_KEY_VALUE);

        return builder.toString();

    }

    public static String createPoliticsUrl() {
        Uri.Builder builder = Uri.parse(Constants.NEWS_API_URL).buildUpon()
                .appendQueryParameter(Constants.NEWS_CATEGORY_KEY, Constants.NEWS_CATEGORY_POLITICS_VALUE)
                .appendQueryParameter(Constants.NEWS_COUNTRY_KEY, Constants.NEWS_COUNTRY_VALUE)
                .appendQueryParameter(Constants.NEWS_API_KEY_KEY, Constants.NEWS_API_KEY_VALUE);

        return builder.toString();

    }


    public static ArrayList<NewModel> createFromJson(String response) {

        ArrayList<NewModel> mNews = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("articles");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                String title = item.getString("title");
                String description = item.getString("description");
                mNews.add(new NewModel(title, description));
            }
        } catch (JSONException ex){
            ex.printStackTrace();
        }
        return mNews;
    }


    private static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnectedOrConnecting();
        } else {
            return false;
        }
    }


}
