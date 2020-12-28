package com.example.a12_28_dp_zy;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class IBaseActivity<P extends BasePresenter,T> extends AppCompatActivity implements IBaseView<T>{

    private Unbinder bind;
    private P mPersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setContentView(layoutId);
        bind = ButterKnife.bind(this);
        init();
        initData();

        //创建p层
        mPersenter = createPresenter();
        if (mPersenter!=null){
            mPersenter.attachView(this);
        }
    }

    protected abstract P createPresenter();

    protected abstract void initData();

    protected abstract void init();

    protected abstract int getLayoutId();

    @Override
    public void showSucess(T t) {

    }

    @Override
    public void showFaile(String msg) {

    }

    @Override
    protected void onDestroy() {
        bind.unbind();
        if (mPersenter!=null){
            mPersenter.detachView();
            mPersenter=null;
        }
        super.onDestroy();
    }
}
