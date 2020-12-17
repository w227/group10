package com.example.day3;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.day3.db.DaoMaster;
import com.example.day3.db.DaoSession;

public class App extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper preson = new DaoMaster.DevOpenHelper(this, "preson");
        SQLiteDatabase writableDatabase = preson.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
