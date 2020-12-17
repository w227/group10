package com.example.day3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day3.view.Viem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SofaFragment extends Fragment {

    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> mFs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.sofa_item, null);
        mVp = view.findViewById(R.id.sofa_vp);
        mTab = view.findViewById(R.id.sofa_tab);
        initData();
        return view;
    }

    private void initData() {
        mFs = new ArrayList<>();
        mFs.add(new TuFragment());
        mFs.add(new SpFragment());
        mFs.add(new TextFragment());

        SofaAdpter sofaAdpter = new SofaAdpter(getChildFragmentManager(),mFs);
        mVp.setAdapter(sofaAdpter);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setText("图片");
        mTab.getTabAt(1).setText("视频");
        mTab.getTabAt(2).setText("文本");
    }

}
