package com.example.xsx_zy_qunti_3.mvp.model;

import android.util.Log;

import com.example.xsx_zy_qunti_3.ApiService;
import com.example.xsx_zy_qunti_3.bean.HotBean;
import com.example.xsx_zy_qunti_3.bean.TuanBean;
import com.example.xsx_zy_qunti_3.callback.ResultCallBack;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FindModel {
    private static final String TAG = "FindModel";
    public void getData(final ResultCallBack callBack) {
        new Retrofit.Builder().baseUrl(ApiService.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                build().create(ApiService.class).getHotData().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        if(callBack != null){
                            callBack.getSuccessData(hotBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callBack != null){
                            callBack.getFaileMeg(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    public void getTuanData(final ResultCallBack callBack) {
        new Retrofit.Builder().baseUrl(ApiService.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                build().create(ApiService.class).getTuanData().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<TuanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuanBean tuanBean) {
                        Log.e(TAG, "onNext: "+"======" );
                        if(callBack != null){
                            callBack.getSuccessData(tuanBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callBack != null){
                            callBack.getFaileMeg(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
