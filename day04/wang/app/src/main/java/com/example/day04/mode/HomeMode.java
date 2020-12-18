package com.example.day04.mode;

import com.example.day04.bean.QianBean;
import com.example.day04.bean.ShowBean;
import com.example.day04.bean.TuBean;
import com.example.day04.bean.YanBean;
import com.example.day04.call.CallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeMode {
    public void request(CallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.GET_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getYanData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<YanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(YanBean value) {

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

    public void turequest(CallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.GET_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getTuData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuBean value) {

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

    public void Qianrequest(CallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.GET_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getQianData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QianBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(QianBean value) {

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

    public void showData(final CallBack callBack) {

        new Retrofit.Builder()
                .baseUrl(ApiService.GET_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getShowData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShowBean value) {
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
