package com.example.day09.mvp.model;

import com.example.day09.callback.RxObserverCallBack;

import com.example.day09.di.component.DaggerOkComponent;
import com.example.day09.mvp.model.api.ApiService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;


/**
 * 封装的网络请求操作类
 */
public class RxOpretorImpl {
    @Inject
    ApiService mApiService;

    public RxOpretorImpl() {


        DaggerOkComponent.create().
                getSingleApiService(this);
    }


    //没有参数也没有请求头的get请求
    public <T> void rxGetRequest(String url, RxObserverCallBack<T> callBack) {
        RxOperator.threadtransformer(mApiService.requestGetData(url)).
                subscribe(new RxObserver(callBack));
    }


    //有参数没有请求头的get请求
    public <T> void rxGetRequest(String url, Map<String,String> params,
                                 RxObserverCallBack<T> callBack) {
        if (params != null && params.size() > 0) { //有参数的请求
            RxOperator.threadtransformer(mApiService.requestGetData(url, params)).
                    subscribe(new RxObserver(callBack));
        } else {  //没有参数的请求
            rxGetRequest(url, callBack);
        }
    }


    //有请求头但是没有参数的get请求
    public <T> void rxGetRequest(String url, HashMap<String, String> headers,
                                 RxObserverCallBack<T> callBack) {
        if (headers != null && headers.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestGetData(url, headers)).
                    subscribe(new RxObserver(callBack));
        } else {
            rxGetRequest(url, callBack);
        }
    }


    //既有请求头也有请求参数的get请求
    public <T> void rxGetRequest(String url, HashMap<String, String> headers,
                                 Map<String, String> params, RxObserverCallBack callBack) {
        //既有请求头也有请求参数的get请求
        if (headers != null && headers.size() > 0 && params != null && params.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestGetData(url, headers, params)).
                    subscribe(new RxObserver(callBack));
            //只有请求头没有请求参数的get请求
        } else if (headers != null && headers.size() > 0 && (params == null || params.size() == 0)) {
            rxGetRequest(url, headers, callBack);
            //只有参数但是没有请求头的get请求
        } else if (params != null && params.size() > 0 && (headers == null || headers.size() == 0)) {
            rxGetRequest(url, params, callBack);
        } else {
            //既没有请求头也没有请求参数的get请求
            rxGetRequest(url, callBack);
        }
    }




    //没有参数也没有请求头的post请求
    public <T> void rxPostRequest(String decode, HashMap<String, String> url, RxObserverCallBack<T> callBack) {
        RxOperator.threadtransformer(mApiService.requestPostData(url)).
                subscribe(new RxObserver(callBack));
    }


    //    有参没有请求头的 post
    public <T> void repostRequest(String url, Map<String, String> map, RxObserverCallBack<T> call) {
        if (map != null && map.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestPostData(url, map))
                    .subscribe(new RxObserver(call));
        } else {
           repostRequest(url,map,call);
        }
    }

//    有头没参的 post

    public <T> void repostRequest(String url, HashMap<String,String> headres, RxObserverCallBack<T> call) {
        if (headres != null && headres.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestPostData(url, headres))
                    .subscribe(new RxObserver(call));
        } else {
            repostRequest(url, headres, call);
        }
    }


}