package com.example.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.RssFragment;
import com.example.SearchFragment;
import com.example.WodsFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm){
        super(fm);
    }


    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new RssFragment();
            case 1:
                // Games fragment activity
                return new SearchFragment();
            case 2:
                // Movies fragment activity
                return new WodsFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
