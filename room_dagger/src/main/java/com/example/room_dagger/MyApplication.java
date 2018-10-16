package com.example.room_dagger;

import android.app.Application;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.INSTANCE.initApplicationComponent(this);
        Injector.INSTANCE.getApplicationComponent().inject(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Injector.INSTANCE.releaseApplicationComponent();
    }
}
