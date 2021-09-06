package com.tram.way.rabat.Activities;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapterHoraire extends FragmentPagerAdapter {

    private  int numOfTabs;

   public  PagerAdapterHoraire(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs=numOfTabs;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new horaires_ramadan();
            case 1:
                return new horaires_normal();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}