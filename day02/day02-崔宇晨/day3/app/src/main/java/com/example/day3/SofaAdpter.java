package com.example.day3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SofaAdpter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFs;

    public SofaAdpter(@NonNull FragmentManager fm, ArrayList<Fragment> mFs) {
        super(fm);
        this.mFs = mFs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFs.get(position);
    }

    @Override
    public int getCount() {
        return mFs.size();
    }
}
