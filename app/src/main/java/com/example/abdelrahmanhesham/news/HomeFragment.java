package com.example.abdelrahmanhesham.news;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager viewPager = parentView.findViewById(R.id.view_pager);
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentAdapter(getActivity().getSupportFragmentManager(),getActivity().getApplicationContext());
        viewPager.setAdapter(fragmentPagerAdapter);
        TabLayout tabLayout = parentView.findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        return parentView;
    }

}
