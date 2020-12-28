package com.example.a12_28_dp_zy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends IBaseActivity {

    @BindView(R.id.tb_txt)
    TextView mTbTxt;
    @BindView(R.id.tb)
    Toolbar mTb;
    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.txt)
    TextView mTxt;
    @BindView(R.id.img2)
    ImageView mImg2;
    @BindView(R.id.img3)
    ImageView mImg3;
    @BindView(R.id.rel)
    RecyclerView mRel;
    @BindView(R.id.rel2)
    RecyclerView mRel2;
    @BindView(R.id.img4)
    ImageView mImg4;
    @BindView(R.id.tab)
    TabLayout mTab;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void init() {
        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.mipmap.ic_launcher));
        mTab.addTab(mTab.newTab().setIcon(R.mipmap.ic_launcher).setText("攻略"));
        mTab.addTab(mTab.newTab().setIcon(R.mipmap.ic_launcher).setText("我的"));

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        Toast.makeText(MainActivity.this, "点击了"+tab, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "点击了"+tab, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "点击了"+tab, Toast.LENGTH_SHORT).show();
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
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
