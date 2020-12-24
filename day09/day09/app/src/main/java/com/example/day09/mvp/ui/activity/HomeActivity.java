package com.example.day09.mvp.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day09.R;
import com.example.day09.base.BaseActivity;
import com.example.day09.base.BasePresenter;
import com.example.day09.engine.adapter.HomeActVpAdapter;
import com.example.day09.mvp.ui.fragment.FaFragment;
import com.example.day09.mvp.ui.fragment.HomeFragment;
import com.example.day09.mvp.ui.fragment.MyFragment;
import com.example.day09.mvp.ui.fragment.PaoFragment;
import com.example.day09.mvp.ui.fragment.ShangFragment;
import com.example.day09.mvp.ui.fragment.SheFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.home_act_vp)
    ViewPager homeActVp;
    @BindView(R.id.home_act_tab)
    TabLayout homeActTab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {


        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new PaoFragment());
        list.add(new FaFragment());
        list.add(new PaoFragment());
        list.add(new MyFragment());
        HomeActVpAdapter homeActVpAdapter = new HomeActVpAdapter(getSupportFragmentManager(), list);

        homeActVp.setAdapter(homeActVpAdapter);
        homeActTab.setupWithViewPager(homeActVp);

        homeActTab.getTabAt(0).setIcon(R.drawable.shou);
        homeActTab.getTabAt(1).setIcon(R.drawable.fa );
        homeActTab.getTabAt(2).setIcon(R.drawable.shang);
        homeActTab.getTabAt(3).setIcon(R.drawable.wo);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_activity;
    }
}
