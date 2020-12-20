package com.example.dptext;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dptext.adapter.RvPoetAdapter;
import com.example.dptext.adapter.RvPoetryLoversAdapter;
import com.example.dptext.adapter.RvReadPoemAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mPoetRv;
    private RecyclerView mReadPoemRv;
    private RecyclerView mPoetryLoversRv;
    private RecyclerView mExcellentRv;
    private TabLayout mHomeTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mPoetRv = (RecyclerView) findViewById(R.id.rv_poet);
        mReadPoemRv = (RecyclerView) findViewById(R.id.rv_read_poem);
        mPoetryLoversRv = (RecyclerView) findViewById(R.id.rv_poetry_lovers);
        mExcellentRv = (RecyclerView) findViewById(R.id.rv_excellent);
        mHomeTab = (TabLayout) findViewById(R.id.tab_home);

        mHomeTab.addTab(mHomeTab.newTab().setIcon(R.drawable.icon_home).setText("首页"));
        mHomeTab.addTab(mHomeTab.newTab().setIcon(R.drawable.icon_write).setText("写诗"));
        mHomeTab.addTab(mHomeTab.newTab().setIcon(R.drawable.icon_camera).setText("传图"));
        mHomeTab.addTab(mHomeTab.newTab().setIcon(R.drawable.icon_works).setText("作品"));
        mHomeTab.addTab(mHomeTab.newTab().setIcon(R.drawable.icon_me).setText("我的"));


        List<String> list = new ArrayList<>();
        mPoetRv.setLayoutManager(new GridLayoutManager(this,5));
        RvPoetAdapter rvPoetAdapter = new RvPoetAdapter(this);
        mPoetRv.setAdapter(rvPoetAdapter);

        mReadPoemRv.setLayoutManager(new LinearLayoutManager(this));
        RvReadPoemAdapter rvReadPoemAdapter = new RvReadPoemAdapter(this);
        mReadPoemRv.setAdapter(rvReadPoemAdapter);

        mPoetryLoversRv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        RvPoetryLoversAdapter rvPoetryLoversAdapter = new RvPoetryLoversAdapter(this);
        mPoetryLoversRv.setAdapter(rvPoetryLoversAdapter);

    }

}