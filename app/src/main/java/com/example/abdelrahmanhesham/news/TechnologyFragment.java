package com.example.abdelrahmanhesham.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.abdelrahmanhesham.news.adapters.NewsAdapter;
import com.example.abdelrahmanhesham.news.models.NewModel;
import com.example.abdelrahmanhesham.news.utils.Connector;
import com.example.abdelrahmanhesham.news.utils.Helper;

import org.json.JSONException;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TechnologyFragment extends Fragment {


    @BindView(R.id.recycler)
    RecyclerView mNewsRecyclerView;
    @BindView(R.id.progress_indicator)
    ProgressBar mProgressBar;
    RequestQueue mQueue;
    String mNewsUrl;
    StringRequest mStringRequest;
    ArrayList<NewModel> mNews;
    NewsAdapter mNewsAdapter;
    public static final String TAG = "MyTag";

    public TechnologyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_technology, container, false);
        ButterKnife.bind(this, parentView);

        mProgressBar.setVisibility(View.VISIBLE);

        mQueue = Volley.newRequestQueue(getActivity());
        mNewsUrl = Connector.createTechnologyUrl();
        mNews = new ArrayList<>();

        mNewsAdapter = new NewsAdapter(mNews, new NewsAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });


        mStringRequest = new StringRequest(Request.Method.GET, mNewsUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        mProgressBar.setVisibility(View.INVISIBLE);
                        Helper.writeToLog(response);
                        try {
                            mNews.addAll(Connector.createFromJson(response));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        mNewsAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Helper.writeToLog(error.toString());

            }
        });

        mStringRequest.setTag(TAG);
        mQueue.add(mStringRequest);


        mNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mNewsRecyclerView.setAdapter(mNewsAdapter);

        return parentView;
    }


    @Override
    public void onStop() {
        super.onStop();
        if (mQueue != null) {
            mQueue.cancelAll(TAG);
        }

    }
}
