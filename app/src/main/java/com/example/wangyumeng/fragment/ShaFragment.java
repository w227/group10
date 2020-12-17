package com.example.wangyumeng.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.wangyumeng.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShaFragment extends Fragment {


    @BindView(R.id.tl_sha)
    TabLayout tlSha;
    @BindView(R.id.fl)
    FrameLayout fl;
    private FragmentActivity activity;
    private PickFragment pickFragment;
    private ShiFragment shiFragment;
    private WenFragment wenFragment;
    private FragmentManager manager;

    public ShaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sha, container, false);
        activity = getActivity();
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    private void initView() {

        manager = activity.getSupportFragmentManager();

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new PickFragment());
        list.add(new ShiFragment());
        list.add(new WenFragment());

        pickFragment = new PickFragment();
        shiFragment = new ShiFragment();
        wenFragment = new WenFragment();

        manager.beginTransaction()
                .add(R.id.fl, pickFragment)
                .add(R.id.fl, shiFragment)
                .add(R.id.fl, wenFragment)
                .hide(shiFragment)
                .hide(wenFragment)
                .commit();

        tlSha.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:

                        manager.beginTransaction()
                                .show(pickFragment)
                                .hide(shiFragment)
                                .hide(wenFragment)
                                .commit();
                        break;
                          case 1:

                        manager.beginTransaction()
                                .show(shiFragment)
                                .hide(pickFragment)
                                .hide(wenFragment)
                                .commit();
                        break;
                          case 2:

                        manager.beginTransaction()
                                .show(wenFragment)
                                .hide(shiFragment)
                                .hide(pickFragment)
                                .commit();
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

        tlSha.addTab(tlSha.newTab().setText("图片"));
        tlSha.addTab(tlSha.newTab().setText("视频"));
        tlSha.addTab(tlSha.newTab().setText("文本"));

    }

}
