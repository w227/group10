package com.example.day09.mvp.ui.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.base.BaseFragment;
import com.example.day09.base.BasePresenter;
import com.example.day09.engine.adapter.RvApret;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.rv_home_frgment)
    RecyclerView rvHomeFrgment;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

//        new ArrayList<>();
        RvApret rvApret = new RvApret(App.context());
        rvHomeFrgment.setAdapter(rvApret);



    }



    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }
}
