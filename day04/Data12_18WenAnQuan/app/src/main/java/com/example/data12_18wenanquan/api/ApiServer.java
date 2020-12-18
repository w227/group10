package com.example.data12_18wenanquan.api;

import com.example.data12_18wenanquan.bean.CommunityBean;
import com.example.data12_18wenanquan.bean.HotBean;
import com.example.data12_18wenanquan.bean.Hot_ActivityBean;
import com.example.data12_18wenanquan.bean.NavigationBean;
import com.example.data12_18wenanquan.bean.RodeBean;
import com.example.data12_18wenanquan.bean.RodeNearBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServer {
    String BASE_URL = "http://cdwan.cn:7000/tongpao/";

    @GET("discover/hot_activity.json")
    Observable<Hot_ActivityBean> getHotActivityBean();

    @GET("discover/navigation.json")
    Observable<NavigationBean> getFoundNavigationBean();

    @GET("discover/news_{type}.json")
    Observable<HotBean> getHotBean(@Path("type") String type);

    //    袍子---附近的袍子：/discover/robe_near.json
//      社团  ：/discover/association.json
//    排行榜--等级榜  /discover/rank_level.json
//    排行榜--签到榜 /discover/rank_sign.json
//    排行榜--土豪榜 /discover/rank_money.json
    @GET("discover/robe.json")
    Observable<RodeBean> getRodeBean();

    @GET("discover/robe_near.json")
    Observable<RodeNearBean> getRodeNearBean();

    @GET("discover/association.json")
    Observable<CommunityBean> getCommunityBean();
}
