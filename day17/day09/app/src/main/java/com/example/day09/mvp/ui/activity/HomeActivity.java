package com.example.day09.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.base.BaseActivity;
import com.example.day09.base.BasePresenter;
import com.example.day09.manager.ThreadPoolManager;
import com.example.day09.base.SpUtils;
import com.example.day09.mvp.model.bean.DecodeBean;
import com.example.day09.mvp.model.constants.ApiConstants;
import com.example.day09.mvp.presenter.SplashPresenter;

import java.util.concurrent.TimeUnit;

public class HomeActivity extends BaseActivity {


    private Button ok;

    @Override
    protected BasePresenter createPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    protected void init() {
        initView();

    }

    private void initView() {

        ThreadPoolManager.getThreadPool(ThreadPoolManager.SCHDULE_THREADPOOL)
                .executeTimerTask(new Runnable() {
                    @Override
                    public void run() {
                        Boolean user = SpUtils.getInstance().getBoolean("user");
                        if (user) {
                            startActivity(new Intent(App.context(), UniteActivity.class));
                            finish();
                        } else {
                            startActivity(new Intent(App.context(), ViewActivity.class));
                            finish();
                            SpUtils.getInstance().setValue("user", true);

                        }
                    }
                }, 2, TimeUnit.SECONDS);

        getmPresenter().start(ApiConstants.DEVICE);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.home_activity;
    }

    @Override
    public void onScuccess(Object o) {
        super.onScuccess(o);
        if (o instanceof DecodeBean){
            DecodeBean bean = (DecodeBean) o;
            Log.e("tag",bean.getData());
        }
        Log.e("tag","成功");
    }

    @Override
    public void onError(String msg) {
        super.onError(msg);


        Log.e("tag","失败"+msg);
    }
}