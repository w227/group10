package com.example.mvp.manager;


import com.example.mvp.base.BaseThreadPool;
import com.example.mvp.thread.CustomThreadPool;
import com.example.mvp.thread.SchduleThreadPool;
import com.example.mvp.thread.SingleThreadPool;

public class ThreadPoolManager {
    public static final int CUSTOM_THREADPOOL = 0;
    public static final int SINGLE_THREADPOOL = 1;
    public static final int SCHDULE_THREADPOOL = 2;

    public static BaseThreadPool getThreadPool(int type) {
        switch (type) {
            case CUSTOM_THREADPOOL:
                return CustomThreadPool.getThreadPool();
            case SINGLE_THREADPOOL:
                return SingleThreadPool.getSingleThreaPool();
            case SCHDULE_THREADPOOL:
                return SchduleThreadPool.getmSchduleThreadPool();
        }
        return null;
    }

}