package com.example.a12_24_zy;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.a12_24_zy.base.BaseActivity;
import com.example.a12_24_zy.base.BasePresenter;
import com.example.a12_24_zy.mvp.ui.Home2Activity;
import com.example.a12_24_zy.mvp.ui.Home3Activity;
import com.example.a12_24_zy.mvp.ui.Home4Activity;
import com.example.a12_24_zy.mvp.ui.HomeActivity;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.rel)
    RecyclerView mRel;
    @BindView(R.id.tab2)
    TabLayout mTab2;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void init() {
        mTab.addTab(mTab.newTab().setText("排行榜"));
        mTab.addTab(mTab.newTab().setText("土豪帮"));
        mTab.addTab(mTab.newTab().setText("社团"));
        mTab.addTab(mTab.newTab().setText("地图"));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, Home2Activity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, Home3Activity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, Home4Activity.class));
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
    }

    @Override
    protected int createlayout() {
        return R.layout.activity_base;


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run ButterKnife again to generate code
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
    }


}
