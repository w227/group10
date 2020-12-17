package com.example.wangyumeng.mode;

import com.example.wangyumeng.bean.JavaBean;
import com.example.wangyumeng.bean.ShiBean;
import com.example.wangyumeng.call.CallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeMode {
    public void request(CallBack callBack) {
        ApiService apiService = new Retrofit.Builder()
                .baseUrl(ApiService.GET_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
                apiService.getData(2,"pics")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JavaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JavaBean value) {

                        if (callBack != null)
                            callBack.onNextData(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack != null)
                            callBack.onErrorData(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });




    }

    public void shiRequest(CallBack callBack) {

        new Retrofit.Builder()
                .baseUrl(ApiService.GET_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
               .create(ApiService.class)
                .getShiData(12,"video")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShiBean value) {

                        if (callBack != null)
                            callBack.onNextData(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack != null)
                            callBack.onErrorData(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
