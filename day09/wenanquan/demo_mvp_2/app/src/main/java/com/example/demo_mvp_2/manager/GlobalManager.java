package com.example.demo_mvp_2.manager;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.demo_mvp_2.base.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GlobalManager {

    private volatile static GlobalManager mManager;
    private static Map<String, Object> mMap;
    private static Set<Activity> mSet;
    private static SharedPreferences mSp;

    private GlobalManager() {
        if (mMap == null) {
            mMap = new HashMap<>();
        }
        if (mSet == null) {
            mSet = new HashSet<>();
        }
        if (mSp == null) {
            mSp = App.getContent().getSharedPreferences("config", App.MODE_PRIVATE);
        }
    }

    public synchronized static GlobalManager getManager() {
        if (mManager == null) {
            synchronized (GlobalManager.class) {
                if (mManager == null) {
                    mManager = new GlobalManager();
                }
            }
        }
        return mManager;
    }

    public void save_str(String key,String value){
        mSp.edit().putString(key, value);
    }
    public String get_str(String key){
       return mSp.getString(key,"");
    }
    public void save_Boolean(String key,boolean value){
        mSp.edit().putBoolean(key, value);
    }
    public boolean get_Boolean(String key){
        return mSp.getBoolean(key,false);
    }


    public void addActivity(Activity activity) {
        if (activity != null) {
            mSet.add(activity);
        }
    }

    public void clearActivity() {
        for (Activity activity : mSet) {
            if (activity != null) {
                activity.finish();
                System.exit(0);
            }
        }
    }

    public void putObj(String key, Object value) {
        mMap.put(key, value);
    }

    public Object getObj(String key) {
        return mMap.get(key);
    }

}
