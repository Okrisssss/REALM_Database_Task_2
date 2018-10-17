package com.example.room_dagger;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.room_dagger.di.Injector;

import javax.inject.Inject;

public class MyApplication extends Application {

    public static final String TAG = "MyApplication";

    @Inject
    Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.INSTANCE.initApplicationComponent(this);
        Log.d(TAG, "applicationContext in MyApplication class is " + applicationContext);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Injector.INSTANCE.releaseApplicationComponent();
    }
}
