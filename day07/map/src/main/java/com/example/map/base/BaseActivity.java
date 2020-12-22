package com.example.map.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.map.manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

// TODO 所有Activity 共有的 方法  共有方法放里面 所有activity 继承这个类
// TODO 分别有.重写onCreate方法 和	onDestroy  Activity 加载布局
// TODO 黄油刀 将所有的Activity添加到集合里面 .初始化    创建P层 对象 并且关联 V层  获取P 层对象
public abstract class BaseActivity<P extends BasePresenter, T> extends AppCompatActivity implements IView {

    private Unbinder bind;
    private P mPersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutid = LayoutId();
        if (layoutid != 0)
            setContentView(layoutid);
        bind = ButterKnife.bind(this);

        ContainManager.manager().addActivity(this);

        mPersenter = createPersenter();
        if (mPersenter != null)
            mPersenter.attchView(this);

        initView();
        initData();

    }

    protected P getmPersenter() {
        if (mPersenter != null)
            return mPersenter;
        return null;
    }

    protected abstract P createPersenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int LayoutId();


    @Override
    public void onNext(Object o) {

    }

    @Override
    public void onError(String smg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null)
            bind.unbind();

        if (mPersenter != null) {
            mPersenter.detchView();
            mPersenter = null;
        }
    }
}
