package com.example.room_dagger.di.components;

import com.example.room_dagger.di.modules.MainModule;
import com.example.room_dagger.di.scopes.ScopeMain;
import com.example.room_dagger.view.MainActivity;

import dagger.Component;

@ScopeMain
@Component(dependencies = ApplicationComponent.class, modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
