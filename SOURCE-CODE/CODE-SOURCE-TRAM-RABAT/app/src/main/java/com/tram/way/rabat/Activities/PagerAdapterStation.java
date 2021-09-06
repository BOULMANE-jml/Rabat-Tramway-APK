package com.tram.way.rabat.Activities;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapterStation   extends FragmentPagerAdapter {

    private  int numOfTabs;

    public  PagerAdapterStation(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs=numOfTabs;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
