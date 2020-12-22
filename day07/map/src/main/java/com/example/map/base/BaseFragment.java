package com.example.map.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

//  TODO 所有 Fragment 的共有方法 所有 Frangment 都要继承此类
public abstract class BaseFragment<P extends BasePresenter,T> extends Fragment implements IView<T> {

    private Unbinder bind;
    private P mPersten;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        布局
        int layoutId = LayoutId();
        View view = null;
        if (layoutId != 0)
//            添加布局
          view =  inflater.inflate(layoutId,null);
        bind = ButterKnife.bind(this, view);

        mPersten = createPerten();
        if (mPersten != null){
            mPersten.attchView(this);
        }
        return view;

    }



    protected abstract P createPerten();

    protected P getmPersten(){
        if (mPersten != null)
           return mPersten;

        return null;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int LayoutId();

    @Override
    public void onNext(T o) {

    }

    @Override
    public void onError(String smg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (bind != null)
            bind.unbind();

        if (mPersten != null){
            mPersten.detchView();
            mPersten =null;
        }
    }
}
