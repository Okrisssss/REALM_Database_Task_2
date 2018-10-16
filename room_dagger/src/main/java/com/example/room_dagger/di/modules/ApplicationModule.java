package com.example.room_dagger.di.modules;

import android.content.Context;

import com.example.room_dagger.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private MyApplication myApplication;

    public ApplicationModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }
    @Provides
    @Singleton
    public Context provideApplicationContext(){
        return myApplication.getApplicationContext();
    }
}
