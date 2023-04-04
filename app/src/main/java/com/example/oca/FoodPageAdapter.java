package com.example.oca;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FoodPageAdapter extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 2;
    private static final String[] PAGE_TITLES = {"Food to Eat", "Food to Avoid"};

    public FoodPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FoodToEat();
            case 1:
                return new FoodToAvoid();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return PAGE_TITLES[position];
    }
}
