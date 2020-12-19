package com.example.xsx_zy_qunti_3;

import com.example.xsx_zy_qunti_3.bean.HotBean;
import com.example.xsx_zy_qunti_3.bean.TuanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    public static final String BASE_URL = "http://cdwan.cn:7000/";

    @GET("tongpao/discover/hot_activity.json")
    Observable<HotBean> getHotData();

    @GET("tongpao/discover/association.json")
    Observable<TuanBean> getTuanData();
}
