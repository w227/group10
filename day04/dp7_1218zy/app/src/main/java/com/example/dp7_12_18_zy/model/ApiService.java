package com.example.dp7_12_18_zy.model;

import com.example.dp7_12_18_zy.model.bean.DataInfo;
import com.example.dp7_12_18_zy.model.bean.DataInfo2;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    public static final String aurl="http://cdwan.cn:7000/";

    @GET("tongpao/discover/hot_activity.json")
    Observable<DataInfo> getData();

    @GET("tongpao/discover/association.json")
    Observable<DataInfo2> getData2();
}
