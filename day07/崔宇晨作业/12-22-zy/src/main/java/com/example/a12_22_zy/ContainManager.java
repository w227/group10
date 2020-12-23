package com.example.a12_22_zy;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.HashSet;

public class ContainManager {

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
}
