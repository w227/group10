package com.example.a12_22_zy;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.HashSet;

public class ContainManager {

    private volatile static ContainManager mManager;
    private  SharedPreferences mSp;
    private  HashSet<Activity> mSet;

    public ContainManager() {
        if (mSet==null){
            mSet = new HashSet<>();
        }
        if (mSp==null){
            mSp = App.context().getSharedPreferences("data",App.MODE_PRIVATE);
        }

    }

    public void save_boolean(String key,Boolean value){
        mSp.edit().putBoolean(key,value).commit();
    }

    public boolean get_boolean(String key){
        return mSp.getBoolean(key,false);
    }

    public void addActivity(Activity activity) {
        mSet.add(activity);
    }


    public void clearActivity() {
        for (Activity activity : mSet) {
            if (activity != null) {
                activity.finish();
                System.exit(0);
            }
        }
    }

    public static synchronized ContainManager getmManager() {
        if (mManager == null) {
            synchronized (ContainManager.class) {
                if (mManager == null) {
                    mManager = new ContainManager();
                }
            }

        }
        return mManager;
    }
}
