package com.example.day3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day3.model.bean.DataInfo4;
import com.example.day3.view.Viem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class LookFragment extends Fragment {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> mFs;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.look_item, null);
        mTab = view.findViewById(R.id.look_tab);
        mVp = view.findViewById(R.id.look_vp);
        initData();
        return view;
    }

    private void initData() {
        mFs = new ArrayList<>();
        mFs.add(new LikeFragment());
        mFs.add(new RecommendFragment());

        VpAdpter2 adpter2 = new VpAdpter2(getChildFragmentManager(),mFs);
        mVp.setAdapter(adpter2);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setText("推荐");
        mTab.getTabAt(1).setText("关注");
    }

}
