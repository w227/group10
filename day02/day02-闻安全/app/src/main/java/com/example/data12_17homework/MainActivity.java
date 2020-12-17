package com.example.data12_17homework;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.data12_17homework.adapter.VpAdapter;
import com.example.data12_17homework.fragment.FoundFragment;
import com.example.data12_17homework.fragment.SofaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp_main;
    private TabLayout tab_main;
    private VpAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        tab_main = (TabLayout) findViewById(R.id.tab_main);

        List<Fragment> fragments = new ArrayList<>();
        List<String> tabs = new ArrayList<>();
        fragments.add(new SofaFragment());
        fragments.add(new FoundFragment());
        tabs.add("沙发");
        tabs.add("发现");

        vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments, tabs);

        vp_main.setAdapter(vpAdapter);

        tab_main.setupWithViewPager(vp_main);
    }
}