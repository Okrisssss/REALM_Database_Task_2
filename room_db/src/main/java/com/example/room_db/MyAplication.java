package com.example.room_db;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.room_db.database.AppDatabase;


public class MyAplication extends Application {
public static MyAplication instance;
private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "mydatabase").allowMainThreadQueries().build();
    }
    public static MyAplication getInstance(){
        return instance;
    }

    public AppDatabase getAppDatabase(){
        return appDatabase;
    }
}
