package com.example.demo_mvp_2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter, T> extends AppCompatActivity implements IBaseView<T> {

    private Unbinder mBind;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutId = getLayoutId();
        if (layoutId != 0) {
            setContentView(layoutId);
        }
        mBind = ButterKnife.bind(this);

        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        init();
        initData();
    }

    protected abstract P createPresenter();

    public P getPresenter() {
        if (mPresenter != null) {
            return mPresenter;
        } else {
            return null;
        }
    }

    protected void initData() {
    }

    protected abstract void init();

    protected abstract int getLayoutId();


    @Override
    public void onSucceed(T t) {

    }

    @Override
    public void onFiled(String errorMsg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
    }
}
