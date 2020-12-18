package com.example.day04.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.day04.R;
import com.example.day04.feagment.JingFragment;
import com.example.day04.feagment.QianFragment;
import com.example.day04.feagment.TuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.tl_home)
    TabLayout tlHome;
    @BindView(R.id.fl_home)
    FrameLayout fl;
    private FragmentManager manager;
    private JingFragment jingFragment;
    private TuFragment tuFragment;
    private QianFragment qianFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new JingFragment());
        list.add(new TuFragment());
        list.add(new QianFragment());

        manager = getSupportFragmentManager();
        jingFragment = new JingFragment();
        tuFragment = new TuFragment();
        qianFragment = new QianFragment();

        manager.beginTransaction()
                .add(R.id.fl_home,jingFragment)
                .add(R.id.fl_home,tuFragment)
                .add(R.id.fl_home,qianFragment)
                .hide(tuFragment)
                .hide(qianFragment)
                .commit();

        tlHome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        manager.beginTransaction()
                                .show(jingFragment)
                                .hide(tuFragment)
                                .hide(qianFragment)
                                .commit();
                        break;
                          case 1:
                        manager.beginTransaction()
                                .show(tuFragment)
                                .hide(jingFragment)
                                .hide(qianFragment)
                                .commit();
                        break;
                          case 2:
                        manager.beginTransaction()
                                .show(qianFragment)
                                .hide(tuFragment)
                                .hide(jingFragment)
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

        tlHome.addTab(tlHome.newTab().setText("经验榜"));
        tlHome.addTab(tlHome.newTab().setText("土豪榜"));
        tlHome.addTab(tlHome.newTab().setText("签到榜"));
    }
}
