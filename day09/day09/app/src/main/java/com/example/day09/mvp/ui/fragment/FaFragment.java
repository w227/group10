package com.example.day09.mvp.ui.fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.base.BaseFragment;
import com.example.day09.base.BasePresenter;
import com.example.day09.engine.adapter.RvApret;

import java.util.ArrayList;

import butterknife.BindView;

public class FaFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;

    private ArrayList<Integer> list;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

        rv.setLayoutManager(new LinearLayoutManager(App.context()));
//        list = new ArrayList<>();
        RvApret rvApret = new RvApret(App.context());
        rv.addItemDecoration(new DividerItemDecoration(App.context(),DividerItemDecoration.VERTICAL));
        rv.setAdapter(rvApret);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_fa;
    }
}
