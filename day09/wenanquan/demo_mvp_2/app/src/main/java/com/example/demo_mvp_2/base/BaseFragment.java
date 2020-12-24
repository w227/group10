package com.example.demo_mvp_2.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter,T> extends Fragment implements IBaseView<T> {

    private Unbinder mBind;
    private P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = null;

        int layoutId = getLayoutId();
        if (layoutId != 0) {
            view = inflater.inflate(layoutId, null);

            mBind = ButterKnife.bind(this, view);
        }

        mPresenter = createPresenter();
        if(mPresenter!=null){
            mPresenter.attachView(this);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
    public void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
    }
}
