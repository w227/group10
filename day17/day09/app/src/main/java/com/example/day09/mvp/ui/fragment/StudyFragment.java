package com.example.day09.mvp.ui.fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.base.BaseFragment;
import com.example.day09.base.BasePresenter;
import com.example.day09.engine.adapter.RvApret;

import butterknife.BindView;

public class StudyFragment extends BaseFragment {
    @BindView(R.id.rv_study)
    RecyclerView rvStudy;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

        rvStudy.setLayoutManager(new LinearLayoutManager(App.context()));
        rvStudy.addItemDecoration(new DividerItemDecoration(App.context(),DividerItemDecoration.VERTICAL));
        RvApret rvApret = new RvApret(App.context());
        rvStudy.setAdapter(rvApret);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.study_fragment;
    }
}
