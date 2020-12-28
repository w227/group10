package com.example.a12_28_dp_zy;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
@Module
//向外界提供对象
public class RetrofitManger {

    @Singleton
    @Provides
    public OkHttpClient.Builder proBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    public OkHttpClient proOkHttpClient() {
        return proBuilder().build();
    }

    @Singleton
    @Provides
    public Retrofit.Builder builder(){
        return new Retrofit.Builder();
    }

    @Provides
    public Retrofit retrofit(){
        return builder().baseUrl(ApiConstants.AURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    @Singleton
    @Provides
    public APiService proApiService(){
        return retrofit().create(APiService.class);
    }




}
