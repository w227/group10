package com.example.xsx_zy_qunti_3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.xsx_zy_qunti_3.fragment.FindFragment;
import com.example.xsx_zy_qunti_3.fragment.HomeFragment;
import com.example.xsx_zy_qunti_3.fragment.IconFragment;
import com.example.xsx_zy_qunti_3.fragment.MineFragment;
import com.example.xsx_zy_qunti_3.fragment.StoreFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_toolbar;
    private Toolbar toolbar;
    private ViewPager vp;
    private TabLayout tabs;
    private List<Fragment> fragments;
    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private IconFragment iconFragment;
    private StoreFragment storeFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv_toolbar = (TextView) findViewById(R.id.tv_toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        vp = (ViewPager) findViewById(R.id.vp);
        tabs = (TabLayout) findViewById(R.id.tabs);
        setSupportActionBar(toolbar);
        fragments = new ArrayList<>();
        homeFragment = new HomeFragment();
        findFragment = new FindFragment();
        iconFragment = new IconFragment();
        storeFragment = new StoreFragment();
        mineFragment = new MineFragment();
        fragments.add(homeFragment);
        fragments.add(findFragment);
        fragments.add(iconFragment);
        fragments.add(storeFragment);
        fragments.add(mineFragment);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tabs.setupWithViewPager(vp);
        tabs.getTabAt(0).setText("首页");
        tabs.getTabAt(1).setText("发现");
        tabs.getTabAt(2).setIcon(R.drawable.ic_launcher_background).setText("");
        tabs.getTabAt(3).setText("商城");
        tabs.getTabAt(4).setText("我的");
        TabLayout.Tab tabAt = tabs.getTabAt(tabs.getSelectedTabPosition());
        tv_toolbar.setText(tabAt.getText().toString());
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tv_toolbar.setText(tabs.getTabAt(tab.getPosition()).getText().toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
