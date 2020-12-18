package com.example.dp7_12_18_zy.model;

import android.util.Log;

import com.example.dp7_12_18_zy.R;
import com.example.dp7_12_18_zy.calback.Cll;
import com.example.dp7_12_18_zy.model.bean.DataInfo;
import com.example.dp7_12_18_zy.model.bean.DataInfo2;

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
                .baseUrl(ApiService.aurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData()
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
                            Log.e("ii","dataInfo 请求成功");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (cll!=null){
                            cll.onFaile(e.getMessage());
                            Log.e("ii","dataInfo 请求失败");
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
                .baseUrl(ApiService.aurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class)
                .getData2()
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
                            Log.e("ii","dataInfo2 请求成功");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (cll!=null){
                            cll.onSucess(e.getMessage());
                            Log.e("ii","dataInfo2 请求失败"+e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.e("ii","方法结束");
                    }
                });
    }
}
