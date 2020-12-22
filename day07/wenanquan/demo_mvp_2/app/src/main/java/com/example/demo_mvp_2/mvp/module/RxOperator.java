package com.example.demo_mvp_2.mvp.module;

import android.util.Log;

import com.example.demo_mvp_2.callback.RxObservableCallBack;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxOperator {
    private static final String TAG = RxOperator.class.getSimpleName();

    public static Observable threadTransFormer(Observable observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static ObservableSource conpatMap(Observable registerObservable, Observable loginObservable, RxObservableCallBack callBack) {
        return threadTransFormer(registerObservable)
                .doOnNext(obj -> {
                    callBack.onSucceed(obj);
                })
                .observeOn(Schedulers.io())
                .concatMap(obj -> {
                    return loginObservable;
                });
    }

}
