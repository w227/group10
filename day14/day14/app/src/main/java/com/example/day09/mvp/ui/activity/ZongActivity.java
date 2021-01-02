package com.example.day09.mvp.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.base.BaseActivity;
import com.example.day09.base.BasePresenter;
import com.example.day09.mvp.ui.fragment.HomeFragment;
import com.example.day09.mvp.ui.fragment.MyFragment;
import com.example.day09.mvp.ui.fragment.XuanFragment;
import com.example.day09.mvp.ui.fragment.XueFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZongActivity extends BaseActivity {
    @BindView(R.id.fl_act)
    FrameLayout flAct;
    @BindView(R.id.tl_act)
    TabLayout tlAct;
    @BindView(R.id.tb_home_frg)
    Toolbar tbHomeFrg;
    private HomeFragment homeFragment;
    private XuanFragment xuanFragment;
    private XueFragment xueFragment;
    private MyFragment myFragment;
    private FragmentTransaction transaction;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
//
//        ArrayList<Fragment> list = new ArrayList<>();
//        list.add(homeFragment);
//        list.add(xuanFragment);
//        list.add(xueFragment);
//        list.add(myFragment);

        setSupportActionBar(tbHomeFrg);
        homeFragment = new HomeFragment();
        xuanFragment = new XuanFragment();
        xueFragment = new XueFragment();
        myFragment = new MyFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fl_act, homeFragment)
                .add(R.id.fl_act, xuanFragment)
                .add(R.id.fl_act, xueFragment)
                .add(R.id.fl_act, myFragment)
                .hide(xuanFragment)
                .hide(xueFragment)
                .hide(myFragment)
                .commit();

        tlAct.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    case 0:
                        getSupportFragmentManager().beginTransaction().show(homeFragment)
                                .hide(xuanFragment)
                                .hide(xueFragment)
                                .hide(myFragment)
                                .commit();

                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .show(xuanFragment)
                                .hide(homeFragment)
                                .hide(xueFragment)
                                .hide(myFragment)
                                .commit();

                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .show(xueFragment)
                                .hide(homeFragment)
                                .hide(xuanFragment)
                                .hide(myFragment)
                                .commit();


                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .show(myFragment)
                                .hide(homeFragment)
                                .hide(xueFragment)
                                .hide(xuanFragment)
                                .commit();

                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tlAct.addTab(tlAct.newTab().setIcon(R.drawable.select1).setText("首页"));
        tlAct.addTab(tlAct.newTab().setIcon(R.drawable.select2).setText("选课"));
        tlAct.addTab(tlAct.newTab().setIcon(R.drawable.select3).setText("学习"));
        tlAct.addTab(tlAct.newTab().setIcon(R.drawable.select4).setText("我的"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.zong_activity;
    }


}
