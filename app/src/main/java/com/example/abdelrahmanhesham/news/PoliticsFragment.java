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
public class PoliticsFragment extends Fragment implements Connector.LoadCallback,Connector.ErrorCallback {

    @BindView(R.id.recycler)
    RecyclerView mNewsRecyclerView;
    @BindView(R.id.progress_indicator)
    ProgressBar mProgressBar;
    Connector mConnector;
    String mNewsUrl;
    ArrayList<NewModel> mNews;
    NewsAdapter mNewsAdapter;
    public static final String TAG = PoliticsFragment.class.getSimpleName();

    public PoliticsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_politics, container, false);

        ButterKnife.bind(this, parentView);

        mProgressBar.setVisibility(View.VISIBLE);

        mNewsUrl = Connector.createPoliticsUrl();
        mNews = new ArrayList<>();


        mNewsAdapter = new NewsAdapter(mNews, new NewsAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });


        mConnector = new Connector(getActivity(),this,this);

        mConnector.getRequest(TAG,mNewsUrl);

        mNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mNewsRecyclerView.setAdapter(mNewsAdapter);

        return parentView;
    }

    @Override
    public void onStop() {
        super.onStop();
        mConnector.cancelAllRequests(TAG);
    }

    @Override
    public void onComplete(String tag, String response) {
        mNews.addAll(Connector.createFromJson(response));
        mProgressBar.setVisibility(View.INVISIBLE);
        mNewsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {
        Helper.writeToLog(error);
    }
}
