package com.example.mvp.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.R;
import com.example.mvp.manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 所有Activity都要继承的类
 *
 * @param <T>
 */
public abstract class BaseActivity<P extends BasePresenter, T> extends AppCompatActivity implements IBaseView<T> {
    private Unbinder mBind;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Activity加载布局
        int layoutId = getLayoutId();
        if (layoutId != 0)
            setContentView(layoutId);
        mBind = ButterKnife.bind(this);
        //将所有的Activity添加到集合里面
        ContainManager.getmManager().addActivity(this);
        //1.创建P层对象并且关联V层
        mPresenter = createPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);
        //初始化view
        init();
        //初始化数据
        initData();
    }

    protected abstract P createPresenter();

    //获取P层对象
    protected P getmPresenter() {
        if (mPresenter != null) {
            return mPresenter;
        }
        return null;
    }

    protected void initData() {

    }

    protected abstract void init();


    protected abstract int getLayoutId();

    @Override
    public void onScuccess(T t) {

    }

    @Override
    public void onError(String msg) {

    }

    //释放资源
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}