package com.example.room_dagger.di.modules;

import  android.arch.persistence.room.Room;
import android.content.Context;

import com.example.room_dagger.repository.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class RepositoryModule {
    public static final String DATA_BASE_NAME = "myDataBase";

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DATA_BASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

}
