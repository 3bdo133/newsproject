package com.example.abdelrahmanhesham.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdelrahmanhesham.news.adapters.NewsAdapter;
import com.example.abdelrahmanhesham.news.models.NewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class PoliticsFragment extends Fragment {

    @BindView(R.id.recycler) RecyclerView mNewsRecyclerView;

    public PoliticsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_politics, container, false);

        ButterKnife.bind(this, parentView);

        ArrayList<NewModel> news = new ArrayList<>();
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new NewModel("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));


        NewsAdapter newsAdapter = new NewsAdapter(news, new NewsAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });


        mNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mNewsRecyclerView.setAdapter(newsAdapter);

        return parentView;
    }

}
