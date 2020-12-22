package com.example.demo_mvp_2.base;

import android.app.Activity;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView<T>, T> implements IBasePresenter<T> {

    private WeakReference<V> mView;

    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    public void addDisposable(Disposable disposable) {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.add(disposable);
        }
    }

    public void attachView(V view) {
        mView = new WeakReference<>(view);
    }

    public void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        deleteDisposable();
    }

    private void deleteDisposable() {
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();
        }
    }


    @Override
    public void start() {

    }

    @Override
    public void start(T... t) {

    }
}
