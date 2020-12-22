package com.example.map.base;
// TODO 实现P层的接口
public interface IPresenter<T> {
    void start();
     void start(T...t);

}
