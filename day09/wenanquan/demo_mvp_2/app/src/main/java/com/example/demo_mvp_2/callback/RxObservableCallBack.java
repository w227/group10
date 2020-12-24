package com.example.demo_mvp_2.callback;

import io.reactivex.disposables.Disposable;

public interface RxObservableCallBack<T> {
    void onSucceed(T t);

    void onFiled(String errorMsg);

    void onSubscribe(Disposable disposable);
}
