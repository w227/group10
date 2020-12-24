package com.example.a12_24_zy.base;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter,T> extends AppCompatActivity implements IBaseView<T> {

    private Unbinder bind;
    private P mPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int createlayout = createlayout();
        if (createlayout!=0){
            setContentView(createlayout);
        }

        bind = ButterKnife.bind(this);
        mPresent = createPresenter();
        if (mPresent!=null){
            mPresent.attachView(this);
        }
        init();
        initData();
    }

    protected abstract P createPresenter();

    protected P getmPresent(){
        if (mPresent!=null){
            return mPresent;
        }

        return null;
    }

    protected  void initData(){

    }

    protected abstract void init();

    protected abstract int createlayout();



    @Override
    public void showSucess(T t) {

    }

    @Override
    public void showFailes(String msg) {

    }

    @Override
    protected void onDestroy() {
        if (bind!=null){
            bind.unbind();
        }
        super.onDestroy();
    }
}
