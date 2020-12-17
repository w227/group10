package com.example.data12_17homework.api;

import com.example.data12_17homework.bean.CollectionBean;
import com.example.data12_17homework.bean.ImageBean;
import com.example.data12_17homework.bean.TextBean;
import com.example.data12_17homework.bean.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String BASE_URL = "http://123.56.232.18:8080/serverdemo/";

    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<ImageBean> getImageBean();

    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<VideoBean> getVideoBean();

    @GET("feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<TextBean> getTextBean();

    @GET("tag/queryTagList")
    Observable<CollectionBean> getCollectionBean();
//    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics  沙发—图片
//    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video 沙发—视频
//    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275沙发— 文本
//    http://123.56.232.18:8080/serverdemo//tag/queryTagList          发现—推荐
}
