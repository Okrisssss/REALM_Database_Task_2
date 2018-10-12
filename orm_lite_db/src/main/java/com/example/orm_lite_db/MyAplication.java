package com.example.orm_lite_db;

import android.app.Application;

import com.example.orm_lite_db.model.HelperFactory;

public class MyAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HelperFactory.setHelper(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        HelperFactory.releaseHelper();
        super.onTerminate();
    }
}
