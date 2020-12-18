package com.example.myapplication.mvp;

import com.example.myapplication.bean.JingBean;
import com.example.myapplication.bean.ListBean;
import com.example.myapplication.bean.TuBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    public static final String str="http://cdwan.cn:7000/";
    @GET("tongpao//discover/robe.json")
    Observable<ListBean> getQao();
    @GET("tongpao/discover/rank_level.json")
    Observable<JingBean> getJing();
    @GET("tongpao/discover/rank_money.json")
    Observable<TuBean> getTu();


}
