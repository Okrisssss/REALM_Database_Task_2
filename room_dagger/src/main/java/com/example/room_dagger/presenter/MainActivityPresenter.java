package com.example.room_dagger.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.example.room_dagger.model.Intern;
import com.example.room_dagger.repository.AppDatabase;
import com.example.room_dagger.view.DataView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter {
    Context context;
    AppDatabase appDatabase;
    DataView dataView;

    public MainActivityPresenter(Context context, AppDatabase appDatabase) {
        this.context = context;
        this.appDatabase = appDatabase;
    }

    public void setDataView(DataView dataView) {
        this.dataView = dataView;
    }

    public void saveDataInRoom(Intern intern) {
        appDatabase.getInternDao().insert(intern);
    }

    @SuppressLint("CheckResult")
    public void getAllUsers() {
        appDatabase.getInternDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(interns -> {
                    dataView.onGetAllInternsSuccesfully(interns);
                }, throwable -> {
                    Log.d("TAG", "Error");
                });
    }

    public void getUserByName(String internName) {
        Intern internByName = appDatabase.getInternDao().getByName(internName);
        dataView.onInternGetSuccesfully(internByName);
    }
}
