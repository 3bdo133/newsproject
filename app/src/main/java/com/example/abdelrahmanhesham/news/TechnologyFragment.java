package com.example.abdelrahmanhesham.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TechnologyFragment extends Fragment {


    public TechnologyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_technology, container, false);

        ArrayList<New> news = new ArrayList<>();
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));
        news.add(new New("Test","TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"));


        NewsAdapter newsAdapter = new NewsAdapter(news, new NewsAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });


        RecyclerView recyclerView = parentView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(newsAdapter);

        return parentView;
    }

}
