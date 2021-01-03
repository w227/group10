package com.example.day09.mvp.ui.fragment;

import android.widget.ImageView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.base.BaseFragment;
import com.example.day09.base.BasePresenter;
import com.example.day09.engine.adapter.RvMyApret;

import butterknife.BindView;

public class MyFragment extends BaseFragment {
    @BindView(R.id.img_study)
    ImageView imgStudy;
    @BindView(R.id.rv_my)
    RecyclerView rvMy;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

        Glide.with(App.context()).load(R.drawable.iv_baokao_chuji)
                .apply(new RequestOptions().circleCrop())
                .into(imgStudy);

        rvMy.setLayoutManager(new LinearLayoutManager(App.context()));
        rvMy.addItemDecoration(new DividerItemDecoration(App.context(),DividerItemDecoration.VERTICAL));
        RvMyApret rvMyApret = new RvMyApret(App.context());
        rvMy.setAdapter(rvMyApret);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.my_fragment;
    }
}
