package com.example.room_dagger.di.components;

import android.content.Context;

import com.example.room_dagger.MyApplication;
import com.example.room_dagger.di.modules.ApplicationModule;
import com.example.room_dagger.di.modules.RepositoryModule;
import com.example.room_dagger.repository.AppDatabase;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);

    Context context();

    AppDatabase appDataBase();

}
