package com.example.a12_28_dp_zy;

import javax.inject.Singleton;

import dagger.Component;

//注射器
@Singleton
@Component(modules = RetrofitManger.class)
public interface RetrofitComponent {
    //自定义的方法
    void getStringLeApiService(RxOprtroImpl rxOprtro);
}
