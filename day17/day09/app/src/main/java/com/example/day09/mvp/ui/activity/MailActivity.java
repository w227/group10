package com.example.day09.mvp.ui.activity;

import android.os.Bundle;

import com.example.day09.R;
import com.example.day09.base.BaseActivity;
import com.example.day09.base.BasePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MailActivity extends BaseActivity {




    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
