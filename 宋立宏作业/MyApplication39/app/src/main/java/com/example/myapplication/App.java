package com.example.myapplication;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.db.DaoMaster;
import com.example.myapplication.db.DaoSession;

public class App extends Application {

    private static  DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate ();
        initDB();
    }

    private void initDB() {
        DaoMaster.DevOpenHelper uuu = new DaoMaster.DevOpenHelper ( this, "uuu" );
        SQLiteDatabase writableDatabase = uuu.getWritableDatabase ();
        daoSession = new DaoMaster ( writableDatabase ).newSession ();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
