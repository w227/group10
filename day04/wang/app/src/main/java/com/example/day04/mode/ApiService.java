package com.example.day04.mode;

import com.example.day04.bean.QianBean;
import com.example.day04.bean.ShowBean;
import com.example.day04.bean.TuBean;
import com.example.day04.bean.YanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    public static final String GET_URL = "http://cdwan.cn:7000/tongpao/";


    @GET("discover/rank_level.json")
    Observable<YanBean> getYanData();

    @GET("discover/rank_money.json")
    Observable<TuBean> getTuData();

    @GET("discover/rank_sign.json")
    Observable<QianBean> getQianData();

    @GET("discover/association.json")
    Observable<ShowBean> getShowData();


}
