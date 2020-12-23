package com.example.demo_mvp_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.demo_mvp_2.base.App;
import com.example.demo_mvp_2.base.BaseActivity;
import com.example.demo_mvp_2.base.BasePresenter;
import com.example.demo_mvp_2.engine.adapter.MainActVpAdapter;
import com.example.demo_mvp_2.mvp.ui.fragment.FindFragment;
import com.example.demo_mvp_2.mvp.ui.fragment.HomeFragment;
import com.example.demo_mvp_2.mvp.ui.fragment.MeFragment;
import com.example.demo_mvp_2.mvp.ui.fragment.ShopFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.main_act_vp)
    ViewPager mainActVp;
    @BindView(R.id.main_act_tab)
    TabLayout mainActTab;
    private List<Fragment> mFragments;
    private List<Integer> mTabs;
    private FragmentManager mManager;
    private MainActVpAdapter mMainActVpAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

        mManager = getSupportFragmentManager();

        mFragments = new ArrayList<>();
        mTabs = new ArrayList<>();

        mMainActVpAdapter = new MainActVpAdapter(mManager, mFragments, mTabs);

        mainActVp.setAdapter(mMainActVpAdapter);

        mainActTab.setupWithViewPager(mainActVp);

    }

    @Override
    protected void initData() {
        mFragments.add(new HomeFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new ShopFragment());
        mFragments.add(new MeFragment());

        mTabs.add(R.string.home_tab_title);
        mTabs.add(R.string.find_tab_title);
        mTabs.add(R.string.empty_text);
        mTabs.add(R.string.shop_tab_title);
        mTabs.add(R.string.me_tab_title);

        mMainActVpAdapter.notifyDataSetChanged();

        mainActTab.getTabAt(0).setText(App.getStr(R.string.home_tab_title)).setIcon(R.drawable.tabs_home);
        mainActTab.getTabAt(1).setText(App.getStr(R.string.find_tab_title)).setIcon(R.drawable.tabs_find_2);
        mainActTab.getTabAt(2).setIcon(R.drawable.tabs_center);
        mainActTab.getTabAt(3).setText(App.getStr(R.string.shop_tab_title)).setIcon(R.drawable.tabs_shop);
        mainActTab.getTabAt(4).setText(App.getStr(R.string.me_tab_title)).setIcon(R.drawable.tabs_me);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}