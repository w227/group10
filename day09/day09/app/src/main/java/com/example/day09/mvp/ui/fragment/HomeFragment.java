package com.example.day09.mvp.ui.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day09.R;
import com.example.day09.base.BaseFragment;
import com.example.day09.base.BasePresenter;


public class HomeFragment extends BaseFragment {


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {


    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }
}
