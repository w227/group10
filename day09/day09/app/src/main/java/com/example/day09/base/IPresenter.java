package com.example.day09.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}