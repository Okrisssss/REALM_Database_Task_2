package com.example.room_dagger.di.modules;

import android.content.Context;

import com.example.room_dagger.di.scopes.ScopeMain;
import com.example.room_dagger.presenter.MainActivityPresenter;
import com.example.room_dagger.repository.AppDatabase;
import com.example.room_dagger.view.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ScopeMain
    public MainActivityPresenter provideScreenNavigation(Context context, AppDatabase appDatabase) {
        return new MainActivityPresenter(context, appDatabase);
    }
}
