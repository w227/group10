package com.example.demo_mvp_2.base;

import android.app.Application;

public class App extends Application {

    private static App mContent;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    public static String getStr(int p) {
        return mContent.getString(p);
    }

    private void init() {
        mContent = this;
    }

    public static App getContent() {
        return mContent;
    }
}
