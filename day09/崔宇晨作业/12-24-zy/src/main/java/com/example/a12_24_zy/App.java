package com.example.a12_24_zy;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        context=this;

    }

    public static Context context(){
        return context;
    }

    public static String getStr(int p){
        return App.context().getString(p);
    }
}
