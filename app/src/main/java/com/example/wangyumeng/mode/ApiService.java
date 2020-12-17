package com.example.wangyumeng.mode;

import com.example.wangyumeng.bean.JavaBean;
import com.example.wangyumeng.bean.ShiBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

//    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics
//   http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video

    public static final String GET_URL = "http://123.56.232.18:8080/serverdemo/";

    @GET("feeds/queryHotFeedsList")
    Observable<JavaBean> getData(@Query("pageCount") int pageCount,
                                 @Query("feedType") String pics);

     @GET("feeds/queryHotFeedsList")
    Observable<ShiBean> getShiData(@Query("pageCount") int pageCount,
                                @Query("feedType") String video);



}
