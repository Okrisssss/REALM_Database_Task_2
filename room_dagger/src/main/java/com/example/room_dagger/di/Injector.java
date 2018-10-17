package com.example.room_dagger.di;

import com.example.room_dagger.MyApplication;
import com.example.room_dagger.di.components.ApplicationComponent;
import com.example.room_dagger.di.components.DaggerApplicationComponent;
import com.example.room_dagger.di.components.DaggerMainComponent;
import com.example.room_dagger.di.components.MainComponent;
import com.example.room_dagger.di.modules.ApplicationModule;
import com.example.room_dagger.di.modules.MainModule;
import com.example.room_dagger.di.modules.RepositoryModule;
import com.example.room_dagger.view.MainActivity;

public enum Injector {
    INSTANCE;
    ApplicationComponent applicationComponent;
    MainComponent mainComponent;

    Injector() {
    }

    public void initApplicationComponent(MyApplication myApplication) {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(myApplication))
                    .repositoryModule(new RepositoryModule())
                    .build();
        }
    }

    public void initMainComponent(MainActivity mainActivity) {
        if (mainComponent == null) {
            mainComponent = DaggerMainComponent.builder()
                    .mainModule(new MainModule(mainActivity))
                    .applicationComponent(applicationComponent)
                    .build();
        }
        mainComponent.inject(mainActivity);
    }


    public void releaseApplicationComponent() {
        applicationComponent = null;
    }

    public void releaseMainComponent() {
        mainComponent = null;
    }
}
