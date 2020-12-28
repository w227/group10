package com.example.a12_28_dp_zy;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static Context mcontext;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mcontext=this;
    }

    public static Context context(){
        return mcontext;
    }

    public static String getStr(int p){
        return App.context().getString(p);
    }
}
