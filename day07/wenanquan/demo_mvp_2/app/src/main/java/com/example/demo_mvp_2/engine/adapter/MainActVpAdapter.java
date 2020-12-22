package com.example.demo_mvp_2.engine.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.demo_mvp_2.base.App;

import java.util.List;

public class MainActVpAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments;
    private final List<Integer> mTabs;

    public MainActVpAdapter(@NonNull FragmentManager fm, List<Fragment> mFragments, List<Integer> mTabs) {
        super(fm);
        this.mFragments = mFragments;
        this.mTabs = mTabs;
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

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return App.getStr(mTabs.get(position));
    }
}
