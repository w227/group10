package com.example.map.callback;

public interface RxObserverCallBack<T> {

    void onNextData(T o);

    void onErrorData(String smg);
}
