package com.example.map.manager;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.map.base.App;

import java.util.HashMap;
import java.util.HashSet;

/*
    TODO   功能类
 * 此类用来放共同的属性如：
 *
 *       1.定义hashMap的传值  put 和 get 方法
 *       2.定义    一个集合存储所有需要添加的 集合的Activity  有两种 添加 和 清除
 *       3. 全局的SP 整个程序 都可以用 其中有 getString  getBoolean
 *
 * */
public class ContainManager {

    private volatile static ContainManager globaiManager;

    private static HashMap<String, Object> map;
    private static HashSet<Activity> set;
    private static SharedPreferences user;


    private ContainManager() {
//    两个类之间 传值

        if (map == null)
            map = new HashMap<>();

        if (set == null)
            set = new HashSet<>();

        if (user == null)
            user = App.context().getSharedPreferences("user",
                    App.MODE_PRIVATE);


    }



    public void save_str(String key, String value) {
        user.edit().putString(key, value).commit();
    }

    public String get_str(String key) {
        return user.getString(key, "");
    }

    public void save_boolean(String key, boolean value) {
        user.edit().putBoolean(key,value);
    }

    public boolean get_boolean(String key) {
        return user.getBoolean(key,false);
    }


    public void addActivity(Activity activity) {
        set.add(activity);
    }

    public void clearActivity() {
        for (Activity activity : set) {
            activity.finish();
            System.exit(0);
        }
    }

    public void putObj(String key, Object o) {
        map.put(key, o);
    }

    public Object getObj(String key) {
        Object o = map.get(key);
        return o;

    }

    public synchronized static ContainManager manager() {
        if (globaiManager == null)
            synchronized (ContainManager.class) {
                if (globaiManager == null)
                    globaiManager = new ContainManager();
            }
        return globaiManager;
    }


}
