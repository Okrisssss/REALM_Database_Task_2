package apple.example.com.realm_database_task_2;

import android.app.Application;

import apple.example.com.realm_database_task_2.database.RealmController;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    Realm realm;
    final static String REALM_NAME = "InternDB";

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name(REALM_NAME).build();
        Realm.setDefaultConfiguration(config);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        realm.close();

    }
}

