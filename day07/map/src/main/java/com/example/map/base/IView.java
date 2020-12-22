package com.example.map.base;

public interface IView<T> {

    void onNext(T o);

    void onError(String smg);
}
