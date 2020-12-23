package com.example.demo_mvp_2.mvp.module.api;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService<T> {

    @GET
    Observable<ResponseBody> requestGetData(@Url String url);

    @GET
    Observable<ResponseBody> requestGetData(@Url String url, @QueryMap HashMap<String, T> headers);

    @GET
    Observable<ResponseBody> requestGetData(@Url String url, @QueryMap Map<String, T> params);


    @GET
    Observable<ResponseBody> requestGetData(@Url String url, @QueryMap HashMap<String, T> headers, @QueryMap Map<String, T> params);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> requestPostData(@Url String url);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> requestPostData(@Url String url, @FieldMap HashMap<String, T> headers);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> requestPostData(@Url String url, @FieldMap Map<String, T> params);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> requestPostData(@Url String url, @FieldMap HashMap<String, T> headers, @FieldMap Map<String, T> params);


    @POST
    Observable<ResponseBody> requestPostData(@Url String url, @Body RequestBody body);

    @POST
    Observable<ResponseBody> requestPostData(@Url String url, @FieldMap Map<String, T> headers, @Body RequestBody body);

}
