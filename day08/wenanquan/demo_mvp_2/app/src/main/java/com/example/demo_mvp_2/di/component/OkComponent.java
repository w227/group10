package com.example.demo_mvp_2.di.component;

import com.example.demo_mvp_2.di.module.OkManager;
import com.example.demo_mvp_2.mvp.module.RxPoretorImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = OkManager.class)
public interface OkComponent {

    //自定义方法
    void getSingleApiService(RxPoretorImpl impl);
}
