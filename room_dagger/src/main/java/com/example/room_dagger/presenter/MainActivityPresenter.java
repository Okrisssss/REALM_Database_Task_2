package com.example.room_dagger.presenter;

import android.content.Context;

import com.example.room_dagger.model.Intern;
import com.example.room_dagger.repository.AppDatabase;
import com.example.room_dagger.view.DataView;

import java.util.List;

public class MainActivityPresenter  {


    Context context;
    AppDatabase appDatabase;
    DataView dataView;

    public MainActivityPresenter(Context context, AppDatabase appDatabase, DataView view) {
        this.context = context;
        this.appDatabase = appDatabase;
        this.dataView = view;
    }

    public void saveDataInRoom(Intern intern){
        appDatabase.getInternDao().insert(intern);
    }

    public void getAllUsers(List<Intern> interns){
    List<Intern> allInterns = appDatabase.getInternDao().getAll();
    dataView.onGetAllInternsSuccesfully(allInterns);
    }

    public void getUserByName(String internName){
        Intern internByName = appDatabase.getInternDao().getByName(internName);
        dataView.onInternGetSuccesfully(internByName);
    }
}
