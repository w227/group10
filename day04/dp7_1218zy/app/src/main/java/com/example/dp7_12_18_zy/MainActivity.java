package com.example.dp7_12_18_zy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.dp7_12_18_zy.fragment.VpAdpter;
import com.example.dp7_12_18_zy.fragment.HomeFragment;
import com.example.dp7_12_18_zy.fragment.LookFragment;
import com.example.dp7_12_18_zy.fragment.MyFragment;
import com.example.dp7_12_18_zy.fragment.SendFragment;
import com.example.dp7_12_18_zy.fragment.ShopFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> mFs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);

        mFs = new ArrayList<>();
        mFs.add(new HomeFragment());
        mFs.add(new LookFragment());
        mFs.add(new SendFragment());
        mFs.add(new ShopFragment());
        mFs.add(new MyFragment());

        VpAdpter adpter = new VpAdpter(getSupportFragmentManager(),mFs);
        mVp.setAdapter(adpter);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setText("首页").setIcon(R.mipmap.ic_launcher);
        mTab.getTabAt(1).setText("发现").setIcon(R.mipmap.ic_launcher);
        mTab.getTabAt(2).setText("+").setIcon(R.mipmap.ic_launcher);
        mTab.getTabAt(3).setText("商城").setIcon(R.mipmap.ic_launcher);
        mTab.getTabAt(4).setText("我的").setIcon(R.mipmap.ic_launcher);
    }
}
