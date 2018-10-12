package com.example.orm_lite_db_2;

import android.app.Application;

import com.example.orm_lite_db_2.model.DatabaseManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.setHelper(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        DatabaseManager.releaseHelper();
        super.onTerminate();
    }
}
