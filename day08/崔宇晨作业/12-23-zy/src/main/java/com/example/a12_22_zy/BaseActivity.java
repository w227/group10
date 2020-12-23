package com.example.a12_22_zy;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter ,T> extends AppCompatActivity implements IBaseView<T>{

    private Unbinder bind;
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = LayoutId();
        setContentView(layoutId);
        bind = ButterKnife.bind(this);
        ContainManager.getmManager().addActivity(this);

        presenter = createPresenter();

        presenter.attachView(this);
        init();
        initData();
    }

    protected  void initData(){

    }

    protected abstract void init();

    protected abstract P createPresenter();

    protected abstract int LayoutId();

    @Override
    protected void onDestroy() {
        if (bind!=null){
            bind.unbind();
        }
        if (presenter!=null){
            presenter.detachView();
            presenter=null;
        }
    }
}
