package com.example.a12_28_dp_zy;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APiService {
    @GET()
    Observable<ResponseBody> getData(@Url String aulr);
}
