package com.example.orm_lite_db;

import android.app.Application;

import com.example.orm_lite_db.database.HelpFactory;

public class MyAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HelpFactory.setHelper(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        HelpFactory.releaseHelper();
        super.onTerminate();
    }
}
