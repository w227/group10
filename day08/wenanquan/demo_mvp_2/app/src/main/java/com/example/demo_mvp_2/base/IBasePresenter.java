package com.example.demo_mvp_2.base;

public interface IBasePresenter<T> {
    void start();

    void start(T... t);
}
