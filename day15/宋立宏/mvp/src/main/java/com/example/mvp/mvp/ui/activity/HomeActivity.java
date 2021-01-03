package com.example.mvp.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TimeUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mvp.R;
import com.example.mvp.base.BaseActivity;
import com.example.mvp.base.BasePresenter;
import com.example.mvp.manager.ThreadPoolManager;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.root_ll)
    LinearLayout rootLl;



    @Override
    protected void init() {
        ThreadPoolManager.getThreadPool(ThreadPoolManager.SCHDULE_THREADPOOL).executeTimerTask(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(HomeActivity.this,Main2Activity.class));
                finish();

            }
        },2, TimeUnit.SECONDS);

    }
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
