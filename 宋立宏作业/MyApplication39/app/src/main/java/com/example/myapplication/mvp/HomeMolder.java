package com.example.myapplication.mvp;

import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.myapplication.bean.GuanBean;
import com.example.myapplication.bean.ListBnea;
import com.example.myapplication.bean.ShiBean;
import com.example.myapplication.bean.WenBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeMolder {
    public void requset1(final HomeCall homeCall) {
        new Retrofit.Builder ()
                .baseUrl ( ApiServer.str )
                .addConverterFactory ( GsonConverterFactory.create () )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .build ()
                .create ( ApiServer.class )
                .getTu ( 12,"pics" )
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<ListBnea> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListBnea listBnea) {
                        List<ListBnea.DataBeanX.DataBean> data = listBnea.getData ().getData ();
                        Log.e ("111",data.size ()+"");

                        if (homeCall!=null){
                            homeCall.getData1 ( data );
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e ("111",e.getMessage ());

                    }

                    @Override
                    public void onComplete() {

                    }
                } );

    }

    public void requset2(final HomeCall homeCall) {
        new Retrofit.Builder ()
                .baseUrl ( ApiServer.str )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ()
                .create ( ApiServer.class )
                .getShi ( 12,"video" )
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<ShiBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShiBean shiBean) {
                        List<ShiBean.DataBeanX.DataBean> data = shiBean.getData ().getData ();
                        if (homeCall!=null){
                            homeCall.getData2 ( data );
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                } );
    }

    public void requset3(HomeCall homeCall) {
        new Retrofit.Builder ()
                .baseUrl ( ApiServer.str )
                .addConverterFactory ( GsonConverterFactory.create () )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .build ()
                .create ( ApiServer.class )
                .getWen ( 10,"text",1578920275 )
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<WenBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WenBean wenBean) {
                        List<WenBean.DataBeanX.DataBean> data = wenBean.getData ().getData ();
                        if (homeCall!=null){
                            homeCall.getData3 ( data );
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                } );
    }

    public void requset4(HomeCall homeCall) {
        new Retrofit.Builder ()
                .baseUrl ( ApiServer.str )
                .addConverterFactory ( GsonConverterFactory.create () )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .build ()
                .create ( ApiServer.class )
                .getGuan ()
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<GuanBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuanBean guanBean) {
                        List<GuanBean.DataBeanX.DataBean> data = guanBean.getData ().getData ();
                        if (homeCall!=null){
                            homeCall.getData4 ( data );
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                } );

    }
}
