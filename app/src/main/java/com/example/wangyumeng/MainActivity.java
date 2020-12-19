package com.example.wangyumeng;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.wangyumeng.adapter.VpApret;
import com.example.wangyumeng.fragment.HomeFragment;
import com.example.wangyumeng.fragment.MyFragment;
import com.example.wangyumeng.fragment.ShaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tl;
    private ViewPager vp;
    private VpApret vpApret;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tl = (TabLayout) findViewById(R.id.tl);
        vp = (ViewPager) findViewById(R.id.vp);

        list = new ArrayList<>();

        list.add(new HomeFragment());
        list.add(new ShaFragment());
        list.add(new Fragment());
        list.add(new MyFragment());
        vpApret = new VpApret(getSupportFragmentManager(), list);

        vp.setAdapter(vpApret);

        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首页");
        tl.getTabAt(1).setText("沙发");
        tl.getTabAt(2).setText("发现");
        tl.getTabAt(3).setText("我的");

    }
}
