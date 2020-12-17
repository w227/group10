package com.example.day3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

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
        mFs.add(new SofaFragment());
        mFs.add(new LookFragment());

        VpAdpter adpter = new VpAdpter(getSupportFragmentManager(),mFs);
        mVp.setAdapter(adpter);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setIcon(R.mipmap.ic_launcher).setText("沙发");
        mTab.getTabAt(1).setIcon(R.mipmap.ic_launcher).setText("发现");
    }
}
