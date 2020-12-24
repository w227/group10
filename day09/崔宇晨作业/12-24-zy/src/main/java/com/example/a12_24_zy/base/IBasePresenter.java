package com.example.a12_24_zy.base;

public interface IBasePresenter<T> {
    void start();

    void start(T... t);
}
