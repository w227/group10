package com.example.day09.base;

import com.google.gson.Gson;

public class GsonUtil {
    private static Gson mGson = null;

    static {

        mGson = new Gson();
    }
    public static <T> T jsonBean(String jsonStr , Class<T>  clazz){

        return mGson.fromJson(jsonStr, clazz);

    }
}
