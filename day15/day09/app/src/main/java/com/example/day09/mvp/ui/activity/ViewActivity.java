package com.example.day09.mvp.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.base.BaseActivity;
import com.example.day09.base.BasePresenter;
import com.example.day09.engine.adapter.VpViewApret;
import com.example.day09.manager.ContainManager;
import com.example.day09.manager.ThreadPoolManager;
import com.example.day09.thread.SpUtils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class ViewActivity extends BaseActivity {
    @BindView(R.id.vp_view_activity)
    ViewPager vpViewActivity;
    private ArrayList<View> list;
    private TextView mTv;
    private CheckBox rember;

    @Override
    protected BasePresenter createPresenter() {

        return null;
    }

    @Override
    protected void init() {
//        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
//        boolean cb = sp.getBoolean("cb", false);
//
//        if (cb) {
//            startActivity(new Intent(App.context(), UniteActivity.class));
//            finish();
//        }
//        rember.setChecked(cb);

        list = new ArrayList<>();
        VpViewApret vpViewApret = new VpViewApret(getView());
        vpViewActivity.setAdapter(vpViewApret);


    }

    private ArrayList<View> getView() {
        list.add(LayoutInflater.from(App.context()).inflate(R.layout.view_one, null));
        list.add(LayoutInflater.from(App.context()).inflate(R.layout.view_two, null));
        View view = LayoutInflater.from(App.context()).inflate(R.layout.view_three, null);
        view.findViewById(R.id.view_page).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(App.context(), UniteActivity.class));
                finish();

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
