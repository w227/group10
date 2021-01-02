package com.example.day09.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.base.BaseActivity;
import com.example.day09.base.BasePresenter;
import com.example.day09.engine.adapter.VpViewApret;
import com.example.day09.manager.ContainManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewActivity extends BaseActivity {
    @BindView(R.id.vp_view_activity)
    ViewPager vpViewActivity;
    private ArrayList<View> list;

    @Override
    protected BasePresenter createPresenter() {

        return null;
    }

    @Override
    protected void init() {

        list = new ArrayList<>();
        VpViewApret vpViewApret = new VpViewApret(getView());
        vpViewActivity.setAdapter(vpViewApret);


    }

    private ArrayList<View> getView() {
        list.add(LayoutInflater.from(App.context()).inflate(R.layout.view_one,null));
        list.add(LayoutInflater.from(App.context()).inflate(R.layout.view_two,null));
        View view = LayoutInflater.from(App.context()).inflate(R.layout.view_three, null);
        view.findViewById(R.id.view_page).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(App.context(),ZongActivity.class));

            }
        });
        list.add(view);
        return list;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_activity;
    }


}
