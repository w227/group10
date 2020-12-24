package com.example.demo_mvp_2.di.module;

import com.example.demo_mvp_2.mvp.module.api.ApiService;
import com.example.demo_mvp_2.mvp.module.constants.ApiConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Module
public class OkManager {


    @Singleton
    @Provides
    public OkHttpClient.Builder proOkBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    public OkHttpClient proOkHttp() {
        return proOkBuilder().build();
    }

    @Singleton
    @Provides
    public Retrofit.Builder proRetroBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    public Retrofit proRetrofit() {
        return proRetroBuilder()
                .baseUrl(ApiConstants.DEBUG_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public ApiService proApiService() {
        return proRetrofit().create(ApiService.class);
    }

}
