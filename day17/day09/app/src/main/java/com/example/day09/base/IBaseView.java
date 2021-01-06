package com.example.day09.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}