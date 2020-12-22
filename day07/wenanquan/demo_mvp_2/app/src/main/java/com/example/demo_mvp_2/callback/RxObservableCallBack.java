package com.example.demo_mvp_2.callback;

public interface RxObservableCallBack<T> {
    void onSucceed(T t);

    void onFiled(String errorMsg);
}
