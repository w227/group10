package com.example.demo_mvp_2.mvp.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.demo_mvp_2.R;
import com.example.demo_mvp_2.base.BaseFragment;
import com.example.demo_mvp_2.base.BasePresenter;
import com.example.demo_mvp_2.mvp.presenter.FindFragmentPresenter;
import com.example.demo_mvp_2.mvp.ui.activity.BaiduMapLocationActivity;
import com.example.demo_mvp_2.mvp.ui.activity.PoiSugSearchActivity;
import com.example.demo_mvp_2.mvp.ui.activity.tongpao.find.CommunityActivity;
import com.example.demo_mvp_2.mvp.ui.activity.tongpao.find.RobeActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

public class FindFragment extends BaseFragment {
    @BindView(R.id.tv_paozi)
    TextView tvPaozi;
    @BindView(R.id.tv_shetuan)
    TextView tvShetuan;
    @BindView(R.id.tv_paihangbang)
    TextView tvPaihangbang;
    @BindView(R.id.rv_activity)
    RecyclerView rvActivity;
    @BindView(R.id.tab_found2)
    TabLayout tabFound2;
    @BindView(R.id.vp_find)
    ViewPager vpFind;
    @BindView(R.id.tv_sousuo)
    TextView tvSousuo;
    @BindView(R.id.tv_weizhi)
    TextView tvWeizhi;
    @BindView(R.id.rl_found)
    RelativeLayout rlFound;
    @BindView(R.id.appbar)
    AppBarLayout appbar;

    @Override
    protected BasePresenter createPresenter() {
//        return new FindFragmentPresenter(this);
    return null;
    }

    @Override
    protected void init() {

        tvPaozi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RobeActivity.class));
            }
        });

        tvShetuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CommunityActivity.class));
            }
        });

        tvSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PoiSugSearchActivity.class));
            }
        });

        tvWeizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BaiduMapLocationActivity.class));
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }


    @Override
    public void onSucceed(Object o) {

    }

    @Override
    public void onFiled(String errorMsg) {

    }


}
