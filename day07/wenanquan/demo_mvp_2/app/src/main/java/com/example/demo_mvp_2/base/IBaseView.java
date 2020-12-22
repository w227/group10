package com.example.demo_mvp_2.base;

public interface IBaseView<T> {
    void onSucceed(T t);

    void onFiled(String errorMsg);
}
