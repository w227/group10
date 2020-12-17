package com.example.day3.model;

import android.util.Log;

import com.example.day3.callback.Cll;
import com.example.day3.model.bean.DataInfo;
import com.example.day3.model.bean.DataInfo2;
import com.example.day3.model.bean.DataInfo3;
import com.example.day3.model.bean.DataInfo4;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {
    public void request(final Cll cll) {
        new Retrofit.Builder()
                .baseUrl(ApiService.aulr)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class)
                .getData(12,"pics")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataInfo dataInfo) {
                        if (cll!=null){
                            cll.onSucess(dataInfo);
                            Log.e("ii","datainfo 请求成功");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (cll!=null){
                            cll.onFaile(e.getMessage());
                            Log.e("ii","daainfo 请求失败"+e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.e("ii","方法结束");
                    }
                });

    }

    public void request2(final Cll cll) {
        new Retrofit.Builder()
                .baseUrl(ApiService.aulr)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class)
                .getData2(12,"video")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataInfo2>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataInfo2 dataInfo2) {
                        if (cll!=null){
                            cll.onSucess(dataInfo2);
                            Log.e("ii","datainfo2 请求成功");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (cll!=null){
                            cll.onFaile(e.getMessage());
                            Log.e("ii","datainfo2 请求失败"+e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.e("ii","方法结束");
                    }
                });
    }

    public void request3(Cll cll) {
        new Retrofit.Builder()
                .baseUrl(ApiService.aulr)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData3(10,"text",1578920275)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataInfo3>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataInfo3 dataInfo3) {
                        if (cll!=null){
                            cll.onSucess(dataInfo3);
                            Log.e("ii","datainfo3 请求成功");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (cll!=null){
                            cll.onFaile(e.getMessage());
                            Log.e("ii","请求失败"+e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.e("ii","datainfo3 方法结束");
                    }
                });
    }

    public void request4(Cll cll) {
        new Retrofit.Builder()
                .baseUrl(ApiService.aulr)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData4()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataInfo4>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataInfo4 dataInfo4) {
                        if (cll!=null){
                            cll.onSucess(dataInfo4);
                            Log.e("ii","datainfo4 请求成功");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (cll!=null){
                            cll.onFaile(e.getMessage());
                            Log.e("ii","datainfo4 请求失败"+e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.e("ii","方法结束");
                    }
                });
    }
}
