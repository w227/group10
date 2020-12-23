package com.example.a12_22_zy;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        context=this;
        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }

    public static Context context(){
        return context;
    }

    public static String getStr(int p){
        return App.context().getString(p);
    }
}
