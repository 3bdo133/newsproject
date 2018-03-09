package com.example.abdelrahmanhesham.news.adapters;

/**
 * Created by Abdelrahman Hesham on 3/8/2018.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.abdelrahmanhesham.news.PoliticsFragment;
import com.example.abdelrahmanhesham.news.TechnologyFragment;

/**
 * Created by Abdelrahman Hesham on 4/22/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TechnologyFragment();
            case 1:
                return new PoliticsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Technology";
            case 1:
                return "Politics";
            default:
                return null;
        }
    }
}
