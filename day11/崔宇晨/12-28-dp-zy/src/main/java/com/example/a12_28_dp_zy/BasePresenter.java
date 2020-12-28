package com.example.a12_28_dp_zy;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView,T> implements IBasePresenter<T>{
    protected WeakReference<V> mView;
    private CompositeDisposable mComposite =
            new CompositeDisposable();


    //添加网络开关
    protected void addDisposable(Disposable disposable) {
        if (mComposite != null)
            mComposite.add(disposable);
    }


    // 1.用弱引用修饰V层 方便GC回收  2.P层关联V层
    protected void attachView(V view) {
        mView = new WeakReference<V>(view);
    }


    //2.释放V层资源的同时断开网络开关
    protected void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        deleteDisposable();
    }

    //断开网络开关
    private void deleteDisposable() {
        if (mComposite != null && !mComposite.isDisposed()) {
            mComposite.dispose();
            mComposite.clear();
            mComposite = null;
        }
    }
    @Override
    public void start() {

    }

    @Override
    public void start(T t) {

    }

}
