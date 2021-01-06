package com.example.day09.callback;

public interface RxObserverCallBack<T> {
    void onSuccessData(Object o);
    void onErrorMsg(String msg);
}