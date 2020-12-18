package com.example.myapplication.mvp;

import com.example.myapplication.bean.GuanBean;
import com.example.myapplication.bean.ListBnea;
import com.example.myapplication.bean.ShiBean;
import com.example.myapplication.bean.WenBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServer {
    public static final String str="http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList")
    Observable<ListBnea> getTu(@Query ( "pageCount" ) int pageCount,@Query ( "feedType" ) String feedType);
    @GET("serverdemo/feeds/queryHotFeedsList")
    Observable<ShiBean> getShi(@Query ( "pageCount" ) int pageCount,@Query ( "feedType" ) String feedType);
    @GET("serverdemo/feeds/queryHotFeedsList")
    Observable<WenBean> getWen(@Query ( "pageCount" ) int pageCount,@Query ( "feedType" ) String feedType,@Query ( "feedId" ) int feedId);
    @GET("serverdemo//tag/queryTagList")
    Observable<GuanBean> getGuan();
}
