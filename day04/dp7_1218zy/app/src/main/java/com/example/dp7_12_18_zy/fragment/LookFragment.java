package com.example.dp7_12_18_zy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.dp7_12_18_zy.AssociationActivity;
import com.example.dp7_12_18_zy.BoardActivity;
import com.example.dp7_12_18_zy.R;
import com.example.dp7_12_18_zy.model.bean.DataInfo;
import com.example.dp7_12_18_zy.view.Viem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class LookFragment extends Fragment implements Viem {

    private Toolbar mTb;
    private TextView mTbtxt;
    private TabLayout mTab;
    private TabLayout mTab2;
    private RecyclerView mRel;
    private ArrayList<Fragment> mFs;
    private ArrayList<DataInfo.DataBean> mBean;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.look_item, null);
        mTb = view.findViewById(R.id.tb);
        mTbtxt = view.findViewById(R.id.tb_txt);
        mTab = view.findViewById(R.id.look_tab);
        mTab2 = view.findViewById(R.id.look_tab2);
        mRel = view.findViewById(R.id.look_rel);

        initTab();
        initTab2();
        initData();
        return view;
    }

    private void initTab2() {
        mTab2.addTab(mTab2.newTab().setText("热点"));
        mTab2.addTab(mTab2.newTab().setText("装造"));
        mTab2.addTab(mTab2.newTab().setText("图赏"));
        mTab2.addTab(mTab2.newTab().setText("百科"));

        mTab2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        Toast.makeText(getContext(), "点击了"+tab, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getContext(), "点击了"+tab, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getContext(), "点击了"+tab, Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getContext(), "点击了"+tab, Toast.LENGTH_SHORT).show();
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

    private void initData() {
        LookPresenter lookPresenter = new LookPresenter(this);
        lookPresenter.start();
    }

    private void initTab() {
        mTab.addTab(mTab.newTab().setText("袍子").setIcon(R.mipmap.ic_launcher));
        mTab.addTab(mTab.newTab().setText("社团").setIcon(R.mipmap.ic_launcher));
        mTab.addTab(mTab.newTab().setText("排行榜").setIcon(R.mipmap.ic_launcher));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        startActivity(new Intent(getContext(), AssociationActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getContext(), BoardActivity.class));
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
    public void showSucess(Object object) {
        if (object instanceof DataInfo){
            DataInfo info=(DataInfo)object;
            List<DataInfo.DataBean> data = info.getData();
            mBean = new ArrayList<>();
            mBean.addAll(data);
            LookAdpter lookAdpter = new LookAdpter(mBean,getContext());
            mRel.setAdapter(lookAdpter);
            mRel.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
            lookAdpter.notifyDataSetChanged();
        }
    }

    @Override
    public void showFaile(String msg) {

    }
}
