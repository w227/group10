package com.example.day09.engine.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.day09.base.App;


import java.util.List;

public class HomeActVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;


    public HomeActVpAdapter(FragmentManager mManager, List<Fragment> fragments) {
        super(mManager);
        this.mFragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


}