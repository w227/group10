package com.example.day04.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day04.R;
import com.example.day04.adapter.VpApret;
import com.example.day04.feagment.FaFragment;
import com.example.day04.feagment.HomeFragment;
import com.example.day04.feagment.MyFragment;
import com.example.day04.feagment.PickFragment;
import com.example.day04.feagment.ShangFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tl)
    TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new FaFragment());
        list.add(new PickFragment());
        list.add(new ShangFragment());
        list.add(new MyFragment());


        VpApret vpApret = new VpApret(getSupportFragmentManager(),list);
        vp.setAdapter(vpApret);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首页");
        tl.getTabAt(1).setText("发现");
        tl.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        tl.getTabAt(3).setText("商城");
        tl.getTabAt(4).setText("我的");

    }
}
