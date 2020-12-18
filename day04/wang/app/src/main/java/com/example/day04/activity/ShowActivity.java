package com.example.day04.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day04.R;
import com.example.day04.adapter.RvQianApret;
import com.example.day04.adapter.RvShowApret;
import com.example.day04.bean.ShowBean;
import com.example.day04.feagment.JingFragment;
import com.example.day04.feagment.QianFragment;
import com.example.day04.feagment.TuFragment;
import com.example.day04.perstr.HomePertent;
import com.example.day04.view.IView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity implements IView {


    @BindView(R.id.rv_show)
    RecyclerView rvShow;
    private ArrayList<ShowBean.DataBean.ListBean> list;
    private RvShowApret rvShowApret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        HomePertent homePertent = new HomePertent(this);
        homePertent.show();
    }

    private void initView() {

        rvShow.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        rvShowApret = new RvShowApret(list, this);
        rvShow.setAdapter(rvShowApret);
        rvShow.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onNextUi(Object o) {
        if (o instanceof  ShowBean){
            ShowBean showBean = (ShowBean) o;
            List<ShowBean.DataBean.ListBean> listBeans = showBean.getData().getList();

            list.addAll(listBeans);
        }
    }

    @Override
    public void onErrorUi(String smg) {

        Log.e("tag","错误"+smg);

    }
}
