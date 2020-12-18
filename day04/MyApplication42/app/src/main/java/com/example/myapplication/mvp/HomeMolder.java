package com.example.myapplication.mvp;

import android.util.Log;

import com.example.myapplication.bean.JingBean;
import com.example.myapplication.bean.ListBean;
import com.example.myapplication.bean.TuBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeMolder {
    public void requset1(final HomeColl homeColl) {
        new Retrofit.Builder ()
                .baseUrl ( ApiServer.str )
                .addConverterFactory ( GsonConverterFactory.create () )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .build ()
                .create ( ApiServer.class )
                .getQao ()
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<ListBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListBean listBean) {
                        List<ListBean.DataBean> data = listBean.getData ();
                        if (homeColl!=null){
                            homeColl.getData1 ( data );
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

    public void requset2(final HomeColl homeColl) {
        new Retrofit.Builder ().baseUrl ( ApiServer.str )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ()
                .create ( ApiServer.class )
                .getJing ()
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<JingBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e ( "111","到了" );

                    }

                    @Override
                    public void onNext(JingBean jingBean) {
                        List<JingBean.DataBean.ExpTopBean.ListBean> list = jingBean.getData ().getExpTop ().getList ();
                        if (homeColl!=null){
                            homeColl.getData2 ( list );
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

    public void requset3(final HomeColl homeColl) {
        new Retrofit.Builder ()
                .baseUrl ( ApiServer.str )
                .addConverterFactory ( GsonConverterFactory.create () )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .build ()
                .create ( ApiServer.class )
                .getJing ()
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<JingBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JingBean jingBean) {
                        List<JingBean.DataBean.ExpTopBean.ListBean> list = jingBean.getData ().getExpTop ().getList ();
                        if (homeColl!=null){
                            homeColl.getData3 ( list );
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

    public void requset4(final HomeColl homeColl) {
        new Retrofit.Builder ()
                .baseUrl ( ApiServer.str )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ()
                .create ( ApiServer.class )
                .getTu ()
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<TuBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(TuBean tuBean) {
                        List<TuBean.DataBean.TongQianTopBean.ListBean> list = tuBean.getData ().getTongQianTop ().getList ();
                        if (homeColl!=null){
                            homeColl.getData4 ( list );
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
