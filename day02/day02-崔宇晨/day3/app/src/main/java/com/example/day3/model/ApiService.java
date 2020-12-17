package com.example.day3.model;

import com.example.day3.model.bean.DataInfo;
import com.example.day3.model.bean.DataInfo2;
import com.example.day3.model.bean.DataInfo3;
import com.example.day3.model.bean.DataInfo4;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    public static final String aulr="http://123.56.232.18:8080/";

    @GET("serverdemo/feeds/queryHotFeedsList")
    Observable<DataInfo> getData(@Query("pageCount")int pageCount,@Query("feedType")String feedType);

    @GET("serverdemo/feeds/queryHotFeedsList")
    Observable<DataInfo2> getData2(@Query("pageCount")int pageCount,@Query("feedType")String feedType);

    @GET("http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList")
    Observable<DataInfo3> getData3(@Query("pageCount")int pageCount,@Query("feedType")String feedType,@Query("feedId")int feedId);

    @GET("serverdemo//tag/queryTagList")
    Observable<DataInfo4> getData4();
}
